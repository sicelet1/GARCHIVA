package http_protokol;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {

        int halted_ports_count = 0;

        for (int c = 1; c < 65536; c++) {

            try {

                ServerSocket server = new ServerSocket(c);
                server.close();

            } catch (IOException e) {

                System.out.println(c);
                halted_ports_count++;
            }

        }

        System.out.println("Pocet obsazenych: " + halted_ports_count);
    }
}
