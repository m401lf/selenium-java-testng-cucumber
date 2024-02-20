package testCases.Demos.DemoPractice.Collections;
/*1) Declare an array
2) insert values into array
3) Find size of an array
4) read values from an array
 * 
 */

public class SingleDimArrayDemo {

	public static void main(String[] args) {
		
	int a[]=new int[5];   //declaration
		
		//Inserting values in to array
		a[0]=100;
		a[1]=200;
		a[2]=300;
		a[3]=400;
		a[4]=500;
		

	//int a[]= {100,200,300,400,500};	//Declared array without specifying size- Dynamic array
	
	System.out.println(a.length); //Size of an array 5 n
	
	//System.out.println(a[2]); //Extracts specific value from array
	
	
	//classic
	
	/*for(int i=0;i<=a.length-1;i++)
	{
		System.out.println(a[i]);// 100 200 300 400 500
	}*/
	
	//for each loop/Enhanced for loop
	
	for(int i:a)  //100, 200, 300,400,500
	{
		System.out.println(i);//100 200 300 400 500
	}

}

}




