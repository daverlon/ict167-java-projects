package lab9_ict167;

import lab9_ict167.TutorialSpaceAssertion;

public class registerClassAssertion {
  public static void main(String[] args) {
    
	int test_slots = 5;
	  
	TutorialSpaceAssertion ts = new TutorialSpaceAssertion(test_slots);
   
    

    ts.Activate();
       
    ts.ReserveSlot();
    ts.ReserveSlot();
    ts.ReserveSlot();
    //ts.ReserveSlot(); // UNCOMMENTING THIS WILL THROW ASSERTION ERROR
    
    ts.ReserveSlot();
    ts.ReserveSlot();
    

    //ts = new TutorialSpaceAssertion(-1);  // UNCOMMENTING THIS WILL THROW ASSERTION ERROR
    //ts = new TutorialSpaceAssertion(0);   // UNCOMMENTING THIS WILL THROW ASSERTION ERROR
 
    System.out.println("Program completed."); 
  }
}
