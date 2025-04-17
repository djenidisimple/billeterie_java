package com.classes;

/**
 *
 * @author Djenidi
 */
public class Ticket {
    private String reference;
    private String route;
    private String qrCode;
    private String namePass;
    private String seatNumber;

    public String getReference() {
        return reference;
    }

    public String getRoute() {
        return route;
    }

    public String getQrCode() {
        return qrCode;
    }

    public String getNamePass() {
        return namePass;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public void setNamePass(String namePass) {
        this.namePass = namePass;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}
