package billeterie;
import com.formulaire.*;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;

public class Billeterie {

    public static void main(String[] args) {
        try {
            UIManager.put("Button.hoverBackground", new Color(230, 230, 230)); // Gris clair
            UIManager.put("Button.hoverForeground", new Color(60, 60, 60));    // Texte foncé

            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Échec lors de l'initialisation de FlatLaf");
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    
}
