package org.lmarek.aoc.day1;

public class Solver {
  public static void main(String[] args) {
    var inventories = InputLoader.load();
    var service = new InventoryService(inventories);
    service
        .findWithMaxCalories()
        .ifPresent(inventory -> System.out.println(inventory.totalCalories()));
  }
}
