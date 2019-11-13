package data;

import data.DataHandlerSQL;
import org.junit.Assert;
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
        assertEquals("Velykket", DataHandlerSQL.opprettArrangement(navn,sted,dato,tid,type));
    }

    @Test
    @Order(2)
    void paaMeldingBrukerArrangement() {
        DataHandlerSQL.PaaMeldingBrukerArrangement("test Arrangement","Db_Test_User");
    }

    @Test
    @Order(3)
    void visBrukerePrArrangement() throws SQLException {
        assertNotNull(DataHandlerSQL.VisBrukerePrArrangement("test Arrangement"));
    }

    @Test
    @Order(4)
    void slettBrukerArrangement() {
       assertEquals("Bruker slettet",DataHandlerSQL.SlettBrukerArrangement(2));
    }
/*
    @Test
    @Order(5)

    void sjekkSQLType() throws SQLException {
        Assert.assertEquals("Løp",DataHandlerSQL.sjekkSQLType("Løp").get(1).getTypeArrangement());
        Assert.assertEquals("Skirenn",DataHandlerSQL.sjekkSQLType("Skirenn"));
        Assert.assertEquals("Sykkel",DataHandlerSQL.sjekkSQLType("Sykkel"));
    }*/
    @Test
    @Order(6)
    void dateconvert(){{
        String dato = "2019-03-12";
        String Tid = "17:00";
        assertEquals("2019-03-12T17:00",String.valueOf(DataHandlerSQL.datoConvert(dato,Tid)));


    }
    }
}