package com.stackroute.lambdaexpression;

import java.util.List;
//import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AlphabetChecker {

  //write logic to find whether given string contains only alphabets or not
  public String checkAlphabets(List<String> inputList) {
    int size = inputList.size();

    if (inputList == null || inputList.isEmpty()) {
      return "Give proper input not empty list";
    }
    inputList =
      inputList
        .stream()
        .filter(s -> s.matches("^[a-zA-Z]*$"))
        .collect(Collectors.toList());

    if (inputList.size() == size) {
      return "Given list contains only alphabet strings";
    }

    return "Given list contains non alphabet strings";
  }
}
