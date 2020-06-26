package test.codeSample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
		try {
			assertEquals(0,obj.Add(input));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@CsvSource(value={"0>0","1>1","1,2>3","11>11","23,4>27","45,400>445"},delimiter='>')
	void test_AddOneOrTwoStringCase(String input,String expectedOutput) {
		try {
			assertEquals(Integer.parseInt(expectedOutput),obj.Add(input));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@CsvSource(value={"1>1","1,2>3","11,3,44,78,126>262","100,200,46,3,88,23,456,982,230>2128"},delimiter='>')
	void test_AddUnknownLengthStringCase(String input,String expectedOutput) {
		try {
			assertEquals(Integer.parseInt(expectedOutput),obj.Add(input));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings={"1\n2o3","11,3\n44,78\n126o262"})
	void test_AddStringWithNewLineCase(String strinput) {
		String input[] = strinput.split("o");
		try {
			assertEquals(Integer.parseInt(input[1]),obj.Add(input[0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings={"//;\n1;2;3o6","//$\n1$22$34$100o157","//.\n10.2.5o17","//#\n10#2#5o17"})
	void test_AddStringWithDelimiterCase(String strinput) {
		String input[] = strinput.split("o");
		try {
			assertEquals(Integer.parseInt(input[1]),obj.Add(input[0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings={"//;\n-1;2;3o-1","11,-3\n44,78\n126o-3","1,-2o-2"})
	void test_AddStringWithNegativeNumberCase(String strinput) {
		String input[] = strinput.split("o");
		Throwable exception = assertThrows(Exception.class, () -> {
			obj.Add(input[0]);
		});
		assertEquals("negatives not allowed: "+input[1],exception.getMessage());
		
	}
	
	@ParameterizedTest
	@ValueSource(strings={"//;\n-1;-2;3o-1,-2","11,-3\n-44,78\n-126o-3,-44,-126","-1,-2o-1,-2"})
	void test_AddStringWithMultipleNegativeNumberCase(String strinput) {
		String input[] = strinput.split("o");
		Throwable exception = assertThrows(Exception.class, () -> {
			obj.Add(input[0]);
		});
		assertEquals("negatives not allowed: "+input[1],exception.getMessage());
		
	}
	
	@ParameterizedTest
	@CsvSource(value={"1000,2:1002","1001,3,44,78,126:251","952,2:954"},delimiter=':')
	void test_AddStringWithNumberBelow1000PlusCase(String input,String expectedOutput) {
		try {
			assertEquals(Integer.parseInt(expectedOutput),obj.Add(input));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings={"//[;;;]\n1;;;2;;;3o6","//[$$]\n1$$22$$34$$100o157","//[*****]\n10*****2*****5o17"})
	void test_AddStringWithSingleAnyLengthDelimiterCase(String strinput) {
		String input[] = strinput.split("o");
		try {
			assertEquals(Integer.parseInt(input[1]),obj.Add(input[0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings={"//[;][$]\n1$2;3o6","//[*][%]\n1*22%34%100o157","//[#][@][.]\n10@2.5#4o21"})
	void test_AddStringWithMultipleDelimiterCase(String strinput) {
		String input[] = strinput.split("o");
		try {
			assertEquals(Integer.parseInt(input[1]),obj.Add(input[0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@ValueSource(strings={"//[;;][$$]\n1$$2;;3o6","//[*****][%%%]\n1*****22%%%34%%%100o157","//[####][@@@@@@@@@@][..]\n10@@@@@@@@@@2..5####4o21"})
	void test_AddStringWithMultipleAnyLengthDelimiterCase(String strinput) {
		String input[] = strinput.split("o");
		try {
			assertEquals(Integer.parseInt(input[1]),obj.Add(input[0]));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
