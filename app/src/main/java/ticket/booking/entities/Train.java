package ticket.booking.entities;

import java.sql.Time;
import java.util.*;

public class Train {
    private String trainId;
    private String trainNumber;
    private List<List<Integer>> seats;
    private List<String> stations;
    private Map<String, Time> arrivalTimeAtStation;
}
