package lab9_ict167;

public class EmptyException extends Exception {
  public EmptyException() {
    super("Exception: TutorialSpace is already empty.");
  }
  public EmptyException(String msg) {
    super(msg);
  }
}
