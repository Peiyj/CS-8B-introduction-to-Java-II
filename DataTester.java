import java.io.IOException;
import java.util.ArrayList;

/**
 *  File: DataTester.java
 *  Name: Ying Pei
 *  Date: April 19, 2016
 *  File: DataTester.java
 *  Sources of Help: None
 *
 * The purpose of this file is provide a tester to
 * aid students in testing their implementation of
 * the parseElectionFile method. Uses the data file 
 * ElectionData2012And2016.csv as the file input.
 */

public class DataTester {


	public static void main(String[] args) throws IOException {
		testParseElectionFile("ElectionData2012And2016_smaller.csv");

	}

	private static void testParseElectionFile(String string) throws IOException {
		// Create ElectionData object so can call on parseElectionFile method
		ElectionData elec = new ElectionData();
		elec.parseElectionFile("ElectionData2012And2016.csv");

		// get the Arraylists containing county results for 12/16
		ArrayList<CountyElectionResult> testCount12 = elec.getCountyResults2012();
		ArrayList<CountyElectionResult> testCount16 = elec.getCountyResults2016();

		// get the Arraylists containing state election results for 12/16
		ArrayList<StateElectionResult> testState12 = elec.getStateResults2012();
		ArrayList<StateElectionResult> testState16 = elec.getStateResults2016();

		// check size of Arraylists
		if (testCount12 == null || testCount16 == null || testCount12.size() != 3113 || testCount16.size() != 3113) {
			System.out.println("Size of ArrayList for county results fails!");
			return;
		}

		if (testState12 == null || testState16 == null || testState12.size() != 51 || testState16.size() != 51) {
			System.out.println(testState12.size());
			System.out.println("Size of ArrayList for state results fails!");
			return;
		}

		// check County ArrayList entries
		for (int i = 0; i < testCount12.size(); i++) {
			if (testCount12.get(i).getState().length() != 2 || testCount16.get(i).getState().length() != 2) {
				System.out.print("Invalid state found");
				return;
			}
			if (testCount12.get(i).getFips().length() != 5 || testCount16.get(i).getFips().length() != 5) {
				System.out.println(testCount16.get(i).getFips().length());
				System.out.print("Invalid FIPS found");
				return;
			}
			if (testCount12.get(i).getYear() != "2012" || testCount16.get(i).getYear() != "2016") {
				System.out.println("Invalid year entry!");
				return;
			}

			Object test12 = (Object) testCount12.get(i).getNumVotesDem();
			Object test16 = (Object) testCount16.get(i).getNumVotesDem();
			if (test12 instanceof Integer == false || test16 instanceof Integer == false) {
				System.out.println("Invalid Democratic vote entry!");
				return;
			}

			test12 = (Object) testCount12.get(i).getNumVotesGop();
			test16 = (Object) testCount16.get(i).getNumVotesGop();
			if (test12 instanceof Integer == false || test16 instanceof Integer == false) {
				System.out.println("Invalid Republican vote entry!");
				return;
			}

			test12 = (Object) testCount12.get(i).getNumVotesOther();
			test16 = (Object) testCount16.get(i).getNumVotesOther();
			if (test12 instanceof Integer == false || test16 instanceof Integer == false) {
				System.out.println("Invalid 3rd party vote entry!");
				return;
			}
		}

		// check State ArrayList entries
		for (int i = 0; i < testState12.size(); i++) {
			if (testState12.get(i).getState().length() != 2 || testState16.get(i).getState().length() != 2) {
				System.out.print("Invalid state found");
				return;
			}
			if (testState12.get(i).getYear() != "2012" || testState16.get(i).getYear() != "2016") {
				System.out.println("Invalid year entry!");
				return;
			}

			Object test12 = (Object) testState12.get(i).getNumVotesDem();
			Object test16 = (Object) testState16.get(i).getNumVotesDem();
			if (test12 instanceof Integer == false || test16 instanceof Integer == false) {
				System.out.println("Invalid Democratic vote entry!");
				return;
			}

			test12 = (Object) testState12.get(i).getNumVotesGop();
			test16 = (Object) testState16.get(i).getNumVotesGop();
			if (test12 instanceof Integer == false || test16 instanceof Integer == false) {
				System.out.println("Invalid Republican vote entry!");
				return;
			}

			test12 = (Object) testState12.get(i).getNumVotesOther();
			test16 = (Object) testState16.get(i).getNumVotesOther();
			if (test12 instanceof Integer == false || test16 instanceof Integer == false) {
				System.out.println("Invalid 3rd party vote entry!");
				return;
			}
		}
		System.out.println("You passed all the tests! Congrats!");

	}

}
