package digitalni_podpis;

import javax.crypto.*;
import java.security.*;
import java.security.spec.*;
import java.util.*;

public class MainClass {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, SignatureException {

        /*
        String verejnyKlicVBase64 = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJ0aq4p+aR2+t/RLy1ZoE/pPswffo2JsbvtDFhE5RnH/TJXCZgSHMxhB39bIMOn2ElXeEHPcyV9m4LR/Mu35+8MCAwEAAQ==";
        byte[] verejnyKlicVBajtech = Base64.getDecoder().decode(verejnyKlicVBase64);
        PublicKey verejnyKlic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(verejnyKlicVBajtech));

        String zprava = "toto je strasne tajna zprava ze je dneska hezky";

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, verejnyKlic);

        byte[] zasifrovanaZpravaVBajtech = cipher.doFinal(zprava.getBytes());
        String zasifrovanaZpravaVBase64 = Base64.getEncoder().encodeToString(zasifrovanaZpravaVBajtech);

        System.out.println(zasifrovanaZpravaVBase64);
        */

        String klic = "MEECAQAwEwYHKoZIzj0CAQYIKoZIzj0DAQcEJzAlAgEBBCAMdG88gcqJTGMpMj3q3sAgFLIHkM1u/ifAqhh4e8UhQA==";
        byte[] klicVBajtech = Base64.getDecoder().decode(klic);
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(klicVBajtech));

        Signature signGenerator = Signature.getInstance("SHA1withRSA");
        signGenerator.initSign(privateKey);

        String msg = "Toto je sek na 10,- Kc";
        signGenerator.update(msg.getBytes());

        byte[] sign = signGenerator.sign();
        String signVBase64 = Base64.getEncoder().encodeToString(sign);

        System.out.println(msg);
        System.out.println(signVBase64);
    }
}
