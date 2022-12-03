package org.lmarek.aoc.day3;

import java.util.HashSet;
import java.util.List;

record Group(List<Rucksack> rucksacks) {
  Group {
    if (rucksacks.size() % 3 != 0) {
      throw new IllegalArgumentException(
          "A group must have exactly 3 rucksacks, got " + rucksacks.size());
    }
    rucksacks = List.copyOf(rucksacks);
  }

  public Item findBadge() {
    var potentialBadges = new HashSet<Item>();
    rucksacks.forEach(rucksack -> potentialBadges.addAll(rucksack.items()));
    rucksacks.forEach(rucksack -> potentialBadges.retainAll(rucksack.items()));
    return potentialBadges.stream().findFirst().get();
  }
}
