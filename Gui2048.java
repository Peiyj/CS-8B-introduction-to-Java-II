/**
 *  Name: Ying Pei
 *  Date: May 10, 2017
 *  File: Gui2048.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 5.
 *  This file has class Gui2048. Gui2048
 *  is a java file that sets up the GUI for 2048.
 *  Specifically, it constructs the initial state of
 *  the board using GUI.
 */

/**
 * Name:    Gui2048.java
 * Purpose: To construct graphic interface for 2048
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import java.awt.*;
import java.util.Random;

public class Gui2048 extends Application 
{

    // Instance variables
    private GridPane pane;      // Pane to hold the game tiles
    private int GRID_SIZE = 4;  // Size of the board
    private Label scoreNum;     // The label with the score
    private Board board;        // Board object to run the game logic
    private GameTileFactory gtf = new GameTileFactory();

    /**
     * Name: start(Stage primaryStage)
     * 
     * Purpose: The purpose of this method is to construct the initial state of
     * the board using GUI. This method will be called on once, and so only
     * initializes the board to its beginning state.
     *
     * @param primaryStage the stage on which all the components
     *                     of the GUI will be drawn
     */
    public void start(Stage primaryStage) {
        // Set up all the GUI components
        setUpPane(primaryStage);

        // Initialize the game board
        board = new Board(new Random(), GRID_SIZE);

        // Set the GUI to reflect the state of the game board
        updateBoard();
    }

    /*
     * setUpPane()
     *
     * Purpose: The purpose of this method is to set up the board using a
     * GridPane object.
     *
     * Parameters: Stage primaryStage - the stage on which all the components of
     * the GUI will be drawn
     *
     * Return: None
     *
     */
    private void setUpPane(Stage primaryStage) {
        // Top level pane
        BorderPane topPane = new BorderPane();

        // Place scene onto the stage and set stage dimensions
        Scene scene = new Scene(topPane);
        Button button = new Button("Rotate!");
        button.setOnAction(new MyButtonListener());

        // Set primaryStage
        primaryStage.setTitle("Gui2048");
        primaryStage.setScene(scene);
        primaryStage.setWidth(700);
        primaryStage.setHeight(700);

        placeTitleBox(topPane);

        placeGameGrid(topPane);

        // Call for key actions
        scene.setOnKeyPressed(new MyKeyHandler());
        topPane.setBottom(button);

        // display stage
        primaryStage.show();

    }

    // Helper function to place the items into the title box at the top
    private void placeTitleBox(BorderPane topPane) {
        HBox titleBox = new HBox(150);
        HBox scoreBox = new HBox(10);

        // Add score header of the GUI back to pane
        Label score = new Label("Score: ");
        score.setFont(Font.font("Helvetica", FontWeight.BOLD,
                    FontPosture.ITALIC, 20));

        scoreNum = new Label("0");
        scoreNum.setFont(Font.font("Helvetica", FontWeight.BOLD,
                    FontPosture.ITALIC, 30));

        // Add Title of the GUI back to pane
        Label title = new Label("2048");
        title.setFont(Font.font("Helvetica", FontWeight.BOLD,
                    FontPosture.ITALIC, 35));

        scoreBox.setAlignment(Pos.CENTER_RIGHT);
        titleBox.setAlignment(Pos.CENTER);

        scoreBox.getChildren().addAll(score, scoreNum);
        titleBox.getChildren().addAll(title, scoreBox);

        topPane.setTop(titleBox);
    }
    // Helper function to place the button at the botton
    private void placeButton(BorderPane topPane){
    	HBox titleBox = new HBox(150);
    }
    // Set up the visual components of the game grid
    private void placeGameGrid(BorderPane topPane) {
        // Create the pane that will hold the board
        pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setStyle("-fx-background-color: rgb(187, 173, 160)");

        // Set the spacing between the Tiles
        pane.setHgap(10);
        pane.setVgap(10);

        topPane.setCenter(pane);
    }


    /*
     * Name: updateBoard()
     *
     * Purpose: The purpose of this method is to continually update the board's
     * tile values and the game score on the GUI.
     * This method will display the new board every time
     * a user clicks on one of the arrow buttons, which signals a move.  The
     * GUI is updated based on the values contained within the grid in
     * Board.java. For each move, the old values of the tiles are cleared, and a
     * new board is constructed based off of the values of the grid inside
     * Board.java.
     *
     * Parameters: none
     *
     */
    private void updateBoard() 
    {
        // update the score
        scoreNum.setText("" + board.getScore());

        // Get rid of all of the current game tiles to make new ones
        pane.getChildren().clear();

        // Update board by reinitializing it to the grid
        for (int r = 0; r < board.GRID_SIZE; r++) 
        {
            for (int c = 0; c < board.GRID_SIZE; c++) 
            {
                // TODO: Create a new (custom) GameTile object with the
                // score value of the board's grid at location r, c
                // Then add this tile to the pane in the correct
                // location.  REMEMBER that pane.add takes the
                // column as the second argument and the row as the third
            	GameTile newTile = gtf.getTile(board.getTileValue(r,c));
            	pane.add(newTile, c, r);
            }
        }

        if (board.isGameOver()) {
            // If the game is over, display a new window stating this
            Stage gameOver = new Stage();
            Label gameOverLabel = new Label("GAME OVER");
            gameOverLabel.setFont(Font.font(
                        "Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 36));

            Scene gameOverScene = new Scene(gameOverLabel);
            gameOver.setScene(gameOverScene);
            gameOver.show();
        }
    }


    /**
     * MyKeyHandler is an inner class of the Board class to handle key events
     * and pass them to the Board object to make the appropriate move.
     *
     * @author Christine
     */
    class MyKeyHandler implements EventHandler<KeyEvent> 
    {
        /*
         * Name: handle(KeyEvent e)
         *
         * Purpose: The purpose of this method is to handle the keys pressed by the
         * user of the game.
         *
         * Parameters: KeyEvent e - The key event that the user enters - in other
         * words the directional arrows that the user can choose, or the "Q" key for
         * quitting the game
         *
         * Return: void
         */
        public void handle(KeyEvent e) {

            Direction direction = null;

            // if user hits up arrow
            if (e.getCode() == KeyCode.UP) {
                direction = Direction.UP;
                System.out.println("Moving UP");
            }

            // if user hits down arrow
            else if (e.getCode() == KeyCode.DOWN) {
                System.out.println("Moving DOWN");
                direction = Direction.DOWN;
            }

            // If user hits left arrow
            else if (e.getCode() == KeyCode.LEFT) {
                System.out.println("Moving LEFT");
                direction = Direction.LEFT;
            }

            // If user hits right arrow
            else if (e.getCode() == KeyCode.RIGHT) {
                System.out.println("Moving RIGHT");
                direction = Direction.RIGHT;
            }

            if (board.canMove(direction)) {
                board.move(direction);
                board.addRandomTile();
                updateBoard();
            }

        }

    }
    
    
    class MyButtonListener implements EventHandler<ActionEvent>
    {
		public void handle(ActionEvent e){

			board.rotate(true);
			updateBoard();
    		//System.out.println("123213");	
    	}
    }
    


    /**
     * This main method is needed for running in eclipse
     *
     * @param args command line arguments
     */
    public static void main(String[] args) 
    {
        Application.launch(args);
    }

} // end of class
