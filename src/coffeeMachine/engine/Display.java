package coffeeMachine.engine;

public interface Display {

  void displayMessage(String message);

  default void shutdown() {
  }
}
