package coffeeMachine.beverages;

import coffeeMachine.engine.CoffeeEngine;

public class Capuccino implements Beverage {

  private CoffeeEngine engine;

  public Capuccino(CoffeeEngine engine) {
    this.engine = engine;
  }

  @Override
  public void serve() {
    if (engine.getWater() - 200 >= 0 && engine.getCoffee() - 12 >= 0 && engine.getMilk() - 100 >= 0
        && engine.getCups() - 1 >= 0) {
      System.out.printf("I have enough resources, making you a coffee!\n");
      engine.setWater(engine.getWater() - 200);
      engine.setMilk(engine.getMilk() - 100);
      engine.setCoffee(engine.getCoffee() - 12);
      engine.setCups(engine.getCups() - 1);
      engine.setMoney(engine.getMoney() + 6);
    } else {
      if (engine.getWater() - 200 < 0) {
        System.out.printf("Sorry, not enough water!\n");
      }
      if (engine.getMilk() - 100 < 0) {
        System.out.printf("Sorry, not enough milk!\n");
      }
      if (engine.getCoffee() - 12 < 0) {
        System.out.printf("Sorry, not enough coffee beans!\n");
      }
      if (engine.getCups() - 1 < 0) {
        System.out.printf("Sorry, not enough cups!\n");
      }
    }
    System.out.printf("\n");
  }
}
