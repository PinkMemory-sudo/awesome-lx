package com.example.springdemo.demos.web.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class TesseractTest {

    public static void main(String[] args) {
        System.setProperty("jna.library.path", "C:\\Program Files\\Tesseract-OCR");
        System.setProperty("TESSDATA_PREFIX", "C:\\Program Files\\Tesseract-OCR\\tessdata");
        System.setProperty("jna.debug_load", "true");
        System.setProperty("jna.debug_load.jna", "true");
        System.load("D:\\Users\\LAN-IT-0212\\Downloads\\opencv\\build\\java\\x64\\opencv_java451.dll");
        System.out.println("OpenCV 版本: " + Core.VERSION);
        String imagePath = "E:\\Users\\LAN-IT-0212\\Desktop\\hello.png";
        Mat mat = preprocessImage(imagePath);
        System.out.println(recognizeText(mat));
    }

    public static void test() {
        System.setProperty("jna.library.path", "C:\\Program Files\\Tesseract-OCR");
        System.setProperty("TESSDATA_PREFIX", "C:\\Program Files\\Tesseract-OCR\\tessdata");
        System.setProperty("jna.debug_load", "true");
        System.setProperty("jna.debug_load.jna", "true");
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.load("D:\\Users\\LAN-IT-0212\\Downloads\\opencv\\build\\java\\x64\\opencv_java451.dll");
        System.out.println("OpenCV 版本: " + Core.VERSION);


        // 创建 Tesseract 实例
        Tesseract tesseract = new Tesseract();

        // 设置 Tesseract 安装路径（确保此路径正确）
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        // 设置语言（可改成 chi_sim 识别中文）
        tesseract.setLanguage("chi_sim");

        try {
            String imagePath = "E:\\Users\\LAN-IT-0212\\Desktop\\hello.png";
            // 读取图片（灰度模式）
            Mat image = Imgcodecs.imread(imagePath, Imgcodecs.IMREAD_GRAYSCALE);

            // 高斯模糊（去噪点）
            Imgproc.GaussianBlur(image, image, new Size(3, 3), 0);

            // 自适应二值化（增强对比度）
            Imgproc.adaptiveThreshold(image, image, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY, 11, 2);

            // 形态学处理（去除噪点）
            Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2, 2));
            Imgproc.morphologyEx(image, image, Imgproc.MORPH_CLOSE, kernel);

            // 保存处理后的图片
            String processedPath = "processed.png";
            Imgcodecs.imwrite(processedPath, image);
            // 读取测试图片（请更换为你的图片路径）
            File imageFile = new File(processedPath);
            if (!imageFile.exists()) {
                System.out.println("测试图片未找到，请检查路径！");
                return;
            }

            // 执行 OCR 识别
            String result = tesseract.doOCR(imageFile);
            System.out.println("OCR 识别结果：");
            System.out.println(result);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
    }

    // 1. 预处理图片
    public static Mat preprocessImage(String imagePath) {
        Mat image = Imgcodecs.imread(imagePath); // 读取图像
        Mat gray = new Mat();
        Mat binary = new Mat();

        // 转灰度
        Imgproc.cvtColor(image, gray, Imgproc.COLOR_BGR2GRAY);


        // 自适应二值化（提高对比度）
        Imgproc.adaptiveThreshold(gray, binary, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C,
                Imgproc.THRESH_BINARY, 11, 2);

        // 形态学操作，去掉大块区域（二维码）
        Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));
//

//        Imgproc.morphologyEx(binary, binary, Imgproc.MORPH_OPEN, kernel);
        showImage(binary,"mat");
        return binary;
    }

    // 2. OCR 文字识别
    public static String recognizeText(Mat image) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // 设定 Tesseract 路径
        tesseract.setLanguage("chi_sim");  // 识别中文

        File tempFile = new File("temp.png");
        Imgcodecs.imwrite(tempFile.getAbsolutePath(), image);

        try {
            return tesseract.doOCR(tempFile);
        } catch (TesseractException e) {
            e.printStackTrace();
            return "OCR 失败";
        }
    }

    // Mat 转 BufferedImage
    public static BufferedImage matToBufferedImage(Mat mat) {
        int width = mat.width();
        int height = mat.height();
        int channels = mat.channels();
        byte[] sourcePixels = new byte[width * height * channels];
        mat.get(0, 0, sourcePixels);

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        image.getRaster().setDataElements(0, 0, width, height, sourcePixels);

        return image;
    }

    // 显示图片
    public static void showImage(Mat img, String title) {
        BufferedImage image = matToBufferedImage(img);
        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
