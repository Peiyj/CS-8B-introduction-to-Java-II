
/**
 *  Name: Ying Pei
 *  Date: May 10, 2017
 *  File: Board.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 5.
 *  This file has class Board. Board is a java file 
 *  that has six fields that construct a board object.
 *  Specifically, the board is a m * n matrix 
 *  The methods in which I implement are 8 helper methods
 *  The first four helper methods aim to 
 *  help determine if the board can move in the passed in each direction
 *  The last four helper methods aim to 
 *  perform the main game logic and perform a move in each direction
 */

/**
 * Name:    Board.java
 * Purpose: To store information about the board class
 */

import java.util.Random;
import java.util.*;

public class Board {
    /**
     * Number of tiles showing when the game starts
     */
    public final int NUM_START_TILES = 2;

    /**
     * The probability (times 100) that a randomly
     * generated tile will be a 2 (vs a 4)
     */
    public final int TWO_PROBABILITY = 90;

    /**
     * The size of the grid
     */
    public final int GRID_SIZE;

    private int[][] grid;  // The grid of tile values
    private int score;     // The current score

    // You do not have to use these variables
    private final Random random;    // A random number generator (for testing)

    /**
     * Name: Board(Random random, int boardSize).
     * 
     * Purpose: The purpose of this method is to create or construct a fresh
     * board for the user with two random tiles places within the board. This
     * board will have a particular boardSize that the user sets, as well as a
     * random
     *
     * @param boardSize size of the 2048 game board to be used.
     * @param random    Random random represents the random number which 
     *                  be used to specific where (after every move) a 
     *                  new tile should be added to the board when playing.
     */
    public Board(Random random, int boardSize) {
        if (boardSize < 2) boardSize = 4;

        // initialize member variables
        this.random = random;
        this.GRID_SIZE = boardSize;
        this.grid = new int[boardSize][boardSize];
        this.score = 0;

        // loop through and add two initial tiles to the board randomly
        for (int index = 0; index < NUM_START_TILES; index++) {
            addRandomTile();
        }
    }


    /**
     * Constructor used to load boards for grading/testing
     * 
     * THIS IS USED FOR GRADING - DO NOT CHANGE IT
     *
     * @param random
     * @param inputBoard
     */
    public Board(Random random, int[][] inputBoard) {
        this.random = random;
        this.GRID_SIZE = inputBoard.length;
        this.grid = new int[GRID_SIZE][GRID_SIZE];
        for (int r = 0; r < GRID_SIZE; r++) {
            for (int c = 0; c < GRID_SIZE; c++) {
                this.grid[r][c] = inputBoard[r][c];
            }
        }
    }

    /**
     * return the tile value in a particular cell in the grid.
     *
     * @param row The row
     * @param col The column
     * @return The value of the tile at (row, col)
     */
    public int getTileValue(int row, int col) {
        return grid[row][col];
    }

    /**
     * Get the current score
     *
     * @return the current score of the game
     */
    public int getScore() {
        return score;
    }

    /**
     * Name: addRandomTile()
     * 
     * Purpose: The purpose of this method is to add a random tile of either
     * value 2 or 4 to a random empty space on the 2048
     * board. The place where this tile is added is dependent on the random
     * value associated with each board object. If no tiles are empty, it
     * returns without changing the board.
     */
    public void addRandomTile() {
        int count = 0;
        // loop through grid keeping count of every empty space on board
        for (int rowI = 0; rowI < grid.length; rowI++) {
            for (int colI = 0; colI < grid[rowI].length; colI++) {
                if (grid[rowI][colI] == 0) {
                    count++;
                }
            }
        }

        // if count is still 0 after loop, no empty spaces, return
        if (count == 0) {
            System.out.println("There are no empty spaces!");
            return;
        }

        // keep track of where on board random tile should be placed
        int location = random.nextInt(count);
        int value = random.nextInt(100);

        // reset count
        count = 0;
        // loop through grid checking where grid is 0 & incrementing count
        for (int rowI = 0; rowI < grid.length; rowI++) {
            for (int colI = 0; colI < grid[rowI].length; colI++) {
                if (grid[rowI][colI] == 0) {
                    // if count equals random location generated, place tile
                    if (count == location) {
                        System.out.println("Adding a tile to location " + rowI + ", " + colI);
                        if (value < TWO_PROBABILITY) {
                            grid[rowI][colI] = 2;
                        } else {
                            grid[rowI][colI] = 4;
                        }
                    }
                    count++;
                }
            }
        }
    }

    /**
     * Name: isGameOver()
     * <p>
     * Purpose: The purpose of this method is to check whether or not the game
     * in play is over. The game is officially over once there are no longer any
     * valid moves that can be made in any direction. If the game is over, this
     * method will return true and print the words: "Game Over!" This method
     * will be checked before any movement is ever made.
     *
     * @return true if the game is over, and false if the game isn't over
     */
    public boolean isGameOver() {
        return (!canMoveLeft() && !canMoveRight() && !canMoveUp()
                && !canMoveDown());
    }


    /**
     * Name: canMove(Direction direction)
     * 
     * Purpose: The purpose of this method is to check to see if the movement of
     * the tiles in any direction can actually take place. It does not move the
     * tiles, but at every index of the grid, checks to see if there is a tile
     * above, below, to the left or right that has the same value. If this is
     * the case, then that tile can be moved. It also checks if there is an
     * empty (0) tile at a specified index, as this also indicates that movement
     * can be possible. This method is called within move() so that that method
     * can determine whether or not tiles should be moved.
     *
     * @param direction direction the tiles will move (if possible)
     * @return true if the movement can be done and false if it cannot
     */
    public boolean canMove(Direction direction) 
    {
        // utilize helper methods to check if movement in a particular
        // direction is possible
    	if(direction == null) return false; //LINE TO BE ADDED
        switch (direction) {
            case UP:
                return canMoveUp();
            case RIGHT:
                return canMoveRight();
            case DOWN:
                return canMoveDown();
            case LEFT:
                return canMoveLeft();
            default:
                // If we got here, something went wrong, so return false
                return false;
        }
    }

    /**
     * Name: move(Direction direction)
     * 
     * Purpose: The purpose of this method is to move the tiles in the game
     * board by a specified direction passed in as a parameter. If the movement
     * cannot be done, the method returns false. If the movement can be done, it
     * moves the tiles and returns true. This method relies on the help of four
     * other helper methods to perform the game play.
     *
     * @param direction direction the tiles will move (if possible)
     * @return true if the movement can be done and false if it cannot
     */
    public boolean move(Direction direction) {
        // if canMove is false, exit and don't move tiles
        if (!canMove(direction)) return false;

        // move in relationship to the direction passed in
        switch (direction) {
            case UP:
                moveUp();
                break;
            case RIGHT:
                moveRight();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            default:
                // This should never happen
                return false;
        }

        return true;
    }

    /**
     *Name: moveRight()
     *Purpose: This is a helper method that performs the main game logic 
     *and perform a move in the right direction. It first creates an int array 
     *copy of the grid. Then we loop through the each row, while doing so, we 
     *create an arraylist to store these integers. Then we ilterate through the
     *arraylist and perform merging if two numbers are found to be the same. Finally
     *we add all the arraylists elements. If the arraylist is empty, we add the remaining
     *zeros.
     */
    private void moveRight() 
    {
    	rotate(true);
    	moveDown();
    	rotate(false);
    }

    /**
     *Name: moveLeft()
     *Purpose: This is a helper method that performs the main game logic 
     *and perform a move in the left direction. It first creates an int array 
     *copy of the grid. Then we loop through the each row, while doing so, we 
     *create an arraylist to store these integers. Then we ilterate through the
     *arraylist and perform merging if two numbers are found to be the same. Finally
     *we add all the arraylists elements. If the arraylist is empty, we add the remaining
     *zeros.
     */
    private void moveLeft() 
    {
    	rotate(false);
    	moveDown();
    	rotate(true);
    }
    /**
     *Name: moveUp()
     *Purpose: This is a helper method that performs the main game logic 
     *and perform a move in the up direction. It first creates an int array 
     *copy of the grid. Then we loop through the each column, while doing so, we 
     *create an arraylist to store these integers. Then we ilterate through the
     *arraylist and perform merging if two numbers are found to be the same. Finally
     *we add all the arraylists elements. If the arraylist is empty, we add the remaining
     *zeros.
     */
    private void moveUp() 
    {
    	rotate(true);
    	rotate(true);
    	moveDown();
    	rotate(true);
    	rotate(true);
    }
    /**
     *Name: moveDown()
     *Purpose: This is a helper method that performs the main game logic 
     *and perform a move in the down direction. It first creates an int array 
     *copy of the grid. Then we loop through the each column, while doing so, we 
     *create an arraylist to store these integers. Then we ilterate through the
     *arraylist and perform merging if two numbers are found to be the same. Finally
     *we add all the arraylists elements. If the arraylist is empty, we add the remaining
     *zeros.
     */
    private void moveDown()
    {
    	//create an 2d int array that has the same size as the grid
    	int[][] copy = new int [GRID_SIZE][GRID_SIZE];
 
    	for (int c = GRID_SIZE-1; c >= 0; c--) 
        {
    		ArrayList<Integer> list = new ArrayList<Integer>();
            for (int r = GRID_SIZE-1; r >= 0; r--) 
          	{
           		if(grid[r][c]!=0)
           		{
           			list.add(grid[r][c]);
           		}		
          	}
            //now iterate through the modified arraylist
            for(int index = 0; index < list.size()-1; index++)
            {
            	int currNum = list.get(index);
            	//if equal, add the two same numbers together
          	   	if(currNum == list.get(index+1))
          	   	{	
          	   		currNum += currNum;
          	   		list.set(index, currNum);
          	   		score += currNum;
          	   		//set the index + 1 to zero 
          	   		list.set(index + 1 , 0);
          	   		index++;
          	   	}
            }
          	for (int r = GRID_SIZE-1; r >= 0; r--) 
          	{
          		if(list.isEmpty())
          		{
          			copy[r][c] = 0;
          		}
          		//remove the excess 0s
          		else if(list.get(0) == 0)
          		{
          			list.remove(0);
          			r++;
          		}
          		else
          		{
          			copy[r][c] = list.get(0);
          			list.remove(0);
          		}
          	} 
        }
    	//set the grid array to the modified copy array
    	grid = copy;  
    }

    /**
     *Name: canmoveLeft()
     *Purpose: This is a helper method move that performs the main game logic 
     *and perform a move in the left direction. It loops through the row and 
     *columns and find if two non zero numbers are equal. If yes, it returns true.
     *Also, it checks if there are zeros in between the numbers, like 0404, or 0444,
     *If yes, it returns true. Otherwise it returns false.
     *Parameter: none
     *Return: boolean
     */
    private boolean canMoveLeft() 
    {
    	int sum;
    	for (int r = GRID_SIZE-1; r >= 0; r--) 
        {
    		sum = grid[r][GRID_SIZE-1];
    		for (int c = GRID_SIZE-1; c >= 1; c--) 
            {
        	   //if the two numbers are the same, return true
        	 	if(grid[r][c]==grid[r][c-1] && grid[r][c] != 0)
          	 	{
          	 		return true;  	 		
          	 	}

          	 	if(sum != 0 && grid[r][c-1] == 0 )
          	 	{
          	 		return true;
          	 	}
      	 		sum += grid[r][c-1];
            } 
          
        }
        return false;
    }

    /**
     *Name: canmoveRight()
     *Purpose: This is a helper method move that performs the main game logic 
     *and perform a move in the Right direction. It loops through the row and 
     *columns and find if two non zero numbers are equal. If yes, it returns true.
     *Also, it checks if there are zeros in between the numbers, like 0404, or 4440,
     *If yes, it returns true. Otherwise it returns false.
     *Parameter: none
     *Return: boolean
     */
    private boolean canMoveRight() 
    {
    	int sum;
    	for (int r = 0; r < GRID_SIZE; r++) 
        {
    		sum = grid[r][0];
    		for (int c = 0; c < GRID_SIZE-1; c++) 
            {
        	   //if the two numbers are the same, return true
        	 	if(grid[r][c]==grid[r][c+1] && grid[r][c] != 0)
          	 	{
          	 		return true;  	 		
          	 	}

          	 	if(sum != 0 && grid[r][c+1] == 0 )
          	 	{
          	 		return true;
          	 	}
      	 		sum += grid[r][c+1];
            } 
          
        }
        return false;
    }

    /**
     *Name: canmoveUp()
     *Purpose: This is a helper method move that performs the main game logic 
     *and perform a move in the Up direction. It loops through the row and 
     *columns and find if two non zero numbers are equal. If yes, it returns true.
     *Also, it checks if there are zeros in between the numbers
     *If yes, it returns true. Otherwise it returns false.
     *Parameter: none
     *Return: boolean
     */
    private boolean canMoveUp() 
    {
    	int sum;
    	for (int c = GRID_SIZE-1; c >= 0; c--) 
        {
    		sum = grid[GRID_SIZE-1][c];
    		for (int r = GRID_SIZE-1; r >= 1; r--) 
            {
        	   //if the two numbers are the same, return true
        	 	if(grid[r][c]==grid[r-1][c] && grid[r][c] != 0)
          	 	{
          	 		return true;  	 		
          	 	}

          	 	if(sum != 0 && grid[r-1][c] == 0 )
          	 	{
          	 		return true;
          	 	}
      	 		sum += grid[r-1][c];
            } 
          
        }
        return false;
    }
    /**
     *Name: canmoveDown()
     *Purpose: This is a helper method move that performs the main game logic 
     *and perform a move in the Down direction. It loops through the row and 
     *columns and find if two non zero numbers are equal. If yes, it returns true.
     *Also, it checks if there are zeros in between the numbers
     *If yes, it returns true. Otherwise it returns false.
     *Parameter: none
     *Return: boolean
     */
    private boolean canMoveDown() 
    {
    	int sum;
    	for (int c = 0; c < GRID_SIZE; c++) 
        {
    		sum = grid[0][c];
    		for (int r = 0; r < GRID_SIZE-1; r++) 
            {
        	   //if the two numbers are the same, return true
        	 	if(grid[r][c]==grid[r+1][c] && grid[r][c] != 0)
          	 	{
          	 		return true;  	 		
          	 	}

          	 	if(sum != 0 && grid[r+1][c] == 0 )
          	 	{
          	 		return true;
          	 	}
      	 		sum += grid[r+1][c];
            } 
          
        }
        return false;
    } 
    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        outputString.append(String.format("Score: %d\n", score));
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++)
                outputString.append(grid[row][column] == 0 ? "    -"
                        : String.format("%5d", grid[row][column]));

            outputString.append("\n");
        }
        return outputString.toString();
    }

    /**
     * Set the grid to a new value.  This method can be used for
     * testing and is used by our testing/grading script.
     * @param newGrid The values to set the grid to
     */
    public void setGrid(int[][] newGrid)
    {
        if (newGrid.length != GRID_SIZE ||
                newGrid[0].length != GRID_SIZE) {
            System.out.println("Attempt to set grid to incorrect size");
            return;
                }
        this.grid = new int[GRID_SIZE][GRID_SIZE];
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++) {
                grid[r][c] = newGrid[r][c];
            }
        }
    }

    /**
     * get a copy of the grid
     * @return A copy of the grid
     */
    public int[][] getGrid()
    {
        int[][] gridCopy = new int[GRID_SIZE][GRID_SIZE];
        for (int r = 0; r < grid.length; r++)
        {
            for (int c = 0; c < grid[r].length; c++) {
                gridCopy[r][c] = grid[r][c];
            }
        }
        return gridCopy;
    }
   /** 
    *Name: rotate(boolean clockwise)
    *Purpose: If the input value is true
    *then we rotate the board clockwise
    *if false
    *we rotate the board anticlockwise
    *Return type: void
    */
    public void rotate(boolean clockwise)
    {
		int[][] gridCopy = new int[grid.length][grid[0].length];
    	if(clockwise == true)
    	{
    		for(int row = 0; row < GRID_SIZE; row++)
    		{		
    			for(int col = 0; col < GRID_SIZE; col++ )
    			{
    				//gridCopy[col][GRID_SIZE-1-row] = grid[row][col];
    				gridCopy [row][col] = grid[GRID_SIZE-1-col][row];
    			}
    		}
    	}
    	if(clockwise == false)
    	{
    		for(int row = 0; row < GRID_SIZE; row++)
    		{		
    			for(int col = 0; col < GRID_SIZE; col++ )
    			{
    				gridCopy [row][col] = grid[col][GRID_SIZE-1-row];
    			}
    		}
    	}
    	grid = gridCopy;
    }

}
