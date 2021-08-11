/**
 * Clase vacunas
 * @author Jeffer Martinez
 */


public class vacunas {
    //propiedades
    int dosis;
    String FechaVencimiento;
    NombreVacuna nombre;


//constructor
public vacunas(int dosis, String fechaVencimiento, NombreVacuna nombre) {
    this.dosis = dosis;
    FechaVencimiento = fechaVencimiento;
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
    return FechaVencimiento;
}


public void setFechaVencimiento(String fechaVencimiento) {
    FechaVencimiento = fechaVencimiento;
}


public NombreVacuna getNombre() {
    return nombre;
}


public void setNombre(NombreVacuna nombre) {
    this.nombre = nombre;
}


  
    
    
}
