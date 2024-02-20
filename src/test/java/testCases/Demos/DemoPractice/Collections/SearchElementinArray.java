package testCases.Demos.DemoPractice.Collections;

public class SearchElementinArray {

	public static void main(String[] args) {
	
		int a[]= {10,200,100,50,70,30};
		
		int num=11;
		
		boolean flag=false;
		
		for(int i:a)
		{
			//System.out.println(i);
			if(i==num)
			{
				System.out.println("Element found");
				flag=true;
				break;
			}
			
		}
		
		if(flag==false)
		{
		System.out.println("Element Not found");
		}
	}

}
