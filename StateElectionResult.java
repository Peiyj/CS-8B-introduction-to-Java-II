/**
 * File: StateElectionResult.java
 *  Name: Ying Pei
 *  Date: April 19, 2016
 *  Sources of Help: None
 *
 * 
 * The purpose of this file is to define a class to hold the election
 * result from a particular year from a particular state.  
 * 
 * You MIGHT want to use this class, but it is not required.
 * It might be useful to aggregate the data across the counties 
 * to have access to state-level results.
 */

/**
 * This is a class to hold the results from an single county in a 
 * single election year.
 *
 */
public class StateElectionResult {
	private String state;  // The state where the result is from
	private String year;   // The year of the election
	private int numVotesDem;  // The number of votes for dem. candidate
	private int numVotesGop;  // The number of votes for gop candidate
	private int numVotesOther;  // The number of votes for another candidate
	
	/**
	 * Create a new StateElectionResult object
	 * @param stateIn  The state where the result is from
	 * @param yearIn  The year of the election
	 * @param nDem    The number of votes for the democatic candidate
	 * @param nGop    The number of votes for the GOP candidate
	 * @param nOther  The combined number of votes for other candidates
	 */
	public StateElectionResult(String stateIn, String yearIn,
			int nDem, int nGop, int nOther) {
		state = stateIn;
		year = yearIn;
		numVotesDem = nDem;
		numVotesGop = nGop;
		numVotesOther = nOther;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the numVotesDem
	 */
	public int getNumVotesDem() {
		return numVotesDem;
	}

	/**
	 * @param numVotesDem the numVotesDem to set
	 */
	public void setNumVotesDem(int numVotesDem) {
		this.numVotesDem = numVotesDem;
	}

	/**
	 * @return the numVotesGop
	 */
	public int getNumVotesGop() {
		return numVotesGop;
	}

	/**
	 * @param numVotesGop the numVotesGop to set
	 */
	public void setNumVotesGop(int numVotesGop) {
		this.numVotesGop = numVotesGop;
	}

	/**
	 * @return the numVotesOther
	 */
	public int getNumVotesOther() {
		return numVotesOther;
	}

	/**
	 * @param numVotesOther the numVotesOther to set
	 */
	public void setNumVotesOther(int numVotesOther) {
		this.numVotesOther = numVotesOther;
	}

	
}
