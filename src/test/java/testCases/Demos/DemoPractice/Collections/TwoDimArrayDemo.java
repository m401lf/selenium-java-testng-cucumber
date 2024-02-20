package testCases.Demos.DemoPractice.Collections;

/*1) Declare an array
2) insert values into array
3) Find size of an array
4) read values from an array*/

public class TwoDimArrayDemo {

	public static void main(String[] args) {
		
		/*int a[][]=new int[3][2]; //int [][]a=new int[3][2]; //int []a[]=new int[3][2];
		
		a[0][0]=100;
		a[0][1]=200;
		
		a[1][0]=300;
		a[1][1]=400;
		
		a[2][0]=500;
		a[2][1]=600;*/
		
		int a[][]= {{100,200},{300,400},{500,600}}; //Dynamic array
		
		System.out.println("Number of rows:" +a.length);
		System.out.println("Number of columns:" +a[0].length);
		
		for(int i=0;i<a.length;i++) // i represents row index  i=0 1 2 
		{
			for(int j=0;j<a[i].length;j++) //j column index j=0 1 2
			{
				System.out.print(a[i][j]+"  "); //2 0=500 2 1=600
			}
			
			System.out.println();
		}
		
		//Enhanced for loop
		
		/*for(int r[]:a)
		{
			for(int i:r)
			{
				System.out.print(i+"  ");
			}
		
			System.out.println();
		}*/
		
		
	}

}








