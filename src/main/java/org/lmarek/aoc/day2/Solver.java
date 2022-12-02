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

    var correctedGame = InputLoader.loadCorrected();
    var predictor = new MovePredictor();
    var correctedScore =
        correctedGame.expectedRounds().stream()
            .map(
                round ->
                    ImmutableRound.builder()
                        .opponentMove(round.opponentMove())
                        .playerMove(predictor.predict(round.opponentMove(), round.expectation()))
                        .build())
            .mapToLong(round -> calculator.calculate(round.opponentMove(), round.playerMove()))
            .sum();
    System.out.println("Part 2: " + correctedScore);
  }
}
