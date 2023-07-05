package com.stackroute.basics;

import java.util.Scanner;

public class RectanglePerimeter {

  public static void main(String[] args) {
    new RectanglePerimeter().getValues();
  }

  //get user input from console
  public void getValues() {
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter length and breadth of the rectangle:");

    double l = kb.nextDouble();
    double b = kb.nextDouble();
    RectanglePerimeter ob = new RectanglePerimeter();
    ob.perimeterCalculator(l, b);
    kb.close();
  }

  //write logic to find perimeter of rectangle here
  public double perimeterCalculator(double length, double breadth) {
    System.out.println(2 * (length + breadth));
    return 2 * (length + breadth);
  }
}
