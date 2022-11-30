import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ICT167 Assignment 2
 * @author David Long
 * @author StudentID: 1234566
 * @version 1.0
 */

/**
 * Client.java
 * @author David Long
 * 28/10/22
 * Main entry point for the program, containing file input/output and functions to analyse student data.
 */

public class Client {
	
	/*
	 * Print the menu to the user. To be called on every repetition of the main loop.
	 */
	public static void ShowMenu() {
		String menu = "\n";
		menu += "1. Quit (exit the program)\n";
		menu += "2. Read from a .CSV file\n";
		menu += "3. Remove student by ID\n";
		menu += "4. Show all students\n";
		menu += "5. Show average and above course work students\n";
		menu += "6. Report student grade by ID\n";
		menu += "7. Sort students by ID (bubble sort)\n";
		menu += "8. Output student information to a .CSV file";
		System.out.println(menu);
	}
		
	/**
	 * Main entry point function for the program.
	 * Contains the main loop and all variables used.
	 * 
	 * @param args		Unused.
	 * 
	 * @return void
	 */
	public static void main(String[] args) {
	
		// ArrayList to hold Students (Student_Research and Student_Course) child classes.
		ArrayList<Student> students = new ArrayList<Student>();
		
		// When the program first starts, load any correctly formatted
		// students from student.csv (if they exist).
		LoadStudentsFromCSV("student.csv", students); // read and load from CSV
		
		// Standard input scanner to receive input from the user.
		Scanner sc = new Scanner(System.in);	
		
		// Buffer and control flow variables.
		boolean running = true; 		// Condition that keeps the main loop running.
		int menuResponse = 0;			// Integer that holds the user's response to the main menu.				
		String fileNameResponse = "";	// String that holds the user's response to file name prompts.
		long idResponse = 0;			// Integer that holds the user's response to student ID lookups.
	
		

		Student_Course test = new Student_Course("john", "smith", 1, "ICT167", 1, 90, 80, 70);	
		Student_Research test2 = new Student_Research("hello", "world", 3, 50, 85);
//		students.add(test);
//		students.add(test2);
		
		

		// Main loop. Program will exit if the loop is closed.
		while (running) {
			
			// Show the menu and grab the user's response.
			ShowMenu();
			// The response should be an integer matching an option in the ShowMenu() string.
			menuResponse = Integer.parseInt(sc.nextLine().trim());
			
			// Match the response integer and execute their respective commands.
			switch (menuResponse) {
			case 1:
				// 1. Quit (exit the program)
				QuitProgram();
				break;
			case 2:
				// 2. Read from a .CSV file
				// Prompt the user to enter a name of an existing .CSV file.
				System.out.println("Enter file name to load from: ");
				fileNameResponse = sc.nextLine().trim(); // Hold the name in the buffer variable.
				LoadStudentsFromCSV(fileNameResponse, students); // Call the correct function.
				break;
			case 3:
				// 3. Remove student by ID
				// Prompt the user to enter an ID,
				// then find a matching, existing student and remove them from ArrayList.
				System.out.println("Please enter the student ID to remove: ");
				idResponse = Long.parseLong(sc.nextLine().trim()); // Hold the response in the ID buffer variable.
				RemoveStudentByID(sc, students, idResponse);	 // Call the correct function.	
				break;
			case 4:
				// 4. Show all students.
				// Call the function which loops through each student and displays their information.
				ShowStudentsInformation(students); 
				break;
			case 5:
				// 5. Show average and above course work students.
				// This function only applies to course work student instances in the ArrayList.
				float average = CalculateAverageOverallMark(students); // Calculate the average mark across course work students.
				System.out.printf("Average Overall Mark (course work students only): %2.2f\n", average); // Display the average mark.
				CountStudentsAboveAndBelowAverageOverallMark(students, average); // Display further counts using the correct function.
				break;
			case 6:
				// 6. Report student grade by ID
				// Prompt the user to enter a student ID, then show the matching student information.
				System.out.println("Please enter the student ID to report grade: ");
				idResponse = Long.parseLong(sc.nextLine().trim()); // Store the ID in the ID buffer variable.
				ShowStudentGradeByID(students, idResponse); // Show the information of the matching student.
				break;
			case 7:
				// 7. Sort students by ID (bubble sort)
				// Call the function which sorts the students,
				// then verify if they have been correctly sorted.
				BubbleSortStudentsByID(students); // Bubble sort function
				// Print an error message if the students were unable to be sorted (for whatever resaon).
				// Print a success message if the students were correctly sorted.
				if (CheckIfStudentsAreSorted(students)) System.out.println("Successfully sorted students by Student ID.");
				else System.out.println("Error sorting students by Student ID.");	
				break;
			case 8:
				// 8. Output student information to a .CSV file
				// First check if the students are correctly sorted.
				// If they are not, print an error message.
				if (!CheckIfStudentsAreSorted(students)) { System.out.println("Students must first be sorted by Student ID."); break; }
				// If the students are sorted correctly, prompt the user for a .CSV file name.
				System.out.println("Enter file name to save to: ");
				fileNameResponse = sc.nextLine().trim(); // Hold the file name in the file name response buffer variable.
				OutputStudentsToCSV(fileNameResponse, students); // Output the data to the file using the correct function.
				break;
			default:
				// If the menu response could not be matched,
				// print an error message and continue the loop.
				System.out.println("Invalid response. Try again.");
				break;
			}	
		}
	}
	
	/**
	 * Outputs the information from the Student ArrayList to a chosen .CSV file.
	 * 
	 * @param fileName		String which holds the file name to be written to
	 * @param arr			Student ArrayList
	 * 
	 * @return				return void
	 */
	public static void OutputStudentsToCSV(String fileName, ArrayList<Student> arr) {
		// Attempt to create an output stream to a file.
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(fileName);
		} catch (FileNotFoundException e) {
			System.out.printf("Error: Could not open %s\n", fileName); // Print an error if the file stream could not be created.
			return; // End the function early.
		}
		// Iterate through the array and output the information string
		// to the file output stream.
		for (int i = 0; i < arr.size(); i++) {
			outputStream.println(arr.get(i).GetInformation()); // GetInformation()-->(String)(of relevant student information).
			//System.out.println(arr.get(i).GetInformation());
		}	
		// Close the output stream.
		outputStream.close();
		System.out.printf("Finished writing %d students to %s\n", arr.size(), fileName); // Display completion message to the user.
	}
	
	/**
	 * Generic function which reads from a chosen file name and writes the
	 * found information to the Student ArrayList
	 * 
	 * @param fileName		String which holds the file name to be read from
	 * @param arr			Student ArrayList which will be written to
	 * 
	 * @return				return void
	 */
	public static void LoadStudentsFromCSV(String fileName, ArrayList<Student> arr) {	
		// Attempt to create a file input stream.
		Scanner fileStream = null;
		try {
			fileStream = new Scanner(new File(fileName));
		}
		catch (FileNotFoundException e) {
			System.out.printf("Error: Could not load students from %s\n", fileName); // Display an error message if the input stream could not be created.
			return; // End the function early.
		}	
		int studentCount = 0;			// Hold a count of each successful student import, to be displayed later.
		Student_Course cBuff = null;	// Buffer to hold a Student_Course instance (type="C")
		Student_Research rBuff = null;	// Buffer to hold a Student_Research instance (type="R")
		// String buffer to hold the formatted student string.
		// Example:
		// Type=C,FirstName=steve,LastName=williams,StudentID=1234567,UnitID=ICT167,Level=1,OverallMark=79,FinalGrade=D
		String items[]; 
		// The program will attempt to create student instances from strings in the correct format.
		while (fileStream.hasNextLine()) {		
			// Split the line (formatted Student string) by the comma and store each split in the items[] buffer.
			items = fileStream.nextLine().trim().split(",");
			
			// Loop through the items[] buffer and remove all text before the equals character.
			// This results in raw data being stored in the items[] array.
			for (int i = 0; i < items.length; i++) {
				//System.out.println(i);
				items[i] = items[i].split("=")[1].trim();
				//System.out.printf("%d: %s\n", i, items[i]);	
			}	
			// The first item in the items[] buffer contains the student type.
			// The type will be "C" for Student_Course, or "R" for Student_Research.
			// Create the corresponding buffer to match the type, then add them to the Student ArrayList (arr).
			if (items[0].toUpperCase().equals("C")) {
				// (String firstName, String lastName, long studentID, String unitID, int unitLevel, int a1Mark, int a2Mark, int examMark)
				// Create the buffer to match the data in the items[] string.
				cBuff = new Student_Course(
					items[1], 						// first name	(String)
					items[2], 						// last name	(String)
					Long.parseLong(items[3]), 		// student id	(long)
					items[4], 						// unitID 		(String)
					Integer.parseInt(items[5]), 	// unitLevel 	(int)
					Integer.parseInt(items[6]), 	// a1Mark		(int)
					Integer.parseInt(items[7]),		// a2Mark		(int)
					Integer.parseInt(items[8]));	// examMark		(int)
				//cBuff.CalculateOverallMark();
				// Copy the buffer into the ArrayList (arr).
				arr.add(cBuff);
			}	
			// If the type (first item in items[] array is "R",
			// create a Student_Research buffer from the remaining information,
			// and add it to the ArrayList (arr).
			else if (items[0].toUpperCase().equals("R")) {
				// (String firstName, String lastName, long studentID, int propsalMark, int finalDissertationMark)
				rBuff = new Student_Research(
					items[1],						// first name 				(String)
					items[2],						// last name 				(String)
					Long.parseLong(items[3]),		// student ID				(long)
					Integer.parseInt(items[4]),		// proposalMark				(int)
					Integer.parseInt(items[5]));	// finalDissertationMark	(int)
				rBuff.CalculateOverallMark();
				arr.add(rBuff);
			}
			// If the type read from the file does not equal "C" or "R",
			// the format may be incorrect. Display a message stating so.
			else {
				System.out.println("Error reading file. Format incorrect. Please refer to example.txt");
				return; // End this function early.
			}
			// Increase the count for each found student.
			studentCount++;
		}	
		fileStream.close();	// Close the file input stream.
		System.out.printf("Finished loading %d students from %s\n", studentCount, fileName); // Display relevant information to the user.
	}
	
	/**
	 * Iterate through the Student ArrayList and report the grades
	 * (using the ReportGrade() method of each instance in the list.
	 * 
	 * @param arr		Student ArrayList to be iterated through and accessed.
	 * 
	 * @return void
	 */
	public static void ShowStudentsGrades(ArrayList<Student> arr) {
		for (int i = 0; i < arr.size(); i++) {
			arr.get(i).ReportGrade(); // ReportGrade() will print information to standard output.
		}
	}
	
	/**
	 * Iterate through the Student ArrayList and call the GetInformation()
	 * method (which returns a string describing the student) for each instance in the list.
	 * 
	 * @param arr		Student ArrayList to be iterated through and accessed.
	 * 
	 * @return void
	 */
	public static void ShowStudentsInformation(ArrayList<Student> arr) {
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i).GetInformation()); // GetInformation() returns a string.
		}
	}
	
	/**
	 * Search through the Student ArrayList, and if a matching Student ID is found,
	 * remove that student from the list. The user will be prompted with a confirmation
	 * message to ensure they want to delete the found student.
	 * If the student is not found, display a message saying so.
	 * 
	 * @param sc		Scanner (standard input) which is created in the main entry point.
	 * @param arr		Student ArrayList to be iterated through and accessed.
	 * @param id		ID of the student to be matched and removed if found.
	 * 
	 * @return void
	 */
	public static void RemoveStudentByID(Scanner sc, ArrayList<Student> arr, long id) {
		// Iterate through the student array
		for (int i = 0; i < arr.size(); i++) {
			// If a matching student ID is found, prompt the user to confirm the deletion.
			if (arr.get(i).GetID() == id) {
				// Show the information of the matching student, and prompt the user to confirm the deletion.
				System.out.println("Confirm: Remove " + arr.get(i).GetFullName() + ", student ID: " + arr.get(i).GetID() + " from list? (y/n)");
				// Store the response in a string.
				String response = sc.nextLine().trim().toLowerCase();
				// If response is invalid, show an error message.
				if (!response.equals("y") && !response.equals("n")) {
					System.out.println("Invalid response.");
					return;
				}
				// If the response is "n", end the function early and do nothing.
				else if (response.equals("n")) {
					System.out.println("Cancelled student removal.");
					return;
				}
				// If the response is "y", remove the corresponding index from the array, and display a success message.
				else if (response.equals("y")) {
					System.out.println("Removed " + arr.get(i).GetFullName() + " from list.");
					arr.remove(i);
					return; // End the function early.
				}
			}
		}
		// At this point the entire loop was iterated through and no match was found.
		System.out.println("Unable to match a student with ID: " + id);
	}
	
	/**
	 * Iterate through the Student ArrayList and search for a student with a matching
	 * student ID (chosen by user). If a matching student is found, report their grade,
	 * using the ReportGrade() method.
	 * If no match is found, display an error message saying so. The function should end
	 * if a match is found.
	 * 
	 * @param arr		Student ArrayList to be iterated through and accessed.
	 * @param id		ID of the student to be matched and have their grade reported.
	 * 
	 * @return void
	 */
	public static void ShowStudentGradeByID(ArrayList<Student> arr, long id) {
		// Iterate through the list until a matching ID is found
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).GetID() == id) {
				// Call the ReportGrade() method for the matching instance
				arr.get(i).ReportGrade();
				return; // End the function early.
			}
		}
		// If the entire loop was scanned and no match found, display an error message.
		System.out.println("Unable to match a student with ID: " + id);
	}
	
	/**
	 * Loop through the Student ArrayList and calculate the average overall mark.
	 * The loop should skip instances of Student_Research and only compute the
	 * results of the Student_Course instances. The average value is returned.
	 * 
	 * @param arr		Student ArrayList to be iterated through and accessed.
	 * 
	 * @return			float representing the average overall mark for each Student_Course instance
	 */
	public static float CalculateAverageOverallMark(ArrayList<Student> arr) {
		// only apply to course work students
		float sum = 0.0f; 	// Sum of all Student_Course instance overall marks.
		int totalCount = 0;	// Count of Student_Course instances.
		for (int i = 0; i < arr.size(); i++) {
			// Ignore the current index in the array, if it is not a Student_Course instance.
			if (!(arr.get(i) instanceof Student_Course)) continue;
			// If it is a Student_Course instance, add the overall mark to the sum and increment the counter.
			sum += arr.get(i).GetOverallMark();
			totalCount++;
		}
		return sum / (float)totalCount; // Return the average.
	}
	
	/**
	 * Loop through the Student ArrayList and keep a count of the number of students
	 * who are above the 'av' float (which may represent the average overall mark) and 
	 * keep count of the students whose average mark is below the 'av' float.
	 * Display this information to the standard output.
	 * 
	 * @param arr		Student ArrayList to be iterated through and accessed.
	 * @param av		Float, where students will be counted if their overall mark is above or below.
	 * 
	 * @return void
	 */
	public static void CountStudentsAboveAndBelowAverageOverallMark(ArrayList<Student> arr, float av) {
		// only apply to course work students
		int below = 0; // Store the count for students below 'av'.
		int above = 0; // Store the count for students above 'av'.
		for (int i = 0; i < arr.size(); i++) {
			// Iterate through the loop and skip if the current index is not a Student_Course instance.
			if (!(arr.get(i) instanceof Student_Course)) continue;
			// If it is, increment the correct counter, then continue the loop straight away.
			if (arr.get(i).GetOverallMark() >= av) { above++; continue; }
			if (arr.get(i).GetOverallMark() < av) { below++; continue; }
		}
		// Display the relevant information.
		System.out.println("Course work student count who scored above average: " + above);
		System.out.println("Course work student count who scored below average: " + below);
	}
	
	/*
	 * Iterate through the Student ArrayList and check if it is correctly sorted by student ID.
	 * Return the result (true/false).
	 * 
	 * @param arr		Student ArrayList to be iterated through and accessed.
	 * 
	 * @return			boolean representing the sort status of the Student ArrayList.
	 */
	public static boolean CheckIfStudentsAreSorted(ArrayList<Student> arr) {
		// If there are is a single instance in the array, or the array is empty,
		// return true (the array is correctly sorted) and end the program early.
		if (arr.size() <= 1) return true;
		for (int i = 0; i < arr.size()-1; i++) {
			// Compare the next item's ID with the current item's ID.
			// If the next item's ID is lower than the current item's ID,
			// the array is not sorted correctly.
			// Return false (end the program).
			if (arr.get(i+1).GetID() < arr.get(i).GetID()) {
				//System.out.println("Error: Students must be sorted by Student ID.");
				return false;
			}
		}
		// If the entire loop was scanned and no incorrect order was found,
		// return true (the array is correctly sorted).
		return true;
	}
	
	/**
	 * Sort the Student ArrayList by student IDs using the BubbleSort algorithm.
	 * https://en.wikipedia.org/wiki/Bubble_sort
	 * java.utils.Collections is unable to be used for the assignment, so a temporary
	 * buffer should be created in order to swap 2 instances in the array.
	 * 
	 * @param arr		Student ArrayList to be iterated through and accessed.
	 * 
	 * @return void
	 */
	public static void BubbleSortStudentsByID(ArrayList<Student> arr) {
		// Variable to hold the length of the array (minus 1).
		// This should not be calculated on every loop iteration.
		int l = arr.size() - 1; 

		// Loop from the first item, to second last.
		for (int i = 0; i < l; i++) {
			// Loop from the first item, to the last minus the current index in the first loop.
			for (int k = 0; k < l - i; k++) {
				// If current index student ID is lower than the next,
				// swap their positions in the array.
				if (arr.get(k).GetID() > arr.get(k + 1).GetID()) {
					// Hold a temporary copy of one of the items, since one will be overwritten by the other at first.
					var temp = arr.get(k); 
					// Swap the positions.
					arr.set(k, arr.get(k+1));
					arr.set(k+1, temp);
					
					// Swap method using java.utils.Collection (disallowed for this assignment).
					//Collections.swap(arr, k+1, k);
				}
			}
		}
	}
	
	/**
	 * Exit the java program.
	 * 
	 * @return void
	 */
	public static void QuitProgram() {
		System.out.println("Exiting program."); 
		System.exit(0);
	}
}
