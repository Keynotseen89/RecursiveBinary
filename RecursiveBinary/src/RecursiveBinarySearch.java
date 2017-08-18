import java.util.Scanner;

/**Date: 7/30/2017
 * 
 * @author Quinatzin Sintora
 * Description: This code is used to test a Recursive Binary Search method.
 * It allows someone to search for a value in an array using Recursive Method.
 *
 */
public class RecursiveBinarySearch {

	public static void main(String[] args) {
		
		//Array of numbers to used to search for a number.
		int[] numbers = { 3, 6, 7, 8, 12, 15, 22, 36, 45,
						  48, 51, 53, 64, 69, 72, 89, 95};
		
		
		//Scanner is used for user input
		Scanner scan = new Scanner(System.in);
		
		//Try catch used to avoid memory leak with scanner
		try{
			
		//Prompt user to Enter a value to search for
		System.out.print("Enter a value to search for > " );
		int value = scan.nextInt();
		
		int index = recursiveBinarySearch(numbers, value, 0, numbers.length - 1);
		
		//If index is not equal to 1 then 
		//output this else "print not found"
		if( index != 1)
			System.out.println(value + " found at index " + index );
		else
			System.out.println( value + " not found");
		
		} finally {
			
			//Closes Scanner to avoid memory leak
			scan.close();
			}
		
	}
	
	/**
	  	This is Method used for Recursive Binary Search
		@param array 
		@param key to search
		@param starting position
		@param ending position
		@return recursive Binary 
	*/
	public static int recursiveBinarySearch
					(int [] arr, int key, int start, int end)
	{
			if(start <= end)
			{
				//look at the middle element of the subarray
				int middle = (start + end) / 2;
				
				if(arr[middle] == key) //found key, base case
					return middle;
				else if (arr[middle] > key) // look lower
					return recursiveBinarySearch(arr, key, start, middle - 1);
				else
					return recursiveBinarySearch(arr, key, middle + 1, end);
			}
			else			//key not found, base case
				return - 1; 
		}//end of recursiveBinarySearch static method
}//End of code