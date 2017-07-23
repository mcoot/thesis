package battleships;
import java.util.LinkedList;
public class Board
{
  public final se.chalmers.paragon.runtime.Policy shipPolicy;
  private java.util.LinkedList<battleships.Ship> ships;
  public Board (final se.chalmers.paragon.runtime.Policy shipPolicy)
  {
    this.shipPolicy = shipPolicy;
    ships = new java.util.LinkedList<battleships.Ship>();
  }
  public void addShip(battleships.Ship s) throws java.lang.IllegalArgumentException
  {
    if (s != null)
    {
      for (int i = 0 ; i < this.ships.size() ; i++)
      {
        battleships.Ship t = this.ships.get(i);
        if (s.intersects(t))
        throw new java.lang.IllegalArgumentException("Ship to add " + "intersects an existing ship");
      }
      this.ships.add(s);
    }
  }
  public boolean testPosition(battleships.Coordinate coord)
  {
    for (int i = 0 ; i < this.ships.size() ; i++)
    {
      battleships.Ship s = this.ships.get(i);
      if (s != null && s.covers(coord))
      return true;
    }
    return false;
  }
}