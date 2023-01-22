import java.sql.SQLException;
import java.util.Scanner;

public class UserMenu {
    Scanner scanner = new Scanner(System.in);
    int userChoice;
    RidersController ridersController = new RidersController();
    public void menu() throws SQLException {
        userChoice = -1 ;
        while (userChoice != 0) {
            System.out.println("USER MENU");
            System.out.println("[1] - Show all rides");
            System.out.println("[2] - Add a ride");
            System.out.println("[3] - Delete ride by id");
            System.out.println("[4] - Search ride by id");
            System.out.println("[5] - Update ride by id");
            System.out.println("[6] - Show all rides date-ascending");
            System.out.println("[7] - Show all rides by date format (dd-MM-yy)");
            System.out.println("");
            System.out.println("[0] - Exit");
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    ridersController.showAllRides();
                    break;
                case 2:
                    ridersController.addRide();
                    break;
                case 3:
                    ridersController.deleteRide();
                    break;
                case 4:
                    ridersController.getRide();
                    break;
                case 5:
                    ridersController.updateRide();
                    break;
                case 6:
                    ridersController.showAllRidesDateAscending();
                    break;
                case 7:
                    ridersController.showAllRidesByDate();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
            }
        }
       }
}