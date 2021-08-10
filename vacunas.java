/**
 * Clase vacunas
 * @author Jeffer Martinez
 */

public class vacunas {
    //propiedades
    int dosis;
    String FechaVencimiento;


//constructor
    public vacunas(int dosis, String fechaVencimiento) {
        this.dosis = dosis;
        FechaVencimiento = fechaVencimiento;
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

    
    
}
