
import Classes.CCoche;
import Classes.CFurgoneta;
import Classes.CMoto;
import Classes.CVehiculo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author M.H. Guitarte <guimhur@gmail.com>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ArrayList<CVehiculo> listaVehiculos = new ArrayList<CVehiculo>();

        listaVehiculos.add(new CCoche("AA1122CC", false));
        listaVehiculos.add(new CMoto("BB3344QQ", false));
        listaVehiculos.add(new CFurgoneta("1122CAC", 1200));

        String orden = "";

        while (!orden.equals("fin")) {
            orden = leerString();
            switch (orden) {
                case ("1"): {
                    altaVehiculo(listaVehiculos);
                    break;
                }

                case ("2"): {
                    mostrarVehiculos(listaVehiculos);
                    break;
                }

                case ("3"): {
                    System.out.println("Indique la matrícula del vehículo a alquilar");
                    String mat = leerString();
                    for (CVehiculo v : listaVehiculos) {
                        if (v.getMatricula().equals(mat)) {
                            System.out.println("¿Por cuantos kms quiere alquilar el vehiculo?");
                            v.setKms(leerInt());
                            System.out.println("El precio del alquiler son " + v.calcularImporte() + "€");
                            v.alquilar();
                        }
                    }
                    break;
                }

                case ("4"): {
                    System.out.println("Indique la matrícula del vehículo a devolver");
                    String mat = leerString();
                    for (CVehiculo v : listaVehiculos) {
                        if (v.getMatricula().equals(mat)) {
                            System.out.println("El importe a pagar asciende a " + v.calcularImporte() + "€");
                            v.devolver();
                        } else {
                            System.out.println("No existe un vehiculo con esta matrícula.");
                        }
                    }
                    break;
                }

                default: {
                    orden = "fin";
                    break;
                }
            }

        }

    }

    public static void altaVehiculo(ArrayList<CVehiculo> vehiculos) throws IOException {
        String tVehiculo;

        System.out.println("Indique el tipo de vehiculo (Coche, Moto, Furgoneta)");
        tVehiculo = "C" + leerString();

        switch (tVehiculo) {
            case ("CCoche"): {
                CCoche c = new CCoche();
                System.out.println("Indique la matrícula del vehículo");
                c.setMatricula(leerString());
                while (c.getMatricula() == null) {
                    System.out.println("Introduzca de nuevo la matrícula");
                    c.setMatricula(leerString());
                }
                System.out.println("Indique si el coche incluye extras");
                if (leerString().equals(true)) {
                    c.setExtras(true);
                } else {
                    c.setExtras(false);
                }
                c.setTipo("Coche");
                vehiculos.add(c);
                break;
            }
            case ("CMoto"): {
                CMoto m = new CMoto();
                System.out.println("Indique la matrícula del vehículo");
                m.setMatricula(leerString());
                System.out.println("Indique si la moto incluye casco");
                if (leerString().equals(true)) {
                    m.setCasco(true);
                } else {
                    m.setCasco(false);
                }
                m.setTipo("Moto");
                vehiculos.add(m);
                break;
            }

            case ("CFurgoneta"): {
                CFurgoneta f = new CFurgoneta();
                System.out.println("Indique la matrícula del vehículo");
                f.setMatricula(leerString());
                System.out.println("Indique la carga máxima de la furgoneta");
                f.setCarga(leerInt());
                f.setTipo("Furgoneta");
                vehiculos.add(f);
                break;
            }

            default: {
                System.out.println("No se reconoce el tipo de vehículo");
                break;
            }
        }
    }

    public static void mostrarVehiculos(ArrayList<CVehiculo> vehiculos) {
        for (CVehiculo v : vehiculos) {
            System.out.println(v.toString());
        }
    }

    public static String leerString() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        return reader.readLine();
    }

    public static int leerInt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        return Integer.parseInt(reader.readLine());
    }

    public static double leerDouble() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        return Double.parseDouble(reader.readLine());
    }

}
