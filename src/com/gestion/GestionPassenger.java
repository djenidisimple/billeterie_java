package com.gestion;

import java.sql.ResultSet;
import com.classes.Passenger;
import com.connexiondb.ConnexionBase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Djenidi
 */
public class GestionPassenger {
    private ConnexionBase connexion;
    
    public GestionPassenger()
    {
        try
        {
            connexion = new ConnexionBase();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    public int insert(Passenger obj) throws Exception
    {
        int lastId = 0;
        String query = "INSERT INTO Passenger (name, firstName, email, Phone) VALUES('" + obj.getName() + "', '" + obj.getFirstName() + "', '" + obj.getEmail() + "', '" + obj.getDateOfBirth() + "');";
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
    
    public List<Passenger> fillList(String query)
    {
        List<Passenger> passenger = new ArrayList<>();
        try
        {
            ResultSet rs = connexion.executeQuery(query);
            while(rs.next())
            {
                passenger.add(new Passenger((int)rs.getInt("passId"), rs.getString("name"), rs.getString("firstName"), rs.getString("email"), rs.getString("Phone")));
            }
        }
        catch(Exception e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }
        return passenger;
    }
    
    public static boolean emailExist(String email)
    {
        try
        {
            ConnexionBase conn = new ConnexionBase();
            String query = "SELECT COUNT(*) as nb FROM Passenger WHERE email = '" + email + "'";
            ResultSet rs = conn.executeQuery(query);
            int nb = 0;
            while(rs.next())
            {
                nb = rs.getInt("nb");
            }
            return nb == 0;
        } catch(Exception e)
        {
            return false;
        }
    }   
    public int count()
    {
        String query = "SELECT COUNT(*) as nb FROM Passenger;";
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
