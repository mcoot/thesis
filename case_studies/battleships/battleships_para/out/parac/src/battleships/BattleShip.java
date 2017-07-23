package battleships;
import java.io.PrintStream;
public class BattleShip
{
  public static final se.chalmers.paragon.runtime.Policy bottom = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {java.lang.Object.class}, new se.chalmers.paragon.runtime.Variable(0)));
  public static final int NUM_COVERED_COORDS = 10;
  public BattleShip ()
  {
  }
  public void play(java.io.PrintStream output) throws java.lang.IllegalArgumentException
  {
    if (output == null)
    throw new java.lang.IllegalArgumentException("Null output");
    output.println("Playing battleships, with each player having " + NUM_COVERED_COORDS + " covered coordinates");
    battleships.Player player1 = new battleships.Player();
    battleships.Player player2 = new battleships.Player();
    output.print("  Initializing...");
    player1.init(NUM_COVERED_COORDS);
    player2.init(NUM_COVERED_COORDS);
    output.println(" Done.");
    int player1Hits = 0;
    int player2Hits = 0;
    output.println("  Playing rounds...");
    while (player1Hits < NUM_COVERED_COORDS && player2Hits < NUM_COVERED_COORDS) {
                                                                                   battleships.Coordinate play1Query = player1.getNextQuery();
                                                                                   output.print("\t Alice: " + (play1Query == null ? "null" : play1Query.toString()) + "?  ");
                                                                                   boolean result = player2.processQuery(play1Query);
                                                                                   player1Hits += result ? 1 : 0;
                                                                                   output.print(result ? "Y" : "N");
                                                                                   if (player1Hits < NUM_COVERED_COORDS)
                                                                                   {
                                                                                     battleships.Coordinate play2Query = player2.getNextQuery();
                                                                                     output.print("   Bob: " + (play2Query == null ? "null" : play2Query.toString()) + "?  ");
                                                                                     boolean result2 = player1.processQuery(play2Query);
                                                                                     player2Hits += result2 ? 1 : 0;
                                                                                     output.print(result2 ? "Y" : "N");
                                                                                     output.println("   Score: " + player1Hits + " vs. " + player2Hits);
                                                                                   }
                                                                                 }
    output.println("\n");
    output.println((player1Hits >= NUM_COVERED_COORDS ? "Alice" : "Bob") + " won!");
  }
}