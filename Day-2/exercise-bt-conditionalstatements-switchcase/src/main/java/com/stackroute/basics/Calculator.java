package com.stackroute.basics;

import java.util.Scanner;

public class Calculator {

  private static Scanner scan;
  static boolean flag = true;

  // define,declare scanner and call getValues with scanner as parameter
  public static void main(String[] args) {
    scan = new Scanner(System.in);
    new Calculator().getValues(scan);
  }

  //Get values and which operator from the menu
  public void getValues(Scanner scan) {
    while (true) {
      System.out.println("Enter the first number:");
      int n1 = Integer.parseInt(scan.nextLine());
      System.out.println("Enter the second number:");
      int n2 = Integer.parseInt(scan.nextLine());
      System.out.println(
        "Enter number beside the operation to perform:" +
        "\n" +
        "1. Add" +
        "\n" +
        "2. Subtract" +
        "\n" +
        "3. Multiply" +
        "\n" +
        "4. Divide"
      );

      int opt = Integer.parseInt(scan.nextLine());

      new Calculator().calculate(n1, n2, opt);
      if (!flag) {
        flag = true;
        break;
      }
      System.out.println("Do you want to try again(y/n)");
      String ch = scan.nextLine();

      if (ch.equals("n")) {
        break;
      }
    }
  }

  //perform operation based on the chosen switch case corresponding to the menu and return string
  public String calculate(int firstValue, int secondValue, int operator) {
    String s = "";
    switch (operator) {
      case 1:
        {
          s =
            firstValue +
            " + " +
            secondValue +
            " = " +
            (firstValue + secondValue);
          System.out.println(s);
          break;
        }
      case 2:
        {
          s =
            firstValue +
            " - " +
            secondValue +
            " = " +
            (firstValue - secondValue);
          System.out.println(s);
          break;
        }
      case 3:
        {
          s =
            firstValue +
            " * " +
            secondValue +
            " = " +
            (firstValue * secondValue);
          System.out.println(s);
          break;
        }
      case 4:
        {
          if (secondValue == 0) {
            flag = false;
            s = "The divider (secondValue) cannot be zero";
            System.out.println(s);
          } else {
            s =
              firstValue +
              " / " +
              secondValue +
              " = " +
              (firstValue / secondValue);
            System.out.println(s);
          }

          break;
        }
      default:
        {
          flag = false;
          s = "Entered wrong option " + operator;
          System.out.println(s);
        }
    }
    return s;
  }
}
