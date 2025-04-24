package com.gestion;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class TrainTicketReferenceGenerator {
    
    private static final String PREFIX = "TRAIN";
    private static final AtomicInteger sequence = new AtomicInteger(1);
    private static LocalDateTime lastGenerationTime = LocalDateTime.now();

    public static String generateReference(String departureStation, String arrivalStation) {
        LocalDateTime now = LocalDateTime.now();
        
        // Réinitialiser le compteur si c'est un nouveau jour
        if (lastGenerationTime.getDayOfMonth() != now.getDayOfMonth()) {
            sequence.set(1);
        }
        lastGenerationTime = now;

        return String.format("%s-%s-%s-%s-%s-%04d",
            PREFIX,
            now.toLocalDate().toString().replace("-", ""),
            now.toLocalTime().toString().replace(":", "").substring(0, 4),
            validateStationCode(departureStation),
            validateStationCode(arrivalStation),
            sequence.getAndIncrement()
        );
    }

    private static String validateStationCode(String code) {
        // Validation des codes gare (exemple avec codes IATA)
        if (code == null || code.length() != 3 || !code.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Code station invalide: " + code);
        }
        return code;
    }

    // Exemple d'utilisation
    public static void main(String[] args) {
        System.out.println(generateReference("PAR", "LYO")); // TRAIN-20231025-0830-PAR-LYO-0001
        System.out.println(generateReference("LYS", "MRS")); // TRAIN-20231025-0830-LYS-MRS-0002
    }
}