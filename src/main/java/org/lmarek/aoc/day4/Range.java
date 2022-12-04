package org.lmarek.aoc.day4;

record Range(int startInclusive, int endInclusive) {
  Range {
    if (startInclusive > endInclusive) {
      throw new IllegalArgumentException(
          "Start must be less or equal to end, but got " + startInclusive + ", " + endInclusive);
    }
  }

  boolean fullyContains(Range another) {
    return this.startInclusive <= another.startInclusive
        && this.endInclusive >= another.endInclusive;
  }

  boolean overlaps(Range another) {
    return this.startInclusive <= another.endInclusive
        && another.startInclusive <= this.endInclusive;
  }
}
