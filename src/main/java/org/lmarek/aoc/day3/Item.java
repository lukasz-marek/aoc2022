package org.lmarek.aoc.day3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

record Item(char symbol) {
  static final Map<Character, Integer> PRIORITIES;

  static {
    HashMap<Character, Integer> priorities = initializeSymbolPriorities();
    PRIORITIES = Collections.unmodifiableMap(priorities);
  }

  Item {
    if (!PRIORITIES.containsKey(symbol)) {
      throw new IllegalArgumentException("Unsupported symbol for Item: " + symbol);
    }
  }

  private static HashMap<Character, Integer> initializeSymbolPriorities() {
    var priorities = new HashMap<Character, Integer>();
    int priority = 1;
    for (char c = 'a'; c <= 'z'; c++) {
      priorities.put(c, priority);
      priority++;
    }
    for (char c = 'A'; c <= 'Z'; c++) {
      priorities.put(c, priority);
      priority++;
    }
    return priorities;
  }

  public int priority() {
    return PRIORITIES.get(symbol);
  }
}
