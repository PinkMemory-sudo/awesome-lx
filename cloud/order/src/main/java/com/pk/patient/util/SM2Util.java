package com.pk.patient.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class SM2Util {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static final String ALGORITHM = "EC";
    private static final String PROVIDER = "BC";
    private static final String CURVE = "sm2p256v1";

    private static final String PUBLIC_KEY = "你的SM2公钥";
    private static final String PRIVATE_KEY = "你的SM2私钥";

    public static String encrypt(String plainText) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM, PROVIDER);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Hex.decode(PUBLIC_KEY));
        Cipher cipher = Cipher.getInstance("SM2", PROVIDER);
        cipher.init(Cipher.ENCRYPT_MODE, keyFactory.generatePublic(keySpec));
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        return Hex.toHexString(encrypted);
    }

    public static String decrypt(String cipherText) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM, PROVIDER);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Hex.decode(PRIVATE_KEY));
        Cipher cipher = Cipher.getInstance("SM2", PROVIDER);
        cipher.init(Cipher.DECRYPT_MODE, keyFactory.generatePrivate(keySpec));
        byte[] decrypted = cipher.doFinal(Hex.decode(cipherText));
        return new String(decrypted);
    }
}

