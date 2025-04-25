package com.gestion;

import javax.swing.*;
import java.awt.*;

public class RoundedPanel extends JPanel {
    private Color fillColor; // Couleur actuelle
    private int borderRadius = 0;

    public RoundedPanel(int radius) {
        super();
        this.borderRadius = radius;
        setOpaque(false);
    }

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
        Dimension arcs = new Dimension(borderRadius, borderRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g.create(); // Toujours créer une copie avec .create()

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Couleur de fond actuelle
        graphics.setColor(fillColor);
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

        graphics.dispose(); // Bonne pratique
    }
}