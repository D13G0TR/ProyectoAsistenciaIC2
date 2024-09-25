package cl.ipst.sca.controllers;

import cl.ipst.sca.config.ConexionBBDD;
import cl.ipst.sca.model.Cargo;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con los cargos en la
 * base de datos. Permite buscar, agregar, actualizar y eliminar cargos, así
 * como listar todos los cargos disponibles.
 *
 * @author rober
 * @version 1.0
 */
public class CargoController {

    private ConexionBBDD con;

    /**
     * Constructor de CargoController que inicializa la conexión a la base de
     * datos.
     */
    public CargoController() {
        con = new ConexionBBDD();
    }

    /**
     * Busca un cargo por su ID.
     *
     * @param idCar El ID del cargo a buscar.
     * @return El objeto Cargo correspondiente al ID, o null si no se encuentra.
     * @throws SQLException Si ocurre un error en la consulta SQL.
     */
    public Cargo buscarPorId(int idCar) throws SQLException {
        String query = "SELECT * FROM cargos WHERE ID = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, idCar);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cargo(
                        rs.getInt("ID"),
                        rs.getString("CARGO")
                );
            }
        }
        return null;  // Si no se encuentra el cargo
    }

    /**
     * Busca un cargo por su nombre.
     *
     * @param nombreCargo El nombre del cargo a buscar.
     * @return El objeto Cargo correspondiente al nombre, o null si no se
     * encuentra.
     * @throws SQLException Si ocurre un error en la consulta SQL.
     */
    public Cargo buscarPorNombre(String nombreCargo) throws SQLException {
        String query = "SELECT * FROM cargos WHERE CARGO = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setString(1, nombreCargo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cargo(
                        rs.getInt("ID"),
                        rs.getString("CARGO")
                );
            }
        }
        return null;  // Si no se encuentra el cargo
    }

    /**
     * Agrega un nuevo cargo a la base de datos.
     *
     * @param cargo El objeto Cargo a agregar.
     * @throws SQLException Si ocurre un error en la consulta SQL.
     */
    public void agregarCargo(Cargo cargo) throws SQLException {
        String query = "INSERT INTO cargos (CARGO) VALUES (?)";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setString(1, cargo.getCargo());
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza un cargo existente en la base de datos.
     *
     * @param cargo El objeto Cargo con la información actualizada.
     * @throws SQLException Si ocurre un error en la consulta SQL.
     */
    public void actualizarCargo(Cargo cargo) throws SQLException {
        String query = "UPDATE cargos SET CARGO = ? WHERE ID = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setString(1, cargo.getCargo());
            stmt.setInt(2, cargo.getIdCar());
            stmt.executeUpdate();
        }
    }

    /**
     * Elimina un cargo de la base de datos por su ID.
     *
     * @param idCar El ID del cargo a eliminar.
     * @throws SQLException Si ocurre un error en la consulta SQL.
     */
    public void eliminarCargo(int idCar) throws SQLException {
        String query = "DELETE FROM cargos WHERE ID = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, idCar);
            stmt.executeUpdate();
        }
    }

    /**
     * Lista todos los cargos disponibles en la base de datos.
     *
     * @return Una lista de objetos Cargo.
     * @throws SQLException Si ocurre un error en la consulta SQL.
     */
    public List<Cargo> listarTodosLosCargos() throws SQLException {
        String query = "SELECT * FROM cargos";
        List<Cargo> cargos = new ArrayList<>();
        try (Statement stmt = con.crearSentencia()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Cargo cargo = new Cargo(
                        rs.getInt("ID"),
                        rs.getString("CARGO")
                );
                cargos.add(cargo);
            }
        }
        return cargos;
    }

}
