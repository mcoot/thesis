package conf;
public class Organiser
{
  public final conf.Organiser self = (conf.Organiser) this;
  public final java.lang.Object oself = (java.lang.Object) self;
  private final java.lang.String name;
  public IOChannel channel;
  public Organiser (java.lang.String name)
  {
    this.name = name;
    channel = new IOChannel(new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {java.lang.Object.class}, new se.chalmers.paragon.runtime.Variable(0))), self);
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