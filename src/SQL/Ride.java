package SQL;

public class Ride {
    private long rideId;
    private String comments;
    private String startPointName;
    private String destination;
    private String rideTime;
    private String backTime;
    private int numberOfPassengers;
    private String date;
    public Ride(long rideId, String comments, String startPointName, String destination, String rideTime, String backTime, int numberOfPassengers, String date) {
        this.rideId = rideId;
        this.comments = comments;
        this.startPointName = startPointName;
        this.destination = destination;
        this.rideTime = rideTime;
        this.backTime = backTime;
        this.numberOfPassengers = numberOfPassengers;
        this.date = date;
    }

    public long getRideId() {
        return rideId;
    }

    public void setRideId(long rideId) {
        this.rideId = rideId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStartPointName() {
        return startPointName;
    }

    public void setStartPointName(String startPointName) {
        this.startPointName = startPointName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRideTime() {
        return rideTime;
    }

    public void setRideTime(String rideTime) {
        this.rideTime = rideTime;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
