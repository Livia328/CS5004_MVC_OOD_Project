package Model;

import enums.MonkeySpecies;

import java.util.ArrayList;
import java.util.List;

/**
 An enclosure that can host a single troop of monkeys.

 Each troop consists of a single species that is found in the New World.

 Each enclosure is configured to house a particular species of monkeys.

 This class allows for adding monkeys to the enclosure and generating a list of all monkeys currently housed there.
 */
public class Enclosures {
    private MonkeySpecies speciesToHost;
    private List<Monkey> enclosureList;

    /**
     * Constructor for Model.Enclosures class
     * this constructor will new the enclosureList to track all monkeys in this enclosures
     * @param speciesToHost : species this enclosure host
     */
    public Enclosures(MonkeySpecies speciesToHost) {
        this.speciesToHost = speciesToHost;
        enclosureList = new ArrayList<>();
    }

    /**
     Adds a monkey to the enclosure.
     @param cur: the monkey to add to the enclosure
     */
    public void addMonkey(Monkey cur) {
        enclosureList.add(cur);
    }

    /**
     Generates a list of all monkeys currently housed in the enclosure.
     @return a list of strings, each representing an individual monkey and their information
            in the format like: "Monkey1: name sex favorite_food
     */
    public List<String> generateMonkeyList() {
        List<String> info = new ArrayList<>();
        for (int i = 0; i < enclosureList.size(); i++) {
            info.add("Monkey" + i + ": " + enclosureList.get(i).generateInfo());
        }
        return info;
    }

    /**
     Returns the species of monkey that this enclosure is configured to house.
     @return the species of monkey that this enclosure is configured to house
     */
    public MonkeySpecies getSpeciesToHost() {
        return speciesToHost;
    }

    /**
     Returns a list of all monkeys currently housed in the enclosure.
     @return a list of all monkeys currently housed in the enclosure
     */
    public List<Monkey> getEnclosureList() {
        return enclosureList;
    }

}
