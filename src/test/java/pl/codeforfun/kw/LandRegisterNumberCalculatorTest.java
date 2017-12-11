package pl.codeforfun.kw;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LandRegisterNumberCalculatorTest {

	ApplicationContext context;
	LandRegisterNumberCalculator landRegisterNumberCalculator;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		landRegisterNumberCalculator = (LandRegisterNumberCalculator) context.getBean("landRegisterNumberCalculator");
	}

	@Test
	public void test() {

/*		Tests for getting control sum of whole land register number
 * 		To make them possible please remove modulo operation for return statement in landRegisterNumberCalculator.getKwNoValue()
 * 
		landRegisterNumberCalculator.setLandRegisterNumber("S");
		assertEquals(28, landRegisterNumberCalculator.getKwNoValue());
		
		landRegisterNumberCalculator.setLandRegisterNumber("G");
		assertEquals(17, landRegisterNumberCalculator.getKwNoValue());
		
		landRegisterNumberCalculator.setLandRegisterNumber("sr1");
		assertEquals(116, landRegisterNumberCalculator.getKwNoValue());
		
		landRegisterNumberCalculator.setLandRegisterNumber("SR1W");
		assertEquals(147, landRegisterNumberCalculator.getKwNoValue());
		
		landRegisterNumberCalculator.setLandRegisterNumber("SR1W/");
		assertEquals(147, landRegisterNumberCalculator.getKwNoValue());
		
		landRegisterNumberCalculator.setLandRegisterNumber("SR1W/1");
		assertEquals(154, landRegisterNumberCalculator.getKwNoValue());
		
		landRegisterNumberCalculator.setLandRegisterNumber("SR1W/0004547");
		assertEquals(241, landRegisterNumberCalculator.getKwNoValue());
		
		landRegisterNumberCalculator.setLandRegisterNumber("PT1T/00203024");
		assertEquals(206, landRegisterNumberCalculator.getKwNoValue());
	
		landRegisterNumberCalculator.setLandRegisterNumber("BY1T/12345678");
		assertEquals(294, landRegisterNumberCalculator.getKwNoValue());
*/		
		landRegisterNumberCalculator.setLandRegisterNo("SR1W/0004547");
		assertEquals(1, landRegisterNumberCalculator.getKwNoValue());
		
		landRegisterNumberCalculator.setLandRegisterNo("PT1T/00203024");
		assertEquals(6, landRegisterNumberCalculator.getKwNoValue());
	
		landRegisterNumberCalculator.setLandRegisterNo("BY1T/12345678");
		assertEquals(4, landRegisterNumberCalculator.getKwNoValue());
		
	}

}
