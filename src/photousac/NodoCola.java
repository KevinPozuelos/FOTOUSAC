package photousac;

/**
 * Nodo para la estructura de datos Cola
 *
 * @author telma
 */

public class NodoCola {

    String Ruta;
    NodoCola siguiente;

    /**
     * Contructor de la Estructura de datos Cola
     *
     * @param R
     */
    public NodoCola(String R) {
        Ruta = R;
        siguiente = null;

    }
}
