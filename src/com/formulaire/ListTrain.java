package com.formulaire;
import com.gestion.GestionRoute;
import com.gestion.GestionTrain;
import com.gestion.PanelEventListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Djenidi
 */
public class ListTrain extends javax.swing.JPanel {
    private String id = "0";
    private PanelEventListener listener;
    /**
     * Creates new form ListTrain1
     */
    public ListTrain() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(920, 541));
        initComponents();
        loadTable();
    }
    
    public void setMonPanelListener(PanelEventListener listener) {
        this.listener = listener;
    }
    
    public void loadTable() {
        String titre[] = {"id", "Nom", "Capacité"};
        Object enreg[][] = new Object[1][1];

        try {
            GestionTrain gestTrain = new GestionTrain();
            int nbr = gestTrain.countAll();
            enreg = new Object[nbr][titre.length];
            ResultSet rs1 = gestTrain.viewAll();
            int i = 0;
            while (rs1.next()) {
                enreg[i][0] = (Object) rs1.getString("trainId");
                enreg[i][1] = (Object) rs1.getString("nameTrain");
                enreg[i][2] = (Object) rs1.getString("capacityTrain");
                i++;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        jTable4.setModel(new DefaultTableModel(enreg, titre));
        jScrollPane4.setViewportView(jTable4);
        com.gestion.ValuePassed.idTrain = 0;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jBtnDelete4 = new javax.swing.JButton();
        next = new javax.swing.JButton();
        jBtnEdit4 = new javax.swing.JButton();
        jBtnAdd4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        prev = new javax.swing.JButton();

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Train de Fianarantsoa");

        jBtnDelete4.setBackground(new java.awt.Color(0, 0, 0));
        jBtnDelete4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnDelete4.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDelete4.setText("Supprimer");
        jBtnDelete4.setMaximumSize(new java.awt.Dimension(106, 38));
        jBtnDelete4.setMinimumSize(new java.awt.Dimension(106, 38));
        jBtnDelete4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnDeleteMouseClicked(evt);
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
                jButton2ActionPerformed(evt);
            }
        });

        jBtnEdit4.setBackground(new java.awt.Color(0, 0, 0));
        jBtnEdit4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnEdit4.setForeground(new java.awt.Color(255, 255, 255));
        jBtnEdit4.setText("Modifier");
        jBtnEdit4.setMaximumSize(new java.awt.Dimension(106, 38));
        jBtnEdit4.setMinimumSize(new java.awt.Dimension(106, 38));
        jBtnEdit4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnEditMouseClicked(evt);
            }
        });
        jBtnEdit4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });

        jBtnAdd4.setBackground(new java.awt.Color(0, 0, 0));
        jBtnAdd4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnAdd4.setForeground(new java.awt.Color(255, 255, 255));
        jBtnAdd4.setText("Ajouter");
        jBtnAdd4.setMaximumSize(new java.awt.Dimension(106, 38));
        jBtnAdd4.setMinimumSize(new java.awt.Dimension(106, 38));
        jBtnAdd4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAddMouseClicked(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        prev.setMaximumSize(new java.awt.Dimension(106, 38));
        prev.setMinimumSize(new java.awt.Dimension(106, 38));
        prev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prevMouseClicked(evt);
            }
        });
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jBtnDelete4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jBtnEdit4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jBtnAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnDelete4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnEdit4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        int ligne = jTable4.getSelectedRow();
        id = String.valueOf(jTable4.getValueAt(ligne, 0));
    }//GEN-LAST:event_jTableMouseClicked

    private void jBtnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnAddMouseClicked
        if(evt.getSource() == jBtnAdd) {
            // Créer et afficher le nouveau formulaire
            RegisterTrain form = new RegisterTrain();
            form.setVisible(true);
        }
        loadTable();
    }//GEN-LAST:event_jBtnAddMouseClicked

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEditActionPerformed

    private void jBtnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEditMouseClicked
        if(evt.getSource() == jBtnEdit) {
            if(id.compareTo("0") != 0)
            {
                com.gestion.ValuePassed.idTrain = Integer.parseInt(id);
                // Créer et afficher le nouveau formulaire
                RegisterTrain form = new RegisterTrain();
                form.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Veuilliez séléctionner une donnée!");
            }
        }
        loadTable();
    }//GEN-LAST:event_jBtnEditMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBtnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnDeleteMouseClicked
        if(id.compareTo("0") != 0)
        {
            GestionTrain train = new GestionTrain();
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
                    train.delete(idStringToInt);
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
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Veuilliez séléctionner une donnée!");
        }
    }//GEN-LAST:event_jBtnDeleteMouseClicked

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        if(evt.getSource() == next) {
            // Créer et afficher le nouveau formulaire
            if(id.compareTo("0") == 0)
            {
                JOptionPane.showMessageDialog(this, "Veuilliez choisir une donnée!");
            } 
            else 
            {
                com.gestion.ValuePassed.idTrain = Integer.parseInt(id);
                com.gestion.ValuePassed.page = 2;
                if (listener != null) {
                    listener.onPanelAction("place");
                }
                else {
                    System.out.println("Listener is NULL !");
                }
            }
        }
    }//GEN-LAST:event_nextMouseClicked

    private void prevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevMouseClicked
        if(evt.getSource() == prev) {
            // Créer et afficher le nouveau formulaire
            com.gestion.ValuePassed.page = 0;
            if (listener != null) {
                listener.onPanelAction("route");
            }
            else {
                System.out.println("Listener is NULL !");
            }
        }
    }//GEN-LAST:event_prevMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnAdd1;
    private javax.swing.JButton jBtnAdd2;
    private javax.swing.JButton jBtnAdd3;
    private javax.swing.JButton jBtnAdd4;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnDelete1;
    private javax.swing.JButton jBtnDelete2;
    private javax.swing.JButton jBtnDelete3;
    private javax.swing.JButton jBtnDelete4;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnEdit1;
    private javax.swing.JButton jBtnEdit2;
    private javax.swing.JButton jBtnEdit3;
    private javax.swing.JButton jBtnEdit4;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    // End of variables declaration//GEN-END:variables
}
