package com.capgemini.invoiceservice;

public class InvoiceService {

	public static final double MINIMUM_COST_PER_KILOMETER = 10.0;
	public static final int COST_PER_TIME = 1;
	public static final double MINIMUM_FARE = 5.0;
	private RideRepository rideRepository;
	public InvoiceService() {
		this.rideRepository = new RideRepository();
	}

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

	public void addRides(String userId, Ride[] rides) {
		// TODO Auto-generated method stub
		rideRepository.addRide(userId, rides);

	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		// TODO Auto-generated method stub
		return this.calculateFare(rideRepository.getRides(userId));
	}

}
