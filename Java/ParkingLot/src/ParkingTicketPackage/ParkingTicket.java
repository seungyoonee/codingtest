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

    ParkingTicket() {
        
    }

    ParkingTicket(String id, String parkingSpotId, String parkingSpotType, String issueTime) {
        id = this.id;
        parkingSpotId = this.parkingSpotId;
        parkingSpotType = this.parkingSpotType;
        issueTime = this.issueTime;
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

    public static void main(String args[]) {
        
        ParkingTicket ticket = new ParkingTicket();
        
        System.out.println(ticket.getId());
        System.out.println(ticket.getIssueTime());
        System.out.println(ticket.getParkingSpotId());
        System.out.println(ticket.getParkingSpotType());
    }
}
