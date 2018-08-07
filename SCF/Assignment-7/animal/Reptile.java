package animal;

public class Reptile extends Animal {
    private final boolean isPoisonous;
    private final String bloodType;

    /**
     * @param name        of Reptile
     * @param weight      of Reptile
     * @param age         of Reptile
     * @param sound       of Reptile
     * @param noOfLegs    of Reptile
     * @param category    of Reptile
     * @param animalType  of Reptile
     * @param isPoisonous whether the reptile is poisonous
     * @param bloodType   of Reptile
     */
    public Reptile(String name, double weight, int age, String sound, int noOfLegs, AnimalFamily category, AnimalName animalType, boolean isPoisonous, String bloodType) {
        super(name, weight, age, sound, noOfLegs, category, animalType);
        this.isPoisonous = isPoisonous;
        this.bloodType = bloodType;
    }

}
