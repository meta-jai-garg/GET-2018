package animaltype;

import animal.AnimalFamily;
import animal.AnimalName;
import animal.Bird;

public class Parrot extends Bird {

    static int id = 1;

    /**
     * @param weight   of Parrot
     * @param age      of Parrot
     * @param wingspan of Parrot
     */
    public Parrot(double weight, int age, double wingspan) {
        super("Parrot " + (id++), weight, age, "squawk", 2, AnimalFamily.BIRD, AnimalName.PARROT, true, wingspan);
    }

}
