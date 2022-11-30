package fractions;

public class Fraction {
	private int numerator = 1;
	private int denominator = 1;
	
	public Fraction(int n, int d) {
		if (d == 0) {
			System.out.println("Error: denominator cannot be zero.");
			return;
		}
		numerator = n;
		denominator = d;
	}

	public void Output() {
		if ((denominator < 0 && numerator >= 0)
			|| (denominator < 0 && numerator <= 0)) {
			System.out.printf("%d / %d\n", -numerator, -denominator);
		}
		else {
			System.out.printf("%d / %d\n", numerator, denominator);
		}
	}
	
	public void SetNumerator(int n) {
		numerator = n;
	}
	
	public int GetNumerator() {
		return numerator;
	}
	
	public void SetDenominator(int d) {
		denominator = d;
	}
	
	public int GetDenominator() {
		return denominator;
	}
}
