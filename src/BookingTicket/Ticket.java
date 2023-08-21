package BookingTicket;

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
        this.trainName = trainName;

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

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
