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

/**
 * This class represents a beverage shop, and acts as the data manager for the other classes in the program.
 * The BevShop class implements BevShopShopInterface.
 * @author Jessica Bunting
 * @version 1, 05/08/2021
 */
public class BevShop implements BevShopInterfce {
	/** The number of Alcohol drinks ordered for the current order */
	private int numOfAlcoholDrink;
	/** An ArrayList of Order objects */
	private ArrayList<Order> ordersList;
	
	/**
	 * No-arg Constructor that creates a BevShop object by initializing the ArrayList of Orders.
	 */
	public BevShop() {
		ordersList = new ArrayList<Order>();
	}
	
	public boolean validTime(int time) {
		return (time >= MIN_TIME && time <= MAX_TIME);
	}
	public boolean eligibleForMore() {
		return (numOfAlcoholDrink < MAX_ORDER_FOR_ALCOHOL);
	}
	public boolean validAge(int age) {
		return (age > MIN_AGE_FOR_ALCOHOL);
	}
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		ordersList.add(new Order(time, day, new Customer(customerName, customerAge)));
		numOfAlcoholDrink = 0;
	}
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		ordersList.get(ordersList.size() - 1).addNewBeverage(bevName, size, extraShot, extraSyrup);
		//currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	public void processAlcoholOrder(String bevName, SIZE size) {
		ordersList.get(ordersList.size() - 1).addNewBeverage(bevName, size);
		numOfAlcoholDrink = getCurrentOrder().findNumOfBeveType(TYPE.ALCOHOL);
	}
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		ordersList.get(ordersList.size() - 1).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}
	public int findOrder(int orderNo) {
		//boolean orderFound = false;
		for (int index = 0; index < ordersList.size(); index++) {
			if (orderNo == ordersList.get(index).getOrderNo()) {
				return index;
			}
		}
		return -1;
	}
	public double totalOrderPrice(int orderNo) {
		return ordersList.get(findOrder(orderNo)).calcOrderTotal();
	}
	public double totalMonthlySale() {
		double totalSale = 0.0;
		for (int index = 0; index < ordersList.size(); index++) {
			totalSale += ordersList.get(index).calcOrderTotal();
		}
		return totalSale;
	}
	/**
	 * Calculates the total number of orders for this beverage shop
	 * @return the total number of orders
	 */
	public int totalNumOfMonthlyOrders() {
		return ordersList.size();
	}
	public void sortOrders() {
		int startScan, index, minIndex;
		Order minValue;
		for (startScan = 0; startScan < (ordersList.size() - 1); startScan++) {
			minIndex = startScan;
			minValue = getOrderAtIndex(startScan);
			for (index = startScan + 1; index < ordersList.size(); index++) {
				if (getOrderAtIndex(index).compareTo(minValue) == -1) {
					minValue = getOrderAtIndex(index);
					minIndex = index;
				}
			}
			ordersList.set(minIndex, getOrderAtIndex(startScan));
			ordersList.set(startScan, minValue);
		}
	}
	public Order getOrderAtIndex(int index) {
		return ordersList.get(index);
	}
	
	/**
	 * Displays the full information for all orders and the total monthly sale amount
	 * @return The string representation of information of ALL the orders within this beverage shop by accessing the "Orders" ArrayList.
	 */
	@Override
	public String toString() {
		return this.ordersList + ", Total Monthly Sale: " + totalMonthlySale();
	}
	
	public Order getCurrentOrder() {
		return getOrderAtIndex(ordersList.size() - 1);
	}
	
	/**
	 * Return current order's number of Alcohol drinks
	 * @return the number of Alcohol drinks for the current order
	 */
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholDrink;
	}
	
	/**
	 * Checks if the number of fruits for the current Smoothie drink has reached the maximum
	 * @param numOfFruits the number of fruits for the current Smoothie drink
	 * @returns returns true if the number of fruits for the current Smoothie drink has reached the maximum, false otherwise
	 */
	public boolean isMaxFruit(int numOfFruits) {
		return (numOfFruits > MAX_FRUIT);
	}
	
	/**
	 * Return the MIN_AGE_FOR_ALCOHOL final variable that represents the minimum customer age to purchase an Alcohol drink.
	 * @return the MIN_AGE_FOR_ALCOHOL a constant attribute for this class that is set 21
	 */
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	/**
	 * Return the MAX_ORDER_FOR_ALCOHOL final variable that represents the maximum number of Alcohol drinks allowed for one order.
	 * @return the MAX_ORDER_FOR_ALCOHOL a constant attribute for this class that is set 3
	 */
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
}
