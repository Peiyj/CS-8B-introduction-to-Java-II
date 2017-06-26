import java.awt.Color;


/**
 *  Name: Ying Pei
 *  Date: May 16, 2017
 *  File: Bear.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 6.
 *  This file has Bear.java. Bear is a java file 
 *  that has one field that construct a bear object.
 *  Specifically, the board stores information about 
 *  a bear. 
 *  The methods in which I override are 5 methods
 *  that have the same signature as the parent class
 *  public boolean eat()
 *  public Attack fight(String opponent)
 *  public Color getColor()
 *  public Direction getMove()
 *  public String toString()
 */

/**
 * Name:    Bear.java
 * Purpose: To store information about the bear class
 */

public class Bear extends Critter
{
	///fields
	protected String bear;
	protected Direction direction;
	
	///constructor
	 public Bear(boolean grizzly)
	 {
		 if(grizzly == true)
		 {
			 bear = "grizzly bear";
		 }
		 if(grizzly == false)
		 {
			 bear = "polar bear";
		 }
		 direction = Direction.SOUTH;
	 }
	 /**
	  * Name:public Color getColor() 
	  * Purpose:Every time the board updates, the code calls bear to ask it what color 
	  * it wants to be drawn with. In this case, if it is grizzly bear, the color will 
	  * be brown. If it is polar bear, then it will be white
	  * Return type: Color
	  */
	 public Color getColor() 
	 {
		 if(bear.equals("grizzly bear") )
		 {
			 return new Color(190,110,50);
		 }
		 if(bear.equals("polar bear"))
		 {
			 return Color.WHITE;
		 }
		 //if bear is null, return null
		return null;
	 }
	 
	 /**
	  * Name:public boolean eat()
	  * Purpose:Every time when bear encounters food, the code calls 
	  * this on it to ask whether it wants to eat (true) or not (false).
	  * In this case, bear will always eat
	  * Return type: boolean
	  */
	 public boolean eat() 
	 {
		 return true;
	 }
	 /**
	  * Name:public Attack fight(String opponent) 
	  * Purpose:Every time when bear encounters his opponent,
	  * he always scratch (Attack.SCRATCH)
	  * Return type: Attack (enum);
	  */
	 public Attack fight(String opponent) 
	 {
		 return Attack.SCRATCH;
	 }
	 /**
	  * Name:public Direction getMove()
	  * Purpose: bear alternates between south and east 
	  * in a zigzag pattern (first south, then east, then south, then east)
	  * Return type: Direction (enum);
	  */
	 public Direction getMove()
	 {
		 if(direction.equals(Direction.SOUTH))
		 {
			 direction = Direction.EAST;
			 return Direction.SOUTH;

		 }
		 if(direction.equals(Direction.EAST))
		 {
			 direction = Direction.SOUTH;
			 return Direction.EAST;
		 }

		 return direction;
	 }
	 /**
	  * Name:public String toString() 
	  * Purpose: the name appeared on the simulator for bear is "B"
	  * Return type: String
	  */
	 public String toString() 
	 {
			return "B";
	 }
	 

}