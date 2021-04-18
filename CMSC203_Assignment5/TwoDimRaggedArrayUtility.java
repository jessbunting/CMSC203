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

import java.io.File;
import java.io.*;
import java.util.Scanner;

/**
 * This class is a utility class that works with two-dimensional ragged arrays of doubles.
 * It works with arrays with a maximum of 10 rows and 10 columns.
 * It works with both negative and positive numbers for array element values.
 * There are no private data members since this is a utility class.
 * @author Jessica Bunting
 * @version 2, 04/17/2021
 */
public final class TwoDimRaggedArrayUtility {

	/**
	 * Reads from a file and returns a ragged array of doubles.
	 * The maximum rows is 10 and the maximum columns for each row is 10.
	 * Each row in the file is separated by a new line.
	 * Each element in the row is separated by a space.
	 * 1. Read the doubles from the file into an a temporary array [10][10] of Strings which was initialized to nulls.
	 * 2. Find out how many rows there are (any row that has the first element != null is a valid row).
	 * 3. Create the array based on the num of rows, i.e. double[][]array = new double[#rows][].
	 * 4. Determine the number of columns for the first row (any element != null is a valid element).
	 * 5. Create the first row, i.e. array[0] = new double[#columns].
	 * 6. Put the values from the temporary array into in the row (don't forget to convert from strings to doubles).
	 * 7. Repeat for all rows.
	 * @param file a file to read from
	 * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty, returns a null if file is empty
	 * @throws FileNotFoundException if file is not valid
	 */
	public static double[][] readFile(File file) throws FileNotFoundException {
		if (!file.exists() || file.length() == 0) {
			return null;
		}
		
		String[][] tempArray = new String[10][10]; // Temporary array of Strings initialized to nulls
		String str;
		Scanner inputFile = new Scanner(file);
		
		int line = 0;
		while (inputFile.hasNext()) {
			str = inputFile.nextLine();
			tempArray[line] = str.split(" ");
			line++;
		}
		
		int rowCount = 0;
		for (int i = 0; i < 10; i++) {
			if (tempArray[i][0] != null) {
				rowCount += 1;
			}
		}
		
		double[][] array = new double[rowCount][];
		
		int colCount;
		for (int i = 0; i < rowCount; i++) {
			colCount = 0;
			for (int j = 0; j < tempArray[i].length; j++) {
				colCount += 1;
			}
			array[i] = new double[colCount];
			for (int m = 0; m < colCount; m++) {
				array[i][m] = Double.valueOf(tempArray[i][m]);
			}
		}
		inputFile.close();
		return array;	// returns reference
	}
	
	/**
	 * Writes the ragged array of doubles into the file.
	 * Each row is on a separate line within the file and each double is separated by a space.
	 * @param data two dimensional ragged array of doubles
	 * @param outputFile the file to write to
	 * @throws FileNotFoundException if outputFile is not valid
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		PrintWriter oFile = new PrintWriter(outputFile);	// Opens the file
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				oFile.print(data[i][j] + " ");
			}
			oFile.print("\n");
		}
		oFile.close();
	}
	
	/**
	 * Returns the total of all the elements of the two dimensional array
	 * @param data the two dimensional array getting total of
	 * @return the sum of all the elements in the two dimensional array
	 */
	public static double getTotal(double[][] data) {
		double total = 0;	// Accumulator set to 0
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
		}
		return total;
	}
	
	/**
	 * Returns the average of the elements in the two dimensional array
	 * @param data the two dimensional array getting the average of
	 * @return the average of the elements in the two dimensional array (total of elements/num of elements)
	 */
	public static double getAverage(double[][] data) {
		double total = getTotal(data);
		int count = 0;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				count += 1;
			}
		}
		// Ensure count is not zero before returning
		if (count != 0) {
			return total / count;
		}
		else {
			return 0.0;
		}
	}
	
	/**
	 * Returns the total of the selected row in the two dimensional array (index 0 refers to the first row).
	 * @param data the two dimensional array
	 * @param row the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		for (int col = 0; col < data[row].length; col++) {
			total += data[row][col];
		}
		return total;
	}
	
	/**
	 * Returns the total of the selected column in the two dimensional array (index 0 refers to the first column).
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col the column index to take the total of (0 refers to the first column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;
		for (int row = 0; row < data.length; row++) {
			if (data[row].length >= col + 1) {
				total += data[row][col];
			}
		}
		return total;
	}
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array (index 0 refers to the first row).
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highestValue = Double.NEGATIVE_INFINITY;
		for (int index = 0; index < data[row].length; index++) {
			if (data[row][index] > highestValue) {
				highestValue = data[row][index];
			}
		}
		return highestValue;
	}
	
	/**
	 * Returns the index of the largest element of the selected row in the two dimensional array (index 0 refers to the first row).
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the index of the largest element of the row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highestValue = Double.NEGATIVE_INFINITY;
		int highestIndex = 0;
		for (int index = 0; index < data[row].length; index++) {
			if (data[row][index] > highestValue) {
				highestValue = data[row][index];
				highestIndex = index;
			}
		}
		return highestIndex;
	}
	
	/**
	 * Returns the smallest element of the selected row in the two dimensional array (index 0 refers to the first row).
	 * @param data the two dimensional array
	 * @param row the row index to find the smallest element of (0 refers to the first row)
	 * @return the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowestValue = Double.MAX_VALUE;
		for (int index = 0; index < data[row].length; index++) {
			if (data[row][index] < lowestValue) {
				lowestValue = data[row][index];
			}
		}
		return lowestValue;
	}
	
	/**
	 * Returns the index of the smallest element of the selected row in the two dimensional array (index 0 refers to the first row).
	 * @param data the two dimensional array
	 * @param row the row index to find the smallest element of (0 refers to the first row)
	 * @return the index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowestValue = Double.MAX_VALUE;
		int lowestIndex = 0;
		for (int index = 0; index < data[row].length; index++) {
			if (data[row][index] < lowestValue) {
				lowestValue = data[row][index];
				lowestIndex = index;
			}
		}
		return lowestIndex;
	}
	
	/**
	 * Returns the largest element of the selected column in the two dimensional array (index 0 refers to the first column).
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col the column index to find the largest element of (0 refers to the first column)
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highestValue = Double.NEGATIVE_INFINITY;
		for (int index = 0; index < data.length; index++) {
			if ((data[index].length >= col + 1) && (data[index][col] > highestValue)) {
				highestValue = data[index][col];
			}
		}
		return highestValue;
	}
	
	/**
	 * Returns index of the largest element of the selected column in the two dimensional array (index 0 refers to the first column).
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col the column index to find the largest element of (0 refers to the first column)
	 * @return the index of the largest element of the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highestValue = Double.NEGATIVE_INFINITY;
		int highestIndex = 0;
		for (int index = 0; index < data.length; index++) {
			if ((data[index].length >= col + 1) && (data[index][col] > highestValue)) {
				highestValue = data[index][col];
				highestIndex = index;
			}
		}
		return highestIndex;
	}
	
	/**
	 * Returns the smallest element of the selected column in the two dimensional array (index 0 refers to the first column).
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col the column index to find the smallest element of (0 refers to the first column)
	 * @return the smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowestValue = Double.MAX_VALUE;
		for (int index = 0; index < data.length; index++) {
			if ((data[index].length >= col + 1) && (data[index][col] < lowestValue)) {
				lowestValue = data[index][col];
			}
		}
		return lowestValue;
	}
	
	/**
	 * Returns the index of the smallest element of the selected column in the two dimensional array (index 0 refers to the first column).
	 * If a row in the two dimensional array doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * @param data the two dimensional array
	 * @param col the column index to find the smallest element of (0 refers to the first column)
	 * @return the index of the smallest element of the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowestValue = Double.MAX_VALUE;
		int lowestIndex = 0;
		for (int index = 0; index < data.length; index++) {
			if ((data[index].length >= col + 1) && (data[index][col] < lowestValue)) {
				lowestValue = data[index][col];
				lowestIndex = index;
			}
		}
		return lowestIndex;
	}
	
	/**
	 * Returns the value of the largest element in the two dimensional array
	 * @param data the two dimensional array
	 * @return the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		double highestValue = Double.NEGATIVE_INFINITY;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] > highestValue) {
					highestValue = data[row][col];
				}
			}
		}
		return highestValue;
	}
	
	/**
	 * Returns the value of the smallest element in the two dimensional array
	 * @param data the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowestValue = Double.MAX_VALUE;
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] < lowestValue) {
					lowestValue = data[row][col];
				}
			}
		}
		return lowestValue;
	}
}
