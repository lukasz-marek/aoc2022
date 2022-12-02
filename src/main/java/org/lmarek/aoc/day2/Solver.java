package org.lmarek.aoc.day2;

public class Solver {
  public static void main(String[] args) {
    var game = InputLoader.load();
    var calculator = new ScoreCalculator();
    var score =
        game.rounds().stream()
            .mapToLong(round -> calculator.calculate(round.opponentMove(), round.playerMove()))
            .sum();
    System.out.println("Part 1: " + score);
  }
}
