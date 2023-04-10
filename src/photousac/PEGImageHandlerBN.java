package photousac;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import static photousac.JPEGtoBMPImage.getName;

/**
 * Clase para aplicar filtro Blanco Y Negro
 *
 * @author Kevin Pozuelos
 */
public class PEGImageHandlerBN extends ImageHandler {

    protected byte[] filebytes;
    protected String CBW;
    public int h;
    public int w;

    /**
     * Constructor de la clase PEGImageHandlerBN
     *
     * @param filename
     */
    public PEGImageHandlerBN(String filename) {
        super(filename);
        this.CBW = "BW-" + filename;
    }

    /**
     * Metodo para leer la imagen.
     *
     * @throws Exception
     */
    @Override
    public void readFile() throws Exception {
        try (FileInputStream input = new FileInputStream(this.handledFileName)) {
            filebytes = new byte[input.available()];
            input.read(filebytes);
        }
        System.out.println("Imagen leida: " + this.handledFileName);

    }

    /**
     * Metodo para generar la imagen con el filtro Blanco y Negro
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
        BufferedImage img = ImageIO.read(entrada);

        for (int x = 0; x < img.getWidth(); ++x) {
            for (int y = 0; y < img.getHeight(); ++y) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);

                // Normalize and gamma correct:
                float rr = (float) Math.pow(r / 255.0, 2.2);
                float gg = (float) Math.pow(g / 255.0, 2.2);
                float bb = (float) Math.pow(b / 255.0, 2.2);

                // Calculate luminance:
                float lum = (float) (0.2126 * rr + 0.7152 * gg + 0.0722 * bb);

                int grayLevel = (int) (255.0 * Math.pow(lum, 1.0 / 2.2));
                int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel;
                img.setRGB(x, y, gray);
            }
        }
        File FinalR = new File("Resultados/" + "BW-" + nombreF + ".jpg");
        ImageIO.write(img, "jpg", FinalR);

        output.delete();
    }

}
