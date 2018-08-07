package cage;

import animal.Animal;
import animal.AnimalName;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private AnimalName animalType;
    private int capacity;
    List<Animal> listOfAnimals = new ArrayList<Animal>();

    /**
     * @param animalType
     * @param capacity
     */
    public Cage(AnimalName animalType, int capacity) {
        this.animalType = animalType;
        this.capacity = capacity;
    }

    public AnimalName getAnimalType() {
        return animalType;
    }

    public void addAnimal(Animal animal) {
        listOfAnimals.add(animal);
    }

    public boolean removeAnimal() {
        boolean removed = false;
        if (listOfAnimals.size() > 0) {
            listOfAnimals.remove(0);
            removed = true;
        }
        return removed;
    }

    public int spareCapacity() {
        return capacity - listOfAnimals.size();
    }

}
