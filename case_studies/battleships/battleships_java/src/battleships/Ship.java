package battleships;

/**
 * Represents a ship in the game
 *
 * Has a coordinate representing its bottom-left point, and a flag for whether it is horizontal or vertical
 */
public class Ship {

    final Coordinate pos;

    final int length;

    final boolean isHorizontal;

    public Ship(Coordinate pos, int len, boolean isHoriz) {
        this.pos = pos;
        this.length = len;
        this.isHorizontal = isHoriz;
    }

    /**
     * Checks whether the ship covers the coordinate
     */
    public boolean covers(Coordinate coord) {
        Coordinate pos = this.pos;

        if (coord == null || pos == null) return false;

        if (isHorizontal) {
            return coord.y == pos.y &&
                    pos.x <= coord.x &&
                    coord.x < pos.x + length;
        } else {
            return coord.x == pos.x &&
                    pos.y <= coord.y &&
                    coord.y < pos.y + length;
        }
    }

    /**
     * Checks whether this ship intersects another
     */
    public boolean intersects(Ship ship) {
        if (ship == null) return false;

        Coordinate c = this.pos;

        for (int i = 0; i < length && c != null; i++) {
            if (ship.covers(c)) return true;

            if (isHorizontal) {
                c = new Coordinate(c.x + 1, c.y);
            } else {
                c = new Coordinate(c.x, c.y + 1);
            }
        }

        return false;
    }

    public String toString() {
        Coordinate pos = this.pos;
        Coordinate end = null;

        if (pos == null) pos = new Coordinate(0, 0);

        if (isHorizontal) {
            end = new Coordinate(pos.x + length, pos.y);
        } else {
            end = new Coordinate(pos.x, pos.y + length);
        }

        return pos.toString() + " to " + end.toString();
    }

    public int hashCode() {
        Coordinate pos = this.pos;

        if (pos == null) pos = new Coordinate(0, 0);

        return pos.hashCode() ^ (4007 * length) ^ (isHorizontal ? 1861 : 2713);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Ship)) return false;

        Ship that = (Ship)o;

        Coordinate thispos = this.pos;
        Coordinate thatpos = that.pos;

        return this.length == that.length &&
                this.isHorizontal == that.isHorizontal &&
                (thispos == thatpos ||
                    thispos != null && thispos.equals(thatpos));
    }
}
