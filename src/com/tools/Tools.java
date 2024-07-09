package com.tools;

/*
  The Tools class represents a tool available for rental.
  Each tool instance has a unique tool code, tool type, brand, daily rental charge,
  and flags indicating whether it is chargeable on weekdays, weekends, and holidays.
 */
public class Tools {

	private String toolCode;
	private String toolType;
	private String brand;
	private double dailyCharge;
	private boolean weekdayCharge;
	private boolean weekendCharge;
	private boolean holidayCharge;

	public Tools(String toolCode, String toolType, String brand, double dailyCharge, boolean weekdayCharge,
			boolean weekendCharge, boolean holidayCharge) {
		this.toolCode = toolCode;
		this.toolType = toolType;
		this.brand = brand;
		this.dailyCharge = dailyCharge;
		this.weekdayCharge = weekdayCharge;
		this.weekendCharge = weekendCharge;
		this.holidayCharge = holidayCharge;
	}

	// getters and setters for attributes
	public String getToolCode() {
		return toolCode;
	}

	public void setToolCode(String toolCode) {
		this.toolCode = toolCode;
	}

	public String getToolType() {
		return toolType;
	}

	public void setToolType(String toolType) {
		this.toolType = toolType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getDailyCharge() {
		return dailyCharge;
	}

	public void setDailyCharge(double dailyCharge) {
		this.dailyCharge = dailyCharge;
	}

	public boolean isWeekdayCharge() {
		return weekdayCharge;
	}

	public void setWeekdayCharge(boolean weekdayCharge) {
		this.weekdayCharge = weekdayCharge;
	}

	public boolean isWeekendCharge() {
		return weekendCharge;
	}

	public void setWeekendCharge(boolean weekendCharge) {
		this.weekendCharge = weekendCharge;
	}

	public boolean isHolidayCharge() {
		return holidayCharge;
	}

	public void setHolidayCharge(boolean holidayCharge) {
		this.holidayCharge = holidayCharge;
	}

}
