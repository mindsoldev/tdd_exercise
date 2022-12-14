package fizzbuzz;

public class FizzBuzz {

	private static final String FIZZ = "Fizz";
	private static final String BUZZ = "Buzz";

	public static String convert(int input) {
		
		for (Rules rule : Rules.values()) {
			if (input % rule.number == 0)
				return rule.output;
		}
		
		return String.valueOf(input);
	}
	
	enum Rules {
		FIFTEEN(15, FIZZ + BUZZ),
		FIVE(5, BUZZ),
		THREE(3, FIZZ);

		private final int number;
		private final String output;

		Rules(int number, String output) {
			this.number = number;
			this.output = output;
		}
		
	}

}
