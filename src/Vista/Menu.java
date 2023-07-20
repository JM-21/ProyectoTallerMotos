/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnAggCliente = new javax.swing.JButton();
        btnAggMoto = new javax.swing.JButton();
        btnAggServicio = new javax.swing.JButton();
        btnListaServi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Menu");

        btnAggCliente.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAggCliente.setText("Agregar Cliente");
        btnAggCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggClienteActionPerformed(evt);
            }
        });

        btnAggMoto.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAggMoto.setText("Agregar Moto");
        btnAggMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggMotoActionPerformed(evt);
            }
        });

        btnAggServicio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnAggServicio.setText("Agregar Servicio");
        btnAggServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggServicioActionPerformed(evt);
            }
        });

        btnListaServi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnListaServi.setText("Ver lista de Servicios Prestados");
        btnListaServi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaServiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAggServicio)
                            .addComponent(btnAggMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAggCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnListaServi)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblTitulo)
                .addGap(26, 26, 26)
                .addComponent(btnAggCliente)
                .addGap(26, 26, 26)
                .addComponent(btnAggMoto)
                .addGap(26, 26, 26)
                .addComponent(btnAggServicio)
                .addGap(32, 32, 32)
                .addComponent(btnListaServi)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAggClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggClienteActionPerformed
        // TODO add your handling code here:
        FrmAggCliente frm = new FrmAggCliente();
        frm.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnAggClienteActionPerformed

    private void btnAggMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggMotoActionPerformed
        // TODO add your handling code here:
        FrmAggMoto frm = new FrmAggMoto();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAggMotoActionPerformed

    private void btnAggServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggServicioActionPerformed
        // TODO add your handling code here:
        FrmServicio frm = new FrmServicio();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAggServicioActionPerformed

    private void btnListaServiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaServiActionPerformed
        try {
            // TODO add your handling code here:
            FrmListasServicios frm = new FrmListasServicios();
            frm.setVisible(true);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnListaServiActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAggCliente;
    private javax.swing.JButton btnAggMoto;
    private javax.swing.JButton btnAggServicio;
    private javax.swing.JButton btnListaServi;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
