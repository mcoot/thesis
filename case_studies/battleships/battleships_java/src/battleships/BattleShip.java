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

        Board board1 = player1.init(NUM_COVERED_COORDS);
        player1.storeBoard(board1);

        Board board2 = player2.init(NUM_COVERED_COORDS);
        player2.storeBoard(board2);

        output.println(" Done.");

        int player1Hits = 0;
        int player2Hits = 0;

        output.println("  Playing rounds...");

        // Loop until a player hits all covered coordinates
        while (player1Hits < NUM_COVERED_COORDS && player2Hits < NUM_COVERED_COORDS) {

            // Player 1 queries
            Coordinate play1Query = player1.getNextQuery();

            output.print("\t Alice: " + (play1Query == null ? "null" : play1Query.toString()) + "?  ");

            boolean result = player2.processQuery(play1Query);
            player1Hits += result ? 1 : 0;
            output.print(result ? "Y" : "N");

            // If player 1 did not win the game with that query, player 2 now queries
            if (player1Hits < NUM_COVERED_COORDS) {
                Coordinate play2Query = player2.getNextQuery();

                output.print("   Bob: " + (play2Query == null ? "null" : play2Query.toString()) + "?  ");

                boolean result2 = player1.processQuery(play2Query);

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
