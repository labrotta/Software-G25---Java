package data;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static data.SQLiteConnect.SQLConnectTest;
import static org.junit.jupiter.api.Assertions.*;

class DataHandlerSQLTestLeggTilBrukerArrangement {
    @Test
    public void LeggTilBrukerArrangement() throws SQLException {
        String sql = "INSERT INTO Tider (ArrangementerNavn,BrukerUniqeID,StartTid,StoppTid) VALUES(?,?,?,?)";
        Connection conn = SQLConnectTest();
        String BrukerUnik = "BrukerTest01";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "Løp 1");
        stmt.setString(2, BrukerUnik);
        stmt.setString(3, "00:00:00");
        stmt.setString(4, "00:00:00");
        stmt.executeUpdate();
        conn.close();

        String sql_2 = "SELECT * FROM Tider WHERE BrukerUniqeID = ?";
        PreparedStatement stmt_2 = conn.prepareStatement(sql_2);
        stmt_2.setString(1,BrukerUnik);
        ResultSet rs = stmt.executeQuery();
        Assert.assertEquals(rs.getInt(4),BrukerUnik);
        conn.close();
    }
}