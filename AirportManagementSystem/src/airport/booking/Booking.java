package airport.booking;

import airport.people.Passenger;
import airport.flights.Flight;

public class Booking {

    public static void book(Passenger p, Flight f, int seat, double baggage) {

        if (!f.bookSeat()) {
            System.out.println("❌ Flight FULL!");
            return;
        }

        p.setDetails(f.getFlightId(), seat, baggage);
        double fare = p.calculateFare(f.getBaseFare(), baggage, f.getExtraPerKg());
        
        System.out.println("✅ Booking Successful! Fare: " + fare);
    }
}