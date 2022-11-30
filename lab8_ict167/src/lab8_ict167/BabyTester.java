package lab8_ict167;

import java.util.Scanner; 
import lab8_ict167.Baby;

public class BabyTester {
	public static void main(String[] args) {

    // input scanner
    Scanner sc = new Scanner(System.in);

    // create baby array
    // and instantiate each object
    // in the array
    Baby[] babies = new Baby[4];    
    for (int i = 0; i < 4; i++) babies[i] = new Baby();

    // get baby info from user
    for (int i = 0; i < 4; i++) {
      System.out.printf("\nEnter a name & age for baby %d.\n", i+1);
      System.out.println("Example: 'sam 2' (Separated by a space)");
      String input = sc.nextLine();
      String inputs[] = input.split(" ");
      String name = inputs[0];
      int age = Integer.parseInt(inputs[1]);

      // write to the array
      babies[i].SetName(name);
      babies[i].SetAge(age);
    }

    OutputBabies(babies);
    System.out.printf("\nAverage age: %1.3f\n", AverageAge(babies));
    CheckDuplicateBabies(babies);
	}

  public static void OutputBabies(Baby[] babies) {
    System.out.printf("\n\n");
    for (int i = 0; i < 4; i++) {
      System.out.printf("Baby %d: %10s        age  %3d\n", 
        i+1, babies[i].GetName(), babies[i].GetAge());
    }
  }

  public static float AverageAge(Baby[] babies) {
     int sum = 0;
     for (int i = 0; i < 4; i++) {
      sum += babies[i].GetAge();
    }
    return (float)sum / 4.0f;
  }

  public static boolean CheckDuplicateBabies(Baby[] babies) {
    // store duplicate indices in a
    // string (integers must be sorted
    // to avoid extra duplicates)
    String duplicates = "";
    // the string will look like:
    // 1-2\n0-3
    // if index 1 & 2 match
    // and if index 0 & 3 match

    for (int i = 0; i < 4; i++) {
      Baby curBaby = babies[i];
      for (int a = 0; a < 4; a++) {
        Baby curBaby2 = babies[a];
        if (i == a) continue;
        if (curBaby.equals(curBaby2)) {
          String buff = "";
          buff = (i < a) ? String.format("%d-%d\n", i, a)
                            : String.format("%d-%d\n", a, i);
          if (duplicates.contains(buff)) continue;
          duplicates = duplicates.concat(buff);
        }
      }
    }

    // list the matching babies
    // indices are stored in the string
    System.out.printf("\n");
    String[] res = duplicates.split("\n");
    for (int i = 0; i < res.length; i++) {
      String temp[] = res[i].split("-");
      int index1 = Integer.parseInt(temp[0]);
      int index2 = Integer.parseInt(temp[1]);
      System.out.printf("Baby %d (%s, aged %d) matches Baby %d (%s, aged %d).\n", 
        index1+1, babies[index1].GetName(), babies[index1].GetAge(),
        index2+1, babies[index2].GetName(), babies[index2].GetAge());
    }
    return true;
  }
}
