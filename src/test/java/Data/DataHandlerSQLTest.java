package Data;

import Data.DataHandlerSQL;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static junit.framework.TestCase.assertNull;
import static org.junit.jupiter.api.Assertions.assertAll;
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
        Assert.assertEquals("Velykket", DataHandlerSQL.opprettArrangement(navn,sted,dato,tid,type));
    }

    @Test
    @Order(2)
    void paaMeldingBrukerArrangement() {
        DataHandlerSQL.PaaMeldingBrukerArrangement("test Arrangement","Db_Test_User");
    }

    @Test
    @Order(3)
    void visBrukerePrArrangement() throws SQLException {
        Assert.assertNotNull(DataHandlerSQL.VisBrukerePrArrangement("test Arrangement"));
    }

    @Test
    @Order(4)
    void slettBrukerArrangement() {
       Assert.assertEquals("Bruker slettet",DataHandlerSQL.SlettBrukerArrangement("Db_Test_User"));
    }

    @Test
    @Order(5)
    void sjekkSQLType() throws SQLException {
        Assert.assertEquals("Løp",DataHandlerSQL.sjekkSQLType("Løp").get(1).getTypeArrangement());
        Assert.assertEquals("Skirenn",DataHandlerSQL.sjekkSQLType("Skirenn"));
        Assert.assertEquals("Sykkel",DataHandlerSQL.sjekkSQLType("Sykkel"));
    }
    @Test
    @Order(6)
    void dateconvert(){{
        String dato = "2019-03-12";
        String Tid = "17:00";
        Assert.assertEquals("2019-03-12T17:00",String.valueOf(DataHandlerSQL.datoConvert(dato,Tid)));


    }
    }
}