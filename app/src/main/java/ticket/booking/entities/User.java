package ticket.booking.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private String hashedPassword;
    private String userId;

    @JsonProperty("getBookedTickets")
    private List<Ticket> getBookedTickets;

    public User() {}

    public User(String name, String password, String hashedPassword, String userId, List<Ticket> getBookedTickets) {
        this.name = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.userId = userId;
        this.getBookedTickets = getBookedTickets;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

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
        if (getBookedTickets == null || getBookedTickets.isEmpty()) {
            System.out.println("No tickets booked.");
            return;
        }
        for (Ticket ticket : getBookedTickets) {
            System.out.println(ticket.getTicketInfo());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setGetBookedTickets(List<Ticket> getBookedTickets) {
        this.getBookedTickets = getBookedTickets;
    }
}
