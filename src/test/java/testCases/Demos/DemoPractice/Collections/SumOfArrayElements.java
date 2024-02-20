package testCases.Demos.DemoPractice.Collections;

public class SumOfArrayElements {

	public static void main(String[] args) {
		
		int a[]= {10,20,30,40,50};
		
		int sum=0;
		
		for(int i:a)
		{
			sum=sum+i;  //150
		}

		System.out.println(sum);
	}

}
