package com.stackroute.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringFormat {

  //write logic to find the format for given list and return result
  public String findStringFormat(List<Integer> input) {
    if (input == null || input.size() == 0) {
      return "Give proper input not empty list";
    }

    Stream<Integer> stream = input.stream();
    boolean positiveIntegers = stream.allMatch(i -> i >= 0);

    if (!positiveIntegers) {
      return "Give proper input not negative values";
    }

    String string = "";
    for (int i : input) {
      string =
        string.concat(
          (
            isEven(i) == true
              ? "even" + Integer.toString(i)
              : "odd" + Integer.toString(i)
          ) +
          ","
        );
    }
    string = string.substring(0, string.length() - 1);

    return string;
  }

  public boolean isEven(int i) {
    if (i % 2 == 0) {
      return true;
    }
    return false;
  }
}
