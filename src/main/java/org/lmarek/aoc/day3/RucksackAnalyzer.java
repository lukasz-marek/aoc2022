package org.lmarek.aoc.day3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class RucksackAnalyzer {
  public Set<Item> findCommonItemsInCompartments(Rucksack rucksack) {
    var firstCompartment = new HashSet<>(rucksack.firstCompartment());
    var secondCompartment = new HashSet<>(rucksack.secondCompartment());

    firstCompartment.retainAll(secondCompartment);
    return Collections.unmodifiableSet(firstCompartment);
  }
}
