package com.classes;

import java.sql.Timestamp;

/**
 *
 * @author Djenidi
 */
public class Route {
    private int id;
    private String placeOfDeparture;
    private String placeOfArrival;
    private int duration;
    private int delay;
    private Timestamp dateArrived;
    private Timestamp dateLeave;
    private int trainId;
        
    public Route(int id, String placeOfDeparture, String placeOfArrival, int duration, int delay, Timestamp dateArrived, Timestamp dateLeave)
    {
        this.id = id;
        this.placeOfDeparture = placeOfDeparture;
        this.placeOfArrival = placeOfArrival;
        this.duration = duration;
        this.delay = delay;
        this.dateLeave = dateLeave;
        this.dateArrived = dateArrived;
    }
    
    public String getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public String getPlaceOfArrival() {
        return placeOfArrival;
    }

    public int getDuration() {
        return duration;
    }

    public int getDelay() {
        return delay;
    }

    public void setPlaceOfDeparture(String placeOfDeparture) {
        this.placeOfDeparture = placeOfDeparture;
    }

    public void setPlaceOfArrival(String placeOfArrival) {
        this.placeOfArrival = placeOfArrival;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public Timestamp getDateArrived() {
        return dateArrived;
    }

    public Timestamp getDateLeave() {
        return dateLeave;
    }

    public void setDateArrived(Timestamp dateArrived) {
        this.dateArrived = dateArrived;
    }

    public void setDateLeave(Timestamp dateLeave) {
        this.dateLeave = dateLeave;
    }
}
