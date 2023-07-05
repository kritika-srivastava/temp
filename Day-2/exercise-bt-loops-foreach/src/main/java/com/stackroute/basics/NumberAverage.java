package com.stackroute.basics;

import java.util.Scanner;

public class NumberAverage {

  public static void main(String[] args) {
    new NumberAverage().getArrayValues();
  }

  //get the values of the array from the user
  public void getArrayValues() {
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter number of values:");
    int n = kb.nextInt();
    int arr[] = new int[n];
    System.out.println("Enter the values:");

    for (int i = 0; i < n; i++) {
      arr[i] = kb.nextInt();
    }
    new NumberAverage().findAverage(arr);

    kb.close();
  }

  //write here logic to calculate the average an array
  public String findAverage(int[] inputArray) {
    if (inputArray.length == 0) {
      System.out.println("Empty array");
      return "Empty array";
    }
    else{}
    
    boolean flag = true;
    int sum = 0;
    for (int tmp : inputArray) {
      if (tmp >= 0) {
        sum += tmp;
      } else {
        flag = false;
        break;
      }
    }
    String s=null;
    int result = sum / inputArray.length;
    if (flag) {
    	s="The average value is: " + result;
      System.out.println(s);
    } else {
    	s="Give proper positive integer values";
      System.out.println(s);
    }
    return s;
  }
}
