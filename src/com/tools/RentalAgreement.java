package com.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//RentalAgreement class represents the rental agreement details for a tool.
public class RentalAgreement {

	private String toolCode;
	private String toolType;
	private String brand;
	private int rentaldays;
	private LocalDate checkoutdate;
	private LocalDate duedate;
	private double dailyrentalcharge;
	private int chargedays;
	private double prediscountcharge;
	private int discountpercent;
	private double discountamount;
	private double finalcharge;

	public RentalAgreement(String toolCode, String toolType, String brand, int rentalDays, LocalDate checkoutDate,
			LocalDate dueDate, double dailyRentalCharge, int chargeDays, double preDiscountCharge, int discountPercent,
			double discountAmount, double finalCharge) {
		this.toolCode = toolCode;
		this.toolType = toolType;
		this.brand = brand;
		this.rentaldays = rentalDays;
		this.checkoutdate = checkoutDate;
		this.duedate = dueDate;
		this.dailyrentalcharge = dailyRentalCharge;
		this.chargedays = chargeDays;
		this.prediscountcharge = preDiscountCharge;
		this.discountpercent = discountPercent;
		this.discountamount = discountAmount;
		this.finalcharge = finalCharge;
	}

	// Getter methods for each attribute
	public String getToolCode() {
		return toolCode;
	}

	public String getToolType() {
		return toolType;
	}

	public String getBrand() {
		return brand;
	}

	public int getRentaldays() {
		return rentaldays;
	}

	public LocalDate getCheckoutdate() {
		return checkoutdate;
	}

	public LocalDate getDuedate() {
		return duedate;
	}

	public double getDailyrentalcharge() {
		return dailyrentalcharge;
	}

	public int getChargedays() {
		return chargedays;
	}

	public double getPrediscountcharge() {
		return prediscountcharge;
	}

	public int getDiscountpercent() {
		return discountpercent;
	}

	public double getDiscountamount() {
		return discountamount;
	}

	public double getFinalcharge() {
		return finalcharge;
	}

	// Method to print the rental agreement details in a formatted way.
	public void print() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
		System.out.printf("Tool code: %s%n", toolCode);
		System.out.printf("Tool type: %s%n", toolType);
		System.out.printf("Tool brand: %s%n", brand);
		System.out.printf("Rental days: %d%n", rentaldays);
		System.out.printf("Check out date: %s%n", checkoutdate.format(formatter));
		System.out.printf("Due date: %s%n", duedate.format(formatter));
		System.out.printf("Daily rental charge: $%.2f%n", dailyrentalcharge);
		System.out.printf("Charge days: %d%n", chargedays);
		System.out.printf("Pre-discount charge: $%.2f%n", prediscountcharge);
		System.out.printf("Discount percent: %d%%%n", discountpercent);
		System.out.printf("Discount amount: $%.2f%n", discountamount);
		System.out.printf("Final charge: $%.2f%n", finalcharge);
	}

}
