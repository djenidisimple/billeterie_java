package com.classes;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Djenidi
 */
public class Reservation {
    private int idPas;
    private ArrayList<Integer> idPla;
    private int idRoute;
    private LocalDateTime dateRes;
    public Reservation(int idPassager, int RouteId, ArrayList<Integer> idPlace, LocalDateTime date) 
    {
        this.idPas = idPassager;
        this.idRoute = RouteId;
        this.idPla = idPlace;
        this.dateRes = date;
    }

    public int getIdPas() {
        return idPas;
    }

    public int getIdRoute() {
        return idRoute;
    }

    public LocalDateTime getDateRes() {
        return dateRes;
    }

    public void setIdPas(int idPas) {
        this.idPas = idPas;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    public void setDateRes(LocalDateTime dateRes) {
        this.dateRes = dateRes;
    }

    public ArrayList<Integer> getIdPla() {
        return idPla;
    }

    public void setIdPla(ArrayList<Integer> idPla) {
        this.idPla = idPla;
    }
}
