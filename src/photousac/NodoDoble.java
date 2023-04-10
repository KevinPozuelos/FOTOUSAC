package photousac;

/**
 * Nodo de la Estructura de datos ListaDoble
 *
 * @author Kevin Pozuelos
 */
public class NodoDoble {

    Object datoC;
    public ListaDobleCircular Imagenes;
    NodoDoble siguiente, anterior;

    /**
     * Contrusctor de la clase NodoDoble
     *
     * @param datoc1
     */
    public NodoDoble(Object datoc1) {

        this(datoc1, null, null);

    }

    /**
     * Segundo Constructor de la clase NodoDOble
     *
     * @param datoC
     * @param s
     * @param a
     */
    public NodoDoble(Object datoC, NodoDoble s, NodoDoble a) {
        this.datoC = datoC;
        Imagenes = new ListaDobleCircular();
        siguiente = s;
        anterior = a;
    }

    public Object getDatoC() {
        return datoC;
    }

    public void setDatoC(Object datoC) {
        this.datoC = datoC;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public ListaDobleCircular getImagenes() {
        return Imagenes;
    }

    public void setImagenes(ListaDobleCircular Imagenes) {
        this.Imagenes = Imagenes;
    }

}
