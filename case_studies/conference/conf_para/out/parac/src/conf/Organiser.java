package conf;
public class Organiser
{
  private final java.lang.String name;
  public Organiser (java.lang.String name)
  {
    this.name = name;
  }
  public java.lang.String getName()
  {
    return name;
  }
  public boolean equals(java.lang.Object o)
  {
    conf.Organiser other;
    try
    {
      other = (conf.Organiser) o;
    }
    catch (java.lang.ClassCastException ex)
    {
      return false;
    }
    return other.name.equals(name);
  }
  public int hashCode()
  {
    return name.hashCode();
  }
  public java.lang.String toString()
  {
    return "Organiser: " + name;
  }
}