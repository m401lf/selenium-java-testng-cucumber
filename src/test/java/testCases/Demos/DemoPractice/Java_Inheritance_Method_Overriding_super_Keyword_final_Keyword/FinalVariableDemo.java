package testCases.Demos.DemoPractice.Java_Inheritance_Method_Overriding_super_Keyword_final_Keyword;

public class FinalVariableDemo {

	int speed=40; // final varaible, so we cannot change this value
	
	
	public static void main(String[] args) {
		
		FinalVariableDemo fm=new FinalVariableDemo();
		fm.speed=100;  // compile time error
		System.out.println(fm.speed);
	}

}
