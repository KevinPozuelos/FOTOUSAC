package photousac;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;
import static photousac.JPEGtoBMPImage.getName;

/**
 * Clase para la aplicacion de filtros a la imagenes
 *
 * @author Kevin Pozuelos
 */
public class JPEGImageHandlerColors extends ImageHandler {

    private Color[][] px;

    int w;
    int h;

    /**
     * Constructor de la clase JPEGImageHandlerColors
     *
     * @param filename
     */
    public JPEGImageHandlerColors(String filename) {
        super(filename);
    }

    /**
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
     * Netido para generar la imagen con el filtro rojo
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
        BufferedImage Rojo = ImageIO.read(entrada);

        w = Rojo.getWidth();
        h = Rojo.getHeight();

        px = new Color[w][h];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                px[i][j] = new Color(Rojo.getRGB(i, j));
            }
        }

        for (int a = 0; a < px.length; a++) {
            for (int b = 0; b < px[0].length; b++) {
                Color MC = px[a][b];
                int Rojo1 = MC.getRed();
                Color Rojo2 = new Color(Rojo1, 0, 0, 0);
                Rojo.setRGB(a, b, Rojo2.getRGB());
            }

        }

        File FinalR = new File("Resultados/" + "Red-" + nombreF + ".jpg");
        ImageIO.write(Rojo, "jpg", FinalR);
        output.delete();
        ////////////////////////////////////////////////////////////////////////

    }

}
