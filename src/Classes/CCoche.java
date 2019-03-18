package Classes;

import Interfaces.Alquilable;

/**
 *
 * @author M.H. Guitarte <guimhur@gmail.com>
 */
public class CCoche extends CVehiculo implements Alquilable {

    //Declaración de atributos
    private final double precio = 0.4;
    private boolean extras;

    //Constructores
    public CCoche() {
    }

    public CCoche(String matricula, boolean extras) {
        super(matricula);
        this.extras = extras;
    }
    
    

    //Getter & Setter
    public boolean isExtras() {
        return extras;
    }

    public void setExtras(boolean extras) {
        this.extras = extras;
    }

    //Métodos extra
    @Override
    public String toString() {
        return super.toString() + " Extras: " + extras;
    }

    @Override
    public double calcularImporte() {

        if (extras) {
            return (kms * precio) + 20;
        } else {
            return kms * precio;
        }

    }

}