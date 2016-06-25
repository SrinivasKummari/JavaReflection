/**
 * 
 */
package org.srinivas.javareflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Srinivas Kummari
 *
 */
public class ReflectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		If the instance variables of the class are inherited then for
		 getDeclaredField we have to use getField() and for
		 getDeclaredMethod we have to use getMethod()*/
		
		//creating a logger instance to print in the console
		Logger logger=LoggerFactory.getLogger(ReflectionTest.class);
		
		//Creating a person instance with parameterized constructor
		Person person=new Person("Srinivas", 26);
		//trying to access the instance variable of the class whose access modifier is private
		//logger.info(person.name);
		
		//Now lets access the same instance variable using reflection concept
		/*Another thing that needs to keep in mind that reflection has to implement in
		 * try block as there is a possibility to throw an error*/
		try {
			Field field=person.getClass().getDeclaredField("name");
			//This is where we are changing the behavior of the attribute so that we can access it 
			field.setAccessible(true);
			logger.info("Person Name: "+field.get(person).toString());
			
			//repeating the same steps for another instance variable
			Field f1=person.getClass().getDeclaredField("age");
			f1.setAccessible(true);
			logger.info("Person age is: "+f1.get(person));
			
			//creating an instance for child class
			Employee emp=new Employee("Sri", 27, "software developer", 70000.00);
			
			//As name attribute exist in super class in order to access it we are now using getField instead getDeclaredField method
			Field empAge=emp.getClass().getField("age");
			empAge.setAccessible(true);
			logger.info("Employee Name: "+empAge.get(emp));
			
			//accessing a method in regular way
			logger.info(person.getName());
			//Accessing a no argument method using reflection
			Method getNameMethod=person.getClass().getDeclaredMethod("getName");
			logger.info("Person name using getName Method: "+getNameMethod.invoke(person).toString());
			
			//accessing a method which consist orguements
			Method setNameMethod=person.getClass().getDeclaredMethod("setName", String.class);
			setNameMethod.invoke(person, "Sriniiii");
			logger.info("Setting person using setMethod: "+person.getName());
			
			//accessing a static method in regular way
			logger.info(Integer.toString(Person.getnumOfPersons()));
			
			//accessing the static method using reflection
			Method staticMethodGetPersons=Person.class.getDeclaredMethod("getnumOfPersons");
			logger.info(staticMethodGetPersons.invoke(null).toString());
			
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//Contructing an object in regular way
			Person p1=new Person("Niranjan",26);
			
			//Constructing an object using reflection
			Constructor<Person> personConstructor=Person.class.getDeclaredConstructor(String.class,int.class);
			Person p2=personConstructor.newInstance("Niri",27);
			logger.info("Reflection Name: "+p2.getName()+" Refelction age: "+p2.getAge());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
