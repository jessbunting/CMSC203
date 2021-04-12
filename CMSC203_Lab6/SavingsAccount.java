/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Due: 04/11/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Jessica Bunting
*/
/**Defines a savings account type of bank account*/
public class SavingsAccount extends BankAccount {
	private double rate = 2.5;
	private int savingsNumber = 0;
	private String accountNumber;
	/**
	 * Constructor that takes a name and initial amount as parameters and calls the superclass constructor
	 * @param name the bank account owner name
	 * @param amount an initial balance
	 */
	SavingsAccount(String name, double amount) {
		super(name, amount);
		this.accountNumber = super.getAccountNumber().concat("-".concat(Integer.toString(this.savingsNumber)));
	}
	/**
	 * Copy constructor
	 * @param oldAccount the original savings account
	 * @param amount an initial balance
	 */
	SavingsAccount(SavingsAccount oldAccount, double amount) {
		super(oldAccount, amount);
		this.rate = oldAccount.rate;
		this.savingsNumber = oldAccount.savingsNumber + 1;
		this.accountNumber = super.getAccountNumber().concat("–".concat(Integer.toString(this.savingsNumber)));
	}
	/**
	 * Method to calculate one month worth of interest on the balance and deposit it into the account
	 */
	public void postInterest() {
		deposit(((rate / 100) * getBalance()) / 12);
	}
	/**
	 * Instance method getAccountNumber to override the superclass getAccountNumber method
	 * @return the account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
}
