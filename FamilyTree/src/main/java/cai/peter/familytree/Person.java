package cai.peter.familytree;

import org.apache.log4j.Logger;

import java.util.List;

public class Person {
    /**
    * Logger for this class
    */
    private static final Logger logger = Logger.getLogger(Person.class);

    	/*
    	 * to simplify the code, name required to be unique in the family tree
    	 */
	private String name;
	private Relationship relation;
	private Person father;
	private Person mother;
	private Person spouse;
	private List<Person> children;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Person getFather()
	{
		return father;
	}
	public void setFather(Person father)
	{
		this.father = father;
	}
	public Person getMother()
	{
		return mother;
	}
	public void setMother(Person mother)
	{
		this.mother = mother;
	}
	public Person getSpouse()
	{
		return spouse;
	}
	public void setSpouse(Person spouse)
	{
		this.spouse = spouse;
	}
	public List<Person> getChildren()
	{
		return children;
	}
	public void setChildren(List<Person> children)
	{
		this.children = children;
	}

	public boolean isSibling(Person p)
	{
	    /*
	     * either mother or father is same
	     */
	    return (this.getFather().equals(p.getFather())) || this.getMother().equals(p.getMother());
	}


	public boolean equals(Person o) {
	    if (this == o) {
		return true;
	    }
	    if (o == null) {
		return false;
	    }
	    /*
	     * name is unique ID
	     */
	    return this.name.equals(o.name);
	}

	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(name);
	    sb.append("(");
	    sb.append(relation);
	    sb.append(")");
	    return sb.toString();
	}

	public boolean isVisited()
	{
	    return relation!=null;
	}

	public boolean isParent(Person p)
	{
	    return this.father.equals(p) || this.mother.equals(p);
	}
	public void getFamilyTree()
	{
	    this.relation = Relationship.ME;
	    FamilyUtil.traverse(this, this, 0);

	}
	public Relationship getRelation() {
	    return relation;
	}
	public void setRelation(Relationship relation) {
	    this.relation = relation;
		logger.info("Person person=" + this);
	}

}
