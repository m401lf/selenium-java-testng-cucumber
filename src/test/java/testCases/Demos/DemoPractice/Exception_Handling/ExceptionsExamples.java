package testCases.Demos.DemoPractice.Exception_Handling;

public class ExceptionsExamples {

	public static void main(String[] args) {
		
		System.out.println("Program is started");
		System.out.println("Program is in progres");
		
		/*int a=100;
		int res = 0;
		try
		{
		//System.out.println(a/0); // Throw Arithmetic Exception
		res=a/0;
		}
		catch(ArithmeticException e)
		{
			System.out.println("Entered in to catch block");
		}
			
		System.out.println(res);*/
		
		String s=null;
		try
		{
		System.out.println(s.length()); // throws NullpointerException
		}
		catch(Exception e)
		{
			System.out.println("Entered in to catch block");
		}
		
			
		String x="abc";
		//int i=Integer.parseInt(x); // NumberFormatException
		
		int arr[]=new int[5];
		//arr[10]=100;   //ArrayIndexOutOfBoundsException
		
		
		System.out.println("Program is completed");
		System.out.println("Program is exited");

	}

}
