package data;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataHandlerDBtoCSVTest {
    private List<String> listArrangement;
    private List<String> listTider;
    private List<String> listBrukere;

    @BeforeEach
    public void setUp() {
        System.out.println("Fyller opp List arrayen");
        listArrangement = new ArrayList<>(Arrays.asList("test1","test2"));
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Liste er fylt");
    }
}