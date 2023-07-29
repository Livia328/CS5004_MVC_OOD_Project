package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model.Isolation is used to keep monkeys when they first arrive at the sanctuary
 * and anytime they are receiving medical attention.
 * Model.Isolation consists of a series of cages each of which can house a single animal.
 */
public class Isolation {
    private List<Monkey> cageList;

    /**
     * Contractor of Model.Isolation class
     * Initializes an empty list of cages.
     */
    public Isolation() {
        cageList = new ArrayList<>();
    }

    /**
     * Gets the list of cages in the isolation.
     * @return the list of cages
     */
    public List<Monkey> getCageList() {
        return cageList;
    }

    /**
     Sets the list of cages in the isolation.
     @param cageList the list of cages to set
     */
    public void setCageList(List<Monkey> cageList) {
        this.cageList = cageList;
    }
}
