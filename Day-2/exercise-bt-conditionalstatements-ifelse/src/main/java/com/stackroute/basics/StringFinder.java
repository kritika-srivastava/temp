package com.stackroute.basics;

import java.util.Scanner;

public class StringFinder {

  Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    new StringFinder().getInput();
  }

  public String getInput() {

    String str = scan.nextLine();
    String str1 = scan.nextLine();
    String str2 = scan.nextLine();

    int result = new StringFinder().findString(str, str1, str2);
    new StringFinder().displayResult(result);

    return null;
  }

  public void displayResult(int result) {
    switch (result) {
      case -1:
        System.out.println("Empty string or null");
        break;
      case 0:
        System.out.println("Not found");
        break;
      case 1:
        System.out.println("Found as expected");
        break;
    }
  }

  public int findString(
    String searchString,
    String firstString,
    String secondString
  ) {
    if (
      (searchString==null || firstString==null || secondString ==null)||(searchString.length()==0 || firstString.length()==0 || secondString.length()==0
   ) ) {
      return -1;
    } else {
      if (
        searchString.indexOf(firstString) >= 0 &&
        searchString.indexOf(secondString) >= 0
      ) {
        if (
          searchString.indexOf(firstString) < searchString.indexOf(secondString)
        ) {
          return 1;
        }
      }
    }
    return 0;
  }

  public void closeScanner() {
    scan.close();
  }
}
