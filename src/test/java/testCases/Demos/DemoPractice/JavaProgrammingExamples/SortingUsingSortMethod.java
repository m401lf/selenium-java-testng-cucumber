package testCases.Demos.DemoPractice.JavaProgrammingExamples;

import java.util.Arrays;

public class SortingUsingSortMethod {
	
	public static void main(String args[])
	  {
	    int data[] = { 4, 10, 2, 6, 1 };
	 
	    Arrays.sort(data);
	 
	    for (int c: data) 
	    {
	      System.out.println(c);
	    }
	  }
}

