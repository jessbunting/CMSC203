/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: A program that calculates holiday bonuses for stores in a retail district based on store sales in several categories.
 * The program uses two utility classes to manipulate a two-dimensional ragged array of doubles to create a sales report and calculate holiday the bonuses by sale category.
 * Different bonus amounts are awarded for the store with highest sales in a category, lowest sales in a category, and all other stores with sales in that category.
 * For each category, only stores with positive sales in that category are eligible for any bonus.
 * Due: 04/18/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Jessica Bunting
*/

/**
 * This class is a utility class that calculates holiday bonuses given a two-dimensional
 * ragged array of doubles which represent the sales for each store in a category.
 * The class gives different bonus amounts for the store with highest sales in a category,
 * lowest sales in a category, and all other stores with sales in that category.
 * It works with both negative and positive numbers for array element values.
 * There are no private data members since this is a utility class.
 * @author Jessica Bunting
 * @version 1, 04/17/2021
 */
public class HolidayBonus {
	
	/**
	 * Calculates the holiday bonus for each store
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		// Find the largest number of columns/longest row
		//int maxRowLength = data[0].length;	// Initialize... this is also the number of sales categories
		int maxRowLength = 0;
		for (int row = 0; row < data.length; row++) {
			if (data[row].length > maxRowLength) {
				maxRowLength = data[row].length;
			}
		}
		
		double[] arr = new double[data.length];	// Number of elements equal to number of rows in data 2D array
		
		// Is below necessary? debug shows already initialized as 0.0
		// Initialize array elements (store bonuses) to zero
		for (int index = 0; index < data.length; index++) {
			arr[index] = 0.0;
		}
		
		// Starting at column index 0, loop through columns
		for (int index = 0; index < maxRowLength; index++) {
			
			// For each column, find the highest in the column and the lowest in the column
			int highStoreIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, index);
			int lowStoreIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, index);
			
			// If only one store for this category
			if (highStoreIndex == lowStoreIndex && data[highStoreIndex][index] > 0.0) {
				// Only stores with positive sales get bonus
				//if (data[highStoreIndex][index] > 0.0) {
				arr[highStoreIndex] += high;
				//}
			}
			else {
				// Loop through rows
				for (int row = 0; row < data.length; row++) {
					if (data[row].length > index && data[row][index] > 0.0) {
						//if (data[row][index] > 0.0) {
						if (data[row][index] == data[highStoreIndex][index]) {
							arr[row] += high;
						}
						else if (data[row][index] == data[lowStoreIndex][index]) {
							arr[row] += low;
						}
						else {
							arr[row] += other;
						}
						//}
					}
				}
			}
		}
		return arr;	// Returns reference to the array
	}
	
	/**
	 * Calculates the total holiday bonuses
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double[] result = HolidayBonus.calculateHolidayBonus(data, high, low, other);
		double total = 0.0;	// Initialize accumulator
		for (int i = 0; i < result.length; i++) {
			total += result[i];
		}
		return total;
	}
}