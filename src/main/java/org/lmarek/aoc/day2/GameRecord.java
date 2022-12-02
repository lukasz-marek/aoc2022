package org.lmarek.aoc.day2;

import java.util.List;
import org.immutables.value.Value;

@Value.Immutable
interface GameRecord {
  List<Round> rounds();

  @Value.Immutable
  interface Round {
    Shape playerMove();

    Shape opponentMove();
  }
}
