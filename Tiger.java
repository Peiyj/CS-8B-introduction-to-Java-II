import java.awt.Color;
import java.util.Random;


/**
 *  Name: Ying Pei
 *  Date: May 16, 2017
 *  File: Tiger.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 6.
 *  This file has Tiger.java. Tiger is a java file 
 *  that has three fields that constructs a Tiger object.
 *  Specifically, the board stores information about 
 *  Tiger. 
 *  The methods in which I override are 5 methods
 *  that have the same signature as the parent class
 *  public boolean eat()
 *  public Attack fight(String opponent)
 *  public Color getColor()
 *  public Direction getMove()
 *  public String toString()
 */

public class Tiger extends Critter
{
	///fields
	protected int hungeryTimes;
	protected int randomDirection;
	//This is the constant I created for counting the loops
	protected static final int LOOPCOUNT = 3;
	protected Direction direction;
	///constructor
	 public Tiger(int hunger)
	 {
		hungeryTimes = hunger;
		randomDirection = 0;
	
	 }
	 
	 /**
		*Name: public Color getColor()
		*Purpose: The color is always yellow
		*Return type: Color
		*/
	 public Color getColor() 
	 {
		return Color.YELLOW;
	 }
	 /**
		*Name:  public boolean eat() 
		*Purpose: eating behavior: returns true the first hunger times it is called
		*(when num of hungryTimes > 0), and false after that
		*Return type: boolean
		*/

	 public boolean eat() 
	 {
		if(hungeryTimes == 0)
		{
			return false;
		}
		else if(hungeryTimes > 0)
		{
			hungeryTimes--;
			return true;
		}
		return false;
	 }
	 /**
		*Name: public Attack fight(String opponent) 
		*Purpose: if this Tiger is hungry (hungeryTimes > 0), then scratch (Attack.SCRATCH); 
		*else pounce (Attack.POUNCE). 
		*Return: Attack
		*/
	 public Attack fight(String opponent) 

	 {
		 if(hungeryTimes > 0)
		 {
			 return Attack.SCRATCH;
		 }
		 else
		 {
			 return Attack.POUNCE;
		 }
	 }
	 /**
		*Name: public Direction getMove()
		*Purpose: Chooses a random direction dir(north, south, east, or west) 
		*and moves in that direction for 3 subsequent calls to move function. 
		*Then chooses a new random direction and repeats. 
		*Return type: Direction
		*/
	 public Direction getMove()
	 {
		if(direction == null || randomDirection == 0)
		{
			randomDirection = LOOPCOUNT;
			Random number = new Random();
			int value = number.nextInt(4);
			if(value == 0)
			{
				randomDirection --;
				direction = Direction.EAST;
				return direction; 
			}
			if(value == 1)
			{
				randomDirection --;
				direction = Direction.WEST;
				return direction;
			}
			if(value == 2)
			{
				randomDirection --;
				direction = Direction.NORTH;
				return direction;
			}
			if(value == 3)
			{
				randomDirection --;
				direction = Direction.SOUTH;
				return direction;
			}
		}
		if(randomDirection > 0 && randomDirection < 3)
		{
			randomDirection--;
			return direction;
		}
		return direction;
	 }
	 /**
		*Name: 	public String toString() 
		*Purpose: to Label tiger in terms of how many times
		*it is hungry
		*Return type: String
		*/
	 public String toString() 
	 {
		 return hungeryTimes + "";
	 }
}