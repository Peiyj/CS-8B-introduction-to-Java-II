import java.awt.Color;

public class MyCritterTester 
{
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

		score += this.testMyCritter();


		scoreLog += "final score = " + score + "/10";
		if (score != 10) {
			scoreLog += scoreInfo;
		}
		return score;
	}

	private int testMyCritter() 
	{
		int score = 0;
		MyCritter critter = new MyCritter();

		// test color and fight
		try {
			// test color
			boolean allRight = true;

			if (critter.getColor().equals(Color.darkGray)||
				critter.getColor().equals(Color.blue)||	
				critter.getColor().equals(Color.green)||
				critter.getColor().equals(Color.PINK)||
				critter.getColor().equals(Color.ORANGE)
				) 
			{
				allRight = true;
			}

			if (critter.eat() == false)
			{
				allRight = false;
			};


			// test fight
			critter.fight("B");
			if (!(Critter.Attack.ROAR == critter.fight("1"))) {
				allRight = false;
			}
			if (!(Critter.Attack.SCRATCH == critter.fight("0"))) {
				allRight = false;
			}
			if (!(Critter.Attack.ROAR == critter.fight("B"))) {
				allRight = false;
			}
			if (!(Critter.Attack.SCRATCH == critter.fight("L"))) {
				allRight = false;
			}

			if (allRight) {
				score += 10;
			} else {
				System.out.println("----" + "fails critter's color or attack" + "----");
				this.eclog += "fails critter's color\n";
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("----" + "fails critter's color or attack" + "----");
			this.eclog += "fails critter's color or attack\n";
		}

		System.out.println("Received " + score + "/10 points for critter");
		return score;
	}
	private void reportError(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		MyCritterTester pa6Tester = new MyCritterTester();

		System.out.println("*********Begin Submission Script  PSA**************");
		double score = pa6Tester.calculateScore();

		System.out.print("Score on this tester " + score + "/10\n");
		if (score != 10) {
			System.out.println(pa6Tester.scoreInfo);
		}
		System.out.println("These submission scripts are not exhaustive. They test only a subset of Part4.  Getting a " + score + " /10 in the submission script  means that you would get atleast " + score + "/40 in part 2.You must test your program thoroughly to make sure that you do not lose any points. You must also test other parts of this assignment. ");

		System.out.println("*********End Submission Script  PSA**************");
	}
}
