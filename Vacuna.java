/**
 * Clase vacunas
 * @author Jeffer Martinez
 */
public class Vacuna {
    //propiedades
    private int dosis;
    private String fechaVencimiento;
    private NombreVacuna nombre;

    //constructor
    public Vacuna(int dosis, String fechaVencimiento, NombreVacuna nombre) {
        this.dosis = dosis;
        this.fechaVencimiento = fechaVencimiento;
        this.nombre = nombre;
    }

    //metodos y funciones
    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public NombreVacuna getNombre() {
        return nombre;
    }

    public void setNombre(NombreVacuna nombre) {
        this.nombre = nombre;
    }
}