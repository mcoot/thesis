package battleships;

/**
 * Represents an (x, y) coordinate on a Battleships board
 *
 * x and y should be non-negative; (0, 0) is the lower-left coordinate
 */
public class Coordinate {

    // The ship's bottom-left x position
    public final int x;

    // The ship's bottom-left y position
    public final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "("  + x + "," + y + ")";
    }

    public int hashCode() {
        return (13 * this.x) ^ (-23 * this.y);
    }

    public boolean equals(Object o) {
        if (o == null || !(o instanceof Coordinate)) return false;

        Coordinate that = (Coordinate)o;
        return this.x == that.x && this.y == that.y;
    }

}
