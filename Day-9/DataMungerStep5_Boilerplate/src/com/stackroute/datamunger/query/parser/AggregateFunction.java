package com.stackroute.datamunger.query.parser;

/* This class is used for storing name of field, aggregate function for
 * each aggregate function
 * */
public class AggregateFunction {

  private String function = null;
  private String field = null;

  public AggregateFunction(String field, String function) {
    this.function = function;
    this.field = field;
  }

  public String getFunction() {
    return function;
  }

  public String getField() {
    return field;
  }
}
