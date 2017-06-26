/**
 *  Name: Ying Pei
 *  Date: May 31, 2017
 *  File: TurtleRecursion.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 8.
 *  TurtleRecursion is a java file 
 *  that has two of the three methods implemented using recursion.
 *  Specifically, these two methods allow the turtle do some cool
 *  pattern.
 *  
 */

/**
 * Name:    TurtleRecursion.java
 * Purpose: To store functionality of the turtle object
 */
import java.lang.Object;

public class TurtleRecursion {

	/**
	 * method header: spiral(Turtle turtle, double initialLength, int angle, double multiplier)
	 * Purpose: The function takes as argument as a drawing turtle to create lines, 
	 * an initialLength of the spiral's first line segment, 
	 * an angle specifying the degree of the angle formed by neighboring segments, and
	 * a multiplier indicating how each segment changes in size from the previous one.
	 * Then the method asks the turtle to draw spirals using recursion.
	 * Return type: void
	 */
    public static void spiral(Turtle turtle, double initialLength, int angle, double multiplier) 
    {
    	if((int)initialLength == 0 ||(int)initialLength >= 200)
    	{
    		return;
    	}
    	turtle.forward((int)initialLength);
    	turtle.turn(angle);
    	spiral(turtle, initialLength * multiplier, angle, multiplier);
    }

    /**
	 * method header: tree(Turtle turtle, int trunkLength, int height) 
	 * Purpose: The function takes as arguments
	 * a drawing turtle to create lines,
	 * a trunkLength which is the length of the main trunk of the tree, and
	 * the height indicating the number of levels of branching of the tree.
	 * It draws a tree pattern on the world object in the tester file
	 * Return type: void
	 */
    public static void tree(Turtle turtle, int trunkLength, int height) 
    {
    	if(height == 0)
    	{
    		return;
    	}
    	else
    	{
    		turtle.forward(trunkLength);
    		turtle.turn(-45);
    		tree(turtle, (int)(trunkLength * 0.5), height - 1);
    		turtle.turn(90);
    		tree(turtle, (int)(trunkLength * 0.5), height - 1);
    		turtle.turn(-45);
    		turtle.backward(trunkLength);
    	}
    }

    /**
     * TODO: Implement method and complete this header comment
     *
     * @param turtle
     * @param sideLength
     * @param levels
     */
    public static void snowflake(Turtle turtle, int sideLength, int levels) 
    {
    	
    }

}
