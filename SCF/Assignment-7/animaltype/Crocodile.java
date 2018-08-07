package animaltype;

import animal.AnimalFamily;
import animal.AnimalName;
import animal.Reptile;

public class Crocodile extends Reptile {

    static int id = 1;

    /**
     * @param weight of crocodile
     * @param age    of crocodile
     */
    public Crocodile(double weight, int age) {
        super("Crocodile " + (id++), weight, age, "Roars", 4, AnimalFamily.REPTILE, AnimalName.CROCODILE, false, "warm");
    }
}
