package web_server;

import java.net.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.io.*;

public class Main {

    public static void zpracujPozadavek(BufferedReader in, PrintWriter out) throws IOException {

        for (String request = in.readLine(); !request.isEmpty(); request = in.readLine()) {

            System.out.println(request);
        }

        System.out.println("Konec hlavicky");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime konecHodiny = LocalDateTime.of(2025, 3, 28, 11, 54);
        int minut = Math.toIntExact(ChronoUnit.MINUTES.between(now, konecHodiny));

        out.println("HTTP/1.1 200 OK");
        out.println("Connection: close");
        out.println("Content-Type: text/html; charset=UTF-8");
        out.println();
        out.println("<html><body><h1>" + minut + "</h1></body></head>");

        System.out.println("Konec pozadavku =============================");
    }

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(10000);

        while (true) {

            Socket socket = server.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            zpracujPozadavek(in, out);

            socket.close();
        }
    }
}
