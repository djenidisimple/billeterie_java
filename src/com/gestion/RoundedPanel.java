package com.gestion;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class RoundedPanel extends JPanel {
    private Color fillColor = Color.WHITE; // Couleur par défaut
    private int borderRadius = 12;

    // Setter pour la couleur de remplissage
    public void setFillColor(Color color) {
        this.fillColor = color;
        repaint(); // Redessine le panel
    }

    // Getter pour la couleur de remplissage
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        
        // Activation de l'anti-aliasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Dessin du fond arrondi
        if (fillColor != null) {
            g2d.setColor(fillColor);
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
        }
        
        g2d.dispose();
    }
}