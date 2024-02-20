package testCases.Demos.DemoPractice.Java_OOPS_Concepts_Class_Object_Methods_Constructors;

public class ConstructorDemo {

	int x;
	int y;
	
	ConstructorDemo()  // default constructor
	{
		x=10;
		y=20;
	}
	
	
	ConstructorDemo(int a, int b)  // parameterized constructor
	{
		x=a;
		y=b;
	}
	
	void display()
	{
		System.out.println(x+y);
	}
	
	
	public static void main(String[] args) {
		
		ConstructorDemo cm1= new ConstructorDemo(); // Invokes default constructor
		cm1.display();
		
		ConstructorDemo cm2= new ConstructorDemo(100,200); // Invokes parameterized constructor
		cm2.display();

	}

}
