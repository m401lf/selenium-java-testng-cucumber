package testCases.Demos.DemoPractice.Java_Inheritance_Method_Overriding_super_Keyword_final_Keyword;

class A   // Parant
{
	int a;
	void display()
	{
		System.out.println(a);
	}
}

class B extends A     // B is child class, A is parent class
{
	int b;
	void print()
	{
		System.out.println(b);
	}
}

class C extends B
{
	int c;
	void show()
	{
		System.out.println(c);
	}
}


public class InheritanceExamples {

	public static void main(String[] args) {
	
		/*A aobj=new A();
		aobj.a=100; 
		aobj.display();*/
		
		/*B bobj=new B();
		bobj.a=10; //A
		bobj.b=20; //B
		
		bobj.display();  //A
		bobj.print(); //B*/
		
		C cobj=new C();
		cobj.a=10;
		cobj.b=20;
		cobj.c=30;
		
		cobj.display();
		cobj.print();
		cobj.show();
			
	}

}
