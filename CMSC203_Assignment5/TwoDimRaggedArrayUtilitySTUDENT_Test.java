

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {{0},{18,12.2,3.11},{0,-5.3,2.22},{-1.11,10.0,-0.02,14.0}};
	private double[][] dataSetSTUDENT2 = {{-1.0},{-18.0,12.2,3.11},{-4.0,-5.3,-2.22},{-1.11,10.0,-0.02,14.0}};
	private double[][] dataSetSTUDENT3 = {{7,8,9,3},{8,9,3,7},{9,3,7,8},{3,7,8,9,-1, -1}};
	
	private File inputFile,outputFile;
	private File inputFile2,outputFile2;
	private File inputFile3,outputFile3;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
		outputFile2 = new File("TestOut2.txt");
		outputFile3 = new File("TestOut3.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = dataSetSTUDENT2 = dataSetSTUDENT3 = null;
		inputFile = outputFile = inputFile2 = outputFile2 = inputFile3 = outputFile3 = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() {
		assertEquals(53.1,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);
		assertEquals(7.66,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT2),.001);
		assertEquals(106.0,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT3),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage() {
		assertEquals(4.827,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);
		assertEquals(0.696,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT2),.001);
		assertEquals(5.888,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT3),.001);	
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() {
		assertEquals(0.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,0),.001);
		assertEquals(33.31,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,1),.001);
		assertEquals(-3.08,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,2),.001);
		assertEquals(22.87,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT,3),.001);
		
		assertEquals(-1.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT2,0),.001);
		assertEquals(-2.69,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT2,1),.001);
		assertEquals(-11.52,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT2,2),.001);
		assertEquals(22.87,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT2,3),.001);
		
		assertEquals(27.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT3,0),.001);
		assertEquals(27.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT3,1),.001);
		assertEquals(27.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT3,2),.001);
		assertEquals(25.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT3,3),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() {
		assertEquals(16.89,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,0),.001);
		assertEquals(16.9,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,1),.001);
		assertEquals(5.31,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,2),.001);
		assertEquals(14.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT,3),.001);
		
		assertEquals(-24.11,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT2,0),.001);
		assertEquals(16.9,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT2,1),.001);
		assertEquals(0.87,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT2,2),.001);
		assertEquals(14.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT2,3),.001);
		
		assertEquals(27.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT3,0),.001);
		assertEquals(27.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT3,1),.001);
		assertEquals(27.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT3,2),.001);
		assertEquals(27.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT3,3),.001);
		assertEquals(-1.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT3,4),.001);
		assertEquals(-1.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT3,5),.001);	
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() {
		assertEquals(18.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);
		assertEquals(14.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT2),.001);
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT3),.001);	
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		assertEquals(0.0, array[0][0],.001);
		assertEquals(18.0, array[1][0],.001);
		assertEquals(12.2, array[1][1],.001);
		assertEquals(3.11, array[1][2],.001);
		assertEquals(0.0, array[2][0],.001);
		assertEquals(-5.3, array[2][1],.001);
		assertEquals(2.22, array[2][2],.001);
		assertEquals(-1.11, array[3][0],.001);
		assertEquals(10.0, array[3][1],.001);
		assertEquals(-0.02, array[3][2],.001);
		assertEquals(14.0, array[3][3],.001);

		double[][] array2=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT2, outputFile2);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array2 = TwoDimRaggedArrayUtility.readFile(outputFile2);
		assertEquals(-1.0, array2[0][0],.001);
		assertEquals(-18.0, array2[1][0],.001);
		assertEquals(12.2, array2[1][1],.001);
		assertEquals(3.11, array2[1][2],.001);
		assertEquals(-4.0, array2[2][0],.001);
		assertEquals(-5.3, array2[2][1],.001);
		assertEquals(-2.22, array2[2][2],.001);
		assertEquals(-1.11, array2[3][0],.001);
		assertEquals(10.0, array2[3][1],.001);
		assertEquals(-0.02, array2[3][2],.001);
		assertEquals(14.0, array2[3][3],.001);
		
		double[][] array3=null;
		try {
			TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT3, outputFile3);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
		array3 = TwoDimRaggedArrayUtility.readFile(outputFile3);
		assertEquals(7.0, array3[0][0],.001);
		assertEquals(8.0, array3[0][1],.001);
		assertEquals(9.0, array3[0][2],.001);
		assertEquals(3.0, array3[0][3],.001);
		assertEquals(8.0, array3[1][0],.001);
		assertEquals(9.0, array3[1][1],.001);
		assertEquals(3.0, array3[1][2],.001);
		assertEquals(7.0, array3[1][3],.001);
		assertEquals(9.0, array3[2][0],.001);
		assertEquals(3.0, array3[2][1],.001);
		assertEquals(7.0, array3[2][2],.001);
		assertEquals(8.0, array3[2][3],.001);
		assertEquals(3.0, array3[3][0],.001);
		assertEquals(7.0, array3[3][1],.001);
		assertEquals(8.0, array3[3][2],.001);
		assertEquals(9.0, array3[3][3],.001);
		assertEquals(-1.0, array3[3][4],.001);
		assertEquals(-1.0, array3[3][5],.001);
	}
}
