package com.gestion;

import java.sql.ResultSet;
import com.classes.Passenger;
import com.connexiondb.ConnexionBase;

/**
 *
 * @author Djenidi
 */
public class GestionPassenger {
    private ConnexionBase connexion;
    
    public GestionPassenger() throws Exception
    {
        connexion = new ConnexionBase();
    }
    
    public int insert(Passenger obj) throws Exception
    {
        int lastId = 0;
        String query = "INSERT INTO Passenger (NamePass, FirstName, Email, Phone, DateOfBirth) VALUES('" + obj.getName() + "', '" + obj.getFirstName() + "', '" + obj.getEmail() + "', '" + obj.getDateOfBirth() + "');SELECT SCOPE_IDENTITY();";
        int insertion = connexion.executeUpdate(query);
        
        if (insertion > 0) 
        {
            ResultSet key = connexion.stat.getGeneratedKeys();
            if(key.next()) 
                lastId = key.getInt(1);
        }
        
        return lastId;
    }
    
    public void update(Passenger obj) throws Exception 
    {
        String query = "UPDATE Passenger SET NamePass = '" + obj.getName() + "' , FirstName = '" + obj.getFirstName() +  "', Email = '" + obj.getEmail() + "', Phone = '" + obj.getPhone() + "', DateOfBirth = '" + obj.getDateOfBirth() + "'";
        connexion.executeUpdate(query);
    }
    
    public void delete(int id) throws Exception
    {
        String query = "DELETE FROM Passenger WHERE PassId = " + id;
        connexion.executeUpdate(query);
    }
    
    public ResultSet viewAll() throws Exception
    {
        String query = "SELECT * FROM Passenger;";
        return connexion.executeQuery(query);
    }
    
}
