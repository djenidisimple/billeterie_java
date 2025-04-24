package com.gestion;
import com.connexiondb.ConnexionBase;
import java.sql.SQLException;
import com.classes.TrainByRoute;

/**
 *
 * @author Djenidi
 */
public class GestionTrainByRoute {
    
    private ConnexionBase connexion;
    
    public GestionTrainByRoute() throws SQLException
    {
        try
        {
            connexion = new ConnexionBase();
        }
        catch(Exception e)
        {
            System.err.println("Error connexion : " + e.getMessage());
        }
    }
    
    public void insert(TrainByRoute obj)
    {
        try
        {
            String query = "INSERT INTO TrainByRoute ( routeId, trainId) VALUES (" + obj.getRouteId() + ", " + obj.getTrainId() + ")";
            connexion.executeUpdate(query);
            System.out.println("Insert succes!");
        }
        catch(Exception e)
        {
            System.err.println("Error in insertion : " + e.getMessage());
        }
    }
    public void update(TrainByRoute obj)
    {
        try
        {
            String query = "UPDATE TrainByRoute SET routeId =  " + obj.getRouteId() + ", trainId = " + obj.getTrainId() + " WHERE idTBR =  "  + obj.getId()  + "";
            connexion.executeUpdate(query);
            System.out.println("Update succes!");
        }
        catch(Exception e)
        {
            System.err.println("Error in insertion : " + e.getMessage());
        }
    }
}
