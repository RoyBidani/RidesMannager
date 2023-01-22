package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSingltoneConnection {
    private static final SQLSingltoneConnection instance = new SQLSingltoneConnection();
    public static SQLSingltoneConnection getInstance() {
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rides", "root", "root1234")) {
            // if datebase doesn't exist, create it
        } catch (SQLException e) {


            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root1234");
            Statement statement = con.createStatement();
            System.out.println("logged");
            statement.execute("CREATE DATABASE rides");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rides", "root", "root1234");
            statement = con.createStatement();

            statement.execute("CREATE TABLE public_rides1(" +
                    "rideId varchar(20) PRIMARY KEY not null," +
                    "comments varchar(20) not null," +
                    "startPointName varchar(45) not null," +
                    "destination varchar(45) not null," +
                    "rideTime varchar(45) not null," +
                    "BackTime varchar(45) not null," +
                    "numberOfPassengers varchar(45) not null," +
                    "date DATETIME not null);");


        }


        return DriverManager.getConnection("jdbc:mysql://localhost:3306/rides", "root", "root1234");


    }
    private static String url = "jdbc:mysql://localhost:3306/rides";
}
