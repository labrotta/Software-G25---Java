package data;

import Model.BrukerType;
import Model.paamelding_resultat.Resultat_Paamelding;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DataHandlerSQLTest {

    @Test
    @Order(1)
    void opprettArrangement() throws InterruptedException {
        String navn = "test Arrangement";
        String sted = "Askim";
        String dato = "2019-01-18";
        String tid = "17:00";
        String type = "Sykkelritt";
        assertEquals("OK", DataHandlerSQL.opprettArrangement(navn,sted,dato,tid,type));
    }

    @Test
    @Order(2)
    void paaMeldingBrukerArrangement() {
        BrukerType brukerType = new BrukerType("Hans", "Hansen");
        Resultat_Paamelding resultat_paamelding = new Resultat_Paamelding(brukerType);
        assertEquals("OK", DataHandlerSQL.leggInnPaameldingDB(23,resultat_paamelding));
    }

    @Test
    @Order(3)
    void visBrukerePrArrangement() throws SQLException {
        assertNotNull(DataHandlerSQL.hentBrukere());
    }

    @Test
    @Order(4)
    void dateconvert(){{
        String dato = "2019-03-12";
        String Tid = "17:00";
        assertEquals("2019-03-12T17:00",String.valueOf(DataHandlerSQL.datoConvert(dato,Tid)));


    }
    }
}