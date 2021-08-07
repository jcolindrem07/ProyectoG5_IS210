/**
 * Clase autorreferenciada Nodo
 * @author Harold Coello
 * @version 1.0
 *  */
public class Nodo {

    /**
     * Propiedad que almacena el dato
     */
    private Object dato;

    /**
     * Propiedad que almacena la referencia al siguiente Nodo
     */
    private Nodo siguienteNodo;

    /**
     * Constructor para solo crear un nodo sin referencia a siguiente nodo
     * @param dato El dato del nodo
     */
    public Nodo(Object dato) {
        this(dato, null);
    }

    /**
     * Constructor para crear un nodo con referencia a su siguiente nodo
     * @param dato El dato a cargar en el nodo
     * @param siguienteNodo El siguiente Nodo
     */
    public Nodo(Object dato, Nodo siguienteNodo) {
        this.dato = dato;
        this.siguienteNodo = siguienteNodo;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
}