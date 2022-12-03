package org.lmarek.aoc.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GroupTest {
  static Stream<Arguments> rucksacks() {
    return Stream.of(
        Arguments.of(
            rucksack('a', 'b', 'c', 'd'),
            rucksack('z', 'o', 'a', 'B'),
            rucksack('a', 'y'),
            item('a')),
        Arguments.of(
            rucksack('z', 'Y'), rucksack('z', 'o', 'a', 'F'), rucksack('A', 'z'), item('z')));
  }

  private static Item item(char symbol) {
    return new Item(symbol);
  }

  private static Rucksack rucksack(char... symbols) {
    var items = new ArrayList<Item>();
    for (var symbol : symbols) {
      items.add(item(symbol));
    }
    return new Rucksack(items);
  }

  @ParameterizedTest
  @MethodSource("rucksacks")
  void findsBadge(Rucksack rucksack1, Rucksack rucksack2, Rucksack rucksack3, Item expectedBadge) {
    // given
    var tested = new Group(List.of(rucksack1, rucksack2, rucksack3));

    // when
    var badge = tested.findBadge();

    // then
    Assertions.assertThat(badge).isEqualTo(expectedBadge);
  }
}
