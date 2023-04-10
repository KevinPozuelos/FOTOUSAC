package photousac;

import java.io.Serializable;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 * Esctucura de datos; Lista doblemente enlazada que hereda de la clase
 * EstructuraDeDatos
 *
 * @author Kevin Pozuelos
 */

public class ListaDoble extends EstructuraDeDatos implements Serializable {

    private NodoDoble cabecera, fin;

    /**
     * Constructor de la clase lista doble
     */

    public ListaDoble() {
        cabecera = fin = null;
    }

    /**
     * Metodo para comprobar si la estructura de datos esta vacia
     *
     * @return
     */
    public boolean esVacia() {
        return (this.cabecera == null);
    }

    /**
     * Metodo para agregar objetos a la lista doble enlazada
     *
     * @param e
     */
    @Override
    public void add(Object e) {
        if (!esVacia()) {
            fin = new NodoDoble(e, null, fin);
            fin.anterior.siguiente = fin;

        } else {
            cabecera = fin = new NodoDoble(e);

        }
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo para buscar un objeto en la lista doble enlazada
     *
     * @param e
     * @return aux
     */
    @Override
    public Object find(Object e) {
        NodoDoble aux = cabecera;

        while (aux.siguiente != null) {
            if (aux.datoC.equals((String) e)) {

                break;
            }

            aux = aux.getSiguiente();
        }
        return aux;
    }

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo para calcular el tamaño de la Lista doblemente enlazada
     *
     * @return
     */
    @Override
    public int getSize() {
        int contador = 0;
        NodoDoble aux = cabecera;
        if (!esVacia()) {

            while (aux != null) {
                aux = aux.siguiente;
                contador++;
            }
        }
        return contador;
    }

    @Override
    public Object get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo para borar un objeto de la lista doblemente enlazada
     *
     * @param e
     */
    @Override
    public void delete(Object e) {
        NodoDoble aux = cabecera;
        NodoDoble ant = null;
        while (aux.siguiente != null) {
            if (aux.datoC.equals((String) e)) {

                ant.siguiente = aux.siguiente;
                NodoDoble temporal;
                temporal = aux.siguiente;
                temporal.anterior = ant;
            }

            ant = aux;

            aux = aux.siguiente;
        }
    }

    public void print() {

        NodoDoble aux = cabecera;
        if (!esVacia()) {
            while (aux != null) {
                System.out.println("[" + aux.datoC + "]");
                aux.getImagenes().imprimir2();
                aux = aux.siguiente;

            }

        } else {
            System.out.println("-->La lista esta vacia");
        }

    }

    /**
     * Metodo para listar en un JList las categorias de cada usuario
     *
     * @param list
     */

    public void listar(JList list) {
        DefaultListModel modeloLista = new DefaultListModel();
        NodoDoble aux = cabecera;
        list.setModel(modeloLista);
        if (!esVacia()) {
            while (aux != null) {
                modeloLista.addElement(aux.datoC);
                aux = aux.siguiente;
            }

        }

    }

    /**
     * Metodo para agregar las categorias a un JCombobox
     *
     * @param combocat
     */
    public void listar2(JComboBox combocat) {

        NodoDoble aux = cabecera;

        if (!esVacia()) {
            while (aux != null) {
                combocat.addItem(aux.getDatoC());
                aux = aux.siguiente;
            }

        }

    }
}
