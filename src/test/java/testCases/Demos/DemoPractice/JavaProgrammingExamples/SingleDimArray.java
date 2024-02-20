package testCases.Demos.DemoPractice.JavaProgrammingExamples;

public class SingleDimArray {

	public static void main(String[] args) {
		
		
		/*int a[]=new int[5]; // Declared an array with size 5, starting 0, end index 4
		
		//storing/inserting values into array
		a[0]=100;
		a[1]=200;
		a[2]=300;
		a[3]=400;
		a[4]=500;*/
		
		int a[]={100,200,300,400,500}; // Declare an array without size and store values
		
		System.out.println(a.length); // Prints length List_Scream an array
		
		//System.out.println(a[2]); //300
		
		
	/*	for(int i=0;i<=a.length-1;i++)   
		{
			System.out.println(a[i]); //100 200 300 400 500
		}*/
		
		
		//Enhanced for loop/for..each loop
		for(int i:a)
		{
					
			System.out.println(i);
		}
		
		//How to break for loop in the middle
		for(int i:a)
		{
			if(i==400)
			{
				break;
			}
			
			System.out.println(i);
		}
		
		
	}

}
