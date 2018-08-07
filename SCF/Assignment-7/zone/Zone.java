package zone;

import animal.Animal;
import animal.AnimalFamily;
import animal.AnimalName;
import cage.Cage;

import java.util.ArrayList;
import java.util.List;

public class Zone {
    private AnimalFamily zoneType;
    private final int capacity;
    private List<Cage> listOfCages = new ArrayList<Cage>();
    private boolean hasPark, hasCanteen;

    /**
     * @param zoneType   is type of zone
     * @param capacity   of zone
     * @param hasPark    in zone
     * @param hasCanteen in zone
     */
    public Zone(AnimalFamily zoneType, int capacity, boolean hasPark,
                boolean hasCanteen) {
        this.zoneType = zoneType;
        this.capacity = capacity;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
    }

    public AnimalFamily getZoneType() {
        return zoneType;
    }

    public int spareCapacity() {
        return capacity - listOfCages.size();
    }

    public void addCage(Cage cage) {
        if (spareCapacity() != 0) {
            listOfCages.add(cage);
        } else {
            throw new AssertionError("zone.Zone is full");
        }
    }

    public boolean addAnimal(Animal animal) {
        boolean flag = false;
        for (Cage cage : listOfCages) {
            if (cage.getAnimalType().equals(animal.getAnimalType())
                    && cage.spareCapacity() != 0) {
                flag = true;
                cage.addAnimal(animal);
                break;
            }
        }
        if (!flag) {
            throw new AssertionError("zone.Zone capacity is full");
        }
        return flag;
    }

    public boolean removeAnimal(AnimalName animalName) {
        boolean removed = false;
        for (Cage cage : listOfCages) {
            if (cage.getAnimalType().equals(animalName)) {
                removed = cage.removeAnimal();
            }
        }
        return removed;
    }
}
