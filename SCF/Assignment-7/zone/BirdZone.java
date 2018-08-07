package zone;

import animal.AnimalFamily;

public class BirdZone extends Zone {

    /**
     * @param capacity
     * @param hasPark
     * @param hasCanteen
     */
    public BirdZone(int capacity, boolean hasPark, boolean hasCanteen) {
        super(AnimalFamily.BIRD, capacity, hasPark, hasCanteen);
    }

}
