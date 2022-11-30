package lab9_ict167;

import lab9_ict167.NotActivatedException;
import lab9_ict167.EmptyException;

public class TutorialSpace {
	private int slots;
	private boolean activated;
	
	public int GetSlots() { return this.slots; }
	public void SetSlots(int s) { this.slots = s; }

  public boolean GetActivated() { return this.activated; }
  public void SetActivated(boolean b) { this.activated = b; }

  public TutorialSpace(int nSlots) {
	
    this.SetSlots(nSlots);
    this.SetActivated(true);
    
    try {
    	if (this.GetSlots() == 0) throw new EmptyException("Exception: TutorialSpace is already empty.");
    	if (this.GetSlots() < 0) throw new EmptyException("Exception: TutorialSpace has invalid (negative) slot amount.");
    }
    catch (Exception e) {
    	System.out.println(e.getMessage());
    }
  }

  public void Activate() {
    try {
      if (this.GetActivated() == true) throw new NotActivatedException("Exception: TutorialSpace is already activated.");
      
      this.SetActivated(true);
    } 
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void ReserveSlot() {
    try {
      if (this.GetSlots() <= 0) throw new EmptyException("Exception: TutorialSpace is already empty.");
      
      this.SetSlots(this.GetSlots()-1);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public int SlotsRemaining() {
    return this.GetSlots();
  }
}
