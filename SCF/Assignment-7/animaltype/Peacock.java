package animaltype;

import animal.AnimalFamily;
import animal.AnimalName;
import animal.Bird;

public class Peacock extends Bird {

    static int id = 1;

    /**
     * @param weight of Peacock
     * @param age    of  Peacock
     */
    public Peacock(double weight, int age, double wingspan) {
        super("Peacock " + (id++), weight, age, "scream", 2, AnimalFamily.BIRD, AnimalName.PEACOCK, true, wingspan);
    }
}
