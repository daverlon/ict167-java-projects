package lab9_ict167;

public class TutorialSpaceAssertion {
	private int slots;
	private boolean activated;

	public int GetSlots() {
		return this.slots;
	}

	public void SetSlots(int s) {
		this.slots = s;
	}

	public boolean GetActivated() {
		return this.activated;
	}

	public void SetActivated(boolean b) {
		this.activated = b;
	}

	public TutorialSpaceAssertion(int nSlots) {
		this.SetSlots(nSlots);
		this.SetActivated(true);
		
		assert (this.GetActivated() == true) : "Assertion error: TutorialSpace is not activated.";
		assert (this.GetSlots() != 0) : "Assertion error: TutorialSpace is was created empty.";
		assert (this.GetSlots() > 0) : "Assertion error: TutorialSpace has was created with invalid slots. (negative int)";
    
	}

	public void Activate() {
    assert (this.GetActivated() == true) : "Assertion error: TutorialSpace is already activated.";
    this.SetActivated(true);
	}

	public void ReserveSlot() {
		assert (this.GetSlots() > 0) : "Assertion error: TutorialSpace has no more available slots.";
		this.SetSlots(this.GetSlots() - 1);
	}

	public int SlotsRemaining() {
		return this.GetSlots();
	}
}
