package com.formulaire;
import javax.swing.*;
import java.awt.*;
import com.formulaire.*;
/**
 *
 * @author Djenidi
 */
public class Home extends javax.swing.JFrame implements com.gestion.PanelEventListener {
    
    /**
     * Creates new form Home
     */
    public Home() {
        setTitle("Train Ticket");
        ImageIcon icon = new ImageIcon(getClass().getResource("/com/icon/icon.png"));
        setIconImage(icon.getImage());
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(920, 541));
        initComponents();
        loadForm(new Dashboard());
        
        //place.freePlace();
    }
    
    
    public void loadForm(JPanel form) {
        contents.removeAll(); // Supprimer le contenu actuel
        contents.add(form); // Ajouter le nouveau formulaire
        contents.revalidate(); // Actualiser l'affichage
        contents.repaint();
        setVisible(true);
    }
    /**
     * @param p the page of window form or JPanel
     */
    @Override
    public void onPanelAction(String message) {
        switch (message) {
            case "route":
                ListRoute listRoute = new ListRoute();
                listRoute.setMonPanelListener(this);
                com.gestion.ValuePassed.idTrain = 0;
                com.gestion.ValuePassed.idTrajet = 0;
                loadForm(listRoute);
                break;
            case "train":
                ListTrain listTrain = new ListTrain(); // 1. on crée UNE instance
                listTrain.setMonPanelListener(this);   // 2. on lui met le listener
                loadForm(listTrain);                   // 3. on l'affiche
                break;
            case "place":
                ListPlace1 listPlace = new ListPlace1();
                listPlace.setMonPanelListener(this);
                loadForm(listPlace);
                //setContentPane(listPlace);
                break;
            default:
                JOptionPane.showMessageDialog(this, "OK");
                break;
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        jBtnRes = new javax.swing.JButton();
        jBtnDashboard = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jBtnPass = new javax.swing.JButton();
        contents = new javax.swing.JPanel();

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        menu.setBackground(new java.awt.Color(255, 255, 255));

        jBtnRes.setBackground(UIManager.getColor("Button.background"));
        jBtnRes.setForeground(new java.awt.Color(255, 255, 255));
        jBtnRes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/reservation.png"))); // NOI18N
        jBtnRes.setToolTipText("Reservation");
        jBtnRes.setBorder(null);
        jBtnRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnResMouseClicked(evt);
            }
        });

        jBtnDashboard.setBackground(UIManager.getColor("Button.background"));
        jBtnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        jBtnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/applications (1).png"))); // NOI18N
        jBtnDashboard.setToolTipText("Dashboard");
        jBtnDashboard.setBorder(null);
        jBtnDashboard.setBorderPainted(false);
        jBtnDashboard.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jBtnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnDashboardMouseEntered(evt);
            }
        });
        jBtnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDashboardActionPerformed(evt);
            }
        });

        jButton11.setBackground(UIManager.getColor("Button.background"));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/parametre.png"))); // NOI18N
        jButton11.setToolTipText("Paramètre");
        jButton11.setBorder(null);

        jBtnPass.setBackground(UIManager.getColor("Button.background"));
        jBtnPass.setForeground(new java.awt.Color(255, 255, 255));
        jBtnPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/client.png"))); // NOI18N
        jBtnPass.setToolTipText("Lstes des passagers");
        jBtnPass.setBorder(null);
        jBtnPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBtnPassMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBtnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jBtnRes, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jBtnPass, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addComponent(jBtnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnRes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnPass, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        contents.setForeground(new java.awt.Color(0, 0, 0));
        contents.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contents, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(contents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDashboardActionPerformed
        loadForm(new Dashboard());
    }//GEN-LAST:event_jBtnDashboardActionPerformed

    private void jBtnResMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnResMouseClicked
        //loadForm(new ListRoute());
        ListRoute listRoute = new ListRoute();
        listRoute.setMonPanelListener(this);
        com.gestion.ValuePassed.idTrain = 0;
        com.gestion.ValuePassed.idTrajet = 0;
        loadForm(listRoute);
    }//GEN-LAST:event_jBtnResMouseClicked

    private void jBtnPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnPassMouseClicked
        loadForm(new ListPassenger());
    }//GEN-LAST:event_jBtnPassMouseClicked

    private void jBtnDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnDashboardMouseEntered
        jBtnDashboard.setBackground(UIManager.getColor("Button.background"));
        jBtnDashboard.setForeground(UIManager.getColor("Button.foreground"));
    }//GEN-LAST:event_jBtnDashboardMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contents;
    private javax.swing.JButton jBtnDashboard;
    private javax.swing.JButton jBtnPass;
    private javax.swing.JButton jBtnRes;
    private javax.swing.JButton jButton11;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables
}
