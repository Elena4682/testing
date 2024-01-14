package com.gridnine.testing;

import java.util.List;
/**
 * Interface for the FlightFilterImpl class
 */

public interface FlightFilter {

    List<Flight> departureBeforeTheCurrentTime(List<Flight> flights);

    List<Flight> segmentsWithArrivalDateBeforeDepartureDate(List<Flight> flights);

    List<Flight> flightsWhereTheTotalTimeSpentOnTheGroundExceedsTwoHours(List<Flight> flights);
}
