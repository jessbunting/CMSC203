/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: A program that lets the user create a management company that manages individual properties they will build 
 * to rent and charges them a management fee as the percentages of the monthly rental amount. The user can add the properties 
 * the management company manages, which cannot overlap each other and must each be within the limits of the management company’s plot.
 * Due: 04/04/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Jessica Bunting
*/

/**
 * This class stores data about a Property. 
 * Each ManagementCompany has an array of Properties.
 * @author Jessica Bunting
 * @version 2, 04/03/2021
 */
public class Property {
	/** The property city */
	private String city;
	/** The property owner */
	private String owner;
	/** The property name */
	private String propertyName;
	/** The property's rent amount */
	private double rentAmount;
	/** The property's Plot */
	private Plot plot;
	
	/**
	 * No-arg Constructor, creates a new object with default values of empty strings, 0 for rent amount, and default Plot (sets the x, y values to zero, depth and width to 1)
	 */
	public Property() {
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0.0;
		this.plot = new Plot();	// or null
	}
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it
	 * @param p - a Property object
	 */
	public Property(Property p) {
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = new Plot(p.getPlot().getX(), p.getPlot().getY(), p.getPlot().getWidth(), p.getPlot().getDepth());	//OR this.plot = new Plot(p.plot)
	}
	/**
	 * Parameterized Constructor, no Plot information provided
	 * @param propertyName - property name
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param owner - the owner's name
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}
	/**
	 * Parameterized Constructor
	 * @param propertyName - property name
	 * @param city - city where the property is located
	 * @param rentAmount - rent amount
	 * @param owner - the owner's name
	 * @param x - the x-value of the property's plot
	 * @param y - the y-value of the property's plot
	 * @param width - the horizontal size of the property's plot
	 * @param depth - the vertical size of the property's plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	/**
	 * Set the city
	 * @param city - the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * Set the owner name
	 * @param owner - the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * Set the property name
	 * @param propertyName - the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/**
	 * Set the rent amount
	 * @param rentAmount - the rentAmount to set
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	/**
	 * Return the city
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * Return the owner name
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * Return the property name
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**
	 * Return the rent amount
	 * @return the rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	/**
	 * Return the Plot
	 * @return the Plot for the property
	 */
	public Plot getPlot() {
		// Creates a new Plot object and returns its address
		return new Plot(plot.getX(), plot.getY(), plot.getWidth(), plot.getDepth());
	}
	/**
	 * Set the Plot values
	 * @param x - the x-value of the property's plot
	 * @param y - the y-value of the property's plot
	 * @param width - the horizontal size of the property's plot
	 * @param depth - the vertical size of the property's plot
	 * @return the Plot for the property
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		// Set the Plot values and return the Plot instance //Plot plot = new Plot()
		this.plot.setX(x);
		this.plot.setY(y);
		this.plot.setWidth(width);
		this.plot.setDepth(depth);
		// Creates a new Plot object and returns its address
		return new Plot(plot.getX(), plot.getY(), plot.getWidth(), plot.getDepth());
	}
	
	/**
	 * Prints out the name, city, owner, and rent amount for a property
	 * @return The string representation of a Property object in the following format:
	 * Property Name: propertyName
	 *  Located in city
	 *  Belonging to: owner
	 *  Rent Amount: rentAmount
	 * Be sure the last item is the rent amount, preceded by a space
	 */
	@Override
	public String toString() {
		return "Property Name: " + this.propertyName + "\n Located in " + this.city + "\n Belonging to: " + this.owner + "\n Rent Amount: " + this.rentAmount;
		
	}	
}
