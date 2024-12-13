package telefonni_seznam;

import java.io.Serializable;

public class TelCislo implements Serializable {

    public String jmeno;
    public String telCislo;

    public TelCislo(String jmeno, String telCislo) {
        this.jmeno = jmeno;
        this.telCislo = telCislo;
    }

    @Override
    public String toString() {

        return "TelCislo{" + "jmeno=\'" + jmeno + "\', telCislo=\'" + telCislo + "\'}";
    }
}
