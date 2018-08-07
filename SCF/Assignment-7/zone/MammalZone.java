package zone;

import animal.AnimalFamily;

public class MammalZone extends Zone {

    /**
     * @param capacity
     * @param hasPark
     * @param hasCanteen
     */
    public MammalZone(int capacity, boolean hasPark, boolean hasCanteen) {
        super(AnimalFamily.MAMMAL, capacity, hasPark, hasCanteen);
    }

}
