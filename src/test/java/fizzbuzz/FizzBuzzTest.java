package fizzbuzz;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

	@Test
	void testReplayTheInputAsString() throws Exception {
		assertThat(FizzBuzz.convert(1)).isEqualTo("1");
		assertThat(FizzBuzz.convert(2)).isEqualTo("2");
	}
	
	@Test
	void testReplayFizz() throws Exception {
		assertThat(FizzBuzz.convert(3)).isEqualTo("Fizz");
		assertThat(FizzBuzz.convert(6)).isEqualTo("Fizz");
		assertThat(FizzBuzz.convert(9)).isEqualTo("Fizz");
	}
	
	@Test
	void testRReplayBuzz() throws Exception {
		assertThat(FizzBuzz.convert(5)).isEqualTo("Buzz");
		assertThat(FizzBuzz.convert(10)).isEqualTo("Buzz");
	}
	
	@Test
	void testReplayFizzBuzz() throws Exception {
		assertThat(FizzBuzz.convert(15)).isEqualTo("FizzBuzz");
		assertThat(FizzBuzz.convert(30)).isEqualTo("FizzBuzz");
	}
	
	@Test
	void testManualVerification() throws Exception {
		
		for (int i = 1; i <= 100; i++) {
			System.out.println(FizzBuzz.convert(i));
		}
	}
	
}
