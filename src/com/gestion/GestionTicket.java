package com.gestion;
import com.classes.Ticket;
import com.connexiondb.ConnexionBase;
import java.sql.ResultSet;

/**
 *
 * @author Djenidi
 */
public class GestionTicket {
    private ConnexionBase connexion;
    
    public GestionTicket() throws Exception
    {
        connexion = new ConnexionBase();
    }
    
    public void insert(Ticket obj) throws Exception
    {
        String query = "INSERT INTO Ticket(reference, routeId, qrCode, namePass, seatNumber) VALUES ('" + obj.getReference() + "', " + obj.getRoute() + ", '" + obj.getQrCode() + "', '" + obj.getNamePass() + "', '" + obj.getSeatNumber() + "')";
        connexion.executeUpdate(query);
    }
    public void delete(int id) throws Exception 
    {
        String query = "DELETE FROM Ticket WHERE ticketId = " + id;
        connexion.executeUpdate(query);
    }
    
    public void update(Ticket obj) throws Exception 
    {
        String query = "UPDATE Ticket SET reference = '" + obj.getReference() + "', routeId = " + obj.getRoute() + ", qrCode = '" + obj.getQrCode() + "', namePass = '" + obj.getNamePass() + "', seatNumber='" + obj.getSeatNumber() + "'";
        connexion.executeUpdate(query);
    }
    
    public ResultSet viewAll() throws Exception
    {
        String query = "SELET * FROM Ticket;";
        return connexion.executeQuery(query);
    }
}
