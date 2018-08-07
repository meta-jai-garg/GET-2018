package animaltype;

import animal.AnimalFamily;
import animal.AnimalName;
import animal.Mammal;

public class Elephant extends Mammal {

    static int id = 1;

    /**
     * @param weight of Elephant
     * @param age    of Elephant
     */
    public Elephant(double weight, int age) {
        super("Elephant " + (id++), weight, age, "Trumpet", 4, AnimalFamily.MAMMAL, AnimalName.ELEPHANT, false);
    }

}
