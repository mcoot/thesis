package scheduler;
public class User
{
  public final scheduler.User self;
  public final java.lang.String name;
  public IOChannel channel;
  public User (java.lang.String uname)
  {
    self = (scheduler.User) this;
    name = uname;
    channel = new IOChannel(new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {java.lang.Object.class}, new se.chalmers.paragon.runtime.Variable(0))), self);
  }
  public boolean equals(java.lang.Object o)
  {
    scheduler.User that;
    try
    {
      that = (scheduler.User) o;
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