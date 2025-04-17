package com.gestion;
import com.connexiondb.ConnexionBase;
import com.classes.Route;
import java.sql.ResultSet;

/**
 *
 * @author Djenidi
 */
public class GestionRoute {
    public ConnexionBase connexion;
    
    public GestionRoute() throws Exception
    {
        connexion = new ConnexionBase();
    }
    
    public void insert(Route route) throws Exception
    {
        String query = "INSERT INTO Route (placeOfDeparture, placeOfArrival, delay, dateLeave, dateArrived) VALUES ('" + route.getPlaceOfDeparture() + "', '" + route.getPlaceOfArrival() + "', " + route.getDelay() + " , '" + route.getDateLeave() + "', '" + route.getDateArrived() + "')";
        connexion.executeUpdate(query);
    }
    public void delete(int id) throws Exception
    {
        String query = "DELETE FROM Route WHERE RouteId = " + id;
        connexion.executeUpdate(query);
    }
    public void update(Route obj) throws Exception
    {
        String query = "UPDATE Route SET placeOfDeparture = '" + obj.getPlaceOfDeparture() + "', placeOfArrival = '" + obj.getPlaceOfArrival() + "', delay = " + obj.getDelay() + ", dateLeave = '" + obj.getDateLeave() + "', dateArrived = '" + obj.getDateArrived() + "'";
        connexion.executeUpdate(query);
    }
    public ResultSet viewAll() throws Exception 
    {
        String query = "SELECT * FROM Route;";
        return connexion.executeQuery(query);
    }
}
