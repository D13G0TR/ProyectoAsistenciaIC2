
package Vistas;

import Modelos.GeneradorPDF;
import Modelos.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class Asist extends javax.swing.JFrame {

   
    public Asist() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AtrasoButton = new javax.swing.JButton();
        AnticipoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AtrasoButton.setText("Reporte Ingreso atrasado");
        AtrasoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasoButtonActionPerformed(evt);
            }
        });

        AnticipoButton.setText("Reporte Salida anticipada");
        AnticipoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnticipoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(AtrasoButton)
                .addGap(34, 34, 34)
                .addComponent(AnticipoButton)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AtrasoButton)
                    .addComponent(AnticipoButton))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AtrasoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasoButtonActionPerformed
          Conexion conexionBD = new Conexion();
        Connection connection = conexionBD.getConnection();
        if (connection != null) {
            GeneradorPDF.generarReporteAtrasos(connection);
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
        
    }//GEN-LAST:event_AtrasoButtonActionPerformed

    private void AnticipoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnticipoButtonActionPerformed
        Conexion conexionBD = new Conexion();
        Connection connection = conexionBD.getConnection();
        if (connection != null) {
            GeneradorPDF.generarReporteAnticipos(connection);
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }//GEN-LAST:event_AnticipoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Asist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Asist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Asist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Asist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Asist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnticipoButton;
    private javax.swing.JButton AtrasoButton;
    // End of variables declaration//GEN-END:variables
}
