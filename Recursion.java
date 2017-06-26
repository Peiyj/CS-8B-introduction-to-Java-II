/**
 *  Name: Ying Pei
 *  Date: May 31, 2017
 *  File: Recursion.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 8.
 *  Recursion is a java file 
 *  that has one of four methods that needed to be implemented.
 *  Specifically, the method I choose to solve is the humanPyramid
 *  
 */

/**
 * Name:    Recursion.java
 * Purpose: To store information about the board class
 */

import java.util.ArrayList;

public class Recursion {

	/**
	 * method header: humanPyramidWeight(ArrayList<ArrayList<Double>> weights,
                                            int level, int offset)
	 * Purpose: That takes a nested ArrayList containing the weights of the people in the pyramid, 
	 * a level where the top person in the pyramid is at level 0 and each level increases by 1, 
	 * and an offset, which is the number of people in from the left in a given level.  
	 * This function returns the total weight carried (as described above)
	 *  by the person in the specified level of the pyramid at the given offset. 
	 *  If the level/offset passed is outside the bounds of the ArrayList, return 0. 
	 *  Return type: double
	 */
    public static double humanPyramidWeight(ArrayList<ArrayList<Double>> weights,
                                            int level, int offset) throws Exception 
    {
    	//base case
    	if(level == 0)
    	{
    		return weights.get(0).get(0);
    	}
    	else if(offset > level)
    	{
    		return 0;
    	}
    	else
    	{
    		if(offset == level)
    		{
    			return 0.5 * humanPyramidWeight(weights, level - 1, offset - 1) 
    				 + weights.get(level).get(offset);
    		}
    		else if(offset == 0)
    		{
    			return 0.5 * humanPyramidWeight(weights, level - 1, offset) 
       				 + weights.get(level).get(offset);
    		}
    		else
    		{
    			return (humanPyramidWeight(weights, level - 1, offset -1)
    				 +  humanPyramidWeight(weights, level - 1, offset +1))/2
    				 + weights.get(level).get(offset);
    		}
    	}
    }

    public static ArrayList<String> generateMnemonics(String number) 
    {
    	ArrayList<String> codeArray = new ArrayList();
    		return codeArray;   
    }

    public static int collectCoins2D(int[][] board, int row, int col) {
        return 0;
    }

    public static int collectCoins1D(int[] m) {
        return 0;
    }

    private static int collectMaxCoinsHelp(int[] m, int start, int end) {
        return 0;
    }
    private static String getCode(char A) 
    {
      	 switch (A) {
      	 case '2':
      		 return "ABC";
      	 case '3':
      		 return "DEF";
      	 case '4':
      		 return "GHI";
      	 case '5':
      		 return "JKL";
      	 case '6':
      		 return "MNO";
      	 case '7':
      		 return "PQRS";
      	 case '8':
      		 return "TUV";
      	 case '9':
      		 return "WXYZ";
      	 default:
      		 return "";

      	 }
     }
    
    

}