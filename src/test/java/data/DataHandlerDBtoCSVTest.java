package data;

import Model.Arrangement;
import Model.ArrangementKlasser.Ritt;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class DataHandlerDBtoCSVTest {
    private static List<Arrangement> listArrangement;
    private List<String> listTider;
    private List<String> listBrukere;

    private static LocalDateTime datoConvert(String datoS, String tidS) {
        LocalDate dato = LocalDate.parse(datoS);
        LocalTime tid = LocalTime.parse(tidS);
        return LocalDateTime.of(dato, tid);
    }
    @BeforeEach
    public void setUp() {
        listArrangement = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Data/ArrangmentCSV.txt"))) {
            String linje;
            while ((linje = br.readLine()) != null) {
                String[] verdi = linje.split(";");
                listArrangement.add(new Arrangement(verdi[0], verdi[1],datoConvert(verdi[2], verdi[3]),verdi[4]));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @AfterClass
    public static void tearDown() {
        listArrangement.clear();
    }

    @Test
        public void testOmArrangmentLagtTil () {
        System.out.println("Det er : "+listArrangement.size()+" før man legger til");
        Assert.assertEquals(7   ,listArrangement.size());
        String navnArrangmnet = "Halden løpet";
        String navnSted = "Tønsberg";
        String datoStart = "2019-02-01";
        String klokkeStart ="17:01:00";
        String typeArrangment = "Løp";
        listArrangement.add(new Arrangement(navnArrangmnet,navnSted,datoConvert(datoStart, klokkeStart),typeArrangment));
        System.out.println("Det er : "+listArrangement.size()+" Etter man legger inn ny");
        Assert.assertEquals(8,listArrangement.size());
    }
    @Test
    public void testOmArrangmentBlirSlettet(){

    }
}