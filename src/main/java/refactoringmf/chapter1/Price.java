package refactoringmf.chapter1;

public abstract class Price {

	abstract int getPriceCode();

	abstract public double getCharge(int daysRented);

	int getFrequentRenterPoints(Movie movie, int daysRented) {
		return getFrequentRenterPoints(daysRented);
	}

	int getFrequentRenterPoints(int daysRented) {
		return 1;
	}
	
}
