package com.gestion;
import com.classes.Ticket;
import com.connexiondb.ConnexionBase;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Djenidi
 */
public class GestionTicket {
    private ConnexionBase connexion;
    
    public GestionTicket() throws Exception
    {
        connexion = new ConnexionBase();
    }
    
    public void insert(Ticket obj) throws Exception
    {
        String query = "INSERT INTO Ticket(reference, routeId, qrCode, namePass, seatNumber) VALUES ('" + obj.getReference() + "', " + obj.getRoute() + ", '" + obj.getQrCode() + "', '" + obj.getNamePass() + "', '" + obj.getSeatNumber() + "')";
        connexion.executeUpdate(query);
    }
    public void insertMultiple(List<Ticket> tickets) throws SQLException {
        ConnexionBase connex = new ConnexionBase();
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = connex.con;
            conn.setAutoCommit(false);

            String sql = "INSERT INTO Ticket(reference, routeId , qrCode, passId, placeId) VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            final int BATCH_SIZE = 1000;
            int count = 0;

            for (Ticket ticket : tickets) {
                // Paramétrisation...
                pstmt.setString(1, ticket.getReference());
                pstmt.setInt(2, ticket.getRoute()); // Adaptez selon votre structure
                pstmt.setString(3, ticket.getQrCode());
                pstmt.setInt(4, ticket.getNamePass());
                pstmt.setInt(5, ticket.getSeatNumber());
                pstmt.addBatch();

                if(++count % BATCH_SIZE == 0) {
                    pstmt.executeBatch();
                    conn.commit();
                }
            }

            pstmt.executeBatch();
            conn.commit();
            System.out.println(tickets.size() + " billets insérés avec succès!");
        } catch (SQLException e) {
            if (conn != null) conn.rollback();
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.setAutoCommit(true);
        }
    }
    public void delete(int id) throws Exception 
    {
        String query = "DELETE FROM Ticket WHERE ticketId = " + id;
        connexion.executeUpdate(query);
    }
    
    public void update(Ticket obj) throws Exception 
    {
        String query = "UPDATE Ticket SET reference = '" + obj.getReference() + "', routeId = " + obj.getRoute() + ", qrCode = '" + obj.getQrCode() + "', namePass = '" + obj.getNamePass() + "', seatNumber='" + obj.getSeatNumber() + "'";
        connexion.executeUpdate(query);
    }
    
    public ResultSet viewAll() throws Exception
    {
        String query = "SELET * FROM Ticket;";
        return connexion.executeQuery(query);
    }
    public List<Ticket> viewAllTicket()
    {
        List<Ticket> ticket = new ArrayList<>();
        String query = "SELECT * FROM Ticket";
        try
        {
            ResultSet rs = connexion.executeQuery(query);
            while(rs.next())
            {

                Ticket t = new Ticket(rs.getString("reference"), rs.getInt("routeId"), rs.getString("qrCode"), rs.getInt("passId"), rs.getInt("placeId"));
                ticket.add(t);
            }
        }
        catch(Exception e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }
        return ticket;
    }
    public String stringById(String query, String column)
    {
        String name = "";
        try
        {
            ResultSet rs = connexion.executeQuery(query);
            while(rs.next())
            {
                name = rs.getString(column);
            }
        }
        catch(Exception e){
            System.err.println("Erreur : " + e.getMessage());
        }
        return name;
    }
    public int count()
    {
        String query = "SELECT COUNT(*) as nb  FROM Ticket";
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
