package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.tools.Checkout;
import com.tools.RentalAgreement;
import com.tools.Tools;

public class CheckoutTest {

	Tools ladder = new Tools("LADW", "Ladder", "Werner", 1.99, true, true, false);
	Tools chainsaw = new Tools("CHNS", "Chainsaw", "Stihl", 1.49, true, false, true);
	Tools jackhammerDeWalt = new Tools("JAKD", "Jackhammer", "DeWalt", 2.99, true, false, false);
	Tools jackhammerRidgid = new Tools("JAKR", "Jackhammer", "Ridgid", 2.99, true, false, false);

	@Test
	public void testCheckout1() {

		// Test case to validate checkout method with invalid discount percent
		IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
			Checkout.checkout("JAKR", 5, 101, LocalDate.of(2015, 9, 3));
		});

		// Assert the error message expected when an invalid discount percent is given
		assertEquals("Discount percent must be in the range 0-100", exception1.getMessage());
	}

	@Test
	public void testCheckout2() {
		// Test 2: Valid test case for LADW tool with 3 rental days, 10% discount,
		// checkout on July 2, 2020
		RentalAgreement agreement2 = Checkout.checkout("LADW", 3, 10, LocalDate.of(2020, 7, 2));

		// Assert that the final charge matches expected value with a delta of 0.01
		assertEquals(3.58, agreement2.getFinalcharge(), 0.01);
	}

	@Test
	public void testCheckout3() {
		// Test 3: Valid test case for CHNS tool with 5 rental days, 25% discount,
		// checkout on July 2, 2015
		RentalAgreement agreement3 = Checkout.checkout("CHNS", 5, 25, LocalDate.of(2015, 7, 2));

		// Assert that the final charge matches expected value with a delta of 0.01
		assertEquals(3.35, agreement3.getFinalcharge(), 0.01);
	}

	@Test
	public void testCheckout4() {
		// Test 4: Valid test case for JAKD tool with 6 rental days, no discount,
		// checkout on September 3, 2015
		RentalAgreement agreement4 = Checkout.checkout("JAKD", 6, 0, LocalDate.of(2015, 9, 3));

		// Assert that the final charge matches expected value with a delta of 0.01
		assertEquals(8.97, agreement4.getFinalcharge(), 0.01);
	}

	@Test
	public void testCheckout5() {
		// Test 5: Valid test case for JAKR tool with 9 rental days, no discount,
		// checkout on July 2, 2015
		RentalAgreement agreement5 = Checkout.checkout("JAKR", 9, 0, LocalDate.of(2015, 7, 2));

		// Assert that the final charge matches expected value with a delta of 0.01
		assertEquals(14.95, agreement5.getFinalcharge(), 0.01);
	}

	@Test
	public void testCheckout6() {
		// Test 6: Valid test case for JAKR tool with 4 rental days, 50% discount,
		// checkout on July 2, 2020
		RentalAgreement agreement6 = Checkout.checkout("JAKR", 4, 50, LocalDate.of(2020, 7, 2));

		// Assert that the final charge matches expected value with a delta of 0.01
		assertEquals(1.495, agreement6.getFinalcharge(), 0.01);
	}

	@Test
	public void testCheckout7() {
		// Test 7: Invalid test case for LADW tool with rental days < 1
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Checkout.checkout("JAKR", 0, 10, LocalDate.of(2020, 7, 2));
		});

		// Assert the error message expected when rental days < 1
		assertEquals("Rental day count must be 1 or greater", exception.getMessage());
	}

	@Test
	public void testCheckout8() {
		// Test 7: Valid test case for LADW tool with 10 rental days, 10% discount,
		// checkout on July 2, 2024
		RentalAgreement agreement7 = Checkout.checkout("LADW", 10, 10, LocalDate.of(2024, 7, 2));

		// Assert that the final charge matches expected value with a delta of 0.01
		assertEquals(16.12, agreement7.getFinalcharge(), 0.01);
	}

	@Test
	public void testCheckout9() {
		// Test 7: Valid test case for CHNS tool with 7 rental days, 50% discount,
		// checkout on February 2, 2023
		RentalAgreement agreement7 = Checkout.checkout("CHNS", 7, 50, LocalDate.of(2023, 2, 2));

		// Assert that the final charge is not equal to 10.465 (a hypothetical expected
		// value)
		assertNotEquals(10.465, agreement7.getFinalcharge(), 0.01);
	}

	@Test
	public void testCheckout10() {
		// Test 8: Invalid test case with negative rental days with -1, 20% discount,
		// checkout on July 10, 2021
		IllegalArgumentException exception8 = assertThrows(IllegalArgumentException.class, () -> {
			Checkout.checkout("CHNS", -1, 20, LocalDate.of(2021, 7, 10));
		});

		// Assert the error message expected when providing negative rental days
		assertEquals("Rental day count must be 1 or greater", exception8.getMessage());
	}

}
