package org.lmarek.aoc.day5;

import java.util.stream.Collectors;

class Solver {
  public static void main(String[] args) {
    var crates = InputLoader.loadCrates();
    var procedure = InputLoader.loadProcedure();
    var operator = new Operator();
    operator.execute(crates, procedure);

    var topMarks = findTopMarks(crates);
    System.out.println(topMarks);

    crates = InputLoader.loadCrates();
    procedure = InputLoader.loadProcedure();
    operator.executeMulti(crates, procedure);
    topMarks = findTopMarks(crates);
    System.out.println(topMarks);
  }

  private static String findTopMarks(Ship crates) {
    return crates.getStacks().stream()
        .map(CargoStack::topElement)
        .map(Crate::mark)
        .collect(Collectors.joining());
  }
}
