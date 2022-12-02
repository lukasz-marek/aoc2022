package org.lmarek.aoc.day2;

import java.util.List;
import org.immutables.value.Value;

@Value.Immutable
interface CorrectedGameRecord {
  List<ExpectedRound> expectedRounds();

  @Value.Immutable
  interface ExpectedRound {
    Shape opponentMove();

    ExpectedEnd expectation();
  }
}
