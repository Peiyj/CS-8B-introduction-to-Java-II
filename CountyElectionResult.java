/**
 * Name: Ying Pei
 *  Date: April 19, 2016
 *  File: CountyElectionTester.java
 *  Sources of Help: None
 * 
 * The purpose of this file is to define a class to hold the election
 * result from a particular year from a particular county.
 */

/**
 * @author Christine
 *
 */
public class CountyElectionResult {
	private String state;  // The state where the result is from
	private String county; // The county where the result is from
	private String fips;   // The fips (unique county identifier)
	private String year;   // The year of the election
	private int numVotesDem;  // The number of votes for dem. candidate
	private int numVotesGop;  // The number of votes for gop candidate
	private int numVotesOther;  // The number of votes for another candidate
	
	/**
	 * Create a new CountyElectionResult object
	 * @param stateIn  The state where the result is from
	 * @param countyIn  The county where the result is from
	 * @param fipsIn  The fips code for the county
	 * @param yearIn  The year of the election
	 * @param nDem    The number of votes for the democatic candidate
	 * @param nGop    The number of votes for the GOP candidate
	 * @param nOther  The combined number of votes for other candidates
	 */
	public CountyElectionResult(String stateIn, String countyIn,
			String fipsIn, String yearIn, int nDem, int nGop, int nOther) {
		state = stateIn;
		county = countyIn;
		fips = fipsIn;
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
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @return the fips
	 */
	public String getFips() {
		return fips;
	}

	/**
	 * @param fips the fips to set
	 */
	public void setFips(String fips) {
		this.fips = fips;
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
