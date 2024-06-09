package src.activities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    public Plane(int maxPassengers) {
        maxPassengers = this.maxPassengers;
        passengers = new ArrayList<String>();
    }

    public void onboard(String passenger){
        passengers.add(passenger);
    }
    public LocalDateTime takeOff(){
        return LocalDateTime.now();
    }
    public void land(){
        lastTimeLanded = new Date();
        passengers.clear();
    }
    public Date getLastTimeLanded(){
       return lastTimeLanded;
    }
    public List<String> getPassengers(){
        return passengers;
    }
}
