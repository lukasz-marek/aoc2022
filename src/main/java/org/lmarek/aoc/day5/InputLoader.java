package org.lmarek.aoc.day5;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class InputLoader {
  private static final String STACKS_RESOURCE_NAME = "day5_stacks.txt";

  public static Ship loadCrates() {
    try {
      var rawData = loadFile(STACKS_RESOURCE_NAME);
      return buildShip(transpose(toChars(rawData)));
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static Ship buildShip(char[][] transposedInput) {
    var stacks =
        Arrays.stream(transposedInput)
            .map(InputLoader::parseCrate)
            .filter(crates -> !crates.isEmpty())
            .map(CargoStack::new)
            .toList();
    return new Ship(stacks);
  }

  private static String loadFile(String fileName) throws URISyntaxException, IOException {
    var inputPath = Path.of(InputLoader.class.getClassLoader().getResource(fileName).toURI());
    return Files.readString(inputPath);
  }

  private static char[][] transpose(char[][] chars) {
    var result = new char[calculateSize(chars)][];
    for (var i = 0; i < result.length; i++) {
      result[i] = new char[chars.length];
    }
    for (var i = 0; i < chars.length; i++) {
      for (var j = 0; j < chars[i].length; j++) {
        result[j][chars.length - 1 - i] = chars[i][j];
      }
    }
    return result;
  }

  private static List<Crate> parseCrate(char[] chars) {
    if (Character.isDigit(chars[0])) {
      var results = new ArrayList<Crate>();
      for (var i = 1; i < chars.length; i++) {
        if (Character.isAlphabetic(chars[i])) {
          results.add(new Crate(Character.toString(chars[i])));
        }
      }
      Collections.reverse(results);
      return results;
    } else {
      return Collections.emptyList();
    }
  }

  private static int calculateSize(char[][] chars) {
    int max = 0;
    for (var line : chars) {
      max = Math.max(max, line.length);
    }
    return max;
  }

  private static char[][] toChars(String stacks) {
    return stacks.lines().map(String::toCharArray).toArray(char[][]::new);
  }
}
