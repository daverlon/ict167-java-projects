package fractions;
import fractions.Fraction;
import java.util.Scanner;

public class TestFraction2 {

  public static void main(String[] args) {

    boolean running = true;
    Scanner sc = new Scanner(System.in);

    boolean first = true;
    Fraction running_fraction = new Fraction(1, 1);

    while (running) {

      // get fraction input from user
      System.out.println("\nEnter a non-zero numerator and a denominator (ie 5 3)");
      int n_buff = 0; // numerator
      int d_buff = 0; // denominator
      n_buff = sc.nextInt();
      d_buff = sc.nextInt();

      // check if it is a valid fraction (non negative in this case)
      if (!validInput(n_buff, d_buff)) { running = false; break; }
      
      if (first) {
        running_fraction = new Fraction(n_buff, d_buff);
        first = false;
      } else {
        Fraction f_buff = new Fraction(n_buff, d_buff);
        running_fraction = running_fraction.Add(f_buff);
      }

      System.out.printf("Input fraction to add: ");
      new Fraction(n_buff, d_buff).Output();
      System.out.printf("Running total fraction: ");
      running_fraction.Output();

    }

    System.out.println("Zero fraction entered: Program quit.");
  }

  public static boolean validInput(int n, int d) {
    if (n <= 0) return false;
    if (d <= 0) return false;
    else return true;
  }
}
