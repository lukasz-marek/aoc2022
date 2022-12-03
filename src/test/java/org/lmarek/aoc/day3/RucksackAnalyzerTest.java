package org.lmarek.aoc.day3;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RucksackAnalyzerTest {
  private final RucksackAnalyzer tested = new RucksackAnalyzer();

  @Test
  void returnsEmptyListWhenNothingIsCommon() {
    // given
    var rucksack = new Rucksack(List.of(item('a'), item('b')));

    // when
    var common = tested.findCommonItemsInCompartments(rucksack);

    // then
    Assertions.assertThat(common).isEmpty();
  }

  @Test
  void returnsSingleSharedItemWhenDetected() {
    // given
    var rucksack = new Rucksack(List.of(item('a'), item('c'), item('a'), item('d')));

    // when
    var common = tested.findCommonItemsInCompartments(rucksack);

    // then
    Assertions.assertThat(common).containsExactlyInAnyOrder(item('a'));
  }

  @Test
  void returnsMultipleSharedItemsWhenDetected() {
    // given
    var rucksack =
        new Rucksack(List.of(item('a'), item('b'), item('c'), item('a'), item('b'), item('d')));

    // when
    var common = tested.findCommonItemsInCompartments(rucksack);

    // then
    Assertions.assertThat(common).containsExactlyInAnyOrder(item('a'), item('b'));
  }

  private Item item(char symbol) {
    return new Item(symbol);
  }
}
