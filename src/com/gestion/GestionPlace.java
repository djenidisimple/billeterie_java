package com.gestion;
import java.sql.ResultSet;
import com.classes.Place;
import com.connexiondb.ConnexionBase;


/**
 *
 * @author Djenidi
 */
public class GestionPlace {
    private ConnexionBase connexion;
    
    public GestionPlace() throws Exception
    {
        connexion = new ConnexionBase();
    }
    
    public void insert(Place obj) throws Exception
    {
        String query = "INSERT INTO Place(routeId, seatNumber, classePas, price, idLo) VALUES (" + obj.getRoute() + ", '" + obj.getSeatNumber() + "', '" + obj.getClassePas() + "', " + obj.getPrice() + ", '" + obj.getIdLo() + "')";
        connexion.executeUpdate(query);
    }
    
    public void delete(int id) throws Exception
    {
        String query = "DELETE FROM Place WHERE placeId = " + id;
        connexion.executeUpdate(query);
    }
    
    public void update(Place obj) throws Exception 
    {
        String query = "UPDATE Place routeId = " + obj.getRoute() + ", seatNumber = " + obj.getSeatNumber() + ", classePas = " + obj.getClassePas() + ", price = " + obj.getPrice() + ", idLo = " + obj.getIdLo() + "";
        connexion.executeUpdate(query);
    }
    public ResultSet viewAll() throws Exception 
    {
        String query = "SELECT * FROM Place;";
        return connexion.executeQuery(query);
    }
}
