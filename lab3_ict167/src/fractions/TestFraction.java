package fractions;
import fractions.Fraction;
import java.util.Scanner;

public class TestFraction {

    public static void main(String[] args) {

        boolean running = true;

        Scanner sc = new Scanner(System.in);

        while (running) {

            int n_buff = 0; // numerator
            int d_buff = 0; // denominator

            System.out.println("Enter a numerator and a denominator (ie 5 3)");
            n_buff = sc.nextInt();
            d_buff = sc.nextInt();

            if (!validInput(n_buff)) { running = false; break; }
            if (d_buff == 0) {
                System.out.println("Denominator must not be zero.");
                continue;
            }

            System.out.printf("Fraction: ");
            Fraction frac = new Fraction(n_buff, d_buff);
            frac.Output();
        }

        System.out.println("Program quit.");
    }

    public static boolean validInput(int n) {
        if (n < 0) return false;
        else return true;
    }
}