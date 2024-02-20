package testCases.Demos.DemoPractice.Java_Inheritance_Method_Overriding_super_Keyword_final_Keyword;

class Teacher {
	String designation = "Teacher";
	String collegeName = "BusyQA";

	void does() {
		System.out.println("Teaching");
	}
}

public class ComputerTeacher extends Teacher {
	
	String mainSubject = "Selenium Automation";

	public static void main(String args[]) {
		ComputerTeacher obj = new ComputerTeacher();
		System.out.println(obj.collegeName);
		System.out.println(obj.designation);
		System.out.println(obj.mainSubject);
		obj.does();
	}
}