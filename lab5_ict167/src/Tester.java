package src;

import java.util.Scanner;


// tester for randomints

import src.RandomInts;

public class Tester {
  public static void main(String[] args) {

    boolean running = true;
    Scanner sc = new Scanner(System.in);

    while (running) {

      // get integer from user
      System.out.println("\nEnter '0' to quit.");
      System.out.println("How many random numbers to generate?");
      int n = sc.nextInt();
      if (n <= 0) { running = false; break; }

      // generate the integer array (class)
      RandomInts a = new RandomInts(n);

      // display class
      a.Output();
    }
    System.out.println("Program quit.");
  }
}
