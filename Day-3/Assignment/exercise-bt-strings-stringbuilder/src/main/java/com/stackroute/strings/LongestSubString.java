package com.stackroute.strings;

public class LongestSubString {

  //write logic to find the longest substring that appears at both ends of a given string and return result
  public StringBuilder findLongestSubString(StringBuilder input) {
    if (input.length() == 0) {
      return new StringBuilder("Give proper input");
    }
    String a = "";
    for (int i = 0; i <= input.length() / 2; i++) {
      //System.out.println(input.substring(0,i+1)+" "+input.substring(input.length()-1-i));
      if (
        input
          .substring(0, i + 1)
          .equals(input.substring(input.length() - 1 - i))
      ) {
        a = input.substring(0, i + 1);
      } else {}
    }
    if (a == "") {
      return new StringBuilder(
        "Longest substring is not present in the given StringBuilder"
      );
    }

    return new StringBuilder(a);
  }
}
