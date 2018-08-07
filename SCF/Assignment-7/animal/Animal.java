package animal;

public class Animal {
    private final String name;
    private double weight;
    private int age;
    private final String sound;
    private final int noOfLegs;
    private AnimalFamily category;
    private AnimalName animalType;

    /**
     * class constructor
     *
     * @param name       of animal
     * @param weight     of animal
     * @param age        of animal
     * @param sound      of animal
     * @param noOfLegs   of animal
     * @param category   of animal
     * @param animalType of animal
     */
    public Animal(String name, double weight, int age, String sound, int noOfLegs, AnimalFamily category, AnimalName animalType) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.sound = sound;
        this.noOfLegs = noOfLegs;
        this.category = category;
        this.animalType = animalType;
    }

    public AnimalName getAnimalType() {
        return animalType;
    }

    public AnimalFamily getCategory() {
        return category;
    }
}
