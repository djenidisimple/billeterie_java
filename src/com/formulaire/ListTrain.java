package com.formulaire;
import com.gestion.GestionTrain;
import com.gestion.PanelEventListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
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
        String titre[] = {"id", "Nom du Train", "Capacité Total", "Nombre de Place Occuper"};
        Object enreg[][] = new Object[1][1];

        try {
            GestionTrain gestTrain = new GestionTrain();
            int nbr = gestTrain.countAllById(com.gestion.ValuePassed.idTrajet);
            enreg = new Object[nbr][titre.length];
            ResultSet rs1 = gestTrain.viewById(com.gestion.ValuePassed.idTrajet);
            int i = 0;
            while (rs1.next()) {
                enreg[i][0] = (Object) rs1.getString("trainId");
                enreg[i][1] = (Object) rs1.getString("nameTrain");
                enreg[i][2] = (Object) rs1.getString("capacityTrain");
                enreg[i][3] = (Object) rs1.getString("occuper");
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
        jTable4.getTableHeader().setReorderingAllowed(false);
        jTable4.getTableHeader().setResizingAllowed(false);
        jTable4.setModel(model);
        
        jTable4.getColumnModel().getColumn(0).setMinWidth(0);
        jTable4.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable4.getColumnModel().getColumn(0).setWidth(0);
        
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Appliquer ce renderer à toutes les colonnes
        for (int i = 0; i < jTable4.getColumnCount(); i++) {
            jTable4.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        jScrollPane4.setViewportView(jTable4);
        com.gestion.ValuePassed.idTrain = 0;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jBtnAdd4 = new javax.swing.JButton();
        jBtnEdit4 = new javax.swing.JButton();
        jBtnDelete4 = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        next = new javax.swing.JButton();
        prev = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(860, 453));

        jPanel6.setBackground(java.awt.SystemColor.scrollbar);
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(860, 453));

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));

        jTable4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable4.setFocusable(false);
        jTable4.setRowHeight(30);
        jTable4.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jTable4.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Train de Fianarantsoa");

        jBtnAdd4.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAdd4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnAdd4.setForeground(getForeground());
        jBtnAdd4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icone-plus (1).png"))); // NOI18N
        jBtnAdd4.setMaximumSize(new java.awt.Dimension(22, 23));
        jBtnAdd4.setMinimumSize(new java.awt.Dimension(22, 23));
        jBtnAdd4.setPreferredSize(new java.awt.Dimension(22, 23));
        jBtnAdd4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnAddMouseClicked(evt);
            }
        });

        jBtnEdit4.setBackground(new java.awt.Color(255, 255, 255));
        jBtnEdit4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnEdit4.setForeground(getForeground());
        jBtnEdit4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/editer.png"))); // NOI18N
        jBtnEdit4.setMaximumSize(new java.awt.Dimension(22, 23));
        jBtnEdit4.setMinimumSize(new java.awt.Dimension(22, 23));
        jBtnEdit4.setPreferredSize(new java.awt.Dimension(22, 23));
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

        jBtnDelete4.setBackground(new java.awt.Color(255, 255, 255));
        jBtnDelete4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12)); // NOI18N
        jBtnDelete4.setForeground(getForeground());
        jBtnDelete4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/supprimer.png"))); // NOI18N
        jBtnDelete4.setMaximumSize(new java.awt.Dimension(22, 23));
        jBtnDelete4.setMinimumSize(new java.awt.Dimension(22, 23));
        jBtnDelete4.setPreferredSize(new java.awt.Dimension(22, 23));
        jBtnDelete4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnDeleteMouseClicked(evt);
            }
        });

        reset.setBackground(new java.awt.Color(255, 255, 255));
        reset.setForeground(getForeground());
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/actualise.png"))); // NOI18N
        reset.setMaximumSize(new java.awt.Dimension(22, 23));
        reset.setMinimumSize(new java.awt.Dimension(22, 23));
        reset.setPreferredSize(new java.awt.Dimension(22, 23));
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

        next.setBackground(new java.awt.Color(255, 255, 255));
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/angle-de-la-fleche-pointant-vers-la-droite.png"))); // NOI18N
        next.setMaximumSize(new java.awt.Dimension(22, 23));
        next.setMinimumSize(new java.awt.Dimension(22, 23));
        next.setPreferredSize(new java.awt.Dimension(22, 23));
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

        prev.setBackground(new java.awt.Color(255, 255, 255));
        prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/fleche-fine-contour-vers-la-gauche.png"))); // NOI18N
        prev.setMaximumSize(new java.awt.Dimension(22, 23));
        prev.setMinimumSize(new java.awt.Dimension(22, 23));
        prev.setPreferredSize(new java.awt.Dimension(22, 23));
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnDelete4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnEdit4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBtnAdd4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnEdit4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnDelete4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(30, 30, 30))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 868, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
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
        if(evt.getSource() == jBtnAdd4) {
            // Créer et afficher le nouveau formulaire
            RegisterTrain form = new RegisterTrain();
            form.setVisible(true);
        }
    }//GEN-LAST:event_jBtnAddMouseClicked

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnEditActionPerformed

    private void jBtnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnEditMouseClicked
        if(evt.getSource() == jBtnEdit4) {
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

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        loadTable();
        com.gestion.ValuePassed.idTrain = 0;
    }//GEN-LAST:event_resetMouseClicked

    private void resetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_resetMouseEntered

    private void resetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_resetMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdd4;
    private javax.swing.JButton jBtnDelete4;
    private javax.swing.JButton jBtnEdit4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable4;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
