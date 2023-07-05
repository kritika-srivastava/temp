package com.stackroute.commonjavaclasses;

public class WrapperClassConvert {

  //write logic to determine and convert given primitive type to its wrapper class and return result
  public Object convertToWrapper(Object input) {
    if (input != null) {
      if (input.getClass() == Integer.class) {
        return (Integer) input;
      } else if (input.getClass() == Byte.class) {
        return (Byte) input;
      } else if (input.getClass() == Short.class) {
        return (Short) input;
      } else if (input.getClass() == Long.class) {
        return (Long) input;
      } else if (input.getClass() == Float.class) {
        return (Float) input;
      } else if (input.getClass() == Double.class) {
        return (Double) input;
      } else if (input.getClass() == Boolean.class) {
        return (Boolean) input;
      } else if (input.getClass() == Character.class) {
        return (Character) input;
      }
    }
    return "Give proper primitive type as input";
  }
}
