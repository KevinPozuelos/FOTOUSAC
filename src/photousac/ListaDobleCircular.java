package photousac;

import java.io.Serializable;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Kevin Pozuelos Estructura de datos Lista Circular doblemente enlazada
 * que hereda de la clase EstructuraDeDatos
 */

public class ListaDobleCircular extends EstructuraDeDatos implements Serializable {

    int tamanio = 0;
    NodoDC inicio;
    NodoDC fin;
    public NodoDC actual1;

    /**
     * Constructor de la lista Circular doblemente enlazada
     */
    public ListaDobleCircular() {
        inicio = fin = null;

    }

    /**
     * Metodo para comprobar si la estructura de datos Lista Circular Doblemente
     * enlazada esta vavia
     *
     * @return tamanio
     */
    public boolean EsVacia() {
        return (tamanio == 0);

    }

    /**
     * Metodo para comprobar si la estructura de datos Lista Circular Doblemente
     * enlazada esta vavia
     *
     * @return false
     */
    public boolean esVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que permite agregar objetos a la lista Circular doblemente
     * enlazada
     *
     * @param e
     */
    @Override
    public void add(Object e) {
        NodoDC nuevo = new NodoDC(e);
        if (EsVacia()) {
            inicio = nuevo;
            fin = nuevo;
            actual1 = inicio;
            inicio.siguiente = fin;
            fin.siguiente = inicio;
            inicio.anterior = fin;
            fin.anterior = inicio;
            tamanio++;

        } else {
            actual1 = inicio;
            NodoDC aux = inicio;
            nuevo.siguiente = aux;
            aux.anterior = nuevo;
            inicio = nuevo;
            tamanio++;

        }
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object find(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo que retorna el objeto siguiente de la lista Circular doblmente
     * enlazada
     *
     * @return ruta
     */
    @Override
    public Object getNext() {

        String ruta;

        NodoDC aux;

        aux = actual1.siguiente;
        actual1.getDiction();
        ruta = (String) actual1.getDiction();
        actual1 = actual1.siguiente;
        return ruta;

    }

    /**
     * Metodo que retorna el tamaño de la estructura de datos Lista circular
     * doblemente enlazada
     *
     * @return
     */
    @Override
    public int getSize() {
        return tamanio;
    }

    /**
     * Metodo que retorna un nodo
     *
     * @param i
     * @return
     */
    @Override
    public Object get(int i) {
        NodoDC aux = inicio;
        int contador = 0;
        while (contador != getSize()) {
            aux = aux.getSiguiente();
            contador++;
        }
        return aux;
    }

    @Override
    public Object pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void imprimir() {

        NodoDC aux = inicio;
        if (EsVacia()) {

            for (int i = 0; i < tamanio; i++) {

//        System.out.println(aux.getDiction());
                PhotoUsac.Conversor.add(aux.getDiction());
                aux = aux.siguiente;
            }

        } else {
            System.out.println(aux.getDiction());
        }

        PhotoUsac.Conversor.add(aux.getDiction());
    }

    /**
     * Metodo para copiar los datos de la lista circular doblemente enlazada a
     * una Pila
     */
    public void imprimir2() {
        NodoDC actual;
        actual = inicio;
        if (!EsVacia()) {

            while (actual != fin) {
//   System.out.println(actual.direction);
                PhotoUsac.Conversor.add(actual.getDiction());
                actual = actual.siguiente;
            }
            PhotoUsac.Conversor.add(actual.getDiction());
//        System.out.println(actual.direction);
        } else {
            System.out.println("ESTA VACIA");
        }

    }

    /**
     * Metodo para copiar los datos de la lista circular doblemente enlazada a
     * una Cola
     */
    public void ColaFotos() {
        NodoDC actual;
        actual = inicio;
        if (!EsVacia()) {

            while (actual != fin) {
//   System.out.println(actual.direction);
                PhotoUsac.ConversorC.add(actual.getDiction());
                actual = actual.siguiente;
            }
            PhotoUsac.ConversorC.add(actual.getDiction());
//        System.out.println(actual.direction);
        } else {
            System.out.println("ESTA VACIA");
        }

    }

    /**
     * metodo para retornar el nodo actual en el que esta la lista circular
     * doblemente enlazada
     *
     * @return
     */
    public String actual() {
        NodoDC actual;
        String ruta;
        actual = inicio;
        actual.getDiction();
        ruta = (String) actual.getDiction();
        return ruta;
    }

    /**
     * metodo para retornar el anterior de la lista circular doblemente enlazada
     *
     * @return
     */
    public Object getBack() {
        NodoDC actual;
        String ruta;
        actual = fin;

        actual = actual1.anterior;
        actual.getDiction();
        ruta = (String) actual.getDiction();
        actual1 = actual1.anterior;
        return ruta;

    }

    /**
     * metodo para obtener el nombre de la imagen sin extencion y ruta
     *
     * @param filePath
     * @return
     */
    public static String getName(String filePath) {
        if (filePath == null || filePath.length() == 0) {
            return "";
        }
        filePath = filePath.replaceAll("[/\\\\]+", "/");
        int len = filePath.length(),
                upCount = 0;
        while (len > 0) {
            //remove trailing separator
            if (filePath.charAt(len - 1) == '/') {
                len--;
                if (len == 0) {
                    return "";
                }
            }
            int lastInd = filePath.lastIndexOf('/', len - 1);
            String fileName = filePath.substring(lastInd + 1, len);
            if (fileName.equals(".")) {
                len--;
            } else if (fileName.equals("..")) {
                len -= 2;
                upCount++;
            } else {
                if (upCount == 0) {
                    return fileName;
                }
                upCount--;
                len -= fileName.length();
            }

        }
        return "";
    }

    /**
     * Metodo para listar en un Jlist los nombres de las imagenes.
     *
     * @param list
     */
    public void listar(JList list) {
        DefaultListModel modeloLista = new DefaultListModel();
        NodoDC actual;
        list.setModel(modeloLista);
        actual = inicio;
        if (!EsVacia()) {

            while (actual != fin) {
                modeloLista.addElement(getName((String) actual.direction));

                actual = actual.siguiente;
            }
            modeloLista.addElement(getName((String) actual.direction));
        } else {
            System.out.println("ESTA VACIA");
        }

    }

}
