package Model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EnclosuresTest {
    private Enclosures enclosures;
    @Before
    public void setUp() {
        enclosures = new Enclosures(enums.MonkeySpecies.SQUIRREL);
    }
    @Test
    public void addMonkey() {
        Monkey monkey = new Monkey(1, "Tom", enums.MonkeySpecies.DRILL, enums.Sex.MALE, 1.0, 1.0, 5, enums.FavouriteFood.EGGS);
        enclosures.addMonkey(monkey);
        assertEquals(enclosures.getEnclosureList().size(), 1);
        assertTrue(enclosures.getEnclosureList().contains(monkey));
    }

    @Test
    public void generateMonkeyList() {
        Monkey monkey = new Monkey(1,"Tom", enums.MonkeySpecies.DRILL, enums.Sex.MALE, 1.0, 1.0, 5, enums.FavouriteFood.EGGS);
        enclosures.addMonkey(monkey);
        List<String> monkeyList = enclosures.generateMonkeyList();
        assertTrue(monkeyList.contains("Monkey0: Tom MALE EGGS"));
    }

}