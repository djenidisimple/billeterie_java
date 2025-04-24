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
    
    public GestionRoute()
    {
        try 
        {
            connexion = new ConnexionBase();
        }
        catch(Exception e) 
        {
            System.err.println("Probleme de connexion! Erreur : " + e.getMessage());
        }
    }
    
    public void insert(Route route)
    {
        try 
        {
            String query = "INSERT INTO Route (placeOfDeparture, placeOfArrival, delay, dateLeave, dateArrived) VALUES ('" + route.getPlaceOfDeparture() + "', '" + route.getPlaceOfArrival() + "', " + route.getDelay() + " , '" + route.getDateLeave() + "', '" + route.getDateArrived() + "')";
            connexion.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    public void delete(int id) throws Exception
    {
        String query = "DELETE FROM Route WHERE routeId = " + id;
        connexion.executeUpdate(query);
    }
    public void update(Route obj)
    {
        try
        {
            String query = "UPDATE Route SET placeOfDeparture = '" + obj.getPlaceOfDeparture() + "', placeOfArrival = '" + obj.getPlaceOfArrival() + "', delay = " + obj.getDelay() + ", dateLeave = '" + obj.getDateLeave() + "', dateArrived = '" + obj.getDateArrived() + "' WHERE routeId = " + obj.getId();
            connexion.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    public ResultSet viewAll() throws Exception 
    {
        String query = "SELECT * FROM Route;";
        return connexion.executeQuery(query);
    }
    
    public ResultSet viewByIdl(int id) throws Exception 
    {
        String query = "SELECT * FROM Route where routeId = " + id;
        return connexion.executeQuery(query);
    }
    
    public int countAll()
    {
       String query = "SELECT COUNT(*) as nb FROM Route";
       int nb = 0;
       try
       {
           ResultSet rs = connexion.executeQuery(query);
            while(rs.next())
            {
                nb = rs.getInt("nb");
            }
       }
       catch(Exception e)
       {
           System.out.println("Erreur : " + e.getMessage());
       }
       return nb;
    }
}
