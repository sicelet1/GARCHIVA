package web_na_prvocislo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrvocisloController {
    @GetMapping("/prvocislo")

    public static long posledni = 1;

    public boolean jePrvocislo(final long cislo) {

        if (cislo < 2)
            return false;

        for (long c = 2; c * c <= cislo; c++)
            if (cislo % c == 0) return false;

        return true;
    }

    public long najdiDalsiPrvocislo(final long start) {

        long cislo = start + 1;

        while (!jePrvocislo(cislo))
            cislo++;

        return cislo;
    }

    public String dalsiPrvocislo() {

        posledni = najdiDalsiPrvocislo(posledni);

        return String.valueOf(posledni);
    }
}
