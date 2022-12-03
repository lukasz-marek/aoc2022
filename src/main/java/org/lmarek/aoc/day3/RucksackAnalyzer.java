package org.lmarek.aoc.day3;

import java.util.HashSet;
import java.util.List;

class RucksackAnalyzer {
  public List<Item> findCommonItemsInCompartments(Rucksack rucksack) {
    var secondCompartment = new HashSet<>(rucksack.secondCompartment());
    return rucksack.firstCompartment().stream().filter(secondCompartment::contains).toList();
  }
}
