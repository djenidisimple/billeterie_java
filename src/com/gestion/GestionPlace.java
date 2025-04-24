package com.gestion;
import java.sql.ResultSet;
import com.classes.Place;
import com.connexiondb.ConnexionBase;
import java.util.ArrayList;
import java.sql.SQLException;


/**
 *
 * @author Djenidi
 */
public class GestionPlace {
    private ConnexionBase connexion;
    
    public GestionPlace()
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
    public ResultSet getPlaceById(int id)
    {
        String query = "";
        try 
        {
            query = "SELECT * FROM Place WHERE routeId = " + id;
            return connexion.executeQuery(query);
        }
        catch(SQLException er)
        {
            System.err.println("Erreur1 : " + er.getMessage());
            return null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public int getNumberPlaceById(int id)
    {
        String query = "";
        int nb = 0;
        try 
        {
            query = "SELECT COUNT(*) as nb FROM Place WHERE routeId = " + id + " AND EstDisponible = 0";
            ResultSet rs = connexion.executeQuery(query);
            while(rs.next())
            {
                nb = rs.getInt("nb");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return nb;
    }
    
    public int countTrain(String query, String column)
    {
        int nb = 0;
        try
        {
            ResultSet rs = connexion.executeQuery(query);
            while(rs.next())
            {
                nb = rs.getInt(column);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return nb;
    }
    
    public int placeOccuper()
    {
        String query = "SELECT COUNT(*) as nb FROM Place WHERE EstDisponible = 0";
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
            System.out.println("Erreur ; " + e.getMessage());
        }
        return nb;
    }
    
    public void freePlace()
    {
        try
        {
            String query = "EXEC LiberationPlaces;";
            connexion.executeUpdate(query);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public int insertAllPlace(ArrayList<Integer> Place, int nbPlace) 
    {
        String query = "";
        int i = 1, j = 0, count = Place.get(1) - nbPlace;
        int nbColunm = (int)(count / 4);
        String[] alphaNum = { "A", "B", "C", "D" };
        int classe = 1;

        try 
        {
            if (count > 0)
            {
                while (i < count)
                {
                    if ( i % nbColunm == 0 && i > 1) 
                    {
                        j++;
                    }
                    if (i == 20) 
                    {
                        classe++;   
                    }
                    query = "INSERT INTO Place (routeId, classePas, seatNumber, price) VALUES( " + Place.get(0) + "," + classe + "  ,'" + alphaNum[j] + i + "', 10000);";
                    connexion.executeUpdate(query);
                    i++;
                }
            }
        }
        catch(Exception e)
        {
            System.err.println("Erreur2 : " + e.getMessage());
        }
        return count;
    }
    public ArrayList<ArrayList<Integer>> addPlace() 
    {
        ArrayList<ArrayList<Integer>> value = new ArrayList<>();
        String query = "SELECT Route.routeId , Train.CapacityTrain as CapaciteTotale FROM Route INNER JOIN Train ON Train.trainId = Route.trainId WHERE Route.IsActive = 1;";
        int idTrajet = 0, nbPlace = 0;
        try
        {
            ResultSet rs = connexion.executeQuery(query);
            while (rs.next()) {
                idTrajet = (int)rs.getInt("routeId");
                nbPlace = (int)rs.getInt("CapaciteTotale");

                // Nouvelle ArrayList à CHAQUE itération
                ArrayList<Integer> rowData = new ArrayList<>();
                rowData.add(idTrajet);
                rowData.add(nbPlace);

                value.add(rowData);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return value;
    }
    public void insertById(int id) 
    {
        int nbTotalTrajet = 0,i = 0, nbPlace = 0;
        String query;
        query = "SELECT COUNT(RouteID) AS Total FROM Route WHERE routeId = " + id;
        nbTotalTrajet = countTrain(query, "Total");
        query = "SELECT COUNT(RouteID) AS Total FROM Place WHERE routeId = " + id;
        nbPlace = countTrain(query, "Total");
        if (nbPlace < nbTotalTrajet)
        {
            try
            {
                while (i < addPlace().size())
                {
                    insertAllPlace(addPlace().get(i), nbPlace);
                    i++;
                }
            }
            catch (Exception e)
            {
                System.out.println("Erreur3 : " + e.getMessage());
            }
        }
        else {
            System.out.println("Enregistrement Deja existant! (fichier controlePlace)");
        }
    }
    public void insert()
    {
        int nbTotalTrajet = 0,i = 0, nbPlace = 0;
        String query;
        query = "SELECT COUNT(routeId) AS Total FROM Route WHERE IsActive = 1;";
        nbTotalTrajet = countTrain(query, "Total");
        query = "SELECT COUNT(routeId) AS Total FROM Place WHERE routeId IN (SELECT routeId FROM Route WHERE IsActive = 1);";
        nbPlace = countTrain(query, "Total");
        System.out.println(nbTotalTrajet);
        if (nbPlace < nbTotalTrajet)
        {
            try
            {
                while (i < addPlace().size())
                {
                    insertAllPlace(addPlace().get(i), nbPlace);
                    i++;
                }
            }
            catch (Exception e)
            {
                System.out.println("Erreur 3: " + e.getMessage());
            }
        }
        else {
            System.out.println("Enregistrement Deja existant (Place deja complet!) ");
        }
    }
}
