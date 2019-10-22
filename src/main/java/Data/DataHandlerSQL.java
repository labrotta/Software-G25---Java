package Data;

import Model.Arrangement;
import Model.ArrangementKlasser.StdArrangement;
import Model.ArrangementVisBruker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DataHandlerSQL {
    private static LocalDateTime datoConvert(String datoS, String tidS) {
        LocalDate dato = LocalDate.parse(datoS);
        LocalTime tid = LocalTime.parse(tidS);
        return LocalDateTime.of(dato, tid);
    }

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


    public static  ObservableList<ArrangementVisBruker> VisBrukerePrArrangement(){

        ObservableList<ArrangementVisBruker>VisbrukerArragement = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Tider NATURAL JOIN Arrangementer WHERE ArrangementerNavn = 'Løp 3'";

        try (Connection conn = DataHandlerSQL.SQLConnect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Time tidStart = Time.valueOf(rs.getString(1));
                Time tidStopp = Time.valueOf(rs.getString(1));
                String brukerUnikID = rs.getString(4);

                VisbrukerArragement.add(new ArrangementVisBruker(brukerUnikID, tidStart, tidStopp));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return VisbrukerArragement;
    }

    //Henter alle arrenmangt og viser disse i Observlist
    public static ObservableList<Arrangement> sjekkSQLType(String arrangementType) {
        ObservableList<Arrangement>arrangementer = FXCollections.observableArrayList();

        String sql = "SELECT * FROM Arrangementer";
        try (Connection conn = DataHandlerSQL.SQLConnect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String TypeArrnengement = rs.getString(3);
                String NavnArrangement = rs.getString(2);
                String Dato = rs.getString(4);
                String Tid = rs.getString(5);
                String Sted = rs.getString(6);
                if(TypeArrnengement.equals(arrangementType))
                    arrangementer.add(new StdArrangement(NavnArrangement, Sted, datoConvert(Dato, Tid)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arrangementer;
    }
}
