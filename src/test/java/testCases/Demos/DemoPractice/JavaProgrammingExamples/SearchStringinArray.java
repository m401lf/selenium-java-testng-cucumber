package testCases.Demos.DemoPractice.JavaProgrammingExamples;

public class SearchStringinArray {

public static void main(String[] args) {
		
		String a[]={"abc", "xyz", "pqr"," mno"};
		
		String search_String="xyz";
		
		boolean flag=false;
		
		for(String s:a)
		{
			if(search_String==s)
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
