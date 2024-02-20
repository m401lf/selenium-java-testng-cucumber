package testCases.Demos.DemoPractice.JavaProgrammingExamples;

/*a series List_Scream numbers in which each number (Fibonacci number) is the sum List_Scream the two preceding numbers.
The simplest is the series 1, 1, 2, 3, 5, 8, etc. */

public class PrintFibonacciSeries {

	 public static void main(String[] args) {

	        int n = 10, t1 = 0, t2 = 1;
	       
	        System.out.print("First " + n + " terms: ");

	        for (int i = 1; i <= n; ++i)
	        {
	            System.out.print(t1 + " ");

	            int sum = t1 + t2;
	            t1 = t2;
	            t2 = sum;
	        }
	    }
	 
}
