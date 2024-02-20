package testCases.Demos.DemoPractice.JavaProgrammingExamples;

class LinearSearch 
{
  public static void main(String args[])
  {
 
    int array[] = {100,200,300,400,500};
 
    int search_element=400;
    
	int c;
    
    for (c = 0; c < array.length; c++)
    {
      if (array[c] == search_element)     /* Searching element is present */
      {
         System.out.println(search_element + " is present at location " + (c + 1) + ".");
          break;
      }
   }
   if (c == array.length)  /* Element to search isn't present */
      System.out.println(search_element + " isn't present in array.");
  }
}