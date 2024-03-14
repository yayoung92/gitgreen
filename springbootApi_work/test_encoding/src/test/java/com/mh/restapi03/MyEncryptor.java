package com.mh.restapi03;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;

public class MyEncryptor {

    private String password="passw12@rdpas12sw@rdpassw";

    @Test
    public void name(){
        System.out.println("실행됩니다." + password);

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(4);
        encryptor.setPassword(password);
        encryptor.setAlgorithm("PBEWithMD5ANdTripleDES");
        String content = "root";
        String encString = encryptor.encrypt(content);
        String decString = encryptor.decrypt(encString);
        System.out.println(String.format("root encString = %s , decString = %s ", encString, decString));

        content = "1234";
        encString = encryptor.encrypt(content);
        decString = encryptor.decrypt(encString);
        System.out.println(String.format("root encString = %s , decString = %s ", encString, decString));

        content = "jdbc:mysql://localhost:3306/ygy?useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=UTF-8&serverTimezone=UTC";
        encString = encryptor.encrypt(content);
        decString = encryptor.decrypt(encString);
        System.out.println(String.format("root encString = %s , decString = %s ", encString, decString));
    }
}
