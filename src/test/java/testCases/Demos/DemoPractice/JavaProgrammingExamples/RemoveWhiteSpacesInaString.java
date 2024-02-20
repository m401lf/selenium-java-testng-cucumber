package testCases.Demos.DemoPractice.JavaProgrammingExamples;
/*
 * Write a java program to remove all white spaces from a string?
 * 
 */

public class RemoveWhiteSpacesInaString {

	public static void main(String[] args) {
		 {
		        String str = "  Core Java selenium automation       oops programming  ";
		 		      
		        String strWithoutSpace = str.replaceAll("\\s", "");
		 
		        System.out.println(strWithoutSpace);         //Output : CoreJavajspservletsjdbcstrutshibernatespring
		 
		 }

	}

}
