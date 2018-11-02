import java.util.*;

class Main {

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      CoffeeEngine coffeeEngine = new CoffeeEngine(400, 540, 120, 9, 550,
          EngineState.IDLE);
      CoffeeMachine coffeeMachine = new CoffeeMachine(coffeeEngine);

      while (true) {
        if (coffeeMachine.isIdle()) {
          System.out.print("Write action (buy, fill, take, remaining, exit): ");
        }
        if (coffeeMachine.isTerminated()) {
          break;
        }
        coffeeMachine.process(sc.nextLine());
      }
    }
  }
}