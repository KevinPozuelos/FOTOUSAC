package photousac;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import static photousac.JPEGtoBMPImage.getName;

/**
 * Clase que nos permite generar una imagen rotada Verticalmente
 *
 * @author Kevin Pozuelos
 */
public class PEGImageHandlerRotator2 extends ImageHandler {

    protected byte[] filebytes;
    protected String Rotador;

    /**
     * Constructor de la clase PEGImageHandlerRotador2
     *
     * @param filename
     */
    public PEGImageHandlerRotator2(String filename) {
        super(filename);
        this.Rotador = "Vrotation-" + filename;
    }

    /**
     * Metodo para leer la imagen
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
     * Metodo para generar la imagen rotada verticalmente
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

        BufferedImage img2 = ImageIO.read(entrada);
        int w = img2.getWidth();
        int h = img2.getHeight();

        BufferedImage flippedImage2 = new BufferedImage(w, h, img2.getType());
        Graphics2D g2 = flippedImage2.createGraphics();
        g2.drawImage(img2, 0, 0, w, h, w, 0, 0, h, null);

        File FinalR2 = new File("Resultados/" + "Vrotation-" + nombreF + ".jpg");
        ImageIO.write(flippedImage2, "jpg", FinalR2);

        output.delete();

    }

}
