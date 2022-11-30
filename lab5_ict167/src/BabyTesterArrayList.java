package src;

import java.util.ArrayList;
import java.util.Scanner;

public class BabyTesterArrayList {
  
  public static void main(String[] args) {
	  
	  
	  /*
	   * 
	   * 
	   * 	ArrayList<baby> instead of Baby[]
	   * 
	   * 	Indexed using babies.get(i) method instead of babies[]
	   * 	Length of array using babies.size() instead of babies.length
	   * 	Added to the array using babies.add(...) instead of babies[i] = ...
	   * 	Removed from the array using babies.remove(i)
	   * 	Moved in the array using babies.set(...) 	----- for bubble sort algorithm
	   * 
	   * 
	   */
	  
    Scanner sc = new Scanner(System.in);

    ArrayList<Baby> babies = new ArrayList<Baby>();

    for (int i = 0; i < 4; i++) {
    System.out.printf("\nEnter a name & age for baby %d.\n", i+1);
      System.out.println("Example: 'sam 2' (Separated by a space)");
      String input = sc.nextLine();
      String inputs[] = input.split(" ");
      String name = inputs[0];
      int age = Integer.parseInt(inputs[1]);

      // write to the array
      babies.add(new Baby(name, age));
    }

    OutputBabies(babies);
     System.out.printf("\nAverage age: %1.3f\n", AverageAge(babies));
    CheckDuplicateBabies(babies);
    
    System.out.printf("\nEnter a baby name to be removed (optional): ");
    String removeName = sc.nextLine().trim().toLowerCase();
    RemoveMatchingBabyName(babies, removeName);
    
    

    String response = "";
    
    while (!(response.equals("n"))) {
        System.out.printf("Would you like to add a baby to the list? (y/n): ");

    	response = sc.nextLine().trim().toLowerCase();
    	
    	if (response.equals("n")) break;
    	
    	else if (response.equals("y")) {
    		System.out.printf("\nEnter a name & age for a baby.\n");
    	      System.out.println("Example: 'sam 2' (Separated by a space)");
    	      String input = sc.nextLine();
    	      String inputs[] = input.split(" ");
    	      String name = inputs[0];
    	      int age = Integer.parseInt(inputs[1]);

    	      // write to the array
    	      babies.add(new Baby(name, age));
    	}
    	else {
    		System.out.println("Invalid response. Please try again.");
    	}
    }
    
    System.out.println("Sorting babies by name...");
    SortBabiesByName(babies);
    System.out.println("Sorted babies in order:");
    OutputBabies(babies);
  }

  public static void OutputBabies(ArrayList<Baby> babies) {
    System.out.printf("\n\n");
    for (int i = 0; i < 4; i++) {
      System.out.printf("Baby %d: %10s        age  %3d\n", 
        i+1, babies.get(i).GetName(), babies.get(i).GetAge());
    }
  }

  public static float AverageAge(ArrayList<Baby> babies) {
     int sum = 0;
     for (int i = 0; i < babies.size(); i++) {
      sum += babies.get(i).GetAge();
    }
    return (float)sum / 4.0f;
  }

  public static boolean CheckDuplicateBabies(ArrayList<Baby> babies) {
    // store duplicate indices in a
    // string (integers must be sorted
    // to avoid extra duplicates)
    String duplicates = "";
    // the string will look like:
    // 1-2\n0-3
    // if index 1 & 2 match
    // and if index 0 & 3 match

    for (int i = 0; i < 4; i++) {
      Baby curBaby = babies.get(i);
      for (int a = 0; a < 4; a++) {
        Baby curBaby2 = babies.get(a);
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
    if (duplicates.equals("")) {
    	System.out.println("There are no duplicate babies.");
    	return false;
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
        index1+1, babies.get(index1).GetName(), babies.get(index1).GetAge(),
        index2+1, babies.get(index2).GetName(), babies.get(index2).GetAge());
    }
    return true;
  }
  
  public static void RemoveMatchingBabyName(ArrayList<Baby> babies, String findName) {
	  int count = 0;
	  for (int i = 0; i < babies.size(); i++) {
		  if (babies.get(i).GetName().equals(findName)) {
			  System.out.printf("Removed %s, aged %d from the list.\n", babies.get(i).GetName(), babies.get(i).GetAge());
			  babies.remove(i);
			  count++;
		  }
	  }
	  System.out.printf("Removed %d babies from the list.\n", count);
  }
  
  public static void SortBabiesByName(ArrayList<Baby> babies) {
	  int l = babies.size() - 1;
	  for (int i = 0; i < l; i++) {
		  for (int k = 0; k < l - i; k++) {
			  	if (babies.get(k).GetName().compareTo(babies.get(k+1).GetName()) > 0) {
			  		var temp = babies.get(k);
			  		babies.set(k,  babies.get(k+1));
			  		babies.set(k+1,  temp);
			  	}
		  }
	  }
  }
}

