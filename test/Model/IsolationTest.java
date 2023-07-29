package Model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IsolationTest {
    private Isolation isolation;

    @Before
    public void setUp() {
        isolation = new Isolation();
    }

    @Test
    public void getCageList() {
        List<Monkey> expectedCageList = new ArrayList<>();
        assertEquals(expectedCageList, isolation.getCageList());
    }

    @Test
    public void setCageList() {
        List<Monkey> newCageList = new ArrayList<>();
        Monkey monkey1 = new Monkey(1, "Tom", enums.MonkeySpecies.DRILL, enums.Sex.MALE, 1.0, 1.0, 5, enums.FavouriteFood.EGGS);
        Monkey monkey2 = new Monkey(2, "Lily", enums.MonkeySpecies.GUEREZA, enums.Sex.FEMALE, 1.0, 2.0, 3, enums.FavouriteFood.INSECTS);
        newCageList.add(monkey1);
        newCageList.add(monkey2);
        isolation.setCageList(newCageList);
        assertEquals(newCageList, isolation.getCageList());
    }
}