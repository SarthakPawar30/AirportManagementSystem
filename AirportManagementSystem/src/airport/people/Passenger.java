package airport.people;

import airport.interfaces.Payable;
import airport.interfaces.CheckIn;

public class Passenger extends Person implements Payable, CheckIn {

    private String flightId;
    private int seatNo;
    private double baggage;
    private double totalFare;

    public Passenger(String name, int age, String id) {
        super(name, age, id);
    }

    public void setDetails(String flightId, int seatNo, double baggage) {
        this.flightId = flightId;
        this.seatNo = seatNo;
        this.baggage = baggage;
    }

    @Override
    public double calculateFare(double baseFare, double baggage, double extraPerKg) {
        double extra = (baggage > 15) ? (baggage - 15) * extraPerKg : 0;
        totalFare = baseFare + extra;
        return totalFare;
    }

    @Override
    public void checkIn() {
        System.out.println(name + " checked-in successfully.");
    }

    public void display() {
        System.out.println(name + " | Flight: " + flightId + " | Seat: " + seatNo + " | Fare: " + totalFare);
    }
}