package airport.exceptions;

public class FlightFullException extends Exception {
    public FlightFullException(String msg) {
        super(msg);
    }
}