import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Simulacion del proceso de vacunacion
 */
public class Simulacion {
    /**
     * Lista de los centros de vacunacion creados
     */
    private static ListaEnlazada centros = new ListaEnlazada("Centros");

    /**
     * autor: Joseph A. Colindres
     */
    public static void main(String[] args) {
        Random rand = new Random();
        crearCentros();

        //arreglo tipo pila que contendra las 5 pilas de vacunas para el centro actual
        Pila[] vacunas;
        Cola pacientes;

        Nodo centroTmp = centros.getPrimerNodo();
        //procesamiento del centro
        do {
            //creacion de pacientes y vacunas
            vacunas = crearVacunas();

            Centro tmpcentro = (Centro) centroTmp.getDato();
            pacientes = crearPacientes(tmpcentro.getCapacidad());

            //variables para manejar los datos de los vacunados e imprimir el reporte
            //[0]Total pacientes no atendidos [1]Aplicadas 1 dosis	[2]Aplicadas 2 dosis 
            int[] pfizer = { 0, 0, 0 };
            int[] moderna = { 0, 0, 0 };
            int[] sputnik = { 0, 0, 0 };
            int[] astrazeneca = { 0, 0, 0 };
            int[] johnson = { 0, 0, 0 };

            //procesamiento de los pacientes
            Paciente pacientetmp;
            int vacunaARecibir;
            boolean vacunado;
            int posicionArreglo;
            do {
                pacientetmp = (Paciente) pacientes.getPrimerNodo().getDato();
                vacunado = false;

                if (pacientetmp.getDosisARecibir() == 1) {
                    //si viene por la primera dosis se le aplica cualquier vacuna disponible
                    do {
                        vacunaARecibir = rand.nextInt(5);

                        //verifica si hay vacunas, si no hay el paciente no es atendido
                        if (!hayVacunas(vacunas)) {
                            break;
                        } else if (!vacunas[vacunaARecibir].estaVacia()) {
                            vacunas[vacunaARecibir].eliminar();
                            vacunado = true;
                        }
                    } while (!vacunado);

                } else {
                    //si viene por la segunda dosis solo se le puede aplicar la misma vacuna. Si no hay, no es atendido
                    try {
                        vacunaARecibir = pacientetmp.getVacunaAplicada().ordinal();
                    } catch (NullPointerException e) {
                        vacunaARecibir = 0;
                    }
                    if (vacunas[vacunaARecibir].estaVacia()) {
                        //si no hay vacuna de esa marca el paciente no es atendido
                        vacunado = false;
                    } else {
                        //si hay vacuna se atiende al paciente y se resta una vacuna
                        vacunas[vacunaARecibir].eliminar();
                        vacunado = true;
                    }
                }

                if (vacunado) {
                    //si el paciente fue vacunado se suma 1 a la estadistica de la respectiva marca y dosis
                    posicionArreglo = pacientetmp.getDosisARecibir();
                } else {
                    //si el paciente NO fue vacunado se suma 1 a la estadistica de la respectiva marca en no atendidos
                    posicionArreglo = 0;
                }

                //se suman los datos de primera dosis, segunda y no atendidos de acuerdo a la marca aplicada
                switch (vacunaARecibir) {
                    case 0:
                        pfizer[posicionArreglo]++;
                        break;

                    case 1:
                        moderna[posicionArreglo]++;
                        break;

                    case 2:
                        sputnik[posicionArreglo]++;
                        break;

                    case 3:
                        astrazeneca[posicionArreglo]++;
                        break;

                    case 4:
                        johnson[posicionArreglo]++;

                    default:
                        break;
                }
                //se saca al paciente de la cola
                pacientes.eliminar();
            } while (!pacientes.estaVacia());

            //cuando se atendio a todos los pacientes del centro se imprime el reporte de dicho centro

            imprimirReporte(tmpcentro.getNombre(), pfizer, moderna, sputnik, astrazeneca, johnson);

            centroTmp = centroTmp.getSiguienteNodo();
        } while (centroTmp.getSiguienteNodo() != null);
    }

    /**
     * Metodo que lee el archivo de texto donde se encuentran los datos de los centros de vacunacion
     * y crea objetos tipo Centro con esos datos y genera la lista con esos objetos. Autor: Jeffer Martinez
     */
    public static void crearCentros() {

        FileReader leer;
        BufferedReader br;
        String linea;

        try {
            leer = new FileReader("C:\\centros.txt");
            br = new BufferedReader(leer);

            linea = br.readLine();

            while (null != linea) {
                /**
                 * proceso de creacion de objetos de tipo Centro y generar la lista
                 */
                String totalcentros[] = linea.split(",");

                Centro nvocentro = new Centro(Integer.parseInt(totalcentros[0]), totalcentros[1], totalcentros[2],
                        Integer.parseInt(totalcentros[3]));

                centros.insertarAlFinal(nvocentro);

                linea = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
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
     * crea una cola de pacientes entre 600 y la capacidad del centro de vacunacion. Autor: Joseph A. Colindres
     * @param capacidad
     * @return
     */
    public static Cola crearPacientes(int capacidad) {
        String[] nombres = { "MARIA", "LAURA", "ALFREDO", "JUAN", "LARISSA", "ROBERTO", "LUCIA", "TYLER", "JOSH" };
        String[] apellidos = { "LOPEZ", "COLINDRES", "ALMENDAREZ", "FLORES", "PINEDA", "PAZ", "AYALA" };
        String[] direcciones = { "RES. LOS GIRASOLES", "COL. KENNEDY", "EL REPARTO", "COL SAN MIGUEL",
                "COL 21 DE OCTUBRE" };
        NombreVacuna[] vacunas = { NombreVacuna.ASTRAZENECA, NombreVacuna.MODERNA, NombreVacuna.PFIZER,
                NombreVacuna.SPUTNIK };

        Random rand = new Random();
        int cantidad = 600 + rand.nextInt(capacidad + 1);

        Cola pacientes = new Cola("pacientes");
        Paciente nvoPaciente;
        for (int i = 0; i < cantidad; i++) {
            int dosis = 1 + rand.nextInt(2);
            switch (dosis) {
                case 1:
                    //si viene por la primera dosis el valor de la vacuna a aplicar sera null
                    nvoPaciente = new Paciente(1 + rand.nextInt(2),
                            nombres[rand.nextInt(nombres.length)] + " " + apellidos[rand.nextInt(apellidos.length)],
                            18 + rand.nextInt(63), direcciones[rand.nextInt(direcciones.length)], null);
                    pacientes.insertar(nvoPaciente);
                    break;

                case 2:
                    //si viene por la segunda dosis el valor de la vacuna a aplicar sera elegido aleatoriamente
                    nvoPaciente = new Paciente(1 + rand.nextInt(2),
                            nombres[rand.nextInt(nombres.length)] + " " + apellidos[rand.nextInt(apellidos.length)],
                            18 + rand.nextInt(63), direcciones[rand.nextInt(direcciones.length)],
                            vacunas[rand.nextInt(vacunas.length)]);
                    pacientes.insertar(nvoPaciente);
                    break;

                default:
                    break;
            }
        }
        return pacientes;
    }

    /**
     * imprime el reporte de vacunacion. Autor: jorge Omar Trochez Moncada
     */
    public static void imprimirReporte(String centro, int[] pfizer, int[] moderna, int[] sputnik, int[] astrazeneca,
            int[] johnson) {

        System.out.println(
                "  Centro de vacunación\tVacuna\t\tAplicadas 1 dosis\tAplicadas 2 dosis\tTotal pacientes atendidos\tTotal pacientes no atendidos");
        System.out.print("  " + centro + "\t\t");
        System.out.print("Pfizer    \t");
        System.out.print(pfizer[1]);
        System.out.print("\t\t\t");
        System.out.print(pfizer[2]);
        System.out.print("\t\t\t");
        System.out.print(pfizer[1] + pfizer[2]);
        System.out.print("\t\t\t\t");
        System.out.println(pfizer[0]);

        System.out.print("  " + centro + "\t\t");
        System.out.print("Moderna   \t");
        System.out.print(moderna[1]);
        System.out.print("\t\t\t");
        System.out.print(moderna[2]);
        System.out.print("\t\t\t");
        System.out.print(moderna[1] + moderna[2]);
        System.out.print("\t\t\t\t");
        System.out.println(moderna[0]);

        System.out.print("  " + centro + "\t\t");
        System.out.print("Sputnik-V\t");
        System.out.print(sputnik[1]);
        System.out.print("\t\t\t");
        System.out.print(sputnik[2]);
        System.out.print("\t\t\t");
        System.out.print(sputnik[1] + sputnik[2]);
        System.out.print("\t\t\t\t");
        System.out.println(sputnik[0]);

        System.out.print("  " + centro + "\t\t");
        System.out.print("Astrazeneca\t");
        System.out.print(astrazeneca[1]);
        System.out.print("\t\t\t");
        System.out.print(astrazeneca[2]);
        System.out.print("\t\t\t");
        System.out.print(astrazeneca[1] + astrazeneca[2]);
        System.out.print("\t\t\t\t");
        System.out.println(astrazeneca[0]);

        System.out.print("  " + centro + "\t\t");
        System.out.print("Johnson    \t");
        System.out.print(johnson[1]);
        System.out.print("\t\t\t");
        System.out.print(johnson[2]);
        System.out.print("\t\t\t");
        System.out.print(johnson[1] + johnson[2]);
        System.out.print("\t\t\t\t");
        System.out.println(johnson[0]);

    }

    public static boolean hayVacunas(Pila[] vacunas) {
        boolean hay = false;
        for (int i = 0; i < vacunas.length; i++) {
            if (!vacunas[i].estaVacia()) {
                hay = true;
                break;
            }
        }
        return hay;
    }
}
