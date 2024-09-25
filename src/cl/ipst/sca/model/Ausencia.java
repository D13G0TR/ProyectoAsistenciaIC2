package cl.ipst.sca.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * La clase Ausencia representa la ausencia de un trabajador en una fecha
 * específica. Cada instancia de Ausencia incluye información sobre el
 * trabajador, la fecha de la ausencia, y el nombre del día de la semana
 * correspondiente a esa fecha.
 *
 * <p>
 * Esta clase es útil para llevar un registro de las ausencias de los
 * trabajadores en un sistema de control de asistencia.</p>
 *
 * @author rober
 * @version 1.0
 */
public class Ausencia {

    /**
     * El trabajador que está ausente
     */
    private Trabajador tra;

    /**
     * Fecha de la ausencia
     */
    private LocalDate fecha;

    /**
     * Nombre del día de la semana correspondiente a la fecha de ausencia
     */
    private String dia;

    /**
     * Constructor por defecto de la clase Ausencia. Inicializa una nueva
     * instancia vacía de Ausencia.
     */
    public Ausencia() {
    }

    /**
     * Constructor que inicializa una ausencia con todos los atributos
     * necesarios.
     *
     * @param tra el trabajador que está ausente
     * @param fecha la fecha de la ausencia
     * @param dia el nombre del día de la semana (se obtiene automáticamente de
     * la fecha)
     */
    public Ausencia(Trabajador tra, LocalDate fecha, String dia) {
        this.tra = tra;
        this.fecha = fecha;
        this.dia = obtenerNombreDia(fecha.getDayOfWeek());
    }

    /**
     * Obtiene el nombre del día de la semana correspondiente a un objeto
     * DayOfWeek.
     *
     * @param dia el día de la semana
     * @return el nombre del día en español
     */
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

    /**
     * Obtiene el trabajador que está ausente.
     *
     * @return el trabajador ausente
     */
    public Trabajador getTra() {
        return tra;
    }

    /**
     * Establece el trabajador que está ausente.
     *
     * @param tra el nuevo trabajador ausente
     */
    public void setTra(Trabajador tra) {
        this.tra = tra;
    }

    /**
     * Obtiene la fecha de la ausencia.
     *
     * @return la fecha de la ausencia
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la ausencia.
     *
     * @param fecha la nueva fecha de la ausencia
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el nombre del día de la semana correspondiente a la fecha de
     * ausencia.
     *
     * @return el nombre del día de la semana
     */
    public String getDia() {
        return dia;
    }

    /**
     * Establece el nombre del día de la semana correspondiente a la fecha de
     * ausencia.
     *
     * @param dia el nuevo nombre del día de la semana
     */
    public void setDia(String dia) {
        this.dia = dia;
    }
}
