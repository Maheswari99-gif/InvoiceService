package com.capgemini.invoiceservice;

public class InvoiceService {

	private RideRepository rideRepository;
	public InvoiceService() {
		this.rideRepository = new RideRepository();
	}


	public InvoiceSummary calculateFare(Ride[] rides) {
		// TODO Auto-generated method stub
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += ride.cabRide.calculateRideCost(ride);
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

	public void setRideRepository(RideRepository rideRepository) {
		// TODO Auto-generated method stub
		this.rideRepository = rideRepository;
	}

}
