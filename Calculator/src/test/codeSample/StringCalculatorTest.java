package test.codeSample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import source.codeSample.StringCalculator;

class StringCalculatorTest {

	StringCalculator obj = new StringCalculator();
	
	@Test
	void test_AddBlankStringCase() {
		int sum1 = obj.Add("");
		int sum2 = obj.Add(null);
		assertEquals(0,sum1);
		assertEquals(0,sum2);
	}
	
	@ParameterizedTest
	@CsvSource(value={"0>0","1>1","1,2>3","11>11","23,4>27","45,400>445"},delimiter='>')
	void test_AddOneOrTwoStringCase(String input,String expectedOutput) {
		assertEquals(Integer.parseInt(expectedOutput),obj.Add(input));
	}
	
	

}
