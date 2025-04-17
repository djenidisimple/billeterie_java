package com.classes;

/**
 *
 * @author Djenidi
 */
public class Place {
    private int id;
    private int route;
    private String seatNumber;
    private String classePas;
    private String price;
    private int idLo;

    public Place(int id, String seat, int routeId,String classe, String pricePlace, int idLocomotive) 
    {
        this.id = id;
        this.route = routeId;
        this.classePas = classe;
        this.price = pricePlace;
        this.seatNumber = seat;
        this.idLo = idLocomotive;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getClassePas() {
        return classePas;
    }

    public String getPrice() {
        return price;
    }

    public int getIdLo() {
        return idLo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setClassePas(String classePas) {
        this.classePas = classePas;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setIdLo(int idLo) {
        this.idLo = idLo;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }
}
