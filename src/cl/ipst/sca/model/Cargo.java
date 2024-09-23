package cl.ipst.sca.model;

/**
 *
 * @author rober
 */
public class Cargo {
    private int idCar;
    private String cargo;

    public Cargo() {
    }

    public Cargo(int idCar, String cargo) {
        this.idCar = idCar;
        this.cargo = cargo;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
