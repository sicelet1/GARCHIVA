package knihovna;

import java.sql.*;

public class Vypujcky {

    private static String najdiPrijmeni(Connection conn, int idUzivatele) throws SQLException {

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM uzivatel WHERE id = " + idUzivatele);
        rs.next();

        return rs.getString("prijmeni");
    }

    private static String najdiJmenoKnihy(Connection conn, int idKnihy) throws SQLException {

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM kniha WHERE id = " + idKnihy);
        rs.next();

        return rs.getString("jmeno");
    }

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql:")) {
            try (Statement stmt = conn.createStatement()) {

                ResultSet vsechnyVypujcene = stmt.executeQuery("SELECT * FROM vypujcka WHERE vraceno IS NULL");

                while (vsechnyVypujcene.next()) {

                    int idUzivatele = vsechnyVypujcene.getInt("id_uzivatel");
                    int idKnihy = vsechnyVypujcene.getInt("id_kniha");

                    String prijmeni = najdiPrijmeni(conn, idUzivatele);
                    String jmenoKnihy = najdiJmenoKnihy(conn, idKnihy);

                    System.out.println(prijmeni + ": " + jmenoKnihy);
                }

            } catch (SQLException e) {

                e.printStackTrace();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
