package cl.ipst.sca.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * La clase Marcacion representa un registro de la asistencia o salida de un
 * trabajador. Cada marcación incluye el trabajador que realizó la acción, la
 * fecha, la hora, y el tipo de marcación (entrada o salida).
 *
 * <p>
 * Esta clase es fundamental en un sistema de control de asistencia, donde se
 * registran las horas de entrada y salida de los empleados.</p>
 *
 * @author rober
 * @version 1.0
 */
public class Marcacion {

    /**
     * Identificador único de la marcación
     */
    private int idMarca;

    /**
     * Trabajador que realiza la marcación
     */
    private Trabajador trabMarca;

    /**
     * Fecha de la marcación
     */
    private LocalDate fecha;

    /**
     * Hora de la marcación
     */
    private LocalTime hora;

    /**
     * Tipo de marcación: 0 para entrada, 1 para salida (se pueden incluir otros tipos de marcaciones)
     */
    private int tipo;

    /**
     * Constructor por defecto de la clase Marcacion. Inicializa una nueva
     * instancia vacía de Marcacion.
     */
    public Marcacion() {
    }

    /**
     * Constructor que inicializa una marcación con todos los atributos
     * necesarios.
     *
     * @param idMarca identificador único de la marcación
     * @param trabMarca el trabajador que realiza la marcación
     * @param fecha la fecha en la que se realiza la marcación
     * @param hora la hora en la que se realiza la marcación
     * @param tipo tipo de marcación: 1 para entrada, 2 para salida
     */
    public Marcacion(int idMarca, Trabajador trabMarca, LocalDate fecha, LocalTime hora, int tipo) {
        this.idMarca = idMarca;
        this.trabMarca = trabMarca;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
    }

    /**
     * Obtiene el identificador único de la marcación.
     *
     * @return el identificador de la marcación
     */
    public int getIdMarca() {
        return idMarca;
    }

    /**
     * Establece el identificador único de la marcación.
     *
     * @param idMarca el nuevo identificador de la marcación
     */
    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    /**
     * Obtiene el trabajador que realizó la marcación.
     *
     * @return el trabajador que realizó la marcación
     */
    public Trabajador getTrabMarca() {
        return trabMarca;
    }

    /**
     * Establece el trabajador que realizó la marcación.
     *
     * @param trabMarca el nuevo trabajador que realiza la marcación
     */
    public void setTrabMarca(Trabajador trabMarca) {
        this.trabMarca = trabMarca;
    }

    /**
     * Obtiene la fecha en la que se realizó la marcación.
     *
     * @return la fecha de la marcación
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en la que se realizó la marcación.
     *
     * @param fecha la nueva fecha de la marcación
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora en la que se realizó la marcación.
     *
     * @return la hora de la marcación
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora en la que se realizó la marcación.
     *
     * @param hora la nueva hora de la marcación
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el tipo de marcación (1 para entrada, 2 para salida).
     *
     * @return el tipo de marcación
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de marcación (1 para entrada, 2 para salida).
     *
     * @param tipo el nuevo tipo de marcación
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
