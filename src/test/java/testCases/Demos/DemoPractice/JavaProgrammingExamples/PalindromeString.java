package testCases.Demos.DemoPractice.JavaProgrammingExamples;

public class PalindromeString {
	
	public static void main(String[] args) {
			
				String s = "DAD";
				
				//1. using for loop 
				int len = s.length(); //7
				String rev = "";
				
				for(int i =len-1; i>=0; i--){
					rev = rev + s.charAt(i); //muineleS
				}
				
				System.out.println(rev);
				
				if(s.equals(rev))
				{
					System.out.println("Palindrome string");
				}
				else
				{
					System.out.println("Not Palindrome string");
				}
				
				
				
				
				
				//2. using StringBuffer class:
				//StringBuffer sf = new StringBuffer(s);
				//System.out.println(sf.reverse());
	}
	
	
}