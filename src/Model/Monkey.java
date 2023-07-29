package Model;

import enums.FavouriteFood;
import enums.MonkeySpecies;
import enums.Sex;

/**
 * Monkeys class represent monkey that are received by the sanctuary
 *
 * each individual monkey is given a name, a species designation, a sex, a size, a weight, an approximate age,
 * and a favorite food. The choices of favorite food include eggs, fruits, insects, leaves, nuts, seeds, and tree sap.
 *
 * Monkeys that have received medical attention may be moved to an enclosure.
 */
public class Monkey {
    private int id;
    private String name;
    private MonkeySpecies species;
    private Sex sex;
    private double size;
    private double weight;
    private int age;
    private FavouriteFood favouriteFood;
    private boolean healthy;

    /**
     * Constructor of monkey class
     * it assign the healthy as false when the monkey generate for the first time
     * @param name : the name of monkey
     * @param species : the species include drill, guereza, howler, mangabey, saki, spider, squirrel, and tamarin.
     * @param sex : the sex of monkey
     * @param size : size, double type
     * @param weight : wight, double type
     * @param age : age, double type
     * @param favouriteFood : favorite food include eggs, fruits, insects, leaves, nuts, seeds, and tree sap
     */
    public Monkey(int id, String name, MonkeySpecies species, Sex sex, double size, double weight, int age, FavouriteFood favouriteFood) {
        if (id < 0) {
            throw new IllegalStateException("The input \'ID\' can not be negtive.");
        }
        if (size < 0) {
            throw new IllegalStateException("The input \'SIZE\' can not be negtive.");
        }
        if (weight < 0) {
            throw new IllegalStateException("The input \'WEIGHT\'can not be negtive.");
        }
        if (age < 0) {
            throw new IllegalStateException("The input \'AGE\'can not be negtive.");
        }
        this.id = id;
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.favouriteFood = favouriteFood;
        this.healthy = false;
    }


    /**
     * generate required infomation(name, sex, and favorite food) for this monkey
     * @return a string in the format of "name sex favorite_food"
     */
    public String generateInfo() {
        return this.name + " " + sex + " " + favouriteFood;
    }

    public int getId() {
        return id;
    }

    /**
     * get method for name
     * @return the monkey's name
     */
    public String getName() {
        return name;
    }

    /**
     * get method for species
     * @return the monkey's species
     */
    public MonkeySpecies getSpecies() {
        return species;
    }

    /**
     Returns the sex of the monkey.
     @return the sex of the monkey
     */
    public Sex getSex() {
        return sex;
    }

    /**
     Returns the size of the monkey.
     @return the size of the monkey
     */
    public double getSize() {
        return size;
    }

    /**
     Returns the weight of the monkey.
     @return the weight of the monkey
     */
    public double getWeight() {
        return weight;
    }

    /**
     Returns the age of the monkey.
     @return the age of the monkey
     */
    public int getAge() {
        return age;
    }

    /**
     Returns the favourite food of the monkey.
     @return the favourite food of the monkey
     */
    public FavouriteFood getFavouriteFood() {
        return favouriteFood;
    }

    /**
     Returns whether the monkey is healthy
     @return true if the monkey is healthy, false otherwise
     */
    public boolean getHealthy() {
        return healthy;
    }

    /**
     Sets the name of the monkey.
     @param name the new name of the monkey
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     Sets the size of the monkey.
     @param size the new size of the monkey
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     Sets the weight of the monkey.
     @param weight the new weight of the monkey
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     Sets the age of the monkey.
     @param age the new age of the monkey
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     Sets the favourite food of the monkey.
     @param favouriteFood the new favourite food of the monkey
     */
    public void setFavouriteFood(FavouriteFood favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    /**
     Sets whether the monkey is healthy.
     */
    public void setHealthy() {
        if (this.healthy == true) {
            throw new IllegalStateException("This monkey has already been vaccinated!");
        }
        healthy = true;
    }


    /**
     Returns a string representation of the monkey object,
     including its name, species, sex, size, weight, age, favourite food, and health status.
     @return a string containing the monkey object's name, species, sex, size, weight, age, favourite food, and health status
     */
    @Override
    public String toString() {
        return "Monkey{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", species=" + species +
                ", sex=" + sex +
                ", size=" + size +
                ", weight=" + weight +
                ", age=" + age +
                ", favouriteFood=" + favouriteFood +
                ", healthy=" + healthy +
                '}';
    }
}
