package org.lmarek.aoc.day3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

final class InputLoader {
  private static final String RESOURCE_NAME = "day3.txt";

  private InputLoader() {}

  public static List<Rucksack> load() {
    try {
      var data = loadFile();
      return parseInput(data);
    } catch (URISyntaxException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static List<Rucksack> parseInput(String input) {
    return input
        .trim()
        .lines()
        .map(String::trim)
        .map(String::toCharArray)
        .map(InputLoader::buildRucksack)
        .toList();
  }

  private static Rucksack buildRucksack(char[] itemSymbols) {
    var items = new ArrayList<Item>();
    for (var symbol : itemSymbols) {
      items.add(new Item(symbol));
    }
    return new Rucksack(items);
  }

  private static String loadFile() throws URISyntaxException, IOException {
    var inputPath =
        Path.of(
            org.lmarek.aoc.day1.InputLoader.class
                .getClassLoader()
                .getResource(RESOURCE_NAME)
                .toURI());
    return Files.readString(inputPath);
  }
}
