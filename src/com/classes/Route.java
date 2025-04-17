package com.classes;

/**
 *
 * @author Djenidi
 */
public class Route {
    private int id;
    private String placeOfDeparture;
    private String placeOfArrival;
    private String duration;
    private String delay;
    private String dateArrived;
    private String dateLeave;

    public String getPlaceOfDeparture() {
        return placeOfDeparture;
    }

    public String getPlaceOfArrival() {
        return placeOfArrival;
    }

    public String getDuration() {
        return duration;
    }

    public String getDelay() {
        return delay;
    }

    public String getDateArrived() {
        return dateArrived;
    }

    public String getDateLeave() {
        return dateLeave;
    }

    public void setPlaceOfDeparture(String placeOfDeparture) {
        this.placeOfDeparture = placeOfDeparture;
    }

    public void setPlaceOfArrival(String placeOfArrival) {
        this.placeOfArrival = placeOfArrival;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public void setDateArrived(String dateArrived) {
        this.dateArrived = dateArrived;
    }

    public void setDateLeave(String dateLeave) {
        this.dateLeave = dateLeave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
