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
 * La clase TurnoController es responsable de gestionar las operaciones
 * relacionadas con los turnos en la base de datos. Esto incluye la búsqueda,
 * adición, actualización y eliminación de turnos.
 *
 * <p>
 * Utiliza la clase ConexionBBDD para manejar la conexión a la base de
 * datos.</p>
 *
 * @author rober
 * @version 1.0
 */
public class TurnoController {

    /**
     * Conexión a la base de datos
     */
    private ConexionBBDD con;

    /**
     * Constructor de la clase TurnoController. Inicializa la conexión a la base
     * de datos.
     */
    public TurnoController() {
        con = new ConexionBBDD();
    }

    /**
     * Busca un turno por su identificador.
     *
     * @param idTurno el identificador del turno a buscar
     * @return el turno correspondiente, o null si no se encuentra
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
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

    /**
     * Busca un turno por su descripción.
     *
     * @param descripcionTurno la descripción del turno a buscar
     * @return el turno correspondiente, o null si no se encuentra
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
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

    /**
     * Agrega un nuevo turno a la base de datos.
     *
     * @param turno el turno a agregar
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    public void agregarTurno(Turno turno) throws SQLException {
        String query = "INSERT INTO turnos (DESCRIPCION, INGRESO, SALIDA) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setString(1, turno.getDescripcionTurno());
            stmt.setTime(2, Time.valueOf(turno.getHoraIngreso()));
            stmt.setTime(3, Time.valueOf(turno.getHoraSalida()));
            stmt.executeUpdate();
        }
    }

    /**
     * Actualiza un turno existente en la base de datos.
     *
     * @param turno el turno con la información actualizada
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
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

    /**
     * Elimina un turno de la base de datos por su identificador.
     *
     * @param idTurno el identificador del turno a eliminar
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
    public void eliminarTurno(int idTurno) throws SQLException {
        String query = "DELETE FROM turnos WHERE ID = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, idTurno);
            stmt.executeUpdate();
        }
    }

    /**
     * Lista todos los turnos disponibles en la base de datos.
     *
     * @return una lista de todos los turnos
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
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
