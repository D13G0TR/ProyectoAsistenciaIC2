package cl.ipst.sca.controllers;

import cl.ipst.sca.config.ConexionBBDD;
import cl.ipst.sca.model.Turno;
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
public class TurnoController {

    private ConexionBBDD con;

    public TurnoController() {
        con = new ConexionBBDD();
    }

    // Buscar turno por ID
    public Turno buscarPorId(int idTurno) throws SQLException {
        String query = "SELECT * FROM turnos WHERE ID = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, idTurno);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Turno(
                        rs.getInt("ID"),
                        rs.getString("DESCRIPCION"),
                        rs.getTime("INGRESO").toLocalTime(),
                        rs.getTime("SALIDA").toLocalTime()
                );
            }
        }
        return null;  // Si no se encuentra el turno
    }

    // Buscar turno por nombre
    public Turno buscarPorNombre(String descripcionTurno) throws SQLException {
        String query = "SELECT * FROM turnos WHERE DESCRIPCION = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setString(1, descripcionTurno);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Turno(
                        rs.getInt("ID"),
                        rs.getString("DESCRIPCION"),
                        rs.getTime("INGRESO").toLocalTime(),
                        rs.getTime("SALIDA").toLocalTime()
                );
            }
        }
        return null;  // Si no se encuentra el turno
    }

    // Agregar turno
    public void agregarTurno(Turno turno) throws SQLException {
        String query = "INSERT INTO turnos (DESCRIPCION, INGRESO, SALIDA) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setString(1, turno.getDescripcionTurno());
            stmt.setTime(2, Time.valueOf(turno.getHoraIngreso()));
            stmt.setTime(3, Time.valueOf(turno.getHoraSalida()));
            stmt.executeUpdate();
        }
    }

    // Actualizar turno
    public void actualizarTurno(Turno turno) throws SQLException {
        String query = "UPDATE turnos SET DESCRIPCION = ?, INGRESO = ?, SALIDA = ? WHERE ID = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setString(1, turno.getDescripcionTurno());
            stmt.setTime(2, Time.valueOf(turno.getHoraIngreso()));
            stmt.setTime(3, Time.valueOf(turno.getHoraSalida()));
            stmt.setInt(4, turno.getIdTurno());
            stmt.executeUpdate();
        }
    }

    // Eliminar turno
    public void eliminarTurno(int idTurno) throws SQLException {
        String query = "DELETE FROM turnos WHERE ID = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, idTurno);
            stmt.executeUpdate();
        }
    }

    // Listar todos los turnos
    public List<Turno> listarTodosLosTurnos() throws SQLException {
        String query = "SELECT * FROM turnos";
        List<Turno> turnos = new ArrayList<>();
        try (Statement stmt = con.crearSentencia()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Turno turno = new Turno(
                        rs.getInt("ID"),
                        rs.getString("DESCRIPCION"),
                        rs.getTime("INGRESO").toLocalTime(),
                        rs.getTime("SALIDA").toLocalTime()
                );
                turnos.add(turno);
            }
        }
        return turnos;
    }
}
