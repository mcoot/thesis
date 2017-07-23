package battleships;
public class Ship
{
  final battleships.Coordinate pos;
  final int length;
  final boolean isHorizontal;
  public Ship (battleships.Coordinate pos, int len, boolean isHoriz)
  {
    this.pos = pos;
    this.length = len;
    this.isHorizontal = isHoriz;
  }
  public boolean covers(battleships.Coordinate coord)
  {
    battleships.Coordinate pos = this.pos;
    try
    {
      if (isHorizontal)
      {
        return coord.y == pos.y && pos.x <= coord.x && coord.x < pos.x + length;
      }
      else
      {
        return coord.x == pos.x && pos.y <= coord.y && coord.y < pos.y + length;
      }
    }
    catch (java.lang.NullPointerException ex)
    {
      return false;
    }
  }
  public boolean intersects(battleships.Ship ship)
  {
    battleships.Coordinate c = this.pos;
    try
    {
      for (int i = 0 ; i < length && c != null ; i++)
      {
        if (ship.covers(c))
        return true;
        if (isHorizontal)
        {
          c = new battleships.Coordinate(c.x + 1, c.y);
        }
        else
        {
          c = new battleships.Coordinate(c.x, c.y + 1);
        }
      }
    }
    catch (java.lang.NullPointerException ex)
    {
    }
    return false;
  }
  public java.lang.String toString()
  {
    battleships.Coordinate pos = this.pos;
    battleships.Coordinate end = null;
    if (pos == null)
    pos = new battleships.Coordinate(0, 0);
    if (isHorizontal)
    {
      end = new battleships.Coordinate(pos.x + length, pos.y);
    }
    else
    {
      end = new battleships.Coordinate(pos.x, pos.y + length);
    }
    return pos.toString() + " to " + end.toString();
  }
  public int hashCode()
  {
    battleships.Coordinate pos = this.pos;
    if (pos == null)
    pos = new battleships.Coordinate(0, 0);
    return pos.hashCode() ^ (4007 * length) ^ (isHorizontal ? 1861 : 2713);
  }
  public boolean equals(java.lang.Object o)
  {
    try
    {
      try
      {
        battleships.Ship that = (battleships.Ship) o;
        battleships.Coordinate thispos = this.pos;
        battleships.Coordinate thatpos = that.pos;
        return this.length == that.length && this.isHorizontal == that.isHorizontal && (thispos == thatpos || thispos != null && thispos.equals(thatpos));
      }
      catch (java.lang.ClassCastException ex)
      {
        return false;
      }
    }
    catch (java.lang.NullPointerException ex)
    {
      return false;
    }
  }
}