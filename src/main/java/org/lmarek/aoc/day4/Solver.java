package org.lmarek.aoc.day4;

public class Solver {
  public static void main(String[] args) {
    var input = InputLoader.load();
    var numberOfFullyContained =
        input.stream()
            .filter(
                assignment ->
                    assignment.first().fullyContains(assignment.second())
                        || assignment.second().fullyContains(assignment.first()))
            .count();
    System.out.println("Part 1 " + numberOfFullyContained);
  }
}
