package coinminimum;

public class CoinMinimum {
	
	private int[] coins = {1,2,5,10};

	public int calculate(int amount) throws IllegalArgumentException {
		if (amount < 0) {
			throw new IllegalArgumentException("Negative amount not allowed!");
		}
		else if (amount == 0) {
			return 0;
		}
		else {
			return calculateImpl(amount, 0);
		}
	}
	
	public int calculateImpl(int amount, int currentIndex) {
		if (amount == 0) {
			return 0;
		}
		
		int result = Integer.MAX_VALUE;
		
		for (int i = currentIndex; i<coins.length; i++) {
			if (coins[i] <= amount) {
				int subResult = calculateImpl(amount-coins[i], i);
				if (subResult != Integer.MAX_VALUE && subResult+1 < result) {
					result = subResult+1;
				}
			}
		}
		
		return result;
	}

}
