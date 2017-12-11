package pl.codeforfun.kw;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ControlDigitApp {
	private static final Logger logger = LogManager.getLogger(ControlDigitApp.class);
	private static Scanner scan;
	
	public static void main(String[] args) { 
		
/*		This code snippet is working with beans configured in file with @Configuration annotation
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		LandRegisterNumberCalculator lrnc = (LandRegisterNumberCalculator)  context.getBean("landRegisterNo");
		lrnc.setLandRegisterNo("SR1W/045471");
		logger.info("Control digit is: {}", lrnc.getKwNoValue());
*/

/*		Commented code snippet is working with beans configured in XMLfile
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		LandRegisterNumberCalculator lrnc = (LandRegisterNumberCalculator)  context.getBean("landRegisterNumberCalculatorBean");
		logger.info("wynik: {}", lrnc.getKwNoValue());
*/
		
//	Commented code snippet is working with beans configured by @Service annotation
		//	Initialization of beans
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		LandRegisterNumberCalculator controlDigit = (LandRegisterNumberCalculator) context.getBean("landRegisterNumberCalculator");
		LrNumberChecker lrNumberChecker = (LrNumberChecker) context.getBean("lrNumberChecker");
		
		
		scan = new Scanner(System.in);
		String userCommand="";
		while(!userCommand.equals("X")){
			logger.info("Podaj numer KW");
			String userSelection = scan.nextLine();
			lrNumberChecker.setLrNumber(userSelection);
				if(lrNumberChecker.isProperNumber()){
					logger.info("Wprodzono nastêpuj¹cy numer KW:{}", userSelection);
					controlDigit.setLandRegisterNo(userSelection);
					logger.info("Dla wprowadzonego nr KW, cyfra kontrolna wynosi: {}", controlDigit.getKwNoValue());
				} else {
					logger.info("Wprowadzono nieprawid³owy numner KW!!");
				}
			logger.info("Aby zakoñczyæ wybierz X, aby kontynuowaæ wiœnij dowolny klawisz.");
			userCommand = scan.nextLine().toUpperCase();
		}
		

	}
}
