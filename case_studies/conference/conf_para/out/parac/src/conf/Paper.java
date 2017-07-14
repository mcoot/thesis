package conf;
public class Paper
{
  public final se.chalmers.paragon.runtime.Policy authorRestriction;
  private final java.lang.String title;
  private final java.lang.String paperAbstract;
  private final conf.Author[] authors;
  public Paper (final se.chalmers.paragon.runtime.Policy authorRestriction, java.lang.String title, java.lang.String paperAbstract, conf.Author[] authors)
  {
    this.authorRestriction = authorRestriction;
    this.title = title;
    this.paperAbstract = paperAbstract;
    this.authors = new conf.Author[authors.length];
    for (int i = 0 ; i < authors.length ; ++i)
    {
      this.authors[i] = authors[i];
    }
  }
  public java.lang.String getTitle()
  {
    return title;
  }
  public java.lang.String getAbstract()
  {
    return paperAbstract;
  }
  public conf.Author[] getAuthors()
  {
    conf.Author[] copy = new conf.Author[authors.length];
    for (int i = 0 ; i < authors.length ; ++i)
    {
      copy[i] = authors[i];
    }
    return copy;
  }
  public boolean equals(java.lang.Object o)
  {
    try
    {
      conf.Paper other;
      try
      {
        other = (conf.Paper) o;
      }
      catch (java.lang.ClassCastException ex)
      {
        return false;
      }
      if (authors.length != other.authors.length)
      return false;
      for (int i = 0 ; i < authors.length ; ++i)
      {
        if (!authors[i].equals(other.authors[i]))
        {
          return false;
        }
      }
      return other.title.equals(title) && other.paperAbstract.equals(paperAbstract);
    }
    catch (java.lang.NullPointerException ex)
    {
      return false;
    }
  }
  public int hashCode()
  {
    int result = 19;
    result = 31 * result + title.hashCode();
    result = 31 * result + paperAbstract.hashCode();
    for (int i = 0 ; i < authors.length ; ++i)
    {
      result = 31 * result + authors[i].hashCode();
    }
    return result;
  }
  public java.lang.String toString()
  {
    java.lang.String s = "";
    s += "Title: " + title + "\n";
    s += "Abstract: " + paperAbstract + "\n";
    s += "Authors: ";
    java.lang.String sep = "";
    for (int i = 0 ; i < authors.length ; ++i)
    {
      s += sep + authors[i].toString();
      sep = ",";
    }
    return s;
  }
}