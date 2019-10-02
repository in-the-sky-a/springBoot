package com.su.springbootinterceptortest.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Utils {


    public static void main(String args[]) {
        base64Test();
    }

    public static void base64Test() {

        try {
            File fi = new File("/Users/suqianqian/picture/bank_woori.png");
            byte[] fileContent = Files.readAllBytes(fi.toPath());

            System.out.println(org.apache.commons.codec.binary.Base64.encodeBase64String(fileContent));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
