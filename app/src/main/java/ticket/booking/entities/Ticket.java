package ticket.booking.entities;

import java.util.*;

public class Ticket {
    private String ticketId;
    private String ticketSource;
    private String ticketDestination;
    private String ticketUserId;
    private String ticketDate;
    private Train trainNumber;

    public Ticket() {
    }

    public Ticket(String ticketId, String ticketSource, String ticketDestination, String ticketUserId, String ticketDate, Train trainNumber) {
        this.ticketId = ticketId;
        this.ticketSource = ticketSource;
        this.ticketDestination = ticketDestination;
        this.ticketUserId = ticketUserId;
        this.ticketDate = ticketDate;
        this.trainNumber = trainNumber;
    }

    public String getTicketInfo() {
        return String.format("Ticket ID: %s belongs to User %s from %s to %s on %s", ticketId, ticketUserId, ticketSource, ticketDestination, ticketDate);
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketSource() {
        return ticketSource;
    }

    public void setTicketSource(String source) {
        this.ticketSource = ticketSource;
    }

    public String getTicketUserId() {
        return ticketUserId;
    }

    public void setTicketUserId(String ticketUserId) {
        this.ticketUserId = ticketUserId;
    }

    public String getTicketDestination() {
        return ticketDestination;
    }

    public void setTicketDestination(String ticketDestination) {
        this.ticketDestination = ticketDestination;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public Train getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Train trainNumber) {
        this.trainNumber = trainNumber;
    }

}
