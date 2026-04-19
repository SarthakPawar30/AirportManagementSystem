package airport.main;

import java.util.*;

import airport.flights.*;
import airport.people.Passenger;
import airport.booking.Booking;

public class MainApp {

    static List<Flight> flights = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int role;

        do {
            System.out.println("\n1. Admin\n2. Passenger\n3. Exit");
            role = sc.nextInt();

            switch (role) {

                case 1: // ADMIN
                    System.out.print("Enter Flight ID: ");
                    String id = sc.next();

                    System.out.print("Source: ");
                    String src = sc.next();

                    System.out.print("Destination: ");
                    String dest = sc.next();

                    System.out.print("Type (1 Domestic / 2 International): ");
                    int type = sc.nextInt();

                    System.out.print("Capacity: ");
                    int cap = sc.nextInt();

                    System.out.print("Base Fare: ");
                    double fare = sc.nextDouble();

                    System.out.print("Extra/kg: ");
                    double extra = sc.nextDouble();

                    if (type == 1)
                        flights.add(new DomesticFlight(id, src, dest, cap, fare, extra));
                    else
                        flights.add(new InternationalFlight(id, src, dest, cap, fare, extra));

                    System.out.println("✅ Flight Added!");
                    break;

                case 2: // PASSENGER

                    if (flights.isEmpty()) {
                        System.out.println("No flights available!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID: ");
                    String pid = sc.nextLine();

                    Passenger p = new Passenger(name, age, pid);

                    System.out.println("Available Flights:");
                    for (int i = 0; i < flights.size(); i++) {
                        System.out.print(i + 1 + ". ");
                        flights.get(i).display();
                    }

                    System.out.print("Select Flight: ");
                    int fIndex = sc.nextInt() - 1;

                    Flight f = flights.get(fIndex);

                    System.out.print("Seat No: ");
                    int seat = sc.nextInt();

                    System.out.print("Baggage Weight: ");
                    double bag = sc.nextDouble();

                    Booking.book(p, f, seat, bag);

                    p.checkIn();
                    p.display();
                    break;
            }

        } while (role != 3);

        sc.close();
    }
}