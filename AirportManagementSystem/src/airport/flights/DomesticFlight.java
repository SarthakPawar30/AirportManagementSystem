package airport.flights;

public class DomesticFlight extends Flight {

    public DomesticFlight(String id, String src, String dest, int cap, double fare, double extra) {
        super(id, src, dest, "Domestic", cap, fare, extra);
    }

    @Override
    public void display() {
        System.out.println("Domestic Flight:");
        super.display();
    }
}