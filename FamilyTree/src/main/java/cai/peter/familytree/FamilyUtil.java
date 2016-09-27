package cai.peter.familytree;

import java.util.List;

public class FamilyUtil
{

	static void traverse(Person person, final Person origin, final int generation)
	{
	    if( person == null ) return;

	    /*
	     * children first
	     */
	    processChildren(person, origin, generation+1);


	    processSpouse(person, origin, generation);
	    processFather(person, origin, generation-1);
	    processMother(person, origin, generation-1);

	}

	private static void processMother(Person person, final Person origin, final int generation) {
	    Person mother = person.getMother();
	    if( mother!=null) {
	    	if (!mother.isVisited()) {
	    		switch(generation)
	    		{
	    		case -1:
	    			mother.setRelation(person.getRelation()==Relationship.OTHER?Relationship.OTHER:Relationship.MOTHER);
	    			break;
	    		case -2:
	    			mother.setRelation((person.getRelation()==Relationship.OTHER?Relationship.OTHER:Relationship.GRANDPARENT));
	    			break;
	    		default:
	    			mother.setRelation((Relationship.OTHER));
	    			break;
	    		}
	    	}

	    	traverse(mother, origin, generation);
	    }
	}

	private static void processFather(Person person, final Person origin, final int generation) {
	    Person father = person.getFather();
	    if( father != null) {
	    	if (!father.isVisited()) {
	    		switch(generation)
	    		{
	    		case 0:
	    			father.setRelation(person.getRelation()==Relationship.OTHER?Relationship.OTHER: Relationship.SPOUSE);
	    			break;
	    		case -1:
	    			father.setRelation(person.getRelation()==Relationship.OTHER?Relationship.OTHER: Relationship.FATHER);
	    			break;
	    		case -2:
	    			father.setRelation(person.getRelation()==Relationship.OTHER?Relationship.OTHER:Relationship.GRANDPARENT);
	    			break;
	    		default:
	    			father.setRelation(Relationship.OTHER);
	    			break;
	    		}
	    	}
	    	traverse(father, origin, generation);
	    }
	}

	private static void processSpouse(Person person, final Person origin, final int generation) {
	    Person spouse = person.getSpouse();
	    if( spouse != null)
		{
			if (!spouse.isVisited())
			{
				/*
				 * Add to graph
				 */
				switch(generation)
				{
				case 0:
					spouse.setRelation(Relationship.SPOUSE);
					break;
				case -1:
					if( spouse.equals(origin.getFather()))
						spouse.setRelation(Relationship.FATHER);
					else if( spouse.equals(origin.getMother()) )
						spouse.setRelation(Relationship.MOTHER);
					else
						spouse.setRelation(Relationship.OTHER);
					break;
				case -2:
					spouse.setRelation(person.getRelation()==Relationship.OTHER?Relationship.OTHER:Relationship.GRANDPARENT);
					break;
				default:
					spouse.setRelation(Relationship.OTHER);
					break;
				}
				traverse(spouse, origin, generation);
			}
		}
	}

	private static void processChildren(Person person, final Person origin, final int generation) {
	    List<Person> children = person.getChildren();// the generation
	    if( children != null ) {
		for( Person child : children)// the generation
		{
		    if( !child.isVisited())
		    {

		    	switch(generation)
		    	{
		    	case 0:
		    		child.setRelation(person.getRelation()==Relationship.OTHER?Relationship.OTHER: Relationship.SIBLING);
		    		break;
		    	case 1:
		    		child.setRelation(Relationship.CHILD);
		    		break;
		    	default:
		    		child.setRelation(Relationship.OTHER);
		    		break;
		    	}
		    	/*
		    	 *
		    	 */
		    	traverse(child, origin, generation);
		    }
		}
	    }
	}
}
