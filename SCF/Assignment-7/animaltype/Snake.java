package animaltype;

import animal.AnimalFamily;
import animal.AnimalName;
import animal.Reptile;

public class Snake extends Reptile {

    static int id = 1;

    /**
     * @param weight of Snake
     * @param age    of Snake
     */
    public Snake(double weight, int age) {
        super("Snake " + (id++), weight, age, "hiss", 0, AnimalFamily.REPTILE, AnimalName.SNAKE, true, "cold");
    }

}
