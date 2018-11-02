class CoffeeMachine {

  public static final String BUY = "buy";
  public static final String FILL = "fill";
  public static final String TAKE = "take";
  public static final String EXIT = "exit";
  public static final String REMAINING = "remaining";

  private CoffeeEngine coffeeEngine;

  public CoffeeMachine(CoffeeEngine coffeeEngine) {
    this.coffeeEngine = coffeeEngine;
  }

  void process(String input) {
    if (coffeeEngine.isOfferedBuy()) {
      coffeeEngine.makeBeverage(input);
    } else if (coffeeEngine.isOfferedFillWater()) {
      coffeeEngine.fillWater(input);
    } else if (coffeeEngine.isOfferedFillMilk()) {
      coffeeEngine.fillMilk(input);
    } else if (coffeeEngine.isOfferedFillBeans()) {
      coffeeEngine.fillBeans(input);
    } else if (coffeeEngine.isOfferedFillCups()) {
      coffeeEngine.fillCups(input);
    } else {
      switch (input) {
        case BUY:
          coffeeEngine.proposeBuy();
          break;
        case FILL:
          coffeeEngine.proposeFill();
          break;
        case TAKE:
          coffeeEngine.takeAction();
          break;
        case EXIT:
          coffeeEngine.terminate();
          break;
        case REMAINING:
          coffeeEngine.printState();
          break;
      }
    }
  }

  boolean isTerminated() {
    return coffeeEngine.isTerminated();
  }

  public boolean isIdle() {
    return coffeeEngine.isIdle();
  }
}
