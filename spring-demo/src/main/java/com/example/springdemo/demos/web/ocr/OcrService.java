package com.example.springdemo.demos.web.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class OcrService {

    public String extractText(String imagePath) {
        ITesseract tesseract = new Tesseract();

        // 设置 Tesseract OCR 目录（Windows 需要指定路径）
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");

        // 设置 OCR 语言（支持多种语言）
        tesseract.setLanguage("chi_sim+eng");

        try {
            File imageFile = new File(imagePath);
            return tesseract.doOCR(imageFile);
        } catch (TesseractException e) {
            e.printStackTrace();
            return "OCR 识别失败";
        }
    }
}

