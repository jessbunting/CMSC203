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
 * This class is an abstract class that holds general data about a beverage that can be ordered from the beverage shop.
 * Classes representing the specific types of beverages available should inherit from this class.
 * @author Jessica Bunting
 * @version 1, 05/05/2021
 */
public abstract class Beverage {
	/** The beverage name */
	private String bevName;
	/** The beverage type */
	private TYPE type;
	/** The beverage size */
	private SIZE size;
	/** The beverage base price ($2.0) */
	private static final double BASE_PRICE = 2.0;
	/** The beverage price increase for each size increase of the beverage ($1.0 per size increase) */
	private static final double SIZE_INCREASE_PRICE = 1.0;
	
	/**
	 * Parameterized constructor to create a Beverage object given its name, type, and size
	 * @param bevName The beverage name
	 * @param type The beverage type
	 * @param size The beverage size
	 */
	public Beverage(String bevName, TYPE type, SIZE size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	/**
	 * Copy Constructor creates a Beverage object using another Beverage object.
	 * @param bev Another beverage ordered at the beverage shop
	 */
	public Beverage(Beverage bev) {
		this.bevName = bev.bevName;
		this.type = bev.type;
		this.size = bev.size;
	}
	/**
	 * Abstract method that calculates and returns the beverage price
	 * @return the beverage price
	 */
	public abstract double calcPrice();
	
	/**
	 * Displays the full information for the Beverage
	 * @return The string representation of information of this Beverage.
	 */
	@Override
	public String toString() {
		return "Name: " + this.bevName + ", Size: " + this.size;
	}
	/**
	 * Checks for equality based on name, type, size of the beverage
	 * @return true if the Beverages are equal, false otherwise
	 */
	// Overridden equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		// If obj is not an instance of the Beverage class return false
	    if (!(obj instanceof Beverage)) {
	    	return false;
	    }
	    Beverage bev = (Beverage) obj;
		// Otherwise check for equality of bevName, type, and size
	    return (bevName.equals(bev.bevName) && type.equals(bev.type) && size.equals(bev.size));

	}
	/**
	 * Return the name of the beverage ordered
	 * @return the beverage name
	 */
	public String getBevName() {
		return bevName;
	}
	/**
	 * Return the type of the beverage ordered
	 * @return the beverage type
	 */
	public TYPE getType() {
		return type;
	}
	/**
	 * Return the size of the beverage ordered
	 * @return the beverage size
	 */
	public SIZE getSize() {
		return size;
	}
	/**
	 * Return the base price of the beverage
	 * @return the beverage base price, BASE_PRICE
	 */
	public double getBasePrice() {
		return BASE_PRICE;
	}
	/**
	 * Return the price increase for each size increase of the beverage
	 * @return the beverage size increase price, SIZE_INCREASE_PRICE
	 */
	public static double getSizeIncreasePrice() {
		return SIZE_INCREASE_PRICE;
	}
	/**
	 * Set the beverage name
	 * @param bevName the name to set
	 */
	public void setBevName(String bevName) {
		this.bevName = bevName;
	}
	
	/**
	 * Set the beverage type
	 * @param type the beverage TYPE to set
	 */
	public void setType(TYPE type) {
		this.type = type;
	}
	/**
	 * Set the beverage size
	 * @param size the beverage SIZE to set
	 */
	public void setSize(SIZE size) {
		this.size = size;
	}
}
