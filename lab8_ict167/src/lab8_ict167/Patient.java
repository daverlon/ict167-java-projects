package lab8_ict167;

public class Patient extends Baby {
	private int idNumber;
	
	public Patient(String name, int age, int id) {
		super(name, age);
		this.idNumber = id;
	}
	
	public Patient() {
		super();
		this.idNumber = 0;
	}
	
	public int 	GetIdNumber() { return this.idNumber; }
	public void SetIdNumber(int id) { this.idNumber = id; }
	
	public boolean equals(Patient other) {
	    return (this.GetIdNumber() == other.GetIdNumber());
	 }
	
	public void BabySound() {
		System.out.println("Baby Sound is Sick");
	}
	

	 public String toString() {
		  return String.format("Name: %10s, Age: %d, ID Number: %d, Baby Sound is Sick", 
				  this.GetName(), this.GetAge(), this.GetIdNumber());
	}
	  
	  
}
