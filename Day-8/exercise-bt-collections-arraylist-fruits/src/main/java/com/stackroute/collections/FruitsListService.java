package com.stackroute.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * This class contains methods for adding Fruits to a List and searching the fruits from the List
 */
public class FruitsListService {

  public static List<String> addFruitsToList(String fruitNames) {
    List<String> fruits = new ArrayList<>();
    if (fruitNames == null || fruitNames.isBlank()) {
      return fruits;
    }
    System.out.println(fruitNames);
    String[] fruitsArray = fruitNames.split(",");
    for (String s : fruitsArray) {
      if (searchFruitInListIgnoreCase(fruits, s) == -1) {
        fruits.add(s);
      }
    }
    return fruits;
  }

  public static int searchFruitInList(
    List<String> fruitList,
    String searchFruit
  ) {
    return fruitList.indexOf(searchFruit);
  }

  public static int searchFruitInListIgnoreCase(
    List<String> fruitList,
    String searchFruit
  ) {
    for (int i = 0; i < fruitList.size(); i++) {
      if (fruitList.get(i).equalsIgnoreCase(searchFruit)) {
        return i;
      }
    }
    return -1;
  }
}
