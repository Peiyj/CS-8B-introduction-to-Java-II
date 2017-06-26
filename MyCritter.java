import java.awt.Color;
import java.util.Random;

/**
 *  Name: Ying Pei
 *  Date: May 16, 2017
 *  File: MyCritter.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 6.
 *  This file has MyCritter.java. MyCritter is a java file 
 *  that has a super constructor that constructs a MyCritter object.
 *  Specifically, the board stores information about 
 *  my own personal Critter. 
 *  The methods in which I override are 5 methods
 *  that have the same signature as the parent class
 *  public boolean eat()
 *  public Attack fight(String opponent)
 *  public Color getColor()
 *  public Direction getMove()
 *  public String toString()
 */
public class MyCritter extends Critter
{
	///fields

	public MyCritter()
	{
		super();
	}
	
	/**
	*Name: public Attack fight(String opponent) 
	*Purpose:  if opponent is a Lion ("L"), then roar (Attack.POUNCE);
	* if opponent is a bear ("B"), then Attack.ROAR. 
	* if the opponent is a tiger ("0"), then Attack.SCRATCH
	* if the opponent is a hungry tiger, then Attack.ROAR
	* Otherwise, randomize attack
	*Return type: Attack
	*/
	public Attack fight(String opponent)
	{
		//how to beat Lion
		if(opponent.equals("L"))
		{	
			return Attack.POUNCE;
		}
		//how to beat Bear
		else if(opponent.equals("B"))
		{
			return Attack.ROAR;
		}
		//how to beat Tiger
		else if(opponent.equals("0"))
		{
			return Attack.SCRATCH;
		}
	
		else if(opponent.equals("1"))
		{
			return Attack.ROAR;
		}
		else if(opponent.equals("2"))
		{
			return Attack.ROAR;
		}
		else if(opponent.equals("3"))
		{
			return Attack.ROAR;
		}
		else if(opponent.equals("4"))
		{
			return Attack.ROAR;
		}
		else if(opponent.equals("5"))
		{
			return Attack.ROAR;
		}
		else if(opponent.equals("6"))
		{
			return Attack.ROAR;
		}
		else if(opponent.equals("7"))
		{
			return Attack.ROAR;
		}
		else if(opponent.equals("8"))
		{
			return Attack.ROAR;
		}
		else if(opponent.equals("9"))
		{
			return Attack.ROAR;
		}
		//otherwise, randomize the attack
		else
		{
			Random number = new Random();
			int value = number.nextInt(3);
			if(value == 0)
			{
				return Attack.ROAR;
			}
			else if(value == 1)
			{
				return Attack.SCRATCH;
			}
			else
			{
				return Attack.POUNCE;
			}
		}
	}
	/**
	*Name: public boolean eat()
	*Purpose: always eats
	*Return type: boolean
	*/
	public boolean eat()
	{
		return true;
	}
	/**
	*Name: public Direction getMove()
	*Purpose: the movement is randomized based on a random number
	*generator. If the number is 1, move north. If the number is 2
	*move south. If the number is 3, move east. If the number is 4, move west.
	*Otherwise, stay where it is.
	*Return type: Direction
	*/
	public Direction getMove()
	{
		Random number = new Random();
		int value = number.nextInt(4);
		if(value == 0)
		{
			return Direction.NORTH;
		}
		else if(value == 1)
		{
			return Direction.SOUTH;
		}
		else if(value == 2)
		{
			return Direction.EAST;
		}
		else if(value == 3)
		{
			return Direction.WEST;
		}
		else
		{
			return Direction.CENTER;
		}	
	}
	/**
	*Name: public Color getColor() 
	*Purpose: the color is randomized based on a random number
	*generator. If the number is 0, return Color.darkGray. If the number is 1
	*return Color.blue. If the number is 2, return Color.green. If the number is 3, 
	*return Color.PINK.
	*Otherwise, return Color.ORANGE.
	*Return type: Color
	*/
	public Color getColor() 
	{
		Random number = new Random();
		int value = number.nextInt(4);
		if(value == 0)
		{
			return Color.darkGray;
		}
		else if(value == 1)
		{
			return Color.blue;
		}
		else if(value == 2)
		{
			return Color.green;
		}
		else if(value == 3)
		{
			return Color.PINK;
		}
		else
		{
			return Color.ORANGE;
		}
	}
	/**
	*Name: public String toString() 
	*Purpose: to label MyCritter as "*"
	*Return type: String
	*/
	
	public String toString()
	{
			return "B";
	}


	

	
}