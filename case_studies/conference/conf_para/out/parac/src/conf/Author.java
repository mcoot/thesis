package conf;
public class Author
{
  private final java.lang.String name;
  public Author (java.lang.String name)
  {
    this.name = name;
  }
  public java.lang.String getName()
  {
    return name;
  }
  public boolean equals(java.lang.Object o)
  {
    conf.Author other;
    try
    {
      other = (conf.Author) o;
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
    return "Author: " + name;
  }
}