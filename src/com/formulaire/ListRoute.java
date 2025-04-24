package com.formulaire;

import java.sql.ResultSet;
import javax.swing.table.*;
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
        String titre[] = {"id", "Gare de départ", "Gare d'arriver", "date de départ" , "date d'arriver", "Encore actif"};
        Object enreg[][] = new Object[1][1];

        try {
            GestionRoute gestRoute = new GestionRoute();
            int nbr = gestRoute.countAll();
            enreg = new Object[nbr][titre.length];
            ResultSet rs1 = gestRoute.viewAll();
            int i = 0;
            
            while (rs1.next()) {
                enreg[i][0] = (Object) rs1.getString("routeId");
                enreg[i][1] = (Object) rs1.getString("placeOfDeparture");
                enreg[i][2] = (Object) rs1.getString("placeOfArrival");
                enreg[i][3] = (Object) rs1.getString("dateLeave");
                enreg[i][4] = (Object) rs1.getString("dateArrived");
                enreg[i][5] = (Object) rs1.getBoolean("IsActive");
                i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DefaultTableModel model = new DefaultTableModel(enreg, titre) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Toutes les cellules sont non modifiables
            }
        };
        
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.setModel(model);
        //hide l'id
        jTable2.getColumnModel().getColumn(0).setMinWidth(0);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(0).setWidth(0);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Appliquer ce renderer à toutes les colonnes
        for (int i = 0; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
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
        reset = new javax.swing.JButton();

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

        contents.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Trajet existant");

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Rendre le tableau non éditable
            }
        });
        jTable2.setFocusable(false);
        jTable2.setGridColor(new java.awt.Color(153, 153, 153));
        jTable2.setRequestFocusEnabled(false);
        jTable2.setRowHeight(30);
        jTable2.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jBtnDelete2.setBackground(UIManager.getColor("Button.background"));
        jBtnDelete2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnDelete2.setForeground(new java.awt.Color(0, 0, 0));
        jBtnDelete2.setText("Supprimer");
        jBtnDelete2.setMaximumSize(new java.awt.Dimension(106, 38));
        jBtnDelete2.setMinimumSize(new java.awt.Dimension(106, 38));
        jBtnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDelete2ActionPerformed(evt);
            }
        });

        jBtnEdit2.setBackground(UIManager.getColor("Button.background"));
        jBtnEdit2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnEdit2.setForeground(new java.awt.Color(0, 0, 0));
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

        jBtnAdd2.setBackground(UIManager.getColor("Button.background"));
        jBtnAdd2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnAdd2.setForeground(new java.awt.Color(0, 0, 0));
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

        reset.setBackground(UIManager.getColor("Button.background"));
        reset.setForeground(UIManager.getColor("Button.foreground"));
        reset.setText("Reinitialiser");
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resetMouseExited(evt);
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
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentsLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 345, Short.MAX_VALUE)
                                .addComponent(reset)
                                .addGap(36, 36, 36)
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
                    .addGroup(contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBtnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                loadTable();
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

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        loadTable();
        com.gestion.ValuePassed.idTrajet = 0;
        com.gestion.ValuePassed.idTrain = 0;
    }//GEN-LAST:event_resetMouseClicked

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
        reset.setBackground(UIManager.getColor("Button.background"));
        reset.setForeground(UIManager.getColor("Button.foreground"));
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        reset.setBackground(UIManager.getColor("Button.background"));
        reset.setForeground(UIManager.getColor("Button.foreground"));
    }//GEN-LAST:event_resetMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contents;
    private javax.swing.JButton jBtnAdd2;
    private javax.swing.JButton jBtnDelete2;
    private javax.swing.JButton jBtnEdit2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton next;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
