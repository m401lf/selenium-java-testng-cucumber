package testCases.Demos.DemoPractice.JavaProgrammingExamples;

public class EvenAndOddNumbersinArray {

	public static void main(String[] args) {
		
		int a[]={10,20,15,3,6,7,8,2,5,7};
		
		int n=a.length;
		
		System.out.print("Odd numbers:");
        for(int i = 0 ; i < n ; i++)
        {
            if(a[i] % 2 != 0)
            {
                System.out.print(a[i]+" ");
            }
        }
        System.out.println();
        
        System.out.print("Even numbers:");
        for(int i = 0 ; i < n ; i++)
        {
            if(a[i] % 2 == 0)
            {
                System.out.print(a[i]+" ");
            }
        }

	}

}
