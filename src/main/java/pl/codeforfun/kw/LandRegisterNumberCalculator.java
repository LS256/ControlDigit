package pl.codeforfun.kw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	@Service("landRegisterNumberCalculator")
public class LandRegisterNumberCalculator 
{
	@Autowired
	private SingleCharValues singleCharValue;
	
	@Autowired
	private LrNumberChecker lrNumberChecker;
	
	private  String landRegisterNo;
	
	//	Values for multiplying operation
	private int[] multiplyers = {1, 3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7};
	
	/*
	 * Setter method for land register number
	 * in addition in this method we customize land register number to it's pattern - that finally it has correct length
	 * @param landRegisterNo - number of land register book to be set 
	 */
	public void setLandRegisterNo(String landRegisterNo){
			this.landRegisterNo =  lrCustomizator(landRegisterNo);
	}

	/*
	 * for proper calculation, land register number given by user must be checked and customized to it's pattern
	 * @param forCustomization - land register number given by the user
	 * @return customized land register number
	 */
	private String lrCustomizator(String forCustomization) {
		String tempLrNo="";
		lrNumberChecker.setLrNumber(forCustomization);
		
		if(lrNumberChecker.isProperNumber()){
			for(int i=0; i<forCustomization.length(); i++) {
				if(forCustomization.charAt(i) == '/'){
					//	pattern of land register number consists 13 characters
					for(int j=0; j<(13-forCustomization.length());j++){
						tempLrNo+="0";
					}
				} else {
					tempLrNo += forCustomization.charAt(i);
				}
			}
			return tempLrNo;
		} else {
			return "0";
		}
	}
	/*
	 * Getter of land register control digit
	 * control digit is a modulo by 10 of all components sum 
	 * @return value of control digit
	 */
	public int getKwNoValue() {
		int totalSum = 0;
		for(int i=0; i<landRegisterNo.length(); i++) {
			int charValue = multiplyers[i] * singleCharValue.getCharValue(landRegisterNo.substring(i, i+1));
			totalSum += charValue;
		}
		return totalSum % 10;
	}
}
