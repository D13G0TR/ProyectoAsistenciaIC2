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
 *
 * @author rober
 */
public class TrabajadorController {

    private ConexionBBDD con;
    TurnoController turnoController = new TurnoController();
    CargoController cargoController = new CargoController();

    public TrabajadorController() {
        con = new ConexionBBDD();
    }

    // Buscar trabajador por RUT
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

    // Buscar trabajador por nombre
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

    // Agregar trabajador
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

    // Actualizar trabajador
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

    public boolean activarTrabajador(int rut) throws SQLException {
        String query = "UPDATE trabajadores SET ESTADO = 1 WHERE RUT = ?";
        try (PreparedStatement stmt = con.prepararSentencia(query)) {
            stmt.setInt(1, rut);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Devuelve true si al menos una fila fue actualizada
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
    }

    // Listar todos los trabajadores
    public List<Trabajador> listarTodosLosTrabajadores() throws SQLException {
        String query = "SELECT * FROM trabajadores";
        List<Trabajador> trabajadores = new ArrayList<>();
        try (Statement stmt = con.crearSentencia()) {
            ResultSet rs = stmt.executeQuery(query);
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

    // Método para calcular el dígito verificador
    private static char calcularDigitoVerificador(int rut) {
        int m = 0, s = 1;
        while (rut != 0) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
            rut /= 10;
        }
        return (char) (s != 0 ? s + 47 : 75);  // 75 es 'K', y el resto se devuelve como un número
    }

}
