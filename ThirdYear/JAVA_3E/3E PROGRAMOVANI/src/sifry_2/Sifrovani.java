package sifry_2;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Sifrovani {

    public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException, IOException {

        Scanner sc = new Scanner(System.in);
        String vstup = sc.next();

        KeyGenerator keyGenerator = KeyGenerator.getInstance(vstup);
        keyGenerator.init(56);
        SecretKey key = keyGenerator.generateKey();

        File file = new File("klic.txt");
        FileOutputStream writer = new FileOutputStream(file);

        writer.write(key.getEncoded());
        writer.close();
    }
}
