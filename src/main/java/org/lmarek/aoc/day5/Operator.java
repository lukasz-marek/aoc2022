package org.lmarek.aoc.day5;

class Operator {
  public void execute(Ship ship, Procedure procedure) {
    for (var step : procedure.steps()) {
      execute(ship, step);
    }
  }

  private void execute(Ship ship, Step step) {
    for (var i = 0; i < step.moves(); i++) {
      ship.moveCrate(step.from(), step.to());
    }
  }
}
