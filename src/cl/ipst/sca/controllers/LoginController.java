package cl.ipst.sca.controllers;

import cl.ipst.sca.config.ConexionBBDD;
import cl.ipst.sca.model.Cargo;
import cl.ipst.sca.model.Trabajador;
import cl.ipst.sca.model.Turno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;

/**
 * Controlador para manejar el proceso de inicio de sesión de los trabajadores.
 * Este controlador se encarga de verificar las credenciales del trabajador y
 * devolver la instancia del trabajador autenticado.
 *
 * @author rober
 * @version 1.0
 */
public class LoginController {

    private ConexionBBDD con;

    /**
     * Constructor de LoginController que inicializa la conexión a la base de
     * datos.
     */
    public LoginController() {
        con = new ConexionBBDD();
    }

    /**
     * Realiza el inicio de sesión de un trabajador utilizando su correo y
     * clave.
     *
     * @param correo El correo electrónico del trabajador.
     * @param clave La clave de acceso del trabajador.
     * @return La instancia de Trabajador si las credenciales son válidas, o
     * null si las credenciales son incorrectas o hay un error en la consulta.
     */
    public Trabajador loginTrabajador(String correo, String clave) {
        int rut;
        char dv;
        Turno tAux = new Turno();
        Cargo cAux = new Cargo();
        String nombres;
        String apellidos;
        String departamento;
        String area;
        String correoBD;
        String claveBD;
        Boolean estado;

        String query = "SELECT"
                + " t.RUT,"
                + " t.DV,"
                + " t.NOMBRES,"
                + " t.APELLIDOS,"
                + " t.DEPARTAMENTO,"
                + " t.AREA,"
                + " t.CORREO,"
                + " t.CLAVE,"
                + " t.ESTADO, "
                + " c.ID AS ID_CARGO,"
                + " c.CARGO,"
                + " tu.ID AS ID_TURNO,"
                + " tu.DESCRIPCION,"
                + " tu.INGRESO,"
                + " tu.SALIDA "
                + "FROM "
                + "trabajadores t "
                + "LEFT JOIN cargos c ON t.CAR_ID = c.ID "
                + "LEFT JOIN turnos tu ON t.ID = tu.ID "
                + "WHERE t.CORREO = '" + correo + "' AND t.CLAVE = '" + clave + "';";

        try {
            Statement insertar = con.crearSentencia();
            ResultSet rs = insertar.executeQuery(query);

            if (rs.next()) {
                rut = rs.getInt("RUT");
                dv = rs.getString("DV").charAt(0);
                nombres = rs.getString("NOMBRES");
                apellidos = rs.getString("APELLIDOS");
                departamento = rs.getString("DEPARTAMENTO");
                area = rs.getString("AREA");
                correoBD = rs.getString("CORREO");
                claveBD = rs.getString("CLAVE");
                estado = rs.getBoolean("ESTADO");

                // Cargo
                cAux.setIdCar(rs.getInt("ID_CARGO"));
                cAux.setCargo(rs.getString("CARGO"));

                // Turno
                tAux.setIdTurno(rs.getInt("ID_TURNO"));
                tAux.setDescripcionTurno(rs.getString("DESCRIPCION"));
                // Turno - Hora Ingreso y Salida
                Time horaIngreSQL = rs.getTime("INGRESO");
                LocalTime horaIngreLT = horaIngreSQL.toLocalTime();
                tAux.setHoraIngreso(horaIngreLT);

                Time horaSaliSQL = rs.getTime("SALIDA");
                LocalTime horaSaliLT = horaSaliSQL.toLocalTime();
                tAux.setHoraSalida(horaSaliLT); // Cambia a setHoraSalida si corresponde

                // Inicializar la instancia única de Trabajador
                Trabajador trabajador = Trabajador.getInstancia();
                trabajador.inicializar(rut, dv, tAux, cAux, nombres, apellidos, correoBD, claveBD, departamento, area, estado);

                return trabajador;
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el trabajador: " + e.getMessage());
            return null;
        }
        return null;
    }

}
