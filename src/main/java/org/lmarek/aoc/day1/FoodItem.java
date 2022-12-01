package org.lmarek.aoc.day1;

import org.immutables.value.Value;

@Value.Immutable
interface FoodItem {

  long calories();
}
