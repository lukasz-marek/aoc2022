package org.lmarek.aoc.day1;

import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InventoryServiceTest {

  @Nested
  class Max {

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

  @Nested
  class Top {
    @Test
    void returnsEmptyWhenNoInventories() {
      // given
      var tested = new InventoryService(Collections.emptyList());

      // when
      var result = tested.findTopCalories(1);

      // then
      Assertions.assertThat(result).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 1000})
    void returnsValueWhenThereIsJustOne(int limit) {
      // given
      var item = ImmutableFoodItem.builder().calories(50L).build();
      var inventory = ImmutableInventory.builder().addItems(item).build();
      var tested = new InventoryService(List.of(inventory));

      // when
      var result = tested.findTopCalories(limit);

      // then
      Assertions.assertThat(result).contains(inventory);
    }

    @Test
    void returnsTopOne() {
      // given
      var item1 = ImmutableFoodItem.builder().calories(50L).build();
      var inventory1 = ImmutableInventory.builder().addItems(item1).build();
      var item2 = ImmutableFoodItem.builder().calories(1050L).build();
      var inventory2 = ImmutableInventory.builder().addItems(item2).build();
      var item3 = ImmutableFoodItem.builder().calories(150L).build();
      var inventory3 = ImmutableInventory.builder().addItems(item3).build();

      var tested = new InventoryService(List.of(inventory1, inventory2, inventory3));

      // when
      var result = tested.findTopCalories(1);

      // then
      Assertions.assertThat(result).containsExactly(inventory2);
    }

    @Test
    void returnsTopTwo() {
      // given
      var item1 = ImmutableFoodItem.builder().calories(50L).build();
      var inventory1 = ImmutableInventory.builder().addItems(item1).build();
      var item2 = ImmutableFoodItem.builder().calories(1050L).build();
      var inventory2 = ImmutableInventory.builder().addItems(item2).build();
      var item3 = ImmutableFoodItem.builder().calories(150L).build();
      var inventory3 = ImmutableInventory.builder().addItems(item3).build();

      var tested = new InventoryService(List.of(inventory1, inventory2, inventory3));

      // when
      var result = tested.findTopCalories(2);

      // then
      Assertions.assertThat(result).containsExactlyInAnyOrder(inventory2, inventory3);
    }

    @Test
    void returnsTopThree() {
      // given
      var item1 = ImmutableFoodItem.builder().calories(50L).build();
      var inventory1 = ImmutableInventory.builder().addItems(item1).build();
      var item2 = ImmutableFoodItem.builder().calories(1050L).build();
      var inventory2 = ImmutableInventory.builder().addItems(item2).build();
      var item3 = ImmutableFoodItem.builder().calories(150L).build();
      var inventory3 = ImmutableInventory.builder().addItems(item3).build();

      var tested = new InventoryService(List.of(inventory1, inventory2, inventory3));

      // when
      var result = tested.findTopCalories(3);

      // then
      Assertions.assertThat(result).containsExactlyInAnyOrder(inventory2, inventory3, inventory1);
    }
  }
}
