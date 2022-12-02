package org.lmarek.aoc.day2;

class ScoreCalculator {
  private static int calculateFightResult(Shape opponentMove, Shape playerMove) {
    if (!opponentMove.isBeatenBy(playerMove) && !playerMove.isBeatenBy(opponentMove)) {
      return 3;
    } else if (opponentMove.isBeatenBy(playerMove)) {
      return 6;
    } else {
      return 0;
    }
  }

  public long calculate(Shape opponentMove, Shape playerMove) {
    return calculateFightResult(opponentMove, playerMove) + playerMove.getScore();
  }
}
