import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  Name: Ying Pei
 *  Date: April 23, 2017
 *  File: AccountManagerTester.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 3.
 *  This file has class AccountManagerTester. AccountManagerTester 
 *  is a java file that allows us to test the methods we wrote in
 *  AccountManager.java file. It tests for 5 credit card and check 
 *  if they are valid or not
 */

/**
 * Name:    AccountManager.java
 * Purpose: To test credit card account number
 */
public class AccountManagerTester {

	// main function calls tester
	public static void main(String[] args) {
		testAccountManager();
	}

	private static void testAccountManager() {

		// Open test file
		File cardsFile = new File("cards_test.csv");
		Scanner scanner = null;

		try {
			scanner = new Scanner(cardsFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Skip header
		scanner.nextLine();

		// Extract first card number from line 2
		String line = scanner.nextLine();
		String[] lineFields = line.split(",");
		String cardNum = lineFields[0];

		// ******************** Test first number ******************** //
		try {
			System.out.print("TEST validadeCardNumber1: ");
			boolean valid = AccountManager.validateCardNumber(cardNum);
			if (!valid) {
				System.out.println(" PASSED!");
			}
			else {
				System.out.println(" FAILED - card number " + cardNum + " should NOT be valid");
			}
		} catch (Exception e) {
			System.out.println(" EXCEPTION! Something went wrong :(");
			// e.printStackTrace(); // TIP: uncomment to see stack trace
		}

		// Extract second card number from line 3
		line = scanner.nextLine();
		lineFields = line.split(",");
		cardNum = lineFields[0];

		// ******************** Test second number ******************** //
		try {
			System.out.print("TEST validadeCardNumber2: ");
			boolean valid = AccountManager.validateCardNumber(cardNum);
			if (valid) {
				System.out.println(" PASSED!");
			}
			else {
				System.out.println(" FAILED - card number " + cardNum + " should be valid");
			}
		} catch (Exception e) {
			System.out.println(" EXCEPTION! Something went wrong :(");
			// e.printStackTrace(); // TIP: uncomment to see stack trace
		}

		// Extract third card number from line 4
		line = scanner.nextLine();
		lineFields = line.split(",");
		cardNum = lineFields[0];

		// ******************** Test third number ******************** //
		try {
			System.out.print("TEST validadeCardNumber3: ");
			boolean valid = AccountManager.validateCardNumber(cardNum);
			if (valid) {
				System.out.println(" PASSED!");
			}
			else {
				System.out.println(" FAILED - card number " + cardNum + " should be valid");
			}
		} catch (Exception e) {
			System.out.println(" EXCEPTION! Something went wrong :(");
			// e.printStackTrace(); // TIP: uncomment to see stack trace
		}

		// Extract fourth card number from line 5
		line = scanner.nextLine();
		lineFields = line.split(",");
		cardNum = lineFields[0];

		// ******************** Test fourth number ******************** //
		try {
			System.out.print("TEST validadeCardNumber4: ");
			boolean valid = AccountManager.validateCardNumber(cardNum);
			if (!valid) {
				System.out.println(" PASSED!");
			}
			else {
				System.out.println(" FAILED - card number " + cardNum + " should NOT be valid");
			}
		} catch (Exception e) {
			System.out.println(" EXCEPTION! Something went wrong :(");
			// e.printStackTrace(); // TIP: uncomment to see stack trace
		}

		// Extract fifth card number from line 6
		line = scanner.nextLine();
		lineFields = line.split(",");
		cardNum = lineFields[0];

		// ******************** Test fifth number ******************** //
		try {
			System.out.print("TEST validadeCardNumber5: ");
			boolean valid = AccountManager.validateCardNumber(cardNum);
			if (!valid) {
				System.out.println(" PASSED!");
			}
			else {
				System.out.println(" FAILED - card number " + cardNum + " should NOT be valid");
			}
		} catch (Exception e) {
			System.out.println(" EXCEPTION! Something went wrong :(");
			// e.printStackTrace(); // TIP: uncomment to see stack trace
		}

		scanner.close();

	}

}
