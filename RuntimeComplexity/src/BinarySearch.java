import java.util.Arrays;
import java.util.Random;

public class BinarySearch{

	public static void main(String[] args){
		int key = 3829301; 
		int size = 10000000;
        int[ ] arr = new int [size];
        // Fill the array
        Random rand = new Random();
		for (int i = 0; i < size; i++){
            arr[i] = rand.nextInt(size+1);
		}
		Arrays.sort(arr);
       binarySearch(arr,0,size-1,key);
		         
	}
public static void binarySearch(int[ ] array, int lowerbound, int upperbound, int key)
   {
       int position;
       int comparisonCount = 1;    // counting the number of comparisons (optional)

     // To start, find the subscript of the middle position.
     position = ( lowerbound + upperbound) / 2;

     while((array[position] != key) && (lowerbound <= upperbound))
     {
         comparisonCount++;
         if (array[position] > key)             // If the number is > key, ..
         {                                              // decrease position by one. 
              upperbound = position - 1;   
         }                                                             
              else                                                   
        {                                                        
              lowerbound = position + 1;    // Else, increase position by one. 
        }
       position = (lowerbound + upperbound) / 2;
     }
     if (lowerbound <= upperbound)
     {
           System.out.println("The number was found in array subscript " + position);
           System.out.println("The binary search found the number after " + comparisonCount +
                 " comparisons.");
           System.out.println(array[position-2] + " " + array[position-1] + " " +  array[position] + " " + array[position+1] + " " + array[position+2]);
           for(int i = -2; i < 3; i++){
        	   String num = " " + array[position-i];
        	   for(int j = 0; j < num.length(); j++){
        		   if(i == 0 && (j == num.length()/2)){
        			   System.out.print("^");
        		   }
        		   System.out.print(" ");
        	   }
        	   
           }
           // printing the number of comparisons is optional
     }
     else
          System.out.println("Sorry, the number is not in this array.  The binary search made "
                 +comparisonCount  + " comparisons.");
  }


}
