package org.lmarek.aoc.day5;

import java.util.ArrayList;
import java.util.List;

class Ship {
  private final List<CargoStack> stacks = new ArrayList<>();

  public Ship(List<CargoStack> initialState) {
    stacks.addAll(initialState);
  }

  public void moveCrate(int from, int to) {
    var moved = stacks.get(from - 1).pop();
    stacks.get(to - 1).push(moved);
  }

  public List<CargoStack> getStacks() {
    return stacks;
  }
}
