package com.gridnine.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TestingApplication {

	public static void main(String[] args) {
		List<Flight> flights =  FlightBuilder.createFlights();
		FlightFilterImpl flightFilter = new FlightFilterImpl();

		System.out.println("Flights with departure before the current time:");
		flightFilter.departureBeforeTheCurrentTime(flights);

		System.out.println("Flights segments with arrival date earlier than departure date:");
		flightFilter.segmentsWithArrivalDateBeforeDepartureDate(flights);

		System.out.println("The flights spent more than two hours on the ground:");
		flightFilter.flightsWhereTheTotalTimeSpentOnTheGroundExceedsTwoHours(flights);
	}

}
