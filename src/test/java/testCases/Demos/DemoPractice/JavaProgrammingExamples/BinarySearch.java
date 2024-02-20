package testCases.Demos.DemoPractice.JavaProgrammingExamples;

class BinarySearch 
{
  public static void main(String args[])
  {
	  int c, first, last, middle, n, search_element;
	  
	  int array[] = {100,200,300,400,500};
	  
	  search_element=200;
	  
	  n=array.length;
	  
	  first  = 0;
	  last   = n - 1;
	  middle = (first + last)/2;
 
    while( first <= last )
    {
      if ( array[middle] < search_element )
        first = middle + 1;    
      else if ( array[middle] == search_element ) 
      {
        System.out.println(search_element + " found at location " + (middle + 1) + ".");
        break;
      }
      else
         last = middle - 1;
 
      middle = (first + last)/2;
   }
   if ( first > last )
      System.out.println(search_element + " isn't present in the list.\n");
  }
}