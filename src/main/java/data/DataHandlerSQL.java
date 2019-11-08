package data;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DataHandlerSQL {
    public static LocalDateTime datoConvert(String datoS, String tidS) {
        LocalDate dato = LocalDate.parse(datoS);
        LocalTime tid = LocalTime.parse(tidS);
        return LocalDateTime.of(dato, tid);
    }

    public static ObservableList<VisResultatBruker> visResultaterBrukerside(BrukerType brukerUniqueID) throws SQLException {
        String sql = "SELECT * FROM Tider  NATURAL JOIN Arrangementer WHERE BrukerUniqeID = ?";
        Connection conn = SQLiteConnect.SQLConnect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, String.valueOf(brukerUniqueID));
        ResultSet rs = stmt.executeQuery();
        ArrayList<VisResultatBruker> samleResultat = new ArrayList<>();
        while (rs.next()) {
            String NavnArrangement = rs.getString(3);
            String Dato = rs.getString(8);
            String Reultat = rs.getString(5);
            String Sted = rs.getString(10);
            VisResultatBruker VisResultatBruk = new VisResultatBruker(Dato,Reultat,Sted,NavnArrangement);
            samleResultat.add(VisResultatBruk);
        }
        conn.close();
        ObservableList<VisResultatBruker> visResultaterBruker = FXCollections.observableArrayList(samleResultat);
        return visResultaterBruker;

    }

    public static String SlettBrukerArrangement(String brukerUnikId){
        String sql = "DELETE FROM Tider WHERE BrukerUniqeID = ?";
        try {
            Connection conn = SQLiteConnect.SQLConnect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, brukerUnikId);
            stmt.executeUpdate();
            conn.close();
        }catch (SQLException e) {
           return e.getMessage();
        }
        return "Bruker slettet";
    }

    public static DataHandlerSQL PaaMeldingBrukerArrangement(String arrangementernavn, String BrukerNavn){

        String sql = "INSERT INTO Tider (ArrangementerNavn,BrukerUniqeID,StartTid,StoppTid) VALUES(?,?,?,?)";
        try {
            Connection conn = SQLiteConnect.SQLConnect();
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
        return null;
    }

    public static ObservableList<ArrangementVisBruker> VisBrukerePrArrangement(String ArrangemnetNavn) throws SQLException {
        String sql = "SELECT * FROM Tider NATURAL JOIN Arrangementer WHERE ArrangementerNavn = ?";

        Connection conn = SQLiteConnect.SQLConnect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, ArrangemnetNavn);
        ResultSet rs = stmt.executeQuery();

        ArrayList<ArrangementVisBruker> ArrangementVisBruk = new ArrayList<ArrangementVisBruker>();
        while (rs.next()) {
            Time tidStart = Time.valueOf(rs.getString(1));
            Time tidStopp = Time.valueOf(rs.getString(1));
            String brukerUnikID = rs.getString(4);
            ArrangementVisBruker ArrangementVisBruker = new ArrangementVisBruker(brukerUnikID, tidStart, tidStopp);
            ArrangementVisBruk.add(ArrangementVisBruker);
        }
        conn.close();
        ObservableList<ArrangementVisBruker> VisbrukerArragement = FXCollections.observableArrayList(ArrangementVisBruk);
        return VisbrukerArragement;
    }

    //Henter alle arrenmangt og viser disse i Observlist
    public static ObservableList<Arrangement> sjekkSQLType(String arrangementType) throws SQLException {

        ArrayList<Arrangement> opprettArr = new ArrayList<Arrangement>();
        String sql = "SELECT * FROM Arrangementer WHERE TypeFK = ?";

        Connection conn = SQLiteConnect.SQLConnect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, arrangementType);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String NavnArrangement = rs.getString(2);
            String Dato = rs.getString(4);
            String Tid = rs.getString(5);
            String Sted = rs.getString(6);
            Arrangement opprettArragement = new Arrangement(NavnArrangement, Sted, datoConvert(Dato, Tid));
            opprettArr.add(opprettArragement);
        }
        conn.close();
        ObservableList<Arrangement> arrangementer = FXCollections.observableArrayList(opprettArr);
        return arrangementer;
    }
    public static String opprettArrangement(String arrangementernavn, String sted, String dato, String tid, String typeArrangement){
        String sql = "INSERT INTO Arrangementer (ArrangementerNavn,Sted,Dato,Tid,TypeFk) VALUES(?,?,?,?,?)";
        try {
            Connection conn = SQLiteConnect.SQLConnect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, arrangementernavn);
            stmt.setString(2, sted);
            stmt.setString(3, dato);
            stmt.setString(4, tid);
            stmt.setString(5, typeArrangement);
            stmt.executeUpdate();
            conn.close();
        }catch (SQLException e) {
            return e.getMessage();
        }
        return "Velykket";
    }
}
