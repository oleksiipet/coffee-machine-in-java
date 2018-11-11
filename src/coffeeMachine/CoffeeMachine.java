package coffeeMachine;

import coffeeMachine.engine.CoffeeEngine;
import coffeeMachine.engine.Display;
import coffeeMachine.state.MachineState;

public class CoffeeMachine {

  private CoffeeEngine coffeeEngine;
  private MachineState machineState;
  private Display display;

  CoffeeMachine(CoffeeEngine coffeeEngine, Display display) {
    this.coffeeEngine = coffeeEngine;
    this.display = display;
    this.machineState = MachineState.defaultState();
  }

  public void process(String input) {
    machineState.processRequest(input, this);
  }

  public void setMachineState(MachineState machineState) {
    this.machineState = machineState;
  }

  public boolean isTerminated() {
    return coffeeEngine.isTerminated();
  }

  public void display(String message) {
    display.displayMessage(message);
  }

  public void withdrawMoney() {
    System.out.printf("\nI gave you $%d\n\n", coffeeEngine.getMoney());
    coffeeEngine.setMoney(0);
  }

  public void terminate() {
    display.shutdown();
    coffeeEngine.terminate();
  }

  public void displayInvitation() {
    System.out.print("Write action (buy, fill, take, remaining, exit): ");
  }

  public void printState() {
    System.out.printf("\nThe coffee machine has:\n");
    System.out.printf("%d of water\n", coffeeEngine.getWater());
    System.out.printf("%d of milk\n", coffeeEngine.getMilk());
    System.out.printf("%d of coffee beans\n", coffeeEngine.getCoffee());
    System.out.printf("%d of disposable cups\n", coffeeEngine.getCups());
    System.out.printf("%d of money\n\n", coffeeEngine.getMoney());
  }

  public CoffeeEngine getEngine() {
    return coffeeEngine;
  }
}
