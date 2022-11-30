package lab8_ict167;

public class Playgroup extends Baby {
	public Playgroup (String name, int age) {
		super(name, age);
	}
	
	public Playgroup() {
		super();
	}
	
	public void BabySound() {
		System.out.println("Baby Sound is Happy");
	}
	

	public String toString() {
		  return String.format("Name: %10s, Age: %d, Baby Sound is Happy", 
				  this.GetName(), this.GetAge());
	}
}
