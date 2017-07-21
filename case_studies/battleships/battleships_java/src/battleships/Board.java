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

        for (int i = 0; i < shps.size(); i++) {
            Ship s = shps.get(i);
            if (s != null && s.covers(coord)) return true;
        }

        return false;
    }

    /**
     * Get a copy of this board which is endorsed (i.e. trusted) by the opponent
     */
    public Board endorseBoard() {
        Board newBoard = new Board();

        List<Ship> shps = this.ships;

        for (int i = 0; i < shps.size(); i++) {
            Ship s = shps.get(i);

            Coordinate pos = s.pos;
            if (pos != null) {
                int length = s.length;
                boolean isHoriz = s.isHorizontal;
                Ship t = new Ship(pos, length, isHoriz);
                newBoard.addShip(t);
            }
        }
        return newBoard;
    }

}
