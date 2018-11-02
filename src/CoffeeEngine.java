class CoffeeEngine {

  private int water;
  private int milk;
  private int coffee;
  private int cups;
  private int money;
  private EngineState engineState;

  public CoffeeEngine(int water, int milk, int coffee, int cups, int money,
      EngineState engineState) {
    this.water = water;
    this.milk = milk;
    this.coffee = coffee;
    this.cups = cups;
    this.money = money;
    this.engineState = engineState;
  }

  boolean isOfferedBuy() {
    return engineState == EngineState.BUY;
  }

  void fillWater(String input) {
    water += Integer.valueOf(input);
    engineState = EngineState.FILL_MILK;
    System.out.printf("Write how many ml of milk do you want to add: ");
  }

  void fillMilk(String input) {
    milk += Integer.valueOf(input);
    engineState = EngineState.FILL_BEANS;
    System.out.printf("Write how many grams of coffee beans do you want to add: ");
  }

  void fillBeans(String input) {
    coffee += Integer.valueOf(input);
    engineState = EngineState.FILL_CUPS;
    System.out.printf("Write how many disposable cups of coffee do you want to add: ");
  }

  void fillCups(String input) {
    cups += Integer.valueOf(input);
    engineState = EngineState.IDLE;
    System.out.printf("\n");
  }

  boolean isOfferedFillWater() {
    return engineState == EngineState.FILL_WATER;
  }

  boolean isOfferedFillMilk() {
    return engineState == EngineState.FILL_MILK;
  }

  boolean isOfferedFillBeans() {
    return engineState == EngineState.FILL_BEANS;
  }

  boolean isOfferedFillCups() {
    return engineState == EngineState.FILL_CUPS;
  }

  boolean isTerminated() {
    return engineState == EngineState.EXIT;
  }

  public boolean isIdle() {
    return engineState == EngineState.IDLE;
  }

  void terminate() {
    engineState = EngineState.EXIT;
  }

  void printState() {
    System.out.printf("\nThe coffee machine has:\n");
    System.out.printf("%d of water\n", water);
    System.out.printf("%d of milk\n", milk);
    System.out.printf("%d of coffee beans\n", coffee);
    System.out.printf("%d of disposable cups\n", cups);
    System.out.printf("%d of money\n\n", money);
    engineState = EngineState.IDLE;
  }

  void takeAction() {
    System.out.printf("\nI gave you $%d\n\n", money);
    money = 0;
    engineState = EngineState.IDLE;
  }

  void proposeBuy() {
    System.out.printf("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
    engineState = EngineState.BUY;
  }

  void proposeFill() {
    System.out.printf("Write how many ml of water do you want to add: ");
    engineState = EngineState.FILL_WATER;
  }

  void makeBeverage(String option) {
    switch (option) {
      case "1":
        serveEspresso();
        break;
      case "2":
        serveLatte();
        break;
      case "3":
        serveCappuccino();
        break;
    }
    engineState = EngineState.IDLE;
  }

  private void serveEspresso() {
    if (water - 250 >= 0 && coffee - 16 >= 0 && cups - 1 >= 0) {
      System.out.printf("I have enough resources, making you a coffee!\n");
      water -= 250;
      coffee -= 16;
      cups -= 1;
      money += 4;
    } else {
      if (water - 250 < 0) {
        System.out.printf("Sorry, not enough water!\n");
      }
      if (coffee - 16 < 0) {
        System.out.printf("Sorry, not enough coffee beans!\n");
      }
      if (cups - 1 < 0) {
        System.out.printf("Sorry, not enough cups!\n");
      }
    }
    System.out.printf("\n");
  }

  private void serveLatte() {
    if (water - 350 >= 0 && coffee - 20 >= 0 && milk - 75 >= 0 && cups - 1 >= 0) {
      System.out.printf("I have enough resources, making you a coffee!\n");
      water -= 350;
      milk -= 75;
      coffee -= 20;
      cups -= 1;
      money += 7;
    } else {
      if (water - 350 < 0) {
        System.out.printf("Sorry, not enough water!\n");
      }
      if (milk - 75 < 0) {
        System.out.printf("Sorry, not enough milk!\n");
      }
      if (coffee - 20 < 0) {
        System.out.printf("Sorry, not enough coffee beans!\n");
      }
      if (cups - 1 < 0) {
        System.out.printf("Sorry, not enough cups!\n");
      }
    }
    System.out.printf("\n");
  }

  private void serveCappuccino() {
    if (water - 200 >= 0 && coffee - 12 >= 0 && milk - 100 >= 0 && cups - 1 >= 0) {
      System.out.printf("I have enough resources, making you a coffee!\n");
      water -= 200;
      milk -= 100;
      coffee -= 12;
      cups -= 1;
      money += 6;
    } else {
      if (water - 200 < 0) {
        System.out.printf("Sorry, not enough water!\n");
      }
      if (milk - 100 < 0) {
        System.out.printf("Sorry, not enough milk!\n");
      }
      if (coffee - 12 < 0) {
        System.out.printf("Sorry, not enough coffee beans!\n");
      }
      if (cups - 1 < 0) {
        System.out.printf("Sorry, not enough cups!\n");
      }
    }
    System.out.printf("\n");
  }
}
