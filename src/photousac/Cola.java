package photousac;

/**
 * Esta clase hereda de la clase EstructuraDeDatos, para hacer una estructura de
 * datos llamada Cola.
 *
 * @author Kevin Pozuelos
 */
public class Cola extends EstructuraDeDatos {

    NodoCola inicio, fin;
    int tama;

    public Cola() {
        inicio = fin = null;
        tama = 0;

    }

    public boolean esVacia() {
        return inicio == null;

    }

    /**
     * Este metodo permite agregar objetos a la Cola
     *
     * @param e
     */
    @Override
    public void add(Object e) {
        NodoCola nuevo = new NodoCola((String) e);

        if (esVacia()) {
            inicio = nuevo;

        } else {
            fin.siguiente = nuevo;

        }
        fin = nuevo;
        tama++;
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
     * Este metodo nos permite buscar un objeto en la cola
     *
     * @return aux
     */
    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Este metodo permite caputar el tamaño de nuestra Cola
     *
     * @return aux
     */
    @Override
    public int getSize() {
        return tama;
    }

    /**
     * Este metodo nos devuelve la posicion del ultimo nodo realizado.
     *
     * @param i
     * @return aux
     */
    @Override
    public Object get(int i) {
        String aux = inicio.Ruta;
        inicio = inicio.siguiente;
        tama--;
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

    public void deleteall() {
        while (!esVacia()) {
            get1();
        }
    }

    /**
     * Este metodo nos sirve para sacar el top de la cola
     */
    public void get1() {

        inicio = inicio.siguiente;
        tama--;

    }

    /**
     * Metodo que sirve para mostrar los datos que estan dentro de la cola
     */
    public void Mostrar() {
        NodoCola aux = inicio;
        System.out.println("Listado de todos los elementos de la cola.");
        while (aux != null) {
            System.out.println(aux.Ruta);
            aux = aux.siguiente;
        }

    }

    /**
     * Metodo para convertir de JPEG a BMP
     *
     * @throws Exception
     */
    public void JPEGTOBMP() throws Exception {
        NodoCola aux = inicio;

        while (aux != null) {

            ImageHandler JPEGtoBMP = new JPEGtoBMPImage(aux.Ruta);
            JPEGtoBMP.generateFiles();
            System.out.println("Imagen generada" + JPEGtoBMP.getFileName());
            aux = aux.siguiente;

        }
    }

    /**
     * Metodo para convertir de BMP a JPEG
     *
     * @throws Exception
     */
    public void BMPTOJPEG() throws Exception {
        NodoCola aux = inicio;

        while (aux != null) {

            ImageHandler BMPtoJPEG = new BMPtoJPEGImage(aux.Ruta);
            BMPtoJPEG.generateFiles();
            System.out.println("Imagen generada" + BMPtoJPEG.getFileName());
            aux = aux.siguiente;
        }
    }

    /**
     * Metodo que nos permite realizar una copia de una imagen JPEG
     *
     * @throws Exception
     */
    public void JPEGCOPY() throws Exception {
        NodoCola aux = inicio;

        while (aux != null) {

            ImageHandler BMPtoJPEG = new JPEGImageCopy(aux.Ruta);
            BMPtoJPEG.generateFiles();
            System.out.println("Imagen generada" + BMPtoJPEG.getFileName());
            aux = aux.siguiente;
        }
    }

    /**
     * Metodo que nos permite aplicar los filtros: Rojo, Verde, Azul y sephia a
     * las imagenes guardadas en la cola
     *
     * @throws Exception
     */
    public void JPEGCOLORS() throws Exception {
        NodoCola aux = inicio;

        while (aux != null) {

            ImageHandler ROJO = new JPEGImageHandlerColors(aux.Ruta);
            ImageHandler VERDEG = new JPEGImageHandlerColors2(aux.Ruta);
            ImageHandler AZUL = new JPEGImageHandlerColors3(aux.Ruta);
            ImageHandler SEPHIA = new JPEGImageHandlerColors4(aux.Ruta);
            System.out.println("Imagen Leida" + aux.Ruta);
            ROJO.generateFiles();
            System.out.println("Imagen generada" + ROJO.getFileName());

            VERDEG.generateFiles();
            System.out.println("Imagen generada" + VERDEG.getFileName());
            AZUL.generateFiles();
            System.out.println("Imagen generada" + AZUL.getFileName());
            SEPHIA.generateFiles();
            System.out.println("Imagen generada" + SEPHIA.getFileName());
            aux = aux.siguiente;
        }
    }

    /**
     * Metodo para Rotar las imagenes guardadas en la rola
     *
     * @throws Exception
     */
    public void JPEGROTED() throws Exception {
        NodoCola aux = inicio;

        while (aux != null) {

            ImageHandler HORI = new PEGImageHandlerRotator(aux.Ruta);
            ImageHandler VERTI = new PEGImageHandlerRotator2(aux.Ruta);
            HORI.generateFiles();
            System.out.println("Imagen generada" + HORI.getFileName());
            VERTI.generateFiles();
            System.out.println("Imagen generada" + VERTI.getFileName());
            aux = aux.siguiente;
        }
    }

    /**
     * Metodo para aplicar filtro blanco y negro a las imanes guardas en la
     * cola.
     *
     * @throws Exception
     */
    public void JPEBW() throws Exception {
        NodoCola aux = inicio;

        while (aux != null) {

            ImageHandler BlackWhite = new PEGImageHandlerBN(aux.Ruta);
            BlackWhite.generateFiles();
            System.out.println("Imagen generada" + BlackWhite.getFileName());
            aux = aux.siguiente;
        }
    }

}
