package Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonkeyTest {

    @Test
    public void testConstructor() {
        String name = "George";
        enums.MonkeySpecies species = enums.MonkeySpecies.HOWLER;
        enums.Sex sex = enums.Sex.MALE;
        double size = 1.2;
        double weight = 25.3;
        int age = 5;
        enums.FavouriteFood favouriteFood = enums.FavouriteFood.EGGS;

        Monkey monkey = new Monkey(1, name, species, sex, size, weight, age, favouriteFood);

        assertEquals(name, monkey.getName());
        assertEquals(species, monkey.getSpecies());
        assertEquals(sex, monkey.getSex());
        assertEquals(size, monkey.getSize(), 0.001);
        assertEquals(weight, monkey.getWeight(), 0.001);
        assertEquals(age, monkey.getAge());
        assertEquals(favouriteFood, monkey.getFavouriteFood());
        assertFalse(monkey.getHealthy());
    }
    @Test
    public void generateInfo() {
        Monkey monkey = new Monkey(1, "George", enums.MonkeySpecies.DRILL, enums.Sex.MALE, 1.2, 30.0, 5, enums.FavouriteFood.EGGS);
        assertEquals("George MALE EGGS", monkey.generateInfo());
    }

    @Test(expected = IllegalStateException.class)
    public void testConstructorWithNegativeSize() {
        new Monkey(1, "George", enums.MonkeySpecies.DRILL, enums.Sex.MALE, -1.2, 25.3, 5, enums.FavouriteFood.EGGS);
    }
}