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
 * This class represents a Coffee drink from the beverage shop, a specific type of Beverage that inherits from the Beverage class.
 * @author Jessica Bunting
 * @version 1, 05/03/2021
 */
public class Coffee extends Beverage {
	/** Extra shot status of the Coffee */
	private boolean hasExtraShot;
	/** Extra syrup status of the Coffee */
	private boolean hasExtraSyrup;
	/** The Coffee price increase for adding an extra shot or extra syrup */
	private static final double SHOT_OR_SYRUP_SURCHARGE = 0.5;
	
	/**
	 * Parameterized constructor to create a Coffee object given its name, size, extra shot status, and extra syrup status.
	 * @param bevName The Coffee name
	 * @param size The Coffee size
	 * @param hasExtraShot Extra shot status of the Coffee
	 * @param hasExtraSyrup Extra syrup status of the Coffee
	 */
	public Coffee(String bevName, SIZE size, boolean hasExtraShot, boolean hasExtraSyrup) {
		super(bevName, TYPE.COFFEE, size);
		this.hasExtraShot = hasExtraShot;
		this.hasExtraSyrup = hasExtraSyrup;
	}
	
	/**
	 * String representation of Coffee beverage, including the name, size, whether it contains extra shot, extra syrup, and the price of the coffee.
	 * @return The string representation of information of this Coffee.
	 */
	@Override
	public String toString() {
		return super.toString() + ", Has Extra Shot: " + this.hasExtraShot + ", Has Extra Syrup: " + this.hasExtraSyrup + ", Price: " + this.calcPrice();
	}
	
	/**
	 * Calculates and returns the Coffee price
	 * @return the Coffee price
	 */
	@Override
	public double calcPrice() {
		double cofPrice = getBasePrice();
		if(hasExtraShot) {
			cofPrice += SHOT_OR_SYRUP_SURCHARGE;
		}
		if(hasExtraSyrup) {
			cofPrice += SHOT_OR_SYRUP_SURCHARGE;
		}
		switch (getSize()) {
		case SMALL :
			break;
		case MEDIUM :
			cofPrice += getSizeIncreasePrice();
			break;
		case LARGE :
			cofPrice += (2 * getSizeIncreasePrice());
			break;
		}
		return cofPrice;
	}
	
	/**
	 * Checks equality based on the Beverage class equals method and additional instance variables for this class.
	 * @return true if the Coffee objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
	    if (!(obj instanceof Coffee)) {
	    	return false;
	    }
	    Coffee cof = (Coffee) obj;
		if (super.equals(cof) && (hasExtraShot == cof.hasExtraShot) && (hasExtraSyrup == cof.hasExtraSyrup)) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Return the extra shot status of the Coffee
	 * @return the extra shot status of the Coffee, true if there is an extra shot, false otherwise
	 */
	public boolean getExtraShot() {
		return hasExtraShot;
	}
	
	/**
	 * Return the extra syrup status of the Coffee
	 * @return the extra shot status of the Coffee, true if there is extra syrup, false otherwise
	 */
	public boolean getExtraSyrup() {
		return hasExtraSyrup;
	}
}
