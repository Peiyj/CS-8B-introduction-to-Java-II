/** 
C * TODO: Your file header comment here.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Name: Ying Pei
 *  Date: April 23, 2017
 *  File: CreditCard.java
 *  Sources of Help: None
 *
 *  CSE8B assignment 3.
 *  This file has class CreditCard. CreditCard is a java file 
 *  has 7 fields to store credit card object  information. Specifically
 *  they are accountNumber(string), accountName(string), creditLimit
 *  (double), currentBalance(double), allowedOverdraft(double),
 *  rebateRate(double),transactions(arrayList).
 */

/**
 * Name:    CreditCard.java
 * Purpose: To store credit card object info
 */
public class CreditCard 
{
	//fields
	private String accountNumber;
	private String accountName;
	private double creditLimit;
	private double currentBalance;
	private double allowedOverdraft;
	private double rebateRate;
	private ArrayList <Transaction> transactions;
	
	//constructor
	public CreditCard(String cardNumber, String accHolder)
	{
		accountNumber = cardNumber;
		accountName = accHolder;
		creditLimit = 5000;
		currentBalance = 0;
		allowedOverdraft = 1000;
		rebateRate = 0.02;
		transactions = new ArrayList<Transaction>();
	}
	
	//getters
	
	public String getCardNumber()
	{
		return accountNumber;
	}
	
	public String getAccountHolder()
	{
		return accountName;
	}
	
	public double getCurrentBalance()
	{
		return currentBalance;
	}
	//is this right?
	public ArrayList<Transaction> getCurrentTransactions()
	{
		return transactions;
	}
	
	//setter
	
	public void setCurrentBalance(double amt) 
	{
		this.currentBalance = amt;
	}

	@Override
	public String toString() 
	{
		// This method will work once you implement the other methods
		return this.getClass().getSimpleName() + " " +
				getCardNumber() + " " + getAccountHolder();
	}
	
	//methods
	/**
	 * This method processes a single transaction. 
	 *  This method returns true if the transaction is allowed.
	 *  Then it adjusts the balance of the account
	 *  and adds t to the transactions arraylist.
	 *  If The account number in the transaction 
	 *  does not match the account number in this CreditCard object,
	 *  this method will return false.
	 *  If the account balance in this CreditCard object would go over the credit limit
	 *  + the overdraft amount with the purchase amount specified by the transaction,
	 *  This method will also return false.
	 *  if transaction is t, it returns false.
	 */
	public boolean processTransaction(Transaction t)
	{
		System.out.println(allowedOverdraft);
		//if the transaction is allowed
		if(t == null)
		{
			return false;
		}
		String TransactioncCN = t.getCardNumber();
		String CreditCardCN = this.getCardNumber();
		
		if(!TransactioncCN.equals(CreditCardCN))
		{
			t.denyTransaction("Transaction attempted on incorrect account");
			return false;			
		}
		//if the account balance + purchase amount > credit limit + overdraft
		double currentBalance = this.getCurrentBalance();
		double purchaseAmount = t.getPurchaseAmount();
		
		if((currentBalance+purchaseAmount) > (this.creditLimit+this.allowedOverdraft))
		{
			t.denyTransaction("Credit limit reached");
			return false;	
		}
		else
		{
			this.setCurrentBalance(currentBalance + purchaseAmount);
			//is this right? add t to the transaction arraylist
			this.transactions.add(t);
			return true;
		}
	}
	
	/**
	 * This method closes out the account for the month and generates
	 * Then it returns a monthly statement as a String.   
	 * Then, it calculates the rebate amount
	 * multiplies it by the rebate percentage.
	 * Then it adjusts (reducing) the balance by the rebate amount
	 * and resets the currentTransactions list to an empty list.
	 */

	public String closeMonth()
	{
	
		//get all the transactions
		double sum = 0;
		String copy  = "Account: "+ accountName + " " + 
				accountNumber.substring(accountNumber.length() - 4) +"\n"+
				"-----------------------------------------------------\n";
		ArrayList <Transaction> transactions = this.getCurrentTransactions();
		
		//check if transactions are 0
		if(transactions.size() == 0)
		{
			copy = copy + "NO TRANSACTIONS THIS MONTH\n";
		}
		for(int i = 0; i < transactions.size(); i++)
		{
			sum += transactions.get(i).getPurchaseAmount();
			copy = copy + transactions.get(i).toString() + "\n";
			
		}
		double rebateAmount = sum * (rebateRate);
		double balance = this.getCurrentBalance() - rebateAmount;
		this.transactions.clear();
		
		copy = copy + "-----------------------------------------------------\n" 
					+ "Rebate received: $" + rebateAmount + "\n" 
					+ "Current Balance: $" + balance;
		if(balance > creditLimit)
		{
			copy = copy + "\n" + "ACCOUNT OVERDRAWN BY: " + (balance - creditLimit); 
		}
		return copy;				
	}

}