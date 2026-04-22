package airport.main;

import java.util.*;

import airport.flights.*;
import airport.people.Passenger;
import airport.booking.Booking;
import airport.exceptions.*;
import java.util.InputMismatchException;

public class MainApp {

    static List<Flight> flights = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int role;

        do {
            System.out.println("\n===== AIRPORT MANAGEMENT SYSTEM =====");
            System.out.println("1. Admin");
            System.out.println("2. Passenger");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            role = sc.nextInt();

            switch (role) {

                // 🔐 ADMIN
                case 1:
                    try {
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

                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid input!");
                        sc.nextLine();
                    }
                    break;

                // 👤 PASSENGER
                case 2:
                    try {

                        if (flights.isEmpty()) {
                            throw new FlightNotFoundException("❌ No flights available!");
                        }

                        System.out.print("Enter Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();

                        System.out.print("Age: ");
                        int age = sc.nextInt();

                        if (age <= 0) {
                            throw new InvalidDataException("❌ Invalid age!");
                        }

                        sc.nextLine();
                        System.out.print("ID: ");
                        String pid = sc.nextLine();

                        Passenger p = new Passenger(name, age, pid);

                        System.out.println("\nAvailable Flights:");
                        for (int i = 0; i < flights.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            flights.get(i).display();
                        }

                        System.out.print("Select Flight: ");
                        int index = sc.nextInt() - 1;

                        if (index < 0 || index >= flights.size()) {
                            throw new FlightNotFoundException("❌ Invalid flight selection!");
                        }

                        Flight f = flights.get(index);

                        System.out.print("Seat No: ");
                        int seat = sc.nextInt();

                        System.out.print("Baggage Weight: ");
                        double bag = sc.nextDouble();

                        Booking.book(p, f, seat, bag);

                        p.checkIn();
                        p.display();

                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid input!");
                        sc.nextLine();

                    } catch (FlightFullException | OverweightException |
                             FlightNotFoundException | InvalidDataException e) {
                        System.out.println(e.getMessage());

                    } catch (Exception e) {
                        System.out.println("❌ Error: " + e.getMessage());
                    }

                    break;

                case 3:
                    System.out.println("🙏 Thank you!");
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }

        } while (role != 3);

        sc.close();
    }
}