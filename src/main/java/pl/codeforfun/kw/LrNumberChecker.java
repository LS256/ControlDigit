package pl.codeforfun.kw;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service("lrNumberChecker")
public class LrNumberChecker {

	private String lrNumber;
	
	/*
	 * set land register number
	 */
	public void setLrNumber(String lrNumber) {
		this.lrNumber = lrNumber;
	}

	/* Check if land register number given by user fir to general pattern of land register number
	 * @return true if number fits to pattern, otherwise false
	 */
	public boolean isProperNumber() {
		String regex = "[a-zA-Z]{2}[0-9a-zA-z]{1}[a-zA-z]{1}\\/{1}[0-9]{3,8}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(lrNumber);
		return matcher.matches();
	}
}
