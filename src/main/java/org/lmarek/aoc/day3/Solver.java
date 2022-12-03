package org.lmarek.aoc.day3;

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
  }
}
