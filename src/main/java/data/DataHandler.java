package data;

import Model.Arrangement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.lang.Integer.parseInt;

public class DataHandler {

    private final static ObservableList<Arrangement> arrangementListe = FXCollections.observableArrayList();
    private static String fil1 = "src/main/resources/data/arrangementer.csv";

    public static ObservableList<Arrangement> getArrangementer() {
        //Tømmer listen slik at det ikke er igjen gamle arrangementer siden forrige gang listen ble fylt.
        arrangementListe.clear();
        genererArrangementer();
        return arrangementListe;
    }

    private static LocalDateTime datoConvert(String datoS, String tidS) {
        LocalDate dato = LocalDate.parse(datoS);
        LocalTime tid = LocalTime.parse(tidS);
        return LocalDateTime.of(dato, tid);
    }

    private static void genererArrangementer() {
     /*   //leser fra CSV
        try (BufferedReader br = new BufferedReader(new FileReader(fil1))) {
            String linje;
            while ((linje = br.readLine()) != null) {
                String[] verdi = linje.split(";");
                switch (verdi[0]) {
                    case "Ritt":
                        arrangementListe.add(new Ritt(verdi[1], verdi[2], datoConvert(verdi[3], verdi[4])));
                        break;
                    case "Renn":
                        arrangementListe.add(new Renn(verdi[1], verdi[2], datoConvert(verdi[3], verdi[4])));
                        break;
                    case "Lop":
                        arrangementListe.add(new Lop(verdi[1], verdi[2], datoConvert(verdi[3], verdi[4])));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }*/
    }
}
