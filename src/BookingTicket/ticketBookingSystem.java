package BookingTicket;

import java.io.*;
import java.util.*;

//BookingTicket.Ticket Booking System

public class ticketBookingSystem {

    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Train Ticket Booking:");
            System.out.println("1. Book your ticket");
            System.out.println("2. See booked status");
            System.out.println("3. Save your data");
            System.out.println("4. See all your saved data ");
            System.out.println("5. Exit");
            System.out.println("Choose one option");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Enter your name");
                    String Name = sc.nextLine();
                    System.out.println("Enter your source");
                    String source = sc.nextLine();
                    System.out.println("Enter your destination");
                    String destination = sc.nextLine();
                    System.out.println("Enter train name");
                    String trainName = sc.nextLine();

                    if (trainName == null) {
                        System.out.println("Details Not found");
                    } else {
                        try {
                            System.out.println("Enter ticketPrice");
                            double ticketPrice = sc.nextDouble();
                            if (ticketPrice < 0) {
                                throw new NegativePriceException("Ticket price cannot be negative");
                            }

                            Ticket newt = new Ticket(Name, source, destination, ticketPrice, trainName);
                            newt.setPassengerName(Name);
                            newt.setSource(source);
                            newt.setDestination(destination);
                            newt.setTicketPrice(ticketPrice);
                            newt.setTrainName(trainName);

                            bookingSystem.bookT(newt);
                            System.out.println("Successfully Booked");
                        } catch (NegativePriceException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                case 2:
                    bookingSystem.displayTickets();
                    break;
                case 3:
                    bookingSystem.saveIntoFile("ticket.txt");
                    System.out.println();
                    break;
                case 4:
                    bookingSystem.readfile("ticket.txt");
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exit..");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
