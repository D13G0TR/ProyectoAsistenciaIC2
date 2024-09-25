package cl.ipst.sca.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 * Clase para gestionar la conexión a la base de datos MySQL. Proporciona
 * métodos para crear sentencias SQL y manejar la conexión.
 *
 * @author rober
 * @version 2.0
 */
public class ConexionBBDD {

    private Connection conn;
    private String url = "jdbc:mysql://localhost/ipst_sca";
    private String username = "root";
    private String password = "";

    /**
     * Registra el controlador de MySQL.
     *
     * @return true si se registró correctamente, false si ocurrió un error.
     */
    private boolean registrar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /**
     * Obtiene una conexión a la base de datos.
     *
     * @return true si se logró la conexión, false si ocurrió un error.
     */
    private boolean obtenerConexion() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            return true;
        } catch (SQLException e) {
            System.out.println("Error al conectar a la BBDD: " + e.getMessage());
            return false;
        }
    }

    /**
     * Crea una sentencia SQL.
     *
     * @return un objeto Statement para realizar consultas SQL, o null si
     * ocurrió un error.
     */
    public Statement crearSentencia() {
        try {
            if (conn != null && !conn.isClosed()) {
                return conn.createStatement();
            }
        } catch (SQLException e) {
            System.out.println("Error al crear la sentencia: " + e.getMessage());
        }
        return null;
    }

    /**
     * Prepara una sentencia SQL con parámetros.
     *
     * @param query La consulta SQL a preparar.
     * @return un objeto PreparedStatement para realizar consultas SQL, o null
     * si ocurrió un error.
     */
    public PreparedStatement prepararSentencia(String query) {
        try {
            if (conn != null && !conn.isClosed()) {
                return conn.prepareStatement(query);
            }
        } catch (SQLException e) {
            System.out.println("Error al preparar la sentencia: " + e.getMessage());
        }
        return null;
    }

    /**
     * Constructor de ConexionBBDD que registra el controlador y establece la
     * conexión. Si no se puede conectar, muestra un mensaje de error y termina
     * la ejecución.
     */
    public ConexionBBDD() {
        registrar();
        if (!obtenerConexion()) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    /**
     * Desconecta la conexión a la base de datos.
     *
     * @return un mensaje indicando el estado de la desconexión.
     */
    public String Desconectar() {
        try {
            if (conn != null) {
                conn.close();
                return "Desconectado";
            } else {
                return "No existe una conexión activa";
            }
        } catch (SQLException e) {
            return "Error al desconectar";
        }
    }

    /**
     * Prueba la conexión a la base de datos y muestra un mensaje indicando el
     * resultado.
     *
     * @return true si la conexión fue exitosa, false si falló.
     */
    public boolean probarConexion() {
        registrar();
        if (obtenerConexion()) {
            JOptionPane.showMessageDialog(null, "Base de datos conectada exitosamente.", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
