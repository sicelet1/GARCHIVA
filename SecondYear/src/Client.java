import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.82.5", 10_000);

        while (true) {

            Scanner keyboard = new Scanner(System.in);

            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            writer.println(keyboard.next());

            writer.close();
        }
    }
}
