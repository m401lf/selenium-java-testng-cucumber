package testCases.Demos.DemoPractice.JavaProgrammingExamples;

public class SearchNumberinArray {

	public static void main(String[] args) {
			
			int a[]={10,20,30,40,50};
			
			int num=30;
			boolean flag=false;
			
			for(int i:a)
			{
				if(num==i)
				{
					System.out.println("Element found");
					flag=true;
					break;
				}
			}
			
			if(flag==false)
			{
				System.out.println("Element NOT found");
			}
			

	}

}
