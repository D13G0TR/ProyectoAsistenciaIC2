package cl.ipst.sca.controllers;

import cl.ipst.sca.config.ConexionBBDD;
import cl.ipst.sca.model.Cargo;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rober
 */
public class CargoController {

    private ConexionBBDD con;

    public CargoController() {
        con = new ConexionBBDD();
    }

    // Buscar cargo por ID
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

    // Buscar cargo por nombre
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

    // Agregar cargo
    public void agregarCargo(Cargo cargo) throws SQLException {
        String query = "INSERT INTO cargos (CARGO) VALUES (?)";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setString(1, cargo.getCargo());
            stmt.executeUpdate();
        }
    }

    // Actualizar cargo
    public void actualizarCargo(Cargo cargo) throws SQLException {
        String query = "UPDATE cargos SET CARGO = ? WHERE ID = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setString(1, cargo.getCargo());
            stmt.setInt(2, cargo.getIdCar());
            stmt.executeUpdate();
        }
    }

    // Eliminar cargo
    public void eliminarCargo(int idCar) throws SQLException {
        String query = "DELETE FROM cargos WHERE ID = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, idCar);
            stmt.executeUpdate();
        }
    }

    // Listar todos los cargos
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
