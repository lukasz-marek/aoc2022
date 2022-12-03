package org.lmarek.aoc.day3;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RucksackTest {

  @Nested
  class FirstCompartment {
    @Test
    void isEmptyWhenRucksackIsEmpty() {
      // given
      var rucksack = new Rucksack(Collections.emptyList());

      // when
      var compartment = rucksack.firstCompartment();

      // then
      Assertions.assertThat(compartment).isEmpty();
    }

    @Test
    void containsFirstHalfOfItems() {
      // given
      var rucksack =
          new Rucksack(List.of(new Item('a'), new Item('b'), new Item('c'), new Item('d')));

      // when
      var compartment = rucksack.firstCompartment();

      // then
      Assertions.assertThat(compartment).containsExactly(new Item('a'), new Item('b'));
    }
  }

  @Nested
  class SecondCompartment {
    @Test
    void isEmptyWhenRucksackIsEmpty() {
      // given
      var rucksack = new Rucksack(Collections.emptyList());

      // when
      var compartment = rucksack.secondCompartment();

      // then
      Assertions.assertThat(compartment).isEmpty();
    }

    @Test
    void containsSecondHalfOfItems() {
      // given
      var rucksack =
          new Rucksack(List.of(new Item('a'), new Item('b'), new Item('c'), new Item('d')));

      // when
      var compartment = rucksack.secondCompartment();

      // then
      Assertions.assertThat(compartment).containsExactly(new Item('c'), new Item('d'));
    }
  }
}
