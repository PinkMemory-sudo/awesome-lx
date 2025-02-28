package com.example.springdemo.demos.web.ocr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/ocr")
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @PostMapping("/upload")
    public String extractText(@RequestParam("file") MultipartFile file) {
        try {
            // 保存上传的文件
            File tempFile = Files.createTempFile("ocr_", ".png").toFile();
            file.transferTo(tempFile);

            // 进行 OCR 识别
            String text = ocrService.extractText(tempFile.getAbsolutePath());

            // 删除临时文件
            tempFile.delete();

            return text;
        } catch (IOException e) {
            return "文件处理失败";
        }
    }
}

