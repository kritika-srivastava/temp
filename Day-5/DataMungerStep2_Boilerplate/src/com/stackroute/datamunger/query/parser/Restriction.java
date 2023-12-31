package com.stackroute.datamunger.query.parser;

/*
 * This class is used for storing name of field, condition and value for
 * each conditions
 * generate getter and setter for this class,
 * Also override toString method
 * */

public class Restriction {

  // Write logic for constructor
  String name, value, condition;

  public Restriction(String name, String value, String condition) {
    this.name = name;
    this.value = value;
    this.condition = condition;
  }

  public String toString() {
    return name + " " + value + " " + condition;
  }
}
