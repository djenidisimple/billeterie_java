package com.classes;
import java.sql.Timestamp;

/**
 *
 * @author Djenidi
 */
public class Ticket {
    private String reference;
    private int route;
    private String qrCode;
    private int namePass;
    private int seatNumber;
    private Timestamp dateDeparture;

    public Ticket(String reference, int route, String qrcode, int namePass, int seatNumber)
    {
        this.reference = reference;
        this.route = route;
        this.qrCode = qrcode;
        this.namePass = namePass;
        this.seatNumber = seatNumber;
    }
    
    public String getReference() {
        return reference;
    }

    public int getRoute() {
        return route;
    }

    public String getQrCode() {
        return qrCode;
    }

    public int getNamePass() {
        return namePass;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public void setNamePass(int namePass) {
        this.namePass = namePass;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Timestamp getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(Timestamp dateDeparture) {
        this.dateDeparture = dateDeparture;
    }
}
