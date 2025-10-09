package asm_sifry;

import javax.crypto.*;
import java.io.*;
import java.security.*;
import java.util.*;

public class GeneratorKlice {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("EC");
        keyGenerator.initialize(256);
        KeyPair keyPair = keyGenerator.generateKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        System.out.println("Verejny klic: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        System.out.println("Soukromy klic: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

        /*
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();

        System.out.println(Base64.getEncoder().encodeToString(key.getEncoded()));
        */

        /*
        File souborKlice = new File("klic.dat");
        FileOutputStream zapisovacKlice = new FileOutputStream(souborKlice);

        zapisovacKlice.write(key.getEncoded());
        zapisovacKlice.close();
        */
    }
}