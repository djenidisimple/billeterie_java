package com.gestion;
import com.connexiondb.ConnexionBase;
import com.classes.Reservation;
import java.sql.ResultSet;

/**
 *
 * @author Djenidi
 */
public class GestionReservation {
    ConnexionBase connexion;
    public GestionReservation()throws Exception
    {
        connexion = new ConnexionBase();
    }
    public void insert(Reservation rs) throws Exception
    {
        int i = 0;
            if (rs.getIdPla().size() > 0) 
            {
                try
                {
                    while (i < rs.getIdPla().size())
                    {

                        String query = "INSERT INTO Reservation (PassengerID, RouteID, PlaceID) VALUES(" + rs.getIdPas() + "," + rs.getIdRoute() + "," + rs.getIdPla().get(i) + ");";
                        connexion.executeUpdate(query);
                        i++;
                        System.out.println("Succes Reservation!");
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Erreur : " + e.getMessage());
                }
            }
    }
    public void delete(int id) throws Exception
    {
        String query = "DELETE FROM Reservations WHERE ResId = " + id;
        connexion.executeUpdate(query);
    }
    public void update(Reservation rs) throws Exception
    {
        String query = "UPDATE Reservations SET PassengerID = " + rs.getIdPas() + ", RouteID = " + rs.getIdRoute() + ", PlaceID = " + rs.getIdPla() + "";
        connexion.executeUpdate(query);
    }
    public ResultSet viewAll() throws Exception
    {
        String query = "SELECT * FROM Reservations";
        return connexion.executeQuery(query);
    }
}
