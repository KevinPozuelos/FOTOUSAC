package photousac;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import static photousac.JPEGtoBMPImage.getName;

/**
 * Clase que nos ayuda para realizar una copia de una imagen JPEG
 *
 * @author Kevin Pozuelos
 */
public class JPEGImageCopy extends ImageHandler {

    /**
     * Consturctor de la clase JPEGImageCopy
     *
     * @param filename
     */
    public JPEGImageCopy(String filename) {
        super(filename);
    }

    /**
     * Metodo la leer la imagen a la que se le realizara la copia
     *
     * @throws Exception
     */
    @Override
    public void readFile() throws Exception {
        File input = new File(handledFileName);
        BufferedImage ImagenJpg = ImageIO.read(input);

        /**
         * Metodo para realizar la copia de la imagen.
         */
    }

    @Override
    public void generateFiles() throws Exception {
        String directory = handledFileName;
        String nombre = directory.substring(directory.lastIndexOf('/') + 1, directory.lastIndexOf('.'));
        String nombreF = getName(nombre);
        File input = new File(handledFileName);

        BufferedImage ImagenJpg = ImageIO.read(input);

        File output = new File("Resultados/" + "converted-" + nombreF + ".bmp");
        ImageIO.write(ImagenJpg, "bmp", output);
        ImageHandler copia = new BmpHandlerCopy("Resultados/" + "converted-" + nombreF + ".bmp");
        String cadena = copia.handledFileName;

        File output2 = new File("Resultados/" + "Copy-" + nombreF + ".jpg");
        ImageIO.write(ImagenJpg, "jpg", output2);

    }

    /**
     * Obtiene el nombre de la imagen sin extencion y ruta.
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
