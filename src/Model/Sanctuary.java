package Model;

import enums.MonkeySpecies;
import Model.Enclosures;
import Model.Isolation;
import Model.Monkey;

import java.util.*;

import static enums.MonkeySpecies.*;

/**
 * The Sanctuary provides a permanent home and high-quality sanctuary care for
 * New World primates who have been cast-off from
 * the pet trade, retired from research, or confiscated by authorities
 *
 * it has room for twenty monkeys in isolation (cages)
 * and eight enclosure spaces (one for each species of monkeys).
 *
 */
public class Sanctuary {
    private final int ISOLATION_BOUND = 20;
    private Isolation isolation;
    private Map<MonkeySpecies, Enclosures> enclosures;
    private List<Monkey> allMonkeyList;

    /**
     * Constructor
     * initialize isolationList, enclosuresList, and allMonkeyList
     * for enclosures, creat 8 empty enclosures for this sanctuary
     */
    public Sanctuary() {
        isolation = new Isolation();
        // initialize enclosuresList by adding 8 different species
        enclosures = new HashMap<>();
        enclosures.put(DRILL, new Enclosures(DRILL));
        enclosures.put(GUEREZA, new Enclosures(GUEREZA));
        enclosures.put(HOWLER, new Enclosures(HOWLER));
        enclosures.put(MANGABEY, new Enclosures(MANGABEY));
        enclosures.put(SAKI, new Enclosures(SAKI));
        enclosures.put(SPIDER, new Enclosures(SPIDER));
        enclosures.put(SQUIRREL, new Enclosures(SQUIRREL));
        enclosures.put(TAMARIN, new Enclosures(TAMARIN));
        allMonkeyList = new ArrayList<>();
    }

    /**
     * add new monkey to isolation
     * @param cur : the target monkey
     */
    public void addMonkeyToIsolation(Monkey cur) {
        List<Monkey> isolationList = isolation.getCageList();
        // check space in isolation
        if (isolationList.size() >= ISOLATION_BOUND) {
            throw new IllegalStateException("The isolation area is full, can not add new Monkeys!");
        }
        // add current monkey to isolation
        isolationList.add(cur);
        isolation.setCageList(isolationList);
        // update allMonkeyList, maintain the list in alphabetical order
        allMonkeyList.add(cur);
        // keep the allMonkeyList always sorted in alphabetical order
        Collections.sort(allMonkeyList, new Comparator<Monkey>() {
            @Override
            public int compare(Monkey o1, Monkey o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    /**
     * move the target monkey from the isolation area to enclosure
     * @param cur : the target monkey
     */
    public void moveMonkeyFromIsolationToEnclosure(Monkey cur) {
        // remove the current monkey form isolation
        if (cur.getHealthy() == false) {
            throw new IllegalStateException("This monkey hasn't received medical attention, can not move to Enclosure.");
        }
        List<Monkey> isolationList = isolation.getCageList();
        if (!isolationList.contains(cur)) {
            throw new IllegalStateException("This Monkey is not in the Isolation area, please check again.");
        }
        isolationList.remove(cur);
        isolation.setCageList(isolationList);
        // add current monkey to the enclosure
        enclosures.get(cur.getSpecies()).addMonkey(cur);
    }

    /**
     * return a list for a given enclosure
     * for each monkey, the string should include required information: name, sex, favorite food
     *
     * @param cur: the target monkey
     * @return list of strings, represents all required information(name, sex, favorite food) of monkeys
     */
    public List<String> generateListForEnclosure(MonkeySpecies cur) {
        return enclosures.get(cur).generateMonkeyList();
    }

    /**
     * return a list of monkey, represents all monkeys currently host in this sanctuary
     * the list is sorted in alphabetical order
     * @return a list of monkey, represents all monkeys currently host in this sanctuary
     */
    public List<Monkey> getAllMonkeyList() {
        return allMonkeyList;
    }

}