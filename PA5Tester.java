/**
 *  Name: Ying Pei
 *  Date: May 10, 2017
 *  File: PA5Tester.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 5.
 *  This file has class PA5Tester. PA5Tester
 *  is a java tester file that test the functionalities 
 *  for the methods in Board.java. These includes the 
 *  8 helper methods that I wrote in Board.java.
 */

/**
 * Name:   PA5Tester.java
 * Purpose: To test the functionality of the methods in Board.java
 */
import java.util.Arrays;
import java.util.Random;

public class PA5Tester {

    // Seed passed to random generator to match the expected output
    private static int SEED = 2017;

    // All these test boards are based off the SEED 2017
    private static int[][][] testGrid = {{
            {0, 0, 0, 0},
            {2, 0, 0, 0}, // Grid 0
            {0, 2, 0, 0},
            {0, 0, 0, 0}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 0}, // Grid 1
            {2, 2, 0, 0},
            {0, 0, 0, 0}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 0}, // Grid 2
            {2, 2, 0, 0},
            {2, 0, 0, 0}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 0}, // Grid 3
            {2, 2, 0, 0},
            {2, 0, 0, 2}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 0}, // Grid 4
            {2, 2, 0, 2},
            {2, 0, 0, 2}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 2}, // Grid 5
            {2, 2, 0, 2},
            {2, 0, 0, 2}}, {

            {0, 0, 0, 0},
            {2, 0, 0, 2}, // Grid 6
            {2, 2, 2, 2},
            {2, 0, 0, 2}}};

    public static void main(String[] args) throws Exception {
        System.out.println("****************** Testing PA3 *******************");

        int score = 0;
        score += testIsGameOver();
        score += testCanMove();
        score += testMove();

        System.out.println("***************************************************");
        System.out.println("*************** PASSED " + score +
                " / 3 TESTS ****************");

        if (score == 3) {
            System.out.println(
                    "NOTE: THIS DOES NOT GUARANTEE FULL CREDIT IN THE PA");
        }

        System.out.println("***************************************************");
    }

    /************************ TEST GAME OVER ************************/

    private static int testIsGameOver() throws Exception {
        System.out.print("Testing isGameOver method ..................");

        Board board1 = new Board(new Random(SEED), 4);
        Board board2 = new Board(new Random(SEED), new int[][]{
                {2, 4, 2, 4},
                {4, 2, 4, 2},
                {2, 4, 2, 4},
                {4, 2, 4, 2}});

        try {
            // test valid board
            if (board1.isGameOver()) {
                System.out.println("FAILED!");
                System.out.println("This board is not game over");
                System.out.println("Your isGameOver method did not " +
                        "return the correct value");
                System.out.println("Board tested: ");
                print2DArray(boardToArray(board1));
                return 0;
            }

            // test game over board
            if (!board2.isGameOver()) {
                System.out.println("FAILED!");
                System.out.println("This board should be game over");
                System.out.println("Your isGameOver method did not " +
                        "return the correct value");
                System.out.println("Board tested: ");
                print2DArray(new int[][]{
                        {2, 4, 2, 4},
                        {4, 2, 4, 2},
                        {2, 4, 2, 4},
                        {4, 2, 4, 2}});
                return 0;
            }

            System.out.println("Passed!");
            return 1;

        } catch (Exception e) {
            System.out.println("FAILED!");
            System.out.println("Exception was thrown while trying to " +
                    "run the isGameOver Method");
            e.printStackTrace();
            return 0;
        }
    }

    /************************ TEST CAN MOVE ************************/

    private static int testCanMove() throws Exception {
        System.out.print("Testing canMove method......................");

        try {
            Board board = new Board(new Random(SEED), new int[][]{
                    {0, 0, 0, 4},
                    {0, 0, 0, 4},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0}});

            if (board.canMove(Direction.UP) && !board.canMove(Direction.RIGHT) &&
                    board.canMove(Direction.DOWN) && board.canMove(Direction.LEFT)) {
                System.out.println("Passed!");
                return 1;
            }

            System.out.println("FAILED!");
            if (!board.canMove(Direction.UP)) {
                System.out.println("Board should be able to move UP!");
            }
            if (board.canMove(Direction.RIGHT)) {
                System.out.println("Board should NOT be able to move RIGHT!");
            }
            if (!board.canMove(Direction.DOWN)) {
                System.out.println("Board should be able to move DOWN!");
            }
            if (!board.canMove(Direction.LEFT)) {
                System.out.println("Board should be able to move LEFT!");
            }

            return 0;

        } catch (Exception e) {
            System.out.println("FAILED!");
            System.out.println("Exception was thrown while trying to" +
                    "run the canMove Method");
            e.printStackTrace();
            return 0;
        }

    }

    /************************ TEST MOVE ************************/

    public static int testMove() throws Exception {
        System.out.print("Testing move method.........................");

       try {
            Board board = new Board(new Random(SEED), new int[][]{
                    {2, 4, 8, 2},
                    {2, 4, 8, 2},
                    {2, 4, 8, 0},
                    {2, 4, 8, 2}});

            board.move(Direction.RIGHT);
            if (!Arrays.deepEquals(boardToArray(board), new int[][]{
                    {2, 4, 8, 2},
                    {2, 4, 8, 2},
                    {0, 2, 4, 8},
                    {2, 4, 8, 2}})) {
                System.out.println("FAILED!");
                System.out.println("move(Direction.RIGHT) is implemented incorrectly");
                return 0;
            }

            board.move(Direction.UP);

            if (board.getScore() != 32) {
                System.out.println("FAILED!");
                System.out.println("Incorrect score! Expected 32, got " +
                        board.getScore());
                return 0;
            }

            if (!Arrays.deepEquals(boardToArray(board), new int[][]{
                    {4, 8, 16, 4},
                    {2, 2, 4, 8},
                    {0, 4, 8, 2},
                    {0, 0, 0, 0}})) {
                System.out.println("FAILED!");
                System.out.println("move(Direction.UP) implemented incorrectly");
                return 0;
            }

            board.move(Direction.LEFT);

            if (board.getScore() != 36) {
                System.out.println("FAILED!");
                System.out.println("Incorrect score! Expected 36, got " +
                        board.getScore());
                return 0;
            }

            if (!Arrays.deepEquals(boardToArray(board), new int[][]{
                    {4, 8, 16, 4},
                    {4, 4, 8, 0},
                    {4, 8, 2, 0},
                    {0, 0, 0, 0}})) {
                System.out.println("FAILED!");
                System.out.println("move(Direction.LEFT) implemented incorrectly");
                return 0;
            }

            board.move(Direction.DOWN);

            if (board.getScore() != 44) {
                System.out.println("FAILED!");
                System.out.println("Incorrect score! Expected 44, got " +
                        board.getScore());
                return 0;
            }

            if (!Arrays.deepEquals(boardToArray(board), new int[][]{
                    {0, 0, 0, 0},
                    {0, 8, 16, 0},
                    {4, 4, 8, 0},
                    {8, 8, 2, 4}})) {
                System.out.println("FAILED!");
                System.out.println("move(Direction.DOWN) implemented incorrectly");
                return 0;
            }

            System.out.println("Passed!");
            return 1;

        } catch (Exception e) {
            return 0;
        }
    }

    // Creates int[][] given a board object
    private static int[][] boardToArray(Board board) {
        if (board == null) {
            return null;
        }
        int[][] array = new int[board.GRID_SIZE][board.GRID_SIZE];
        for (int r = 0; r < board.GRID_SIZE; r++) {
            for (int c = 0; c < board.GRID_SIZE; c++) {
                array[r][c] = board.getTileValue(r, c);
            }
        }
        return array;
    }

    // Prints matrix
    private static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println(Arrays.toString(array[i]));
    }

}
