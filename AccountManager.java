import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  Name: Ying Pei
 *  Date: April 23, 2017
 *  File: AccountManager.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 3.
 *  This file has class AccountManager. AccountManager is a java file 
 *  that uses hashmap to store credit card object with String. Specifically
 *  it uses the HashMap to retrieve the CreditCards from their account 
 *  number strings. The method in which I implement to validate the credit 
 *  card number is called  public static boolean validateCardNumber(String cardNum).
 *  It takes a string of card number and validate it using Luhn Algorithm.
 */

/**
 * Name:    AccountManager.java
 * Purpose: To manage credit card account info
 */

public class AccountManager {

  // Used by the methods we provide for reading in the transactions
  // from a file.  You don't need to worry about this, and please
  // do not change it.
  private static final String DATE_FORMAT = "yyyy-MM-dd";

  // The accounts managed by this AccountManager object.
  // This is public only to make grading your assignments easier.
  // It would be better design to make it private.
  public HashMap<String, CreditCard> accounts;

  /**
   * Construct a new, empty, AccountManager object.
   * To load accounts, use the loadAccounts method.
   */
  public AccountManager() {
    accounts = new HashMap<>();
  }

  /**
   * This method uses Luhn's Algorithm to validate card numbers.
   * It takes a string of cardNum and return true or false 
   * depending the algorithm.
   * If the size of the numberArray is bigger than 2,
   * starting from the first digit to the left of the check digit,
   * doubling every other digit going left.
   * By adding all these numbers together and multiplying this sum of digits.
   * If the product mod 10 is equal to the right most digit,
   * return true.
   * Otherwise, return false
   */
  
  public static boolean validateCardNumber(String cardNum) 
  {
	//if the input is null, then return false
	if(cardNum == null)
	{
		return false;
	}
	int sum = 0;
	 //convert string cardNum to int array 
	int [] numberArray = stringToIntArray(cardNum);
	 //we need at least 2 digits in the string array
	if(numberArray.length < 2)
	{
		return false;
	}
	else if(numberArray.length > 1)
	{
		//loop through to change values in the int array
		for(int i = numberArray.length-2; i >= 0; i-=2 )
		{	
			int newNumber = 2 * numberArray[i];
			if(newNumber > 9)
			{
				numberArray[i] = newNumber-9;
			}
			else
			{
				numberArray[i] = newNumber;
			}
		}

		for (int i = 0; i <  numberArray.length-1; i++)
		{
			sum += numberArray[i];
		}
		int newSum = sum * 9;
		int remainder = newSum % 10;
		if(remainder == numberArray[numberArray.length-1])
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
    return false ;
  }
  /**
   * This is helper method that takes a string numbers 
   * Turn it to an integer array.
   * And return the integer array.
   */ 
  public static int [] stringToIntArray(String numbers)
  {
      int [] numberArray  = new int[numbers.length()] ;
	  for (int i = 0; i < numbers.length(); i++)
	  {
	      numberArray [i] = numbers.charAt(i) - '0';
	  }
	  return numberArray;
  }
  
  /**
   * TODO Explain this method in Part B
   */
  public ArrayList<String> loadAccounts(String filename) {
    ArrayList<String> invalid = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File(filename))) {
      // Skip the header
      scanner.nextLine();

      // Read the credit card data
      while (scanner.hasNextLine()) {
        String[] data = scanner.nextLine().split(",");
        System.out.println("------------------------------------");
        String cardNumber = data[0];
        System.out.println("Card number: " + cardNumber);
        String accountHolder = data[1];
        System.out.println("Account holder: " + accountHolder);
        String bal = data[2];
        System.out.println("Balance: " + bal);
        double cardBalance = Double.parseDouble(bal);
        if (validateCardNumber(cardNumber)) {
          CreditCard card = new CreditCard(cardNumber, accountHolder);
          card.setCurrentBalance(cardBalance);
          accounts.put(cardNumber, card);
        } else {
          invalid.add(cardNumber);
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Accounts file not found");
      e.printStackTrace();
    }

    System.out.println("------------------------------------");
    return invalid;
  }

  /**
   * Process a list of transactions from a file.
   * As each transaction is processed, the balance of the corresponding
   * credit card is adjusted if the transaction is allowed.  If the
   * transaction is not valid, the transaction is denied with the reason
   * for the denial.
   *
   * @param transactionsFile The name of the file where the transactions
   *                         are listed.
   * @return A list of denied Transactions, modified to indicate
   * why they were denied.
   */
  public ArrayList<Transaction>
  processTransactionsFromFile(String transactionsFile) {
    ArrayList<Transaction> transactions = readTransactionsFromFile(transactionsFile);
    return processTransactions(transactions);
  }

  /**
   * TODO Explain this method in Part B
   */
  private ArrayList<Transaction>
  processTransactions(ArrayList<Transaction> transactions) {
    // The transactions that are denied
    ArrayList<Transaction> denied = new ArrayList<>();
    for (Transaction t : transactions) {
      if (validateCardNumber(t.getCardNumber())) {
        // Get the card object corresponding to the card number
        CreditCard c = accounts.get(t.getCardNumber());
        if (!c.processTransaction(t)) {
          denied.add(t);
        }
      } else {
        t.denyTransaction("Invalid account number " + t.getCardNumber());
        denied.add(t);
      }
    }
    return denied;
  }

  /**
   * Read transactions from a file.
   *
   * YOU DO NOT NEED TO AND SHOULD NOT CHANGE THIS METHOD
   *
   * @param transactionsFilename Name of transactions data file
   * @return A list of transactions from the file.
   */
  private ArrayList<Transaction>
  readTransactionsFromFile(String transactionsFilename) {
    ArrayList<Transaction> transactions = new ArrayList<>();
    try { // Read data
      Scanner scanner = new Scanner(new File(transactionsFilename));

      // Use comma as the delimiter
      scanner.useDelimiter(",|\n");

      // Skip header
      scanner.nextLine();

      // Formatter to parse the date object
      DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

      while (scanner.hasNext()) {
        String transactionNumber = scanner.next();
        String cardNumber = scanner.next();
        Date date = dateFormat.parse(scanner.next());
        String vendor = scanner.next();
        double purchaseAmount = scanner.nextDouble();
        transactions.add(new Transaction(
            transactionNumber, cardNumber, date, vendor, purchaseAmount));
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.err.println("Could not read from transaction file");
    } catch (InputMismatchException e) {
      System.err.println("Purchase amount is not a double type");
      System.err.println("Skipping the rest of the file");
    } catch (ParseException e) {
      System.err.println("Bad date format: " + e.getMessage());
      System.err.println("Skipping the rest of the file");
    }
    return transactions;
  }

  /**
   * TODO Explain this method in Part B
   */
  public void generateStatements(String filename) {
    try {
      PrintWriter statements = new PrintWriter(new File(filename));
      statements.write("******************************************************\n");
      for (String cardNum : accounts.keySet()) {
        CreditCard card = accounts.get(cardNum);
        String statement = card.closeMonth();
        statements.write(statement);
        statements.write("******************************************************\n");
      }
      statements.flush();
      statements.close();
    } catch (IOException e) {
      System.err.println("There was a problem opening the statements file");
    }
  }

  /**
   * Implement the program described in PA3
   *
   * @param args The three command line arguments:
   *             The filename that contains the account information
   *             The filename that contains the transactions
   *             The filename where the account statements will be written
   */
  public static void main(String[] args) {
    // YOU DO NOT NEED TO CHANGE THIS METHOD.

    if (args.length < 3) {
      System.err.println("Invalid number of arguments");
      System.exit(1);
    }

    String creditCardsFilename = args[0];
    String transactionsFilename = args[1];
    String statementsFilename = args[2];

    AccountManager accountManager = new AccountManager();
    System.out.println("Loading accounts...");
    ArrayList<String> invalidAccounts =
        accountManager.loadAccounts(creditCardsFilename);

    if (invalidAccounts.size() > 0) {
      System.out.println("The following " + invalidAccounts.size() +
          " account numbers are invalid. No accounts created:");
      for (String acct : invalidAccounts) {
        System.out.println("\t" + acct);
      }
    }

    ArrayList<Transaction> denied =
        accountManager.processTransactionsFromFile(transactionsFilename);

    if (denied.size() > 0) {
      System.out.println("The following transactions were denied: ");
      for (Transaction t : denied) {
        System.out.println("-----------------------------------------------------");
        System.out.println(t.toString());
        System.out.println("Reason: " + t.getDenialReason());
      }
      System.out.println("-----------------------------------------------------");
    }

    System.out.println("Writing statements to " + statementsFilename + " ...");
    accountManager.generateStatements(statementsFilename);
  }
}
