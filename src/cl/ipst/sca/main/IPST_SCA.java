package cl.ipst.sca.main;

import cl.ipst.sca.frames.*;
import com.formdev.flatlaf.FlatIntelliJLaf;

/**
 * Clase principal de la aplicación Sistema de Control de Asistencia (SCA).
 *
 * Esta clase contiene el método principal que se ejecuta al iniciar la
 * aplicacion. Configura el Look and Feel y muestra el formulario de inicio de
 * sesion.
 *
 * @author Roberto Vargas Vargas
 */
public class IPST_SCA {

    /**
     * Método principal que inicia la aplicación.
     *
     * Este método configura el Look and Feel a la versión de IntelliJ y muestra
     * la ventana de inicio de sesión.
     *
     * @param args Los argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        // Cargamos el Look&Feel versión IntelliJ
        FlatIntelliJLaf.setup();

        // Crear e inicializar la ventana de inicio de sesión
        frmLogin v = new frmLogin();
        v.setSize(340, 400);
        v.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        v.setVisible(true); // Hacer visible la ventana de inicio de sesión
    }
}
