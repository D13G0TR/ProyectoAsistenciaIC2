package cl.ipst.sca.model;

import java.time.LocalTime;

/**
 *
 * @author rober
 */
public class Turno {
    
    private int idTurno;
    private String descripcionTurno;
    private LocalTime horaIngreso;
    private LocalTime horaSalida;

    public Turno() {
    }

    public Turno(int idTurno, String descripcionTurno, LocalTime horaIngreso, LocalTime horaSalida) {
        this.idTurno = idTurno;
        this.descripcionTurno = descripcionTurno;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getDescripcionTurno() {
        return descripcionTurno;
    }

    public void setDescripcionTurno(String descripcionTurno) {
        this.descripcionTurno = descripcionTurno;
    }

    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }
    
}
