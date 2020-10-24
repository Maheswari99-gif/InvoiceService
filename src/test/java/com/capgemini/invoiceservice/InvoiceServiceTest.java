package com.capgemini.invoiceservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

	InvoiceService invoiceService;
	@Before
	public void setUp() {
		this.invoiceService = new InvoiceService();
	}
	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance, time);
		System.out.println(fare);
		Assert.assertEquals(25, fare, 0.0);
	}
	@Test
	public void givenLessDistanceOrTimeShouldReturnMinFare() {
		
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRidesShouldReturnInvoiceSummary() {
		
		Ride[] rides = {new Ride(2.0,5), new Ride(0.1,1),};
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2,30.0);
		Assert.assertEquals(expectedSummary, summary);
	}

}
