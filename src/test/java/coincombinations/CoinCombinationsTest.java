package coincombinations;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoinCombinationsTest {
	
	private CoinCombinations coinCombinations;
	
	@BeforeEach
	public void setUp() {
		coinCombinations = new CoinCombinations();
	}
	
	@Test
	public void thorwExceptionWhenInputMinusAmount() {
		int amount = -3;
		Assertions.assertThatThrownBy(() -> {
			coinCombinations.calculateCombo(amount);
		}).isInstanceOf(IllegalArgumentException.class);
//		.hasMessageContaining("Negative amount not allowed!");
		/*
		IllegalArgumentException thrown = 
				Assertions.catchThrowableOfType(() -> coinCombinations.calculateCombo(amount), IllegalArgumentException.class);
		assertThat(thrown).hasMessage("Negative amount not allowed!");
		*/
	}

	@Test
	public void testForAmountZero() {
		int amount = 0;
		int numberOfCombos = coinCombinations.calculateCombo(amount);
		assertThat(numberOfCombos)
		.as("amount: %d", amount)
		.isEqualTo(1);
	}
	
	@Test
	public void testForAmountOne() {
		int amount = 1;
		int numberOfCombos = coinCombinations.calculateCombo(amount);
		assertThat(numberOfCombos)
		.as("amount: %d", amount)
		.isEqualTo(1);
	}
	
	@Test
	public void testForAmountTwo() {
		int amount = 2;
		int numberOfCombos = coinCombinations.calculateCombo(amount);
		assertThat(numberOfCombos)
		.as("amount: %d", amount)
		.isEqualTo(2);
	}
	
	@Test
	public void testForAmountThree() {
		int amount = 3;
		int numberOfCombos = coinCombinations.calculateCombo(amount);
		assertThat(numberOfCombos)
			.as("amount: %d", amount)
			.isEqualTo(2);
	}
	
	@Test
	public void testForAmountFour() {
		int amount = 4;
		int numberOfCombos = coinCombinations.calculateCombo(amount);
		assertThat(numberOfCombos)
		.as("amount: %d", amount)
		.isEqualTo(3);
	}
	
	@Test
	public void testForAmountFive() {
		int amount = 5;
		int numberOfCombos = coinCombinations.calculateCombo(amount);
		assertThat(numberOfCombos)
		.as("amount: %d", amount)
		.isEqualTo(3);
	}
	
}
