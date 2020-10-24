package com.capgemini.invoiceservice;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
	private InvoiceService invoiceService;

	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
	    double fare = invoiceService.calculateFare(distance, time);
		System.out.println(fare);
		Assert.assertEquals(0, fare, 0.0);
	}

}
