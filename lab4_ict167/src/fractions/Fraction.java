package fractions;

public class Fraction {
	private int numerator = 1;
	private int denominator = 1;
	
	public Fraction(int n, int d) {
		if (d == 0) {
			System.out.println("Error: denominator cannot be zero.");
			return;
		}
		this.numerator = n;
		this.denominator = d;
		this.Simplify();
	}

	public void Output() {
		if ((this.denominator < 0 && this.numerator >= 0)
			|| (this.denominator < 0 && this.numerator <= 0)) {
			System.out.printf("%d / %d\n", -this.numerator, -this.denominator);
		}
		else {
			System.out.printf("%d / %d\n", this.numerator, this.denominator);
		}
	}

  public Fraction Add(Fraction other) {
    int n = (this.GetNumerator() * other.GetDenominator()) +
              (this.GetDenominator() * other.GetNumerator());
    int d = this.GetDenominator() * other.GetDenominator();

    return new Fraction(n, d);
  }

  private void Simplify() {
    int gdc = this.GDC(this.numerator, this.denominator);
    this.numerator /= gdc;
    this.denominator /= gdc;
  }

  // greatest common divisor
  private int GDC(int n1, int n2) {
    int c = 0;
    while (n1 != 0 && n2 != 0) {
        c = n2;
        n2 = n1 % n2;
        n1 = c;
    }
    return (n1 + n2);
  }
	
	public void SetNumerator(int n) {
		this.numerator = n;
	}
	
	public int GetNumerator() {
		return this.numerator;
	}
  	
	public void SetDenominator(int d) {
		this.denominator = d;
	}
	
	public int GetDenominator() {
		return this.denominator;
	}
}
