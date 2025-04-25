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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        next1 = new javax.swing.JButton();
        next = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jBtnDelete2 = new javax.swing.JButton();
        jBtnEdit2 = new javax.swing.JButton();
        jBtnAdd2 = new javax.swing.JButton();

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

        contents.setBackground(java.awt.SystemColor.scrollbar);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Trajet existant");

        next1.setBackground(new java.awt.Color(255, 255, 255));
        next1.setForeground(getForeground());
        next1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/fleche-fine-contour-vers-la-gauche.png"))); // NOI18N
        next1.setMaximumSize(new java.awt.Dimension(106, 38));
        next1.setMinimumSize(new java.awt.Dimension(106, 38));
        next1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                next1MouseClicked(evt);
            }
        });
        next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next1ActionPerformed(evt);
            }
        });

        next.setBackground(new java.awt.Color(255, 255, 255));
        next.setForeground(UIManager.getColor("Button.foreground"));
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/angle-de-la-fleche-pointant-vers-la-droite.png"))); // NOI18N
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

        reset.setBackground(new java.awt.Color(255, 255, 255));
        reset.setForeground(UIManager.getColor("Button.foreground"));
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/actualise.png"))); // NOI18N
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

        jBtnDelete2.setBackground(new java.awt.Color(255, 255, 255));
        jBtnDelete2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnDelete2.setForeground(UIManager.getColor("Button.foreground"));
        jBtnDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/supprimer.png"))); // NOI18N
        jBtnDelete2.setMaximumSize(new java.awt.Dimension(106, 38));
        jBtnDelete2.setMinimumSize(new java.awt.Dimension(106, 38));
        jBtnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDelete2ActionPerformed(evt);
            }
        });

        jBtnEdit2.setBackground(new java.awt.Color(255, 255, 255));
        jBtnEdit2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnEdit2.setForeground(UIManager.getColor("Button.foreground"));
        jBtnEdit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/editer.png"))); // NOI18N
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

        jBtnAdd2.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAdd2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnAdd2.setForeground(UIManager.getColor("Button.foreground"));
        jBtnAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icone-plus (1).png"))); // NOI18N
        jBtnAdd2.setMaximumSize(new java.awt.Dimension(106, 38));
        jBtnAdd2.setMinimumSize(new java.awt.Dimension(106, 38));
        jBtnAdd2.setPreferredSize(new java.awt.Dimension(22, 23));
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addComponent(next1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnEdit2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnAdd2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnDelete2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEdit2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(next1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentsLayout = new javax.swing.GroupLayout(contents);
        contents.setLayout(contentsLayout);
        contentsLayout.setHorizontalGroup(
            contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contentsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(31, 31, 31))
        );
        contentsLayout.setVerticalGroup(
            contentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
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

    private void next1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_next1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_next1MouseClicked

    private void next1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_next1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contents;
    private javax.swing.JButton jBtnAdd2;
    private javax.swing.JButton jBtnDelete2;
    private javax.swing.JButton jBtnEdit2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton next;
    private javax.swing.JButton next1;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
