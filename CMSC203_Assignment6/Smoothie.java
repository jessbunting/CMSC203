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
 * This class represents a Smoothie drink from the beverage shop, a specific type of Beverage that inherits from the Beverage class.
 * @author Jessica Bunting
 * @version 1, 05/03/2021
 */
public class Smoothie extends Beverage {
	/** Number of fruits in the Smoothie */
	private int numOfFruits;
	/** Protein powder added status of the Smoothie */
	private boolean hasProteinPowder;
	/** The Smoothie price increase for adding each additional fruit */
	private static final double PER_FRUIT_SURCHARGE = 0.5;
	/** The Smoothie price increase for adding protein powder */
	private static final double PROTEIN_POWDER_SURCHARGE = 1.5;
	
	/**
	 * Parameterized constructor to create a Coffee object given its name, size, 
	 * number of fruits added, and protein powder added status.
	 * @param bevName The Smoothie name
	 * @param size The Smoothie size
	 * @param numOfFruits Number of fruits in the Smoothie
	 * @param hasProteinPowder Protein powder added status of the Smoothie
	 */
	public Smoothie(String bevName, SIZE size, int numOfFruits, boolean hasProteinPowder) {
		super(bevName, TYPE.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.hasProteinPowder = hasProteinPowder;
	}
	
	/**
	 * String representation of a Smoothie drink including the name, size, whether or not protein is added, number of fruits, and the price of the Smoothie.
	 * @return The string representation of information of this Smoothie
	 */
	@Override
	public String toString() {
		return super.toString() + ", Has Protein Powder: " + this.hasProteinPowder + ", Number of Fruits: " + this.numOfFruits + ", Price: " + this.calcPrice();
		
	}
	
	/**
	 * Calculates and returns the Smoothie price
	 * @return the Smoothie price
	 */
	@Override
	public double calcPrice() {
		double smoothiePrice = getBasePrice();
		smoothiePrice += (numOfFruits * PER_FRUIT_SURCHARGE);

		if(hasProteinPowder) {
			smoothiePrice += PROTEIN_POWDER_SURCHARGE;
		}
		switch (getSize()) {
		case SMALL :
			break;
		case MEDIUM :
			smoothiePrice += getSizeIncreasePrice();
			break;
		case LARGE :
			smoothiePrice += (2 * getSizeIncreasePrice());
			break;
		}
		return smoothiePrice;
	}
	
	/**
	 * Checks equality based on the Beverage class equals method and additional instance variables for this class.
	 * @return true if the Smoothie objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
	    if (!(obj instanceof Smoothie)) {
	    	return false;
	    }
	    Smoothie sm = (Smoothie) obj;
		if (super.equals(sm) && (numOfFruits == sm.numOfFruits) && (hasProteinPowder == sm.hasProteinPowder)) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Return the number of fruits in the Smoothie
	 * @return the number of fruits
	 */
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	/**
	 * Return the protein powder added status of the Smoothie
	 * @return the protein powder status of the Smoothie, true if there is protein powder, false otherwise
	 */
	public boolean getAddProtien() {
		return hasProteinPowder;
	}
}