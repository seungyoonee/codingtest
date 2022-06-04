// import ParkingTicketPackage.*;

public class Main {
    public static void main(String args[]) {
        
        ParkingTicket ticket = new ParkingTicket();
        
        System.out.println(ticket.getId());
        System.out.println(ticket.getIssueTime());
        System.out.println(ticket.getParkingSpotId());
        System.out.println(ticket.getParkingSpotType());
    }
}
