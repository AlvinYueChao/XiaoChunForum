package org.example.alvin.utils;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class SecurityUtils {

    private SecurityUtils(){}

    public static String getEncryptedString(String str) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("alvin@20200418");
        config.setAlgorithm("PBEWithMD5AndDES");
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(1);
        encryptor.setConfig(config);
        return encryptor.encrypt(str);
    }

    public static String getDecryptedString(String str) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("alvin@20200418");
        config.setAlgorithm("PBEWithMD5AndDES");
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(1);
        encryptor.setConfig(config);
        return encryptor.decrypt(str);
    }

    /*public static void main(String[] args) {
        System.out.println(getEncryptedString("root"));
        System.out.println(getEncryptedString("ZiF6OZ5eB4gW2kN0"));
        System.out.println(getDecryptedString("P+BapX4qZq6CpkfAZjdNug=="));
        System.out.println(getDecryptedString("e8WREgEjQQs4zOL0re8Jg2JakDoi/ABmOf9a9VpVSR8="));
    }*/
}
