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
 * This class represents an Alcohol drink from the beverage shop, a specific type of Beverage that inherits from the Beverage class.
 * @author Jessica Bunting
 * @version 1, 05/03/2021
 */
public class Alcohol extends Beverage {
	/** Status of whether the Alcohol beverage is offered on the weekend */
	private boolean offeredOnWeekend;
	/** The Alcohol price increase for offering on the weekend */
	private static final double WEEKEND_SURCHARGE = 0.6;
	
	/**
	 * Parameterized constructor to create a Coffee object given its name, size, and offered on weekend status.
	 * @param bevName The Alcohol name
	 * @param size The Alcohol size
	 * @param offeredOnWeekend Status of whether the Alcohol beverage is offered on the weekend
	 */
	public Alcohol(String bevName, SIZE size, boolean offeredOnWeekend) {
		super(bevName, TYPE.ALCOHOL, size);
		this.offeredOnWeekend = offeredOnWeekend;
	}
	
	/**
	 * String representation of Alcohol drink including the name, size, whether or not beverage is offered in the weekend and the price.
	 * @return The string representation of information of this Alcohol.
	 */
	@Override
	public String toString() {
		return super.toString() + ", Offered On Weekend: " + this.offeredOnWeekend + ", Price: " + this.calcPrice();
		
	}
	
	/**
	 * Calculates and returns the Alcohol price
	 * @return the Alcohol price
	 */
	@Override
	public double calcPrice() {
		double alcoholPrice = getBasePrice();

		if(offeredOnWeekend) {
			alcoholPrice += WEEKEND_SURCHARGE;
		}
		switch (getSize()) {
		case SMALL :
			break;
		case MEDIUM :
			alcoholPrice += getSizeIncreasePrice();
			break;
		case LARGE :
			alcoholPrice += (2 * getSizeIncreasePrice());
			break;
		}
		return alcoholPrice;
	}
	
	/**
	 * Checks equality based on the Beverage class equals method and additional instance variables for this class.
	 * @return true if the Alcohol objects are equal, false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
	    if (!(obj instanceof Alcohol)) {
	    	return false;
	    }
	    Alcohol alc = (Alcohol) obj;
		if (super.equals(alc) && (offeredOnWeekend == alc.offeredOnWeekend)) {
			return true;
		}
		else {
			return false;
		}
	}

}