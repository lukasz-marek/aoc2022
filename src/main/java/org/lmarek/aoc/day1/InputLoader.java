package org.lmarek.aoc.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class InputLoader {
  public static final String RESOURCE_NAME = "day1.txt";

  private InputLoader() {}

  public static List<? extends Inventory> load() {
    try {
      var fileContent = loadFile();
      return parseFile(fileContent);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static List<? extends Inventory> parseFile(String content) {
    var inventories = content.trim().split("(\r\n\r\n)|(\n\n)");
    return Arrays.stream(inventories)
        .map(inventory -> inventory.split("\\s+"))
        .map(InputLoader::parseFoodItems)
        .map(items -> ImmutableInventory.builder().items(items.toList()).build())
        .toList();
  }

  private static Stream<ImmutableFoodItem> parseFoodItems(String[] items) {
    return Arrays.stream(items)
        .mapToLong(Long::parseLong)
        .mapToObj(calories -> ImmutableFoodItem.builder().calories(calories).build());
  }

  private static String loadFile() throws URISyntaxException, IOException {
    var inputPath = Path.of(InputLoader.class.getClassLoader().getResource(RESOURCE_NAME).toURI());
    return Files.readString(inputPath);
  }
}
