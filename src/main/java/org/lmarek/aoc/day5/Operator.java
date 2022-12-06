package org.lmarek.aoc.day5;

class Operator {
  public void execute(Ship ship, Procedure procedure) {
    for (var step : procedure.steps()) {
      execute(ship, step);
    }
  }

  public void executeMulti(Ship ship, Procedure procedure) {
    for (var step : procedure.steps()) {
      executeMulti(ship, step);
    }
  }

  private void execute(Ship ship, Step step) {
    for (var i = 0; i < step.moves(); i++) {
      ship.moveCrate(step.from(), step.to());
    }
  }

  private void executeMulti(Ship ship, Step step) {
    ship.moveCrates(step.from(), step.to(), step.moves());
  }
}
