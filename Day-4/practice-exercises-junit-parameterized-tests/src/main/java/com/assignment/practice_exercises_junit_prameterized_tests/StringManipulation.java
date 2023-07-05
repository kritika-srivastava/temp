package com.assignment.practice_exercises_junit_prameterized_tests;

public class StringManipulation {

  StringManipulation() {}

  int vowelCount(String name) {
    int ret = 0;
    if (name == null) {
      return ret;
    }
    for (int i = 0; i < name.length(); i++) {
      char ch = Character.toLowerCase(name.charAt(i));
      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        ret++;
      }
    }
    return ret;
  }

  int characterCount(String str) {
    if (str == null) {
      return 0;
    }
    return str.length();
  }
}
