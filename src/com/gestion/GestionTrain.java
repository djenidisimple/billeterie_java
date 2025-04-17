package com.gestion;
import com.classes.Train;
import com.connexiondb.ConnexionBase;
import java.sql.ResultSet;

/**
 *
 * @author Djenidi
 */
public class GestionTrain {
    private ConnexionBase connexion;
    
    public GestionTrain() throws Exception
    {
        connexion = new ConnexionBase();
    }
    
    public void insert(Train obj) throws Exception
    {
        String query = "INSERT INTO Train (NameTrain, CapacityTrain) VALUES ('" + obj.getName() + "', " + obj.getCapacity() + " )";
        connexion.executeUpdate(query);
    }
    
    public void update(Train obj) throws Exception
    {
        String query = "UPDATE Train SET NameTrain = '" + obj.getName() + "', CapacityTrain = " + obj.getCapacity() + "";
        connexion.executeUpdate(query);
    }
    
    public void delete(int id) throws Exception 
    {
        String query = "DELETE FROM Train WHERE TrainId = " + id;
        connexion.executeUpdate(query);
    }
    
    public ResultSet viewAll() throws Exception
    {
        String query = "SELECT * FROM Train;";
        return connexion.executeQuery(query);
    }
}
