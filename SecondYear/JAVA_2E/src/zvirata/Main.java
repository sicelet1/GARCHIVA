package zvirata;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws JsonProcessingException, IOException {

        Zvire kocka = new Kocka("mikes");
        Zvire had = new Had("nagini", 20);

        System.out.println("kocka = " + kocka.toString() + "\n");
        //System.out.println("had = " + had.toString());

        //ObjectMapper mapper = new ObjectMapper();
        XmlMapper mapper = new XmlMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        File soubor = new File("data.xml");

        mapper.writeValue(soubor, kocka);

        Zvire kocicka = mapper.readValue(soubor, Kocka.class);

        System.out.println("\n\n" + kocicka.toString());
    }
}
