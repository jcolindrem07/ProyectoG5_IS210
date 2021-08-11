import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Simulacion del proceso de vacunacion
 */
public class Simulacion {

    public static void main(String[] args) {
        
    }

    /**
     * Metodo que lee el archivo de texto donde se encuentran los datos de los centros de vacunacion
     * y crea objetos tipo Centro con esos datos. Autor:
     */
    public static void crearCentros() {
        
    }

    /**
     * Crea 5 pilas de vacunas por cada centro, 1 por cada marca. Autor: Joseph A. Colindres
     */
    public static Pila[] crearVacunas() {
        Random rand = new Random();

        Pila pfizer = new Pila("PFIZER");
        Pila moderna = new Pila("MODERNA");
        Pila sputnik = new Pila("SPUTNIK V");
        Pila astrazeneca = new Pila("ASTRAZENECA");
        Pila johnson = new Pila("JOHNSON");
        Pila[] vacunas = { pfizer, moderna, sputnik, astrazeneca, johnson };

        //LLENA LAS PILAS DE VACUNAS
        for (int i = 0; i < vacunas.length; i++) {
            int cantidad = 500 + rand.nextInt(501);
            switch (i) {
                case 0:
                    for (int j = 0; j < cantidad; j++) {
                        Vacuna newVacuna = new Vacuna(2, "30/01/2022", NombreVacuna.PFIZER);
                        vacunas[i].insertar(newVacuna);
                    }
                    break;

                case 1:
                    for (int j = 0; j < cantidad; j++) {
                        Vacuna newVacuna = new Vacuna(2, "30/01/2022", NombreVacuna.MODERNA);
                        vacunas[i].insertar(newVacuna);
                    }
                    break;

                case 2:
                    for (int j = 0; j < cantidad; j++) {
                        Vacuna newVacuna = new Vacuna(2, "30/01/2022", NombreVacuna.SPUTNIK);
                        vacunas[i].insertar(newVacuna);
                    }
                    break;

                case 3:
                    for (int j = 0; j < cantidad; j++) {
                        Vacuna newVacuna = new Vacuna(2, "30/01/2022", NombreVacuna.ASTRAZENECA);
                        vacunas[i].insertar(newVacuna);
                    }
                    break;

                case 4:
                    for (int j = 0; j < cantidad; j++) {
                        Vacuna newVacuna = new Vacuna(1, "30/01/2022", NombreVacuna.JOHNSON);
                        vacunas[i].insertar(newVacuna);
                    }
                    break;

                default:
                    break;
            }
        }
        return vacunas;
    }

    /**
     * crea una cola con una cantidad de pacientres aleatoria entre 600 y la capacidad del centro de vacunacion. Autor:
     */
    public static Cola crearPacientes() {
        
    }
}
