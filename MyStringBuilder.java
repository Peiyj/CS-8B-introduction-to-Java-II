/**
 *  Name: Ying Pei
 *  Date: June 07, 2017
 *  File: MyStringBuilder.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 9.
 *  MyStringBuilder is a java file 
 *  that constructors a similar data 
 *  structure as link list. It has 
 *  four methods: add, change, remove 
 *  and toString methods. 
 *  
 */

/**
 * Name:    MyStringBuilder.java
 * Purpose: to implement a data structure
 */
public class MyStringBuilder{
    SBNode firstNode;   
    int count;

    /* TODO */
    public MyStringBuilder(){
        count = 0;
        firstNode = null;
    }
    /**
     * method header: add(char addingChar)
     * purpose: First iterate through the list of SBNodes until it hits the last SBNode. 
     * We then use a while-loop and iterate through until you hit the last SBNode. 
     * At this last SBNode, create a new SBNode with addingChar as the argument. 
     * Then, set the reference of the CURRENT SBNode’s next-node reference to 
     * the SBNode you just created. Finally we increment the count variable.
     * return type: void
     */
    public void add(char addingChar)
    {
    	if(firstNode == null)
    	{
    		firstNode = new SBNode(addingChar);
    		count ++;  		
    	}
    	else
    	{
    		SBNode currNode= new SBNode(addingChar);
    		currNode.nextNode = firstNode;
    		while(currNode.nextNode.nextNode != null)
    		{
    			//set up a temp variable to keep track of the last element
    			currNode.nextNode = currNode.nextNode.nextNode;
    		}
    		currNode.nextNode.nextNode = new SBNode(addingChar);
    		count ++;
    	}
    	
    }
    /**
     * method header: change(char changeChar, int position) throws Exception
     * purpose: Check to make sure the position is within the legal range of locations in the string 
     * (anywhere from the first character (position 0) to the last (position count-1).  
     * If it is out of bounds,  throw a new StringIndexOutOfBoundsException
     * using "throw new StringIndexOutOfBoundsException(String errorMessage)"
     * Otherwise, it iterates through the list of SBNodes for the correct number of times as 
     * given by position. Legal value of position starts with 0, which is the first char in the list. 
     * Finally, change the SBNode’s character to changeChar. 
     * return type: void
     */
    public void change(char changeChar, int position) throws Exception
    {
    	if(position >= 0 && position < count )
    	{
    		SBNode currNode= new SBNode(changeChar);
    		currNode.nextNode = firstNode;
    		int index = 0;
    		while(index < position)
    		{	
    			currNode.nextNode = currNode.nextNode.nextNode;
    			index ++;
    		}
    		currNode.nextNode.data = changeChar;
    	}
    	else
    	{
    		throw new StringIndexOutOfBoundsException("Index out of bound!");
    	}
    }
    /**
     * method header: change(char changeChar, int position) throws Exception
     * purpose:Create a String that will eventually be returned when the method finishes. 
     * Iterate through each of the nodes until there are no more. 
     * Each character you see will be joined with this String. 
     * return type: String
     */
    public String toString()
    {
    	String toReturn = "";
    	if(firstNode != null)
    	{
    		SBNode currNode= new SBNode('0');
    		currNode.nextNode = firstNode;
    		toReturn += currNode.nextNode.data;
    		while(currNode.nextNode.nextNode != null)
    		{
    			//set up a temp variable to keep track of the last element
    			currNode.nextNode = currNode.nextNode.nextNode;
    			toReturn += currNode.nextNode.data;
    		}
    	}
    	return toReturn;
    }
    /**
     * method header: remove( int position ) 
     * purpose:This method will give programmers an interface to delete a character 
     * from the data structure. Given a position, take the character located at
     * that position out of the MyStringBuilder and return it in this method. 
     * This method, then, acts somewhat like a getter. However, in addition to that
     * it removes the character from the StringBuilder.  
     * return type: char
     */
    public char remove( int position ) 
    {
    	if(position >= 0 && position < count )
    	{
    		SBNode currNode= new SBNode('0');
    		currNode.nextNode = firstNode;
    		int index = 0;
    		if(position == 0)
    		{
    			char toReturn = firstNode.data;
    			firstNode = firstNode.nextNode;
    			count --;
    			return toReturn;
    		}
    		while(index < position - 1)
    		{	
    			currNode.nextNode = currNode.nextNode.nextNode;
    			index ++;
    		}
    		SBNode toReturn = currNode.nextNode.nextNode;
    		currNode.nextNode.nextNode = currNode.nextNode.nextNode.nextNode;
    		count --;
    		return toReturn.data;
    	}
    	else
    	{
    		throw new StringIndexOutOfBoundsException("Index out of bound!");
    	}
    }

}