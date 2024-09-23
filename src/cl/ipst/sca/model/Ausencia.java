package cl.ipst.sca.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author rober
 */
public class Ausencia {

    private Trabajador tra;
    private LocalDate fecha;
    private String dia;

    public Ausencia() {
    }

    public Ausencia(Trabajador tra, LocalDate fecha, String dia) {
        this.tra = tra;
        this.fecha = fecha;
        this.dia = obtenerNombreDia(fecha.getDayOfWeek());
    }
    
    private String obtenerNombreDia(DayOfWeek dia) {
        return switch (dia) {
            case MONDAY -> "Lunes";
            case TUESDAY -> "Martes";
            case WEDNESDAY -> "Miércoles";
            case THURSDAY -> "Jueves";
            case FRIDAY -> "Viernes";
            case SATURDAY -> "Sábado";
            case SUNDAY -> "Domingo";
            default -> "";
        };
    }

    public Trabajador getTra() {
        return tra;
    }

    public void setTra(Trabajador tra) {
        this.tra = tra;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
}
