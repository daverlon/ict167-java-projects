
/**
 * Research.java
 * @author David Long
 * 29/10/22
 * Research unit class which inherits the Unit base class.
 */


public class Research extends Unit {
	
	private int _proposalMark;				// 40% of overall mark
	private int _finalDissertationMark;		// 60% of overall mark
	
	/**
	 * Default constructor with no arguments
	 */
	public Research() {
		super();
		SetEnrolmentType("R");
		SetProposalMark(0);
		SetFinalDissertationMark(0);
	}
	
	/**
	 * Constructor which takes the mark for both assignments
	 * 
	 * @param proposalMark				Mark (percentage out of 100) which represents 40% of the overall mark.
	 * @param finalDissertationMark		Mark (percentage out of 100) which represents 60% of the overall mark.
	 */
	public Research(int proposalMark, int finalDissertationMark) {
		super();
		SetEnrolmentType("R");
		SetProposalMark(proposalMark);
		SetFinalDissertationMark(finalDissertationMark);
	}
	
	/**
	 * Function which calculates the overall mark (internally overrides the value)
	 * it is assumed that PropsalMark and FinalDisssertationMark are already set.
	 * 
	 * @return void
	 */
	public void CalculateOverallMark() { 
		float weightedResult = 0.0f;
		weightedResult += (float)GetProposalMark() * 0.4f; 
		weightedResult += (float)GetFinalDissertationMark() * 0.6f;
		
		// set the overall mark
		SetOverallMark((int)weightedResult);
	}

	/**
	 * Get and set methods.
	 */
	
	public void SetProposalMark(int mark) { _proposalMark = mark; }
	public int GetProposalMark() { return _proposalMark; }
	
	public void SetFinalDissertationMark(int mark) { _finalDissertationMark = mark; }
	public int GetFinalDissertationMark() { return _finalDissertationMark; }
}
