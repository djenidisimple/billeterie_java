package com.formulaire;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import com.gestion.GestionRoute;
import javax.swing.*;
import java.awt.*;
import com.formulaire.RegisterRoute;
import com.gestion.PanelEventListener;

public class ListRoute extends javax.swing.JPanel {
    private String id = "0";
    private PanelEventListener listener;
    /**
     * Creates new form ListRoute1
     */
    public ListRoute() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(920, 541));
        initComponents();
        loadTable();
    }
    
    public void setMonPanelListener(PanelEventListener listener) {
        this.listener = listener;
    }
    
    public void loadTable() {
        String titre[] = {"id","trainId", "Gare de départ", "Gare d'arriver", "date de départ" , "date d'arriver", "Encore actif"};
        Object enreg[][] = new Object[1][1];

        try {
            GestionRoute gestRoute = new GestionRoute();
            int nbr = gestRoute.countAll();
            enreg = new Object[nbr][titre.length];
            ResultSet rs1 = gestRoute.viewAll();
            int i = 0;
            while (rs1.next()) {
                enreg[i][0] = (Object) rs1.getString("routeId");
                enreg[i][1] = (Object) rs1.getString("trainId");
                enreg[i][2] = (Object) rs1.getString("placeOfDeparture");
                enreg[i][3] = (Object) rs1.getString("placeOfArrival");
                enreg[i][4] = (Object) rs1.getString("dateLeave");
                enreg[i][5] = (Object) rs1.getString("dateArrived");
                enreg[i][6] = (Object) rs1.getBoolean("IsActive");
                i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jTable2.setModel(new DefaultTableModel(enreg, titre));
        jScrollPane2.setViewportView(jTable2);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        contents = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jBtnDelete2 = new javax.swing.JButton();
        jBtnEdit2 = new javax.swing.JButton();
        jBtnAdd2 = new javax.swing.JButton();
        next = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new java.awt.BorderLayout());

        contents.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Trajet existant");

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Nom", "Capacité", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jBtnDelete2.setBackground(new java.awt.Color(0, 0, 0));
        jBtnDelete2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnDelete2.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDelete2.setText("Supprimer");
        jBtnDelete2.setMaximumSize(new java.awt.Dimension(106, 38));
        jBtnDelete2.setMinimumSize(new java.awt.Dimension(106, 38));
        jBtnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDelete2ActionPerformed(evt);
            }
        });

        jBtnEdit2.setBackground(new java.awt.Color(0, 0, 0));
        jBtnEdit2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnEdit2.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEdit2.setText("Modifier");
        jBtnEdit2.setMaximumSize(new java.awt.Dimension(106, 38));
        jBtnEdit2.setMinimumSize(new java.awt.Dimension(106, 38));
        jBtnEdit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEdit2MouseClicked(evt);
            }
        });
        jBtnEdit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEdit2ActionPerformed(evt);
            }
        });

        jBtnAdd2.setBackground(new java.awt.Color(0, 0, 0));
        jBtnAdd2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnAdd2.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAdd2.setText("Ajouter");
        jBtnAdd2.setMaximumSize(new java.awt.Dimension(106, 38));
        jBtnAdd2.setMinimumSize(new java.awt.Dimension(106, 38));
        jBtnAdd2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAdd2MouseClicked(evt);
            }
        });
        jBtnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdd2ActionPerformed(evt);
            }
        });

        next.setMaximumSize(new java.awt.Dimension(106, 38));
        next.setMinimumSize(new java.awt.Dimension(106, 38));
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
        });
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentsLayout = new javax.swing.GroupLayout(contents);
        contents.setLayout(contentsLayout);
        contentsLayout.setHorizontalGroup(
            contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentsLayout.createSequentialGroup()
                        .addComponent(jBtnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jBtnEdit2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentsLayout.createSequentialGroup()
                        .addGroup(contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
                            .addGroup(contentsLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jBtnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
        );
        contentsLayout.setVerticalGroup(
            contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentsLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jBtnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEdit2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        add(contents, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int ligne = jTable2.getSelectedRow();
        id = String.valueOf(jTable2.getValueAt(ligne, 0));
    }//GEN-LAST:event_jTable2MouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void jBtnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDelete2ActionPerformed
        GestionRoute route = new GestionRoute();
        try
        {
            int reponse = JOptionPane.showConfirmDialog(
                null, // Composant parent (peut être null)
                "Voulez-vous vraiment supprimer l'id = " + id + " ?", // Message
                "Confirmation", // Titre
                JOptionPane.YES_NO_CANCEL_OPTION, // Type d'options
                JOptionPane.QUESTION_MESSAGE // Type d'icône
            );
            switch(reponse) {
                case JOptionPane.YES_OPTION:
                System.out.println("Oui cliqué");
                int idStringToInt = Integer.parseInt(id);
                route.delete(idStringToInt);
                JOptionPane.showMessageDialog(this, "Suppression reussite id = " + idStringToInt);
                break;
                case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(this, "Suppression Annuler!");
                break;
                case JOptionPane.CANCEL_OPTION:
                JOptionPane.showMessageDialog(this, "Suppression Annuler!");
                break;
                case JOptionPane.CLOSED_OPTION:
                System.out.println("Fermé sans réponse");
                break;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        loadTable();
    }//GEN-LAST:event_jBtnDelete2ActionPerformed

    private void jBtnEdit2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEdit2MouseClicked
        if(evt.getSource() == jBtnEdit2) {
            // Créer et afficher le nouveau formulaire
            if(id.compareTo("0") == 0)
            {
                JOptionPane.showMessageDialog(this, "Veuilliez choisir une donnée!");
            } 
            else 
            {
                com.gestion.ValuePassed.idTrajet = Integer.parseInt(id);
                RegisterRoute form = new RegisterRoute();
                form.setVisible(true);
            }
        }
    }//GEN-LAST:event_jBtnEdit2MouseClicked

    private void jBtnEdit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEdit2ActionPerformed
        
    }//GEN-LAST:event_jBtnEdit2ActionPerformed

    private void jBtnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdd2ActionPerformed
        
    }//GEN-LAST:event_jBtnAdd2ActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextActionPerformed

    private void jBtnAdd2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAdd2MouseClicked
        if(evt.getSource() == jBtnAdd2) {
            // Créer et afficher le nouveau formulaire
            RegisterRoute form = new RegisterRoute();
            form.setVisible(true);
        }
        loadTable();
    }//GEN-LAST:event_jBtnAdd2MouseClicked

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        if(evt.getSource() == next) {
            // Créer et afficher le nouveau formulaire
            if(id.compareTo("0") == 0)
            {
                JOptionPane.showMessageDialog(this, "Veuilliez choisir une donnée!");
            } 
            else 
            {
                com.gestion.ValuePassed.idTrajet = Integer.parseInt(id);
                com.gestion.ValuePassed.page = 1;
                if (listener != null) {
                    listener.onPanelAction("train");
                }
                else {
                    System.out.println("Listener is NULL !");
                }
            }
        }
    }//GEN-LAST:event_nextMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contents;
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnAdd1;
    private javax.swing.JButton jBtnAdd2;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnDelete1;
    private javax.swing.JButton jBtnDelete2;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnEdit1;
    private javax.swing.JButton jBtnEdit2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton next;
    // End of variables declaration//GEN-END:variables
}
