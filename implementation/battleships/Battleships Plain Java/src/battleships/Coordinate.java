package battleships;

public class Coordinate {

	// The x coordinate
	public final int x;

	// THe y coordinate
	public final int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	} 

	public int hashCode() {
		return (13 * x) ^ (-23 * y);
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof Coordinate)) return false;

		Coordinate other = (Coordinate)o;
		return this.x == other.x && this.y == other.y;
	}

}