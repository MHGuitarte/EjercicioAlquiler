package Classes;

import Interfaces.Alquilable;

/**
 *
 * @author M.H. Guitarte <guimhur@gmail.com>
 */
public class CFurgoneta extends CVehiculo implements Alquilable {

    //Declaración de variables
    private final double precio = 0.5;
    private int carga;

    //Constructores
    public CFurgoneta() {
    }

    public CFurgoneta(String matricula, int carga) {
        super(matricula);
        this.carga = carga;
    }

    //Getter & Setter
    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    //Métodos extra
    @Override
    public String toString() {
        return super.toString() + " Carga: " + carga;
    }

    @Override
    public double calcularImporte() {
        return precio * kms;
    }

}
