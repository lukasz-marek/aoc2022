package org.lmarek.aoc.day3;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ItemTest {

  static Stream<Arguments> expectedPriorities() {
    return Stream.of(
        Arguments.of('a', 1),
        Arguments.of('A', 27),
        Arguments.of('Z', 52),
        Arguments.of('z', 26),
        Arguments.of('p', 16),
        Arguments.of('L', 38),
        Arguments.of('P', 42),
        Arguments.of('v', 22),
        Arguments.of('t', 20),
        Arguments.of('s', 19));
  }

  @ParameterizedTest
  @MethodSource("expectedPriorities")
  void returnsExpectedPriority(char symbol, int expected) {
    Assertions.assertThat(new Item(symbol).priority()).isEqualTo(expected);
  }
}
