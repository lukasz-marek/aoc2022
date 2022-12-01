package org.lmarek.aoc.day1;

public class Solver {
  public static void main(String[] args) {
    var inventories = InputLoader.load();
    var service = new InventoryService(inventories);
    service
        .findWithMaxCalories()
        .ifPresent(inventory -> System.out.println("Part 1 " + inventory.totalCalories()));
    var sumOfCalories =
        service.findTopCalories(3).stream().mapToLong(Inventory::totalCalories).sum();
    System.out.println("Part 2: " + sumOfCalories);
  }
}
