package com.stackroute.exception;

public class Account {
	double balance;

	public Account() {
		balance = 0;
	}

	public Account(double balance) {
		this.balance = balance;
	}

	public double getAccountBalance() {
		return balance;
	}

	public double withdraw(double amount) throws InsufficientFundException, NegativeIntegerException {
		if (amount > balance) {
			throw new InsufficientFundException("InsufficientFundException");
		}
		if (amount < 0) {
			throw new NegativeIntegerException("NegativeIntegerException");
		}
		balance -= amount;
		return balance;
	}
}
