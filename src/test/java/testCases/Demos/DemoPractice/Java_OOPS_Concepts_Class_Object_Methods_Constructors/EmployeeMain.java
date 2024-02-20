package testCases.Demos.DemoPractice.Java_OOPS_Concepts_Class_Object_Methods_Constructors;

public class EmployeeMain {

	public static void main(String args[])
	{
		Employee emp1=new Employee(); // creating object
		emp1.eid=101;
		emp1.ename="David";
		emp1.sal=25000.00;
		emp1.deptno=10;
		emp1.job="Manager";
		emp1.display();
		
		Employee emp2=new Employee();
		
		emp2.eid=102;
		emp2.ename="John";
		emp2.sal=55000.00;
		emp2.deptno=20;
		emp2.job="CEO";
		emp2.display();
			
	}

}
