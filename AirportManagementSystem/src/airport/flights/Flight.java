package airport.flights;

public class Flight {
    protected String flightId, source, destination, type;
    protected int capacity, booked = 0;
    protected double baseFare, extraPerKg;

    public Flight(String id, String src, String dest, String type, int cap, double fare, double extra) {
        this.flightId = id;
        this.source = src;
        this.destination = dest;
        this.type = type;
        this.capacity = cap;
        this.baseFare = fare;
        this.extraPerKg = extra;
    }
    
    public String getFlightId() {
        return flightId;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public double getExtraPerKg() {
        return extraPerKg;
    }

    public boolean bookSeat() {
        if (booked < capacity) {
            booked++;
            return true;
        }
        return false;
    }

    public void display() {
        System.out.println(flightId + " | " + source + " → " + destination +
                " | " + type + " | Seats Left: " + (capacity - booked));
    }
}