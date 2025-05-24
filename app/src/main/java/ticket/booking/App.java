package ticket.booking;

import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.services.UserBookingService;
import ticket.booking.util.UserServiceUtil;

import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        System.out.println("IRCTC Backend");
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        Train trainSelectedForBooking = null;
        UserBookingService userBookingService;
        try {
            userBookingService = new UserBookingService();
        } catch (IOException ex) {
            System.out.println("Something went wrong, Please try again later");
            ex.printStackTrace();
            scanner.close();
            return;
        }

        while (option != 7) {
            System.out.println("Choose option");
            System.out.println("1. Sign up");
            System.out.println("2. Login");
            System.out.println("3. Fetch Bookings");
            System.out.println("4. Search Trains");
            System.out.println("5. Book a Seat");
            System.out.println("6. Cancel my Booking");
            System.out.println("7. Exit the App");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.println("Enter the username to signup");
                    String nameToSignUp = scanner.nextLine();
                    System.out.println("Enter the password to signup");
                    String passwordToSignUp = scanner.nextLine();
                    User userToSignup = new User(nameToSignUp, passwordToSignUp, UserServiceUtil.hashPassword(passwordToSignUp), UUID.randomUUID().toString(), new ArrayList<>());
                    userBookingService.signUpUser(userToSignup);
                    break;

                case 2:
                    System.out.println("Enter the username to Login");
                    String nameToLogin = scanner.nextLine();
                    System.out.println("Enter the password to Login");
                    String passwordToLogin = scanner.nextLine();
                    User userToLogin = new User(nameToLogin, passwordToLogin, UserServiceUtil.hashPassword(passwordToLogin), UUID.randomUUID().toString(), new ArrayList<>());
                    try {
                        userBookingService = new UserBookingService(userToLogin);
                    } catch (IOException ex) {
                        System.out.println("Login failed, please try again.");
                        ex.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Fetching your bookings");
                    userBookingService.fetchBookings();
                    break;

                case 4:
                    System.out.println("Type your source station");
                    String source = scanner.nextLine();
                    System.out.println("Type your destination station");
                    String dest = scanner.nextLine();
                    List<Train> trains = userBookingService.getTrains(source, dest);
                    System.out.println(trains);
                    System.out.println("trains listed");
                    int index = 1;
                    for (Train t : trains) {
                        System.out.println(index + ". Train id : " + t.getTrainId());
                        for (Map.Entry<String, String> entry : t.getStationTimes().entrySet()) {
                            System.out.println("station " + entry.getKey() + " time: " + entry.getValue());
                        }
                        index++;
                    }
                    System.out.println("Select a train by typing 1,2,3...");
                    int trainChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (trainChoice > 0 && trainChoice <= trains.size()) {
                        trainSelectedForBooking = trains.get(trainChoice - 1);
                    } else {
                        System.out.println("Invalid train selection");
                        trainSelectedForBooking = null;
                    }
                    break;

                case 5:
                    if (trainSelectedForBooking == null) {
                        System.out.println("Please select a train first by using option 4.");
                        break;
                    }
                    System.out.println("Select a seat out of these seats");
                    List<List<Integer>> seats = userBookingService.fetchSeats(trainSelectedForBooking);
                    for (List<Integer> rowSeats : seats) {
                        for (Integer val : rowSeats) {
                            System.out.print(val + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("Select the seat by typing the row and column");
                    System.out.println("Enter the row");
                    int row = scanner.nextInt();
                    System.out.println("Enter the column");
                    int col = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Booking your seat....");
                    Boolean booked = userBookingService.bookTrainSeat(trainSelectedForBooking, row, col);
                    if (booked) {
                        System.out.println("Booked! Enjoy your journey");
                    } else {
                        System.out.println("Can't book this seat");
                    }
                    break;

                case 6:
                    // You can implement cancellation here or print a placeholder
                    System.out.println("Cancel booking feature coming soon!");
                    break;

                case 7:
                    System.out.println("Exiting the app. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
