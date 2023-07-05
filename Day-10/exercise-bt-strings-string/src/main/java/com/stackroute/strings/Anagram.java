package com.stackroute.strings;

import java.util.Arrays;

public class Anagram {

  //write logic to check given two phrases are anagrams or not and return result
  public String checkAnagrams(String phraseOne, String phraseTwo) {
    if (
      phraseOne == null ||
      phraseTwo == null ||
      phraseOne.isBlank() ||
      phraseTwo.isBlank()
    ) {
      return "Give proper input not empty phrases";
    }

    char[] phr1 = phraseOne.toCharArray();
    Arrays.sort(phr1);
    char[] phr2 = phraseTwo.toCharArray();
    Arrays.sort(phr2);

    phraseTwo = new String(phr1);
    phraseOne = new String(phr2);

    if (phraseOne.equals(phraseTwo)) {
      return "Given phrases are anagrams";
    }
    return "Given phrases are not anagrams";
  }
}
