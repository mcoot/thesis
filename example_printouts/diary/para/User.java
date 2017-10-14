public class User
{
  public final java.lang.String name;
  public User (java.lang.String uname)
  {
    name = uname;
  }
  public boolean equals(java.lang.Object o)
  {
    User that;
    try
    {
      that = (User) o;
    }
    catch (java.lang.ClassCastException ex)
    {
      return false;
    }
    try
    {
      return that.name.equals(name);
    }
    catch (java.lang.NullPointerException ex)
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
    return name;
  }
}