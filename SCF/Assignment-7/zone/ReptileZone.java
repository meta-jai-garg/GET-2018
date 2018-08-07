package zone;

import animal.AnimalFamily;

public class ReptileZone extends Zone {

    /**
     * @param capacity
     * @param hasPark
     * @param hasCanteen
     */
    public ReptileZone(int capacity, boolean hasPark, boolean hasCanteen) {
        super(AnimalFamily.REPTILE, capacity, hasPark, hasCanteen);
    }

}
