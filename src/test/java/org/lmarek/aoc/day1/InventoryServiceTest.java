package org.lmarek.aoc.day1;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InventoryServiceTest {

  @Test
  void returnsEmptyWhenNoInventories() {
    // given
    var tested = new InventoryService(Collections.emptyList());

    // when
    var result = tested.findWithMaxCalories();

    // then
    Assertions.assertThat(result).isEmpty();
  }

  @Test
  void returnsValueWhenThereIsJustOne() {
    // given
    var item = ImmutableFoodItem.builder().calories(50L).build();
    var inventory = ImmutableInventory.builder().addItems(item).build();
    var tested = new InventoryService(List.of(inventory));

    // when
    var result = tested.findWithMaxCalories();

    // then
    Assertions.assertThat(result).contains(inventory);
  }

  @Test
  void returnsMaxValueWhenThereAreMany() {
    // given
    var item1 = ImmutableFoodItem.builder().calories(50L).build();
    var inventory1 = ImmutableInventory.builder().addItems(item1).build();
    var item2 = ImmutableFoodItem.builder().calories(1050L).build();
    var inventory2 = ImmutableInventory.builder().addItems(item2).build();
    var item3 = ImmutableFoodItem.builder().calories(150L).build();
    var inventory3 = ImmutableInventory.builder().addItems(item3).build();

    var tested = new InventoryService(List.of(inventory1, inventory2, inventory3));

    // when
    var result = tested.findWithMaxCalories();

    // then
    Assertions.assertThat(result).contains(inventory2);
  }
}
