package battleships;
import java.util.LinkedList;
public class Player
{
  public final battleships.Player self = (battleships.Player) this;
  static final private se.chalmers.paragon.runtime.LockID allowBoardAccess = new se.chalmers.paragon.runtime.LockID("allowBoardAccess", battleships.Player.class);
  private static final se.chalmers.paragon.runtime.Policy bottom = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {java.lang.Object.class}, new se.chalmers.paragon.runtime.Variable(0)));
  public final se.chalmers.paragon.runtime.Policy boardPolicy = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {}, new se.chalmers.paragon.runtime.Actor(self)), new se.chalmers.paragon.runtime.Clause(new Class<?>[] {java.lang.Object.class}, new se.chalmers.paragon.runtime.Variable(0), new se.chalmers.paragon.runtime.Atom(allowBoardAccess, new se.chalmers.paragon.runtime.Actor(self))));
  private battleships.Board board;
  private java.util.LinkedList<battleships.Coordinate> opponentQueries;
  private battleships.Coordinate nextQuery = null;
  public Player ()
  {
    opponentQueries = new java.util.LinkedList<battleships.Coordinate>();
  }
  public void init(int numCovered)
  {
    final battleships.Ship[] myCunningStrategy = {new battleships.Ship(new battleships.Coordinate(1, 1), 1, true), new battleships.Ship(new battleships.Coordinate(1, 3), 2, false), new battleships.Ship(new battleships.Coordinate(2, 2), 3, true), new battleships.Ship(new battleships.Coordinate(3, 4), 4, false), new battleships.Ship(new battleships.Coordinate(5, 6), 5, true), new battleships.Ship(new battleships.Coordinate(5, 7), 6, false)};
    battleships.Board board = new battleships.Board(boardPolicy);
    int i = 0;
    for (int count = numCovered ; count > 0 && board != null ;)
    {
      try
      {
        try
        {
          try
          {
            if (i > myCunningStrategy.length)
            i = 0;
            battleships.Ship newPiece = myCunningStrategy[i++];
            if (newPiece != null && newPiece.length > count)
            {
              newPiece = new battleships.Ship(newPiece.pos, count, newPiece.isHorizontal);
            }
            board.addShip(newPiece);
            count -= (newPiece == null ? 0 : newPiece.length);
          }
          catch (java.lang.ArrayIndexOutOfBoundsException ignored)
          {
          }
        }
        catch (java.lang.IllegalArgumentException ignored)
        {
        }
      }
      catch (java.lang.NullPointerException ex)
      {
      }
    }
    this.board = board;
  }
  public battleships.Coordinate getNextQuery()
  {
    battleships.Coordinate c = this.nextQuery;
    if (c == null)
    {
      c = new battleships.Coordinate(0, 0);
    }
    boolean direction = ((c.x + c.y) % 2 == 0);
    int newX = c.x + (direction ? 1 : -1);
    int newY = c.y + (direction ? -1 : 1);
    if (newX < 0)
    newX = 0;
    if (newY < 0)
    newY = 0;
    this.nextQuery = new battleships.Coordinate(newX, newY);
    return c;
  }
  boolean processQuery(battleships.Coordinate query) throws java.lang.IllegalArgumentException
  {
    java.util.LinkedList<battleships.Coordinate> oppQueries = this.opponentQueries;
    try
    {
      if (oppQueries.contains(query))
      {
        throw new java.lang.IllegalArgumentException("Opponent already asked the query " + query.toString());
      }
      oppQueries.add(query);
      boolean result = testAndDeclassify(query);
      return result;
    }
    catch (java.lang.NullPointerException ex)
    {
      throw new java.lang.IllegalArgumentException("Bad state or args");
    }
  }
  private boolean testAndDeclassify(battleships.Coordinate query)
  {
    boolean res = this.board.testPosition(query);
    boolean declassified = false;
    {
      declassified = res;
    }
    return declassified;
  }
}