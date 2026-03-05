package chat_client;

import java.sql.*;

public class VypisChat extends Thread {

    private void vypisChat(Connection conn) throws SQLException, InterruptedException {

        int posledniPoradi = 0;

        while (true) {

            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM zprava WHERE poradi > " + posledniPoradi);

                while (rs.next()) {

                    String msg = rs.getString("msg");
                    int poradi = rs.getInt("poradi");
                    posledniPoradi = poradi;

                    System.out.println("" + poradi + ". " + msg);
                }
            }
            catch (SQLException e) {

                e.printStackTrace();
            }

            Thread.sleep(3000);
        }
    }

    public void run() {

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql:db3963", "db3963", "programovani")) {
            vypisChat(conn);

        } catch (SQLException | InterruptedException e) {

            e.printStackTrace();
        }
    }
}
