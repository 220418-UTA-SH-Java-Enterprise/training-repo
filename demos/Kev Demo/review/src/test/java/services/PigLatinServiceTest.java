package services;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import piglatin.PigLatin;

public class PigLatinServiceTest {

	PigLatinService pigLatinService;
	
	//creating mocked object
	PigLatin pigLatin = Mockito.mock(PigLatin.class);
	
	public PigLatinServiceTest() {
		//we are passing the mocked object to our pigLatinService class
		this.pigLatinService = new PigLatinService(pigLatin);
	}
	

	/*
	 * What is unit testing?
	 * 	- Testing the smallest units of your code in isolation
	 * 	- The smallest units of code in java is going to be methods
	 * 
	 * Mockito allows us to mock methods in external classes so you can test your method in isolation
	 * 	- you need to determine if the method that you are testing has methods from other classes.
	 *
	 * Two Mockito methods we should be aware of:
	 * 	- Mockito.when().thenReturn();
	 * 		- hard code a return value for an external method
	 *  - Mockito.verify()
	 *  	- verifies a mocked method is called a certain amount of times
	 *  
	 *  General rule of thumb:
	 *  	- if the method that you are testing calls an external method, you need to mock it.
	 */
	
	@Test
	public void encodeSentencePassTest() {
		//arrange - the setup for the test
		String sentenceToPass = "Another string";
		String expectedResult = "notherAay tringsay";
		
		//Mockito.when hard codes a return value without actually calling the logic of the external method
		Mockito.when(this.pigLatin.encode("Another")).thenReturn("iHay");
		Mockito.when(this.pigLatin.encode("im")).thenReturn("miay");
		
		//act - actually calling the method that we are testing
		String actualResult = this.pigLatinService.encodeSentence(sentenceToPass);
		
		//assert - the pass or fail (assertEquals)
		Assert.assertEquals(expectedResult, actualResult);
		
	}
}
