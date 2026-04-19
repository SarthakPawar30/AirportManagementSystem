package airport.flights;

public class InternationalFlight extends Flight {

    public InternationalFlight(String id, String src, String dest, int cap, double fare, double extra) {
        super(id, src, dest, "International", cap, fare, extra);
    }

    @Override
    public void display() {
        System.out.println("International Flight:");
        super.display();
    }
}