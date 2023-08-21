package BookingTicket;

import java.io.*;
import java.util.*;

//BookingTicket.Ticket Booking System
//

class Ticket {
    int ticketId;
    String passengerName;
    String source;
    String destination;
    double ticketPrice;

    String trainName;

    //constructor
    public Ticket(String passengerName, String source, String destination, double ticketPrice, String trainName) {
        this.passengerName = passengerName;
        this.source = source;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
        this.trainName=trainName;

    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    //getter and setter methods
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getTicketPrice (){
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice=ticketPrice;
    }
}



class BookingSystem{

    //Map-> to store booked tickets
    private Map<Integer, Ticket> bookedT;

    //to keep track of the next available ticket id
    private int nextId;

    //constructor
    public BookingSystem(){
        bookedT=new HashMap<>();
        nextId=1;
    }

    public void bookT(Ticket ticket){
        ticket.setTicketId(nextId);
        bookedT.put(nextId, ticket);
        nextId++;
    }

    //this method displays all booked ticket details
    public void displayTickets(){
        for(Map.Entry<Integer, Ticket> entry: bookedT.entrySet()){
            int ticketId= entry.getKey();
            Ticket ticket=entry.getValue();
            System.out.println("BookingTicket.Ticket Id: "+ticketId);
            System.out.println(ticket.toString());
            System.out.println();
        }
    }
    //method saves booked ticket into a file using PrintWriter
    public void saveIntoFile(String file){
        try(PrintWriter w = new PrintWriter(new FileWriter(file))){
            for(Map.Entry<Integer, Ticket> entry: bookedT.entrySet()){
                int ticketId= entry.getKey();
                Ticket ticket=entry.getValue();
                w.println(ticketId+","+ticket.getPassengerName()+","+ticket.getSource()+","
                +ticket.getDestination()+","+ticket.getTrainName()+","+ticket.getTicketPrice());
            }
            System.out.println("Details saved to: "+file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //reads and display ticket details from a file using BufferedReader
    public void readfile(String file){
        try(BufferedReader reader=new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                String[] read= line.split(",");
                if(read.length==6){
                    int ticketId= Integer.parseInt(read[0]);
                    String passengerName=read[1];
                    String source = read[2];
                    String destination=read[3];
                    String trainName =read[4];
                    double ticketPrice=Double.parseDouble(read[5]);

                    System.out.println("BookingTicket.Ticket Id: "+ticketId);
                    System.out.println("Passenger Name: "+passengerName);
                    System.out.println("Source: "+source);
                    System.out.println("Destination: "+destination);
                    System.out.println("Train Name: "+trainName);
                    System.out.println("BookingTicket.Ticket Price: "+ticketPrice);

                    System.out.println("All your details"+file);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
public class ticketBookingSystem {

    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Book your ticket");
            System.out.println("2. See booked status");
            System.out.println("3. Save your data");
            System.out.println("4. See all your save data ");
            System.out.println("5. Exit");
            System.out.println("Enter any option");
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
                    String trainName=sc.nextLine();

                    if(trainName==null){
                        System.out.println("Details Not found");
                    }else{
                        System.out.println("Enter ticketPrice");
                        double ticketPrice = sc.nextDouble();
                        Ticket newt=new Ticket(Name, source, destination, ticketPrice, trainName);
                        newt.setPassengerName(Name);
                        newt.setSource(source);
                        newt.setDestination(destination);
                        newt.setTicketPrice(ticketPrice);
                        newt.setTrainName(trainName);

                        bookingSystem.bookT(newt);
                        System.out.println("Successfully Booked");
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

//