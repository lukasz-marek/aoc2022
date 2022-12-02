package org.lmarek.aoc.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public final class InputLoader {
  public static final String RESOURCE_NAME = "day2.txt";

  private static final Map<String, Shape> CONVERSIONS =
      Map.of(
          "A", Shape.ROCK,
          "X", Shape.ROCK,
          "B", Shape.PAPER,
          "Y", Shape.PAPER,
          "C", Shape.SCISSORS,
          "Z", Shape.SCISSORS);

  private InputLoader() {}

  public static GameRecord load() {
    try {
      var fileContent = loadFile();
      return parseFile(fileContent);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static GameRecord parseFile(String data) {
    var rounds =
        data.lines()
            .map(String::trim)
            .map(line -> line.split(" "))
            .map(InputLoader::buildRound)
            .toList();
    return ImmutableGameRecord.builder().rounds(rounds).build();
  }

  private static ImmutableRound buildRound(String[] parts) {
    var opponent = CONVERSIONS.get(parts[0]);
    var player = CONVERSIONS.get(parts[1]);
    return ImmutableRound.builder().opponentMove(opponent).playerMove(player).build();
  }

  private static String loadFile() throws URISyntaxException, IOException {
    var inputPath = Path.of(InputLoader.class.getClassLoader().getResource(RESOURCE_NAME).toURI());
    return Files.readString(inputPath);
  }
}
