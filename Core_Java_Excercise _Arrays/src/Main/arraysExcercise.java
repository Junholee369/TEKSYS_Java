package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class arraysExcercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Write a program that creates an array of integers with a length of 3. Assign
		 * the values 1, 2, and 3 to the indexes. Print out each array element.
		 */
		
//		 ArrayList<Integer> numbers = new ArrayList<Integer>();
//		 numbers.add(1);
//		 numbers.add(2);
//		 numbers.add(3);
//		 System.out.println(numbers);

		/*
		 * Write a program that returns the middle element in an array. Give the
		 * following values to the integer array: {13, 5, 7, 68, 2} and produce the
		 * following output: 7
		 */
//		 ArrayList<Integer> numbers2 = new ArrayList<Integer>();
//		 numbers2.add(13);
//		 numbers2.add(15);
//		 numbers2.add(7);
//		 numbers2.add(68);
//		 numbers2.add(2);
//		 
//		 int mid = (numbers2.size() - 1)/2;
//		 int answer = numbers2.get(mid);
//				 
//		 System.out.println(answer);

		/*
		 * Write a program that creates an array of String type and initializes it with
		 * the strings “red”, “green”, “blue” and “yellow”. Print out the array length.
		 * Make a copy using the clone( ) method. Use the Arrays.toString( ) method on
		 * the new array to verify that the original array was copied.
		 */

//		String[] numbers3 = {"red", "green", "blue", "yellow"};
//		int arrLength = numbers3.length;
//		
//		System.out.println(arrLength);		
//		
//		String[] copiedArray = numbers3.clone();
//		System.out.println(Arrays.toString(copiedArray));
		
		

		/*
		 * Write a program that creates an integer array with 5 elements (i.e.,
		 * numbers). The numbers can be any integers. Print out the value at the first
		 * index and the last index using length - 1 as the index. Now try printing the
		 * value at index = length ( e.g., myArray[myArray.length ] ). Notice the type
		 * of exception which is produced. Now try to assign a value to the array index
		 * 5. You should get the same type of exception.
		 */

//		int[] number4 = {1,13,14,25,36};
//		int first4= number4[0];
//		
//		int last4 = (number4.length - 1);
//		
//		
//		System.out.println(first4);
//		System.out.println(number4[last4]);
//		System.out.println(number4[number4.length);

		
		/*
		 * Write a program where you create an integer array with a length of 5. Loop
		 * through the array and assign the value of the loop control variable (e.g., i)
		 * to the corresponding index in the array.
		 */
		
//		int[] number5 = {1,13,14,25,36};
//		for(int i = 0; i<0 ; i++ ) {
//			number5[i] = i;
//		}

		
		
		/*
		 * Write a program where you create an integer array of 5 numbers. Loop through
		 * the array and assign the value of the loop control variable multiplied by 2
		 * to the corresponding index in the array.
		 */
//		int[] number6 = {1,13,14,25,36};
//		for(int i = 0; i<0 ; i++ ) {
//			number6[i] = i*2;
//		}
		
		
		/*
		 * Write a program where you create an array of 5 elements. Loop through the
		 * array and print the value of each element, except for the middle (index 2)
		 * element.
		 */
//		int[] number7 = {1,13,14,25,36};
//		for(int i = 0; i<0 ; i++ ) {
//			if (i != 2) {
//				System.out.println(number7[i]);
//			}			
//		}
		
		
		/*
		 * Write a program that creates a String array of 5 elements and swaps the first
		 * element with the middle element without creating a new array.
		 */

//		String[] numbers8 = {"uwu", "owo", "omo", "hi", "hello"};
//		String Temp;
//		String middleElement = numbers8[(numbers8.length)/2];
//		Temp =middleElement;
//		
//		numbers8[(numbers8.length)/2] = numbers8[0];
//		numbers8[0] = Temp;
//		
//		System.out.println(Arrays.toString(numbers8));
		
		
		
		/*
		 * Write a program to sort the following int array in ascending order: {4, 2, 9,
		 * 13, 1, 0}. Print the array in ascending order, print the smallest and the
		 * largest element of the array. The output will look like the following:
		 * 
		 * Array in ascending order: 0, 1, 2, 4, 9, 13
		 * 
		 * The smallest number is 0
		 * 
		 * The biggest number is 13
		 */

//		 ArrayList<Integer> numbers9 = new ArrayList<Integer>();
//		 numbers9.add(12);
//		 numbers9.add(5);
//		 numbers9.add(6);
//		 numbers9.add(10);
//		 numbers9.add(2);
//		 numbers9.add(44);
//		 
//		 System.out.println("Before sorting: " + numbers9);
//		 
//		 Collections.sort(numbers9);
//		 System.out.println("After sorting: " + numbers9);
//		 int firstIndexValue = numbers9.get(0);
//		 System.out.println(firstIndexValue);
//		 int lastIndexValue = numbers9.get(numbers9.size() -1);
//		 System.out.println(lastIndexValue);

		/*
		 * Create an array that includes an integer, 3 strings, and 1 double. Print the
		 * array.
		 */
		Object[] mixed = new Object[5];
		mixed[0] = Integer.valueOf(30);
		mixed[1] = "OWO";
		mixed[2] = "UWU";
		mixed[3] = "OMO";
		mixed[4] = Double.valueOf(3.5);
		
		System.out.println(Arrays.toString(mixed));
		
 
		
	}

}
