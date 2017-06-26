/**
 *  Name: Ying Pei
 *  Date: June 07, 2017
 *  File: SBNode.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 9.
 *  SBNode is a java file 
 *  that constructs a 
 *  basic link list
 *  for the methods in
 *  MyStringBuilder class
 */

/**
 * Name:    SBNode.java
 * Purpose: to construct basic list object
 */
public class SBNode 
{
	public char data;
	public SBNode nextNode;
	
	public SBNode(char myData)
	{
		data = myData;
		nextNode = null;
	}

}
