package testCases.Demos.DemoPractice.Collections;

import java.util.ArrayList;

/*
 * How to declare array list
how to to add elements/values to array list
Find size of array list
remove elements/values from array list
insert a new element in the middle of array list
read values from arraylist
 */

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList list=new ArrayList(); //Declaration
		
		//how to to add elements/values to array list
		list.add("welcome");		
		list.add(10);
		list.add(10.5);
		list.add(true);
		list.add('A');
		
		//Find size of array list
		System.out.println(list.size()); //5
		System.out.println("Initial list of values in array list:"+list);
		
		System.out.println(list.get(2));//10.5 //capture specific value from array list,index starts from 0
		
		//insert a new element in the middle of array list
		list.add(1,"selenium"); 
		System.out.println("list of values after inserting new value:"+list);
		
		list.remove(3); //Remove element/value from array list based on index value, index starts from 0
		System.out.println("list of values after remove:"+list);
		
		for(Object i:list)
		{
			System.out.println(i);
		}
		

	}

}
