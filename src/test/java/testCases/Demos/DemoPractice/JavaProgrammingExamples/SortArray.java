package testCases.Demos.DemoPractice.JavaProgrammingExamples;

import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {
		
		//Number Array sorting
		int data[] = { 4, 10, 2, 6, 1 };
		 
	    Arrays.sort(data); 
	 	 
	   for (int c: data) 
	    {
	      System.out.println(c);
	    }
	    
	   	  
	    //String array sorting
	    	   	 
	   String data2[] = { "z","a","x"};
	    Arrays.sort(data2);
	 
	    for (String c: data2) 
	    {
	      System.out.println(c);
	    }
	    
	    

	}

}
