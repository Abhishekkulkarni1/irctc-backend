package ticket.booking.entities;

import java.util.*;

public class User {
    private String name;
    private String email;
    private String password;
    private String hashedPassword;
    private String userId;
    private List<Ticket> getBookedTickets;

    public User(String name, String password, String hashedPassword, String userId, List<Ticket> getBookedTickets) {
        this.name = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.userId = userId;
        this.getBookedTickets = getBookedTickets;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

//    public String getEmail() {
//        return email;
//    }

    public String getPassword() {
        return password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getUserId() {
        return userId;
    }

    public List<Ticket> getGetBookedTickets() {
        return getBookedTickets;
    }

    public void printBookedTickets() {
        for (int i = 0; i < getBookedTickets.size(); i++) {
            System.out.println(getBookedTickets.get(i).getTicketInfo());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setGetBookedTickets(List<Ticket> getBookedTickets) {
        this.getBookedTickets = getBookedTickets;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

