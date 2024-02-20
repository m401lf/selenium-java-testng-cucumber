package testCases.Demos.DemoPractice.JavaProgrammingExamples;

public class StringMethods {

	public static void main(String[] args) {
		
		String s="welcome";
		
		//length()
		System.out.println(s.length());
		
		//concat()
		String s1="welcome";
		String s2=" to java";
		
		System.out.println(s1.concat(s2));
		System.out.println("welcome".concat(" to java"));
			
		//trim()
		s="    welcome    ";
		System.out.println(s);
		System.out.println(s.trim());
		
		
		//charAt()
		s="Welcome";
		
		System.out.println(s.charAt(4)); //o
		
		//contains() --> return true/false
		s="Welcome to java";
		System.out.println(s.contains("java")); //true
		System.out.println(s.contains("Java")); //false
		
		//equals()  & equalsIgnoreCase()
		s="Selenium";
		System.out.println(s.equals("SELENIUM"));
		System.out.println(s.equalsIgnoreCase("SELENIUM"));
		
		//Replace()
		s="welcome to java";
		System.out.println(s.replace('e', 'a')); // replacing single character
		System.out.println(s.replace("java", "selenium")); // replacing multiple chars
		
		//substring()
		s="Welcome";
		System.out.println(s.substring(2,4)); //lc
		System.out.println(s.substring(4,7));  //ome
		
		//toLowerCase() && toUpperCase()
		
		s="WelCome";
		
		System.out.println(s.toLowerCase()); //welcome
		System.out.println(s.toUpperCase()); //WELCOME
	}

}
