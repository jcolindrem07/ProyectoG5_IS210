/**
 * Clase Paciente
 * @author Joseph A. Colindres
 */
public class Paciente {
    //propiedades
    private int dosisARecibir;
    private String nombre;
    private int edad;
    private String residencia;
    private NombreVacuna vacunaAplicada;

    //constructor
    public Paciente(int dosisARecibir, String nombre, int edad, String residencia, NombreVacuna vacunaAplicada) {
        this.dosisARecibir = dosisARecibir;
        this.nombre = nombre;
        this.edad = edad;
        this.residencia = residencia;
        this.vacunaAplicada = vacunaAplicada;
    }

    //getters y setters
    public int getDosisARecibir() {
        return dosisARecibir;
    }

    public void setDosisARecibir(int dosisARecibir) {
        this.dosisARecibir = dosisARecibir;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public NombreVacuna getVacunaAplicada() {
        return vacunaAplicada;
    }

    public void setVacunaAplicada(NombreVacuna vacunaAplicada) {
        this.vacunaAplicada = vacunaAplicada;
    }
}