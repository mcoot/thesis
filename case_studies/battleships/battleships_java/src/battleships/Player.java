package battleships;

import java.util.LinkedList;
import java.util.List;

public class Player {

    private Board board;

    private final List<Coordinate> opponentQueries;

    private Coordinate nextQuery = null;

    public Player() {
        opponentQueries = new LinkedList<>();
    }

    /**
     * Generate an initial board covering numCovered coordinates
     */
    Board init(int numCovered) {
        // Default 'strategy'
        final Ship[] myCunningStrategy = {
                new Ship(new Coordinate(1, 1), 1, true),
                new Ship(new Coordinate(1, 3), 2, false),
                new Ship(new Coordinate(2, 2), 3, true),
                new Ship(new Coordinate(3, 4), 4, false),
                new Ship(new Coordinate(5, 6), 5, true),
                new Ship(new Coordinate(5, 7), 6, false),
	    };

        Board board = new Board();

        int i = 0;
        for (int count = numCovered; count > 0 && board != null;) {
            try {
                Ship newPiece = myCunningStrategy[i++];
                if (newPiece != null && newPiece.length > count) {
                    // Ship is too long
                    newPiece = new Ship(newPiece.pos, count, newPiece.isHorizontal);
                }
                board.addShip(newPiece);
                count -= (newPiece == null ? 0 : newPiece.length);
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }

        return board;
    }

    void storeBoard(Board board) {
        this.board = board;
    }

    public Coordinate getNextQuery() {
        // Default query strategy

        Coordinate c = this.nextQuery;
        if (c == null) {
            c = new Coordinate(0, 0);
        }

        // Get the next query
        boolean direction = ((c.x + c.y)%2 == 0);
        int newX = c.x + (direction ? 1 : -1);
        int newY = c.y + (direction ? -1 : 1);
        if (newX < 0) newX = 0;
        if (newY < 0) newY = 0;

        this.nextQuery = new Coordinate(newX, newY);

        return c;
    }

    boolean processQuery(Coordinate query) throws IllegalArgumentException {
        Board brd = this.board;
        List<Coordinate> oppQueries = this.opponentQueries;

        if (brd == null || oppQueries == null || query == null) {
            throw new IllegalArgumentException("Bad state or args");
        }

        if (oppQueries.contains(query)) {
            throw new IllegalArgumentException("Opponent already asked the query " + query.toString());
        }

        oppQueries.add(query);

        // Give a result
        boolean result = brd.testPosition(query);

        return result;
    }

}
