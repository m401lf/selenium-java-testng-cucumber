package testCases.Demos.DemoPractice.JavaProgrammingExamples;

import java.util.ArrayList;
import java.util.HashSet;

//Removing Duplicate Elements From ArrayList Using HashSetDemo

public class RemoveDuplicatesFromArrayList {
	  public static void main(String[] args)
	    {
	        //Constructing An ArrayList
	 
	        ArrayList<String> listWithDuplicateElements = new ArrayList<String>();
	 
	        listWithDuplicateElements.add("JAVA");
	 
	        listWithDuplicateElements.add("J2EE");
	 
	        listWithDuplicateElements.add("JSP");
	 
	        listWithDuplicateElements.add("SERVLETS");
	 
	        listWithDuplicateElements.add("JAVA");
	 
	        listWithDuplicateElements.add("STRUTS");
	 
	        listWithDuplicateElements.add("JSP");
	 
	        //Printing listWithDuplicateElements
	 
	        System.out.print("ArrayList With Duplicate Elements :");
	 
	        System.out.println(listWithDuplicateElements);
	 
	        //Constructing HashSetDemo using listWithDuplicateElements
	 
	        HashSet<String> set = new HashSet<String>(listWithDuplicateElements);
	 
	        //Constructing listWithoutDuplicateElements using set
	 
	        ArrayList<String> listWithoutDuplicateElements = new ArrayList<String>(set);
	 
	        //Printing listWithoutDuplicateElements
	 
	        System.out.print("ArrayList After Removing Duplicate Elements :");
	 
	        System.out.println(listWithoutDuplicateElements);
	    }
	  
}
