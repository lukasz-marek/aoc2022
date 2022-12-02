package org.lmarek.aoc.day2;

import java.util.Arrays;
import java.util.function.Predicate;

class MovePredictor {
  private static Predicate<Shape> buildMoveSelector(Shape opponentMove, ExpectedEnd expectedEnd) {
    return switch (expectedEnd) {
      case WIN -> opponentMove::isBeatenBy;
      case LOSE -> (other) -> other.isBeatenBy(opponentMove);
      case DRAW -> (other) -> !other.isBeatenBy(opponentMove) && !opponentMove.isBeatenBy(other);
    };
  }

  public Shape predict(Shape opponentMove, ExpectedEnd expectedEnd) {
    return Arrays.stream(Shape.values())
        .filter(buildMoveSelector(opponentMove, expectedEnd))
        .findFirst()
        .get();
  }
}
