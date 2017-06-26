/**
 *  Name: Ying Pei
 *  Date: May 16, 2017
 *  File: PA6Tester.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 6.
 *  This file has PA6Tester.java. PA6Tester is a java 
 *  tester file that test the functionality of the critter
 *  objects. These includes the 5 inherited methods that I 
 *  wrote for each animal
 */

/**
 * Name:    PA6Tester.java
 * Purpose: To test the functionality of the critter objects
 */
import java.awt.*;

public class PA6Tester {
	public String scoreLog = "";
	public String scoreInfo = "";
	public String eclog = "";
	public String folderName = "";

	private void handleTestFail(String message) {
		System.out.println("---- " + folderName + " fails " + message + " ----");
		scoreLog += "fails " + message + "\n";
		scoreInfo += " + " + message;
	}

	private double calculateScore() {
		double score = 0;

		score += this.testBear();
		score += this.testLion();
		score += this.testTiger();
		score += this.testDragon();

		scoreLog += "final score = " + score + "/30";
		if (score != 30) {
			scoreLog += scoreInfo;
		}
		return score;
	}

	private int testDragon() {
		int score = 0;
		Dragon dragon = new Dragon();

		// test color and fight
		try {
			// test color
			boolean allRight = true;

			if (!dragon.getColor().equals(Color.BLACK)) {
				allRight = false;
			}

			dragon.eat();

			if (!dragon.getColor().equals(Color.WHITE)) {
				allRight = false;
			}

			// test fight
			dragon.fight("B");
			if (!(Critter.Attack.ROAR == dragon.fight("L"))) {
				allRight = false;
			}
			if (!(Critter.Attack.POUNCE == dragon.fight("L"))) {
				allRight = false;
			}

			if (allRight) {
				score += 3;
			} else {
				System.out.println("----" + "fails dragon's color or attack" + "----");
				this.eclog += "fails dragon's color\n";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----" + "fails dragon's color or attack" + "----");
			this.eclog += "fails dragon's color or attack\n";
		}

		System.out.println("Received " + score + "/3 points for Dragon");
		return score;
	}

	public int testBear() {
		int score = 0;

		// Create bear
		Bear polar = new Bear(false);
		Bear griz = new Bear(true);

		// test color
		try {
			Color grizColor = new Color(190, 110, 50);
			boolean allRight = true;
			if (!(polar.getColor()).equals(Color.WHITE)) {
				handleTestFail("Polar Bear's color");
				allRight = false;
			}

			if (!(griz.getColor()).equals(grizColor)) {
				handleTestFail("Grizzly Bear's color");
				allRight = false;
			}

			if (allRight) {
				score += 2;
			}
		} catch (Exception e) {
			handleTestFail("Bear's color");
		}

		// test eat
		try {
			boolean allRight = true;
			for (int i = 0; i < 100; i++) {
				if (!polar.eat()) {
					allRight = false;
					handleTestFail("Bear's eat()");
					break;
				}
			}

			if (allRight) {
				score += 1;
			}
		} catch (Exception e) {
			handleTestFail("Bear's eat()");
		}

		// test fight
		try {
			boolean allRight = true;

			for (int i = 0; i < 100; i++) {
				if (!(polar.fight("A") == Critter.Attack.SCRATCH)) {
					allRight = false;
					handleTestFail("Bear's fight()");
					break;
				}
			}

			if (allRight) {
				score += 1;
			}
		} catch (Exception e) {
			handleTestFail("Bear's fight()");
		}

		// test movement
		// grab initial direction
		try {
			boolean allRight = true;

			if (!(polar.getMove() == Critter.Direction.SOUTH)) {
				allRight = false;
				handleTestFail("Bear's move()");
			}

			// then test West/North after
			for (int i = 1; i < 20; i++) {
				if (i % 2 == 0) {
					if (!(polar.getMove() == Critter.Direction.SOUTH)) {
						allRight = false;
						handleTestFail("Bear's move()");
						break;
					}
				} else {
					if (!(polar.getMove() == Critter.Direction.EAST)) {
						allRight = false;
						handleTestFail("Bear's move()");
						break;
					}
				}
			}
			if (allRight) {
				score += 5;
			}
		} catch (Exception e) {
			handleTestFail("Bear's move()");
		}

		// test string
		try {
			String bVal = polar.toString();
			String gVal = griz.toString();
			boolean allRight = true;
			if (!gVal.equals(bVal)) {
				allRight = false;
				handleTestFail("Bear's toString()");
			}
			if (!gVal.equals("B")) {
				allRight = false;
				handleTestFail("Bear's toString()");
			}

			if (allRight) {
				score += 1;
			}
		} catch (Exception e) {
			handleTestFail("Bear's toString()");
		}
		System.out.println("Received " + score + "/10 points for Bear");
		return score;
	}

	public int testLion() {
		// Test lion
		Lion scared = new Lion();
		int score = 0;

		// test color
		try {
			if (!(scared.getColor()).equals(Color.RED)) {
				handleTestFail("Lion's color");
			} else {
				score += 1;
			}
		} catch (Exception e) {
			handleTestFail("Lion's color");
		}

		// test eat
		try {
			boolean allRight = true;
			if (scared.eat()) {
				allRight = false;
			}

			// fight should make hungry
			scared.fight("A");
			if (!scared.eat()) {
				allRight = false;
			}
			if (scared.eat()) {
				allRight = false;
			}

			if (allRight) {
				score += 2;
			} else {
				handleTestFail("Lion's eat()");
			}
		} catch (Exception e) {
			handleTestFail("Lion's eat()");
		}

		// test movement
		try {
			boolean allRight = true;
			for (int i = 0; i < 100; i++) {
				if (i % 20 < 5) {
					if (!(scared.getMove() == Critter.Direction.SOUTH)) {
						allRight = false;
						System.out.println("------Lion should move SOUTH on first 5 steps---------");
						break;
					}
				} else if (i % 20 < 10) {
					if (!(scared.getMove() == Critter.Direction.WEST)) {
						allRight = false;
						System.out.println("------Lion should move WEST on steps 5-9------");
						break;
					}
				} else if (i % 20 < 15) {
					if (!(scared.getMove() == Critter.Direction.NORTH)) {
						allRight = false;
						System.out.println("------Lion should move NORTH on steps 10-14------");
						break;
					}
				} else {
					if (!(scared.getMove() == Critter.Direction.EAST)) {
						allRight = false;
						System.out.println("------Lion should move EAST on steps 5-9------");
						break;
					}
				}
			}

			if (allRight) {
				score += 3;
			} else {
				handleTestFail("Lion's getMove()");
			}
		} catch (Exception e) {
			handleTestFail("Lion's getMove()");
		}

		// test string
		try {
			String sVal = scared.toString();

			if (!sVal.equals("L")) {
				handleTestFail("Lion's toString()");
			} else {
				score += 1;
			}
		} catch (Exception e) {
			handleTestFail("Lion's toString()");
		}
		System.out.println("Received " + score + "/7 points for Lion");
		return score;
	}

	public int testTiger() {
		int score = 0;

		// Test Tiger
		Tiger scared = new Tiger(9);

		// test color
		try {
			if (!(scared.getColor()).equals(Color.YELLOW)) {
				handleTestFail("Tiger's color");
			} else {
				score += 1;
			}
		} catch (Exception e) {
			handleTestFail("Tiger's color");
		}

		// test eat
		try {
			boolean allRight = true;
			// Tiger hungry
			for (int i = 9; i > 0; i--) {
				if (!scared.eat()) {
					allRight = false;
					break;
				}
			}

			if (scared.eat()) {
				allRight = false;
			}
			if (0 != Integer.parseInt(scared.toString())) {
				allRight = false;
			}

			if (allRight) {
				score += 2;
			} else {
				handleTestFail("Tiger's eat()");
			}
		} catch (Exception e) {
			handleTestFail("Tiger's eat()");
		}

		// test fight
		try {
			boolean allRight = true;

			scared = new Tiger(1);
			if (!(scared.fight("A") == Critter.Attack.SCRATCH)) {
				allRight = false;
				reportError("------Tiger attack is incorrect when hungry - should scratch------");
			}
			if (0 == Integer.parseInt(scared.toString())) {
				allRight = false;
				reportError("------Tigers should be 1  but is " + scared + "------");
			}
			// tiger eats, so should now POUNCE
			scared.eat();
			if (!(scared.fight("A") == Critter.Attack.POUNCE)) {
				allRight = false;
				reportError("------Tiger attack is incorrect when hungry - should scratch------");
			}
			// check for initially not hungry tiger
			scared = new Tiger(0);
			if (!(scared.fight("A") == Critter.Attack.POUNCE)) {
				allRight = false;
				reportError("------Tiger attack is incorrect when hungry - should scratch------");
			}

			if (allRight) {
				score += 3;
			} else {
				handleTestFail("Tiger's fight()");
			}
		} catch (Exception e) {
			handleTestFail("Tiger's fight()");
		}

		// test movement
		try {
			boolean allRight = true;

			scared = new Tiger(7);
			Critter.Direction d;
			boolean[] bArr = new boolean[4];
			for (int i = 0; i < 50; i++) {
				// get initial Direction
				d = scared.getMove();
				// mark off this direction
				if (d == Critter.Direction.NORTH)
					bArr[0] = true;
				else if (d == Critter.Direction.WEST)
					bArr[1] = true;
				else if (d == Critter.Direction.EAST)
					bArr[2] = true;
				else if (d == Critter.Direction.SOUTH)
					bArr[3] = true;

				// check two more moves - not done in loop to simplify error
				// reporting
				if (!(scared.getMove() == d)) {
					allRight = false;
					reportError("-----Tiger should move in the same direction 3 times (failed at 2) -----");
					break;
				}
				if (!(scared.getMove() == d)) {
					allRight = false;
					reportError("-----Tiger should move in the same direction 3 times (failed at 3) -----");
					break;
				}
			}
			// ensure all directions found
			for (int i = 0; i < 4; i++) {
				if (!bArr[i]) {
					allRight = false;
					reportError("-----Tiger appears to not be moving randomly (missed at least one direction)-----");
				}
			}

			if (allRight) {
				score += 3;
			} else {
				handleTestFail("Tiger's getMove()");
			}
		} catch (Exception e) {
			handleTestFail("Tiger's getMove()");
		}

		try {
			// test string
			boolean allRight = true;

			scared = new Tiger(9);
			String sVal = scared.toString();

			if (!sVal.equals("9")) {
				allRight = false;
			}
			scared = new Tiger(0);
			// test string
			sVal = scared.toString();

			if (!sVal.equals("0")) {
				allRight = false;
			}

			if (allRight) {
				score += 1;
			} else {
				handleTestFail("Tiger's toString()");
			}
		} catch (Exception e) {
			handleTestFail("Tiger's toString()");
		}
		System.out.println("Received " + score + "/10 points for Tiger");
		return score;
	}

	private void reportError(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		PA6Tester pa6Tester = new PA6Tester();

		System.out.println("*********Begin Submission Script  PSA**************");
		double score = pa6Tester.calculateScore();

		System.out.print("Score on this tester " + score + "/30\n");
		if (score != 30) {
			System.out.println(pa6Tester.scoreInfo);
		}
		System.out.println("These submission scripts are not exhaustive. They test only a subset of Part2.  Getting a " + score + " /30 in the submission script  means that you would get atleast " + score + "/40 in part 2.You must test your program thoroughly to make sure that you do not lose any points. You must also test other parts of this assignment. ");

		System.out.println("*********End Submission Script  PSA**************");
	}
}
