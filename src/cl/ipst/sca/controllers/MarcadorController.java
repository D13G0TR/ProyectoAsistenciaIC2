package cl.ipst.sca.controllers;

import cl.ipst.sca.config.ConexionBBDD;
import cl.ipst.sca.model.Ausencia;
import cl.ipst.sca.model.Marcacion;
import cl.ipst.sca.model.Trabajador;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author rober
 */
public class MarcadorController {

    private ConexionBBDD con;

    public MarcadorController() {
        con = new ConexionBBDD();
    }

    private String obtenerNombreDia(DayOfWeek dia) {
        return switch (dia) {
            case MONDAY ->
                "Lunes";
            case TUESDAY ->
                "Martes";
            case WEDNESDAY ->
                "Miércoles";
            case THURSDAY ->
                "Jueves";
            case FRIDAY ->
                "Viernes";
            case SATURDAY ->
                "Sábado";
            case SUNDAY ->
                "Domingo";
            default ->
                "";
        };
    }

    public boolean agregarMarcacion(Marcacion marcacion) {
        String query = "INSERT INTO marcaciones (RUT, FECHA, HORA, TIPO) "
                + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = con.prepararSentencia(query);
            stmt.setInt(1, marcacion.getTrabMarca().getRutTra());
            stmt.setDate(2, Date.valueOf(marcacion.getFecha()));
            stmt.setTime(3, Time.valueOf(marcacion.getHora()));
            stmt.setInt(4, marcacion.getTipo());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error al agregar la marcación: " + e.getMessage());
            return false;
        }
    }

    public List<Marcacion> generarReportesAtrasos() {
        List<Marcacion> marcacionesPosteriores = new ArrayList<>();

        // Consulta para obtener las marcaciones después de las 09:30 y tipo ENTRADA
        String query = "SELECT "
                + "t.RUT, "
                + "t.DV, "
                + "t.NOMBRES, "
                + "t.APELLIDOS, "
                + "t.DEPARTAMENTO, "
                + "m.ID, "
                + "m.FECHA, "
                + "m.HORA, "
                + "m.TIPO "
                + "FROM "
                + "marcaciones m "
                + "JOIN "
                + "trabajadores t ON m.RUT = t.RUT "
                + "WHERE "
                + "m.TIPO = 0 AND m.HORA > '09:30:00';";

        try {
            PreparedStatement stmt = con.prepararSentencia(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Marcacion marcacion = new Marcacion();

                marcacion.setIdMarca(rs.getInt("ID"));
                marcacion.setFecha(rs.getDate("FECHA").toLocalDate());
                marcacion.setHora(rs.getTime("HORA").toLocalTime());
                marcacion.setTipo(rs.getInt("TIPO"));

                Trabajador tAux = new Trabajador();
                tAux.setRutTra(rs.getInt("RUT"));
                tAux.setDvTra(rs.getString("DV").charAt(0));
                tAux.setNombresTra(rs.getString("NOMBRES"));
                tAux.setApellidosTra(rs.getString("APELLIDOS"));
                tAux.setDepartamentoTra(rs.getString("DEPARTAMENTO"));
                marcacion.setTrabMarca(tAux);

                marcacionesPosteriores.add(marcacion);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener marcaciones posteriores a las 09:30: " + e.getMessage());
        }

        return marcacionesPosteriores;
    }

    public List<Marcacion> generarReporteSalidasAnticipadas() {
        List<Marcacion> marcacionesAnticipadas = new ArrayList<>();

        // Consulta para obtener las marcaciones antes de las 17:30:00 y tipo SALIDA
        String query = "SELECT "
                + "t.RUT, "
                + "t.DV, "
                + "t.NOMBRES, "
                + "t.APELLIDOS, "
                + "t.DEPARTAMENTO, "
                + "m.ID, "
                + "m.FECHA, "
                + "m.HORA, "
                + "m.TIPO "
                + "FROM "
                + "marcaciones m "
                + "JOIN "
                + "trabajadores t ON m.RUT = t.RUT "
                + "WHERE "
                + "m.TIPO = 1 AND m.HORA < '17:30:00';";

        try {
            PreparedStatement stmt = con.prepararSentencia(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Marcacion marcacion = new Marcacion();

                marcacion.setIdMarca(rs.getInt("ID"));
                marcacion.setFecha(rs.getDate("FECHA").toLocalDate());
                marcacion.setHora(rs.getTime("HORA").toLocalTime());
                marcacion.setTipo(rs.getInt("TIPO"));

                Trabajador tAux = new Trabajador();
                tAux.setRutTra(rs.getInt("RUT"));
                tAux.setDvTra(rs.getString("DV").charAt(0));
                tAux.setNombresTra(rs.getString("NOMBRES"));
                tAux.setApellidosTra(rs.getString("APELLIDOS"));
                tAux.setDepartamentoTra(rs.getString("DEPARTAMENTO"));
                marcacion.setTrabMarca(tAux);

                marcacionesAnticipadas.add(marcacion);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener marcaciones anteriores a 17:30: " + ex.getMessage());
        }

        return marcacionesAnticipadas;
    }

    public List<Ausencia> generarReporteInasistenciasv2(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Ausencia> inasistencias = new ArrayList<>();
        try {
            // Obtener todos los trabajadores
            String queryTrabajadores = "SELECT RUT, DV, NOMBRES, APELLIDOS FROM trabajadores WHERE CAR_ID != 1;";
            Statement stmtTrabajadores = con.crearSentencia();
            ResultSet rsTrabajadores = stmtTrabajadores.executeQuery(queryTrabajadores);

            // Crear un mapa para almacenar marcaciones
            Map<Integer, Set<LocalDate>> marcacionesPorTrabajador = new HashMap<>();

            // Obtener todas las marcaciones en el rango de fechas
            String queryMarcaciones = "SELECT RUT, FECHA FROM marcaciones WHERE FECHA BETWEEN ? AND ?";
            PreparedStatement stmtMarcaciones = con.prepararSentencia(queryMarcaciones);
            stmtMarcaciones.setDate(1, Date.valueOf(fechaInicio));
            stmtMarcaciones.setDate(2, Date.valueOf(fechaFin));

            ResultSet rsMarcaciones = stmtMarcaciones.executeQuery();
            while (rsMarcaciones.next()) {
                int rut = rsMarcaciones.getInt("RUT");
                LocalDate fecha = rsMarcaciones.getDate("FECHA").toLocalDate();

                marcacionesPorTrabajador
                        .computeIfAbsent(rut, k -> new HashSet<>())
                        .add(fecha);
            }

            // Iterar sobre cada trabajador
            while (rsTrabajadores.next()) {
                int rut = rsTrabajadores.getInt("RUT");
                String nombres = rsTrabajadores.getString("NOMBRES");
                String apellidos = rsTrabajadores.getString("APELLIDOS");
                char dv = rsTrabajadores.getString("DV").charAt(0);

                // Iterar sobre cada día en el rango de fechas
                LocalDate fechaActual = fechaInicio;
                while (!fechaActual.isAfter(fechaFin)) {
                    // Verificar si la fecha es un día laboral (lunes a sábado)
                    if (fechaActual.getDayOfWeek().getValue() <= 6) {
                        // Comprobar si el trabajador tiene marcaciones en la fecha actual
                        if (!marcacionesPorTrabajador.getOrDefault(rut, Collections.emptySet()).contains(fechaActual)) {
                            Ausencia a = new Ausencia();

                            Trabajador t = new Trabajador();
                            t.setRutTra(rut);
                            t.setDvTra(dv);
                            t.setNombresTra(nombres);
                            t.setApellidosTra(apellidos);

                            a.setTra(t);
                            a.setFecha(fechaActual);
                            a.setDia(obtenerNombreDia(fechaActual.getDayOfWeek()));

                            inasistencias.add(a);
                        }
                    }
                    // Avanzar al siguiente día
                    fechaActual = fechaActual.plusDays(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inasistencias;
    }

}
