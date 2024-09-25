package cl.ipst.sca.frames;

import cl.ipst.sca.controllers.LoginController;
import cl.ipst.sca.model.Trabajador;
import javax.swing.JOptionPane;

/**
 *
 * @author rober
 */
public class frmLogin extends javax.swing.JFrame {

    LoginController loginController = new LoginController();

    /**
     *
     * Creates new form frmLogin
     */
    public frmLogin() {
        initComponents();
        ClearAll();
    }

    /**
     * Limpia todos los campos de entrada en el formulario de inicio de sesión.
     */
    private void ClearAll() {
        txtClave.setText(null);
        txtCorreo.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtClave = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Asistencia");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLabel2.setText("Correo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 260, -1));

        jLabel8.setText("Clave");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        btnLogin.setText("Ingresar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Iniciar Sesión");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 310, -1));

        txtClave.setNextFocusableComponent(btnLogin);
        getContentPane().add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 260, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setText("v1.0");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Maneja el evento de acción del botón de inicio de sesión. Valida que los
     * campos de correo y clave no estén vacíos y intenta autenticar al
     * trabajador utilizando el controlador de inicio de sesión. Si la
     * autenticación es exitosa, se verifica el estado del trabajador y se carga
     * la vista correspondiente (admin o user).
     *
     * @param evt el evento de acción que ha provocado la llamada a este método
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String correo = txtCorreo.getText().trim();
        String clave = new String(txtClave.getPassword()).trim();

        //Validamos que los campos no estén vacíos
        if (correo.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar su correo y clave.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        } else {
            Trabajador tAux = loginController.loginTrabajador(correo, clave);
            if (tAux != null) {
                if (tAux.getEstadoTra() == true) {
                    System.out.println("El usuario " + tAux.getNombresTra() + " ha iniciado sesion.");
                    //Cerramos la ventana
                    dispose();

                    //Si es ADMIN cargamos la vista de ADMIN
                    if (tAux.getCargoTra().getIdCar() == 1) {
                        //Cargamos el main frame ADMIN
                        frmAdmin v = new frmAdmin();
                        v.setSize(1200, 950);
                        v.setLocationRelativeTo(null);
                        v.setVisible(true);
                    } else {
                        //Cargamos el main frame USER
                        frmUser v = new frmUser();
                        v.setSize(1200, 950);
                        v.setLocationRelativeTo(null);
                        v.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Su cuenta se encuentra deshabilitada. Contacte al Administrador", "Cuenta deshabilitada", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Las credenciales ingresadas no son validas.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
