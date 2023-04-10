package photousac;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Esta clase nos sirve para implementar la interface serializable
 *
 * @author Kevin Pozuelos
 */
public class BinManager {

    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    /**
     * Este metodo nos permite escribir en un archivo binario.
     *
     * @param object
     */
    public void writeObject(Object object) {
        try {
            oos = new ObjectOutputStream(new FileOutputStream("file.bin"));
            oos.writeObject(object);
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este metodo nos sirve para leer un archivo binario.
     *
     * @return null
     */
    public Object readObject() {
        Object object;

        try {
            ois = new ObjectInputStream(new FileInputStream("file.bin"));
            object = ois.readObject();

            return object;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
