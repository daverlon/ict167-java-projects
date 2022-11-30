package lab8_ict167;
import java.util.Random;

// non static methods because
// they are dependant on values
// which will be different on each
// instance of the class

public class RandomInts {

  // the variables are private and
  // do not need to be accessed externally
  private int n = 0; // number of random ints
  private int[] numbers; // int array
  public int[] GetNumbers() { return this.numbers; }

  // public class constructor since
  // it must be accessed externally.
  public RandomInts(int n) { 
    this.n = n;
    GenerateInts();
  }

  // private generate method since it
  // will be used only within the class
  // to generate the integers.
  private void GenerateInts() {
    Random gen = new Random(); 
    this.numbers = new int[this.n];
    for (int i = 0; i < n; i++) {
      int rand = gen.nextInt(1000);
      this.numbers[i] = rand;
    }
  }

  // public method to output the integers
  // because this will be accessed externally.
  public void Output() {
    System.out.printf("\nMin: %d\nMax: %d\nAverage: %1.3f\n", 
      this.Min(), this.Max(), this.Average());

    for (int i = 0; i < n; i++) {
      if (i % 5 == 0) {
        System.out.printf("\n");
      }
      System.out.printf("%3d, ", this.numbers[i]);
    }
    System.out.printf("\n");
  }

  // public non static method to get mean
  public float Average() {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += this.numbers[i];
    }
    return (float)sum / (float)n;
  }

  // public non static method to get max
  public int Max() {
    int max = -99999;
    for (int i = 0; i < n; i++) {
      if (this.numbers[i] > max) {
        max = this.numbers[i];
      }
    }
    return max;
  }

  // public non static method to get min
  public int Min() {
    int min = 99999;
    for (int i = 0; i < n; i++) {
      if (this.numbers[i] < min) {
        min = this.numbers[i];
      }
    }
    return min;
  }
}
