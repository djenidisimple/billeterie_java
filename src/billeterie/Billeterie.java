package billeterie;
import com.formulaire.*;
import javax.swing.UIManager;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;

public class Billeterie {

    public static void main(String[] args) {
        try {
            UIManager.put("Button.arc", 20);
            UIManager.put("Component.arc", 20); // Général (boutons, champs texte, etc.)
            UIManager.put("ProgressBar.arc", 20);
            UIManager.put("TextComponent.arc", 20);
            UIManager.put("CheckBox.arc", 10);
            UIManager.put("TabbedPane.tabArc", 15);
            UIManager.put("ScrollBar.thumbArc", 15);
            
            UIManager.put("Button.hoverBackground", new Color(230, 230, 230)); // Gris clair
            UIManager.put("Button.hoverForeground", new Color(60, 60, 60));    // Texte foncé

            UIManager.setLookAndFeel(new FlatMacLightLaf());
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
