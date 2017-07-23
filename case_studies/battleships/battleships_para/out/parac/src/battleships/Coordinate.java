package battleships;
public class Coordinate
{
  public final int x;
  public final int y;
  public Coordinate (int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  public java.lang.String toString()
  {
    return "(" + x + "," + y + ")";
  }
  public int hashCode()
  {
    return (13 * this.x) ^ (-23 * this.y);
  }
  public boolean equals(java.lang.Object o)
  {
    try
    {
      try
      {
        battleships.Coordinate that = (battleships.Coordinate) o;
        return this.x == that.x && this.y == that.y;
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