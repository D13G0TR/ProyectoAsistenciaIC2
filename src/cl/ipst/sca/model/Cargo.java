package cl.ipst.sca.model;

/**
 * La clase Cargo representa un cargo o posición laboral dentro de una
 * organización. Cada instancia de Cargo contiene un identificador único y el
 * nombre del cargo.
 *
 * <p>
 * Esta clase es utilizada en el sistema para asociar a los trabajadores con sus
 * respectivos cargos.</p>
 *
 * @author rober
 * @version 1.0
 */
public class Cargo {

    /**
     * Identificador único del cargo
     */
    private int idCar;

    /**
     * Nombre del cargo
     */
    private String cargo;

    /**
     * Constructor por defecto de la clase Cargo. Inicializa una nueva instancia
     * vacía de Cargo.
     */
    public Cargo() {
    }

    /**
     * Constructor que inicializa un cargo con todos los atributos necesarios.
     *
     * @param idCar identificador único del cargo
     * @param cargo el nombre del cargo
     */
    public Cargo(int idCar, String cargo) {
        this.idCar = idCar;
        this.cargo = cargo;
    }

    /**
     * Obtiene el identificador único del cargo.
     *
     * @return el identificador del cargo
     */
    public int getIdCar() {
        return idCar;
    }

    /**
     * Establece el identificador único del cargo.
     *
     * @param idCar el nuevo identificador del cargo
     */
    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    /**
     * Obtiene el nombre del cargo.
     *
     * @return el nombre del cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el nombre del cargo.
     *
     * @param cargo el nuevo nombre del cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
