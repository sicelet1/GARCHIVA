package knihovna;

import java.sql.*;
import java.util.Scanner;

public class MainClass {

    private static void pridejKnihuDoPujcenych(Connection conn, int idUzivatele, int idKnihy) {

        try (Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("INSERT INTO vypujcka (id_uzivatel, id_kniha, vypujceno, vraceno) VALUES (" + idUzivatele + ", " + idKnihy + ", CURRENT_TIMESTAMP, NULL)");

        } catch (SQLException e) {

            System.out.println("chyba");
        }
    }

    private static void oznacKnihuJakoVracenou(Connection conn, int idUzivatele, int idKnihy) {

        System.out.println("vypujcka vracena");

        try (Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("UPDATE TABLE vypujcka SET vraceno = CURRENT_TIMESTAMP WHERE (id_uzivatel = " + idUzivatele + ") AND (id_kniha = " + idKnihy + ")");

        } catch (SQLException e) {

            System.out.println("chyba");
        }
    }

    private static void zapujcKnihu(Connection conn, int idUzivatele, int idKnihy) {

        try (Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("SELECT * FROM vypujcka WHERE (id_uzivatel = " + idUzivatele + ") AND (id_kniha = " + idKnihy + ")");
            rs.next();

            String vypujceno = rs.getString("vypujceno");
            String vraceno = rs.getString("vraceno");

            if (vypujceno == null && vraceno == null) {

                pridejKnihuDoPujcenych(conn, idUzivatele, idKnihy);

            } else if (vypujceno != null && vraceno == null) {

                oznacKnihuJakoVracenou(conn, idUzivatele, idKnihy);
            }

        } catch (SQLException e) {

            System.out.println("chyba");
        }
    }

    private static int najdiUzivatele(Connection conn, String prijmeni) throws SQLException {

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM uzivatel");

        while (rs.next()) {

            if (rs.getString("prijmeni").equals(prijmeni))
                return rs.getInt("id");
        }

        return 0;
    }

    private static int najdiKnihu(Connection conn, String jmenoKnihy) throws SQLException {

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM kniha");

        while (rs.next()) {

            if (rs.getString("jmeno").equals(jmenoKnihy))
                return rs.getInt("id");
        }

        return 0;
    }

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:postgresql:")) {

            Scanner sc = new Scanner(System.in);
            String vstup = sc.nextLine();
            int indexPrvniMezery = vstup.indexOf(' ');

            String prijmeni = vstup.substring(0, indexPrvniMezery);
            String jmenoKnihy = vstup.substring(indexPrvniMezery + 1, vstup.length());
            int idUsera = najdiUzivatele(conn, prijmeni);
            int idKnihy = najdiKnihu(conn, jmenoKnihy);

            if (idUsera == 0) {

                System.out.println("neznamy uzivatel");

                return;
            }

            if (idKnihy == 0) {

                System.out.println("neznama kniha");

                return;
            }

            zapujcKnihu(conn, idUsera, idKnihy);


        } catch (SQLException e) {

            System.out.println("chyba");
        }
    }
}
