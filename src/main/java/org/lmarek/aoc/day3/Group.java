package org.lmarek.aoc.day3;

import java.util.List;

record Group(List<Rucksack> rucksacks) {
  Group {
    if (rucksacks.size() % 3 != 0) {
      throw new IllegalArgumentException(
          "A group must have exactly 3 rucksacks, got " + rucksacks.size());
    }
    rucksacks = List.copyOf(rucksacks);
  }
}
