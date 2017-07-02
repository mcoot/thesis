public class Policy
{
  public static final java.lang.Object lowObserver = new java.lang.Object();
  public static final java.lang.Object highObserver = new java.lang.Object();
  public static final se.chalmers.paragon.runtime.Policy high = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {}, new se.chalmers.paragon.runtime.Actor(highObserver)));
  public static final se.chalmers.paragon.runtime.Policy low = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {}, new se.chalmers.paragon.runtime.Actor(lowObserver)), new se.chalmers.paragon.runtime.Clause(new Class<?>[] {}, new se.chalmers.paragon.runtime.Actor(highObserver)));
}