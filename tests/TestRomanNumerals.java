import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {
	
	// Tests for the input validity feature.
	@Test
	public void testInvalid_empty() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity(""));
	}
	
	@Test
	public void testInvalid_numeric() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("01112145"));
	}
	
	@Test
	public void testInvalid_letter() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("arabic letters are fun"));
	}
	
	@Test
	public void testInvalid_specialLetter() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("##$@!#$!@#"));
	}
	
	@Test
	public void testInvalid_rule1_1() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("IIIIC"));
	}
	
	@Test
	public void testInvalid_rule1_2() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("XXXXC"));
	}
	
	@Test
	public void testInvalid_rule1_3() {
		RomanNumerals RNum = new RomanNumerals();	
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("CCCCD"));
	}
	
	@Test
	public void testInvalid_rule2_1() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("IVV"));
	}
	
	@Test
	public void testInvalid_rule2_2() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("LLI"));
	}
	
	@Test
	public void testInvalid_rule2_3() {
		RomanNumerals RNum = new RomanNumerals();	
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("XDDI"));
	}
	
	@Test
	public void testInvalid_rule3_1() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("IL"));
	}
	
	@Test
	public void testInvalid_rule3_2() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("XD"));
	}
	
	@Test
	public void testInvalid_rule4_1() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("XXC"));
	}
	
	@Test
	public void testInvalid_rule4_2() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("IIV"));
	}
	
	@Test
	public void testInvalid_rule4_3() {
		RomanNumerals RNum = new RomanNumerals();	
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("CCM"));
	}
	
	@Test
	public void testInvalid_rule5_1() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("VC"));
	}
	
	@Test
	public void testInvalid_rule5_2() {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("LC"));
	}
	
	@Test
	public void testInvalid_rule5_3() {
		RomanNumerals RNum = new RomanNumerals();	
		assertEquals("Failed to detect invalid input", false, RNum.checkValidity("DM"));
	}
	
	@Test
	public void testValid_1() {
		RomanNumerals RNum = new RomanNumerals();	
		assertEquals("Failed to accept valid input", true , RNum.checkValidity("LXXX"));
	}
	
	@Test
	public void testValid_2() {
		RomanNumerals RNum = new RomanNumerals();	
		assertEquals("Failed to accept valid input", true , RNum.checkValidity("CM"));
	}
	
	@Test
	public void testValid_3() {
		RomanNumerals RNum = new RomanNumerals();	
		assertEquals("Failed to accept valid input", true , RNum.checkValidity("MCMLXXXIV"));
	}
	
	@Test
	public void testValid_4() {
		RomanNumerals RNum = new RomanNumerals();	
		assertEquals("Failed to accept valid input", true , RNum.checkValidity("MMXIV"));
	}
	
	@Test
	public void testValid_5() {
		RomanNumerals RNum = new RomanNumerals();	
		assertEquals("Failed to accept valid input", true , RNum.checkValidity("MMM"));
	}
	
	@Test (expected = InvalidInputException.class)
	public void testConversion_InvalidInput_1() throws InvalidInputException {
		RomanNumerals RNum = new RomanNumerals();	
		RNum.convertToInteger("XDDI");
	}
	
	@Test (expected = InvalidInputException.class)
	public void testConversion_InvalidInput_2() throws InvalidInputException {
		RomanNumerals RNum = new RomanNumerals();
		RNum.convertToInteger("XXC");
	}
	
	@Test (expected = InvalidInputException.class)
	public void testConversion_InvalidInput_3() throws InvalidInputException {
		RomanNumerals RNum = new RomanNumerals();
		RNum.convertToInteger("VC");
	}
	
	@Test
	public void testConversion_ValidInput_1() throws InvalidInputException {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to convert correctly", 6, RNum.convertToInteger("VI"));
	}
	
	@Test
	public void testConversion_ValidInput_2() throws InvalidInputException {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to convert correctly", 14, RNum.convertToInteger("XIV"));
	}
	
	@Test
	public void testConversion_ValidInput_3() throws InvalidInputException {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to convert correctly", 79, RNum.convertToInteger("LXXIX"));
	}
	
	@Test
	public void testConversion_ValidInput_4() throws InvalidInputException {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to convert correctly", 999, RNum.convertToInteger("CMXCIX"));
	}
	
	@Test
	public void testConversion_ValidInput_5() throws InvalidInputException {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to convert correctly", 2017, RNum.convertToInteger("MMXVII"));
	}
	
	@Test
	public void testConversion_ValidInput_6() throws InvalidInputException {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to convert correctly", 3999, RNum.convertToInteger("MMMCMXCIX"));
	}
	@Test
	public void testConversion_ValidInput_7() throws InvalidInputException {
		RomanNumerals RNum = new RomanNumerals();
		assertEquals("Failed to convert correctly", 2647, RNum.convertToInteger("MMDCXLVII"));
	}
}
