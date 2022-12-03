package org.lmarek.aoc.day3;

import java.util.Collections;
import java.util.List;

record Rucksack(List<Item> items) {
  Rucksack {
    items = Collections.unmodifiableList(items);
  }
}
