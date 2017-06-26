import java.awt.Color;

/**
 *  Name: Ying Pei
 *  Date: May 16, 2017
 *  File: Lion.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 6.
 *  This file has Lion.java. Lion is a java file 
 *  that has seven fields that construct a Lion object.
 *  Specifically, the board stores information about 
 *  a Lion. 
 *  The methods in which I override are 5 methods
 *  that have the same signature as the parent class
 *  public boolean eat()
 *  public Attack fight(String opponent)
 *  public Color getColor()
 *  public Direction getMove()
 *  public String toString()
 */
public class Lion extends Critter
{
	///fields
	protected int countSouth;
	protected int countWest;
	protected int countNorth;
	protected int countEast;
	protected boolean isHungry;
	protected int countAttack;
	//this is the constant variable for number of loops
	protected static final int LOOPCOUNT = 5;
	protected Direction direction;
	
	/**
	 * Name: public Lion()
	 * Purpose: construct a Lion object
	 * Return type: none
	 */
	 public Lion()
	 {
		 countSouth = LOOPCOUNT;
		 countWest = LOOPCOUNT;
		 countNorth = LOOPCOUNT;
		 countEast = LOOPCOUNT;	
		 countAttack = 0;
	 }
	 
	 /**
		*Name: public Color getColor()
		*Purpose: The color is always red
		*Return type: Color
		*/
	 public Color getColor() 
	 {
		return Color.RED;
	 }
	 /**
		*Name:  public boolean eat()
		*Purpose: returns true if this Lion has been in a fight 
		*since it has last eaten (if fight has been called on this Lion 
		*at least once since the last call to eat (countAttack > 0)). 
		*Return type: boolean
		*/

	 public boolean eat() 
	 {
		if(countAttack == 0 )
		{	
			return false; 	
		}
		else
		{
			countAttack = 0; 
			return true;
		}	
		
	 }
	 /**
		*Name: public Attack fight(String opponent) 
		*Purpose:  if opponent is a Bear ("B"), then roar (Attack.ROAR);
		* otherwise pounce (Attack.POUNCE). 
		*Return type: Attack
		*/
	 public Attack fight(String opponent) 

	 {
		 if(opponent.equals("B"))
		 {
			 countAttack ++;
			 return Attack.ROAR;
		 }
		 else
		 {
			 countAttack++;
			 return Attack.POUNCE;
		 }
	 }
	 /**
		*Name: public Direction getMove()
		*Purpose:  movement behavior: first go south 5 times, then go west 5 times, 
		*then go north 5 times, then go east 5 times (a clockwise square pattern), then repeat. 
		*I set up 4 counters for each direction which all start with 5.
		*Each counter will count from 5 to 1 (one at a time).
		*For each counter, lion moves 1 square south for a total of 5.
		*Then go west 5 times.
		*Then go north 5 times. 
		*Then go east 5 times.
		*Finally reset all the counter to 5.
		*Return type: Direction
		*/
	 //
	 public Direction getMove()
	 {
		 if(countSouth < LOOPCOUNT+1 && countSouth > 0)
		 {
			countSouth --;
			direction = Direction.SOUTH;
			return direction;
		 }
		 else if(countWest < LOOPCOUNT+1 && countWest > 0)
		 {
			countWest --;
			direction = Direction.WEST;
			return direction;
		 }
		 else if(countNorth < LOOPCOUNT+1 && countNorth > 0)
		 {
			countNorth --;
			direction = Direction.NORTH;
			return direction;
		 }
		 else if (countEast < LOOPCOUNT+1 && countEast > 0)
		 {
			countEast --;
			direction = Direction.EAST;
			return direction;
		 }
		 countSouth = LOOPCOUNT-1;
		 countWest = LOOPCOUNT;
		 countNorth = LOOPCOUNT;
		 countEast = LOOPCOUNT;
		 return Direction.SOUTH;
	 }
	 /**
		*Name: public String toString() 
		*Purpose:  label lion as 'L'
		*Return type: String
		*/
	 public String toString() 
	 {
			return "L";
	 }
}