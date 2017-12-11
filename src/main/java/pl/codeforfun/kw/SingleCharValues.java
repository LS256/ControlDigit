package pl.codeforfun.kw;

import org.springframework.stereotype.Service;

@Service("singleCharValue")
public class SingleCharValues {
	
	public enum CharValues{
		X(10), A(11), B(12), C(13), D(14), E(15), F(16), G(17), H(18), I(19), J(20), K(21), L(22), M(23), 
		N(24), O(25), P(26), R(27), S(28), T(29), U(30), W(31), Y(32), Z(33);		
		int charValue;
		
		CharValues(int charValue){
			this.charValue = charValue;
		}
		
		public int getValue(){
			return charValue;
		}
	}
	
	/*
	 * Method which give integer representation of askedSymbol
	 * @param askedSymbol - single character of land register number
	 * @return value of asked symbol. If askedSymbol is integer in range 0-9 then we return integer value of askedSymbol. 
	 * @return value of asked symbol. If askedSymbol is declared enum then we return value of this enum
	 * @return value of asked symbol. If asked symbol is not out of range for example £, Ó, @, 123, 10 etc. then we return error value equlas to 256 
	 * 
	 */
	public int getCharValue(String askedSymbol){
	try {
			if(askedSymbol.length() == 1 & !isInteger(askedSymbol)) {
					return CharValues.valueOf(askedSymbol.toUpperCase()).getValue();
			} else if(askedSymbol.length() == 1 & isInteger(askedSymbol)) {
				return Integer.parseInt(askedSymbol);
			} else return 256;
		} catch (Exception e) {
			return 256;
		}
	}
	
	/*
	 * Check if asked char is integer or not
	 * @param askedSymbol - single character of land register number
	 * @return true if asked char is integer otherwise false
	 */
	private boolean isInteger(String askedSymbol) {
		try {
			Integer.parseInt(askedSymbol);
		} catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
		//	Only if askedChar is number we can return true
		return true;
	}
	

}
