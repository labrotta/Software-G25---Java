package data;
import org.junit.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.*;

import static data.SQLiteConnect.SQLConnect;
import static data.SQLiteConnect.SQLConnectTest;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class DataHandlerSQLTest{

    @Test //Skriver en test for å sjekke om vi har riktig JDBC kontroller
    public void TestForbindelseJDBCDriver() throws SQLException {
        Connection dbcon = SQLConnectTest();
        Assert.assertNotNull(dbcon);
        if(dbcon.toString().contains("org.sqlite")){
            Assert.assertTrue(dbcon.isValid(0));
            dbcon.close();
        }
            dbcon.close();
    }

    @Test
    public void TestForbindelseSvarTilbake() throws SQLException {
        String sql = "SELECT count(*) FROM Arrangementer";
        Connection conn = SQLConnectTest();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        Assert.assertNotNull(rs);
        conn.close();
    }
    @Test
    public void TestAntallLinjer() throws SQLException {
        String sql = "SELECT count(*) FROM Arrangementer";
        Connection conn = SQLConnectTest();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        Assert.assertNotNull(rs);
        Assert.assertEquals(7,rs.getInt(1));
        conn.close();
    }

    @ParameterizedTest
    @ValueSource(strings = { "Løp 1","Ski ","Løp 2","Løp 3","Sykkel 1","Birkebeinere 2019","Powerdrag 2019" })
    void TestSjekkArrangementForLop(String text) throws SQLException {
        String sql = "SELECT ArrangementerNavn FROM Arrangementer WHERE ArrangementerNavn = ?";
        Connection conn = SQLConnectTest();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1,text);
        ResultSet rs = stmt.executeQuery();
        assertEquals(text,rs.getString(1));
        //conn.close();
    }
}