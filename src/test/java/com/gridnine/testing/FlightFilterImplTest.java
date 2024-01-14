package com.gridnine.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class for testing
 */

public class FlightFilterImplTest {
    private final List<Flight> flights = new ArrayList<>();
    private final FlightFilter flightFilter = new FlightFilterImpl();
    LocalDateTime time = LocalDateTime.now();

    @Test

    public void departureBeforeTheCurrentTimeTest() {
        Segment segment = new Segment(LocalDateTime.now().minusHours(4),LocalDateTime.now());
        List<Segment> segments = new ArrayList<>();
        segments.add(segment);
        List<Flight> filteredFlights = flightFilter.departureBeforeTheCurrentTime(flights);
        assertTrue(filteredFlights.isEmpty());
    }

    @Test

    public void segmentsWithArrivalDateBeforeDepartureDateTest() {
        Segment segment = new Segment(LocalDateTime.now(),LocalDateTime.now().minusHours(1));
        List<Segment> segments = new ArrayList<>();
        segments.add(segment);
        List<Flight> filteredFlights = flightFilter.segmentsWithArrivalDateBeforeDepartureDate(flights);
        assertTrue(filteredFlights.isEmpty());
    }

    @Test

    public void flightsWhereTheTotalTimeSpentOnTheGroundExceedsTwoHoursTest() {

        Segment segment1 = new Segment(time.plusHours(2), time);
        Segment segment2 = new Segment(time.plusHours(2).plusMinutes(2), time.plusHours(5));
        List<Segment> segments = new ArrayList<>();
        segments.add(segment1);
        segments.add(segment2);
        Flight flight = new Flight(segments);
        List<Flight> flights = new ArrayList<>();
        flights.add(flight);
        List<Flight> filteredFlights = flightFilter.flightsWhereTheTotalTimeSpentOnTheGroundExceedsTwoHours(flights);
        assertTrue(filteredFlights.isEmpty());
    }
}
