package test.codeSample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source.codeSample.StringCalculator;

class StringCalculatorTest {

	StringCalculator obj = new StringCalculator();
	
	@Test
	void AddBlankStringCase() {
		int sum1 = obj.Add("");
		int sum2 = obj.Add(null);
		assertEquals(0,sum1);
		assertEquals(0,sum2);
	}

}
