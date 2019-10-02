package com.su.springbootinterceptortest.utils;


import org.apache.logging.log4j.util.StringBuilders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class SignGenerator {
    public final static String ALGORITHM_SHA256 = "SHA256withRSA";


    public static  void main(String args[]) {
        StringBuilder sb = new StringBuilder();
        String requestId = "123456789123456";
        String referenceId = "VICASH1234567891234";
        String requestTime = "2018-09-20 10:54:55";
        BigDecimal amount = BigDecimal.valueOf(1830000);
        BigDecimal fee = BigDecimal.valueOf(0);
        sb.append(requestId)
                .append("|")
                .append(referenceId)
                .append("|")
                .append(requestTime)
                .append("|")
                .append(amount)
                .append("|")
                .append(fee);
        try {
            System.out.println(sb.toString());
            System.out.println("=============");
            System.out.println(genSign(sb.toString()));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //"requestId|referenceId|requestTime|amount|fee"
    //123456789123456|VICASH1234567891234|2018-09-20 10:54:55|1830000|0
    public static String genSign(String data4Sign) throws GeneralSecurityException, IOException {
        byte[] data4SignBytes = data4Sign.getBytes(StandardCharsets.UTF_8);
        Signature sigPub4Notify = Signature.getInstance(ALGORITHM_SHA256);
        sigPub4Notify.initSign(SignGenerator.getPrivateKey("data/private_key.pem"));
        sigPub4Notify.update(data4SignBytes, 0, data4SignBytes.length);
        byte[] sign = sigPub4Notify.sign();
        return toHexString(sign);
    }

    public static byte[] fromHexString(String s) throws IllegalArgumentException {
        int stringLength = s.length();
        if ((stringLength & 0x1) != 0) { //Odd (le)
            throw new IllegalArgumentException("fromHexString requires an even number of hex characters");
        }
        byte[] b = new byte[stringLength / 2];

        for (int i = 0, j = 0; i < stringLength; i += 2, j++) {
            int high = charToNibble(s.charAt(i));
            int low = charToNibble(s.charAt(i + 1));
            b[j] = (byte) ((high << 4) | low);
        }
        return b;
    }

    private static int charToNibble(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        } else if ('a' <= c && c <= 'f') {
            return c - 'a' + 0xa;
        } else if ('A' <= c && c <= 'F') {
            return c - 'A' + 0xa;
        } else {
            throw new IllegalArgumentException("Invalid hex character: " + c);
        }
    }

    public static String toHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            // look up high nibble char
            sb.append(hexChar[(b[i] & 0xF0) >>> 4]);
            // look up low nibble char
            sb.append(hexChar[b[i] & 0x0F]);
        }
        return sb.toString();
    }

    static char[] hexChar = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'A', 'B',
            'C', 'D', 'E', 'F'};

    private static String getKey(String name) throws IOException {
        // Read key from file


        InputStream resourceAsStream = SignGenerator.class.getClassLoader().getResourceAsStream(name);
        assert resourceAsStream != null;

        BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream));

        StringBuilder strKeyPEM = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            strKeyPEM.append(line).append("\n");
        }
        br.close();
        return strKeyPEM.toString();
    }

    private static RSAPrivateKey getPrivateKey(String fileRelativePath) throws IOException, GeneralSecurityException {
        String privateKeyPEM = getKey(fileRelativePath);
        return getPrivateKeyFromString(privateKeyPEM);
    }

    private static RSAPrivateKey getPrivateKeyFromString(String key) throws IOException, GeneralSecurityException {
        String privateKeyPEM = key;
        privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----\n", "");
        privateKeyPEM = privateKeyPEM.replace("-----END PRIVATE KEY-----", "");
        byte[] encoded = Base64.getMimeDecoder().decode(privateKeyPEM);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        return (RSAPrivateKey) kf.generatePrivate(keySpec);
    }
}
