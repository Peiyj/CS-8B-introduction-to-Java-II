/**
 *  Name: Ying Pei
 *  Date: May 31, 2017
 *  File: WarmupRecursion.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 8.
 *  WarmupRecursion is a java file 
 *  that has three methods implemented using recursion.
 *  Specifically, these three methods are basic methods of
 *  recursion
 *  
 */

/**
 * Name:    WarmupRecursion.java
 * Purpose: To store three recursive functions 
 */

import java.util.ArrayList;
import java.util.Random;

public class WarmupRecursion {

    /**
     * Method header:binaryString(int n) 
     * Purpose: this method takes an input value n,
     * using recursion, it is able to print the value
     * in binary format. However n can only be non-negative
     * value.
     * Return type: String.
     */
    public static String binaryString(int n) 
    {
    	if(n/2 == 0)
    	{
    		return n + "";
    	}
    	else
    	{
    		return binaryString(n/2) + n % 2;
    	}
    	
    }

    /**
     * Method header:generateRandomMnemonic(String digits)  
     * Purpose: This method takes as input a String containing 0 or more digits and 
     * returns a string which is a legal mnemonic for that string of digits 
     * (though not necessarily an actual word), chosen at random. 
     * Return type: String.
     */
    public static String generateRandomMnemonic(String digits) 
    {
    	//base case
    	if(digits == null || digits.length() == 0)
    	{
    		return "";
    	}
    	else
    	{
    		String toReturn = getCode(digits.charAt(digits.length()-1));
    		return generateRandomMnemonic(digits.substring(0, digits.length()-1))
    			  + toReturn;
    	}
    }

    /**
     * Method header:isSubSetSum(ArrayList<Integer> set, int targetNumber)  
     * Purpose: This method takes an ArrayList of integers, and a targetNumber and determines 
     * if there  is a subset of those integers that sum to that targetNumber.
     * Return type: boolean.
     */
    public static boolean isSubSetSum(ArrayList<Integer> set, int targetNumber) 
    {
    	ArrayList<Integer> copy = new ArrayList<Integer>();
    	copy.addAll(set);
    	if(targetNumber ==0 )
    	{
    		return true;
    	}
    	else if(set.size() == 0 || set == null)
    	{
            return false;
    	}
    	else if(set.get(0) == targetNumber)
    	{
    		return true;
    	}
    	else
    	{
    		int first = set.get(0);
    		copy.remove(0);
    		return isSubSetSum(copy, targetNumber) || isSubSetSum(copy, targetNumber - first);
    	}
    }
    
    
    private static String getCode(char A) {
    	Random randNum = new Random();
    	switch (A) {    	 
      	 case '2':	
    		int position = randNum.nextInt(3);
    		if(position == 0)
    		{
    			return "A";
    		}
    		else if(position == 1)
    		{
    			return "B";
    		}
    		else
    		{
    			return "C";
    		}
      	 case '3':
    		int position1 = randNum.nextInt(3);
    		if(position1 == 0)
    		{
    			return "D";
    		}
    		else if(position1 == 1)
    		{
    			return "E";
    		}
    		else
    		{
    			return "F";
    		}
      	 case '4':
    		int position2 = randNum.nextInt(3);
    		if(position2 == 0)
    		{
    			return "G";
    		}
    		else if(position2 == 1)
    		{
    			return "H";
    		}
    		else
    		{
    			return "I";
    		}
      	 case '5':
    		int position3 = randNum.nextInt(3);
    		if(position3 == 0)
    		{
    			return "J";
    		}
    		else if(position3 == 1)
    		{
    			return "K";
    		}
    		else
    		{
    			return "L";
    		}
      	 case '6':
    		int position4 = randNum.nextInt(3);
    		if(position4 == 0)
    		{
    			return "M";
    		}
    		else if(position4 == 1)
    		{
    			return "N";
    		}
    		else 
    		{
    			return "O";
    		}
      	 case '7':
    		int position5 = randNum.nextInt(4);
    		if(position5 == 0)
    		{
    			return "P";
    		}
    		else if(position5 == 1)
    		{
    			return "Q";
    		}
    		else if(position5 == 2)
    		{
    			return "R";
    		}
    		else
    		{
    			return "S";
    		}
      	 case '8':
    		int position6 = randNum.nextInt(3);
    		if(position6 == 0)
    		{
    			return "T";
    		}
    		else if(position6 == 1)
    		{
    			return "U";
    		}
    		else
    		{
    			return "V";
    		}
      	 case '9':
    		int position7 = randNum.nextInt(4);
    		if(position7 == 0)
    		{
    			return "W";
    		}
    		else if(position7 == 1)
    		{
    			return "X";
    		}
    		else if(position7 == 2)
    		{
    			return "Y";
    		}
    		else
    		{
    			return "Z";
    		}
      	 default:
      		 return "";
      	 }
       }


}
