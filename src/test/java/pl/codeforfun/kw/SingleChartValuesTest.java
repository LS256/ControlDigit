package pl.codeforfun.kw;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.codeforfun.kw.SingleCharValues.CharValues;

public class SingleChartValuesTest {
	
	SingleCharValues singleChartValue;
	
	@Before
	public void setUp() throws Exception {
		singleChartValue = new SingleCharValues();
	}

	@Test
	public void test() {
		
		//	Value of X is 10
		assertEquals(10, CharValues.valueOf("X").getValue());
		
		//	Value of G is 17
		assertEquals(17, CharValues.valueOf("G").getValue());
		
		//	check if for argument of small letter test also will be succeed. Value of G is 17
		assertEquals(17, singleChartValue.getCharValue("g"));
		
		//	check if for argument of small letter test also will be succeed. Value of P is 26
		assertEquals(26, singleChartValue.getCharValue("p"));
		
		//	check if for integer argument test is succeed
		assertEquals(5, singleChartValue.getCharValue("5"));
		
		//	check if for incorrect argument test returns value of error (value of error is 256)
		assertEquals(256, singleChartValue.getCharValue("£"));
		
		//	check if for incorrect argument test returns value of error (value of error is 256)
		assertEquals(256, singleChartValue.getCharValue("Q"));
	
	}

}
