package data;

import Model.BrukerType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class InnloggetBruker {

    private BrukerType innloggetBruker;

    public InnloggetBruker(BrukerType innloggetBruker) {
        this.innloggetBruker = innloggetBruker;
    }

    public BrukerType getInnloggetBruker() {
        return innloggetBruker;
    }

    public void setInnloggetBruker(BrukerType innloggetBruker) {
        this.innloggetBruker = innloggetBruker;
    }
}
