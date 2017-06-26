import java.awt.Color;
import java.util.Random;
/**
 *  Name: Ying Pei
 *  Date: May 16, 2017
 *  File: Dragon.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 6.
 *  This file has Dragon.java. Dragon is a java file 
 *  that has seven fields that construct a Dragon object.
 *  Specifically, the board stores information about 
 *  a Dragon. 
 *  The methods in which I override are 5 methods
 *  that have the same signature as the parent class
 *  public boolean eat()
 *  public Attack fight(String opponent)
 *  public Color getColor()
 *  public Direction getMove()
 *  public String toString()
 */



/**
 * Name:    Dragon.java
 * Purpose: To store information about the Dragon class
 */

public class Dragon extends Critter
{
	///fields
	protected int countFood;
	protected String previousOpp;
	protected static final int LOOPCOUNT = 5;
	protected int countSouth;
	protected int countWest;
	protected int countNorth;
	protected int countEast;
	protected Direction direction;
	protected Attack attack;

	
	///constructor
	/**
	 * Name: Dragon()
	 * Purpose: construct a dragon object
	 * Return type: none
	 */
	public Dragon()
	{
		Random number = new Random();
		int value = number.nextInt(3);
		if(value == 0)
		{
			previousOpp = "B";
		}
		if(value == 1)
		{
			previousOpp = "L";
		}
		if(value == 2)
		{
			previousOpp = "1";
		}	
		countSouth = 0;
		countWest = 0;
		countNorth = 0;
		countEast = 0;	
		countFood = 0;
		direction = Direction.SOUTH;
	}
	/**
	*Name: public Attack fight(String opponent)
	*Purpose: When the dragon encounters an animal of a different species, it will fight. 
	*The choice of attack will depend on the PREVIOUS animal that it encounters. 
	*If previous attacker was Bear, attack ROAR. If previous attacker was Lion, attack Pounce, 
	*else attack Scratch. The first attack is the randomized attack initialized 
	*when a Dragon object is created.
	*Return type: Attack
	*/
	public Attack fight(String opponent)
	{
		if(previousOpp.equals("B"))
		{
			attack = Attack.ROAR;
		}
		else if(previousOpp.equals("L"))
		{
			attack = Attack.POUNCE;
		}
		else if(!opponent.equals("1"))
		{
			attack = Attack.SCRATCH;
		}
		else
		{
			attack = Attack.FORFEIT;
		}
		previousOpp = opponent;
		return attack;	
	}
	/**
	*Name: public Color getColor()
	*Purpose: The dragon will change color depending on the food items that it consumes. 
	*If it has eaten an even number of food items, it will be black in color. 
	*If the dragon has eaten an odd number of food items, it will be white in color.
	*Return type: Color
	*/
	public Color getColor()
	{
		if(countFood % 2 == 1)
		{
			return Color.WHITE;
		}
		else
		{
			return Color.BLACK;
		}
	}
	/**
	*Name: public boolean eat()
	*Purpose: Dragon's eating behavior always return true
	*Return type: boolean
	*/
	public boolean eat()
	{
		countFood++;
		return true;
	}
	/**
	*Name: public Direction getMove()
	*Purpose: The initial direction of the dragon is WEST. 
	*In the subsequent moves, the dragon goes in a zig zag circle shape of diameter 10
	*I set up 4 different counters for 4 different direction
	*For each counter, the direction alternates between SW
	*If the counter reaches 5, it switches to the next counter and alternates SE
	*Then EN
	*Then NW.
	*Finally we reset all the counters to 0.
	*Return type: Direction
	*/
	public Direction getMove()
	{
		if(countSouth < LOOPCOUNT)
		{
			if(direction.equals(Direction.WEST))
			{
				direction = Direction.SOUTH;
				countSouth++;
				return direction;
			}
			else if(direction.equals(Direction.SOUTH))
			{
				direction = Direction.WEST;
				return direction;
			}
		}
		else if(countSouth == LOOPCOUNT)
		{
			direction = Direction.EAST;
			countSouth++;
			return Direction.CENTER;
		}
		
		else if(countEast < LOOPCOUNT)
		{
			if(direction.equals(Direction.SOUTH))
			{
				direction = Direction.EAST;
				countEast++;
				return direction;
			}
			else if(direction.equals(Direction.EAST))
			{
				direction = Direction.SOUTH;
				return direction;
			}
		}
		else if(countEast == LOOPCOUNT)
		{
			countEast ++;
			direction = Direction.NORTH;
			return Direction.CENTER;
		}
		else if(countNorth < LOOPCOUNT)
		{
			if(direction.equals(Direction.NORTH))
			{
				direction = Direction.EAST;
				return direction;
			}
			else if(direction.equals(Direction.EAST))
			{
				direction = Direction.NORTH;
				countNorth++;
				return direction;
			}
		}
		else if(countNorth == LOOPCOUNT)
		{
			countNorth ++;
			direction = Direction.WEST;
			return Direction.CENTER;
		}
		else if(countWest < LOOPCOUNT)
		{
			if(direction.equals(Direction.WEST))
			{
				direction = Direction.NORTH;
				return direction;
			}
			else if(direction.equals(Direction.NORTH))
			{
				direction = Direction.WEST;
				countWest++;
				return direction;
			}
		}
		else if(countWest == LOOPCOUNT)
		{
			countWest ++;
			direction = Direction.SOUTH;
			return Direction.CENTER;
		}
		else
		{
			countSouth = 0;
			countWest = 0;
			countNorth = 0;
			countEast = 0;	
			countFood = 0;
			direction = Direction.SOUTH;
		}
		return Direction.CENTER;
	}
	/**
	*Name: public String toString()
	*Purpose: To label the dragon object "D"
	*Return type: String
	*/
	public String toString()
	{
		return "D";
	}
}