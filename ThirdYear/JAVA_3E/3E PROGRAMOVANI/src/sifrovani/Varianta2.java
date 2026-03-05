package sifrovani;

import javax.crypto.*;
import java.security.*;
import java.security.spec.*;
import java.util.*;

public class Varianta2 {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException {

        Scanner sc = new Scanner(System.in);

        String privatniKlicVBase64 = "";
        String zasifrovanaZpravaVBase64 = "";
        String buf = "";
        
        while (sc.hasNextLine()) {

            buf = sc.nextLine();

            if (buf.isEmpty())
                break;

            else
                privatniKlicVBase64 += buf;
        }

        while (sc.hasNextLine()) {

            buf = sc.nextLine();

            if (buf.isEmpty())
                break;

            else
                zasifrovanaZpravaVBase64 += buf;
        }

        privatniKlicVBase64 = privatniKlicVBase64.replaceAll("[\r\n]+", "");
        zasifrovanaZpravaVBase64 = zasifrovanaZpravaVBase64.replaceAll("[\r\n]+", "");

        byte[] privatniKlicVBajtech = Base64.getDecoder().decode(privatniKlicVBase64);
        byte[] zasifrovanaZprava = Base64.getDecoder().decode(zasifrovanaZpravaVBase64);

        PrivateKey privatniKlic = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privatniKlicVBajtech));

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privatniKlic);
        byte[] zprava = cipher.doFinal(zasifrovanaZprava);

        String zpravaStr = new String(zprava);

        System.out.println(zpravaStr);
    }
}
