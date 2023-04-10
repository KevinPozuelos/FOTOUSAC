package photousac;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * Clase para convertir imagens de JPEG a BMP
 *
 * @author telma
 */

public class JPEGtoBMPImage extends ImageHandler {

    /**
     * Contrusctor de la clase JPEGtoBMPImage
     *
     * @param filename
     */
    public JPEGtoBMPImage(String filename) {
        super(filename);

    }

    /**
     * Metodo para leer la imagen.
     *
     * @throws Exception
     */
    @Override
    public void readFile() throws Exception {

        File input = new File(handledFileName);
        BufferedImage ImagenJpg = ImageIO.read(input);
    }

    /**
     * Metodo para generar el archivo convertido
     *
     * @throws Exception
     */
    @Override
    public void generateFiles() throws Exception {
        String directory = handledFileName;
        String nombre = directory.substring(directory.lastIndexOf('/') + 1, directory.lastIndexOf('.'));
        String nombreF = getName(nombre);
        File input = new File(handledFileName);

        BufferedImage ImagenJpg = ImageIO.read(input);

        File output = new File("Resultados/" + "converted-" + nombreF + ".bmp");
        ImageIO.write(ImagenJpg, "bmp", output);

    }

    /**
     * Metodo para obtener el nombre de la imagen sin extencion y ruta
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

}
