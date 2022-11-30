
/**
 * Unit_Course.java
 * @author David Long
 * 29/10/22
 * Course unit class which inherits the base class Unit.
 * Represents course work.
 */


public class Unit_Course extends Unit {

	private String _unitID;			// ID of the unit (ie. ICT333)
	private int _unitLevel;			// Year of the unit (ei. 3 = third year)
	
	private int _assignment1Mark;	// Assignment representing 30% of the overall mark
	private int _assignment2Mark;	// Assignment representing 30% of the overall mark
	private int _finalExamMark;		// Final exam representing 40% of the overall mark
	
	/**
	 * Default constructor with no arguments.
	 * It will set all values to null or zero (aside from the enrolment type C).
	 */
	public Unit_Course() {
		super();
		SetEnrolmentType("C");
		SetUnitID("null");
		SetAssignment1Mark(0);
		SetAssignment2Mark(0);
		SetFinalExamMark(0);
	}
	
	/**
	 * Constructor with all required information about the specific course and
	 * the assignment + exam marks.
	 * 
	 * @param unitID			ID of the unit (ie. ICT333).
	 * @param unitLevel			Year of the unit (ie. 3 = third year).
	 * @param a1Mark			Mark for assignment 1.
	 * @param a2Mark			Mark for assignment 2.
	 * @param examMark			Mark for the final exam.
	 */
	public Unit_Course(String unitID, int unitLevel, int a1Mark, int a2Mark, int examMark) {
		super();
		SetEnrolmentType("C");
		SetUnitID(unitID);
		SetUnitLevel(unitLevel);
		SetAssignment1Mark(a1Mark);
		SetAssignment2Mark(a2Mark);
		SetFinalExamMark(examMark);
	}
	
	/**
	 * Calculates the overall mark based on the marks saved for both assignments
	 * and the final exam. It weights those marks and calculates the correct final result.
	 * 
	 * @return void
	 */
	public void CalculateOverallMark() { 
		float weightedResult = 0.0f;
		weightedResult += (float)GetAssignment1Mark() * 0.3f;
		weightedResult += (float)GetAssignment2Mark() * 0.3f;
		weightedResult += (float)GetFinalExamMark() * 0.4f;
		
		// set the overall mark
		SetOverallMark((int)weightedResult);
	}
	
	// -------- Get and set methods for internal values. -------- //
	
	public void SetUnitID(String unitID) { _unitID = unitID; }
	public String GetUnitID() { return _unitID; }
	
	public void SetUnitLevel(int level) { _unitLevel = level; }
	public int GetUnitLevel() { return _unitLevel; }
	
	public void SetAssignment1Mark(int mark) { _assignment1Mark = mark; }
	public int GetAssignment1Mark() { return _assignment1Mark; }
	
	public void SetAssignment2Mark(int mark) { _assignment2Mark = mark; }
	public int GetAssignment2Mark() { return _assignment2Mark; }	
	
	public void SetFinalExamMark(int mark) { _finalExamMark = mark; }
	public int GetFinalExamMark() { return _finalExamMark; }
}
