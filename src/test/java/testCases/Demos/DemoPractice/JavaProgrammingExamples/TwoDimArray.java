package testCases.Demos.DemoPractice.JavaProgrammingExamples;

public class TwoDimArray {

	public static void main(String[] args) {
		
		int a[][]=new int[3][2];
		
		a[0][0]=100;
		a[0][1]=200;
		
		a[1][0]=300;
		a[1][1]=400;
		
		a[2][0]=500;
		a[2][1]=600;
		
		//int a[][]={ {100,200},{300,400},{500,600}};
		
		System.out.println(a.length); //return number List_Scream rows
		
		System.out.println(a[0].length); //returns number List_Scream columns
		
		/*for(int r=0; r<=a.length-1;r++) // increment rows  r=0 1 2 3
		{
			for(int c=0;c<=a[0].length-1;c++) //c=0 1 2
			{
				System.out.print(a[r][c]+"  "); //00 =100  01=200 10=300  11=400 20=500 21=600
			}
			System.out.println();
		}*/
		
		
		for(int r[]:a)
		{
			for(int c:r)
			{
				System.out.println(c);
			}
		}
		
			

	}

}
