package org.lmarek.aoc.day1;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InventoryTest {

  @Test
  void returnsZeroCaloriesWhenEmpty() {
    // given
    var inventory = ImmutableInventory.builder().items(Collections.emptyList()).build();

    // when
    var calories = inventory.totalCalories();

    // then
    Assertions.assertThat(calories).isZero();
  }

  @Test
  void returnsSumOfCalories() {
    // given
    var items =
        List.of(
            ImmutableFoodItem.builder().calories(100L).build(),
            ImmutableFoodItem.builder().calories(50L).build(),
            ImmutableFoodItem.builder().calories(1L).build());

    var inventory = ImmutableInventory.builder().items(items).build();

    // when
    var calories = inventory.totalCalories();

    // then
    Assertions.assertThat(calories).isEqualTo(151L);
  }
}
