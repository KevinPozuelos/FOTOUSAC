package photousac;

/**
 * Nodo de la estructura de datos ListaSImple
 *
 * @author telma
 */

public class NodoS {

    private Object dato;
    private NodoS siguiente;
    public ListaDoble categoria;

    /**
     * Constructor de la clase NodoS
     *
     * @param dato
     */
    public NodoS(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        categoria = new ListaDoble();

        categoria.add("General");

    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoS siguiente) {
        this.siguiente = siguiente;
    }

    public ListaDoble getCategoria() {
        return categoria;
    }

    public void setCategoria(ListaDoble categoria) {
        this.categoria = categoria;
    }

    public void agregarCat(String nombre) {
        categoria.add(nombre);
    }

    public void buscCat(String nombre) {
        categoria.find(nombre);
    }
}
