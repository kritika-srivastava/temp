package com.stackroute.collections;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UniqueWordExtractor {

  Set<String> wordSet;

  public UniqueWordExtractor() {
    wordSet = new LinkedHashSet<>();
  }

  public Set<String> fetchUniqueWordsInOrder(
    String paragraph,
    SortOrder order
  ) {
    if (paragraph == null) {
      return wordSet;
    }
    List<String> words = new ArrayList<>();
    Pattern p = Pattern.compile("[a-zA-Z]+");

    Matcher m1 = p.matcher(paragraph);

    while (m1.find()) {
      words.add(m1.group());
    }

    if (order == SortOrder.INPUT_ORDER || order == null) {
      wordSet.addAll(words);
      return wordSet;
    } else if (order == SortOrder.LENGTH_THEN_ALPHABETIC_ASCENDING) {
      Set<String> treeSet = new TreeSet<String>(
        new Comparator<String>() {
          public int compare(String i1, String i2) {
            if (i1.length() == i2.length()) {
              return i1.compareTo(i2);
            } else if (i1.length() < i2.length()) {
              return -1;
            } else {
              return 1;
            }
          }
        }
      );
      treeSet.addAll(words);

      return treeSet;
    } else if (order == SortOrder.ALPHABETIC_ASCENDING) {
      Set<String> treeSet = new TreeSet<>();
      treeSet.addAll(words);
      return treeSet;
    } else if (order == SortOrder.ALPHABETIC_DESCENDING) {
      Set<String> treeSet = new TreeSet<String>(
        new Comparator<String>() {
          public int compare(String i1, String i2) {
            return i2.compareTo(i1);
          }
        }
      );
      treeSet.addAll(words);

      return treeSet;
    }

    return null;
  }
}
