package org.lmarek.aoc.day4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

final class InputLoader {
  private static final String RESOURCE_NAME = "day4.txt";

  private InputLoader() {}

  public static List<Assignment> load() {
    try {
      var data = loadFile();
      return parseInput(data);
    } catch (URISyntaxException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static List<Assignment> parseInput(String input) {
    return input
        .trim()
        .lines()
        .map(line -> line.split(","))
        .map(parts -> Arrays.stream(parts).map(part -> part.split("-")).toList())
        .map(ranges -> new Assignment(buildRange(ranges.get(0)), buildRange(ranges.get(1))))
        .toList();
  }

  private static Range buildRange(String[] rawNumbers) {
    return new Range(Integer.parseInt(rawNumbers[0]), Integer.parseInt(rawNumbers[1]));
  }

  private static String loadFile() throws URISyntaxException, IOException {
    var inputPath = Path.of(InputLoader.class.getClassLoader().getResource(RESOURCE_NAME).toURI());
    return Files.readString(inputPath);
  }
}
