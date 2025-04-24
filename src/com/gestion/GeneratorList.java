package com.gestion;
import com.classes.Passenger;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.gestion.GestionPassenger;
/**
 *
 * @author Djenidi
 */
public class GeneratorList {
    public static void getlist(String filename, String query)
    {
        // Créer une liste de clients
        List<Passenger> clients = new ArrayList<>();
        com.itextpdf.text.Document document = new com.itextpdf.text.Document();
        GestionPassenger pass = new GestionPassenger();
        clients = pass.fillList(query);
        try {
            // Générer le PDF
            com.itextpdf.text.pdf.PdfWriter.getInstance(document, new FileOutputStream(filename + ".pdf"));
            document.open();
            // Titre
            document.add(new com.itextpdf.text.Paragraph("Liste des clients\n\n"));

            // Tableau
            PdfPTable table = new PdfPTable(3);
            table.addCell("Nom");
            table.addCell("Prenom");
            table.addCell("Email");
            table.addCell("Téléphone");
            table.addCell("Date de Naissance");

            // Remplir le tableau
            for (Passenger client : clients) {
                table.addCell(client.getName());
                table.addCell(client.getFirstName());
                table.addCell(client.getEmail());
                table.addCell(client.getPhone());
                table.addCell(client.getDateOfBirth().getDay() + "/" + client.getDateOfBirth().getMonth() + "/" + client.getDateOfBirth().getYear());
            }

            document.add(table);
            document.close();
            System.out.println("PDF généré avec succès !");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
