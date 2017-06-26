/*
 * Name: Ying Pei
 * Login: cs8bsgx 
 * Date:  04/12/2017 Tue
 * File: FunWithIntArrays.java 
 * Purpose: To check and debug mistakes in FunWithIntArray file.
 * In this section, we debugged mistakes in FunWithIntArray file.
 * FunWithIntArrays.java contains bugs that require us to debug.
 * Now, I learned the techniques to debug code, eg use System.out.println()
 */

/** Incorrect type Error as return type for the method is missing
 * Incorrect: public static findMax(int[] array)
 * Fix: public static int findMax(int[] array)
 * Explanation: method has return value of int
 //
 * "Min" can not be resolved as a variable --
 * Incorrect: min = array[0];
 * Fix: int min = array[0];
 * Explanation: "min" is not defined as a local variable yet
 //
 *Incorrect type Error 
 *Incorrect: int average = ( sum / ( array.length ) );
 *Fix: double average = ( sum / ( array.length ) );
 *Explanation: average should be returned as a double not int
 //
 *Syntax error, invalid AssignmentOperator
 *Incorrect:  sum == array[i];
 *Fix: sum = array[i];
 *Explanation: we dont compare; we set sum equal to array[i]
 //
 *Incorrect type Error
 *Incorrect: public static int[] arrayCopy(int array) 
 *Fix:  public static int[] arrayCopy(int [] array) 
 *Explanation: we want to make sure out input is an array not an int.
 //
 *Run time error, array out of bound
 *Incorrect: result[i++] = array[i];
 *Fix:  result[i] = array[i];
 *Explanation: result and array are the same size. Result can't have more elements than array
 //
 *null point access
 *Incorrect:if (array != null)
 *Fix:if (array != null)
 *Explanation: we only return if the array is null
 //
 *Comparison error
 *Incorrect: min = i;
 *Fix: min = array[i];
 *Explanation: we are setting min to the array element.
 //
 *Array out of bound error
 *Incorrect:for (int i = 0; i <= array.length; i++) 
 *Fix: for (int i = 0; i < array.length; i++) 
 *Explanation:index needs to be length-1.
 //
 *Incorrect calculation
 *Incorrect: sum = array[i];
 *Fix: sum = sum+array[i];
 *Explanation: sum should be the sum of all the array, not the last element
 // 
 *Incorrect type error
 *Incorrect: int average = (int) ( sum / ( array.length ) );
 *Fix: double average = (double) ( sum / ( array.length ) );
 *Explanation: we want the average to be double, not int.
 //
 *Array out of bound error
 *Incorrect:for (int i = 0; i < result.length-1; ++i) 
    {
      for (int j = 0; j < result.length-i-1; ++j) 
      {
 *Fix:for (int i = 0; i < result.length; ++i) 
    {
      for (int j = 0; j < result.length-1; ++j) 
      {
 *Explanation: to avoid arrary out bound, j must have result.length-1
 //
 *
 *Incorrect:int temp = result[j];
 *Fix:int temp = result[j+1];
 *Explanation: we must set the temporary variable to j+1 to perform swapping
 * Ying Pei, April 10, 2017
 * */

public class FunWithIntArrays 
{

  // return the largest element in the input array
  public static int findMax(int[] array) 
  {
    //short circuit protects null access
    if (array == null || array.length == 0)
      return -1;
    int max = array[0];

    for (int i = 0; i < array.length; i++) 
    {
      if (array[i] > max) {
        max = array[i];
      }
    }

    return max;
  }

  // return the smallest element in the input array
  public static int findMin(int[] array) 
  {
	    //short circuit protects null access
   if (array == null || array.length == 0)
   {
	   return -1;
   }
   	   int min = array[0];
     for (int i = 0; i < array.length; i++) 
    {
	 if (array[i] < min) 
	 {
	  min = array[i];
	 }
   }
  return min;
  }


  // return the average of elements in the input array
  public static double findAvg( int array[] ) 
 {
	 //short circuit protects null access
	 if ( array == null || array.length == 0 )
	    return -1;
	   double sum = 0;
	 for ( int i=0; i < array.length; i++ ) 
	 {
	    sum = sum+array[i];
	 }
	 double average = (double) ( sum / ( array.length ) );
	 return average;
 }
  // return a copy of the input array
  public static int[] arrayCopy(int [] array) 
  {
	 if (array == null)
	  return null;
     int[] result = new int[array.length];
	 for (int i = 0; i < array.length; i++) 
	{
	   result[i] = array[i];
	}
	   return result;
  }

  // output the elements of the input array
  public static void printArray(int[] array) 
  {
    if (array == null)
      return;
    for (int i = 0; i < array.length; i++) 
    {
      System.out.print(array[i] + ", ");
    }

    System.out.println();
  }

  // return a sorted copy of the input array
  public static int[] arraySort(int[] array) {
    if (array == null)
      return null;
    int[] result = arrayCopy(array);

    for (int i = 0; i < result.length; ++i) 
    {
      for (int j = 0; j < result.length-1; ++j) 
      { 
        if (result[j] > result[j + 1]) 
        {
          //swapping result[j] and result[j+1]
          int temp = result[j+1];
          result[j + 1] = result[j];
          result[j] = temp;
          
        }
      }
    }
    return result;
  }
}
