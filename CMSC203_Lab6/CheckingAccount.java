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
/**Defines a checking account type of bank account*/
public class CheckingAccount extends BankAccount {
	// The cost of clearing one check
	private final double FEE = 0.15;
	/**
	 * Constructor that takes a name and initial amount as parameters and calls the superclass constructor
	 * @param name the bank account owner name
	 * @param amount an initial balance
	 */
	CheckingAccount(String name, double amount) {
		super(name, amount);
		setAccountNumber(super.getAccountNumber().concat("–10"));
	}
	/**
	 * Instance method withdraw to override the superclass withdraw method
	 * @param amount the amount to withdraw
	 * @return true if there was sufficient funds to complete the transaction, false otherwise
	 */
	public boolean withdraw(double amount) {
		double amountPlusFee;
		// Take the amount to withdraw and add amount to the fee for check clearing
		amountPlusFee = amount + FEE;
		// Call the superclass withdraw method
		return super.withdraw(amountPlusFee);
	}
}
