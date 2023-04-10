package photousac;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import static photousac.JPEGtoBMPImage.getName;

/**
 * Esta clase contiene los metodos readFile y generateFiles convierto para
 * convertir una imagen BMP a JPEG
 *
 * @author kevin Raul Pozuelos
 */
public class BMPtoJPEGImage extends ImageHandler {

    /**
     * Constructor de la clase BMPtoJPEGImage
     *
     * @param filename
     */
    public BMPtoJPEGImage(String filename) {
        super(filename);
    }

    /**
     * Este metodo lee la imagen
     *
     * @author kevin Raul Pozuelos
     * @throws java.lang.Exception
     */
    @Override
    public void readFile() throws Exception {
        File input = new File(handledFileName);
        BufferedImage ImagenJpg = ImageIO.read(input);
    }

    /**
     * Este metodo convierto de imagen BMP a JPEG
     *
     * @author kevin Raul Pozuelos
     * @throws java.lang.Exception
     */
    @Override
    public void generateFiles() throws Exception {
        String directory = handledFileName;
        String nombre = directory.substring(directory.lastIndexOf('/') + 1, directory.lastIndexOf('.'));
        String nombreF = getName(nombre);
        File input = new File(handledFileName);

        BufferedImage ImagenJpg = ImageIO.read(input);

        File output = new File("Resultados/" + "converted-" + nombreF + ".jpg");
        ImageIO.write(ImagenJpg, "jpg", output);

    }

    /**
     * Este metodo para obtener el nombre de la imagen sin la extencion y ruta.
     *
     * @param filePath ruta requerida para generar los archivos
     *
     * @author kevin Raul Pozuelos
     * @return ""
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
