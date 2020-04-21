package org.example.alvin.web;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptTestController {
    @Value("jasypt.encryptor.password")
    private String encrypt_key;

    @RequestMapping(value = "/encrypt")
    public String getEncryptedString(String input) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(encrypt_key);
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(1);
        encryptor.setConfig(config);
        return encryptor.encrypt(input);
    }

    @RequestMapping(value = "/decrypt")
    public String getDecryptedString(String input) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(encrypt_key);
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(1);
        encryptor.setConfig(config);
        return encryptor.decrypt(input);
    }
}
