/**
 * Clase Centros
 *@author Joseph A. Colindres 
 */
public class Centro {
    //propiedades
    private int codigo;
    private String ubicacion;
    private String nombre;
    private int capacidad;

    //constructor
    public Centro(int codigo, String ubicacion, String nombre, int capacidad) {
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    //getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
}