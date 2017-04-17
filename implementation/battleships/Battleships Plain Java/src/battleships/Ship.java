package battleships;

public class Ship {

	// The bottom left position of the ship
	final Coordinate pos;
	// The length of the ship
	final int length;
	// Whether the ship is horizontal or vertical
	final boolean isHorizontal;

	public Ship(Coordinate pos, int len, boolean isHoriz) {
		this.pos = pos;
		this.length = len;
		this.isHorizontal = isHoriz;
	}

	public boolean covers(Coordinate coord) {
		if (coord == null || pos == null) return false;

		if (isHorizontal) {
			// If horizontal, ship extends to the right of its pos
			return coord.y == pos.y && pos.x <= coord.x && coord.x < pos.x + length;
		} else {
			// If vertical, ship extends up above its pos
			return coord.x == pos.x && pos.y <= coord.y && coord.y < pos.y + length;
		}
	}

	public boolean intersects(Ship ship) {
		if (ship == null) return false;

		Coordinate c = this.pos;

		for (int i = 0; i < length && c != null; ++i) {
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
		Coordinate end = null;

		if (isHorizontal) {
			end = new Coordinate(pos.x + length, pos.y);
		} else {
			end = new Coordinate(pos.x, pos.y + length);
		}

		return pos.toString() + " to " + end.toString();
	}

	public int hashCode() {
		return pos.hashCode() ^ (4007 * length) ^ (isHorizontal ? 1861 : 2713);
	}

	public boolean equals(Object o) {
		if (o == null || !(o instanceof Ship)) return false;

		Ship other = (Ship)o;

		return length == other.length && isHorizontal == other.isHorizontal
			&& pos.equals(other.pos);
	}

}