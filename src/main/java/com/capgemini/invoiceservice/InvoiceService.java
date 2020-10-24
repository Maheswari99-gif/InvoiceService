package com.capgemini.invoiceservice;

public class InvoiceService {

	public static final double MINIMUM_COST_PER_KILOMETER = 10.0;
	public static final int COST_PER_TIME = 1;
	public static final double MINIMUM_FARE = 5.0;

	public double calculateFare(double distance, int time) {
		// TODO Auto-generated method stub
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + COST_PER_TIME * time;

		return Math.max(totalFare, MINIMUM_FARE);
	}

	public InvoiceSummary calculateFare(Ride[] rides) {
		// TODO Auto-generated method stub
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new InvoiceSummary(rides.length, totalFare);
	}

}
