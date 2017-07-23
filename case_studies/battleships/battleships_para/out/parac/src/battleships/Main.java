package battleships;
import java.io.PrintStream;
public class Main
{
  public static final se.chalmers.paragon.runtime.Policy bottom = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {java.lang.Object.class}, new se.chalmers.paragon.runtime.Variable(0)));
  public static final void main(java.lang.String[] args) throws java.lang.IllegalArgumentException
  {
    java.io.PrintStream out = java.lang.System.out;
    new battleships.BattleShip().play(out);
  }
}