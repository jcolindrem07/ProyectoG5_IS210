/**
 * Estructura de datos cola
 * @author Joseph A. Colindres
 * @version 1.0
 */
public class Cola extends Pila {

    public Cola(String nombreLista) {
        super(nombreLista);
        setTipoLista("cola");
    }

    /**
     * Operación para eliminar el nodo del frente de la cola
     * @return El dato almacenado en el primer nodo de la cola
     * @throws ExcepcionLista 
     */
    @Override
    public Object eliminar() throws ExcepcionLista {
        if (estaVacia()) {
            throw new ExcepcionLista("cola", getNombreLista());
        }

        Object datoAlmacenado = getPrimerNodo().getDato();
        if (getPrimerNodo() == getUltimoNodo()) {
            setPrimerNodo(null);
            setUltimoNodo(null);
        } else {
            setPrimerNodo(getPrimerNodo().getSiguienteNodo());
        }
        return datoAlmacenado;
    }
}