package coinminimum;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoinMinimumTest {
	
	CoinMinimum coinMinimum;
	
	@BeforeEach
	public void setUp() {
		coinMinimum = new CoinMinimum();
	}
	
	@Test
	public void testAmountNegative() {
		int amount = -3;
		assertThatThrownBy(() -> {
			assertThat(coinMinimum.calculate(amount));
		}).isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void testAmountIs0() {
		int amount = 0;
		assertThat(coinMinimum.calculate(amount)).isEqualTo(0);
	}

	@Test
	public void testAmountIs1() {
		int amount = 1;
		assertThat(coinMinimum.calculate(amount)).isEqualTo(1);
	}
	
	@Test
	public void testAmountIs2() {
		int amount = 2;
		assertThat(coinMinimum.calculate(amount)).isEqualTo(1);
	}
	
	@Test
	public void testAmountIs3() {
		int amount = 3;
		assertThat(coinMinimum.calculate(amount)).as("amount: " + amount).isEqualTo(2);
	}
	
	@ParameterizedTest
	// érmék: 1,2
//	@CsvSource({"0,0", "1,1", "2,1", "3,2", "4,2", "5,3", "6,3", "7,4", "8,4", "9,5", "10,5"})
	// érmék: 1,2,5
//	@CsvSource({"0,0", "1,1", "2,1", "3,2", "4,2", "5,1", "6,2", "7,2", "8,3", "9,3", "10,2"})
	// érmék: 1,2,5,10
	@CsvSource({"0,0", "1,1", "2,1", "3,2", "4,2", "5,1", "6,2", "7,2", "8,3", "9,3", "10,1"})
	public void testFromCvs(int amount, int coins) {
		assertThat(coinMinimum.calculate(amount)).as("amount: " + amount).isEqualTo(coins);
	}
	
}
