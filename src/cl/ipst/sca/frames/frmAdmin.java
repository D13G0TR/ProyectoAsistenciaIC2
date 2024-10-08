package cl.ipst.sca.frames;

import cl.ipst.sca.config.ConexionBBDD;
import cl.ipst.sca.model.Trabajador;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Roberto Vargas Vargas
 */
public class frmAdmin extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        miPanel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Reportes = new javax.swing.JMenu();
        jmiAtrasos = new javax.swing.JMenuItem();
        jmiAdelantos = new javax.swing.JMenuItem();
        jmiInasistencias = new javax.swing.JMenuItem();
        GestionUsuarios = new javax.swing.JMenu();
        jmiAddUser = new javax.swing.JMenuItem();
        jmiEditUser = new javax.swing.JMenuItem();
        jmiDelUser = new javax.swing.JMenuItem();
        Ayuda = new javax.swing.JMenu();
        jmiProbarConexion = new javax.swing.JMenuItem();
        jmiAyuda = new javax.swing.JMenuItem();
        jmiCerrarSesion = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout miPanelLayout = new javax.swing.GroupLayout(miPanel);
        miPanel.setLayout(miPanelLayout);
        miPanelLayout.setHorizontalGroup(
            miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        miPanelLayout.setVerticalGroup(
            miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );

        Reportes.setText("Reportes");

        jmiAtrasos.setText("Reporte de Atrasos");
        jmiAtrasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAtrasosActionPerformed(evt);
            }
        });
        Reportes.add(jmiAtrasos);

        jmiAdelantos.setText("Reporte de Salidas Tempranas");
        jmiAdelantos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAdelantosActionPerformed(evt);
            }
        });
        Reportes.add(jmiAdelantos);

        jmiInasistencias.setText("Reporte de Inasistencias");
        jmiInasistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiInasistenciasActionPerformed(evt);
            }
        });
        Reportes.add(jmiInasistencias);

        jMenuBar1.add(Reportes);

        GestionUsuarios.setText("Gestión de Trabajadores");

        jmiAddUser.setText("Añadir Trabajador");
        jmiAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddUserActionPerformed(evt);
            }
        });
        GestionUsuarios.add(jmiAddUser);

        jmiEditUser.setText("Modificar Trabajador");
        jmiEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditUserActionPerformed(evt);
            }
        });
        GestionUsuarios.add(jmiEditUser);

        jmiDelUser.setText("Eliminar Trabajador");
        jmiDelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDelUserActionPerformed(evt);
            }
        });
        GestionUsuarios.add(jmiDelUser);

        jMenuBar1.add(GestionUsuarios);

        Ayuda.setText("Ayuda");

        jmiProbarConexion.setText("Probar Conexión a BBDD");
        jmiProbarConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProbarConexionActionPerformed(evt);
            }
        });
        Ayuda.add(jmiProbarConexion);

        jmiAyuda.setText("Acerca de");
        jmiAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAyudaActionPerformed(evt);
            }
        });
        Ayuda.add(jmiAyuda);

        jMenuBar1.add(Ayuda);

        jmiCerrarSesion.setText("Cerrar Sesión");
        jmiCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmiCerrarSesionMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmiCerrarSesion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Maneja la acción del menú para abrir el reporte de atrasos.
     *
     * Este método se ejecuta cuando se selecciona la opción "Atrasos" del menú.
     * Crea una nueva instancia de la ventana de reporte de atrasos y la agrega
     * al panel.
     *
     * @param evt El evento que se genera al seleccionar la opción del menú.
     */
    private void jmiAtrasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAtrasosActionPerformed
        frmReporteAtrasos v = new frmReporteAtrasos();
        miPanel.add(v);
        v.setVisible(true);
    }//GEN-LAST:event_jmiAtrasosActionPerformed
    /**
     * Maneja la acción del menú para abrir el reporte de salidas anticipadas.
     *
     * Este método se ejecuta cuando se selecciona la opción "Adelantos" del
     * menú. Crea una nueva instancia de la ventana de reporte de salidas
     * anticipadas y la agrega al panel.
     *
     * @param evt El evento que se genera al seleccionar la opción del menú.
     */
    private void jmiAdelantosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAdelantosActionPerformed
        frmReporteSalidasAnt v = new frmReporteSalidasAnt();
        miPanel.add(v);
        v.setVisible(true);
    }//GEN-LAST:event_jmiAdelantosActionPerformed
    /**
     * Maneja la acción del menú para abrir el reporte de inasistencias.
     *
     * Este método se ejecuta cuando se selecciona la opción "Inasistencias" del
     * menú. Crea una nueva instancia de la ventana de reporte de inasistencias
     * y la agrega al panel. Maneja posibles excepciones al inicializar la
     * ventana.
     *
     * @param evt El evento que se genera al seleccionar la opción del menú.
     */
    private void jmiInasistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiInasistenciasActionPerformed
        frmReporteInasistencias v = null;
        try {
            v = new frmReporteInasistencias();
        } catch (ParseException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        miPanel.add(v);
        v.setVisible(true);
    }//GEN-LAST:event_jmiInasistenciasActionPerformed
    /**
     * Maneja la acción del menú Ayuda que muestra información del sistema.
     *
     * Este método se ejecuta cuando se selecciona la opción "Ayuda" del menú.
     * Muestra un cuadro de diálogo con información sobre el sistema y los
     * programadores que lo desarrollaron.
     *
     * @param evt El evento que se genera al seleccionar la opción del menú.
     */
    private void jmiAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAyudaActionPerformed
        ImageIcon icono = new ImageIcon(getClass().getResource("/cl/ipst/sca/resources/ipst.png"));
        String mensaje = "<html><div style='text-align: center;'>"
                + "<b>Sistema de Gestión de Asistencia</b><br>"
                + "<hr>"
                + "Programadores: <br>"
                + "Diego Troncoso <br>"
                + "Claudio Trigo <br>"
                + "Roberto Vargas <br>"
                + "<br>"
                + "Docente: Alejandro Vargas<br>"
                + "Integración de Competencias II<br>"
                + "Instituto Profesional Santo Tomás - Sede Arica"
                + "</div></html>";

        JOptionPane.showMessageDialog(null, mensaje,
                "Sistema de Control de Asistencia", JOptionPane.INFORMATION_MESSAGE, icono);
    }//GEN-LAST:event_jmiAyudaActionPerformed
    /**
     * Maneja la acción del menú para probar la conexión a la base de datos.
     *
     * Este método se ejecuta cuando se selecciona la opción "Probar Conexión"
     * del menú. Realiza una prueba de conexión a la base de datos.
     *
     * @param evt El evento que se genera al seleccionar la opción del menú.
     */
    private void jmiProbarConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProbarConexionActionPerformed
        //Test de conexión
        ConexionBBDD conexion = new ConexionBBDD();
        conexion.probarConexion();
    }//GEN-LAST:event_jmiProbarConexionActionPerformed
    /**
     * Maneja la acción del menú para cerrar la sesión del usuario.
     *
     * Este método se ejecuta cuando se hace clic en el menú "Cerrar Sesión".
     * Muestra un cuadro de diálogo de confirmación y, si se confirma, cierra la
     * sesión del usuario y muestra el formulario de inicio de sesión.
     *
     * @param evt El evento que se genera al hacer clic en el menú.
     */
    private void jmiCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiCerrarSesionMouseClicked
        int respuesta = JOptionPane.showConfirmDialog(
                null, // Componente padre
                "¿Desea cerrar sesión?", // Mensaje
                "Confirmación", // Título del diálogo
                JOptionPane.YES_NO_OPTION, // Tipo de opciones (Sí/No)
                JOptionPane.QUESTION_MESSAGE // Tipo de mensaje (pregunta)
        );
        if (respuesta == JOptionPane.YES_OPTION) {
            //Cerramos la ventana
            dispose();

            //Cerramos la sesión SINGLETON
            Trabajador.getInstancia().cerrarSesion();

            frmLogin v = new frmLogin();
            v.setSize(340, 400);
            v.setLocationRelativeTo(null);
            v.setVisible(true);
        }
    }//GEN-LAST:event_jmiCerrarSesionMouseClicked
    /**
     * Maneja la acción del menú para agregar un nuevo usuario.
     *
     * Este método se ejecuta cuando se selecciona la opción "Agregar Usuario"
     * del menú. Crea una nueva instancia de la ventana para agregar un usuario
     * y la agrega al panel. Maneja posibles excepciones al inicializar la
     * ventana.
     *
     * @param evt El evento que se genera al seleccionar la opción del menú.
     */
    private void jmiAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddUserActionPerformed
        frmNuevoUsuario v = null;
        try {
            v = new frmNuevoUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        miPanel.add(v);
        v.setVisible(true);
    }//GEN-LAST:event_jmiAddUserActionPerformed
    /**
     * Maneja la acción del menú para editar un usuario existente.
     *
     * Este método se ejecuta cuando se selecciona la opción "Editar Usuario"
     * del menú. Crea una nueva instancia de la ventana para editar un usuario y
     * la agrega al panel. Maneja posibles excepciones al inicializar la
     * ventana.
     *
     * @param evt El evento que se genera al seleccionar la opción del menú.
     */
    private void jmiEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditUserActionPerformed
        frmEditarUsuario v = null;
        try {
            v = new frmEditarUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        miPanel.add(v);
        v.setVisible(true);
    }//GEN-LAST:event_jmiEditUserActionPerformed
    /**
     * Maneja la acción del menú para eliminar un usuario existente.
     *
     * Este método se ejecuta cuando se selecciona la opción "Eliminar Usuario"
     * del menú. Crea una nueva instancia de la ventana para eliminar un usuario
     * y la agrega al panel. Maneja posibles excepciones al inicializar la
     * ventana.
     *
     * @param evt El evento que se genera al seleccionar la opción del menú.
     */
    private void jmiDelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDelUserActionPerformed
        frmEliminarUsuario v = null;
        try {
            v = new frmEliminarUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(frmAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        miPanel.add(v);
        v.setVisible(true);
    }//GEN-LAST:event_jmiDelUserActionPerformed

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
            java.util.logging.Logger.getLogger(frmAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdmin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Ayuda;
    private javax.swing.JMenu GestionUsuarios;
    private javax.swing.JMenu Reportes;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jmiAddUser;
    private javax.swing.JMenuItem jmiAdelantos;
    private javax.swing.JMenuItem jmiAtrasos;
    private javax.swing.JMenuItem jmiAyuda;
    private javax.swing.JMenu jmiCerrarSesion;
    private javax.swing.JMenuItem jmiDelUser;
    private javax.swing.JMenuItem jmiEditUser;
    private javax.swing.JMenuItem jmiInasistencias;
    private javax.swing.JMenuItem jmiProbarConexion;
    private javax.swing.JDesktopPane miPanel;
    // End of variables declaration//GEN-END:variables
}
