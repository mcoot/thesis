package conf;
import java.util.HashMap;
import java.util.Map;
public class ConferenceSystem
{
  private static final se.chalmers.paragon.runtime.Policy bottom = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {java.lang.Object.class}, new se.chalmers.paragon.runtime.Variable(0)));
  static final public se.chalmers.paragon.runtime.LockID allocationsVisible = new se.chalmers.paragon.runtime.LockID("allocationsVisible");
  public static final se.chalmers.paragon.runtime.Policy ifAllocationsVisible = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {java.lang.Object.class}, new se.chalmers.paragon.runtime.Variable(0), new se.chalmers.paragon.runtime.Atom(allocationsVisible)), new se.chalmers.paragon.runtime.Clause(new Class<?>[] {conf.Organiser.class}, new se.chalmers.paragon.runtime.Variable(0)));
  public final conf.Organiser organiser;
  private int numSubmissions;
  private conf.Paper[] submissions;
  private java.util.HashMap<conf.Paper, java.lang.Integer> allocations;
  public ConferenceSystem ()
  {
    organiser = new conf.Organiser("TheOrganiser");
    submissions = new conf.Paper[5];
    numSubmissions = 0;
    allocations = new java.util.HashMap<conf.Paper, java.lang.Integer>();
  }
  private conf.Paper upgradePaper(conf.Paper paper)
  {
    conf.Author[] paperAuthors = paper.getAuthors();
    conf.Author[] upgradedAuthors = new conf.Author[paperAuthors.length];
    for (int i = 0 ; i < paperAuthors.length ; ++i)
    {
      conf.Author u = paperAuthors[i];
      upgradedAuthors[i] = u;
    }
    conf.Paper upgraded = new conf.Paper(ifAllocationsVisible, paper.getTitle(), paper.getAbstract(), upgradedAuthors);
    return upgraded;
  }
  public void handleSubmission(conf.Paper paper)
  {
    if (!se.chalmers.paragon.runtime.LockState.isOpen(new se.chalmers.paragon.runtime.Lock(allocationsVisible)))
    {
      submissions[numSubmissions] = upgradePaper(paper);
      numSubmissions++;
      if (numSubmissions >= submissions.length)
      {
        conf.Paper[] newSubmissions = new conf.Paper[numSubmissions * 2];
        for (int i = 0 ; i < submissions.length ; ++i)
        {
          newSubmissions[i] = submissions[i];
        }
        submissions = newSubmissions;
      }
    }
  }
  public conf.Paper[] getSubmissions()
  {
    conf.Paper[] copy = new conf.Paper[submissions.length];
    for (int i = 0 ; i < copy.length ; ++i)
    {
      copy[i] = submissions[i];
    }
    return copy;
  }
  public int getSessionNumber(conf.Paper paper)
  {
    if (se.chalmers.paragon.runtime.LockState.isOpen(new se.chalmers.paragon.runtime.Lock(allocationsVisible)))
    {
      return (int) allocations.get(paper);
    }
    else
    {
      return -1;
    }
  }
  public void performAllocations()
  {
    for (int i = 0 ; i < numSubmissions ; ++i)
    {
      allocations.put(submissions[i], i);
    }
  }
  public void setAllocationsVisible()
  {
    se.chalmers.paragon.runtime.LockState.open(new se.chalmers.paragon.runtime.Lock(allocationsVisible));
  }
}