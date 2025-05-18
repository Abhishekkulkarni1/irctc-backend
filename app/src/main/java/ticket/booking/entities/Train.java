package ticket.booking.entities;

import java.sql.Time;
import java.util.*;

public class Train {
    private String trainId;
    private String trainNumber;
    private List<List<Integer>> seats;
    private List<String> stations;
    private Map<String, String> arrivalTimeAtStation;

    public Train() {
    }

    public Train(String trainId, String trainNumber, List<List<Integer>> seats, List<String> stations, Map<String, String> arrivalTimeAtStation) {
        this.trainId = trainId;
        this.trainNumber = trainNumber;
        this.seats = seats;
        this.stations = stations;
        this.arrivalTimeAtStation = arrivalTimeAtStation;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public List<List<Integer>> getSeats() {
        return seats;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public Map<String, String> getArrivalTimeAtStation() {
        return arrivalTimeAtStation;
    }

    public void setArrivalTimeAtStation(Map<String, String> arrivalTimeAtStation) {
        this.arrivalTimeAtStation = arrivalTimeAtStation;
    }

    public String getTrainInfo(){
        return String.format("Train ID: %s Train No: %s", trainId, trainNumber);
    }
}
