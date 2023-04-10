package photousac;

/**
 * Nodo de la Estructura de datos Pila
 *
 * @author Kevin Pozuelos
 */

public class NodoPila {

    String ruta;

    NodoPila siguiente;

    /**
     * Constructor de la clase NodoPila
     *
     * @param r
     */
    public NodoPila(String r) {
        ruta = r;
        siguiente = null;

    }

}
