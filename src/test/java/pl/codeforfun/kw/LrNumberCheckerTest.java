package pl.codeforfun.kw;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LrNumberCheckerTest {

	ApplicationContext context;
	LrNumberChecker lrNumberChecker;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		lrNumberChecker = (LrNumberChecker) context.getBean("lrNumberChecker");
	}

	@Test
	public void test() {
		
		lrNumberChecker.setLrNumber("SR1W/000018");
		assertTrue(lrNumberChecker.isProperNumber());
		
		lrNumberChecker.setLrNumber("SR1W/01234568");
		assertTrue(lrNumberChecker.isProperNumber());
		
		lrNumberChecker.setLrNumber("SR22/0123A567");
		assertFalse(lrNumberChecker.isProperNumber());
		
		lrNumberChecker.setLrNumber("SR22/012345-8");
		assertFalse(lrNumberChecker.isProperNumber());
		
		lrNumberChecker.setLrNumber("SR22/0123456789");
		assertFalse(lrNumberChecker.isProperNumber());
	
	
	}

}



