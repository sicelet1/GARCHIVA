package sifry_2;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Sifrovac {

    public static void main(String[] args) throws IOException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {

        Scanner sc = new Scanner(System.in);
        String vstup = sc.next();

        File file1 = new File("klic.txt");
        FileInputStream reader = new FileInputStream(file1);

        byte[] klic = reader.readAllBytes();
        reader.close();

        SecretKey key = new SecretKeySpec(klic, "DES");

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] vystup = cipher.doFinal(vstup.getBytes());

        File file2 = new File("zasifrovana_zprava.txt");
        FileOutputStream writer = new FileOutputStream(file2);

        writer.write(vystup);
        writer.close();
    }
}
