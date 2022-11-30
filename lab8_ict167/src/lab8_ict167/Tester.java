package lab8_ict167;

import java.util.Scanner;


// tester for randomints

import lab8_ict167.RandomInts;

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
      
      // display sorted array
      System.out.printf("\nSorted array: ");
      SortArray(a.GetNumbers());
    }
    
    System.out.println("Program quit.");
  }
  
  public static void SortArray(int ar[]) {
	  int a[] = ar;
	  int l = a.length;
	  for (int i = 0; i < l; i++) {
		  
		  int cur = a[i];
		  int prevIndex = i - 1;
		  
		  
		  while (prevIndex >= 0 && a[prevIndex] > cur) {
			  a[prevIndex + 1] = a[prevIndex];
			  prevIndex = prevIndex - 1;
		  }
		  a[prevIndex + 1] = cur;
	  }
	  DisplayArray(a);
  }
  
  public static void DisplayArray(int a[]) {
	  int l = a.length;
	  for (int i = 0; i < l; i++) {
		  System.out.printf("%d", a[i]);
		  if (i < l-1) System.out.printf(",");
	  }
	  System.out.printf("\n");
  }
}
