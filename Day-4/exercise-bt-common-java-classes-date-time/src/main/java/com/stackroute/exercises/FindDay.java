package com.stackroute.exercises;

import java.time.LocalDate;
public class FindDay {

  //write logic to find day of the date and return result
  public String findDay(int month, int day, int year) {
    boolean flag = false;
    String findday = "";
    
    if (month < 1 || month > 12) {
      flag = true;
      findday += "Give month in range";
    }
    if (day < 1 || day > 31) {
      flag = true;
      findday += "Give day in range";
    }
    if (year < 2000 || year > 3000) {
      flag = true;
      findday += "Give year in range";
    }

    if (!flag) {
    	LocalDate localDate = LocalDate.of(year, month, day);
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        findday+= dayOfWeek.toString().toUpperCase();
        
    }
    return findday;
  }
}
