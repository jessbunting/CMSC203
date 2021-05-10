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

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents an order from the beverage shop. The Order has a Customer and one or more Beverages.
 * The Order class implements OrderInterface and Comparable.
 * @author Jessica Bunting
 * @version 1, 05/08/2021
 */
public class Order implements OrderInterface, Comparable<Order> {
	/** The order number, from 10000 to 90000 */
	private int orderNo;
	/** The time of day the order is placed */
	private int orderTime;
	/** The day of the week the order is placed */
	private DAY orderDay;
	/** The Customer placing the order */
	private Customer cust;
	/** An ArrayList of Beverage objects */
	private ArrayList<Beverage> orderBevs;
	
	// Generate random number 10000 to 90000
	public int randOrderNo() {
		Random randomNum = new Random();
		return randomNum.nextInt(80001) + 10000;
	}
	/**
	 * Constructor Creates an Order object using the passed information. The ArrayList of Beverages is initialized.
	 * @param orderTime Time the order is placed
	 * @param orderDay Day the order is placed
	 * @param cust Customer placing the order
	 */
	public Order(int orderTime, DAY orderDay, Customer cust) {
		this.orderNo = randOrderNo();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = new Customer(cust); 	// CHECK THIS
		this.orderBevs = new ArrayList<Beverage>();
	}
	
	public boolean isWeekend() {
		switch (orderDay) {
			case SATURDAY:
			case SUNDAY:
				return true;
			default:
				return false;
		}
	}
	
	public Beverage getBeverage(int itemNo) {
		if (itemNo >= orderBevs.size()) {
			return null;
		}
		//Beverage bev = orderBevs.get(itemNo);
		return orderBevs.get(itemNo);
	}
	
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orderBevs.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	public void addNewBeverage(String bevName, SIZE size) {
		orderBevs.add(new Alcohol(bevName, size, isWeekend()));
	}
	
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		orderBevs.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	/**
	 * Displays the full information for the order
	 * @return The string representation of information of this order and all the beverages in it.
	 */
	@Override
	public String toString() {
		return "Order Number: " + this.orderNo + ", Time: " + this.orderTime + ", Day: " + this.orderDay + ", " + this.cust + ", " + this.orderBevs + ", Order Total: " + calcOrderTotal();
	}
	
	/**
	 * Compares this order with another order based on the order number. Returns 0 if this order number 
	 * is same as another order's order number, 1 if it is greater than another order's order number, 
	 * -1 if it smaller than another order's order number.
	 * @return 0 if this order number is same as another order's order number, 1 if it is greater than another order's order number, -1 if it smaller than another order's order number.
	 */
	@Override 
	public int compareTo(Order ord) {
		int comp = 0;
		if (orderNo == ord.getOrderNo()) {
			comp = 0;
		}
		else if (orderNo > ord.getOrderNo()) {
			comp = 1;
		}
		else if (orderNo < ord.getOrderNo()) {
			comp = -1;
		}
		return comp;
	}
	
	
	public double calcOrderTotal() {
		double orderTotal = 0.0;
		for (int index = 0; index < orderBevs.size(); index++) {
			orderTotal += orderBevs.get(index).calcPrice();
		}
		return orderTotal;
	}
	public int findNumOfBeveType(TYPE type) {
		int numOfBeveType = 0;
		for (int index = 0; index < orderBevs.size(); index++) {
			if (type.equals(orderBevs.get(index).getType())) {
				numOfBeveType += 1;
			}
		}
		return numOfBeveType;
	}
	
	/**
	 * Return order's order number
	 * @return the order number of the order
	 */
	public int getOrderNo() {
		return orderNo;
	}
	/**
	 * Return the time of day the order was placed
	 * @return the order time of the order
	 */
	public int getOrderTime() {
		return orderTime;
	}
	
	/**
	 * Return the day of the week the order was placed
	 * @return the order day of the order
	 */
	public DAY getOrderDay() {
		return orderDay;
	}
	
	/**
	 * Return the Customer that placed the order
	 * @return a deep copy of the Customer making the order
	 */
	public Customer getCustomer() {
		return new Customer(cust.getName(), cust.getAge());	// OR copy constructor?
	}
	
	/**
	 * Return the total number of items in the order
	 * @return the total items in the order Beverage ArrayList
	 */
	public int getTotalItems() {
		return orderBevs.size();
	}
}
