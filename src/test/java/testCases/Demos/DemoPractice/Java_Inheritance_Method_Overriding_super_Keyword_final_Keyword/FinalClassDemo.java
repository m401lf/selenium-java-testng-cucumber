package testCases.Demos.DemoPractice.Java_Inheritance_Method_Overriding_super_Keyword_final_Keyword;

class Bike1    // final class, so we cannot extend into child class
{
	int speed=40;
	
	void run()
	{
		System.out.println(speed);
	}
}

class Honda1 extends Bike1  // compile time error
{
	
}


public class FinalClassDemo {

	public static void main(String[] args) {
		

	}

}
