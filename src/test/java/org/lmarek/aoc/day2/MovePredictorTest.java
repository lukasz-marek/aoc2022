package org.lmarek.aoc.day2;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MovePredictorTest {
  private final MovePredictor tested = new MovePredictor();

  static Stream<Arguments> predictions() {
    return Stream.of(
        Arguments.of(Shape.ROCK, ExpectedEnd.DRAW, Shape.ROCK),
        Arguments.of(Shape.PAPER, ExpectedEnd.DRAW, Shape.PAPER),
        Arguments.of(Shape.SCISSORS, ExpectedEnd.DRAW, Shape.SCISSORS),
        Arguments.of(Shape.ROCK, ExpectedEnd.WIN, Shape.PAPER),
        Arguments.of(Shape.PAPER, ExpectedEnd.WIN, Shape.SCISSORS),
        Arguments.of(Shape.SCISSORS, ExpectedEnd.WIN, Shape.ROCK),
        Arguments.of(Shape.ROCK, ExpectedEnd.LOSE, Shape.SCISSORS),
        Arguments.of(Shape.PAPER, ExpectedEnd.LOSE, Shape.ROCK),
        Arguments.of(Shape.SCISSORS, ExpectedEnd.LOSE, Shape.PAPER));
  }

  @ParameterizedTest
  @MethodSource("predictions")
  void predictsAsExpected(Shape opponentMove, ExpectedEnd expectedEnd, Shape expectedMove) {
    Assertions.assertThat(tested.predict(opponentMove, expectedEnd)).isEqualTo(expectedMove);
  }
}
