package data;

import Model.*;
import Model.ArrangementKlasser.Lop;
import Model.ArrangementKlasser.Renn;
import Model.ArrangementKlasser.Ritt;
import Model.BrukerKlasser.Admin;
import Model.BrukerKlasser.ArrangementAnsvarlig;
import Model.BrukerKlasser.Medlem;
import Model.paamelding_resultat.Resultat_Paamelding;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


public class DataHandlerSQL {

    public static LocalDateTime datoConvert(String datoS, String tidS) {
        LocalDate dato = LocalDate.parse(datoS);
        LocalTime tid = LocalTime.parse(tidS);
        return LocalDateTime.of(dato, tid);
    }

    public static String SlettBrukerArrangement(int brukerUnikId){
        String sql = "DELETE FROM TiderPaameldinger WHERE BrukerUniqeID = ?";
        try {
            Connection conn = SQLiteConnect.SQLConnect();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, brukerUnikId);
            stmt.executeUpdate();
            conn.close();
        }catch (SQLException e) {
           return e.getMessage();
        }
        return "Bruker slettet";
    }

    public static String leggInnPaamelding(int arrangementID, Resultat_Paamelding resultat_paamelding){
        String sql = "INSERT INTO TiderPaameldinger (ArrangementID, BrukerID, ErResultat) VALUES(?,?,?)";

        try {
            Connection connection = SQLiteConnect.SQLConnect();
            PreparedStatement streng = connection.prepareStatement(sql);
                    streng.setInt(1, arrangementID);
                    streng.setInt(2, resultat_paamelding.getUtoover().getId());
                    streng.setBoolean(3, false);
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return "Påmelding lagt inn";
    }

    public static DataHandlerSQL leggInnResultat(int arrangementID, Resultat_Paamelding resultat_paamelding){

        String sql = "INSERT INTO TiderPaameldinger (StartTid,StoppTid,ArrangementID, BrukerID, Plasseringer, ErResultat) VALUES(?,?,?,?,?,?)";
        try {
            Connection conn = SQLiteConnect.SQLConnect();
            PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, resultat_paamelding.getStarttid().toString());
                stmt.setString(2, resultat_paamelding.getSlutttid().toString());
                stmt.setInt(3, arrangementID);
                stmt.setInt(4, resultat_paamelding.getUtoover().getId());
                stmt.setInt(5, resultat_paamelding.getPlassering());
                stmt.setBoolean(6, true);
                stmt.executeUpdate();
                conn.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<BrukerType> hentBrukere(){
        ArrayList<BrukerType> brukere = new ArrayList<>();

        try {
            String sporring = "SELECT * FROM Brukere";

            Connection connection = SQLiteConnect.SQLConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(sporring);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String fornavn = resultSet.getString(2);
                String etternavn = resultSet.getString(3);
                String rettighetsNivaa = resultSet.getString(4);

                switch (rettighetsNivaa){
                    case "admin": {
                        BrukerType admin = new Admin(id, fornavn, etternavn);
                        brukere.add(admin);
                        break;
                    }case "aa": {
                        BrukerType arrangementAnsvarlig = new ArrangementAnsvarlig(id, fornavn, etternavn);
                        brukere.add(arrangementAnsvarlig);
                        break;
                    }case "medlem": {
                        BrukerType medlem = new Medlem(id, fornavn, etternavn);
                        brukere.add(medlem);
                        break;
                    }
                }
            }

        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return brukere;
    }

    public static ArrayList<Arrangement> hentArrangementerMedPaameldinger(){

        ArrayList<Arrangement> arrangementer = hentArrangementer();
        ArrayList<BrukerType> brukere = hentBrukere();

        try {
            String sporring = "SELECT * FROM TiderPaameldinger";

            Connection connection = SQLiteConnect.SQLConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(sporring);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int arrangementID = resultSet.getInt(3);
                int brukerID = resultSet.getInt(4);

                for (BrukerType bruker : brukere){
                    if (bruker.getId() == brukerID){
                        for (Arrangement arrangement : arrangementer){
                            if (arrangement.getId() == arrangementID){
                                //Resultat_Paamelding betyr i denne settingen "påmelding"
                                Resultat_Paamelding paamelding = new Resultat_Paamelding(bruker);
                                arrangement.setPaameldinger(paamelding);
                                if (resultSet.getBoolean(6)){

                                    LocalTime start = LocalTime.parse(resultSet.getString(1));
                                    LocalTime slutt = LocalTime.parse(resultSet.getString(2));
                                    int plassering = resultSet.getInt(5);
                                    Resultat_Paamelding resultat = paamelding;
                                    resultat.setPlassering(plassering);
                                    resultat.setStarttid(start);
                                    resultat.setSlutttid(slutt);
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return arrangementer;
    }

    public static ArrayList<Arrangement> hentArrangementer(){

        ArrayList<Arrangement> arrangementer = new ArrayList<>();

        try {

            String sporring = "SELECT * FROM Arrangementer";

            Connection connection = SQLiteConnect.SQLConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(sporring);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String navn = resultSet.getString(2);
                String type = resultSet.getString(3);
                LocalDate dato = LocalDate.parse(resultSet.getString(4));
                LocalTime tid = LocalTime.parse(resultSet.getString(5));
                String sted = resultSet.getString(6);

                switch (type) {
                    case "Sykkelritt":{
                        Arrangement ritt = new Ritt(id, navn, sted, dato, tid);
                        arrangementer.add(ritt);
                        break;
                    }
                    case "Skirenn":{
                        Arrangement renn = new Renn(id, navn, sted, dato, tid);
                        arrangementer.add(renn);
                        break;
                    }
                    case "Løp":{
                        Arrangement lop = new Lop(id, navn, sted, dato, tid);
                        arrangementer.add(lop);
                        break;
                    }
                }
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return arrangementer;
    }

    public static ArrayList<ArrangementVisBruker> VisBrukerePrArrangement(String ArrangemnetNavn) throws SQLException {
        String sql = "SELECT * FROM TiderPaameldinger NATURAL JOIN Arrangementer WHERE ArrangementerNavn = ?";

        Connection conn = SQLiteConnect.SQLConnect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, ArrangemnetNavn);
        ResultSet rs = stmt.executeQuery();

        ArrayList<ArrangementVisBruker> ArrangementVisBruk = new ArrayList<>();
        while (rs.next()) {
            Time tidStart = Time.valueOf(rs.getString(1));
            Time tidStopp = Time.valueOf(rs.getString(1));
            String brukerUnikID = rs.getString(4);
            ArrangementVisBruker ArrangementVisBruker = new ArrangementVisBruker(brukerUnikID, tidStart, tidStopp);
            ArrangementVisBruk.add(ArrangementVisBruker);
        }
        conn.close();
        System.out.println(ArrangementVisBruk);
        return ArrangementVisBruk;
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
