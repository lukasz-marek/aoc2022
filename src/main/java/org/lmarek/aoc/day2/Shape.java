package org.lmarek.aoc.day2;

enum Shape {
  ROCK(1) {
    @Override
    public boolean isBeatenBy(Shape another) {
      return PAPER == another;
    }
  },
  PAPER(2) {
    @Override
    public boolean isBeatenBy(Shape another) {
      return SCISSORS == another;
    }
  },
  SCISSORS(3) {
    @Override
    public boolean isBeatenBy(Shape another) {
      return ROCK == another;
    }
  };

  private final long score;

  Shape(long score) {
    this.score = score;
  }

  public long getScore() {
    return score;
  }

  public abstract boolean isBeatenBy(Shape another);
}
