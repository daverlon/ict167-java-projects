
/**
 * Student_Reserach.java
 * @author David Long
 * 29/10/22
 * Student_Research class which represents a student that has
 * taken a research class. It inherits the Student base class and
 * uses the Research class as a private variable class instance.
 */

public class Student_Research extends Student {

	private Research _classCourse;	// Instance of Research class, storing class information and marks.

	/**
	 * Default constructor which takes no arguments.
	 * It will use the Research class constructor with no arguments
	 * to create an instance with zero'd values.
	 */
	public Student_Research() {
		super();
		_classCourse = new Research();
		_classCourse.CalculateOverallMark();
		_classCourse.CalculateFinalGrade();
	}
	
	/**
	 * Constructor which takes all required arguments for the student
	 * and the Research class. It will automatically calculate the overall mark
	 * since the marks are assumed to be received.
	 * 
	 * @param firstName					First name of the student
	 * @param lastName					Last name of the student
	 * @param studentID					Student ID number
	 * @param propsal					Mark (percentage) for the proposal assignment
	 * @param finalDissertationMark		Mark (percentage) for the final dissertation assignment
	 */
	public Student_Research(String firstName, String lastName, long studentID, int propsalMark, int finalDissertationMark) {
		super(firstName, lastName, studentID);
		_classCourse = new Research(propsalMark, finalDissertationMark);
		CalculateOverallMark();
	}
	
	/**
	 * Function which outputs the student's information along with their
	 * course marks to the standard output for viewing.
	 * 
	 * @return void
	 */
	public void ReportGrade() {
		CalculateOverallMark();
		String out = "";
		out += String.format("Type=%s,", _classCourse.GetEnrolmentType());
		out += String.format("FirstName=%s,LastName=%s,", GetFirstName(), GetLastName());
		out += String.format("StudentID=%d,", GetID());
		out += String.format("OverallMark=%d,", _classCourse.GetOverallMark());
		out += String.format("FinalGrade=%s", _classCourse.GetFinalGrade());

		System.out.println(out);
	}
	
	/**
	 * Function which formats all the student information and research course information.
	 * This can be used to output the student details to a .CSV file.
	 * Research Students which have their information stored in a .CSV file should be in this format.
	 * 
	 * @return		String formatted with all the student and course information separated by a comma.
	 */
	public String GetInformation() {
		String ret = String.format("Type=%s,FirstName=%s,LastName=%s,StudentID=%d,ProposalMark=%d,FinalDissertationMark=%d",
						_classCourse.GetEnrolmentType(),
						GetFirstName(),
						GetLastName(),
						GetID(),
						_classCourse.GetProposalMark(),
						_classCourse.GetFinalDissertationMark());
		return ret;
	}
		
	/**
	 * Calls the overall mark get method from the private Research class instance.
	 * 
	 * @return 			Integer representing the overall mark of this student.
	 */
	public int GetOverallMark() {
		return _classCourse.GetOverallMark();
	}
	
	/**
	 * Calls the calculation methods from the private Research class instance.
	 * This will update the Research overall mark and final grade variables internally.
	 * 
	 * @return void
	 */	
	public void CalculateOverallMark() {
		_classCourse.CalculateOverallMark();
		_classCourse.CalculateFinalGrade();
	}
}
