package testCases.Demos.DemoPractice.Java_OOPS_Concepts_Class_Object_Methods_Constructors;

public class StudentMain {

	public static void main(String[] args) {
		
		Student stu1=new Student(1010,"John",'A'); //3 ASSIGN VALUES BY USING CONSTRUCTOR
		
		//1 assign values by usign reference varaible
		/*stu1.sid=1010;
		stu1.sname="John";
		stu1.grade='A';*/
		
		//2 assign values by using method
		//stu1.getValues(1010,"John",'A');
			
			
		stu1.display();

	}

}
