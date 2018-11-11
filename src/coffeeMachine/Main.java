package coffeeMachine;

import coffeeMachine.engine.CoffeeEngine;
import coffeeMachine.engine.StdIoDisplay;
import java.util.*;

class Main {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      CoffeeEngine coffeeEngine = new CoffeeEngine(400, 540, 120, 9, 550);
      StdIoDisplay display = new StdIoDisplay();
      CoffeeMachine coffeeMachine = new CoffeeMachine(coffeeEngine, display);
      coffeeMachine.displayInvitation();
      while (!coffeeMachine.isTerminated()) {
        coffeeMachine.process(sc.nextLine());
      }
    }
  }
}