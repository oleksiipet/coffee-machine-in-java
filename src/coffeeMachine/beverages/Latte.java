package coffeeMachine.beverages;

import coffeeMachine.engine.CoffeeEngine;

public class Latte implements Beverage {

  private CoffeeEngine engine;

  public Latte(CoffeeEngine engine) {
    this.engine = engine;
  }

  @Override
  public void serve() {
    if (engine.getWater() - 350 >= 0 && engine.getCoffee() - 20 >= 0 && engine.getMilk() - 75 >= 0
        && engine.getCups() - 1 >= 0) {
      System.out.printf("I have enough resources, making you a coffee!\n");
      engine.setWater(engine.getWater() - 350);
      engine.setMilk(engine.getMilk() - 75);
      engine.setCoffee(engine.getCoffee() - 20);
      engine.setCups(engine.getCups() - 1);
      engine.setMoney(engine.getMoney() + 7);
    } else {
      if (engine.getWater() - 350 < 0) {
        System.out.printf("Sorry, not enough water!\n");
      }
      if (engine.getMilk() - 75 < 0) {
        System.out.printf("Sorry, not enough milk!\n");
      }
      if (engine.getCoffee() - 20 < 0) {
        System.out.printf("Sorry, not enough coffee beans!\n");
      }
      if (engine.getCups() - 1 < 0) {
        System.out.printf("Sorry, not enough cups!\n");
      }
    }
    System.out.printf("\n");
  }
}
