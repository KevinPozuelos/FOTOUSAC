package photousac;

import javax.swing.JComboBox;

/**
 * Estructura de datos Lista simplemente enlazada que hereda de la clase
 * EstructuraDeDatos
 *
 * @author Kevin Pozuelos
 */

public class ListaSimple extends EstructuraDeDatos implements java.io.Serializable {

    private NodoS nodo;

    /**
     * Constructor de la clase ListaSimple
     */
    public ListaSimple() {
        this.nodo = null;
    }

    /**
     * Metodo para comprobar si la ListaSimple es vacia
     *
     * @return false
     */
    public boolean esVacia() {
        if (nodo == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que permite agregar objetos a la ListaSimple
     *
     * @param e
     */
    @Override
    public void add(Object e) {
        NodoS nuevo = new NodoS(e);
        if (esVacia()) {
            nodo = nuevo;
        } else {
            NodoS aux = nodo;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo para buscar un objeto en la ListaSimple
     *
     * @param e
     * @return aux
     */
    @Override
    public Object find(Object e) {
        NodoS actual = nodo;
        boolean encontrado = false;
        if (nodo != null) {
            while (actual != null) {
                if (actual.getDato().equals((String) e)) {
                    encontrado = true;
                    break;
                }
                actual = actual.getSiguiente();
            }

        }

        return actual;
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo para mostrar contenido de la ListaSimple en consola
     */
    public void pantalla() {
        NodoS aux = nodo;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux.getCategoria().print();

            aux = aux.getSiguiente();
        }
    }

    /**
     * Metodo para encontrar un objeto en la ListaSimple
     *
     * @param e
     * @return
     */
    public boolean encontrar(Object e) {
        NodoS actual = nodo;
        boolean encontrado = false;
        if (nodo != null) {
            while (actual != null) {
                if (actual.getDato().equals((String) e)) {
                    encontrado = true;
                    break;
                }
                actual = actual.getSiguiente();
            }

        }

        return encontrado;
    }

    /**
     * Metodo para listar un JCombobox de los usuarios registrados en la
     * ListaSimple
     *
     * @param cbxUser
     */
    public void rellenarComboConductores(JComboBox cbxUser) {
        NodoS aux = nodo;
        while (aux != null) {
            cbxUser.addItem(aux.getDato());

            aux = aux.getSiguiente();
        }

    }
}
