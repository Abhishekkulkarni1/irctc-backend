package ticket.booking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {
    private String ticketId;
    private String ticketSource;
    private String ticketDestination;
    private String ticketUserId;
    private String ticketDate;
    private Train train; // ✅ renamed from trainNumber to match JSON key

    public Ticket() {
    }

    public Ticket(String ticketId, String ticketSource, String ticketDestination, String ticketUserId, String ticketDate, Train train) {
        this.ticketId = ticketId;
        this.ticketSource = ticketSource;
        this.ticketDestination = ticketDestination;
        this.ticketUserId = ticketUserId;
        this.ticketDate = ticketDate;
        this.train = train;
    }

    public String getTicketInfo() {
        return String.format(
                "Ticket ID: %s belongs to User %s from %s to %s on %s\n%s",
                ticketId,
                ticketUserId,
                ticketSource,
                ticketDestination,
                ticketDate,
                train != null ? train.getTrainInfo() : "No train info"
        );
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

    public void setTicketSource(String ticketSource) {
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

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
