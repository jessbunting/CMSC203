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
 * This class stores data about a Plot.
 * Each Property object has a Plot and each ManagementCompany object has a Plot.
 * @author Jessica Bunting
 * @version 2, 04/03/2021
 */

public class Plot {
	/** The x-value of the upper-left corner of the Plot */
	private int x;	
	/** The y-value of the upper-left corner of the Plot */
	private int y;
	/** The horizontal extent of the Plot */
	private int width;
	/** The vertical extent of the Plot */
	private int depth;
	
	/**
	 * No-arg Constructor, creates a default Plot with args x=0, y=0, width=1, depth=1
	 */
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	/**
	 * Copy Constructor, creates a new Plot using the information of the Plot passed to it.
	 * @param p - a Plot object
	 */
	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	/**
	 * Parameterized Constructor
	 * @param x - horizontal coordinate of upper left corner
	 * @param y - vertical coordinate of upper left corner
	 * @param width - horizontal size
	 * @param depth - vertical size
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	/**
	 * Determines if this plot overlaps the parameter
	 * @param plot - a Plot object
	 * @return Returns true if this plot overlaps the parameter, false otherwise
	 */
	public boolean overlaps(Plot plot) {
		boolean status = false;
		if ((((this.y == plot.y) || (this.y + this.depth == plot.y + plot.depth) ||
				((this.y > plot.y) && (this.y < plot.y + plot.depth)) ||
				((this.y + this.depth > plot.y) && (this.y + this.depth < plot.y + plot.depth)) ||
				((plot.y > this.y) && (plot.y < this.y + this.depth)) ||
				((plot.y + plot.depth > this.y) && (plot.y + plot.depth < this.y + this.depth)))
				&& ((this.x == plot.x) || (this.x + this.width == plot.x + plot.width) ||
				((this.x > plot.x) && (this.x < plot.x + plot.width)) ||
				((this.x + this.width > plot.x) && (this.x + this.width < plot.x + plot.width)) ||
				((plot.x > this.x) && (plot.x < this.x + this.width)) ||
				((plot.x + plot.width > this.x) && (plot.x + plot.width < this.x + this.width))))) {
			status = true;
		}
		else {
			status = false;
		}
		return status;
	}
	/**
	 * Determines if this plot encompasses the parameter
	 * @param plot - a Plot object
	 * @return Returns true if this plot encompasses the parameter, false otherwise
	 */
	public boolean encompasses(Plot plot) {
		boolean status = false;
		if (
			((plot.y >= this.y) && (plot.y <= this.y + this.depth)) &&
			((plot.y + plot.depth >= this.y) && (plot.y + plot.depth <= this.y + this.depth)) &&
			((plot.x >= this.x) && (plot.x <= this.x + this.width)) &&
			((plot.x + plot.width >= this.x) && (plot.x + plot.width <= this.x + this.width))
		) {
			status = true;
		}
		else {
			status = false;
		}
		
		return status;
	}
	/**
	 * Set the x value
	 * @param x - the x value to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * Set the y value
	 * @param y - the y value to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Set the width value
	 * @param width - the width value to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * Set the depth value
	 * @param depth - the depth value to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	/**
	 * Return the x value
	 * @return the x value
	 */
	public int getX() {
		return x;
	}
	/**
	 * Return the y value
	 * @return the y value
	 */
	public int getY() {
		return y;
	}
	/**
	 * Return the width value
	 * @return the width value
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Return the depth value
	 * @return the depth value
	 */
	public int getDepth() {
		return depth;
	}
	/**
	 * Prints out the name, city, owner, and rent amount for a property
	 * @return the string representation of a Plot object in the following format:
	 * Upper left: (1,1); Width 3 Depth 3
	 */
	@Override
	public String toString() {
		return "Upper left: (" + this.x + "," + this.y + "); Width: " + this.width + " Depth: " + this.depth;
	}
}
