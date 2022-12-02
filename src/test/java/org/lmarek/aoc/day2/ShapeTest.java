package org.lmarek.aoc.day2;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ShapeTest {

  static Stream<Arguments> scores() {
    return Stream.of(
        Arguments.of(Shape.ROCK, 1), Arguments.of(Shape.PAPER, 2), Arguments.of(Shape.SCISSORS, 3));
  }

  static Stream<Arguments> fights() {
    return Stream.of(
        Arguments.of(Shape.ROCK, Shape.ROCK, false),
        Arguments.of(Shape.ROCK, Shape.PAPER, false),
        Arguments.of(Shape.ROCK, Shape.SCISSORS, true),
        Arguments.of(Shape.SCISSORS, Shape.SCISSORS, false),
        Arguments.of(Shape.SCISSORS, Shape.PAPER, true),
        Arguments.of(Shape.SCISSORS, Shape.ROCK, false),
        Arguments.of(Shape.PAPER, Shape.PAPER, false),
        Arguments.of(Shape.PAPER, Shape.ROCK, true),
        Arguments.of(Shape.PAPER, Shape.SCISSORS, false));
  }

  @ParameterizedTest
  @MethodSource("scores")
  void returnsExpectedScores(Shape shape, int expectedScore) {
    Assertions.assertThat(shape.getScore()).isEqualTo(expectedScore);
  }

  @ParameterizedTest
  @MethodSource("fights")
  void fightsHaveExpectedResults(Shape shape, Shape another, boolean isBeatenBy) {
    Assertions.assertThat(another.isBeatenBy(shape)).isEqualTo(isBeatenBy);
  }
}
