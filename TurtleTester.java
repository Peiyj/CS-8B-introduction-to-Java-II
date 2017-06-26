/**
 *  Name: Ying Pei
 *  Date: May 31, 2017
 *  File: TurtleTester.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 8.
 *  TurtleTester is a tester file 
 *  that tests the functionality of the 
 *  TurtleRecursion.java file
 * 
 */

/**
 * Name:    TurtleTester.java
 * Purpose: To test the functionality of the turtle object
 */
public class TurtleTester {
    public static void main(String[] args) {
        try {
            World world = new World();
            Turtle turtle = new Turtle(world);
            TurtleRecursion.spiral(turtle, 1, -45, 1.1);
        } catch (Exception e) {
            System.out.println("spiral method raised an exception");
            e.printStackTrace();
        }

        try {
            World world = new World();
            Turtle turtle = new Turtle(world);

            // Place turtle at the bottom of the window
            turtle.penUp();
            turtle.moveTo(turtle.getXPos(), world.getHeight());
            turtle.penDown();

            TurtleRecursion.tree(turtle, 256, 7);
        } catch (Exception e) {
            System.out.println("tree method raised an exception");
            e.printStackTrace();
        }

        try {
            World world = new World();
            Turtle turtle = new Turtle(world);
            TurtleRecursion.snowflake(turtle, 200, 3);
        } catch (Exception e) {
            System.out.println("snowflake method raised an exception");
            e.printStackTrace();
        }
    }
}
