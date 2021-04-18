import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HolidayBonusSTUDENT_Test {
	
	private double[][] dataSetSTUDENT = {{0},{18,12.2,3.11},{0,-5.3,2.22},{-1.11,10.0,-0.02,14.0}};
	private double[][] dataSetSTUDENT2 = {{-1.0},{-18.0,12.2,3.11},{-4.0,-5.3,-2.22},{-1.11,10.0,-0.02,14.0}};
	private double[][] dataSetSTUDENT3 = {{7,8,9,3},{8,9,3,7},{9,3,7,8},{3,7,8,9,-1,-1}};
	
	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
		dataSetSTUDENT = dataSetSTUDENT = null;
	}

	@Test
	public void testCalculateHolidayBonus() {
		double[] result = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT, 5000, 1000, 2000);
		assertEquals(0.0,result[0],.001);
		assertEquals(15000.0,result[1],.001);
		assertEquals(2000.0,result[2],.001);
		assertEquals(7000.0,result[3],.001);
		
		double[] result2 = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT2, 5000, 1000, 2000);
		assertEquals(0.0,result2[0],.001);
		assertEquals(10000.0,result2[1],.001);
		assertEquals(0.0,result2[2],.001);
		assertEquals(7000.0,result2[3],.001);
		
		double[] result3 = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT3, 1000, 0, 500);
		assertEquals(2000.0,result3[0],.001);
		assertEquals(2000.0,result3[1],.001);
		assertEquals(2000.0,result3[2],.001);
		assertEquals(2000.0,result3[3],.001);
	}

	@Test
	public void testCalculateTotalHolidayBonus() {
		assertEquals(24000.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT, 5000, 1000, 2000),.001);
		assertEquals(17000.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT2, 5000, 1000, 2000),.001);
		assertEquals(8000.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT3, 1000, 0, 500),.001);
	}

}
