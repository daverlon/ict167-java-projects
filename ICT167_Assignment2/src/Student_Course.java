
/**
 * Student_Course.java
 * @author David Long
 * 29/10/22
 * Student_Course class which represents a student that has taken a
 * unit work course. It inherits the Student base class and uses
 * the Unit_Course class as a private variable.
 */

public class Student_Course extends Student {

	private Unit_Course _classCourse;	// Instance of Unit_Course, which holds the course marks and details for this student.

	
	/**
	 * Default constructor which takes no arguments.
	 * It will call the Unit_Course constructor with no arguments,
	 * resulting in zero marks and all default values.
	 */
	public Student_Course() {
		super();
		_classCourse = new Unit_Course();
	}
	
	/**
	 * Constructor which takes all necessary information about the student and the Unit_Course.
	 * It will automatically calculate overall mark (stored in Unit_Course).
	 * 
	 * @param firstName				First name of the student		(String)
	 * @param lastName				Last name of the student		(String)
	 * @param studentID				The student's ID number			(long)
	 * @param unitID				The Unit's ID					(String)
	 * @param unitLevel				The year of the Unit			(int)
	 * @param a1Mark				Assignment 1 mark				(int)
	 * @param a2Mark				Assignment 2 mark				(int)
	 * @param examMark				Final exam mark					(int)
	 */
	public Student_Course(String firstName, String lastName, long studentID, String unitID, int unitLevel, int a1Mark, int a2Mark, int examMark) {
		super(firstName, lastName, studentID);
		_classCourse = new Unit_Course(unitID, unitLevel, a1Mark, a2Mark, examMark);
		CalculateOverallMark();
	}
	
	/**
	 * Function which prints to the standard output the relevant course information for this student.
	 * It will calculate the overall mark before printing, in case it is not already calculated.
	 * 
	 * @return void
	 */
	public void ReportGrade() {	
		CalculateOverallMark();
		String out = "";
		out += String.format("Type=%s,", _classCourse.GetEnrolmentType());
		out += String.format("FirstName=%s,LastName=%s,", GetFirstName(), GetLastName());
		out += String.format("StudentID=%d,", GetID());
		out += String.format("UnitID=%s,", _classCourse.GetUnitID());
		out += String.format("Level=%d,", _classCourse.GetUnitLevel());
		out += String.format("OverallMark=%d,", _classCourse.GetOverallMark());
		out += String.format("FinalGrade=%s", _classCourse.GetFinalGrade());
		System.out.println(out);
	}
	
	/**
	 * Function which formats all the student information and course information.
	 * This can be used to output the student details to a .CSV file.
	 * Course_Work Students which have their information stored in a .CSV file should be in this format.
	 * 
	 * @return			String formatted with all the student and course information separated by a comma.
	 */
	public String GetInformation() {
		String ret = String.format("Type=%s,FirstName=%s,LastName=%s,StudentID=%d,UnitID=%s,UnitLevel=%d,Assignment1Mark=%d,Assignment2Mark=%d,ExamMark=%d",
			_classCourse.GetEnrolmentType(),
			GetFirstName(),
			GetLastName(),
			GetID(),
			_classCourse.GetUnitID(),
			_classCourse.GetUnitLevel(),
			_classCourse.GetAssignment1Mark(),
			_classCourse.GetAssignment2Mark(),
			_classCourse.GetFinalExamMark()
		);
		return ret;
	}
	
	/**
	 * Calls the overall mark get method from the private Unit_Course class instance.
	 * 
	 * @return 			Integer representing the overall mark of this student.
	 */
	public int GetOverallMark() {
		return _classCourse.GetOverallMark();
	}
	
	/**
	 * Calls the calculation methods from the private Unit_Course class instance.
	 * This will update the Unit_Course overall mark and final grade variables internally.
	 * 
	 * @return void
	 */
	public void CalculateOverallMark() {
		_classCourse.CalculateOverallMark();
		_classCourse.CalculateFinalGrade();
	}
}
