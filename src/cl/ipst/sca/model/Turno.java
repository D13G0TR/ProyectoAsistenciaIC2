package cl.ipst.sca.model;

import java.time.LocalTime;

/**
 * La clase Turno representa un turno laboral en un sistema de control de
 * asistencia. Contiene información sobre la identificación del turno, una
 * descripción, la hora de ingreso y la hora de salida.
 *
 * <p>
 * Esta clase puede ser utilizada para modelar los turnos laborales de empleados
 * en un sistema que maneje horarios y asistencias.</p>
 *
 * @author rober
 * @version 1.0
 */
public class Turno {

    /**
     * Identificador único del turno
     */
    private int idTurno;

    /**
     * Descripción del turno (por ejemplo: "Mañana", "Tarde", "Noche")
     */
    private String descripcionTurno;

    /**
     * Hora de ingreso del turno
     */
    private LocalTime horaIngreso;

    /**
     * Hora de salida del turno
     */
    private LocalTime horaSalida;

    /**
     * Constructor por defecto de la clase Turno. Crea una instancia de Turno
     * sin inicializar los atributos.
     */
    public Turno() {
    }

    /**
     * Constructor que inicializa los atributos del turno con valores
     * específicos.
     *
     * @param idTurno el identificador único del turno
     * @param descripcionTurno la descripción del turno
     * @param horaIngreso la hora de ingreso del turno
     * @param horaSalida la hora de salida del turno
     */
    public Turno(int idTurno, String descripcionTurno, LocalTime horaIngreso, LocalTime horaSalida) {
        this.idTurno = idTurno;
        this.descripcionTurno = descripcionTurno;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
    }

    /**
     * Obtiene el identificador único del turno.
     *
     * @return el id del turno
     */
    public int getIdTurno() {
        return idTurno;
    }

    /**
     * Establece el identificador único del turno.
     *
     * @param idTurno el id a asignar al turno
     */
    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    /**
     * Obtiene la descripción del turno.
     *
     * @return la descripción del turno
     */
    public String getDescripcionTurno() {
        return descripcionTurno;
    }

    /**
     * Establece la descripción del turno.
     *
     * @param descripcionTurno la nueva descripción del turno
     */
    public void setDescripcionTurno(String descripcionTurno) {
        this.descripcionTurno = descripcionTurno;
    }

    /**
     * Obtiene la hora de ingreso del turno.
     *
     * @return la hora de ingreso
     */
    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    /**
     * Establece la hora de ingreso del turno.
     *
     * @param horaIngreso la nueva hora de ingreso del turno
     */
    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    /**
     * Obtiene la hora de salida del turno.
     *
     * @return la hora de salida
     */
    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    /**
     * Establece la hora de salida del turno.
     *
     * @param horaSalida la nueva hora de salida del turno
     */
    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }
}