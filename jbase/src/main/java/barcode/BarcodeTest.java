package barcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * 条码。二维码，base64,BufferedImage
 */
@Slf4j
public class BarcodeTest {
    public static void main(String[] args) throws Exception {
//        BufferedImage bufferedImage = generatePDF417codeImage("66889da0-d55c-4753-acbf-086827f5ae10");
//        ImageIO.write(bufferedImage, "png", new File("E:\\workspace\\test.png")); // Change "png" to the format you desire
//        System.out.println("Image saved successfully.");
        System.out.println(getQrCode("66889da0-d55c-4753-acbf-086827f5ae10"));
    }

    /**
     * https://zhuanlan.zhihu.com/p/159462673
     */
    public static BufferedImage generatePDF417codeImage(String barcodeText) throws Exception {
        // 1. 创建对应的writer类型。根据容量，纠错能力等选择合适类型BarcodeFormat
        PDF417Writer barcodeWriter = new PDF417Writer();
        // 2. 可以通过EncodeHintType设置一些属性(边距，行列限制，压缩，字符集，形状...)
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 0);
        // 3. 编码
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.PDF_417, 300, 150, hints);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public static String getQrCode(String msg){
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        // 设置空白边距为0
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.MARGIN, 0);
        try {
            BitMatrix bitMatrix = barcodeWriter.encode(msg, BarcodeFormat.QR_CODE, 300, 300, hints);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            return toBase64(bufferedImage);
        } catch (WriterException e) {
            log.info("生成PDF417条形码失败，msg={}", msg, e);
            throw new RuntimeException(e);
        }
    }

    private static String toBase64(BufferedImage bufferedImage) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            ImageIO.write(bufferedImage, "png", bos);
            byte[] imageBytes = bos.toByteArray();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            log.info("转换base64异常", e);
            throw new RuntimeException(e);
        }
    }
}
