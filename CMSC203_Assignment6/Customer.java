/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: A program that automates order transactions for a store that sells beverages. The program creates 
 * and processes orders of different types of beverages, provides information on all the orders. The program can 
 * report total amount on a specific order, monthly total number  of orders, and monthly total sales amount.
 * Due: 05/09/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Jessica Bunting
*/

/**
 * This class represents a customer who places an order from the beverage shop.
 * @author Jessica Bunting
 * @version 1, 05/06/2021
 */
public class Customer {
	/** The name of the customer */
	private String customerName;
	/** The age of the customer */
	private int customerAge;
	
	/**
	 * Constructor Creates a Customer object using the passed information.
	 * @param customerName Customer's name
	 * @param customerAge Customer's age
	 */
	public Customer(String customerName, int customerAge) {
		this.customerName = customerName;
		this.customerAge = customerAge;
	}
	
	/**
	 * Copy Constructor creates a Customer object using another Customer object.
	 * @param c Another customer at the beverage shop
	 */
	public Customer(Customer c) {
		this.customerName = c.customerName;
		this.customerAge = c.customerAge;
	}
	
	/**
	 * Displays the full information for the customer
	 * @return The string representation of information of this customer.
	 */
	@Override
	public String toString() {
		return "Customer Name: " + this.customerName + ", Customer Age: " + this.customerAge;
	}
	
	/**
	 * Return the customer's name
	 * @return the name of the customer
	 */
	public String getName() {
		return customerName;
	}
	
	/**
	 * Return the customer's age
	 * @return the age of the customer
	 */
	public int getAge() {
		return customerAge;
	}
	
	/**
	 * Set the customer's name
	 * @param customerName the name to set
	 */
	public void setName(String customerName) {
		this.customerName = customerName;
	}
	
	/**
	 * Set the customer's age
	 * @param customerAge the age to set
	 */
	public void setAge(int customerAge) {
		this.customerAge = customerAge;
	}
}
