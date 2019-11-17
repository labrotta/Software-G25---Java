package main;

import Model.Arrangement;
import Model.ArrangementKlasser.Lop;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
import Model.BrukerKlasser.Bruker;
import Model.BrukerKlasser.Medlem;
import Model.BrukerType;
import Model.paamelding_resultat.Resultat_Paamelding;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class MainTest {

    public static ArrayList<LocalDate> datoer;
    public static ArrayList<LocalTime> tider;
    public static ArrayList<Arrangement> arrangementer;
    public static ArrayList<BrukerType> brukere;
    public static ArrayList<Resultat_Paamelding> paameldingerOgResultater;

    @BeforeAll
    public void setUp() {}

@BeforeClass
    public static void lagAlleObjektene(){
        LocalDate dato1 = LocalDate.of(2019, 12, 24);
        LocalDate dato2 = LocalDate.of(2020, 2, 6);
        datoer.add(dato1);
        datoer.add(dato2);

        LocalTime tid1 = LocalTime.of(14, 30);
        LocalTime tid2 = LocalTime.of(19, 0);
        LocalTime tid3 = LocalTime.of(13, 0, 0);
        LocalTime tid4 = LocalTime.of(13, 43, 37);
        tider.add(tid1);
        tider.add(tid2);
        tider.add(tid3);
        tider.add(tid4);

        Arrangement skirenn = new Renn(1, "RennTest1", "Testborg", dato1, tid1);
        Arrangement sykkelritt = new Ritt(2, "RittTest1", "Testborg", dato1, tid2);
        Arrangement lop = new Lop(3, "RennTest1", "Testborg", dato2, tid1);
        Arrangement skirenn2 = new Renn(4, "RennTest1", "Testborg", dato2, tid2);
        arrangementer.add(skirenn);
        arrangementer.add(sykkelritt);
        arrangementer.add(lop);
        arrangementer.add(skirenn2);

        BrukerType admin = new Admin(1, "Admin", "Adminsen");
        BrukerType aa = new ArrangementAnsvarlig(2, "Pontus", "Pilatus");
        BrukerType medlem = new Medlem(3, "Medlem", "Melløs");
        BrukerType bruker = new Bruker(4, "Bruker", "Bruksen");
        brukere.add(admin);
        brukere.add(aa);
        brukere.add(medlem);
        brukere.add(bruker);

        Resultat_Paamelding resultat1 = new Resultat_Paamelding(aa, tid3, tid4, 3);
        Resultat_Paamelding resultat2 = new Resultat_Paamelding(medlem, tid3, tid4, 1);
        paameldingerOgResultater.add(resultat1);
        paameldingerOgResultater.add(resultat2);




    }
}