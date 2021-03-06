package conf;
public class Main
{
  private static final se.chalmers.paragon.runtime.Policy bottom = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {java.lang.Object.class}, new se.chalmers.paragon.runtime.Variable(0)));
  private static conf.ConferenceSystem conferenceSystem;
  private static conf.Paper[] papers;
  public static void main(java.lang.String[] args)
  {
    java.lang.System.out.println("Conference system" + "\n-----------------\n");
    java.lang.System.out.println("Initialising system...");
    setupDummyData();
    conf.Paper[] retrievedPapers = conferenceSystem.getSubmissions();
    java.lang.System.out.println("Performing session allocations [secret]");
    conferenceSystem.performAllocations();
    java.lang.System.out.println();
    java.lang.System.out.println("Allocations completed [secret]: attempting to retrieve session numbers:");
    printAllocations();
    java.lang.System.out.println();
    java.lang.System.out.println("Printing out (secret) author information via organiser channel:");
    try
    {
      printOutAuthorsOrganiser(conferenceSystem.organiser, retrievedPapers);
    }
    catch (java.lang.NullPointerException ex)
    {
    }
    java.lang.System.out.println();
    conferenceSystem.setAllocationsVisible();
    java.lang.System.out.println("Allocations made public: attempting to retrieve session numbers:");
    printAllocations();
    java.lang.System.out.println();
    java.lang.System.out.println("Printing out (no longer secret) author information via public channel:");
    printOutAuthors(retrievedPapers);
  }
  private static void printOutAuthors(conf.Paper[] retrievedPapers)
  {
    java.lang.System.out.println("Papers and authors: ");
    for (int i = 0 ; i < retrievedPapers.length ; ++i)
    {
      if (retrievedPapers[i] == null)
      continue;
      java.lang.System.out.print(retrievedPapers[i].getTitle() + ": ");
      java.lang.String sep = "";
      conf.Author[] authors = retrievedPapers[i].getAuthors();
      for (int j = 0 ; j < authors.length ; ++j)
      {
        conf.Author author = authors[j];
        java.lang.System.out.print(sep + author.toString());
        sep = ", ";
      }
      java.lang.System.out.println();
    }
  }
  private static void printOutAuthorsOrganiser(conf.Organiser organiser, conf.Paper[] retrievedPapers)
  {
    organiser.channel.println("Papers and authors: ");
    for (int i = 0 ; i < retrievedPapers.length ; ++i)
    {
      if (retrievedPapers[i] == null)
      continue;
      try
      {
        final java.lang.Object oself = organiser.self;
        organiser.channel.print(retrievedPapers[i].getTitle() + ": ");
        java.lang.String sep = "";
        conf.Author[] authors = retrievedPapers[i].getAuthors();
        for (int j = 0 ; j < authors.length ; ++j)
        {
          final conf.Author author = authors[j];
          conf.Author author2 = author;
          organiser.channel.print(sep);
          organiser.channel.print(author.toString());
          sep = ", ";
        }
      }
      catch (java.lang.NullPointerException e)
      {
      }
      organiser.channel.println();
    }
  }
  private static void setupDummyData()
  {
    conferenceSystem = new conf.ConferenceSystem();
    conf.Author alice = new conf.Author("Alice");
    conf.Author bob = new conf.Author("Bob");
    conf.Author charles = new conf.Author("Charles");
    conf.Author dennis = new conf.Author("Dennis");
    conf.Author eve = new conf.Author("Eve");
    conf.Author[] allAuthors = {alice, bob, charles, dennis, eve};
    conf.Author[] authorsABC = {alice, bob, charles};
    conf.Author[] authorsDE = {dennis, eve};
    papers = new conf.Paper[3];
    papers[0] = new conf.Paper(bottom, "A Paper We Did Together", "We all did it :3", allAuthors);
    papers[1] = new conf.Paper(bottom, "An Excellent Paper", "Truly excellent", authorsABC);
    papers[2] = new conf.Paper(bottom, "A Terrible Paper", "This paper is bad", authorsDE);
    conferenceSystem.handleSubmission(papers[0]);
    conferenceSystem.handleSubmission(papers[1]);
    conferenceSystem.handleSubmission(papers[2]);
  }
  private static void printAllocations()
  {
    for (int i = 0 ; i < papers.length ; ++i)
    {
      int sessionNumber = conferenceSystem.getSessionNumber(papers[i]);
      java.lang.System.out.println("Session number for \"" + papers[i].getTitle() + "\": " + sessionNumber);
    }
  }
}