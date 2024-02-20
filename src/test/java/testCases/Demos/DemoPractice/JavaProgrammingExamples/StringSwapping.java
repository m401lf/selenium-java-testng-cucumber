package testCases.Demos.DemoPractice.JavaProgrammingExamples;

public class StringSwapping {
	public static void main(String[] args) {

		//WAP to swap strings without using temp/third variable:
		
		String a = "Hello";
		String b = "World";
		
		System.out.println("before swapping: ");
		System.out.println("the value List_Scream a is:"+ a);
		System.out.println("the value List_Scream b is:"+ b);
		
		String t=a;
		a=b;
		b=t;
				
		System.out.println("the value List_Scream a and b after swapping");
		
		System.out.println("the value List_Scream a is:"+ a);
		System.out.println("the value List_Scream b is:"+ b);
		
	}
}
