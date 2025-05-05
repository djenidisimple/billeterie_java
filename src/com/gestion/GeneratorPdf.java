package com.gestion;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.AreaBreakType;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import java.util.List;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.ByteArrayOutputStream;
import com.classes.Ticket;
import com.gestion.GestionTicket;
/**
 *
 * @author Djenidi
 */
public class GeneratorPdf {
    private static byte[] generateQRCode(String text, int width, int height) throws Exception {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "PNG", baos);
        return baos.toByteArray();
    }
    public static void getBillet(Document doc, Ticket data)
    {
        try {
            
            GestionTicket ticket = new GestionTicket();
            String query1 = "SELECT * FROM Passenger WHERE passId = " + data.getNamePass();
            String name = ticket.stringById(query1, "name");
            String query2 = "SELECT * FROM Place WHERE placeId = " + data.getSeatNumber();
            String place = ticket.stringById(query2, "seatNumber");
            String query3 = "SELECT * FROM Route WHERE routeId = " + data.getRoute();
            String departure = ticket.stringById(query3, "placeOfDeparture");
            String query4 = "SELECT * FROM Route WHERE routeId = " + data.getRoute();
            String arrival = ticket.stringById(query4, "placeOfArrival");
            
            String query5 = "SELECT * FROM Reservation WHERE resId = " + data.getRoute();
            String dateLeave = ticket.stringById(query5, "dateLeave");
            
            doc.add(new Paragraph("Billet de Train " + departure + "-" + arrival));
            doc.add(new Paragraph("Nom : " + name));
            doc.add(new Paragraph("Date de départe : Pas encore fixer!"));
            doc.add(new Paragraph("Siège : " + place));
                
             // Générer le QR code (ex: "TICKET-12345")
            byte[] qrCodeBytes = generateQRCode(data.getReference(), 200, 200);
            Image qrCodeImage = new Image(ImageDataFactory.create(qrCodeBytes));

            // Ajouter le QR code au PDF
            doc.add(qrCodeImage);
            
            System.out.println("PDF généré avec succès !"); 

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
            //e.printStackTrace();
        }
    }
    
     public static byte[] generateMultipleTickets(List<Ticket> tickets)
     {
         ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
         try
         {
            PdfWriter writer = new PdfWriter(byteStream);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            for (int i = 0; i < tickets.size(); i++) {
                Ticket data = tickets.get(i);
                getBillet(document, data);

                // Ajouter un saut de page sauf pour le dernier billet
                if (i < tickets.size() - 1) {
                    document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
                }
            }

            document.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
        return byteStream.toByteArray();
    }
    public static void generateBillet(List<Ticket> ticket, String filename)
    {
        try {
            byte[] pdfBytes = GeneratorPdf.generateMultipleTickets(ticket);
            Files.write(Paths.get(filename+".pdf"), pdfBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
