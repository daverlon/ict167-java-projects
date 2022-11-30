
/**
 * Student.java
 * @author David Long
 * 28/10/22
 * Student base class, holding basic information which all students
 * will have. Intended to be extended by students taking certain courses.
 */

public class Student {
	
	private String _firstName;			// First name of student
	private String _lastName;			// Last name of student
	private long _id;					// Student's ID number
	
	// constructors	
	
	/**
	 * Default constructor taking no arguments.
	 * Will default values to null or zero.
	 */
	public Student() {
		SetFullName("null", "null");
		SetID(0);
	}
	
	/**
	 * Constructor which takes student's relevant information.
	 * 
	 * @param firstName		First name of student
	 * @param lastName		Last name of student
	 * @param studentID		Student's ID number
	 */
	public Student(String firstName, String lastName, long studentID) {
		SetFullName(firstName, lastName);
		SetID(studentID);
	}
	
	// ---------- methods ---------- //
	
	/**
	 * This function should be replaced by inherited classes
	 * to output the student grade to the standard output.
	 * 
	 * @return void
	 */
	public void ReportGrade() {
		System.out.println("There is no grade here.");
	}
	
	/**
	 * Comparison function to compare class instances.
	 * It uses the student ID (which should be unique) to detect duplicates.
	 * 
	 * @return 		Boolean representing duplicate detection.
	 */
	public boolean equals(Student other) {
		return GetID() == other.GetID();
	}
	
	
	/**
	 * Function to be replaced by inherited classes override function.
	 * It will return as a string, all the student's formatted information.
	 * 
	 * @return 		String with student information.
	 */
	public String GetInformation() {
		return "There is no information here.";
	}
	
	/**
	 * Function to be replaced by inherited classes override function.
	 * It will return the calculated overall mark for the student.
	 * 
	 * @return		Integer representing the weighted overall mark for the student.
	 */
	public int GetOverallMark() {
		return 0; // override function
	}
	
	// -------- Get and set methods for internal variables -------- //
	
	// first name
	public void SetFirstName(String name) {
		_firstName = name.trim();
	}
	public String GetFirstName() { return _firstName; }
	
	// last name
	public void SetLastName(String name) {
		_lastName = name.trim();
	}
	public String GetLastName() { return _lastName; }
	
	// student ID
	public void SetID(long id) {
		_id = id;
	}
	public long GetID() { return _id; }
	
	// full name (first + last)
	public void SetFullName(String first, String last) { 
		_firstName = first.trim();
		_lastName = last.trim();
	}
	public String GetFullName() { return _firstName + " " + _lastName; }
}
