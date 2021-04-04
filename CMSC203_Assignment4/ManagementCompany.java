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
 * This class stores data about a ManagementCompany.
 * @author Jessica Bunting
 * @version 2, 04/03/2021
 */
public class ManagementCompany {
	/** Maximum number of properties that this management company handles is set to 5 */
	private final int MAX_PROPERTY = 5;
	/** The management fee percentage */
	private double mgmFeePer;
	/** Name of the management company */
	private String name;
	/** An array of Property objects */
	private Property[] properties;
	/** Tax ID of the management company */
	private String taxID;
	/** Maximum horizontal extent of the Plot of the management company */
	private final int MGMT_WIDTH = 10;
	/** Maximum vertical extent of the Plot of the management company */
	private final int MGMT_DEPTH = 10;
	/** Plot of the management company */
	private Plot plot;
	
	/**
	 * No-arg Constructor Constructor that creates a ManagementCompany object using empty strings and a default Plot. "properties" array is initialized here as well.
	 */
	public ManagementCompany() {
		this.mgmFeePer = 0.0;
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);	// Plot default here
		this.properties = new Property[MAX_PROPERTY];	// Initialize properties array
		for (int i = 0; i < MAX_PROPERTY; i++) {
			this.properties[i] = new Property();
		}
	}
	/**
	 * Constructor Creates a ManagementCompany object using the passed information. Mgmt Co plot is initialized to default Plot. "properties" array is initialized here as well.
	 * @param name - management company name
	 * @param taxID - tax id
	 * @param mgmFee - management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);	// Plot default here
		this.properties = new Property[MAX_PROPERTY];	/// Initialize properties array
		for (int i = 0; i < MAX_PROPERTY; i++) {
			this.properties[i] = new Property();
		}
	}
	/**
	 * Constructor Creates a ManagementCompany object using the passed information. "properties" array is initialized here as well.
	 * @param name - management company name
	 * @param taxID - tax id
	 * @param mgmFee - management fee
	 * @param x - the x-value of the property's plot
	 * @param y - the y-value of the property's plot
	 * @param width - the horizontal size of the property's plot
	 * @param depth - the vertical size of the property's plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];	// Initialize properties array
		for (int i = 0; i < MAX_PROPERTY; i++) {
			this.properties[i] = new Property();
		}
	}
	/**
	 * Copy Constructor creates a ManagementCompany object using another ManagementCompany object. "properties" array is initialized here as well.
	 * @param otherCompany - another management company
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = new Plot(otherCompany.getPlot().getX(), otherCompany.getPlot().getY(), otherCompany.getPlot().getWidth(), otherCompany.getPlot().getDepth());	//this.plot = new Plot(otherCompany.plot)
		this.properties = new Property[MAX_PROPERTY];
		for (int i = 0; i < MAX_PROPERTY; i++) {
			this.properties[i] = new Property(otherCompany.properties[i]);
		}
	}
	
	/**
	 * Return the management company name
	 * @return the name for the management company
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Return the management company Plot
	 * @return the Plot for the management company
	 */
	public Plot getPlot() {
		return new Plot(plot.getX(), plot.getY(), plot.getWidth(), plot.getDepth());
	}
	/**
	 * Return the MAX_PROPERTY constant that represents the size of the "properties" array.
	 * @return the MAX_PROPERTY a constant attribute for this class that is set 5
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	/**
	 * Adds the property object to the "properties" array.
	 * @param property - a property object
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, or the index in the array where the property was added successfully.
	 */
	public int addProperty(Property property) {
		Property pX = new Property(property);	// Call Property copy constructor to deep copy the parameter property
		// Search array for empty element
		int index = 0;	// Loop control variable
		int element = -1;	// Element where empty Property is found
		boolean found = false;	// Flag
		while (!found && index < MAX_PROPERTY) {
			if ((this.properties[index].getPropertyName().equals("") && this.properties[index].getCity().equals("") && this.properties[index].getOwner().equals("") && this.properties[index].getRentAmount() == 0.0 ) || this.properties[index] == null) {
				found = true;
				element = index;
			}
			index++;
		}
		if (!found) {
			return -1;	// or could return element since it would be -1 if !found
		}
		else if (pX.equals(null)) {
			return -2;
		}
		else if (!(this.plot.encompasses(pX.getPlot()))) {
			return -3;
		}
		else {
			for (int i = 0; i < MAX_PROPERTY; i++) {
				if (!this.properties[i].getPropertyName().equals("")) {	// Only compare to non-empty properties
					if (this.properties[i].getPlot().overlaps(pX.getPlot())) {
						return -4;
					}
				}
			}
			this.properties[element] = new Property(pX);
			return element;
		}
	}
	/**
	 * Creates a property object and adds it to the "properties" array, in a default plot.
	 * @param name - property name
	 * @param city - location of the property
	 * @param rent - monthly rent
	 * @param owner - owner of the property
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		Property pX = new Property(name, city, rent, owner);
		// Search array for empty element
		int index = 0;	// Loop control variable
		int element = -1;	// Element where empty Property is found
		boolean found = false;	// Flag
		while (!found && index < MAX_PROPERTY) {
			if ((this.properties[index].getPropertyName().equals("") && this.properties[index].getCity().equals("") && this.properties[index].getOwner().equals("") && this.properties[index].getRentAmount() == 0.0 ) || this.properties[index] == null) {
				found = true;
				element = index;
			}
			index++;
		}
		if (!found) {
			return -1;	// or could return element since it would be -1 if !found
		}
		else if (pX.equals(null)) {
			return -2;
		}
		else if (!(this.plot.encompasses(pX.getPlot()))) {
			return -3;
		}
		else {
			for (int i = 0; i < MAX_PROPERTY; i++) {
				if (!this.properties[i].getPropertyName().equals("")) {	// Only compare to non-empty properties
					if (this.properties[i].getPlot().overlaps(pX.getPlot())) {
						return -4;
					}
				}
			}
			this.properties[element] = new Property(pX);
			return element;
		}
	}	
		
	/**
	 * Creates a property object and adds it to the "properties" array.
	 * @param name - property name
	 * @param city - location of the property
	 * @param rent - monthly rent
	 * @param owner - owner of the property
	 * @param x - x location of upper left corner of property's plot
	 * @param y - y location of upper left corner of property's plot
	 * @param width - width of the property's plot
	 * @param depth - depth of the property's plot
	 * @return Returns either -1 if the array is full, -2 if property is null, -3 if the plot is not contained by the MgmtCo plot, -4 of the plot overlaps any other property, or the index in the array where the property was added successfully.
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property pX = new Property(name, city, rent, owner, x, y, depth, width);
		// Search array for empty element
		int index = 0;	// Loop control variable
		int element = -1;	// Element where empty Property is found
		boolean found = false;	// Flag
		while (!found && index < MAX_PROPERTY) {
			if ((this.properties[index].getPropertyName().equals("") && this.properties[index].getCity().equals("") && this.properties[index].getOwner().equals("") && this.properties[index].getRentAmount() == 0.0 ) || this.properties[index] == null) {
				found = true;
				element = index;
			}
			index++;
		}
		if (!found) {
			return -1;	// or could return element since it would be -1 if !found
		}
		else if (pX.equals(null)) {
			return -2;
		}
		else if (!(this.plot.encompasses(pX.getPlot()))) {
			return -3;
		}
		else {
			for (int i = 0; i < MAX_PROPERTY; i++) {
				if (!this.properties[i].getPropertyName().equals("")) {	// Only compare to non-empty properties
					if (this.properties[i].getPlot().overlaps(pX.getPlot())) {
						return -4;
					}
				}
			}
			this.properties[element] = new Property(pX);
			return element;
		}
	}
		
	/**
	 * This method accesses each "Property" object within the array "properties" and sums up the property rent and returns the total amount.
	 * @return total rent
	 */
	public double totalRent() {
		double total = 0;
		for (int i = 0; i < MAX_PROPERTY; i++) {
			total += this.properties[i].getRentAmount();
		}
		return total;
	}
	/**
	 * This method finds the property with the maximum rent amount and returns its rent amount and displays its toString result. NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * @return the maximum rent amount, a double
	 */
	public double maxRentProp() {
		return this.properties[maxRentPropertyIndex()].getRentAmount();
	}
	/**
	 * This method finds the index of the property with the maximum rent amount. NOTE: For simplicity assume that each "Property" object's rent amount is different.
	 * @return the index of the property with the maximum rent amount
	 */
	private int maxRentPropertyIndex() {
		int maxIndex = 0;
		for (int i = 1; i < MAX_PROPERTY; i++) {
			if (this.properties[i].getRentAmount() > this.properties[maxIndex].getRentAmount()) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	/**
	 * Displays the information of the property at index i
	 * @param i - the index of the property within the array "properties"
	 * @return information of the property at index i
	 */
	private String displayPropertyAtIndex(int i) {
		return this.properties[i].toString();
	}
	/**
	 * Displays the information of all the properties in the "properties" array.
	 * @return The string representation of information of ALL the properties within this management company by accessing the "Properties" array.
	 */
	@Override
	public String toString() {
		String printOutput = "List of the properties for " + this.name + ", taxID: " + this.taxID +
				"\n______________________________________________________";
		for (int i = 0; i < MAX_PROPERTY; i++) {
			printOutput += ("\n" + displayPropertyAtIndex(i));
		}
		printOutput += "\n______________________________________________________\ntotal management Fee: " + ((this.mgmFeePer / 100) * totalRent());
		return printOutput;
		
		
		
	}
	
}
