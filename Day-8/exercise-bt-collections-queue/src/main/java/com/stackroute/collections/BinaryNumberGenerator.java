package com.stackroute.collections;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberGenerator {

  //write logic to find binary number from 1 to given input
  public String findBinaryNumbersSequence(int input) {
    if (input <= 0) {
      return "Give proper input not zero or negative";
    }

    if (input > 20) {
      return "Give proper input not greater than 20";
    }

    String binary = "";
    Queue<String> q = new LinkedList<>();
    q.add("1");
    for (int i = 1; i <= input; i++) {
      q.add(q.peek() + "0");
      q.add(q.peek() + "1");
      binary += q.poll() + " ";
    }

    return binary.trim();
  }
}
