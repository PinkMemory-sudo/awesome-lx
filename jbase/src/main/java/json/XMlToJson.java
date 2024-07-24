package json;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XMlToJson {
    public static void main(String[] args) {
        // 指定文件路径
        String filePath = "E:\\Users\\LAN-IT-0212\\Documents\\WXWork\\1688856747561427\\Cache\\File\\2024-07\\重症接口\\医嘱推送.txt";

        try {
            String xmlContent = new String(Files.readAllBytes(Paths.get(filePath)));

            JSONObject jsonObject = JSONUtil.parseFromXml(xmlContent);

            System.out.println(jsonObject.toStringPretty());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
