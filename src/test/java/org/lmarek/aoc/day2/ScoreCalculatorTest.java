package org.lmarek.aoc.day2;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ScoreCalculatorTest {
  private final ScoreCalculator tested = new ScoreCalculator();

  static Stream<Arguments> scores() {
    return Stream.of(
        Arguments.of(Shape.ROCK, Shape.PAPER, 8),
        Arguments.of(Shape.PAPER, Shape.ROCK, 1),
        Arguments.of(Shape.SCISSORS, Shape.SCISSORS, 6));
  }

  @ParameterizedTest
  @MethodSource("scores")
  void calculatesScoreCorrectly(Shape opponentMove, Shape playerMove, int score) {
    Assertions.assertThat(tested.calculate(opponentMove, playerMove)).isEqualTo(score);
  }
}
