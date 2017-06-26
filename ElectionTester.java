/**
 * File: CountyElectionResult.java
 *  Name: Ying Pei
 *  Date: April 19, 2016
 *  Sources of Help: None
 *
 * 
 * The purpose of this file is to write a tester to verify the methods implemented 
 * in Part 2c.
 */

/**
 * @author Sriram
 *
 */
import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.ArrayList;

public class ElectionTester {

	public static void main(String[] args) throws IOException {
		int passed_tests = 0;
		ElectionData elecSmall = new ElectionData();
		elecSmall.parseElectionFile("ElectionData2012And2016_smaller.csv");
		ElectionData elecBig = new ElectionData();
		elecBig.parseElectionFile("ElectionData2012And2016.csv");
		if (runTestMostLopSidedCounty(elecSmall))
			passed_tests++;
		if (runTestNumCountiesVotedForWinner(elecBig))
			passed_tests++;
		if (runTestMostThirdParty(elecSmall))
			passed_tests++;
		if (runTestleastDemocraticParty(elecSmall))
			passed_tests++;
		if (passed_tests <= 2) {
			System.out.println("Only " + passed_tests + " methods are correctly implemented. "
					+ "You need to implement atleast 3 out of the 4 methods in the write up correctly "
					+ "to get full credit");
		} else {
			System.out.println(
					"You have passed all submission tests.");

		}

	}

	private static boolean runTestMostLopSidedCounty(ElectionData elec) {
		CountyElectionResult county = elec.mostLopsidedCounty("2012");
		if (county.getCounty().equals("District of Columbia") && county.getState().equals("DC")) {
			System.out.println("mostLopSidedCounty Test passes for valid input");
			county = elec.mostLopsidedCounty("2013");
			if (county == null) {
				System.out.println("mostLopSidedCounty Test passes for invalid input");
				return true;
			} else {
				System.out.println("mostLopSidedCounty Test fails for invalid input");
				return false;
			}
		}
		System.out.println("mostLopSidedCounty Test fails for valid input");
		return false;
	}

	private static boolean runTestNumCountiesVotedForWinner(ElectionData elec) {

		if ((elec.numCountiesVotedForWinner("CT", "2016") == 2)
				&& (elec.numCountiesVotedForWinner("CO", "2016") == 37)) {
			System.out.println("numCountiesVotedForWinner Test passes for valid input");
		} else {
			System.out.println("numCountiesVotedForWinner Test fails for valid input");
			return false;
		}
		if (elec.numCountiesVotedForWinner("CT", "20") != -1) {
			System.out.println(elec.numCountiesVotedForWinner("CT", "20"));
			System.out.println("numCountiesVotedForWinner Test fails for invalid input");
			return false;
		}
		System.out.println("numCountiesVotedForWinner Test passes for invalid input");
		return true;
	}

	private static boolean runTestMostThirdParty(ElectionData elec) {
		if (elec.mostThirdParty("2016").equals("ID") && elec.mostThirdParty("2012").equals("AK")) {
			System.out.println("mostThirdParty Test passes for valid input");
			if (!elec.mostThirdParty("2011").isEmpty()) {
				System.out.println("mostThirdParty Test fails for invalid input");
				return false;
			} else {
				System.out.println("mostThirdParty Test passes for invalid input");
				return true;
			}
		}
		System.out.println("mostThirdParty Test fails for valid input");
		return false;
	}
	
	private static boolean runTestleastDemocraticParty(ElectionData elec) {
		
		if ( (elec.leastDemocraticParty("2016") < 0.161 && 
			 (elec.leastDemocraticParty("2016") > 0.160)) && 
		     (elec.leastDemocraticParty("2012") < 0.127) &&
		     (elec.leastDemocraticParty("2012") > 0.126))  		
		    		{
			System.out.println("leastDemocraticParty Test passes for valid input");
			if (elec.leastDemocraticParty("2010") != -1) {
				System.out.println("leastDemocraticParty Test fails for invalid input");
				return false;
			} else {
				System.out.println("leastDemocraticParty Test passes for invalid input");
				return true;
			}
		}
		System.out.println("leastDemocraticParty Test fails for valid input");
		return false;
	}
}
