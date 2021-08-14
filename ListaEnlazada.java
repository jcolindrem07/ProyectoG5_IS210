/**
 * Estructura de datos Lista enlazada
 * @author Harold Coello
 * @version 1.1
 */
public class ListaEnlazada {
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

    public ListaEnlazada(String nombreLista) {
        this.nombreLista = nombreLista;
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    /**
     * Inserta un nodo al inicio de la lista
     * @param dato
     */
    public void insertarAlFrente(Object dato) {
        if (estaVacia()) {
            this.primerNodo = this.ultimoNodo = new Nodo(dato);
        } else {
            Nodo nvoNodo = new Nodo(dato, this.primerNodo);
            this.primerNodo = nvoNodo;
        }
    }

    /**
     * Inserta un nodo al final de la lista
     * @param dato
     */
    public void insertarAlFinal(Object dato) {
        if (estaVacia()) {
            this.primerNodo = this.ultimoNodo = new Nodo(dato);
        } else {
            Nodo nvoNodo = new Nodo(dato);
            this.ultimoNodo.setSiguienteNodo(nvoNodo);
            this.ultimoNodo = nvoNodo;
        }
    }

    /**
     * Operación para eliminar el nodo del frente de la lista
     * @return El dato almacenado en el primer nodo de la lista
     * @throws ExcepcionLista 
     */
    public Object eliminarAlFrente() throws ExcepcionLista {
        if (estaVacia()) {
            throw new ExcepcionLista("lista", this.nombreLista);
        }

        Object datoAlmacenado = this.primerNodo.getDato();
        if (this.primerNodo == this.ultimoNodo) {
            this.primerNodo = this.ultimoNodo = null;
        } else {
            this.primerNodo = this.primerNodo.getSiguienteNodo();
        }
        return datoAlmacenado;
    }

    /**
     * Operación para elimina un nodo del final
     * @return El dato almacenado en el nodo a eliminar
     * @throws ExcepcionLista
     */
    public Object eliminarAlFinal() throws ExcepcionLista {
        if (estaVacia()) {
            throw new ExcepcionLista("lista", this.nombreLista);
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
     * Imprime el contenido de la lista
     */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("La lista '" + this.nombreLista + "' está vacía");
        } else {
            System.out.println("El contenido de la lista es el siguiente");

            Nodo nodoTmp = this.primerNodo;
            while (nodoTmp.getSiguienteNodo() != null) {
                System.out.println(nodoTmp.getDato());
                nodoTmp = nodoTmp.getSiguienteNodo();
            }
            System.out.println(nodoTmp.getDato());
        }
    }

    /**
     * Valida si la lista está vacía
     * @return true o false
     */
    public boolean estaVacia() {
        return (null == this.primerNodo);
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
