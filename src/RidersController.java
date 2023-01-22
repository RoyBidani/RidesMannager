import SQL.SQLSingltoneConnection;
import SQL.ScannerGetter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RidersController {

    public void showAllRides() throws SQLException {
        Statement stmt = SQLSingltoneConnection.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM public_rides1");
        while (rs.next()) {
            System.out.println("Ride Id: "+rs.getString("rideId"));
            System.out.println("Comments: "+rs.getString("comments"));
            System.out.println("Start Point: "+rs.getString("startPoint"));
            System.out.println("End Point: "+rs.getString("destination"));
            System.out.println("Ride Time: "+rs.getString("rrideTime"));
            System.out.println("Back Time: "+rs.getString("backTime"));
            System.out.println("Number Of Passengers: "+rs.getString("numberOfPassengers"));
            System.out.println("Date: "+rs.getString("date"));
            System.out.println("-----------------------------------------------------");
            System.out.println("Succeed");
            System.out.println("-----------------------------------------------------");

        }
    }

    public void addRide(){
        System.out.println("Enter Ride Id: ");
        String rideId = ScannerGetter.scanString();
        System.out.println("Enter Comments: ");
        String comments = ScannerGetter.scanString();
        System.out.println("Enter Start Point: ");
        String startPoint = ScannerGetter.scanString();
        System.out.println("Enter End Point: ");
        String endPoint = ScannerGetter.scanString();
        System.out.println("Enter Ride Time: ");
        String rideTime = ScannerGetter.scanString();
        System.out.println("Enter Back Time: ");
        String backTime = ScannerGetter.scanString();
        System.out.println("Enter Number Of Passengers: ");
        String numberOfPassengers = ScannerGetter.scanString();
        System.out.println("Enter Date: ");
        String date = ScannerGetter.scanString();
        System.out.println("-----------------------------------------------------");
        System.out.println("You want to add this ride? (y/n)");
        String answer = ScannerGetter.scanString();
        if(answer.equals("y")){
            try {
                Statement stmt = SQLSingltoneConnection.getConnection().createStatement();
                stmt.execute("INSERT INTO public_rides1(rideId,comments,startPoint,destination,rrideTime,backTime,numberOfPassengers,date) " +
                        "VALUES ('" + rideId + "','" + comments + "','" + startPoint + "','" + endPoint + "','" + rideTime + "','" + backTime + "','" + numberOfPassengers + "','" + date + "')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(answer.equals("n")){
            System.out.println("-----------------------------------------------------");
            System.out.println("You didn't add this ride");
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("Succeed");
        System.out.println("-----------------------------------------------------");
    }


    public  void deleteRide() throws SQLException {
        System.out.println("Enter Ride Id: ");
        String id = ScannerGetter.scanString();
        if(isRideExist(id)) {
            Statement stmt = SQLSingltoneConnection.getConnection().createStatement();
            stmt.execute("DELETE FROM public_rides1 WHERE rideId = '" + id + "'");
            System.out.println("Ride: " + id + " was deleted");
            System.out.println("-----------------------------------------------------");
            System.out.println("Succeed");
            System.out.println("-----------------------------------------------------");
        }else{
            System.out.println("Ride: " + id + " doesn't exist");
            System.out.println("-----------------------------------------------------");
            System.out.println("Failed");
            System.out.println("-----------------------------------------------------");
        }
    }

    public void getRide() throws SQLException {
        System.out.println("Enter Ride Id: ");
        String id = ScannerGetter.scanString();
        Statement stmt = SQLSingltoneConnection.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM public_rides1 WHERE rideId = '" + id + "'");
        if(rs.next()){
            System.out.println("Ride Id: "+rs.getString("rideId"));
            System.out.println("Comments: "+rs.getString("comments"));
            System.out.println("Start Point: "+rs.getString("startPoint"));
            System.out.println("End Point: "+rs.getString("destination"));
            System.out.println("Ride Time: "+rs.getString("rrideTime"));
            System.out.println("Back Time: "+rs.getString("backTime"));
            System.out.println("Number Of Passengers: "+rs.getString("numberOfPassengers"));
            System.out.println("Date: "+rs.getString("date"));
            System.out.println("-----------------------------------------------------");
            System.out.println("Succeed");
            System.out.println("-----------------------------------------------------");
        }else {
            System.out.println("Ride: " + id + " was not found");
            System.out.println("-----------------------------------------------------");
            System.out.println("Failed");
            System.out.println("-----------------------------------------------------");
        }
    }

    public void updateRide() throws SQLException {
        System.out.println("Enter Ride Id: ");
        String id = ScannerGetter.scanString();
        if(isRideExist(id)) {
            System.out.println("Wich field do you want to update? (rideId/comments/startPoint/destination/rrideTime/backTime/numberOfPassengers/date)");
            String field = ScannerGetter.scanString();
            System.out.println("Enter new value: ");
            String value = ScannerGetter.scanString();
            Statement stmt = SQLSingltoneConnection.getConnection().createStatement();
            stmt.execute("UPDATE public_rides1 SET " + field + " = '" + value + "' WHERE rideId = '" + id + "'");
            System.out.println("Ride: " + id + " was updated");
            System.out.println("-----------------------------------------------------");
            System.out.println("Succeed");
            System.out.println("-----------------------------------------------------");
        }else {
            System.out.println("Ride: " + id + " was not found");
            System.out.println("-----------------------------------------------------");
            System.out.println("Failed");
            System.out.println("-----------------------------------------------------");
        }
    }

    public void showAllRidesByDate() throws SQLException {
        System.out.println("Enter Date: ");
        String date = ScannerGetter.scanString();
        Statement stmt = SQLSingltoneConnection.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM public_rides1 WHERE date = '" + date + "'");
        while (rs.next()) {
            System.out.println("Ride Id: "+rs.getString("rideId"));
            System.out.println("Comments: "+rs.getString("comments"));
            System.out.println("Start Point: "+rs.getString("startPoint"));
            System.out.println("End Point: "+rs.getString("destination"));
            System.out.println("Ride Time: "+rs.getString("rrideTime"));
            System.out.println("Back Time: "+rs.getString("backTime"));
            System.out.println("Number Of Passengers: "+rs.getString("numberOfPassengers"));
            System.out.println("Date: "+rs.getString("date"));
            System.out.println("-----------------------------------------------------");
            System.out.println("Succeed");
            System.out.println("-----------------------------------------------------");
        }
    }

    public void showAllRidesDateAscending() throws SQLException {
        Statement stmt = SQLSingltoneConnection.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM public_rides1 ORDER BY date ASC");
        while (rs.next()) {
            System.out.println("Ride Id: "+rs.getString("rideId"));
            System.out.println("Comments: "+rs.getString("comments"));
            System.out.println("Start Point: "+rs.getString("startPoint"));
            System.out.println("End Point: "+rs.getString("destination"));
            System.out.println("Ride Time: "+rs.getString("rrideTime"));
            System.out.println("Back Time: "+rs.getString("backTime"));
            System.out.println("Number Of Passengers: "+rs.getString("numberOfPassengers"));
            System.out.println("Date: "+rs.getString("date"));
            System.out.println("-----------------------------------------------------");
            System.out.println("Succeed");
            System.out.println("-----------------------------------------------------");
        }
    }

    public boolean isRideExist(String id) throws SQLException {
        Statement stmt = SQLSingltoneConnection.getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM public_rides1 WHERE rideId = '" + id + "'");
        if(rs.next()){
            return true;
        }else {
            return false;
        }
    }



}
