package photousac;

/**
 * Nodo de la ListaCircularDoblementeEnlazada
 *
 * @author Kevin Pozuelos
 */

public class NodoDC {

    Object direction;
    NodoDC siguiente, anterior;

    /**
     * Constructor de la clase NodoDC
     *
     * @param diction
     */
    public NodoDC(Object diction) {
        this.direction = diction;
        this.siguiente = null;
        this.anterior = null;
    }

    public Object getDiction() {
        return direction;
    }

    public void setDiction(Object diction) {
        this.direction = diction;
    }

    public NodoDC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDC siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDC getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDC anterior) {
        this.anterior = anterior;
    }

}
