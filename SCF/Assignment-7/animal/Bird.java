package animal;

public class Bird extends Animal {
    private final boolean canFly;
    private double wingspan;

    /**
     * @param name       of bird
     * @param weight     of bird
     * @param age        of bird
     * @param sound      of bird
     * @param noOfLegs   of bird
     * @param category   of bird
     * @param animalType of bird
     * @param canFly     of bird
     * @param wingspan   of bird
     */
    public Bird(String name, double weight, int age, String sound, int noOfLegs, AnimalFamily category, AnimalName animalType, boolean canFly, double wingspan) {
        super(name, weight, age, sound, noOfLegs, category, animalType);
        this.canFly = canFly;
        this.wingspan = wingspan;
    }
}
