public class Diary
{
  public static final User alice = new User("Alice");
  public static final User betty = new User("Betty");
  public static final User mal = new User("Mal");
  static final private se.chalmers.paragon.runtime.LockID declassifier = new se.chalmers.paragon.runtime.LockID("declassifier");
  public static final se.chalmers.paragon.runtime.Policy aliceAndBetty = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {}, new se.chalmers.paragon.runtime.Actor(alice)), new se.chalmers.paragon.runtime.Clause(new Class<?>[] {}, new se.chalmers.paragon.runtime.Actor(betty)), new se.chalmers.paragon.runtime.Clause(new Class<?>[] {}, new se.chalmers.paragon.runtime.Actor(mal), new se.chalmers.paragon.runtime.Atom(declassifier)));
  public static final se.chalmers.paragon.runtime.Policy everyone = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {}, new se.chalmers.paragon.runtime.Actor(alice)), new se.chalmers.paragon.runtime.Clause(new Class<?>[] {}, new se.chalmers.paragon.runtime.Actor(betty)), new se.chalmers.paragon.runtime.Clause(new Class<?>[] {}, new se.chalmers.paragon.runtime.Actor(mal)));
  private int secretNumber;
  public Diary ()
  {
    secretNumber = 5;
  }
  public int readDiary()
  {
    return secretNumber;
  }
  public boolean isTheSecret5()
  {
    boolean result;
    if (secretNumber == 5)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  public void modifyDiary()
  {
    secretNumber = 10;
  }
  public int declassifyDiary()
  {
    int result;
    {
      result = secretNumber;
    }
    ;
    return result;
  }
}