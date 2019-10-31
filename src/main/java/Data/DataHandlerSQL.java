package Data;

import Model.Arrangement;
import Model.ArrangementVisBruker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static Data.SQLiteConnect.SQLConnect;

public class DataHandlerSQL {
    private static LocalDateTime datoConvert(String datoS, String tidS) {
        LocalDate dato = LocalDate.parse(datoS);
        LocalTime tid = LocalTime.parse(tidS);
        return LocalDateTime.of(dato, tid);
    }

    public static  void SlettBrukerArrangement(String brukerUnikId){
        String sql = "DELETE FROM Tider WHERE BrukerUniqeID = ?";
        try {
            Connection conn = SQLConnect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, brukerUnikId);
            stmt.executeUpdate();
            conn.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void PaaMeldingBrukerArrangement(String arrangementernavn,String BrukerNavn){

        String sql = "INSERT INTO Tider (ArrangementerNavn,BrukerUniqeID,StartTid,StoppTid) VALUES(?,?,?,?)";
        try {
            Connection conn = SQLConnect();
            PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, arrangementernavn);
                stmt.setString(2, BrukerNavn);
                stmt.setString(3, "00:00:00");
                stmt.setString(4, "00:00:00");
                stmt.executeUpdate();
                conn.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ObservableList<ArrangementVisBruker> VisBrukerePrArrangement(String ArrangemnetNavn) throws SQLException {
        ObservableList<ArrangementVisBruker> VisbrukerArragement = FXCollections.observableArrayList();
        String sql = "SELECT * FROM Tider NATURAL JOIN Arrangementer WHERE ArrangementerNavn = ?";

        Connection conn = SQLConnect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, ArrangemnetNavn);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Time tidStart = Time.valueOf(rs.getString(1));
            Time tidStopp = Time.valueOf(rs.getString(1));
            String brukerUnikID = rs.getString(4);
            System.out.println(brukerUnikID);
            VisbrukerArragement.add(new ArrangementVisBruker(brukerUnikID, tidStart, tidStopp));
        }
        conn.close();
        return VisbrukerArragement;
    }

    //Henter alle arrenmangt og viser disse i Observlist
    public static ObservableList<Arrangement> sjekkSQLType(String arrangementType) throws SQLException {
        ObservableList<Arrangement> arrangementer = FXCollections.observableArrayList();

        String sql = "SELECT * FROM Arrangementer WHERE TypeFK = ?";

        Connection conn = SQLConnect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, arrangementType);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String NavnArrangement = rs.getString(2);
            String Dato = rs.getString(4);
            String Tid = rs.getString(5);
            String Sted = rs.getString(6);
            arrangementer.add(new Arrangement(NavnArrangement, Sted, datoConvert(Dato, Tid)));
        }
        conn.close();
        return arrangementer;
    }
}
