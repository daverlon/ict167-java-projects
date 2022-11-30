import java.util.Scanner;

//Trunc.java
//Displays running total of numbers in lines of standard
//input rounded to the nearest whole number (without using java's round function)
//Uses an out of range number(<-100 or >100) to quit.

public class Trunc {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		double total = 0;
		boolean flag = true;

		System.out.println("Use an out of range entry <-100 or >100 to quit.");

		while (flag) {
			System.out.println("Enter a number on a line:");

			double d = input.nextDouble();

			if (outOfRange(d)) {
				flag = false;
			} else {
				displayRounded("The number value is:	", d);
				total = total + d;
				displayRounded("The running total is:	", total);

				System.out.println();
				System.out.println("Next.");
			}
		}
		System.out.println("You quit.");
	}

	static boolean outOfRange(double d) {
		if (d < -100)
			return true;
		if (d > 100)
			return true;
		return false;
	}

	static void displayRounded(String msg, double num) {
	
		// check whether or not the
		// input num is negative
		boolean neg = (num < 0);
		
		// integer version of the negative check
		// for number processing
		int ineg = 1;
		if (neg) ineg = -1;
		
		// store the number in a new variable
		double posNum = num;
		if (neg) posNum = -num;
		
		double nPlus = posNum + 0.005;
		
		// value before the decimal point
		int whole = (int) nPlus;
		
		// value after the decimal point
		double rest = nPlus - whole;
		
		// if the value after the decimal point (rest)
		// is to be rounded up (>50)
		// add (1-rest) to the whole number
		// minus rest if it is to be rounded down
		double rounded = 0;
		if (rest >= 0.5) {
			rounded = nPlus + (1.0 - rest);
		} else {
			rounded = nPlus - rest;
		}
		// multiply the rounded number by
		// either 1 or -1 if the original
		// was positive or negative (respectively)
		rounded *= ineg;
	
		// string formatting
		String s = "" + rest;
		int I = s.length();

		// display the negative sign if necessary
		String sign = "";
		if (neg) sign = "-";
		
		// display the information
		System.out.println(msg + "" + sign + whole + "." + s.substring(2, 4) + "   (" + rounded + " rounded)");
	}
}
