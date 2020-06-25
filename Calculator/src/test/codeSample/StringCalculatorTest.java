package test.codeSample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import source.codeSample.StringCalculator;

class StringCalculatorTest {

	StringCalculator obj = new StringCalculator();
	
	@ParameterizedTest
	@NullAndEmptySource
	void test_AddBlankStringCase(String input) {
		assertEquals(0,obj.Add(input));
	}
	
	@ParameterizedTest
	@CsvSource(value={"0>0","1>1","1,2>3","11>11","23,4>27","45,400>445"},delimiter='>')
	void test_AddOneOrTwoStringCase(String input,String expectedOutput) {
		assertEquals(Integer.parseInt(expectedOutput),obj.Add(input));
	}
	
	@ParameterizedTest
	@CsvSource(value={"1>1","1,2>3","11,3,44,78,126>262","100,200,46,3,88,23,456,982,230>2128"},delimiter='>')
	void test_AddUnknownLengthStringCase(String input,String expectedOutput) {
		assertEquals(Integer.parseInt(expectedOutput),obj.Add(input));
	}
	
	@ParameterizedTest
	@ValueSource(strings={"1\n2o3","11,3\n44,78\n126o262"})
	void test_AddStringWithNewLineCase(String strinput) {
		String input[] = strinput.split("o");
		assertEquals(Integer.parseInt(input[1]),obj.Add(input[0]));
	}
	
	

}
