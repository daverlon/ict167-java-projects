package lab8_ict167;

public class Baby {
  private String name;
  private int age;

  public Baby() {
    this.name = "";
    this.age = 0;
  }

  public Baby(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String GetName() { return this.name; }
  public void SetName(String s) { this.name = s; } 

  public int GetAge() { return this.age; }
  public void SetAge(int a) { this.age = a; }

  public boolean equals(Baby other) {
    return ((this.GetName().toLowerCase().equals(other.GetName().toLowerCase()))
            && (this.GetAge() == other.GetAge()));
  }
  
  public void BabySound() {
		System.out.println("Baby Sound is Neutral");
  }
  

  public String toString() {
	  return String.format("Name: %10s, Age: %d, Baby Sound is Neutral", this.GetName(), this.GetAge());
  }
}
