package data;

import Model.Arrangement;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

class DataHandlerDBtoCSVTest {
    private static List<Arrangement> listArrangement;
    private List<String> listTider;
    private List<String> listBrukere;
    private int ArrangmenterCSVSize = 7;

    DataHandlerDBtoCSV test = new DataHandlerDBtoCSV();

    @Test
    void arrangementerTilCSV() throws IOException, SQLException {
    }

    @Test
    void CVSGenerator() {
        String testTxt = "test";
        File ArrangementCSV = test.CVSGenerator(testTxt,1);
        File TiderCSV = test.CVSGenerator(testTxt,2);
        File Brukere = test.CVSGenerator(testTxt,3);
        Assert.assertEquals("ArrangmentCSV.csv",ArrangementCSV.getName());
        Assert.assertEquals("TiderCSV.csv",TiderCSV.getName());
        Assert.assertEquals("Brukere.csv",Brukere.getName());
    }
}