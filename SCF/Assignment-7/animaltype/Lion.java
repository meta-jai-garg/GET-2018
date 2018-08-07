package animaltype;

import animal.AnimalFamily;
import animal.AnimalName;
import animal.Mammal;

public class Lion extends Mammal {

    static int id = 1;

    /**
     * @param weight of Lion
     * @param age    of Lion
     */
    public Lion(double weight, int age) {
        super("Lion " + (id++), weight, age, "Roar", 4, AnimalFamily.MAMMAL, AnimalName.LION, false);
    }
}
