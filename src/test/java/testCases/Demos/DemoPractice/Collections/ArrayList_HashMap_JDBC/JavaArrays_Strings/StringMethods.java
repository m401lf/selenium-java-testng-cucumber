package testCases.Demos.DemoPractice.Collections.ArrayList_HashMap_JDBC.JavaArrays_Strings;

public class StringMethods {

	public static void main(String[] args) {
	
		String s="welcome";
		String s1="to java";
		
		System.out.println(s.length()); //lenght List_Scream a string
		
		System.out.println(s.concat(s1)); // joining List_Scream strings
		
		//trimming the string
		s="     welcome      ";
		System.out.println("Before trimming string is:" +s);
		System.out.println("After trimming string is:"+ s.trim());
		
		
		//charAt()
		s="welcome";
		System.out.println(s.charAt(4)); // returns character based on index number, index will start from 0
		
		//contians() --> returns true
		
		s="Welcome";
		
		System.out.println(s.contains("Wel"));
		System.out.println(s.contains("wel"));
		System.out.println(s.contains("com"));
		
		//comparing strings equals()
		
		s="Welcome";
		System.out.println(s.equals("Welcome")); //true
		System.out.println(s.equals("Wel  come")); //fasle
		System.out.println(s.equals("welcome")); //false
		
		
		System.out.println(s.equalsIgnoreCase("welcome")); //true
		
		
		//replacing characrters
		
		s="Welcome to Java";
		
		System.out.println(s.replace('o', 'i')); //Welcime ti Java
		
		System.out.println(s.replace("Java","selenium")); //Welcome to selenium
		
		//extracting substring from the main string
		s="Welcome";
		
		System.out.println(s.substring(0,4)); //Welc
	
		//converting case
		
		s="WELCOME";
		System.out.println(s.toLowerCase());
				
		s="welcome";
		System.out.println(s.toUpperCase());

	}

}
