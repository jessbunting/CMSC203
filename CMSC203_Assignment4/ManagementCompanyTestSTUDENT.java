

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property house1, house2, house3, house4, house5, house6;
	ManagementCompany myCompany;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		myCompany = new ManagementCompany("Jessica's Company", "000001", 3, 0, 0, 12, 12);
		
		//student add three properties, with plots, to mgmt co
		house1 = new Property("City Apartment", "DC", 1500, "John Smith", 7, 8, 1, 1);
		house2 = new Property("Suburb Apartment", "Gaithersburg", 1277.5, "Brian Jones", 5, 5, 2, 2);
		house3 = new Property("Rural House", "Laurel", 1099, "Sue Sheldon", 3, 4, 2, 2);
		
		myCompany.addProperty(house1);
		myCompany.addProperty(house2);
		myCompany.addProperty(house3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null  
		myCompany = null;
		house1 = house2 = house3 = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(myCompany.addProperty("Nice Townhouse", "Rockville", 1331.5, "Sam Kim"), 3, 0);
		
		//student should add property with 8 args
		assertEquals(myCompany.addProperty("Normal House", "Bethesda", 1277, "Judy Jenkins", 5, 2, 3, 3), 4, 0);
		
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		assertEquals(myCompany.addProperty("Extra House", "Rockville", 1555, "Carl Park", 1, 4, 2, 2), -1, 0);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(myCompany.maxRentProp(), 1500.0, 0);	// for house1, house2. house3 only since tearDown() between tests
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		System.out.println(myCompany.totalRent());
		assertEquals(myCompany.totalRent(), 3876.5, 0);	// house1 + house2 + house3 only since tearDown() between tests
	}

 }
