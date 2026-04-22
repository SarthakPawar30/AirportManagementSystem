package airport.booking;

import airport.people.Passenger;
import airport.flights.Flight;
import airport.exceptions.*;

public class Booking {

    public static void book(Passenger p, Flight f, int seat, double baggage)
            throws FlightFullException, OverweightException {

        // ❌ Baggage check
        if (baggage > 50) {
            throw new OverweightException("❌ Baggage exceeds 50kg limit!");
        }

        // ❌ Flight full check
        f.bookSeat();

        // ✅ Set details
        p.setDetails(f.getFlightId(), seat, baggage);

        // 💰 Fare calculation
        double fare = p.calculateFare(f.getBaseFare(), baggage, f.getExtraPerKg());

        System.out.println("✅ Booking Successful! Total Fare: ₹" + fare);
    }
}