package lab9_ict167;

public class NotActivatedException extends Exception {
  public NotActivatedException() {
    super("Exception: TutorialSpace is not activated.");
  }

  public NotActivatedException(String msg) {
    super(msg);
  }
}
