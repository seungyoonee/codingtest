/*
ParkingTicket has 4 properties:
 - id
 - parkingSpotId
 - parkingSpotType
 - issueTime
*/
package ParkingTicketPackage;

public class ParkingTicket {
    
    private String id;
    private String parkingSpotId;
    private String parkingSpotType;
    private String issueTime;

    public ParkingTicket() {}

    public ParkingTicket(String id, String parkingSpotId, String parkingSpotType, String issueTime) {
        this.id = id;
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
        this.issueTime = issueTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setParkingSpotId(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public void setParkingSpotType(String parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getId() {
        return id;
    }

    public String getParkingSpotId() {
        return parkingSpotId;
    }

    public String getParkingSpotType() {
        return parkingSpotType;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void printParkingTicket() {
        System.out.println("ID: " + getId() + "\nParking Spot ID: " + getParkingSpotId() + "\nParking Spot Type: " + getParkingSpotType() + "\nIssued Time: " + getIssueTime() + "\n");
    }

    public static void main(String args[]) {
        
        ParkingTicket ticket = new ParkingTicket();
        
        ticket.printParkingTicket();

        ParkingTicket ticket1 = new ParkingTicket("1111", "11", "Compact", "14:35");
        ticket1.printParkingTicket();
    }
}
