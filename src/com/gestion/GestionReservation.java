package com.gestion;
import com.connexiondb.ConnexionBase;
import com.classes.Reservation;
import java.sql.ResultSet;
import java.sql.*;

/**
 *
 * @author Djenidi
 */
public class GestionReservation {
    ConnexionBase connexion;
    public GestionReservation()throws Exception
    {
        connexion = new ConnexionBase();
    }
    public void reserverPlace(Reservation rs) throws SQLException
    {
        Connection conn = null;
        ConnexionBase connex = new ConnexionBase();
        if (rs.getIdPla().isEmpty()) {
            return;
        }

        try {
            conn = connex.con;
            conn.setAutoCommit(false); // Démarrer la transaction

            String insertSQL = "INSERT INTO Reservation (passId, routeId, placeID) VALUES (?, ?, ?)";
            String updateSQL = "UPDATE Place SET EstDisponible = 0 WHERE placeId = ?";

            try (PreparedStatement pstmtInsert = conn.prepareStatement(insertSQL);
                 PreparedStatement pstmtUpdate = conn.prepareStatement(updateSQL)) {

                for (Integer placeId : rs.getIdPla()) {
                    // Vérifier la disponibilité avant réservation
                    if (!isPlaceAvailable(conn, placeId)) {
                        throw new SQLException("Place " + placeId + " déjà réservée");
                    }

                    // Insertion réservation
                    pstmtInsert.setInt(1, rs.getIdPas());
                    pstmtInsert.setInt(2, rs.getIdRoute());
                    pstmtInsert.setInt(3, placeId);
                    pstmtInsert.executeUpdate();

                    // Mise à jour disponibilité
                    pstmtUpdate.setInt(1, placeId);
                    pstmtUpdate.executeUpdate();

                    System.out.println("Succès Reservation pour place: " + placeId);
                }

                conn.commit(); // Valider la transaction
            }
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback(); // Annulation en cas d'erreur
            }
            throw new SQLException("Échec de la réservation: " + e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); // Réactiver l'auto-commit
                } catch (SQLException e) {
                    System.err.println("Erreur reset auto-commit: " + e.getMessage());
                }
            }
        }
    }

    private boolean isPlaceAvailable(Connection conn, int placeId) throws SQLException {
        String checkSQL = "SELECT EstDisponible FROM Place WHERE placeId = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(checkSQL)) {
            pstmt.setInt(1, placeId);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() && rs.getInt("EstDisponible") == 1;
        }
    }
    public void insert(Reservation rs) throws Exception
    {
        int i = 0;
            if (rs.getIdPla().size() > 0) 
            {
                try
                {
                    while (i < rs.getIdPla().size())
                    {
                        String query = "INSERT INTO Reservation (passId, routeId, placeID) VALUES(" + rs.getIdPas() + "," + rs.getIdRoute() + "," + rs.getIdPla().get(i) + ");";
                        connexion.executeUpdate(query);
                        String query2 = "UPDATE Place SET EstDisponible = 0 WHERE placeId = " + rs.getIdPla().get(i) + ";";
                        connexion.executeUpdate(query2);
                        i++;
                        System.out.println("Succes Reservation!");
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Erreur : " + e.getMessage());
                }
            }
    }
    public void delete(int id) throws Exception
    {
        String query = "DELETE FROM Reservations WHERE ResId = " + id;
        connexion.executeUpdate(query);
    }
    public void update(Reservation rs) throws Exception
    {
        String query = "UPDATE Reservations SET PassengerID = " + rs.getIdPas() + ", RouteID = " + rs.getIdRoute() + ", PlaceID = " + rs.getIdPla() + "";
        connexion.executeUpdate(query);
    }
    public ResultSet viewAll() throws Exception
    {
        String query = "SELECT * FROM Reservations";
        return connexion.executeQuery(query);
    }
}
