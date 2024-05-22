import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ScelToTxtConverter {

    public static void main(String[] args) {
        String scelFilePath = "E:\\Users\\LAN-IT-0212\\Downloads\\example.scel";
        String txtFilePath = "E:\\Users\\LAN-IT-0212\\Downloads\\\\output.txt";

        try {
            List<String> words = extractWordsFromScel(scelFilePath);
            writeWordsToTxt(words, txtFilePath);
            System.out.println("转换完成！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> extractWordsFromScel(String scelFilePath) throws IOException {
        List<String> words = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(scelFilePath);
             DataInputStream dis = new DataInputStream(fis)) {
            // 跳过前面的文件头
            dis.skipBytes(0x1540);
            byte[] buffer = new byte[1024];
            int length;
            // 读取每个词条，并将其添加到列表中
            while ((length = dis.read(buffer)) != -1) {
                String word = new String(buffer, 0, length, StandardCharsets.ISO_8859_1);
                words.add(word);
            }
        }
        return words;
    }

    public static void writeWordsToTxt(List<String> words, String txtFilePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(txtFilePath))) {
            for (String word : words) {
                writer.write(word);
                writer.newLine();
            }
        }
    }
}
