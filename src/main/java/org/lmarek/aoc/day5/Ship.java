package org.lmarek.aoc.day5;

import java.util.ArrayList;
import java.util.List;

class Ship {
  private final List<CargoStack> stacks = new ArrayList<>();

  public Ship(List<CargoStack> initialState) {
    stacks.addAll(initialState);
  }

  public void moveCrate(int from, int to) {
    var moved = stacks.get(from).pop();
    stacks.get(to).push(moved);
  }
}
