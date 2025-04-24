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
    
    public GestionTrain()
    {
        try 
        {
            connexion = new ConnexionBase();
        }
        catch(Exception e)
        {
            System.out.println("Probleme de connexion!");
        }
    }
    
    public int insert(Train obj) throws Exception
    {
        String query = "INSERT INTO Train (NameTrain, CapacityTrain) VALUES ('" + obj.getName() + "', " + obj.getCapacity() + " )";
        int insertion = connexion.executeUpdate(query), lastId = 0;
        if(insertion > 0) 
        {
            ResultSet key = connexion.stat.getGeneratedKeys();
            while(key.next())
                lastId = key.getInt(1);
        }
        return lastId;
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
    
    public ResultSet viewById(int id) throws Exception
    {
        String query = "SELECT Train.trainId, Train.nameTrain, Train.CapacityTrain, ( SELECT COUNT(*) FROM Place WHERE Place.trainId = Train.trainId AND Place.EstDisponible = 0 ) as occuper FROM trainbyroute INNER JOIN Train ON Train.trainId = trainbyroute.trainId WHERE routeId = " + id + ";";
        return connexion.executeQuery(query);
    }
    
    public int exist(String name)
    {
        try 
        {
            String query = "SELECT COUNT(trainId) as nb FROM Train WHERE nameTrain = '" + name + "'";
            ResultSet rs = connexion.executeQuery(query);
            return (rs.next()) ? rs.getInt("nb") : 0;
        }
        catch (Exception e) 
        {
            return -1;
        }
    }
    public int getIdByName(String name)
    {
        try
        {
           String query = "SELECT trainId FROM Train WHERE nameTrain = '" + name + "'";
           ResultSet rs = connexion.executeQuery(query);
           return (rs.next()) ? rs.getInt("trainId") : 0;
        }
        catch(Exception e)
        {
            return -1;
        }
    }
    
    public String getIdByNames(int id)
    {
        try
        {
           String query = "SELECT * FROM Train WHERE trainId = " + id + "";
           ResultSet rs = connexion.executeQuery(query);
           return (rs.next()) ? rs.getString("nameTrain") : "";
        }
        catch(Exception e)
        {
            return "";
        }
    }
    
    public ResultSet getNameById(int id)
    {
        try
        {
           String query = "SELECT * FROM Train WHERE trainId = " + id + "";
           return connexion.executeQuery(query);
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public int countAll()
    {
        try
        {
           String query = "SELECT COUNT(*) AS nb FROM Train";
           ResultSet rs = connexion.executeQuery(query);
           return (rs.next()) ? rs.getInt("nb") : 0;
        }
        catch(Exception e)
        {
            return -1;
        }
    }
    public int countAllById(int id)
    {
        try
        {
           String query = "SELECT COUNT(*) AS nb FROM TrainByRoute WHERE routeId = " + id;
           ResultSet rs = connexion.executeQuery(query);
           return (rs.next()) ? rs.getInt("nb") : 0;
        }
        catch(Exception e)
        {
            return -1;
        }
    }
}
