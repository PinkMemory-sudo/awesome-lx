import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpRequest;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BASE64EncoderStream;
import lombok.extern.slf4j.Slf4j;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Ca {


    //云平台测试
    private static String SIGN_ALGORITHMS = "SHA256WithRSA";
    private static String privatekey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCqYABEKz2PpHwtUf1/PSowSpUVT5Nw6EbX+7H0ClWTN7di4pwrWrduaamTS9e7+hU6PWo95zWyiF7VxvW++Z/bPSHpHRide/YHPmuKcU6NdFcGwDdzsiEudlNJJaIjjeY4yXjMOdoNp86CSBAaMYaT7y8BbUzO+Yj2b1fMNpoRRjaRZuQf3qE3QwBOvQq78yX0upWRf4W3tfPUmT/HLBHsYYGspCfQACpA5PYIxnbNq3cMUI6TtZLHqZ+SA+SExC8IUl92fKChV6gTjy0NLuSRujj4xwWIze3x+KhAiYmivOHyZ0fNUQ/b0MRrmbUM7NA864A7NBm/2Wr50M0TBtdFAgMBAAECggEAXJxiiKuYgwQ+G8R9rzRoQmfIMhVXaABawfym9qjHa4bVwIK9sTNWkkYNT2vikOOXtli773pGzg0iv8Guw2idZGcOj9CpGLHRQo7DljWRJYMf6yOBAPrK3p6jFxfF0t3HTwb1Cs5HoTSeJGNXnWVeafuR6YyoO7mYoZxUdUUY6loEhjLBIQgZio86JX1i/jgrh42lsY89IC4ljbHFZSC+BjEya4vzoEjPKqrmshax1sPcuLqnP4CzwjAytk0TioqjZ4lECIeGaYD4tOA4viCY7bLf3DcjlaFMp4nbp96DyXjjqKVVB0qSg4MX4m6yJbb0NfAatuuXxnyUmwT6TjPB4QKBgQDhmnU4mZtVzjj86D7EvQ9Hw1K7ZwCMCEaaw1NWzP9UOY/TAUaEcKyQUpj9lPQSntxVE5udUhtWIpNfQX9IOTJmisb3AY3cZt2ASaid1cw/55k2DKnVqreDTTLMd0uJf4lq9HjGOSD56IDdpekwCzgg0oYk1L9+PnuSjSMeiZ/k+wKBgQDBVJltwPNdrD0WZTtaNLwhV69jg4LzmHkjLCAeDD1j6GecLmVKSnvKT9dfUo3ksJQ9Es+7i7TjdUjr7lPnYQasejvun7yV/+ZkVyUutCCm+fRNYKbu0BUiqTXTJnlrEViCMPmeSlEhD0TlhnYijaB+HLJjVzulF1MwCohj80EAvwKBgQDNsU9ZSKwZIspQxMueAyZwbsT6uqIECvOc3aQZixTtTQI2B36s+DJN8BEve2TBqXgIVbVXTepAsYuemRAc4JF0bumTgiY+oscn1YDYT3tHdLj7T7Z1ao6hN3yuccI8Xj0DeFy5lpLbaEI+VKv0svX87xWBdTwXNY7jgq1XhXF0iwKBgBeMpY/P9BUR+PL0a9FmIRByrOOTTm07wm29X0Apv4Se95f3stDk18ViClsLJEuaEsSJuRIgR215iONsSX4ivHxf+1Lq1D71R+wrDVVuDZgpVE/kmRD3+csaD3tj8WBQYZaiPpXAebdsM7k9ssAsvkL+XeBp7NMET1bHwatjIyTjAoGBAJIMvOFTXOB35Efj0kc9ugWTuPhvjTiBl1yXHDgbL9kvGTRLI2urFnDf71ytHqk8mIrUX/2y3/RM2/G4DE7AHZq9zr+oexvhzbC5/GCIAbRav+sNUeQuI/ekMUmvavayXxEDKNlsKDbqeKIJHYLtGinNDoUrjDBLwxoG67/1dBfr";
    private static String appId = "15";
    private static String id = "13795218582";
    private static String url = "https://device.cloud.mkeysec.net/openapi/";

    public static void main(String[] args) {
        genCode();
    }
    /**
     * 推送签名
     */
    public static void genCode(){
        String bizSn = "488cf272-36f9-4037-ba61-d9fe348ac0a2";
        String inData = "患者：李四，年龄：30岁，科室：骨科，预约号：18，日期：2019-12-30";
        String callback_url = "http://127.0.0.1/";
        String mode = "redirect";
        String desc = "test";
        try {
            // 原文SHA256摘要处理
            String msg = GetSHA256FormString(inData);
            // 组织请求数据
            Map<String, String> map = new HashMap<String, String>();
            map.put("appId", appId);
            map.put("action", "login");
            map.put("bizSn", bizSn);
            map.put("msg", URLEncoder.encode(msg, "UTF-8"));
            map.put("url", URLEncoder.encode(callback_url, "UTF-8"));
            map.put("mode", mode);
            map.put("msgWrapper", "1");
            map.put("desc", URLEncoder.encode(desc, "UTF-8"));

            // 对msg做签名
            byte[] signData = signature(privatekey, msg);
            String sign = new String(Base64.encode(signData));
            map.put("sign", URLEncoder.encode(sign, "UTF-8"));
            String resp = HttpRequest.post(url + "/v1/qrcode/gen")
                    .formStr(map)
                    .charset("UTF-8")
                    .execute().body();
            log.info("request: " + map.toString());
//            String resp = HttpClientUtil.doPost(url + "/v1/push/sign", map, "UTF-8");
            log.info("response == " + URLDecoder.decode(resp, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void push() {
        String bizSn = "488cf272-36f9-4037-ba61-d9fe348ac0a2";
        String inData = "患者：李四，年龄：30岁，科室：骨科，预约号：18，日期：2019-12-30";
        String callback_url = "http://127.0.0.1/";
        String mode = "redirect";
        String desc = "test";
        try {
            // 原文SHA256摘要处理
            String msg = GetSHA256FormString(inData);
            // 组织请求数据
            Map<String, String> map = new HashMap<String, String>();
            map.put("appId", appId);
            map.put("id", id);
            map.put("bizSn", bizSn);
            map.put("msg", URLEncoder.encode(msg, "UTF-8"));
            map.put("url", URLEncoder.encode(callback_url, "UTF-8"));
            map.put("mode", mode);
            map.put("desc", URLEncoder.encode(desc, "UTF-8"));

            // 对msg做签名
            byte[] signData = signature(privatekey, msg);
            String sign = new String(Base64.encode(signData));
            map.put("sign", URLEncoder.encode(sign, "UTF-8"));
            String resp = HttpRequest.post(url + "/v1/push/sign")
                    .formStr(map)
                    .charset("UTF-8")
                    .execute().body();
            log.info("request: " + map.toString());
//            String resp = HttpClientUtil.doPost(url + "/v1/push/sign", map, "UTF-8");
            log.info("response == " + URLDecoder.decode(resp, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static byte[] signature(String privateKey, String data) {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(
                    Base64.decode(privateKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyFactory.generatePrivate(keySpec);

            Signature oSig = Signature.getInstance(SIGN_ALGORITHMS);
            oSig.initSign(priKey);
            oSig.update(data.getBytes("UTF-8"));
            return oSig.sign();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String GetSHA256FormString(String inData) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(inData.getBytes());
            result = new String(BASE64EncoderStream.encode(messageDigest));
            System.out.println("BASE64EncoderStream1: " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
