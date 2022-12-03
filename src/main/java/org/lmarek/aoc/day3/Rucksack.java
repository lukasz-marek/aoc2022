package org.lmarek.aoc.day3;

import java.util.Collections;
import java.util.List;

record Rucksack(List<Item> items) {
  Rucksack {
    if (items.size() % 2 != 0) {
      throw new IllegalArgumentException("Number of items must be even, got " + items.size());
    }
    items = Collections.unmodifiableList(items);
  }

  public List<Item> firstCompartment() {
    var compartmentSize = items.size() / 2;
    return items.subList(0, compartmentSize);
  }

  public List<Item> secondCompartment() {
    var compartmentSize = items.size() / 2;
    return items.subList(compartmentSize, items.size());
  }
}
