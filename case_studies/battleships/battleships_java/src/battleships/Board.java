package battleships;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Board {

    private final List<Ship> ships;

    public Board() {
        ships = new LinkedList<>();
    }

    public void addShip(Ship s) throws IllegalArgumentException {
        List<Ship> shps = this.ships;

        if (s != null) {
            // Check this doesn't intersect an existing ship
            for (int i = 0; i < shps.size(); i++) {
                Ship t = shps.get(i);
                if (s.intersects(t)) throw new IllegalArgumentException("Ship to add " +
                        "intersects an existing ship");
            }
            shps.add(s);
        }
    }

    public boolean testPosition(Coordinate coord) {
        List<Ship> shps = this.ships;

        if (shps != null) {
            for (int i = 0; i < shps.size(); i++) {
                Ship s = shps.get(i);
                if (s != null && s.covers(coord)) return true;
            }
        }

        return false;
    }

}
