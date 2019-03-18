package Classes;

import java.util.regex.Pattern;

/**
 *
 * @author M.H. Guitarte <guimhur@gmail.com>
 */
public class CVehiculo {
    // Declaración de atributos

    protected String matricula, tipo;
    protected int kms = 0;
    protected boolean alquilado = false;

    protected final String matOld = "[A-Z]{2}[0-9]{4}[A-Z]{2}";
    protected final String matNew = "[0-9]{4}[A-Z]{3}";

    //Constructores
    public CVehiculo() {
        this.tipo = this.getClass().getName();
    }

    public CVehiculo(String matricula) {
        try {
            if (Pattern.matches(matOld, matricula) || Pattern.matches(matNew, matricula)) {
                this.matricula = matricula;
                this.tipo = this.getClass().getName();

            } else {
                throw new Exception("El formato de matrícula no es correcto.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Getter & Setter
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //Métodos extra
    @Override
    public String toString() {

        return "Tipo de vehículo: " + tipo + " Matricula: " + matricula + " Kilómetros recorridos: " + kms + " Estado del alquiler: " + alquilado;
    }

    public void alquilar() {
        try {
            if (alquilado) {
                throw new Exception("El vehículo ya se encuentra alquilado.");
            } else {
                alquilado = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void devolver() {
        try {
            if (!alquilado) {
                throw new Exception("El vehículo no se encuentra alquilado.");
            } else {
                alquilado = false;
                kms = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double calcularImporte() {
        return 0;
    }

}
