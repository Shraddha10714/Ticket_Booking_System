package BookingTicket;

public class NegativePriceException extends Exception{
    public NegativePriceException(String e){
        super(e);
    }
}
