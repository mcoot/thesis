package battleships;

import java.io.PrintStream;

public class BattleShip {

    public static final int NUM_COVERED_COORDS = 10;

    public void play(PrintStream output) throws IllegalArgumentException {
        if (output == null) throw new IllegalArgumentException("Null output");

        output.println("Playing battleships, with each player having " + NUM_COVERED_COORDS + " covered coordinates");

        Player player1 = new Player();
        Player player2 = new Player();

        output.print("  Initializing...");

        Board proposed1 = player1.init(NUM_COVERED_COORDS);
        Board accepted1 = player2.endorseBoard(proposed1);
        player1.storeBoard(accepted1);

        Board proposed2 = player2.init(NUM_COVERED_COORDS);
        Board accepted2 = player1.endorseBoard(proposed2);
        player2.storeBoard(accepted2);

        output.println(" Done.");

        int player1Hits = 0;
        int player2Hits = 0;

        output.println("  Playing rounds...");

        // Loop until a player hits all covered coordinates
        while (player1Hits < NUM_COVERED_COORDS && player2Hits < NUM_COVERED_COORDS) {

            // Player 1 queries
            Coordinate play1Query = player1.getNextQuery();
            Coordinate play1QueryEnd = player2.endorseQuery(play1Query);

            output.print("\t Alice: " + (play1QueryEnd == null ? "null" : play1QueryEnd.toString()) + "?  ");

            boolean result = player2.processQuery(play1QueryEnd);
            player1Hits += result ? 1 : 0;
            output.print(result ? "Y" : "N");

            // If player 1 did not win the game with that query, player 2 now queries
            if (player1Hits < NUM_COVERED_COORDS) {
                Coordinate play2Query = player2.getNextQuery();
                Coordinate play2QueryEnd = player1.endorseQuery(play2Query);

                output.print("   Bob: " + (play2QueryEnd == null ? "null" : play2QueryEnd.toString()) + "?  ");

                boolean result2 = player1.processQuery(play2QueryEnd);

                player2Hits += result2 ? 1 : 0;
                output.print(result2 ? "Y" : "N");

                // Print a running total of the scores
                output.println("   Score: " + player1Hits + " vs. " + player2Hits);
            }
        }

        // Print out winner
        output.println("\n");
        output.println((player1Hits >= NUM_COVERED_COORDS ? "Alice" : "Bob") + " won!");
    }

}
