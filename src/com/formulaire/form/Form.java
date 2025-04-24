package com.formulaire.form;
import java.sql.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.gestion.GestionTrain;
import javax.swing.*;
import com.connexiondb.ConnexionBase;


/**
 *
 * @author Djenidi
 */
public class Form {
    private ConnexionBase connexion;
    public Form()
    {
        try 
        {
            connexion = new ConnexionBase();
        }
        catch(Exception e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
    public static int Train(String name, String capacity)
    {
        GestionTrain train = new GestionTrain();
        try {
            int cp = Integer.parseInt(capacity);
            if (!name.isEmpty() && cp > 0) 
            {
                return (train.exist(name) > 0) ? 2 : 0;
            } 
            else 
            {
                return  1;
            }
        }
        catch(NumberFormatException e)
        {
            return (name.length() == 0) ? -2 : -1 ;
        }
    }
    public static int Route(String departure, String arrival, Timestamp dateDeparture, Timestamp dateArrival) 
    {
        if (departure.length() > 0 && arrival.length() > 0 && dateDeparture != null && dateArrival != null) 
        {
            return 0;
        }
        else 
        {
            return 1;
        }
    }
    public static int Passenger(String name, String firstName, String phone, String email)
    {
        if (name.length() > 0 && firstName.length() > 0 && phone.length() > 0 && email.length() > 0) 
        {
            return 0;
        } 
        else 
        {
            return 1;
        }
    }
    public static boolean Email(String email) 
    {
        Pattern p = Pattern.compile("^(?i)[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        return m.matches();
    }
    public static boolean PhoneNumberValid(String phone)
    {
        return phone.matches("^\\+[0-9]{12}$");
    }
    public DefaultComboBoxModel<String> fillComboBox(String query, JComboBox<String> comboBox, String column)
    {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        try 
        {
            ResultSet rs = connexion.executeQuery(query);
            while(rs.next())
            {
                model.addElement(rs.getString(column));
            }
            return model;
        }
        catch(Exception e)
        {
            System.out.println("Erreur : " + e.getMessage());
            return null;
        }
    }
}
