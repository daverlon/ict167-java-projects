package lab8_ict167;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import lab8_ict167.Baby;
import lab8_ict167.Patient;
import lab8_ict167.Playgroup;

public class BabySoundClient {
	public static void main(String[] args) {

		Baby[] babies = new Baby[4];
		
		// example data

		babies[0] = new Patient("Bobby", 2, 16521);

		babies[1] = new Baby("Bruce", 1);

		babies[2] = new Playgroup("Sammy", 3);

		babies[3] = new Baby("Mutahar", 2);


		// output the data to the file 
		// and also output it to the console at the same time
		
		// prepare the file output stream
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter("ouput.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Erorr: coudl not open file.");
		}
		
		
		// loop through the baby array and output their string
		// conversion to both the console output stream
		// and the file output stream
		for (int i = 0; i < babies.length; i++) {
			System.out.println(babies[i]);
			outputStream.println(babies[i]);
		}
		
		// close the file
		
		outputStream.close();

		
		// polymorphism is happening above as different classes are 
		// being stored in the same array (array of base class Baby)
		// the override method "toString()" is present in the
		// Baby class as well as the extended classes,
		// which allows the method to be called in the same way
		// and output different data as it may be used on different classes
		
//		System.out.println(babies[i]);
//		outputStream.println(babies[i]);
		
		// the baby info is able to be printed out as there is a conversion
		// method which displays their relevant information as a string
		// the method is slightly different for each different extension of the class
		
		// in code, it is possible to perform the same operations on each member
		// of the array as they all appear to be of type Baby
	}
}
