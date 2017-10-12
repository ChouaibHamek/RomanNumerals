
public class RomanNumerals {
	
	private int convertDigit(char c) {
		switch(c) {
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return -1;
		}
	}
	
	public boolean checkValidity(String romanNum) {
		// empty strings are not valid, we check for the input validity using this nice pattern :)
		return (romanNum.length()!=0 && romanNum.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"));
	}
	
	public int convertToInteger(String romanNum) throws InvalidInputException {
		int arabicNum = 0;
		if (!checkValidity(romanNum)) {
			throw new InvalidInputException();
		} else {
			// the input is valid and not empty - no zero in Roman numbers
			int i=0;
			while (i<romanNum.length()) {
				if (i+1 < romanNum.length()) {
					if (romanNum.charAt(i) == 'I' && romanNum.charAt(i+1) == 'V') {
						arabicNum+= 4;
						i+=2;
					}
					else if (romanNum.charAt(i) == 'I' && romanNum.charAt(i+1) == 'X') {
						arabicNum+= 9;
						i+=2;
					}
					else if (romanNum.charAt(i) == 'X' && romanNum.charAt(i+1) == 'L') {
						arabicNum+=40;
						i+=2;
					}
					else if (romanNum.charAt(i) == 'X' && romanNum.charAt(i+1) == 'C') {
						arabicNum+= 90;
						i+=2;
					}
					else if (romanNum.charAt(i) == 'C' && romanNum.charAt(i+1) == 'D') {
						arabicNum+=400;	
						i+=2;
					}
					else if (romanNum.charAt(i) == 'C' && romanNum.charAt(i+1) == 'M') {
						arabicNum+= 900;
						i+=2;
					}
					else {
						arabicNum+= convertDigit(romanNum.charAt(i));
						i++;
					}
				} else {
					arabicNum+= convertDigit(romanNum.charAt(i));
					i++;
				}
			}
		}
		return arabicNum;
	}
}
