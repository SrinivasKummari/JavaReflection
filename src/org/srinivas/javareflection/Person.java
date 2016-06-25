/**
 * 
 */
package org.srinivas.javareflection;

/**
 * @author Srinivas Kummari
 *
 */
public class Person {

	protected String name;
	public int age;
	
	private static int numOfPersons=1;
	
	public static int getnumOfPersons(){
		return numOfPersons;
	}
	public Person(String name ,int age ) {
		this.name=name;
		this.age=age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/*@Override
	public String toString() {
		return "Person name is:"+name+" and age is: "+age;
	}*/
	
}
