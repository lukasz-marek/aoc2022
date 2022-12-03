package org.lmarek.aoc.day3;

import org.apache.commons.collections4.ListUtils;

class Solver {
  public static void main(String[] args) {
    var rucksacks = InputLoader.load();
    var analyzer = new RucksackAnalyzer();
    var sumOfPriorities =
        rucksacks.stream()
            .map(analyzer::findCommonItemsInCompartments)
            .flatMapToLong(items -> items.stream().mapToLong(Item::priority))
            .sum();
    System.out.println("Part 1: " + sumOfPriorities);

    var groups = ListUtils.partition(rucksacks, 3).stream().map(Group::new).toList();
    var sumOfBadgePriorities =
        groups.stream().map(Group::findBadge).mapToLong(Item::priority).sum();
    System.out.println("Part 2: " + sumOfBadgePriorities);
  }
}
