package barcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.PDF417Writer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 条码。二维码，base64,BufferedImage
 */
public class BarcodeTest {
    public static void main(String[] args) throws Exception {
        BufferedImage bufferedImage = generateEAN13BarcodeImage("66889da0-d55c-4753-acbf-086827f5ae10");
        ImageIO.write(bufferedImage, "png",new File("E:\\workspace\\test.png")); // Change "png" to the format you desire
        System.out.println("Image saved successfully.");
    }

    public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws Exception {
        PDF417Writer barcodeWriter = new PDF417Writer();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.PDF_417, 300, 150);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
