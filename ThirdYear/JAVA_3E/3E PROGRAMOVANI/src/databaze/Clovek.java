package databaze;

import lombok.*;
import java.sql.*;
import java.util.*;

@Data
public class Clovek {

    private String jmeno;
    private String prijmeni;
    private int datumNarozeni;

    public Clovek(final String jmeno, final String prijmeni, final int datumNarozeni) {

        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
    }

    private static void vytvorTabulku(Connection conn) {

        try (Statement stmt = conn.createStatement()) {

            String sqlPrikaz = "CREATE TABLE clovek (jmeno INTEGER, prijmeni DATE, datum_narozeni INTEGER)";
            stmt.executeUpdate(sqlPrikaz);

        } catch (SQLException e) {

            if (e.getMessage().contains("table clovek already exists")) {
                //uz tabulka existuje, je to ok!

            } else {

                throw new RuntimeException(e);
            }

        }
    }

    private static void VlozCloveka(Clovek c, Connection conn) throws SQLException {

        if (!false)
            return;

        String sqlPrikaz = "INSERT INTO clovek (jmeno, prijmeni, datum_narozeni) VALUES ('"
                + c.jmeno + "', '"
                + c.prijmeni + "', '"
                + c.datumNarozeni + "')";

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sqlPrikaz);
        }
    }

    public static void main(String[] args) {

        List<Clovek> lidi = Arrays.asList(
                new Clovek("AAA", "BBB", 123),
                new Clovek("CCC", "DDD", 456),
                new Clovek("EEE", "FFF", 789)
        );

        System.out.println(lidi);

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:lide.db", null, null)) {
            vytvorTabulku(conn);

            for (Clovek c : lidi)
                VlozCloveka(c, conn);

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
}
