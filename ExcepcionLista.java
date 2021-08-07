/**
 * Excepcion 'ExcepcionLista'
 * @author Harold Coello
 * @version 1.1
 * @implNote se añade la variable 'tipoLista' para desplegar el mensaje de acuerdo a cada tipo de estructura (lista, pila o cola)
 *  */
public class ExcepcionLista extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionLista() {
        this("lista", "genérica");
    }

    public ExcepcionLista(String tipoLista, String nombreLista) {
        super("La " + tipoLista + " '" + nombreLista + "' está vacía");
    }
}