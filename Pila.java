/**
 * Estructura de datos pila
 * @version 1.0
 */
public class Pila {
    /**
     * Tipo de lista a mostrar en el mensaje de excepcion
     */
    private String tipoLista = "pila";

    /**
     * El primer nodo
     */
    private Nodo primerNodo;

    /**
     * El ultimo nodo
     */
    private Nodo ultimoNodo;

    /**
     * El nombre de la lista
     */
    private String nombreLista;

    public Pila(String nombreLista) {
        this.nombreLista = nombreLista;
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    /**
     * Inserta un nodo al final de la pila
     * @param dato
     */
    public void insertar(Object dato) {
        if (estaVacia()) {
            this.primerNodo = this.ultimoNodo = new Nodo(dato);
        } else {
            Nodo nvoNodo = new Nodo(dato);
            this.ultimoNodo.setSiguienteNodo(nvoNodo);
            this.ultimoNodo = nvoNodo;
        }
    }

    /**
     * Operación para elimina un nodo del final
     * @return El dato almacenado en el nodo a eliminar
     * @throws ExcepcionLista
     */
    public Object eliminar() throws ExcepcionLista {
        if (estaVacia()) {
            throw new ExcepcionLista("pila", this.nombreLista);
        }

        Object datoAlmacenado = this.ultimoNodo.getDato();
        if (this.primerNodo == this.ultimoNodo) {
            this.primerNodo = this.ultimoNodo = null;
        } else {
            Nodo nodoTmp = this.primerNodo;
            while (nodoTmp.getSiguienteNodo() != this.ultimoNodo) {
                nodoTmp = nodoTmp.getSiguienteNodo();
            }
            nodoTmp.setSiguienteNodo(null);
            this.ultimoNodo = nodoTmp;
        }
        return datoAlmacenado;
    }

    /**
     * Imprime el contenido de la pila
     */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("La " + this.tipoLista + " '" + this.nombreLista + "' está vacía");
        } else {
            System.out.println("El contenido de la " + this.tipoLista + " es el siguiente");

            Nodo nodoTmp = this.primerNodo;
            while (nodoTmp.getSiguienteNodo() != null) {
                System.out.println(nodoTmp.getDato());
                nodoTmp = nodoTmp.getSiguienteNodo();
            }
            System.out.println(nodoTmp.getDato());
        }
    }

    /**
     * Valida si la pila está vacía
     * @return true o false
     */
    public boolean estaVacia() {
        return (null == this.primerNodo);
    }

    public void setTipoLista(String tipoLista) {
        this.tipoLista = tipoLista;
    }

    public Nodo getPrimerNodo() {
        return primerNodo;
    }

    public void setPrimerNodo(Nodo primerNodo) {
        this.primerNodo = primerNodo;
    }

    public Nodo getUltimoNodo() {
        return ultimoNodo;
    }

    public void setUltimoNodo(Nodo ultimoNodo) {
        this.ultimoNodo = ultimoNodo;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }
}