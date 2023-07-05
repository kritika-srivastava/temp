package com.stackroute.datamunger.query;

//header class
public class Header {

  /*
   * this class should contain a member variable which is a String array, to hold
   * the headers and should override toString() method.
   */
  String[] header;

  public Header() {
    header = null;
  }

  public Header(String header) {
    this.header = header.split(",");
  }

  public String[] getHeaders() {
    return header;
  }
}
