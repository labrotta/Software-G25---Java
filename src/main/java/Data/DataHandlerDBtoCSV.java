package data;

import Data.SQLiteConnect;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataHandlerDBtoCSV {
    public void ArrangementerTilCSV() throws SQLException {
        int csv = 1;
        String sql = "SELECT * FROM Arrangementer";
        Connection conn = SQLiteConnect.SQLConnect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String Ar = new StringBuilder().append(rs.getString(2)).append(";").append(rs.getString(3)).append(";").append(rs.getString(4)).append(";").append(rs.getString(5)).append(";").append(rs.getString(6)).append(System.lineSeparator()).toString();
            CVSGenerator(Ar,csv);
        }
    }

    public void TiderTilCSV() throws SQLException {
        int csv = 2;
        String sql = "SELECT * FROM Tider";
        Connection conn = SQLiteConnect.SQLConnect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String Ar = new StringBuilder().append(rs.getString(1)).append(";").append(rs.getString(2)).append(";").append(rs.getString(3)).append(";").append(rs.getString(4)).append(System.lineSeparator()).toString();
            CVSGenerator(Ar,csv);
        }
    }

    public void BrukereTilCSV() throws SQLException {
        int csv = 3;
        String sql = "SELECT * FROM Brukere";
        Connection conn = SQLiteConnect.SQLConnect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String Ar = new StringBuilder().append(rs.getString(2)).append(";").append(rs.getString(3)).append(";").append(rs.getString(4)).append(";").append(rs.getString(5)).append(System.lineSeparator()).toString();
            CVSGenerator(Ar,csv);
        }
    }

    public File CVSGenerator(String Ar, int csv){
        BufferedWriter output = null;
        File fil = null;
        switch (csv) {
            case 1:
                fil = new File("src/main/resources/Data/ArrangmentCSV.txt");
                break;
            case 2:
                fil = new File("src/main/resources/Data/TiderCSV.txt");
                break;
            case 3:
                fil = new File("src/main/resources/Data/Brukere.txt");
                break;
        }

        try {
            if (!fil.exists()) {
                fil.createNewFile();
            }
            FileWriter fs = new FileWriter(fil,true);
            output = new BufferedWriter(fs);
            output.write(Ar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(output!=null)
                    output.close();
            }catch(Exception ex){
                System.out.println("Kunne ikke skrive til fil"+ex);
            }
        }

        return fil;
    }
    private void copyDB() throws IOException {
        String source = "src/main/resources/Data/arrangementer.db";
        String dest = "src/main/resources/Data/arrangementerTest.db";
        File file = new File(dest);
        if(file.exists() && file.isFile()){
            file.delete();
        }
        Files.copy(Paths.get(source), Paths.get(dest));
    }
}