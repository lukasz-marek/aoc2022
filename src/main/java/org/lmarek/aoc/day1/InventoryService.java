package org.lmarek.aoc.day1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class InventoryService {
  private final List<Inventory> inventories;

  InventoryService(List<? extends Inventory> inventories) {
    this.inventories = List.copyOf(inventories);
  }

  public Optional<Inventory> findWithMaxCalories() {
    return inventories.stream().max(Comparator.comparing(Inventory::totalCalories));
  }

  public List<Inventory> findTopCalories(int limit) {
    return inventories.stream()
        .sorted(Comparator.comparing(Inventory::totalCalories).reversed())
        .limit(limit)
        .toList();
  }
}
