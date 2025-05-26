package com.formulaire;

import com.formulaire.RegisterPassenger;
import com.gestion.GestionTrain;
import com.gestion.GestionTicket;
import com.gestion.RoundedPanel;
import com.gestion.GestionPlace;
import java.sql.ResultSet;
import com.gestion.ValuePassed;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import com.gestion.GeneratorPdf;
import com.gestion.PanelEventListener;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Djenidi
 */
public class ListPlace1 extends javax.swing.JPanel {
    private int _nbPassager = 0;
    private String id = "0";
    private List<RoundedPanel> selectedPanels = new ArrayList<>();
    private PanelEventListener listener;
    /**
     * Creates new form ListPlace
     */
    public ListPlace1() {
        initComponents();
        loadPanelPlace();
    }

    public record SeatData(int placeId, String seatNumber) {}
    
    public void setMonPanelListener(PanelEventListener listener) {
        this.listener = listener;
    }
    
    private void loadPanelPlace()
    {
        GestionTrain train = new GestionTrain();
        GestionPlace place = new GestionPlace();
        nameTrain.setText("" + train.getIdByNames(com.gestion.ValuePassed.idTrain));
        nbPass.setText("" + place.getNumberPlaceById(com.gestion.ValuePassed.idTrajet));
        if(place.getNumberPlaceById(com.gestion.ValuePassed.idTrajet) <= 1)
        {
            jLabel4.setText("Passager");
        }
        contentsPlace2.removeAll();
        
        ResultSet row = place.getPlaceById(com.gestion.ValuePassed.idTrajet, com.gestion.ValuePassed.idTrain);
        
        int line = 0;
        
        int i = 95, counter = 0, j = 12;
        int spacingX = 95, spacingY = 60;
        try
        {
            while (row.next())
            {
                RoundedPanel itemPanel = new RoundedPanel(20);
                itemPanel.setPreferredSize(new Dimension(56, 49));
                itemPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
                itemPanel.setOpaque(false);
                try
                {
                    //define color in fonction of place stat
                    if ((boolean)row.getBoolean("EstDisponible"))
                    {
                        itemPanel.setFillColor(CustomColors.DARK_BLUE);
                    }
                    else
                    {
                        itemPanel.setFillColor(CustomColors.MEDIUM_SEA_GREEN);
                        _nbPassager++;
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Erreur 1 : " + e.getMessage());
                    break;
                }


                if (line % 4 == 0 && line != 0) {
                    j += spacingY; // Nouvelle ligne
                    i = 95; // Réinitialiser X
                    //contentsPlace2.setPreferredSize(new Dimension(100, 350));
                }


                itemPanel.setBounds(i, j, 56, 49); // position du panel
                if (counter % 2 != 0) {
                    i += 100;
                }
                i += spacingX;
                SeatData data = new SeatData(
                    row.getInt("placeId"), 
                    row.getString("seatNumber")
                );
                itemPanel.putClientProperty("data" , data);// row stocke une donnée d'une base de donnee, venantt de la table personne


                itemPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                            panelMouseClick(e);
                        }
                    }); // abonnement de tous les panel a une evenement click!

                contentsPlace2.add(itemPanel);
                contentsPlace2.revalidate();
                contentsPlace2.repaint();


                line++;
                counter++;
            }
        }
        catch(Exception e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }
        // ScrollPane qui contient le panel des places
        //jScrollPane1 = new JScrollPane(contentsPlace2);
        //jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //jScrollPane1.getVerticalScrollBar().setUnitIncrement(16); // défilement fluide

        // Ajout du scrollPane au centre du panel principal
        //add(jScrollPane1, BorderLayout.CENTER);
    }
    
    public class CustomColors {
        public static final Color DARK_BLUE = new Color(0, 0, 139);
        public static final Color MEDIUM_SEA_GREEN = new Color(60, 179, 113);
    }
    
    private void panelMouseClick(MouseEvent e) {
        if (!(e.getSource() instanceof RoundedPanel)) return;

        RoundedPanel clickPanel = (RoundedPanel) e.getSource();
        SeatData rowData = (SeatData) clickPanel.getClientProperty("data");

        if (rowData == null) {
            JOptionPane.showMessageDialog(this, "Données manquantes !");
            return;
        }

        boolean isDarkBlue = clickPanel.getFillColor().equals(CustomColors.DARK_BLUE);
        boolean isMediumGreen = clickPanel.getFillColor().equals(CustomColors.MEDIUM_SEA_GREEN);
        boolean isSelected = selectedPanels.contains(clickPanel);

        // Correction de la logique conditionnelle
        if ((isDarkBlue || (isMediumGreen && isSelected))) {
            if (isSelected) {
                handleDeselection(clickPanel, rowData);
            } else {
                handleSelection(clickPanel, rowData);
            }
            updateUI();
        }
    }

    private void handleSelection(RoundedPanel panel, SeatData data) {
        selectedPanels.add(panel);
        panel.setFillColor(CustomColors.MEDIUM_SEA_GREEN);
        try
        {
            ValuePassed.idPlace.add(data.placeId);
            ValuePassed.place.add(data.seatNumber);
        }
        catch(Exception e)
        {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    private void handleDeselection(RoundedPanel panel, SeatData data) {
        int index = selectedPanels.indexOf(panel);
        if (index != -1) {
            panel.setFillColor(CustomColors.DARK_BLUE);
            try
            {
                selectedPanels.remove(index);
                ValuePassed.idPlace.remove(Integer.valueOf(data.placeId));
                ValuePassed.place.remove(data.seatNumber);
            }
            catch(Exception e)
            {
                System.out.println("Erreur : " + e.getMessage());
            }
        }
    }
    public void updateUI() {
        SwingUtilities.invokeLater(() -> {
            labelPlace.setText("Place choisi : " + ValuePassed.listToString());
            contentsPlace2.revalidate();
            contentsPlace2.repaint();
        });
        System.out.println(ValuePassed.listToString());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        nameTrain = new javax.swing.JLabel();
        nbPass = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBtnExport = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        jBtnRes = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelPlace = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentsPlace2 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(java.awt.SystemColor.scrollbar);
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        nameTrain.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        nameTrain.setForeground(new java.awt.Color(0, 0, 0));
        nameTrain.setText("Tom");

        nbPass.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        nbPass.setForeground(new java.awt.Color(0, 0, 0));
        nbPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nbPass.setText("50");

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Passagers");

        jBtnExport.setBackground(new java.awt.Color(255, 255, 255));
        jBtnExport.setForeground(getForeground());
        jBtnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/exporter-le-fichier.png"))); // NOI18N
        jBtnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnExportMouseClicked(evt);
            }
        });
        jBtnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExportActionPerformed(evt);
            }
        });

        prev.setBackground(new java.awt.Color(255, 255, 255));
        prev.setForeground(getForeground());
        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/fleche-fine-contour-vers-la-gauche.png"))); // NOI18N
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevjButton3ActionPerformed(evt);
            }
        });

        jBtnRes.setBackground(new java.awt.Color(255, 255, 255));
        jBtnRes.setForeground(getForeground());
        jBtnRes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/reservation-en-ligne.png"))); // NOI18N
        jBtnRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnResMouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(getForeground());
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/annuler.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/multiple-users-silhouette.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(nameTrain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(nbPass, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(100, 100, 100)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnRes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnRes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nameTrain, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nbPass, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        labelPlace.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        labelPlace.setForeground(new java.awt.Color(0, 0, 0));
        labelPlace.setText("Place choisi :");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        contentsPlace2.setBackground(new java.awt.Color(255, 255, 255));
        contentsPlace2.setAutoscrolls(true);
        contentsPlace2.setPreferredSize(new java.awt.Dimension(623, 370));
        contentsPlace2.setLayout(null);
        jScrollPane1.setViewportView(contentsPlace2);

        jPanel2.add(jScrollPane1, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPlace, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPlace)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnResMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnResMouseClicked
        if(ValuePassed.place.size() == 0)
        {
            JOptionPane.showMessageDialog(this, "Veuilliez choisir une place!");
        }
        else
        {
            new RegisterPassenger().setVisible(true);
        }
    }//GEN-LAST:event_jBtnResMouseClicked

    private void prevjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevjButton3ActionPerformed
        if(evt.getSource() == prev) {
            // Créer et afficher le nouveau formulaire
            com.gestion.ValuePassed.page = 1;
            if (listener != null) {
                listener.onPanelAction("train");
            }
            else {
                System.out.println("Listener is NULL !");
            }
        }
    }//GEN-LAST:event_prevjButton3ActionPerformed

    private void jBtnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExportActionPerformed
        try
        {
            GestionTicket gestTicket = new GestionTicket();
            GeneratorPdf.generateBillet(gestTicket.viewAllTicket(), "a");
            if (gestTicket.viewAllTicket().size() == 0){
                JOptionPane.showMessageDialog(this, "Désoler il n'y a pas de place qui a été reserver!");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Le billet a été bien enregistrer en pdf!");
            }
        }
        catch(Exception e)
        {
            System.out.println("Erreur : " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Le billet n'a pas été bien enregistrer en pdf!");
        }
    }//GEN-LAST:event_jBtnExportActionPerformed

    private void jBtnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnExportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnExportMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentsPlace2;
    private javax.swing.JButton jBtnExport;
    private javax.swing.JButton jBtnRes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPlace;
    private javax.swing.JLabel nameTrain;
    private javax.swing.JLabel nbPass;
    private javax.swing.JButton prev;
    // End of variables declaration//GEN-END:variables
}
