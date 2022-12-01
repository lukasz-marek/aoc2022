package org.lmarek.aoc.day1;

import java.util.List;
import org.immutables.value.Value;

@Value.Immutable
abstract class Inventory {

  public abstract List<FoodItem> items();

  @Value.Lazy
  public long totalCalories() {
    return items().stream().mapToLong(FoodItem::calories).sum();
  }
}
