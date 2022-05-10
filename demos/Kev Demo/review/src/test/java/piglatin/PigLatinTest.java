package piglatin;

import org.junit.Assert;
import org.junit.Test;

public class PigLatinTest {
	
	PigLatin pigLatin = new PigLatin();

	@Test
	public void encode() {
		//arrange
		String wordToPass = "Revature";
		String expectedOutput = "evatureRay";
		
		//act
		String actualResult = this.pigLatin.encode(wordToPass);
		
		//assert
		Assert.assertEquals(expectedOutput, actualResult);
	}
}
