package cl.ipst.sca.controllers;

import cl.ipst.sca.config.ConexionBBDD;
import cl.ipst.sca.model.Cargo;
import cl.ipst.sca.model.Trabajador;
import cl.ipst.sca.model.Turno;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona las operaciones relacionadas con los trabajadores.
 * Proporciona métodos para buscar, agregar, actualizar y validar trabajadores
 * en la base de datos.
 *
 * @author rober
 * @version 1.0
 */
public class TrabajadorController {

    private ConexionBBDD con;  // Conexión a la base de datos.
    private TurnoController turnoController = new TurnoController(); // Controlador para gestionar los turnos de los trabajadores.
    private CargoController cargoController = new CargoController(); // Controlador para gestionar los cargos de los trabajadores.

    public TrabajadorController() {
        con = new ConexionBBDD();
    }

    /**
     * Busca un trabajador en la base de datos por su RUT.
     *
     * @param rut El RUT del trabajador a buscar.
     * @return El objeto Trabajador correspondiente al RUT, o null si no se
     * encuentra.
     * @throws SQLException Si ocurre un error en la consulta a la base de
     * datos.
     */
    public Trabajador buscarPorRut(int rut) throws SQLException {
        String query = "SELECT * FROM trabajadores WHERE RUT = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, rut);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Turno turno = turnoController.buscarPorId(rs.getInt("ID"));
                Cargo cargo = cargoController.buscarPorId(rs.getInt("CAR_ID"));

                Trabajador tAux = new Trabajador();
                tAux.setRutTra(rs.getInt("RUT"));
                tAux.setDvTra(rs.getString("DV").charAt(0));
                tAux.setTurnoTra(turno);
                tAux.setCargoTra(cargo);
                tAux.setNombresTra(rs.getString("NOMBRES"));
                tAux.setApellidosTra(rs.getString("APELLIDOS"));
                tAux.setCorreoTra(rs.getString("CORREO"));
                tAux.setClaveTra(rs.getString("CLAVE"));
                tAux.setDepartamentoTra(rs.getString("DEPARTAMENTO"));
                tAux.setAreaTra(rs.getString("AREA"));
                tAux.setEstadoTra(rs.getBoolean("ESTADO"));

                return tAux;
            }
        }
        return null; // Si no se encuentra el trabajador
    }

    /**
     * Busca trabajadores en la base de datos por sus nombres.
     *
     * @param nombresTra El nombre o parte del nombre a buscar.
     * @return Una lista de objetos Trabajador que coinciden con el nombre.
     * @throws SQLException Si ocurre un error en la consulta a la base de
     * datos.
     */
    public List<Trabajador> buscarPorNombre(String nombresTra) throws SQLException {
        String query = "SELECT * FROM trabajadores WHERE NOMBRES LIKE ?";
        List<Trabajador> trabajadores = new ArrayList<>();
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setString(1, "%" + nombresTra + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Turno turno = turnoController.buscarPorId(rs.getInt("ID"));
                Cargo cargo = cargoController.buscarPorId(rs.getInt("CAR_ID"));

                Trabajador tAux = new Trabajador();
                tAux.setRutTra(rs.getInt("RUT"));
                tAux.setDvTra(rs.getString("DV").charAt(0));
                tAux.setTurnoTra(turno);
                tAux.setCargoTra(cargo);
                tAux.setNombresTra(rs.getString("NOMBRES"));
                tAux.setApellidosTra(rs.getString("APELLIDOS"));
                tAux.setCorreoTra(rs.getString("CORREO"));
                tAux.setClaveTra(rs.getString("CLAVE"));
                tAux.setDepartamentoTra(rs.getString("DEPARTAMENTO"));
                tAux.setAreaTra(rs.getString("AREA"));
                tAux.setEstadoTra(rs.getBoolean("ESTADO"));

                trabajadores.add(tAux);
            }
        }
        return trabajadores;
    }

    /**
     * Agrega un nuevo trabajador a la base de datos.
     *
     * @param trabajador El objeto Trabajador a agregar.
     * @return true si el trabajador fue agregado exitosamente, false en caso
     * contrario.
     * @throws SQLException Si ocurre un error en la inserción a la base de
     * datos.
     */
    public boolean agregarTrabajador(Trabajador trabajador) throws SQLException {
        String query = "INSERT INTO trabajadores (RUT, DV, ID, CAR_ID, NOMBRES, APELLIDOS, DEPARTAMENTO, AREA, CORREO, CLAVE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, trabajador.getRutTra());
            stmt.setString(2, String.valueOf(trabajador.getDvTra()));
            stmt.setInt(3, trabajador.getTurnoTra().getIdTurno());
            stmt.setInt(4, trabajador.getCargoTra().getIdCar());
            stmt.setString(5, trabajador.getNombresTra());
            stmt.setString(6, trabajador.getApellidosTra());
            stmt.setString(7, trabajador.getDepartamentoTra());
            stmt.setString(8, trabajador.getAreaTra());
            stmt.setString(9, trabajador.getCorreoTra());
            stmt.setString(10, trabajador.getClaveTra());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Devuelve true si al menos una fila fue insertada
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
    }

    /**
     * Actualiza la información de un trabajador existente en la base de datos.
     *
     * @param trabajador El objeto Trabajador con la información actualizada.
     * @return true si el trabajador fue actualizado exitosamente, false en caso
     * contrario.
     * @throws SQLException Si ocurre un error en la actualización de la base de
     * datos.
     */
    public boolean actualizarTrabajador(Trabajador trabajador) throws SQLException {
        String query = "UPDATE trabajadores SET ID = ?, CAR_ID = ?, NOMBRES = ?, APELLIDOS = ?, DEPARTAMENTO = ?, AREA = ?, CORREO = ?, CLAVE = ?, ESTADO = ? WHERE RUT = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, trabajador.getTurnoTra().getIdTurno());
            stmt.setInt(2, trabajador.getCargoTra().getIdCar());
            stmt.setString(3, trabajador.getNombresTra());
            stmt.setString(4, trabajador.getApellidosTra());
            stmt.setString(5, trabajador.getDepartamentoTra());
            stmt.setString(6, trabajador.getAreaTra());
            stmt.setString(7, trabajador.getCorreoTra());
            stmt.setString(8, trabajador.getClaveTra());
            stmt.setBoolean(9, trabajador.getEstadoTra());
            stmt.setInt(10, trabajador.getRutTra());
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Devuelve true si al menos una fila fue actualizada
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
    }

    /**
     * Desactiva un trabajador en la base de datos.
     *
     * @param rut El RUT del trabajador a desactivar.
     * @return true si el trabajador fue desactivado exitosamente, false en caso
     * contrario.
     * @throws SQLException Si ocurre un error en la actualización de la base de
     * datos.
     */
    public boolean desactivarTrabajador(int rut) throws SQLException {
        String query = "UPDATE trabajadores SET ESTADO = 0 WHERE RUT = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, rut);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Devuelve true si al menos una fila fue actualizada
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
    }

    /**
     * Activa un trabajador en la base de datos.
     *
     * @param rut El RUT del trabajador a activar.
     * @return true si el trabajador fue activado exitosamente, false en caso
     * contrario.
     * @throws SQLException Si ocurre un error en la actualización de la base de
     * datos.
     */
    public boolean activarTrabajador(int rut) throws SQLException {
        String query = "UPDATE trabajadores SET ESTADO = 1 WHERE RUT = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, rut);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Devuelve true si al menos una fila fue actualizada
        } catch (SQLException e) {
            return false; // Devuelve false si ocurre una excepción
        }
    }

    /**
     * Valida un RUT chileno.
     *
     * @param rut El RUT a validar (sin dígito verificador).
     * @return true si el RUT es válido, false en caso contrario.
     */
    public boolean validarRUT(String rut) {
        // Eliminar puntos y guion del RUT
        rut = rut.replace(".", "").replace("-", "");

        // Verificar que el RUT tenga al menos 2 caracteres (RUT y dígito verificador)
        if (rut.length() < 2) {
            return false;
        }

        // Obtener el dígito verificador
        char digitoVerificador = rut.charAt(rut.length() - 1);

        // Obtener la parte numérica del RUT
        String rutNumerico = rut.substring(0, rut.length() - 1);

        // Validar que la parte numérica sea un número
        if (!rutNumerico.matches("\\d+")) {
            return false;
        }

        // Convertir a entero el RUT sin dígito verificador
        int rutInt = Integer.parseInt(rutNumerico);

        // Calcular el dígito verificador
        char digitoCalculado = calcularDigitoVerificador(rutInt);

        // Comparar el dígito calculado con el proporcionado
        return digitoVerificador == digitoCalculado;
    }

    /**
     * Calcular el DV de un RUT Chileno.
     *
     * @param rut El RUT a verificar.
     * @return el dígito verificador del RUT recibido.
     */
    private static char calcularDigitoVerificador(int rut) {
        int m = 0, s = 1;
        while (rut != 0) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
            rut /= 10;
        }
        return (char) (s != 0 ? s + 47 : 75);  // 75 es 'K', y el resto se devuelve como un número
    }
}
