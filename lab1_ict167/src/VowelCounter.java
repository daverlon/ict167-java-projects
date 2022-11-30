import java.util.Scanner;

//
// ICT167 Week 1
// Lab exercise 3
//
// David Long
// Student ID: 1234567
//
// VowelCounter.java
// Retrieves an input string from the user
// then extracts only vowels and displays 
// the number of times each vowel appeared in the string
// and also displays the index of each vowels' first appearance
//

public class VowelCounter {

	public static void main(String[] args) {

		System.out.println("Type 'quit' to exit program.");

		Scanner sc = new Scanner(System.in);

		// main loop
		boolean running = true;
		while (running) {
			System.out.println("\nEnter a string to a maximum length of 30:");
			// retrieve input string
			String inputString = sc.nextLine().toLowerCase();

			// exit the loop if the user inputs "quit"
			if (inputString.equals("quit")) {
				running = false;
				break;
			}

			// check if the input string has a maximum length of 30
			if (outOfRange(inputString)) {
				System.out.println("\nThe string is too long. Please enter again.");
				continue;
			}

			// extract only the vowels from the input string
			String temp = ExtractVowels(inputString);

			// display this second array (array of chars)
			System.out.println("\nThe output of the second array is:\n" + temp);

			// display the counts
			DisplayVowelCounts(temp);

			// display index of first appearances for each vowel
			DisplayVowelIndices(temp);
		}

		sc.close();
	}

	static boolean outOfRange(String s) {
		if (s.length() > 30) {
			return true;
		}
		return false;
	}

	static String ExtractVowels(String s) {
		String ret = "";
		String vowels = "aeiou";

		// iterate through each character in string s
		// if the character appears in the vowels string,
		// add it to a temporary string (second array)
		for (int i = 0; i < s.length(); i++) {
			int id = vowels.indexOf(s.charAt(i));
			if (id != -1) {
				ret += s.charAt(i);
			}
		}
		// return the new string
		return ret;
	}

	static void DisplayVowelCounts(String foundVowels) {
		String vowels = "aeiou";

		// integer array to store an appearance counter for each vowel
		int counts[] = { 0, 0, 0, 0, 0 };

		// iterate through the extracted vowel string
		// if the current vowel in the extracted vowel string
		// is found in the "aeiou" vowels string,
		// add 1 to the integer array at the same index as the
		// vowel appearance in "aeiou"
		for (int i = 0; i < foundVowels.length(); i++) {
			if (vowels.indexOf(foundVowels.charAt(i)) != -1) {
				counts[vowels.indexOf(foundVowels.charAt(i))] += 1;
			}
		}

		// display the results in a readable way
		System.out.println("\nThe counts are as follows:");
		for (int i = 0; i < vowels.length(); i++) {
			System.out.println(vowels.charAt(i) + "=" + counts[i]);
		}
	}

	static void DisplayVowelIndices(String foundVowels) {
		System.out.println("\nThe index of the second array where each vowel first appeared:");
		String vowels = "aeiou";

		// iterate through each vowel in the "aeiou" string
		// use 'indexOf' method to retrieve the index of the first apperance
		// of the vowel in the extracted vowel string (foundVowels)
		// display the results in a readable way
		for (int i = 0; i < vowels.length(); i++) {
			int id = foundVowels.indexOf(vowels.charAt(i));
			if (id != -1) {
				System.out.println(vowels.charAt(i) + " = " + id);
			} else {
				System.out.println(vowels.charAt(i) + " is not in the input");
			}
		}
	}
}
