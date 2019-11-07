package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnect {

    public static Connection SQLConnect() {

        Connection conn = null;
        try {
            String URL = "jdbc:sqlite:src/main/resources/data/arrangementer.db";
            conn = DriverManager.getConnection(URL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}