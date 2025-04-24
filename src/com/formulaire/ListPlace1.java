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
        //JScrollPane scrollPane = new JScrollPane(contentsPlace2);
        //contentsPlace2.add(scrollPane);

        
        ResultSet row = place.getPlaceById(com.gestion.ValuePassed.idTrajet, com.gestion.ValuePassed.idTrain);
        
        int line = 0;
        
        int i = 45, counter = 0, j = 10;
        int spacingX = 60, spacingY = 60;
        try
        {
            while (row.next())
            {
                RoundedPanel itemPanel = new RoundedPanel();
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


                if (line % 10 == 0 && line != 0) { // 4 panels par ligne
                    j += spacingY; // Nouvelle ligne
                    i = 45; // Réinitialiser X
                    //contentsPlace2.setPreferredSize(new Dimension(100, j + spacingY));
                }


                itemPanel.setBounds(i, j, 56, 49); // position du panel
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
        jButton1 = new javax.swing.JButton();
        jBtnRes = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jBtnExport = new javax.swing.JButton();
        nameTrain = new javax.swing.JLabel();
        nbPass = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        prev = new javax.swing.JButton();
        labelPlace = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentsPlace2 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Annuler");

        jBtnRes.setText("Réserver");
        jBtnRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnResMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jBtnExport.setBackground(new java.awt.Color(51, 51, 51));
        jBtnExport.setForeground(new java.awt.Color(255, 255, 255));
        jBtnExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/export.png"))); // NOI18N
        jBtnExport.setText("Exporter");
        jBtnExport.setPreferredSize(new java.awt.Dimension(95, 34));
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

        nameTrain.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        nameTrain.setForeground(new java.awt.Color(255, 255, 255));
        nameTrain.setText("Tom");

        nbPass.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        nbPass.setForeground(new java.awt.Color(255, 255, 255));
        nbPass.setText("50");

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Passagers");

        prev.setMaximumSize(new java.awt.Dimension(106, 38));
        prev.setMinimumSize(new java.awt.Dimension(106, 38));
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevjButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(nameTrain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(nbPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(168, 168, 168)
                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTrain, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nbPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        labelPlace.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        labelPlace.setForeground(new java.awt.Color(0, 0, 0));
        labelPlace.setText("Place choisi :");

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(580, 230));

        contentsPlace2.setBackground(new java.awt.Color(255, 255, 255));
        contentsPlace2.setAutoscrolls(true);

        javax.swing.GroupLayout contentsPlace2Layout = new javax.swing.GroupLayout(contentsPlace2);
        contentsPlace2.setLayout(contentsPlace2Layout);
        contentsPlace2Layout.setHorizontalGroup(
            contentsPlace2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        contentsPlace2Layout.setVerticalGroup(
            contentsPlace2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(contentsPlace2);

        jPanel2.add(jScrollPane1, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jBtnRes, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(69, 69, 69)))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(labelPlace)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnRes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentsPlace2;
    private javax.swing.JButton jBtnExport;
    private javax.swing.JButton jBtnRes;
    private javax.swing.JButton jButton1;
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
