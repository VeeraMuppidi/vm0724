package com.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class RentalToolApplication {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String toolCode;
		int rentalDays = 0;
		int discountPercent = 0;
		LocalDate checkoutDate = null;

		// user input for tool code and validate
		while (true) {
			System.out.print("Enter tool code (LADW, CHNS, JAKD, JAKR): ");
			toolCode = scanner.nextLine();
			if (Checkout.isValidToolCode(toolCode)) {
				break;
			} else {
				System.out.println("Invalid tool code. Please enter one of the following: LADW, CHNS, JAKD, JAKR.");
			}
		}

		// user input for rental days and validate
		while (true) {
			System.out.print("Enter rental days: ");
			if (scanner.hasNextInt()) {
				rentalDays = scanner.nextInt();
				if (rentalDays > 0) {
					break;
				} else {
					System.out.println("Rental days must be 1 or greater. Please enter again.");
				}
			} else {
				System.out.println("Invalid input. Please enter a valid number for rental days.");
				scanner.next(); // Clear invalid input
			}
		}

		//user input for discount percent and validate
		while (true) {
			System.out.print("Enter discount percent: ");
			if (scanner.hasNextInt()) {
				discountPercent = scanner.nextInt();
				if (discountPercent >= 0 && discountPercent <= 100) {
					break;
				} else {
					System.out.println("Discount percent must be in the range 0-100. Please enter again.");
				}
			} else {
				System.out.println("Invalid input. Please enter a valid number for discount percent.");
				scanner.next(); 
			}
		}

		//user input for checkout date and validate
		scanner.nextLine();
		while (true) {
			System.out.print("Enter checkout date (yyyy-mm-dd): ");
			String checkoutDateStr = scanner.nextLine();
			try {
				checkoutDate = LocalDate.parse(checkoutDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
				break;
			} catch (DateTimeParseException e) {
				System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format.");
			}
		}

		try {
			// Perform checkout
			RentalAgreement agreement = Checkout.checkout(toolCode, rentalDays, discountPercent, checkoutDate);

			// Displaying rental agreement
			agreement.print();
			;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}

	}

}
