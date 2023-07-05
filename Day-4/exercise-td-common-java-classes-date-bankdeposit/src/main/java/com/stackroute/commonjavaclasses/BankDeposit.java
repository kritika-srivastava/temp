package com.stackroute.commonjavaclasses;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BankDeposit {

  String investmentDate;
  String maturityDate;

  public String getMaturityDate(String investmentDate, Period duration) {
    if (duration == null) {
      return "Give proper input not null";
    }
    if (duration.isNegative()) {
      return "Give proper duration not negative value";
    }
    if (investmentDate == null) {
      return "Give proper input not null";
    }
    if (investmentDate.isEmpty()) {
      return "Give proper input not empty investment date";
    }
    this.investmentDate = investmentDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate date = LocalDate.parse(this.investmentDate, formatter);
    date = date.plus(duration);

    return formatter.format(date);
  }

  public String getInvestmentDuration(
    String investmentDate,
    String maturityDate
  ) {
    this.investmentDate = investmentDate;
    this.maturityDate = maturityDate;
    if (this.investmentDate == null || this.maturityDate == null) {
      return "Give proper input not null";
    }
    if (this.investmentDate.isEmpty()) {
      return "Give proper input not empty value";
    }
    if (investmentDate.compareTo(maturityDate) > 0) {
      return "Give proper maturity date greater than investment date";
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate investment = LocalDate.parse(this.investmentDate, formatter);
    LocalDate maturity = LocalDate.parse(this.maturityDate, formatter);

    return Period.between(investment, maturity).toString();
  }
}
