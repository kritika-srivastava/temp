package com.stackroute.exercises;

import java.util.Collections;
import java.util.List;

public class StringSort {

  //write here logic to sort a string List
  public String stringSorter(List<String> stringList, String sortingOrder) {
    if (
      sortingOrder == null ||
      sortingOrder.isBlank() ||
      stringList == null ||
      stringList.size() == 0
    ) {
      return "Given stringList or sortingOrder is empty, null or blank space";
    }

    if (
      !sortingOrder.equalsIgnoreCase("asc") &&
      !sortingOrder.equalsIgnoreCase("desc")
    ) {
      return (
        "No sorting order present for given string '" +
        sortingOrder +
        "' , 'asc' for ascending order sort and 'desc' for descending order sort"
      );
    }

    for (String s : stringList) {
      if (s == null || s.isBlank()) {
        return "The list contains an empty or blank space value";
      }
    }

    if (stringList.size() == 1) {
      return "The list contains only one value";
    }
    if (sortingOrder.equalsIgnoreCase("asc")) {
      Collections.sort(
        stringList,
        (str1, str2) ->
          (str1.compareTo(str2) < 0) ? -1 : ((str1.compareTo(str2) > 0) ? 1 : 0)
      );
    } else {
      Collections.sort(
        stringList,
        (str1, str2) ->
          (str1.compareTo(str2) < 0) ? 1 : ((str1.compareTo(str2) > 0) ? -1 : 0)
      );
    }
    return stringList.toString();
  }
}
