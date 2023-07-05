package com.stackroute.oops;

/*
	This class is used to create account object and execute methods on account objects
 */
public class AccountService {

  /*
   * This method creates and returns an account object based on the parameters supplied
   */
  public Account createAccount(double balance, String status) {
    return new Account(balance, status);
  }

  /*
   * This method deposits the parameter amount in the account passed as parameter
   */
  public boolean depositAmountInAccount(Account account, double amount) {
    boolean ret = account.depositAmount(amount);
    return ret;
  }

  /*
   * This method gets the account details for the  account passed as parameter
   */
  public String getAccountDetails(Account account) {
    return account.getAccountDetails();
  }
}
