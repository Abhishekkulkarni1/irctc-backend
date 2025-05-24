package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserBookingService {
    private User user;
    private List<User> userList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String USER_PATH = "app/src/main/java/ticket/booking/database/users.json";

    public UserBookingService(User user) throws IOException {
        System.out.println("inside userbooking service1");
        this.user = user;
        loadUsers();
    }

    public UserBookingService() throws IOException {
        loadUsers();
    }

    private void loadUsers() throws IOException {
        userList = objectMapper.readValue(new File(USER_PATH), new TypeReference<List<User>>() {
        });
    }

    public Boolean loginUser() {
        Optional<User> getUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return getUser.isPresent();
    }

    public Boolean signUpUser(User user1) {
        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException {
        File usersFile = new File(USER_PATH);
        objectMapper.writeValue(usersFile, userList);
    }

    public void fetchBookings() {
        Optional<User> getUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        if (getUser.isPresent()) {
            getUser.get().printBookedTickets();
        }
    }

//    public Boolean cancelBooking(String ticketId) {
//        if (user == null) {
//            System.out.println("No user is currently logged in.");
//            return Boolean.FALSE;
//        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the ticket id to cancel");
//        ticketId = scanner.next();
//
//        if (ticketId == null || ticketId.isEmpty()) {
//            System.out.println("Ticket ID cannot be null or empty.");
//            return Boolean.FALSE;
//        }
//        String finalTicketId1 = ticketId;
//        boolean removed = user.getGetBookedTickets().removeIf(ticket -> ticket.getTicketId().equals(finalTicketId1));
//
//        String finalTicketId = ticketId;
//        user.getGetBookedTickets().removeIf(Ticket -> Ticket.getTicketId().equals(finalTicketId));
//        if (removed) {
//            System.out.println("Ticket with ID " + ticketId + " has been canceled.");
//            return Boolean.TRUE;
//        }else{
//            System.out.println("No ticket found with ID " + ticketId);
//            return Boolean.FALSE;
//        }
//    }

    public Boolean cancelBooking() {
        if (user == null) {
            System.out.println("No user is currently logged in.");
            return Boolean.FALSE;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ticket id to cancel:");
        String ticketId = scanner.next();

        if (ticketId == null || ticketId.isEmpty()) {
            System.out.println("Ticket ID cannot be null or empty.");
            return Boolean.FALSE;
        }

        boolean removed = user.getGetBookedTickets().removeIf(ticket -> ticket.getTicketId().equals(ticketId));
        if (removed) {
            System.out.println("Ticket with ID " + ticketId + " has been canceled.");
            try {
                saveUserListToFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Boolean.TRUE;
        } else {
            System.out.println("No ticket found with ID " + ticketId);
            return Boolean.FALSE;
        }
    }


    public List<Train> getTrains(String source, String destination) {
        try {
            TrainService trainService = new TrainService();
            System.out.println(trainService);
            System.out.println("trains listed");
            return trainService.searchTrains(source, destination);
        } catch (IOException ex) {
            System.out.println("inside catch block");
            ex.printStackTrace();  // print exception details
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Unexpected exception:");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<List<Integer>> fetchSeats(Train train) {
        return train.getSeats();
    }

    public Boolean bookTrainSeat(Train train, int row, int seat) {
        try {
            TrainService trainService = new TrainService();
            List<List<Integer>> seats = train.getSeats();
            if (row >= 0 && row < seats.size() && seat >= 0 && seat < seats.get(row).size()) {
                if (seats.get(row).get(seat) == 0) {
                    seats.get(row).set(seat, 1);
                    train.setSeats(seats);
                    trainService.addTrain(train);
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }
}
