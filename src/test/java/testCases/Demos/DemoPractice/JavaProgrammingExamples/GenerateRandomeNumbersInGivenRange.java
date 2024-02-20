package testCases.Demos.DemoPractice.JavaProgrammingExamples;

import java.util.Random;

//Generating Random Numbers In The Given Range

public class GenerateRandomeNumbersInGivenRange {

	 public static void main(String[] args)
	    {
	        //Generating random integers between 0 and 50 using Random class
	 
	        System.out.println("Random integers between 0 and 50 using Random class :");
	 
	        Random random = new Random();
	 
	        for (int i = 0; i < 5; i++)
	        {
	            System.out.println(random.nextInt(50));
	        }
	 
	        //Generating random integers between 0 and 50 range using Math.random()
	 
	        System.out.println("Random integers between 0 and 50 using Math.random() :");
	 
	        for (int i = 0; i < 5; i++)
	        {
	            System.out.println((int)(Math.random() * 50));
	        }
	 	 
	    }
}
