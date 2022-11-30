
/**
 * Unit.java
 * @author David Long
 * 28/10/22
 * Base Unit class which holds the basic course information.
 * Generic functions are placed here.
 */

public class Unit {
	
	private String _enrolmentType;		// Enrolment type, "C" for course work, "R" for research work.
	private int _overallMark;			// Overall mark, to be weighted with course specific assignments.
	private String _finalGrade;			// Final grade represented by a letter.
	
	/**
	 * Default constructor which takes no arguments.
	 * It will set all variables to zero or null.
	 */
	public Unit() {
		SetEnrolmentType("NA");
		SetOverallMark(0);
		_finalGrade = "null";
	}
	
	/**
	 * Function which prints the grade information to the standard output.
	 * It should be replaced by course specific implementations.
	 * 
	 * @return void
	 */
	public void ReportGrade() { 
		System.out.println("NA");
	}
	
	/**
	 * Converts the overall mark (int) to the corresponding grade letter.
	 * 
	 * @return void
	 */
	public void CalculateFinalGrade() {	
		// set the final grad
		if (_overallMark == 0)  	 _finalGrade = "NA";
		else if (_overallMark >= 80) _finalGrade = "HD";
		else if (_overallMark >= 70) _finalGrade = "D";
		else if (_overallMark >= 60) _finalGrade = "C";
		else if (_overallMark >= 50) _finalGrade = "P";
		else if (_overallMark < 50)  _finalGrade = "N";
	}
	
	/**
	 * Get and set methods for private variables.
	 */	
	public void SetEnrolmentType(String type) { _enrolmentType = type; }
	public String GetEnrolmentType() { return _enrolmentType; }
	
	public void SetOverallMark(int mark) { _overallMark = mark; }
	public int GetOverallMark() { return _overallMark; }
	
	public String GetFinalGrade() { return _finalGrade; }
}
