package certifikaty;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

public class Certifikaty {

    public static void main(String[] args) throws IOException {

        URL destinationURL = new URL("https://www.google.com");
        HttpsURLConnection conn = (HttpsURLConnection) destinationURL.openConnection();
        conn.connect();
        Certificate[] certs = conn.getServerCertificates();

        System.out.println("Pocet certifikatu: " + certs.length + "\n");

        for (Certificate prvek : certs) {

            X509Certificate certificate = (X509Certificate)prvek;
            System.out.println("===========================================================================================" + prvek.toString());
        }
    }
}
