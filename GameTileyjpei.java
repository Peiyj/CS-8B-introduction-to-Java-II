/**
 *  Name: Ying Pei
 *  Date: May 10, 2017
 *  File:GameTile.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 5.
 *  This file has class GameTileyjpei.  GameTileyjpei 
 *  is a java file that allows us to construct
 *  a GameTile object. It has one constructor method 
 *  that allows us to construct this GameTile object.
 */

/**
 * Name:     GameTileyjpei.java
 * Purpose: To construct a  GameTileyjpei object
 */
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.*;

/**
  * A GameTile is a StackPane that groups together the 
  * visual items needed to display a 2048 tile.
  * 
  * We haven't talked about inheritance much yet, so 
  * the "extends" keyword might be a bit mysterious at this
  * point.  We'll help you through it in this assignment
  * and it will start to make much more sense over the next
  * few weeks.
  */
public class GameTileyjpei extends GameTile 
{
	//fields
	private int tileValue;
	private Rectangle rectangle;
	private Text defaultText;


	//Hashmap that uses tilevalue as the key to access appropriate color
	//Check out the populateColors method that populates the HashMap
	public static HashMap<Integer, Color> colors = new HashMap<Integer, Color>();



	public GameTileyjpei(int tileValue) 
	{
		//calls the empty constructor
		super();
		/*TODO: Create one or more new Shape(s) to represent the tile 
		 * (it can be a Rectangle, a Circle, a combination, etc.  Get creative!)
		 *
		 * Don't forget to set the width and height of the object(s)
		 * 
		 * Set the color of the object(s) depending on the tile's value.
		 * You can use the colors HashMap to get the appropriate color.
		 * Remember you can change the colors in this HashMap, and you can 
		 * combine them with other colors to make a creative tile.  The
		 * only requirement is that each legal value in the game have a 
		 * different color or color scheme.  You need to handle illegal 
		 * values, but the color you choose for these illegal values is 
		 * up to you.
		 * 
		 * Remember that colors.get(tileValue) will return the Color
		 * associated with the value.
		 * 
		 */
		populateColors();
		rectangle = new Rectangle(0,0, 140, 140);
		rectangle.setStroke(colors.get(tileValue));
		rectangle.setFill(colors.get(tileValue));;
		/* TODO: Create a Text object to display the value of the tile,
		 * if the tileValue is non-zero
		
		 * Don't forget to setText, setFont, and setFill
		 *
		 * The font type and color is up to you.  You might choose to vary it
		 * depending on the value of the tile, or you can just use a single
		 * color.
		 *
		 * If tileValue is 0,
		 * you do not need to create this text object.  I.e. it will be blank.
		 */
		defaultText = new Text();
		if(tileValue != 0)
		{
			defaultText.setFont(new Font("Times New Roman", 32));	
			defaultText.setText(tileValue + "");
			defaultText.setFill(Color.BLACK);
		}

		/* TODO: Finally, add tile shape(s) and value of tile to the calling
		 * object, which is a StackPane.  
		 * Hint: Look into the getChildren method of the StackPane/Pane class
		 * and remember that you are adding your objects to the calling object
		 * which is a StackPane. 
		 */
		this.getChildren().addAll(rectangle,defaultText);	
	}

	/* Name: populateColors() 
	 *
	 * Purpose: The purpose of this method is to populate the HashMap
	 * with RGB values pertaining to certain tileValues. For example,
	 * the tileValue 2 has an RGB value of (238, 228, 218). Therefore,
	 * if we want to access the color of tileValue 2 from the hashmap,
	 * we would say colors.get(2) and it would return the color object
	 * Color.rgb(238, 228, 218).
	 *
	 * You are free to change the RGB values of each tileValue as you wish.
	 *
	 * Parameters: None
	 *
	 * Return: None
	 */
	
	public static void populateColors() 
	{
		colors.put(0,Color.WHITE); //empty tile
		colors.put(2, Color.ALICEBLUE);
		colors.put(4, Color.AQUA);
		colors.put(8,Color.AQUAMARINE);
		colors.put(16, Color.AZURE);
		colors.put(32,Color.BEIGE);
		colors.put(64,Color.YELLOW);
		colors.put(128,Color.CADETBLUE);
		colors.put(256,Color.CRIMSON);
		colors.put(512,Color.DEEPPINK);
		colors.put(1024,Color.DARKRED);
		colors.put(2048,Color.GRAY);
		colors.put(4096,Color.PALETURQUOISE);
		colors.put(8192,Color.SLATEGREY);
	}
	//It should construct an object of type GameTile[emailID] and return it.
	
	/* Name:makeNewTile(int tileValue)
	 * Purpose: it takes an int, declare that it returns a GameTile object, 
	 * and be named makeNewTile.
	 * It constructs an object of type GameTile[emailID] and return it
	 */
	public static GameTile makeNewTile(int tileValue)
	{
		GameTileyjpei NewTile = new GameTileyjpei(tileValue);
		return NewTile;
	}	
}
