package com.stackroute.oops;

/*
   This class is used to store account details
 */
public class Account {

  int accountNo;
  double balance;
  String status;
  static int counter;

  public Account(double balance, String status) {
    counter += 1;
    accountNo = counter;
    this.balance = balance;
    this.status = status;
  }

  public boolean depositAmount(double amount) {
    if (status.equalsIgnoreCase("active")) {
      balance += amount;
      return true;
    }
    return false;
  }

  public String getAccountDetails() {
    return new String(
      "[Account No : " +
      accountNo +
      ", Status : " +
      status +
      ", Balance : " +
      balance +
      "]"
    );
  }

  public static int getCounter() {
    return counter;
  }

  public static void setCounter(int count) {
    counter = count;
  }

  public int getAccountNo() {
    return accountNo;
  }

  public double getBalance() {
    return balance;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
