package Classes;

import Interfaces.Alquilable;

/**
 *
 * @author M.H. Guitarte <guimhur@gmail.com>
 */
public class CMoto extends CVehiculo implements Alquilable {

    //Declaración de atributos
    private final double precio = 0.6;
    private boolean casco;

    //Constructores
    public CMoto() {
    }

    public CMoto(String matricula, boolean casco) {
        super(matricula);
        this.casco = casco;
    }

    //Getter & Setter
    public boolean isCasco() {
        return casco;
    }

    public void setCasco(boolean casco) {
        this.casco = casco;
    }

    //Métodos extra
    @Override
    public String toString() {
        return super.toString() + " Casco: " + casco;
    }

    @Override
    public double calcularImporte() {

        if (casco) {
            return (precio * kms) + 10;
        } else {
            return precio * kms;
        }

    }

}