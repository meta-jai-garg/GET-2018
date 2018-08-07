package animal;

public class Mammal extends Animal {
    private final boolean hasFur;

    /**
     * @param name       of Mammal
     * @param weight     of Mammal
     * @param age        of Mammal
     * @param sound      of Mammal
     * @param noOfLegs   of Mammal
     * @param category   of Mammal
     * @param animalType of Mammal
     * @param hasFur     of Mammal
     */
    public Mammal(String name, double weight, int age, String sound, int noOfLegs, AnimalFamily category, AnimalName animalType, boolean hasFur) {
        super(name, weight, age, sound, noOfLegs, category, animalType);
        this.hasFur = hasFur;
    }

}
