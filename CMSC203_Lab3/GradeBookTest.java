import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	private GradeBook gb1, gb2;	// Private attributes
	
	@BeforeEach
	void setUp() throws Exception {
		gb1 = new GradeBook(5);	// Object of GradeBook to hold 5 scores
		gb2 = new GradeBook(5);	// Another object of GradeBook to hold 5 scores
		// Call the addScore method for each GradeBook object 2 to 5 times
		gb1.addScore(45);
		gb1.addScore(71);
		gb1.addScore(98);
		
		gb2.addScore(87);
		gb2.addScore(22);
		gb2.addScore(66);
		gb2.addScore(12);
	}

	@AfterEach
	void tearDown() throws Exception {
		// Set the two objects of GradeBook to null
		gb1 = null;
		gb2 = null;
	}

	@Test
	void testAddScore() {
		// Use toString to compare contents of scores array vs. expected contents of scores array
		assertTrue(gb1.toString().equals("45.0 71.0 98.0 "));
		assertTrue(gb2.toString().equals("87.0 22.0 66.0 12.0 "));
		// Compare scoresSize to expected number of scores entered
		assertEquals(3, gb1.getScoreSize(), 0.001);
		assertEquals(4, gb2.getScoreSize(), 0.001);
	}

	@Test
	void testSum() {
		// Compare what is returned by sum() vs. expected sum of scores entered
		assertEquals(214, gb1.sum(), .0001);
		assertEquals(187, gb2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		// Compare what is returned by minimum() vs. expected minimum of scores entered
		assertEquals(45, gb1.minimum(), 0.001);
		assertEquals(12, gb2.minimum(), 0.001);
	}

	@Test
	void testFinalScore() {
		// Compare what is returned by finalScore() vs. expected finalScore of scores entered
		assertEquals(169, gb1.finalScore(), 0.0001);
		assertEquals(175, gb2.finalScore(), 0.0001);
	}
}
