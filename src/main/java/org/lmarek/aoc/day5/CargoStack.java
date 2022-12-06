package org.lmarek.aoc.day5;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

class CargoStack {
  private final Deque<Crate> crates = new ArrayDeque<>();

  public CargoStack(Collection<Crate> initialState) {
    crates.addAll(initialState);
  }

  public Crate topElement() {
    return crates.peek();
  }

  public void push(Crate crate) {
    crates.push(crate);
  }

  public Crate pop() {
    return crates.pop();
  }
}
