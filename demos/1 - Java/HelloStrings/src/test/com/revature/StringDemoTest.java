package test.com.revature;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;

import com.revature.Driver;



public class StringDemoTest {
	
	/* - Unit testing is a part of TDD
	 * - TDD = first make your tests, then write code that pass test
	 * - Our testing framework in Java is called JUnit
	 * 
	 * - When making a unit test, remember the 3 A's:
	 * 		- ARRANGE = you setup your test by providing the preliminary/needed code (ex. class instance Animal needed for AnimalTest) 
	 * 		- ACT = the invocation of the method being tested (ex. Animal.speak())
	 * 		- ASSERT = check whether the expectations were met (ex. assertEquals(expected is bark, actual should be also bark)
	 * 
	 */
	
	public static Driver target;
	
	@BeforeClass
	public static void setup() {
		//arrange
		target = new Driver();
	}

	@Test
	public void fancyString_positiveTest() {
		
		//act
		String expected = "test-string";
		
		//assert
		assertEquals(expected, target.fancyString("test"));
	}

}
