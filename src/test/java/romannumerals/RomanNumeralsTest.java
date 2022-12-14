package romannumerals;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanNumeralsTest {

	@Test
	void testOne() {
		assertThat(RomanNumerals.arabicToRoman(1)).isEqualTo("I");
	}
	
	@Test
	public void testOneTwo() {
    	SoftAssertions assertions = new SoftAssertions();
    	assertions.assertThat(RomanNumerals.arabicToRoman(1)).isEqualTo("I");
    	assertions.assertThat(RomanNumerals.arabicToRoman(2)).isEqualTo("II");
    	assertions.assertAll();
	}

	@Test
	public void testOneTwoThree() {
		SoftAssertions assertions = new SoftAssertions();
		assertions.assertThat(RomanNumerals.arabicToRoman(1)).isEqualTo("I");
		assertions.assertThat(RomanNumerals.arabicToRoman(2)).isEqualTo("II");
		assertions.assertThat(RomanNumerals.arabicToRoman(3)).isEqualTo("III");
		assertions.assertAll();
	}
	
	@Test
	public void testFour() {
		assertThat(RomanNumerals.arabicToRoman(4)).isEqualTo("IV");
	}
	
	@Test
	public void testFive() {
		assertThat(RomanNumerals.arabicToRoman(5)).isEqualTo("V");
	}
	
	@Test
	public void testSix() {
		assertThat(RomanNumerals.arabicToRoman(6)).isEqualTo("VI");
	}
	
	@Test
	public void testNineIsXPrefixedByI() {
		assertThat(RomanNumerals.arabicToRoman(9)).isEqualTo("IX");
	}
	
	@Test
	public void test2022() {
		assertThat(RomanNumerals.arabicToRoman(2022)).isEqualTo("MMXXII");
	}
	
}
