package battleships;

import java.util.List;
import java.util.LinkedList;

public class Board {
	private final List<Ship> ships;

	public Board() {
		ships = new LinkedList<Ship>();
	}

	/**
	* @throws IllegalArgumentException if the ship to add is null or intersects an existing one
	*
	*/
	public void addShip(Ship s) throws IllegalArgumentException {
		if (s == null) throw new IllegalArgumentException("Cannot add null ship");

		for (Ship t : ships) {
			if (s.intersects(t)) throw new IllegalArgumentException("Ship to add intersects and existing ship");
		}

		ships.add(s);
	}

	public boolean testPosition(Coordinate coord) {
		for (Ship s : ships) {
			if (s.covers(coord)) return true;
		}
		return false;
	}

	/**
	 * Returns a copy of the board (no real point without Jif's endorsement/declassification mechanism)
	 *
	 */
	public Board endorseBoard() {
		Board newBoard = new Board();

		for (Ship s : ships) {
			newBoard.addShip(s);
		}

		return newBoard;
	}
}