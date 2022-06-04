/*
Interface allows a class to become more formal about the behavior it promises to provide.
It forms a contract between the class and the outside world.
It is a specification of method prototypes.
*/
package ParkingTicketPackage;

public interface ParkingTicketInterface {
    
    public String getId();
    public String getParkingSpotId();
    public String getParkingSpotType();
    public String getIssueTime();

}
