package coffeeMachine.state;

import coffeeMachine.CoffeeMachine;
import coffeeMachine.beverages.StandartBeverages;

public class Idle implements MachineState {

  private static final String BUY = "buy";
  private static final String FILL = "fill";
  private static final String TAKE = "take";
  private static final String EXIT = "exit";
  private static final String REMAINING = "remaining";

  @Override
  public void processRequest(String action, CoffeeMachine context) {
    switch (action) {
      case BUY:
        context.display("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        context.setMachineState(new ServeBeverage(StandartBeverages.Factory));
        break;
      case FILL:
        context.display("Write how many ml of water do you want to add: ");
        context.setMachineState(new FillWater());
        break;
      case TAKE:
        context.withdrawMoney();
        context.displayInvitation();
        break;
      case EXIT:
        context.terminate();
        break;
      case REMAINING:
        context.printState();
        context.displayInvitation();
        break;
    }
  }
}
