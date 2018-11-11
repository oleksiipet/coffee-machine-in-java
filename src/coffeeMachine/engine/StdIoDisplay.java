package coffeeMachine.engine;

import coffeeMachine.engine.Display;

public class StdIoDisplay implements Display {

  @Override
  public void displayMessage(String message) {
    System.out.printf(message);
  }
}
