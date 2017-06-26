import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

/**
 *  File: ElectionData.java
 *  Name: Ying Pei
 *  Date: April 19, 2016
 *  Sources of Help: None
 *  
 * This file builds a class that can parse election results 
 * from a csv file containing results from 2012 and 2016, by county.
 * This file has three sections: part A, part B and part C.
 * In part A, the method takes parameter of the string and returns void using 
 * one of the helper method. The purpose is to allow the file to be parsed into
 * fields.
 * In part B, I write a user interactive program that allows the users to enter
 * what question they wished to be answered using scanner input.
 * Inp part C, I write four methods to help answer part B.
 */

/**
 * A class to parse a specifically formatted CSV file containing election
 * results.
 *
 */
public class ElectionData 
{
	
	// A list of results at the county level in 2012
	ArrayList<CountyElectionResult> countyResults2012;
	
	// A list of results at the county level in 2016
	ArrayList<CountyElectionResult> countyResults2016;

	// Lists of results at the state level in 2012 and 2016
	// YOU DO NOT HAVE TO USE THESE LISTS, BUT MIGHT FIND
	// THEM USEFUL.
	ArrayList<StateElectionResult>  stateResults2012;
	ArrayList<StateElectionResult>  stateResults2016;
	
	ArrayList<CountyElectionResult> getCountyResults2012() {
		return countyResults2012;
	}

	ArrayList<CountyElectionResult> getCountyResults2016() {
		return countyResults2016;
	}

	ArrayList<StateElectionResult> getStateResults2012() {
		return stateResults2012;
	}

	ArrayList<StateElectionResult> getStateResults2016() {
		return stateResults2016;
	}
	
	/*
	 * Initialize all the results lists to be empty.
	 */
	public ElectionData() 
	
	{
		//This is a constructor
		countyResults2012 = new ArrayList<CountyElectionResult>();
		countyResults2016 = new ArrayList<CountyElectionResult>();

		stateResults2012 = new ArrayList<StateElectionResult>();
		stateResults2016 = new ArrayList<StateElectionResult>();
	}
	
	
	
	 /* Part A: method 1
	  * This method parses a file of election results containing results from 
	 * two years of elections: 2012 and 2016 
	 * Each line in the file has the following fields, separated by commas:
	 * state_abbr,county_name,fips,state_fips,county_fips,
	 * total_votes_2012,votes_dem_2012,votes_gop_2012,total_votes_2016,
	 * votes_dem_2016,votes_gop_2016
	 * This function does not need to handle incorrectly formatted files.
	 * It can simply throw an exception if there is a problem with the file
	 * or if any of the lines are not formatted correctly.
	 */
	public void parseElectionFile(String filename) throws IOException 
	{   
		//declare a file name and scanner to read the file
		File file = new File(filename);
	    Scanner input = new Scanner(file);
	    //this is to skip the first line of code
	    input.nextLine();
	    //if there is a next line, use parse method
	    while(input.hasNextLine())
	    {
	      this.parseLine(input.nextLine());
	    }
	    
	    ArrayList<CountyElectionResult> twok12 = this.getCountyResults2012();
	    ArrayList<CountyElectionResult> twok16 = this.getCountyResults2016();
	    
	    //organise the state results
	  	    
	    String [] state = {"AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", 
	    		           "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", 
	    		           "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", 
	    		           "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", 
	    		           "WI", "WV", "WY"};
	    //allow the user to choose a state
	    for( int i = 0; i < state.length; i++)
	    {
	    	int votes_dem_2012 = 0;
		    int votes_gop_2012 = 0;
		    int votes_others_2012 = 0;
		    int votes_dem_2016 = 0;
		    int votes_gop_2016 = 0;
		    int votes_others_2016 = 0;
	    	//this allows user to see the 2012 data
	    	for(int x = 0; x < twok12.size(); x++)
	    	{
	          String current12 = twok12.get(x).getState();
	          	if(current12.equals(state[i]))
	         	{
	             CountyElectionResult temp1 = twok12.get(x);
	        	 votes_dem_2012 = votes_dem_2012 + temp1.getNumVotesDem();
	        	 votes_gop_2012 = votes_gop_2012 + temp1.getNumVotesGop();
	        	 votes_others_2012 =  votes_others_2012 + temp1.getNumVotesOther();
	         	}
	    	}
	       //this allows user to see the 2016 data
	    	for(int y = 0; y <  twok16.size(); y++) 		
	    	{
	    		CountyElectionResult temp2 = twok16.get(y);
	    		String current16 =temp2.getState();
	          	if(current16.equals(state[i]))
	         	{
	        	 votes_dem_2016 = votes_dem_2016 + temp2.getNumVotesDem();
	        	 votes_gop_2016 = votes_gop_2016 + temp2.getNumVotesGop();
	        	 votes_others_2016 = votes_others_2016 + temp2.getNumVotesOther();
	         	}
	    	}
	    
	    StateElectionResult currenttwok12 = new StateElectionResult(state[i],"2012", votes_dem_2012,
	    															votes_gop_2012,votes_others_2012);
	    StateElectionResult currenttwok16 = new StateElectionResult(state[i],"2016", votes_dem_2016,
																	votes_gop_2016,votes_others_2016);
	    this.stateResults2012.add(currenttwok12);
	    this.stateResults2016.add(currenttwok16);  
	    }
	    input.close();
	}

	
	 /* Part 2C: method 1
	  * This method investigates the county that had the greatest 
	  * difference (absolute value) 
	  * It takes an input of the year as a string
	  * If user enters invalid number, it will return null
	  * If it is either 2012 or 2016, it will return CountyElectionResult object 
	  * with the most lopsided results between dem and gop.
	  */
	CountyElectionResult mostLopsidedCounty(String year) 
	{
		// if user enters null, return null
		if(year == null)
		{
			return null;
		}
		//if the year chooses year 2012
		if(year.equals("2012"))
		{
			//Each countyElectionResult object is one line
			//The arraylist holds every county election result objects

			//loop through every object
			ArrayList<CountyElectionResult> twok12 = this.getCountyResults2012();
			double max = 0;
			int maxIndex = 0;
			for(int i = 0; i < twok12.size(); i++)
			{
				//get the democratic votes of each countyElectionResult object
				double dem = (double) twok12.get(i).getNumVotesDem();
				//get the republican votes of each countyElectionResult object
				double rep = (double) twok12.get(i).getNumVotesGop();
				//get the other votes of each countyElectionResult object
				double other = (double) twok12.get(i).getNumVotesOther();
				double difference = Math.abs(dem - rep);		
				double ratio =  difference / (dem + rep + other);
				double current = ratio;
				if(current > max)
				{
					max = current;
					maxIndex = i;
				}
			}
			return twok12.get(maxIndex);
		}
		if(year.equals("2016"))
		{
			//loop through every object
			ArrayList<CountyElectionResult> twok16 = this.getCountyResults2016();
			double max1 = 0;
			int maxIndex1 = 0;
			for(int i = 0; i < twok16.size(); i++)
			{
				//get the democratic votes of each countyElectionResult object
				double dem1 =(double) twok16.get(i).getNumVotesDem();
				//get the republican votes of each countyElectionResult object	
				double rep1 = (double) twok16.get(i).getNumVotesGop();
				//get the other votes of each countyElectionResult object
				double other1 = (double) twok16.get(i).getNumVotesOther();
				double difference1 = Math.abs(dem1 - rep1);		
				double ratio1 = difference1 / (dem1 + rep1 + other1);
				double current1 = ratio1;
				if(current1 > max1)
				{
					max1 = current1;
					maxIndex1 = i;
				}			
			}
			return twok16.get(maxIndex1);
		}
		else
		{
			return null;
		}
	}

	/*
	 * Part 2C: Method 2
	 * This method investigates the number of counties 
	 * whose majority vote actually aligned with the presidential winner
	 * It takes in two String arguments: a state abbreviation and year (either 2012 or 2016)
	 * It then returns the number of counties 
	 * If user ends invalid number, it will return -1.
	 */
	int numCountiesVotedForWinner(String stateAbbr, String year) 
	{
		int count = 0;
		// TODO: Implement this method and replace the return statement	
		if(year.equals("2012"))
		{
			ArrayList<CountyElectionResult> twok12 = this.getCountyResults2012();
			for(int i = 0; i < twok12.size(); i++)
			{

				double nOther = (double)twok12.get(i).getNumVotesOther();
				double nDem = (double)twok12.get(i).getNumVotesDem();
				double nRep = (double)twok12.get(i).getNumVotesGop();
				String state = twok12.get(i).getState();
				if(state.equals(stateAbbr))
				{
					double PercentageOfDem = nDem / (nOther + nDem + nRep);
					if(PercentageOfDem > 0.5)
					{
						count += 1;
					}
				}
				
			}
			return count;
		}
		if(year.equals("2016"))
		{
			ArrayList<CountyElectionResult> twok16 = this.getCountyResults2016();
			for(int i = 0; i < twok16.size(); i++)
			{

				double nOther1 = (double)twok16.get(i).getNumVotesOther();
				double nDem1 = (double)twok16.get(i).getNumVotesDem();
				double nRep1 = (double)twok16.get(i).getNumVotesGop();
				String state1 = twok16.get(i).getState();
				if(state1.equals(stateAbbr))
				{
					double PercentageOfRep = nRep1 / (nOther1 + nDem1 + nRep1);
					if(PercentageOfRep > 0.5)
					{
						count += 1;
					}
				}		
			}
			return count;
		}
		else if(!(year.equals("2012")||year.equals("2016")))
		{
			return -1;
		}
		return 0;
	}

	/*
	 * Part 2C: Method 3
	 * This method investigates the most third party voters
	 * percentage in each county
	 * It takes in the input of year as a string
	 * It then returns the state with the most number of 3rd party voters
	 *
	 */
	String mostThirdParty(String year) 
	{
		if(year.equals("2012"))
		{
			ArrayList<StateElectionResult> twok12 = this.getStateResults2012();	
			 double max = 0;
			 int maxIndex = 0;
			for(int i = 0; i < twok12.size(); i++)
			{
				//get the number of third party voters
			 double nOther = (double)twok12.get(i).getNumVotesOther();
			 double nDem = (double)twok12.get(i).getNumVotesDem();
			 double nRep = (double)twok12.get(i).getNumVotesGop();
			 double percentage = nOther / (nOther + nDem + nRep);
			 //this ensures there would not be a tie
			 if(percentage > max)
				{
					max = percentage;
					maxIndex = i;
				}	 
			}
			//returns a string of state abbreviation
			return twok12.get(maxIndex).getState();
		}
		if(year.equals("2016"))
		{
			ArrayList<StateElectionResult> twok16 = this.getStateResults2016();	
			 double max1 = 0;
			 int maxIndex1 = 0;
			for(int i = 0; i < twok16.size(); i++)
			{
				//get the number of third party voters
			 double nOther1 = (double)twok16.get(i).getNumVotesOther();
			 double nDem1 = (double)twok16.get(i).getNumVotesDem();
			 double nRep1 = (double)twok16.get(i).getNumVotesGop();
			 double percentage1 = nOther1 / (nOther1 + nDem1 + nRep1);
			 //this ensures there would not be a tie
			 if(percentage1 > max1)
				{
					max1 = percentage1;
					maxIndex1 = i;
				}	 
			}
			//returns a string of state abbreviation
			System.out.println(twok16.get(maxIndex1).getState());
			return twok16.get(maxIndex1).getState();
		}	
		else
		{
			return "";
		}
	}
	/*
	 * This method will be ignored
	 */
	ArrayList<ArrayList<String>> switchedParties() {

		  ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		  ArrayList<String> demToRep = new ArrayList<String>();
		  ArrayList<String> repToDem = new ArrayList<String>();

		  results.add(demToRep);
		  results.add(repToDem);

		  return results;
		 }


	/*
	 * Part 2C: Method 4
	 * This method takes in a String representing the year of the election 
	 * It returns the least percentage of voters for a democratic party candidate among every state in that year. 
	 * If there is a tie the method should return the same value.  
	 * If the year is invalid (including null), the method should return an empty string.
	 */

	double leastDemocraticParty(String year)
	{
		if(year.equals("2012"))
		{
			ArrayList<StateElectionResult> twok12 = this.getStateResults2012();	
			 double min = 1.0;
			for(int i = 0; i < twok12.size(); i++)
			{
				//get the number of third party voters
			 double nOther = (double)twok12.get(i).getNumVotesOther();
			 double nDem = (double)twok12.get(i).getNumVotesDem();
			 double nRep = (double)twok12.get(i).getNumVotesGop();
			 double percentage = nDem / (nOther + nDem + nRep);
			 double current = percentage;
			 //this ensures there would not be a tie
			 if(current < min)
				{
					min = current;
				}	 
			}
			//returns a the minimal percentage
			return min;
		}
		if(year.equals("2016"))
		{
			ArrayList<StateElectionResult> twok16 = this.getStateResults2016();	
			 double min1 = 1;
			for(int i = 0; i < twok16.size(); i++)
			{
				//get the number of third party voters
			 double nOther1 = (double)twok16.get(i).getNumVotesOther();
			 double nDem1 = (double)twok16.get(i).getNumVotesDem();
			 double nRep1 = (double)twok16.get(i).getNumVotesGop();
			 double percentage1 = nDem1 / (nOther1 + nDem1 + nRep1);
			 double current1 = percentage1;
			 //this ensures there would not be a tie
			 if(current1 < min1)
				{
					min1 = current1;

				}	 
			}
			//returns a string of state abbreviation
			return min1;
		}	
		else
		{
			return -1;
		}
	}

	
	/*
	 * Part 2B
	 * This method runs the main loop that controls the interaction with the user
	 * It prints the menu of choices for the user
	 * Then gets the user’s response
	 * Then check to make sure the user has entered a valid response
	 * Call the method in part 2c
	 * Print the result for the user. 
	 */
	public void runLoop() 
	{
		Scanner commandReader = new Scanner(System.in);
		String choice ="";
		String input ="";
		String input2= "";
		while(!choice.equals("0"))
		{
		System.out.println("What would you like to know?  Enter the number "
				           + "corresponding to your choice.\n" +
				           "1	Most lopsided county between dem and rep (param: year) \n" +
				           "2	How many counties align with the actual winner (param: year, param: state) \n" +
				           "3	State with max percent of votes for 3rd party candidate (param: year) \n" +
				           "4	The least percentage of democratic party among all states (param: year) \n" +
				           "0	Quit \n" +
							"Please enter your choice:");
		//get the user's input
			choice = commandReader.nextLine();
			if(choice.equals("1"))
			{
				System.out.println("Your choice is 1 \n" +
						           "Which year would you like to use?");
				input = commandReader.nextLine();
				CountyElectionResult answer = mostLopsidedCounty(input);
				if(answer == null)
				{
					System.out.println("You entered an invalid number. Please try again");
				}
				else
				{
					System.out.println("The answer is: " + answer);
				}
				
			}			
			else if(choice.equals("2"))
			{
				System.out.println("Your choice is 2 \n" +
								   "Which year would you like to use?");		  
					input = commandReader.nextLine();
				System.out.println("Which state would you like to use?");		  
					input2 = commandReader.nextLine();
				int answer = numCountiesVotedForWinner(input2, input);
				if(answer == -1)
				{
					System.out.println("You entered an invalid year.");
				}
				else if(answer == 0)
				{
					System.out.println("You entered an invalid response.");
				}
				else
				{
					System.out.println("In "+ input + "," + answer + " counties in " + input2 + " aligned with the winner.");
				}			
			}
			else if(choice.equals("3"))
			{
				System.out.println("Your choice is 3 \n" +
						           "Which year would you like to use?");
				input = commandReader.nextLine();
				String answer = mostThirdParty(input);
				if(answer.equals(""))
				{
					System.out.println("You entered an invalid number.");
				}
				else
				{
					System.out.println("The answer is: " + answer);
				}

			}
			else if(choice.equals("4"))
			{
				System.out.println("Your choice is 4 \n" +
						           "Which year would you like to use?");
				input = commandReader.nextLine();
				double answer = leastDemocraticParty(input);
				if(answer == -1)
				{
					System.out.println("You entered an invalid number.");
				}
				else
				{
					System.out.println("The answer is: " + answer);
				}
			
			}
			else if(choice.equals("0"))
			{
				System.out.println("see you!");
				return;
			}
			else
			{
				System.out.println("Please try again!");
			}
		}
		System.out.println("See you!");
		// TODO: Complete this method.  
		// If you call any helper methods that need to read
		// input from the user, pass the commandReader Scanner
		// object to these methods.  You don't want to have more than one
		// Scanner reading from System.in at the same time.	
		commandReader.close();
	}
	
	// TODO: Add private helper methods here.  Two are listed below,
	// and the parseLine method is required,
	// but feel free to add more to help you keep your methods above short.
	
	
	/**
	 * This method takes one line of the input file containing the election data,
	 * in the format described in the PA2 writeup.  It should parse the line
	 * and create two CountyElectionResult objects, one for 2012 results and
	 * one for 2016 results.  Then it should add each object to the appropriate
	 * ArrayList countyResults2012 and countyResults2016.
	 * 
	 * You will call this method from your parseElectionFile method.
	 * 
	 * @param line A single line from the election results file.
	 */
	/* Part A: method 2
	 * This method takes a parameter of a line as a string
	 * Then parse it into 11 fields
	 * Take these fields and add them to the two arraylist objects
	 * Then return void
	 * Purpose: it is a helper method for part A method 1
	 */
	private void parseLine(String line)
	{
		if(line.equals(""))
		{
			return;
		}
		String [ ] token = line.split(",");
		String state = token[0];
		String county = token[1];
		String fips = token [2];
		int nDem2012 = (int) Double.parseDouble(token [6]);
		int nGOP2012 = (int) Double.parseDouble(token [7]);
		int nOther2012 = (int)(Double.parseDouble(token [5]))-nGOP2012-nDem2012;
		int nDem2016 =(int) Double.parseDouble(token [9]);
		int nGOP2016 = (int)Double.parseDouble(token [10]);
		int nOther2016 = (int)(Double.parseDouble(token [8]))-nDem2016-nGOP2016;
		
		CountyElectionResult twok12 = new CountyElectionResult
				                   (state,county,fips,"2012",nDem2012,nGOP2012,nOther2012);
		CountyElectionResult twok16 = new CountyElectionResult
                                   (state,county,fips,"2016",nDem2016,nGOP2016,nOther2016);
		this.countyResults2012.add(twok12);
		this.countyResults2016.add(twok16);
	}
	
	/**
	 * A private helper function to print the options menu.  
	 * This method is not required, but STRONGLY recommended
	 * so that your runLoop method stays short.
	 */
	private void printOptions()
	{
		
	}

	
	/** 
	 * A command line program to allow the user to interact with the election
	 * data.
	 * 
	 * You do not need to modify the main method, but you should understand 
	 * what it does.
	 * 
	 * @param args The program takes the name of the file as a command line
	 * argument.
	 */
	public static void main(String[] args) {	
		// We will provide the code that reads the command line argument
		if (args.length < 1) {
			System.out.println("No data file passed in");
			return;
		}
		ElectionData data = new ElectionData();
		// Call the parseElectionFile method to read in the data
		try {
			data.parseElectionFile(args[0]);
		}
		catch (IOException e) {
			System.out.println("There was a problem with the data file");
			e.printStackTrace();
			return;
		}
		// Run the main loop
		data.runLoop();
		
	}
	
}
