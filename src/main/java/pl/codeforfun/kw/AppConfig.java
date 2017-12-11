package pl.codeforfun.kw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public LandRegisterNumberCalculator landRegisterNo(){	
		return new LandRegisterNumberCalculator();
	}
	
	@Bean
	public SingleCharValues singleCharValue() {
		return new SingleCharValues();
	}
	
	@Bean
	public LrNumberChecker lrNumberChecker() {
		return new LrNumberChecker();
	}
	
	
}