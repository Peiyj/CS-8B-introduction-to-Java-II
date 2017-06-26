/**
 *  Name: Ying Pei
 *  Date: June 07, 2017
 *  File: CipherTurtleMT.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 9.
 *  CipherTurtleMT is a java file 
 *  that constructs Turtle and 
 *  world objects. Moreover, it 
 *  has one method that asks 
 *  the turtle to draw the encrypted
 *  letters. However, rather than one
 *  turtle, it uses multiple turtle
 *  via multi-threading.
 *  
 */

/**
 * Name:    CipherTurtleMT.java
 * Purpose: To construct a turtle object and method
 */

import turtleClasses.Turtle;
import turtleClasses.World;

import java.awt.*;

public class CipherTurtleMT extends Turtle implements Runnable
{
  private final static int HALF_CHAR_WIDTH = 20;
  private final static int CHAR_WIDTH = 40;
  private final static int LINE_HEIGHT = 80;
  private final static int CHAR_PADDING = 40;
  private final static int LINE_PADDING = 40;
  private final static int LINE_SPACE = LINE_HEIGHT + CHAR_PADDING;
  
  private final static int TURN_DEGREE_ONE = 120;
  private final static int TURN_DEGREE_W_L = 86;
  private final static int TURN_DEGREE_W_S = 53;
  private final static int W_LONG_LEG = 80;
  private final static int W_SHORT_LEG = 25;
  private final static int TURN_DEGREE_Q = 45;
  private final static int TURN_DEGREE_N = 63;
  private final static int N_SLOPE = 89;
  private final static int TURN_DEGREE_R = 45;
  private final static int R_SLOPE = 56;


// We expect you to use these constants: 

  private final static int CHAR_SPACE = CHAR_WIDTH + LINE_PADDING;

  /*  DO NOT CHANGE FOR PARTS 1A AND 1B
   *  But you may wish to change these in the extra credit.
   */
  private final static int WORLD_WIDTH = 800;
  private final static int WORLD_HEIGHT = 120;

 /*
  * Delay between turtle actions (turns, moves) in milliseconds.
  * CHANGE THIS VALUE TO OPTIMIZE VISIBILITY AND SPEED. 
  * Make sure that it is set back to 30 when you submit. 
  * 1000 = 1 sec. / 100 = 0.1 sec.
  */
/**************************************/
  private final static int DELAY = 30;
/**************************************/



// These instance variables may or may not be extremely important for 
// passing values through to run. Feel free to add more instance vars. 
  private char ch;
  private int x = CHAR_PADDING;
  private int y = CHAR_PADDING;

  /**  
   * method header: CipherTurtleMT(World w, char ch, int x, int y, int rotation, int delay)
   * purpose: To construct a turtle object. 
   * Return type: no return type (constructor only)
   */
  public CipherTurtleMT(World w, char ch, int x, int y, int rotation, int delay){
    super(w, delay);
    setPenWidth(10);
    setPenColor(Color.BLUE);
    this.x = x;
    this.y = y;
    this.ch = ch;
    letterOperationMT(rotation);
  }
  


  /* TODO */
  /** DO NOT CALL THIS METHOD DIRECTLY */
  public void run() {
    switch(ch)
    {
      case 'A': this.drawA(x,y); break;
      case 'B': this.drawB(x,y); break;
      case 'C': this.drawC(x,y); break;
      case 'D': this.drawD(x,y); break;
      case 'E': this.drawE(x,y); break;
      case 'F': this.drawF(x,y); break;
      case 'G': this.drawG(x,y); break;
      case 'H': this.drawH(x,y); break;
      case 'I': this.drawI(x,y); break;
      case 'J': this.drawJ(x,y); break;
      case 'K': this.drawK(x,y); break;
      case 'L': this.drawL(x,y); break;
      case 'M': this.drawM(x,y); break;
      case 'N': this.drawN(x,y); break;
      case 'O': this.drawO(x,y); break;
      case 'P': this.drawP(x,y); break;
      case 'Q': this.drawQ(x,y); break;
      case 'R': this.drawR(x,y); break;
      case 'S': this.drawS(x,y); break;
      case 'T': this.drawT(x,y); break;
      case 'U': this.drawU(x,y); break;
      case 'V': this.drawV(x,y); break;
      case 'W': this.drawW(x,y); break;
      case 'X': this.drawX(x,y); break;
      case 'Y': this.drawY(x,y); break;
      case 'Z': this.drawZ(x,y); break;
    }
  }


/**  
 * method header: encryptMT(String s, int rotation) 
 * purpose: To implement the encryptMT method, the conditions for allowed Strings 
 * is the same as Part 1A: non-empty Strings containing capital letters only. 
 * The difference here is that for each character that gets encrypted,
 * a NEW Turtle will be assigned that letter for drawing. 
 * Return type: void
 */
private static void encryptMT(String s, int rotation) 
{
	  World world = new World(WORLD_WIDTH, WORLD_HEIGHT);
	  for(int i = 0; i < s.length(); i++)
	  {
		  Runnable turtle = new CipherTurtleMT(world, s.charAt(i), CHAR_PADDING + i*CHAR_SPACE, CHAR_PADDING, rotation, DELAY);
		  if(!Character.isUpperCase(letterOperation(s.charAt(i), rotation)))
		  {
			  System.err.println("Error! The input is invalid!");
			  //return from the method
			  return; 
		  }   
		  Thread thread = new Thread(turtle);
		  thread.start();
	  }
}

/*
* Name: letterOperationMT
* Purpose: This method will encrypt a single character.
* Parameters: Integer rotation is the value to rotate a character by.
*/
private void letterOperationMT(int rotation) {
	int num = (int)this.ch;

	if(num <=(int)'Z' && num >=(int)'A')
	{
		num+=(rotation%26);
		if(num > (int)'Z')
			num-=26;
		else if (num < (int)'A')
			num+=26;
		if(num < 'A' || num > 'Z'){
			System.err.println("ERROR - char is "+num);
			return;
		}
	}
	this.ch = (char) num;
}

/**
 *method header: letterOperation(char original, int rotation) 
 *purpose:this is a helper method that aids the encryptMT method to
 *encrypt a single character.
 *Return type: char
 */
private static char letterOperation(char original, int rotation) 
{
  if (!Character.isLetter(original)) return original;
  int mod = ((rotation % 26) + 26) % 26;
  if (Character.isUpperCase(original)) {
    return (char) ('A' + ((original - 'A' + mod) % 26));
  } else {
    return (char) ('a' + ((original - 'a' + mod) % 26));
  }
}


/* TODO */
public static void main(String [] args) 
{ 
	encryptMT("ENCRYPTION", 16);
	
}


/* We have copied the drawA to drawZ methods here from CipherTurtle */ 
/*
  * Name: drawA
  * Purpose: This method will draw letter A.
  * Parameters: Integer x is x-coordinate of upper left corner of A.
  *             Integer y is y-coordinate of upper left corner of A.
  * Return: void.
  */
  private void drawA(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x + CHAR_WIDTH, y);
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT);
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT / 2);
    moveTo(x, y + LINE_HEIGHT / 2);
    moveTo(x, y);
    moveTo(x, y + LINE_HEIGHT);
  }

  /*
  * Name: drawB
  * Purpose: This method will draw letter B.
  * Parameters: Integer x is x-coordinate of upper left corner of B.
  *             Integer y is y-coordinate of upper left corner of B.
  * Return: void.
  */
  private void drawB(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x + CHAR_WIDTH, y + CHAR_WIDTH / 2);
    moveTo(x, y + CHAR_WIDTH);
    moveTo(x + CHAR_WIDTH, y + 3 * CHAR_WIDTH / 2);
    moveTo(x, y + LINE_HEIGHT);
    moveTo(x, y);
  }

  /*
  * Name: drawC
  * Purpose: This method will draw letter C.
  * Parameters: Integer x is x-coordinate of upper left corner of C.
  *             Integer y is y-coordinate of upper left corner of C.
  * Return: void.
  */
  private void drawC(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH);
    turnRight();
    penDown();
    forward(LINE_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH);
  }

  /*
  * Name: drawD
  * Purpose: This method will draw letter D
  * Parameters: Integer x is x-coordinate of upper left corner of D.
  *             Integer y is y-coordinate of upper left corner of D.
  * Return: void.
  */
  private void drawD(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x + CHAR_WIDTH / 2, y);
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT / 2);
    moveTo(x + CHAR_WIDTH / 2, y + LINE_HEIGHT);
    moveTo(x, y + LINE_HEIGHT);
    moveTo(x, y);
  }

  /*
  * Name: drawE
  * Purpose: This method will draw letter E.
  * Parameters: Integer x is x-coordinate of upper left corner of E.
  *             Integer y is y-coordinate of upper left corner of E.
  * Return: void.
  */
  private void drawE(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos(), getYPos() + 1); // face down
    penDown();
    forward(LINE_HEIGHT);
    penUp();
    moveTo(x, y);
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    penUp();
    moveTo(x, y + LINE_HEIGHT / 2);
    penDown();
    forward(CHAR_WIDTH);
    penUp();
    moveTo(x, y + LINE_HEIGHT);
    penDown();
    forward(CHAR_WIDTH);
  }

  /*
  * Name: drawF
  * Purpose: This method will draw letter F.
  * Parameters: Integer x is x-coordinate of upper left corner of F.
  *             Integer y is y-coordinate of upper left corner of F.
  * Return: void.
  */
  private void drawF(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x + CHAR_WIDTH, y);
    moveTo(x, y);
    moveTo(x, y + LINE_HEIGHT);
    moveTo(x, y + LINE_HEIGHT / 2);
    moveTo(x + CHAR_WIDTH / 2, y + LINE_HEIGHT / 2);
  }

  /*
  * Name: drawG
  * Purpose: This method will draw letter G.
  * Parameters: Integer x is x-coordinate of upper left corner of G.
  *             Integer y is y-coordinate of upper left corner of G.
  * Return: void.
  */
  private void drawG(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH);
    turnRight();
    penDown();
    forward(LINE_HEIGHT);
    turnLeft();
    forward(CHAR_WIDTH);
    turnLeft();
    forward(CHAR_WIDTH);
    turnLeft();
    forward(HALF_CHAR_WIDTH);
  }

  /*
  * Name: drawH
  * Purpose: This method will draw letter H.
  * Parameters: Integer x is x-coordinate of upper left corner of H.
  *             Integer y is y-coordinate of upper left corner of H.
  * Return: void.
  */
  private void drawH(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x, y + LINE_HEIGHT);
    moveTo(x, y + LINE_HEIGHT / 2);
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT / 2);
    moveTo(x + CHAR_WIDTH, y);
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT);
  }

  /*
  * Name: drawI
  * Purpose: This method will draw letter I.
  * Parameters: Integer x is x-coordinate of upper left corner of I.
  *             Integer y is y-coordinate of upper left corner of I.
  * Return: void.
  */
  private void drawI(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH / 2);
    turnRight();
    forward(LINE_HEIGHT);
    turnRight();
    forward(CHAR_WIDTH / 2);
    backward(CHAR_WIDTH);
  }

  /*
  * Name: drawJ
  * Purpose: This method will draw letter J.
  * Parameters: Integer x is x-coordinate of upper left corner of J.
  *             Integer y is y-coordinate of upper left corner of J.
  * Return: void.
  */
  private void drawJ(int x, int y)
  {
    penUp();
    moveTo(x + CHAR_WIDTH, y);
    penDown();
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT);
    moveTo(x, y + LINE_HEIGHT);
    moveTo(x, y + LINE_HEIGHT / 2);
  }

  /*
  * Name: drawK
  * Purpose: This method will draw letter K.
  * Parameters: Integer x is x-coordinate of upper left corner of K.
  *             Integer y is y-coordinate of upper left corner of K.
  * Return: void.
  */
  private void drawK(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x, y + LINE_HEIGHT);
    moveTo(x, y + LINE_HEIGHT / 2);
    moveTo(x + CHAR_WIDTH, y);
    moveTo(x, y + LINE_HEIGHT / 2);
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT);
  }

  /*
  * Name: drawL
  * Purpose: This method will draw letter L.
  * Parameters: Integer x is x-coordinate of upper left corner of L.
  *             Integer y is y-coordinate of upper left corner of L.
  * Return: void.
  */
  private void drawL(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x, y + LINE_HEIGHT);
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT);
  }

  /*
  * Name: drawM
  * Purpose: This method will draw letter M.
  * Parameters: Integer x is x-coordinate of upper left corner of M.
  *             Integer y is y-coordinate of upper left corner of M.
  * Return: void.
  */
  private void drawM(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x, y + LINE_HEIGHT);
    moveTo(x, y);
    moveTo(x + CHAR_WIDTH / 2, y + LINE_HEIGHT / 2);
    moveTo(x + CHAR_WIDTH, y);
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT);
  }

  /*
  * Name: drawN
  * Purpose: This method will draw letter N.
  * Parameters: Integer x is x-coordinate of lower left corner of N.
  *             Integer y is y-coordinate of lower left corner of N.
  * Return: void.
  */
  private void drawN(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos(), getYPos() - 1); // face up
    penDown();
    backward(LINE_HEIGHT);
    forward(LINE_HEIGHT);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turn(TURN_DEGREE_N);
    forward(N_SLOPE);
    turnToFace(getXPos(), getYPos() - 1); // face up
    forward(LINE_HEIGHT);
  }

  /*
  * Name: drawO
  * Purpose: This method will draw letter O.
  * Parameters: Integer x is x-coordinate of upper left corner of O.
  *             Integer y is y-coordinate of upper left corner of O.
  * Return: void.
  */
  private void drawO(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x + CHAR_WIDTH, y);
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT);
    moveTo(x, y + LINE_HEIGHT);
    moveTo(x, y);
  }


  /*
  * Name: drawP
  * Purpose: This method will draw letter P.
  * Parameters: Integer x is x-coordinate of upper left corner of P.
  *             Integer y is y-coordinate of upper left corner of P.
  * Return: void.
  */
  private void drawP(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos(), getYPos() + 1); // face down
    penDown();
    forward(LINE_HEIGHT);
    penUp();
    moveTo(x, y);
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    turnRight();
    forward(LINE_HEIGHT / 2);
    turnRight();
    forward(CHAR_WIDTH);
  }

  /*
  * Name: drawQ
  * Purpose: This method will draw letter Q.
  * Parameters: Integer x is x-coordinate of upper left corner of Q.
  *             Integer y is y-coordinate of upper left corner of Q.
  * Return: void.
  */
  private void drawQ(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    turnRight();
    forward(LINE_HEIGHT);
    turnRight();
    turn(TURN_DEGREE_Q);
    forward(CHAR_WIDTH / 2);
    backward(CHAR_WIDTH / 2);
    turn(-TURN_DEGREE_Q);
    forward(CHAR_WIDTH);
    turnRight();
    forward(LINE_HEIGHT);
  }

  /*
  * Name: drawR
  * Purpose: This method will draw letter R.
  * Parameters: Integer x is x-coordinate of upper left corner of R.
  *             Integer y is y-coordinate of upper left corner of R.
  * Return: void.
  */
  private void drawR(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos(), getYPos() + 1); // face down
    penDown();
    forward(LINE_HEIGHT);
    penUp();
    moveTo(x, y);
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    turnRight();
    forward(LINE_HEIGHT / 2);
    turnRight();
    forward(CHAR_WIDTH);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turn(TURN_DEGREE_R);
    forward(R_SLOPE);
  }

  /*
  * Name: drawS
  * Purpose: This method will draw letter S.
  * Parameters: Integer x is x-coordinate of upper left corner of S.
  *             Integer y is y-coordinate of upper left corner of S.
  * Return: void.
  */
  private void drawS(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH);
    turnRight();
    forward(LINE_HEIGHT / 2);
    turnLeft();
    forward(CHAR_WIDTH);
    turnRight();
    forward(LINE_HEIGHT / 2);
    turnRight();
    forward(CHAR_WIDTH);
  }

  /*
  * Name: drawT
  * Purpose: This method will draw letter T.
  * Parameters: Integer x is x-coordinate of upper left corner of T.
  *             Integer y is y-coordinate of upper left corner of T.
  * Return: void.
  */
  private void drawT(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    penDown();
    forward(CHAR_WIDTH);
    backward(CHAR_WIDTH / 2);
    turnRight();
    forward(LINE_HEIGHT);
  }

  /*
  * Name: drawU
  * Purpose: This method will draw letter U.
  * Parameters: Integer x is x-coordinate of upper left corner of U.
  *             Integer y is y-coordinate of upper left corner of U.
  * Return: void.
  */
  private void drawU(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x, y + LINE_HEIGHT);
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT);
    moveTo(x + CHAR_WIDTH, y);
  }

  /*
  * Name: drawV
  * Purpose: This method will draw letter V.
  * Parameters: Integer x is x-coordinate of upper left corner of V.
  *             Integer y is y-coordinate of upper left corner of V.
  * Return: void.
  */
  private void drawV(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x + CHAR_WIDTH / 2, y + LINE_HEIGHT);
    moveTo(x + CHAR_WIDTH, y);
  }

  /*
  * Name: drawW
  * Purpose: This method will draw letter W.
  * Parameters: Integer x is x-coordinate of upper left corner of W.
  *             Integer y is y-coordinate of upper left corner of W.
  * Return: void.
  */
  private void drawW(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    turnToFace(getXPos() + 1, getYPos()); // face right
    turn(TURN_DEGREE_W_L); // turn at an angle to draw the long leg of W
    penDown();
    forward(W_LONG_LEG);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turn(-TURN_DEGREE_W_S); // turn at an angle to draw the short leg of W
    forward(W_SHORT_LEG);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turn(TURN_DEGREE_W_S); // turn at an angle to draw the short leg of W
    forward(W_SHORT_LEG);
    turnToFace(getXPos() + 1, getYPos()); // face right
    turn(-TURN_DEGREE_W_L); // turn at an angle to draw the long leg of W
    forward(W_LONG_LEG);
  }

  /*
  * Name: drawX
  * Purpose: This method will draw letter X.
  * Parameters: Integer x is x-coordinate of upper left corner of X.
  *             Integer y is y-coordinate of upper left corner of X.
  * Return: void.
  */
  private void drawX(int x, int y)
  {
    penUp();
    moveTo(x, y); // always start in upper left corner of this char block
    penDown();
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT);
    penUp();
    moveTo(x + CHAR_WIDTH, y);
    penDown();
    moveTo(x, y + LINE_HEIGHT);
  }

  /*
  * Name: drawY
  * Purpose: This method will draw letter Y.
  * Parameters: Integer x is x-coordinate of upper left corner of Y.
  *             Integer y is y-coordinate of upper left corner of Y.
  * Return: void.
  */
  private void drawY(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x + CHAR_WIDTH / 2, y + LINE_HEIGHT / 2);
    moveTo(x + CHAR_WIDTH / 2, y + LINE_HEIGHT);
    moveTo(x + CHAR_WIDTH / 2, y + LINE_HEIGHT / 2);
    moveTo(x + CHAR_WIDTH, y);
  }

  /*
  * Name: drawZ
  * Purpose: This method will draw letter Z.
  * Parameters: Integer x is x-coordinate of upper left corner of Z.
  *             Integer y is y-coordinate of upper left corner of Z.
  * Return: void.
  */
  private void drawZ(int x, int y)
  {
    penUp();
    moveTo(x, y);
    penDown();
    moveTo(x + CHAR_WIDTH, y);
    moveTo(x, y + LINE_HEIGHT);
    moveTo(x + CHAR_WIDTH, y + LINE_HEIGHT);
  }


} // End of public class CipherTurtle extends Turtle