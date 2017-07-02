public final class User
{
  private final java.lang.String name;
  public User (java.lang.String name)
  {
    this.name = name;
  }
  public java.lang.String getName()
  {
    return name;
  }
  public boolean equals(java.lang.Object other)
  {
    try
    {
      return name.equals(((User) other).name);
    }
    catch (java.lang.ClassCastException ex)
    {
      return false;
    }
  }
  public int hashCode()
  {
    return name.hashCode();
  }
  public java.lang.String toString()
  {
    return "User: " + name;
  }
}