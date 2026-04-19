package airport.interfaces;

public interface Payable {
    double calculateFare(double baseFare, double baggage, double extraPerKg);
}