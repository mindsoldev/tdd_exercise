package refactoringmf.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
    	String result = "<!DOCTYPE html>\n";
    	result += "<html>\n";
    	result += "<body>\n";
    	result += "\n";
    	result += "<Hl>Rentals for <EM>" + getName() + "</EM></Hl><P>\n" ;
    	for (Rental rental : rentals) {
    		result += rental.getMovie().getTitle()+ ": " + String.valueOf(rental.getCharge()) + "<BR>\n";
    	}
    	
    	result += "<P>You owed is <EM>" + String.valueOf(getTotalCharge () ) + "</EM><P>\n";
		result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints() ) + "</EM> frequent renter points<P>";    	

		result += "\n\n";
    	result += "</body>\n";
    	result += "</html>\n";

		return result;
    }
    
    private double getTotalCharge() {
    	double result = 0;
        for (Rental rental : rentals) {
        	result += rental.getCharge();
        }
    	return result;
    }
    
    private int getTotalFrequentRenterPoints() {
    	int result = 0;
    	for (Rental rental : rentals) {
    		result += rental.getFrequentRenterPoints();
    	}
    	return result;
    }
    
}
