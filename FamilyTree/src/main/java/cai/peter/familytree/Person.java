package cai.peter.familytree;

import java.util.List;

public class Person {

	String name;
	Relationship relation;
	Person father;
	Person mother;
	Person spouse;
	List<Person> children;
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
}
