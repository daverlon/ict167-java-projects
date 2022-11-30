package lab9_ict167;

import lab9_ict167.TutorialSpace;

public class registerClass {
  public static void main(String[] args) {
    
	int test_slots = 5;
	  
    TutorialSpace ts = new TutorialSpace(test_slots);
    
    // ts should have 5 slots
    TestCon(ts.SlotsRemaining() == test_slots, "TutorialSpace has incorrect slot count.");
    
    // ts should be activated
    TestCon(ts.GetActivated() == true, "TutorialSpace is not activated");
    
    // ts should throw an already-activated exception
    ts.Activate();
       
    ts.ReserveSlot();
    ts.ReserveSlot();
    ts.ReserveSlot();
    ts.ReserveSlot();
    TestCon(ts.SlotsRemaining() == 1, "TutorialSpace has invalid slots remaining after reserving slots.");
    
    // reserving the final slot
    ts.ReserveSlot();

    
    // ts should throw an empty slots exception
    ts.ReserveSlot();
    
    
    // overwrite ts with a new tutorialspace instance
    // to test the exception in the constructor
    ts = new TutorialSpace(-1);
    ts = new TutorialSpace(0);
 
    System.out.println("Program completed."); 
  }
  
  
  public static void TestCon(boolean condition, String errorMsg) {
	   if (!condition) System.out.println("Error: " + errorMsg);
  }
}
