package BookingTicket;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//interface
interface TicketServices{
    void bookT(Ticket ticket);
    void displayTickets();
}
class BookingSystem implements TicketServices{

    //Map-> to store booked tickets
    private Map<Integer, Ticket> bookedT;

    //to keep track of the next available ticket id
    private int nextId;

    //constructor
    public BookingSystem() {
        bookedT = new HashMap<>();
        nextId = 1;
    }

    public void bookT(Ticket ticket) {
        ticket.setTicketId(nextId);
        bookedT.put(nextId, ticket);
        nextId++;
    }

    //this method displays all booked ticket details
    public void displayTickets() {
        for (Map.Entry<Integer, Ticket> entry : bookedT.entrySet()) {
            int ticketId = entry.getKey();
            Ticket ticket = entry.getValue();
            System.out.println("Ticket Id: " + ticketId);
            System.out.println(ticket.toString());
            System.out.println();
        }
    }

    //method saves booked ticket into a file using PrintWriter
    void saveIntoFile(String file) {
        try (PrintWriter w = new PrintWriter(new FileWriter(file))) {
            for (Map.Entry<Integer, Ticket> entry : bookedT.entrySet()) {
                int ticketId = entry.getKey();
                Ticket ticket = entry.getValue();
                w.println(ticketId + "," + ticket.getPassengerName() + "," + ticket.getSource() + ","
                        + ticket.getDestination() + "," + ticket.getTrainName() + "," + ticket.getTicketPrice());
            }
            System.out.println("Details saved to: " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //reads and display ticket details from a file using BufferedReader
    void readfile(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] read = line.split(",");
                if (read.length == 6) {
                    int ticketId = Integer.parseInt(read[0]);
                    String passengerName = read[1];
                    String source = read[2];
                    String destination = read[3];
                    String trainName = read[4];
                    double ticketPrice = Double.parseDouble(read[5]);

                    System.out.println("Ticket Id: " + ticketId);
                    System.out.println("Passenger Name: " + passengerName);
                    System.out.println("Source: " + source);
                    System.out.println("Destination: " + destination);
                    System.out.println("Train Name: " + trainName);
                    System.out.println("Ticket Price: " + ticketPrice);

                    System.out.println("All your details stored in " + file);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
