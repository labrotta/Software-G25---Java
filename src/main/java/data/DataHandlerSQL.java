package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class DataHandlerSQL {

    public static Connection SQLConnect() {
        Connection conn = null;
        try {
            String URL = "jdbc:sqlite:src/main/resources/Data/arrangementer.db";
            conn = DriverManager.getConnection(URL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static ObservableList<String> sjekkSQLType(String arrangementType) {
        ObservableList<String> arrangementer = FXCollections.observableArrayList();
        if ("Løp".equals(arrangementType)) {
            arrangementer.add(genererArrangementer(arrangementType));
            return arrangementer;
        } else if ("Sykkelritt".equals(arrangementType)) {
            arrangementer.add(genererArrangementer(arrangementType));
            return arrangementer;
        } else if ("Skirenn".equals(arrangementType)) {
            arrangementer.add(genererArrangementer(arrangementType));
            return arrangementer;
        }
        return arrangementer;
    }
    public static String genererArrangementer(String x) {
        String sql = "SELECT * FROM Tider NATURAL JOIN Arrangementer";
       ArrayList<String> Placeholder = new ArrayList<>();
        try (Connection conn = DataHandlerSQL.SQLConnect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String TypeArrnengement = rs.getString(5);
                String NavnArrangement = rs.getString(4);
                String StartTid = rs.getString(3);
                String StoppTid = rs.getString(4);

                if(TypeArrnengement.equals(x)) {
                    Placeholder.add(NavnArrangement);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return String.valueOf(Placeholder);
    }

    /*public static ObservableList<Arrangement> getArrangementer() {
        return arrangementTestListe;
    }*/
}
