package coffeeMachine.beverages;

import coffeeMachine.engine.CoffeeEngine;

public class Espresso implements Beverage {

  private CoffeeEngine engine;

  public Espresso(CoffeeEngine engine) {
    this.engine = engine;
  }

  @Override
  public void serve() {
    if (engine.getWater() - 250 >= 0 && engine.getCoffee() - 16 >= 0 && engine.getCups() - 1 >= 0) {
      System.out.printf("I have enough resources, making you a coffee!\n");
      engine.setWater(engine.getWater() - 250);
      engine.setCoffee(engine.getCoffee() - 16);
      engine.setCups(engine.getCups() - 1);
      engine.setMoney(engine.getMoney() + 4);
    } else {
      if (engine.getWater() - 250 < 0) {
        System.out.printf("Sorry, not enough water!\n");
      }
      if (engine.getCoffee() - 16 < 0) {
        System.out.printf("Sorry, not enough coffee beans!\n");
      }
      if (engine.getCups() - 1 < 0) {
        System.out.printf("Sorry, not enough cups!\n");
      }
    }
    System.out.printf("\n");
  }
}
