package photousac;

/**
 * Estructura de datos llamada Pila
 *
 * @author Kevin Pozuelos
 */
public class Pila extends EstructuraDeDatos {

    private NodoPila top;
    int tama;

    /**
     * Constructor de la clase Pila
     */
    public Pila() {
        top = null;
        tama = 0;

    }

    /**
     * Metodo que verificar si la Pila esta vacia
     *
     * @return
     */
    public boolean esVacia() {
        return top == null;
    }

    /**
     * Metodo que nos permite agregar objetos a la pila
     *
     * @param e
     */
    @Override
    public void add(Object e) {
        NodoPila nuevo = new NodoPila((String) e);
        nuevo.siguiente = top;
        top = nuevo;
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

    @Override
    public Object getNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        return tama;
    }

    @Override
    public Object get(int i) {
        return top.ruta;

    }

    /**
     * Metodo que nos permite sacar un objeto de la pila
     *
     * @return
     */
    @Override
    public Object pop() {
        String aux = top.ruta;
        top = top.siguiente;
        tama--;
        return aux;

    }

    /**
     * Metodo que elimina un objeto de la pila
     *
     * @param e
     */
    @Override
    public void delete(Object e) {
        while (!esVacia()) {
            pop();
        }
    }

    /**
     * Metodo para convertir las imagenes de JPEG a BMP de la cola
     *
     * @throws Exception
     */
    public void printJPEGtoBMP() throws Exception {
        NodoPila aux = top;
        while (aux != null) {

            ImageHandler JPEGtoBMP = new JPEGtoBMPImage(aux.ruta);
            JPEGtoBMP.generateFiles();
            System.out.println("Imagen generada" + JPEGtoBMP.getFileName());

            aux = aux.siguiente;

        }
    }

    /**
     * Metodo para convertir las iamgenes de BMP a JPEG
     *
     * @throws Exception
     */
    public void printBMPtoJPEG() throws Exception {
        NodoPila aux = top;
        while (aux != null) {

            ImageHandler BMPtoJPEG = new BMPtoJPEGImage(aux.ruta);
            BMPtoJPEG.generateFiles();
            System.out.println("Imagen generada" + BMPtoJPEG.getFileName());
            aux = aux.siguiente;

        }
    }

    /**
     * Metodo para generar una copia de una imagen JPEG de la pila
     *
     * @throws Exception
     */

    public void printJPEGCOPY() throws Exception {
        NodoPila aux = top;
        while (aux != null) {

            ImageHandler BMPtoJPEG = new JPEGImageCopy(aux.ruta);
            BMPtoJPEG.generateFiles();
            System.out.println("Imagen generada" + BMPtoJPEG.getFileName());
            aux = aux.siguiente;

        }
    }

    /**
     * Metodo para generar las imagenes con los filtros; Rojo, Verde, Azul y
     * Sephia de pila
     *
     * @throws Exception
     */
    public void printCOLORS() throws Exception {
        NodoPila aux = top;
        while (aux != null) {

            ImageHandler ROJO = new JPEGImageHandlerColors(aux.ruta);
            ImageHandler VERDEG = new JPEGImageHandlerColors2(aux.ruta);
            ImageHandler AZUL = new JPEGImageHandlerColors3(aux.ruta);
            ImageHandler SEPHIA = new JPEGImageHandlerColors4(aux.ruta);
            System.out.println("Imagen Leida" + aux.ruta);
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
     * metodo para generar imagenes rotadas vertical como horizontalmente de la
     * pila
     *
     * @throws Exception
     */
    public void printROTED() throws Exception {
        NodoPila aux = top;
        while (aux != null) {

            ImageHandler HORI = new PEGImageHandlerRotator(aux.ruta);
            ImageHandler VERTI = new PEGImageHandlerRotator2(aux.ruta);
            HORI.generateFiles();
            System.out.println("Imagen generada" + HORI.getFileName());
            VERTI.generateFiles();
            System.out.println("Imagen generada" + VERTI.getFileName());
            aux = aux.siguiente;

        }
    }

    /**
     * Metodo para aplicar el filtro blanco y negro de las iamgens almacenadas
     * en la cola
     *
     * @throws Exception
     */
    public void printBW() throws Exception {
        NodoPila aux = top;
        while (aux != null) {

            ImageHandler BlackWhite = new PEGImageHandlerBN(aux.ruta);
            BlackWhite.generateFiles();
            System.out.println("Imagen generada" + BlackWhite.getFileName());
            aux = aux.siguiente;

        }
    }

    /**
     * metodo que nos permite borrar todos los objetos de la cola
     */
    public void deleteall() {
        while (!esVacia()) {
            pop();
        }
    }

    /**
     * metodo para mostrar en consola los objetos de la pila
     */
    public void Mostrar() {

        NodoPila aux = top;
        while (aux != null) {

            System.out.println(aux.ruta);

            aux = aux.siguiente;

        }

    }
}
