package com.tools;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.Map;

public class Checkout {

	// Map to store tool information
	private static Map<String, Tools> toolMap = new HashMap<>();

	// Static block to initialize tool map with tool information like tool code,
	// tool, charge
	static {
		// Initializing tools
		Tools ladder = new Tools("LADW", "Ladder", "Werner", 1.99, true, true, false);
		Tools chainsaw = new Tools("CHNS", "Chainsaw", "Stihl", 1.49, true, false, true);
		Tools jackhammerDeWalt = new Tools("JAKD", "Jackhammer", "DeWalt", 2.99, true, false, false);
		Tools jackhammerRidgid = new Tools("JAKR", "Jackhammer", "Ridgid", 2.99, true, false, false);

		// Adding tools to the map with tool code and corresponding tool info
		toolMap.put("LADW", ladder);
		toolMap.put("CHNS", chainsaw);
		toolMap.put("JAKD", jackhammerDeWalt);
		toolMap.put("JAKR", jackhammerRidgid);
	}

	// Public method to check if tool code is valid
	public static boolean isValidToolCode(String toolCode) {
		return toolMap.containsKey(toolCode);
	}

	// Checkout method that takes tool code, rental days, discount Percent, checkout
	// Date
	public static RentalAgreement checkout(String toolcode, int rentaldays, int discountpercent,
			LocalDate checkoutdate) {
		if (rentaldays < 1) {
			throw new IllegalArgumentException("Rental day count must be 1 or greater");
		}
		if (discountpercent < 0 || discountpercent > 100) {
			throw new IllegalArgumentException("Discount percent must be in the range 0-100");
		}
		// Retrieve tool from map using tool code
		Tools tool = toolMap.get(toolcode);

		LocalDate duedate = checkoutdate.plusDays(rentaldays);
		int chargedays = calculateChargeDays(checkoutdate, duedate, tool);
		double prediscountcharge = chargedays * tool.getDailyCharge();
		double discountamount = prediscountcharge * discountpercent / 100.0;
		double finalcharge = prediscountcharge - discountamount;

		return new RentalAgreement(toolcode, tool.getToolType(), tool.getBrand(), rentaldays, checkoutdate, duedate,
				tool.getDailyCharge(), chargedays, prediscountcharge, discountpercent, discountamount, finalcharge);
	}

	// Method to calculate the number of chargeable days
	private static int calculateChargeDays(LocalDate checkoutDate, LocalDate dueDate, Tools tool) {
		int chargeDays = 0;

		for (LocalDate date = checkoutDate.plusDays(1); !date.isAfter(dueDate); date = date.plusDays(1)) {
			if (isChargeableDay(date, tool)) {
				chargeDays++;
			}
		}

		return chargeDays;
	}

	// Method to determine if a given day is chargeable based on the tool's charging
	// rules
	private static boolean isChargeableDay(LocalDate date, Tools tool) {
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		boolean isWeekend = (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY);
		boolean isHoliday = isHoliday(date);

		// Check if the day is not chargeable due to being a holiday or weekend
		if ((isHoliday && !tool.isHolidayCharge()) || (isWeekend && !tool.isWeekendCharge())) {
			return false;
		}
		// Check if the day is chargeable as a weekday
		return tool.isWeekdayCharge() || (!isWeekend && !isHoliday);
	}

	// Method to determine if a given date is a holiday
	private static boolean isHoliday(LocalDate date) {
		// Calculate Independence Day and observe it on closest weekday if it falls on a
		// weekend
		LocalDate independenceDay = LocalDate.of(date.getYear(), Month.JULY, 4);
		if (independenceDay.getDayOfWeek() == DayOfWeek.SATURDAY) {
			independenceDay = independenceDay.minusDays(1);
		} else if (independenceDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
			independenceDay = independenceDay.plusDays(1);
		}

		LocalDate laborDay = LocalDate.of(date.getYear(), Month.SEPTEMBER, 1)
				.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

		return date.equals(independenceDay) || date.equals(laborDay);
	}

}
