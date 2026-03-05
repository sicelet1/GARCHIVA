package chat_client;

import java.sql.*;
import java.util.*;

public class MainClass {

    private static void insertMsg(Connection conn, int posledniPoradi, String msg) {

        //try (Statement stmt = conn.createStatement()) {

            String sql = "INSERT INTO zprava (poradi, auto, msg) VALUES (" + (posledniPoradi + 1) + ", 'ja', '" + msg + "')";
            System.out.println(sql);
            //stmt.executeUpdate(sql);
        //}
    }

    private static void ulozDoDB(Connection conn, String msg) {

        //int posledniPoradi = dejPosledniPoradi(conn);
        //insertMsg(conn, posledniPoradi, msg);
    }

    public static void main(String[] args) {
        
        VypisChat vlakno = new VypisChat();
        vlakno.start();

        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql:db3963", "db3963", "programovani")) {

            while (true) {

                String msg = sc.nextLine();
                ulozDoDB(conn, msg);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}
