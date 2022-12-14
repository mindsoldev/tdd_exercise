package coincombinations;

public class CoinCombinations {
	
	private int[] coins = {1,2};

	public int calculateCombo(int amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException("Negative amount not allowed!");
		}
		return calculateComboImpl(amount, 0);
	}

	public int calculateComboImpl(int amount, int currentIndex) {
		if (amount == 0) {
			return 1;
		}
		else if (amount < 0) {
			return 0;
		}
		
		int combos = 0;
		for (int i = currentIndex; i < coins.length; i++) {
			combos += calculateComboImpl(amount - coins[i], i);
		}
		return combos;
	}
	
	public static void main(String[] args) {
		int amount = 5;
		CoinCombinations coinCombinations = new CoinCombinations();
		int numberOfCombos = coinCombinations.calculateCombo(amount);
		System.out.printf("%d forintot %d módon lehet felbontani.", amount, numberOfCombos);
	}
}
