package src;

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
  
  public int compareTo(Baby other) {
      return GetName().compareTo(other.GetName());
  }
}
