import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	private final Customer customer = new Customer("Leon");
	
	private final Movie movieRegular = new Movie("L.A. Crash", Movie.REGULAR);
	private final Movie movieNew = new Movie("The Incredibles 2", Movie.NEW_RELEASE);
	private final Movie movieChildren = new Movie("Barbie: Mariposa", Movie.CHILDRENS);
	
	private final Rental rentalRegular = new Rental(movieRegular, 10);
	private final Rental rentalNew = new Rental(movieNew, 5);
	private final Rental rentalChildren = new Rental(movieChildren, 7);
	
	@Test
	public void nameTest() {
		assertEquals("Leon", customer.getName());
	}
	
	@Test
	public void statementTest(){
		String sRightComparison = "Rental Record for " + customer.getName() + "\n" +
									"\tTitle\t\tDays\tAmount\n" +
									"Amount owed is 0.0\n" +
									"You earned 0 frequent renter points";
		
		assertEquals(sRightComparison, customer.statement());
	}
	
	@Test
	public void rentalTest(){
		String string = "Rental Record for " + customer.getName() + "\n" +
				"\tTitle\t\tDays\tAmount\n" +
				"\tL.A. Crash\t\t10\t14.0\n" +
				"\tThe Incredibles 2\t\t5\t15.0\n" +
				"\tBarbie: Mariposa\t\t7\t7.5\n" +
				"Amount owed is 36.5\n" +
				"You earned 4 frequent renter points";
		
		customer.addRental(rentalRegular);
		customer.addRental(rentalNew);
		customer.addRental(rentalChildren);
		
		assertEquals(string, customer.statement());
	}

}
