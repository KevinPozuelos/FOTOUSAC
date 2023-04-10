package photousac;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import static photousac.JPEGtoBMPImage.getName;

/**
 * Clase que nos permite generar las imagenes con el filtro Sephia
 *
 * @author Kevin Pozuelos
 */
public class JPEGImageHandlerColors4 extends ImageHandler {

    private Color[][] px;

    int w;
    int h;

    /**
     * Constructor de la clase JPEGImageHandlerColors4
     *
     * @param filename
     */
    public JPEGImageHandlerColors4(String filename) {
        super(filename);
    }

    /**
     * *
     * Metodo para leer la imagen
     *
     * @throws Exception
     */
    @Override
    public void readFile() throws Exception {
        File input = new File(handledFileName);
        BufferedImage ImagenJpg = ImageIO.read(input);
    }

    /**
     * Metodo para generar la imagen con el filtro Sephia.
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

        File output = new File("Resultados/" + "temp-" + nombreF + ".bmp");
        ImageIO.write(ImagenJpg, "bmp", output);
        String RutaR = "Resultados/" + "temp-" + nombreF + ".bmp";

        FileInputStream entrada = new FileInputStream(RutaR);
        BufferedImage imgsel = ImageIO.read(entrada);

        Color colorImagen = null;
        int red = 0, green = 0, blue = 0;
        for (int i = 0; i < imgsel.getWidth(); i++) {
            for (int j = 1; j < (imgsel.getHeight() - 1); j++) {
                colorImagen = new Color(imgsel.getRGB(i, j));
                try {
                    red = (int) (colorImagen.getRed() * 0.393
                            + colorImagen.getGreen() * 0.769 + colorImagen.getBlue() * 0.189);
                    green = (int) (colorImagen.getRed() * 0.349
                            + colorImagen.getGreen() * 0.686 + colorImagen.getBlue() * 0.168);
                    blue = (int) (colorImagen.getRed() * 0.272
                            + colorImagen.getGreen() * 0.534 + colorImagen.getBlue() * 0.131);
                    colorImagen = new Color((red > 255) ? 255 : red,
                            (green > 255) ? 255 : green, (blue > 255) ? 255 : blue);
                } catch (Exception e) {
                }
                imgsel.setRGB(i, j, colorImagen.getRGB());
            }
        }

        File FinalR = new File("Resultados/" + "Sephia-" + nombreF + ".jpg");
        ImageIO.write(imgsel, "jpg", FinalR);
        output.delete();

    }
}
