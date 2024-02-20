package testCases.Demos.DemoPractice.JavaProgrammingExamples;

public class ReverseString {
	
	public static void main(String[] args) {
			//Reverse a String: 
				//diff bw String and StringBuffer
				//do we have reverse function in String?
				
				String s = "Welcome";
				
				//1. using for loop 
				int len = s.length(); //7
				String rev = "";
				
				for(int i =len-1; i>=0; i--){
					rev = rev + s.charAt(i); //muineleS
				}
				
				System.out.println(rev);
				
				//2. using StringBuffer class:
				StringBuffer sf = new StringBuffer(s);
				System.out.println(sf.reverse());
				
				
				//Using recursive method.
				System.out.println(recursiveMethod(s));
				
				
	}
	
	static String recursiveMethod(String str)
	{
	     if ((null == str) || (str.length() <= 1))
	     {
	            return str;
	     }
	 
	     return recursiveMethod(str.substring(1)) + str.charAt(0);
	}
	
}