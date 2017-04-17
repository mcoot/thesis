package battleships;

import java.io.PrintStream;

public class BattleShip {

	// The number of covered coordinates each player must have on their board
	public static final int NUM_COVERED_COORDS = 10;

	public void play(PrintStream output) throws IllegalArgumentException {
		if (output == null) throw new IllegalArgumentException("Null output");

		output.println("Playing battleships, with each player having " + NUM_COVERED_COORDS + " covered coordinates");

		// Instantiate the players
		Player player1 = new Player();
		Player player2 = new Player();

		// Initialise the players
		output.print("  Initializing....");

		// Player 1 must propose their board, and it must be endorsed by player 2
		Board proposed1 = player1.init(NUM_COVERED_COORDS);
		Board accepted1 = player2.endorseBoard(proposed1);
		player1.storeBoard(accepted1);

		Board proposed2 = player2.init(NUM_COVERED_COORDS);
		Board accepted2 = player1.endorseBoard(proposed2);
		player2.storeBoard(accepted2);


		output.println(" Done.");

		// How many hits each player has scored
		int player1Hits = 0;
		int player2Hits = 0;

		// Loop until a player hits all the covered coordinates
		while (player1Hits < NUM_COVERED_COORDS && player2Hits < NUM_COVERED_COORDS) {
			// Player 1 queries first
			Coordinate play1Query = player1.getNextQuery();
			Coordinate play1QueryAccepted = player2.endorseQuery(play1Query);

			output.print("   Alice:" + (play1QueryAccepted == null ? "null" : play1QueryAccepted.toString()) + "?  ");

			// Player 2 processes player 1's query
			boolean result = player2.processQuery(play1QueryAccepted);
			player1Hits += result ? 1 : 0;
			output.print(result ? "Y" : "N");

			if (player1Hits < NUM_COVERED_COORDS) {
				// Player 1 hasn't won, so player 2 gets to query
				Coordinate play2Query = player2.getNextQuery();
				Coordinate play2QueryAccepted = player1.endorseQuery(play2Query);

				output.print("   Bob:" + (play2QueryAccepted == null ? "null" : play2QueryAccepted.toString()) + "?  ");

				// Player 1 processes player 2's query
				result = player1.processQuery(play2QueryAccepted);
				player2Hits += result ? 1 : 0;
				output.print(result ? "Y" : "N");

				output.println("   Score:" + player1Hits + " vs. " + player2Hits);
			}
		}

		// Determine the winner
		output.println("\n");
		output.println((player1Hits >= NUM_COVERED_COORDS ? "Alice" : "Bob") + " won!");
	}
}