/**
 * 
 */
package org.srinivas.javareflection;

/**
 * @author Srinivas Kummari
 *
 */
public class Employee extends Person{

	private String profession;
	private double salary;
	public Employee(String name, int age,String profession,double salary) {
		super(name, age);
		this.profession=profession;
		this.salary=salary;
		
	}

}
