package cl.ipst.sca.model;

/**
 *
 * @author rober
 */
public class Trabajador {

    private static Trabajador instancia;

    private int rutTra;
    private char dvTra;
    private Turno turnoTra;
    private Cargo cargoTra;
    private String nombresTra;
    private String apellidosTra;
    private String correoTra;
    private String claveTra;
    private String departamentoTra;
    private String areaTra;
    private Boolean estadoTra;

    public Trabajador() {
    }

    public static Trabajador getInstancia() {
        if (instancia == null) {
            instancia = new Trabajador();
        }
        return instancia;
    }

    public void inicializar(int rutTra, char dvTra, Turno turnoTra, Cargo cargoTra, String nombresTra, String apellidosTra, String correoTra, String claveTra, String departamentoTra, String areaTra, Boolean estadoTra) {
        this.rutTra = rutTra;
        this.dvTra = dvTra;
        this.turnoTra = turnoTra;
        this.cargoTra = cargoTra;
        this.nombresTra = nombresTra;
        this.apellidosTra = apellidosTra;
        this.correoTra = correoTra;
        this.claveTra = claveTra;
        this.departamentoTra = departamentoTra;
        this.areaTra = areaTra;
        this.estadoTra = estadoTra;
    }

    public void cerrarSesion() {
        instancia = null; // Limpiar la instancia al cerrar sesión
    }

    // Getters y Setters
    public int getRutTra() {
        return rutTra;
    }

    public void setRutTra(int rutTra) {
        this.rutTra = rutTra;
    }

    public char getDvTra() {
        return dvTra;
    }

    public void setDvTra(char dvTra) {
        this.dvTra = dvTra;
    }

    public Turno getTurnoTra() {
        return turnoTra;
    }

    public void setTurnoTra(Turno turnoTra) {
        this.turnoTra = turnoTra;
    }

    public Cargo getCargoTra() {
        return cargoTra;
    }

    public void setCargoTra(Cargo cargoTra) {
        this.cargoTra = cargoTra;
    }

    public String getNombresTra() {
        return nombresTra;
    }

    public void setNombresTra(String nombresTra) {
        this.nombresTra = nombresTra;
    }

    public String getApellidosTra() {
        return apellidosTra;
    }

    public void setApellidosTra(String apellidosTra) {
        this.apellidosTra = apellidosTra;
    }

    public String getCorreoTra() {
        return correoTra;
    }

    public void setCorreoTra(String correoTra) {
        this.correoTra = correoTra;
    }

    public String getClaveTra() {
        return claveTra;
    }

    public void setClaveTra(String claveTra) {
        this.claveTra = claveTra;
    }

    public String getDepartamentoTra() {
        return departamentoTra;
    }

    public void setDepartamentoTra(String departamentoTra) {
        this.departamentoTra = departamentoTra;
    }

    public String getAreaTra() {
        return areaTra;
    }

    public void setAreaTra(String areaTra) {
        this.areaTra = areaTra;
    }

    public Boolean getEstadoTra() {
        return estadoTra;
    }

    public void setEstadoTra(Boolean estadoTra) {
        this.estadoTra = estadoTra;
    }
}
