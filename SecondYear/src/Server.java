import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(10000);

        while (true) {

            try {

                Socket socket = server.accept();

                InputStream in = socket.getInputStream();
                Reader reader = new InputStreamReader(in);
                Scanner sc = new Scanner(reader);

                String line = sc.nextLine();
                System.out.println(line);

            } catch (IOException e) {

                System.out.println("Chyba");
            }

        }
    }
}