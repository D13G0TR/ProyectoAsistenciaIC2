package cl.ipst.sca.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author rober
 */
public class Marcacion {
    private int idMarca;
    private Trabajador trabMarca;
    private LocalDate fecha;
    private LocalTime hora;
    private int tipo;

    public Marcacion() {
    }

    public Marcacion(int idMarca, Trabajador trabMarca, LocalDate fecha, LocalTime hora, int tipo) {
        this.idMarca = idMarca;
        this.trabMarca = trabMarca;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public Trabajador getTrabMarca() {
        return trabMarca;
    }

    public void setTrabMarca(Trabajador trabMarca) {
        this.trabMarca = trabMarca;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
