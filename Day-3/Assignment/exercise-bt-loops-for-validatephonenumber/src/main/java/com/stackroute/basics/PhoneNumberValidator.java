package com.stackroute.basics;

import java.util.Scanner;
import java.util.regex.*;

public class PhoneNumberValidator {

  Scanner kb;

  public static void main(String[] args) {
    //call the functions in the required sequence
    new PhoneNumberValidator().getInput();
  }

  public String getInput() {
    kb = new Scanner(System.in);
    String str = kb.nextLine();

    int result = new PhoneNumberValidator().validatePhoneNumber(str);

    new PhoneNumberValidator().displayResult(result);

    if (result == -1) {
      return "Empty string";
    } else if (result == 1) {
      return "Valid";
    }
    return "Invalid";
  }

  public void displayResult(int result) {
    if (result == -1) {
      System.out.println("Empty string");
    } else if (result == 1) {
      System.out.println("Valid");
    } else {
      System.out.println("Invalid");
    }
  }

  public int validatePhoneNumber(String input) {
    if (input == null || input.isEmpty()) {
      return -1;
    }
    if (
      Pattern.matches("[0-9]{2}[-]*[0-9]{3}[-]*[0-9]{5}", input) ||
      Pattern.matches("[0-9]{3}[-]*[0-9]{2}[-]*[0-9]{5}", input)
    ) {
      return 1;
    }

    return 0;
  }

  public void closeScanner() {
    kb.close();
  }
}
