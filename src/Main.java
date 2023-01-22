import SQL.SQLSingltoneConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        SQLSingltoneConnection sqlConnection = SQLSingltoneConnection.getInstance();
        sqlConnection.getConnection();
        UserMenu userMenu = new UserMenu();
        userMenu.menu();
    }
}