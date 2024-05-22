package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

public class IoTest {


    public static void main(String[] args) throws IOException {
        System.out.println("asd"+null);
    }

    public static void readGzFile(String gzFile) throws IOException {
        try (
                FileInputStream fis = new FileInputStream(gzFile);
                GZIPInputStream gzipIn = new GZIPInputStream(fis);
                InputStreamReader isr = new InputStreamReader(gzipIn);
                BufferedReader reader = new BufferedReader(isr);
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
