package cl.ipst.sca.model;

/**
 * La clase Trabajador representa a un empleado en el sistema y utiliza el
 * patrón Singleton para garantizar que solo haya una instancia de la clase en
 * todo momento. Contiene información relevante como RUT, turno, cargo, y
 * detalles de contacto.
 *
 * <p>
 * La clase permite inicializar los atributos del trabajador, establecer su
 * turno y cargo, así como controlar su estado dentro del sistema.</p>
 *
 * <p>
 * El patrón Singleton se implementa para que solo exista una única instancia de
 * Trabajador durante la sesión, la cual puede ser limpiada cuando el trabajador
 * cierra sesión.</p>
 *
 * @author rober
 * @version 1.0
 */
public class Trabajador {

    /**
     * Instancia única de la clase Trabajador (patrón Singleton)
     */
    private static Trabajador instancia;

    /**
     * RUT del trabajador (sin dígito verificador)
     */
    private int rutTra;

    /**
     * Dígito verificador del RUT del trabajador
     */
    private char dvTra;

    /**
     * Turno asociado al trabajador
     */
    private Turno turnoTra;

    /**
     * Cargo del trabajador
     */
    private Cargo cargoTra;

    /**
     * Nombres del trabajador
     */
    private String nombresTra;

    /**
     * Apellidos del trabajador
     */
    private String apellidosTra;

    /**
     * Correo electrónico del trabajador
     */
    private String correoTra;

    /**
     * Clave o contraseña del trabajador
     */
    private String claveTra;

    /**
     * Departamento al que pertenece el trabajador
     */
    private String departamentoTra;

    /**
     * Área de trabajo del trabajador
     */
    private String areaTra;

    /**
     * Estado del trabajador (activo/inactivo)
     */
    private Boolean estadoTra;

    /**
     * Constructor publico.
     * Implementación del patrón Singleton "a medias".
     */
    public Trabajador() {
    }

    /**
     * Retorna la instancia única de la clase Trabajador. Si la instancia no
     * existe, se crea una nueva.
     *
     * @return la instancia única de Trabajador
     */
    public static Trabajador getInstancia() {
        if (instancia == null) {
            instancia = new Trabajador();
        }
        return instancia;
    }

    /**
     * Inicializa los atributos del trabajador. Este método es usado para
     * establecer los detalles de un trabajador después de su creación.
     *
     * @param rutTra RUT del trabajador (sin dígito verificador)
     * @param dvTra dígito verificador del RUT del trabajador
     * @param turnoTra el turno asignado al trabajador
     * @param cargoTra el cargo del trabajador
     * @param nombresTra nombres del trabajador
     * @param apellidosTra apellidos del trabajador
     * @param correoTra correo electrónico del trabajador
     * @param claveTra contraseña del trabajador
     * @param departamentoTra departamento al que pertenece el trabajador
     * @param areaTra área de trabajo del trabajador
     * @param estadoTra estado del trabajador (activo/inactivo)
     */
    public void inicializar(int rutTra, char dvTra, Turno turnoTra, Cargo cargoTra, String nombresTra,
            String apellidosTra, String correoTra, String claveTra,
            String departamentoTra, String areaTra, Boolean estadoTra) {
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

    /**
     * Cierra la sesión del trabajador limpiando la instancia única. Este método
     * es útil para finalizar la sesión de un trabajador y permitir una nueva
     * instancia de Trabajador si es necesario.
     */
    public void cerrarSesion() {
        instancia = null; // Limpiar la instancia al cerrar sesión
    }

    // Getters y Setters
    /**
     * Obtiene el RUT del trabajador (sin dígito verificador).
     *
     * @return el RUT del trabajador
     */
    public int getRutTra() {
        return rutTra;
    }

    /**
     * Establece el RUT del trabajador (sin dígito verificador).
     *
     * @param rutTra el nuevo RUT del trabajador
     */
    public void setRutTra(int rutTra) {
        this.rutTra = rutTra;
    }

    /**
     * Obtiene el dígito verificador del RUT del trabajador.
     *
     * @return el dígito verificador del RUT
     */
    public char getDvTra() {
        return dvTra;
    }

    /**
     * Establece el dígito verificador del RUT del trabajador.
     *
     * @param dvTra el nuevo dígito verificador
     */
    public void setDvTra(char dvTra) {
        this.dvTra = dvTra;
    }

    /**
     * Obtiene el turno asociado al trabajador.
     *
     * @return el turno del trabajador
     */
    public Turno getTurnoTra() {
        return turnoTra;
    }

    /**
     * Establece el turno asociado al trabajador.
     *
     * @param turnoTra el nuevo turno del trabajador
     */
    public void setTurnoTra(Turno turnoTra) {
        this.turnoTra = turnoTra;
    }

    /**
     * Obtiene el cargo del trabajador.
     *
     * @return el cargo del trabajador
     */
    public Cargo getCargoTra() {
        return cargoTra;
    }

    /**
     * Establece el cargo del trabajador.
     *
     * @param cargoTra el nuevo cargo del trabajador
     */
    public void setCargoTra(Cargo cargoTra) {
        this.cargoTra = cargoTra;
    }

    /**
     * Obtiene los nombres del trabajador.
     *
     * @return los nombres del trabajador
     */
    public String getNombresTra() {
        return nombresTra;
    }

    /**
     * Establece los nombres del trabajador.
     *
     * @param nombresTra los nuevos nombres del trabajador
     */
    public void setNombresTra(String nombresTra) {
        this.nombresTra = nombresTra;
    }

    /**
     * Obtiene los apellidos del trabajador.
     *
     * @return los apellidos del trabajador
     */
    public String getApellidosTra() {
        return apellidosTra;
    }

    /**
     * Establece los apellidos del trabajador.
     *
     * @param apellidosTra los nuevos apellidos del trabajador
     */
    public void setApellidosTra(String apellidosTra) {
        this.apellidosTra = apellidosTra;
    }

    /**
     * Obtiene el correo electrónico del trabajador.
     *
     * @return el correo del trabajador
     */
    public String getCorreoTra() {
        return correoTra;
    }

    /**
     * Establece el correo electrónico del trabajador.
     *
     * @param correoTra el nuevo correo del trabajador
     */
    public void setCorreoTra(String correoTra) {
        this.correoTra = correoTra;
    }

    /**
     * Obtiene la clave o contraseña del trabajador.
     *
     * @return la clave del trabajador
     */
    public String getClaveTra() {
        return claveTra;
    }

    /**
     * Establece la clave o contraseña del trabajador.
     *
     * @param claveTra la nueva clave del trabajador
     */
    public void setClaveTra(String claveTra) {
        this.claveTra = claveTra;
    }

    /**
     * Obtiene el departamento del trabajador.
     *
     * @return el departamento del trabajador
     */
    public String getDepartamentoTra() {
        return departamentoTra;
    }

    /**
     * Establece el departamento del trabajador.
     *
     * @param departamentoTra el nuevo departamento del trabajador
     */
    public void setDepartamentoTra(String departamentoTra) {
        this.departamentoTra = departamentoTra;
    }

    /**
     * Obtiene el área de trabajo del trabajador.
     *
     * @return el área de trabajo del trabajador
     */
    public String getAreaTra() {
        return areaTra;
    }

    /**
     * Establece el área de trabajo del trabajador.
     *
     * @param areaTra el nuevo área del trabajador
     */
    public void setAreaTra(String areaTra) {
        this.areaTra = areaTra;
    }

    /**
     * Obtiene el estado actual del trabajador (activo/inactivo).
     *
     * @return el estado del trabajador
     */
    public Boolean getEstadoTra() {
        return estadoTra;
    }

    /**
     * Establece el estado actual del trabajador (activo/inactivo).
     *
     * @param estadoTra el nuevo estado del trabajador
     */
    public void setEstadoTra(Boolean estadoTra) {
        this.estadoTra = estadoTra;
    }
}
