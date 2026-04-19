package airport.people;

public class Staff extends Person {

    private String role;

    public Staff(String name, int age, String id, String role) {
        super(name, age, id);
        this.role = role;
    }
}