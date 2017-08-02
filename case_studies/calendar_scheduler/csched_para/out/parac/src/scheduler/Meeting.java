package scheduler;
import java.util.LinkedList;
public class Meeting
{
  public final scheduler.Meeting self = this;
  public final scheduler.User owner;
  static final public se.chalmers.paragon.runtime.LockID isAttending = new se.chalmers.paragon.runtime.LockID("isAttending", scheduler.User.class, scheduler.Meeting.class);
  static final public se.chalmers.paragon.runtime.LockID isOwner = new se.chalmers.paragon.runtime.LockID("isOwner", scheduler.User.class, scheduler.Meeting.class);
  public final se.chalmers.paragon.runtime.Policy attendeesOnly = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {scheduler.User.class}, new se.chalmers.paragon.runtime.Variable(0), new se.chalmers.paragon.runtime.Atom(isAttending, new se.chalmers.paragon.runtime.Variable(0), new se.chalmers.paragon.runtime.Actor(self))));
  public final se.chalmers.paragon.runtime.Policy ownerOnly = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {scheduler.User.class}, new se.chalmers.paragon.runtime.Variable(0), new se.chalmers.paragon.runtime.Atom(isOwner, new se.chalmers.paragon.runtime.Variable(0), new se.chalmers.paragon.runtime.Actor(self))));
  public final java.lang.String title;
  public final int day;
  public final int startHour;
  public final int endHour;
  private java.util.LinkedList<scheduler.User> users;
  public Meeting (scheduler.User uowner, java.lang.String dayName, int startHour, int endHour, java.lang.String title, java.util.LinkedList<scheduler.User> attendees)
  {
    // self = (scheduler.Meeting) this;
    owner = uowner;
    se.chalmers.paragon.runtime.LockState.open(new se.chalmers.paragon.runtime.Lock(isOwner, new se.chalmers.paragon.runtime.Actor(owner), new se.chalmers.paragon.runtime.Actor(self)));
    this.day = getDayValue(dayName);
    this.startHour = startHour;
    this.endHour = endHour;
    this.title = title;
    users = new java.util.LinkedList<scheduler.User>();
    for (int i = 0 ; i < attendees.size() ; ++i)
    {
      scheduler.User u = attendees.get(i);
      se.chalmers.paragon.runtime.LockState.open(new se.chalmers.paragon.runtime.Lock(isAttending, new se.chalmers.paragon.runtime.Actor(u), new se.chalmers.paragon.runtime.Actor(self)));
      this.users.add(u);
    }
  }
  private static boolean meetingDetailsValid(int day, int startHour, int endHour)
  {
    return (day >= 0 && day <= 6) && (startHour >= 0 && startHour <= 23) && (endHour > startHour && endHour <= 24);
  }
  public boolean overlaps(int day, int startHour, int endHour)
  {
    return this.day == day && ((this.startHour >= startHour && this.startHour < endHour) || (startHour >= this.startHour && startHour < this.endHour));
  }
  public boolean overlaps(scheduler.Meeting that)
  {
    try
    {
      return overlaps(that.day, that.startHour, that.endHour);
    }
    catch (java.lang.NullPointerException ex)
    {
      return false;
    }
  }
  public int getDuration()
  {
    return endHour - startHour;
  }
  public java.util.LinkedList<scheduler.User> getUsers()
  {
    return this.users;
  }
  public boolean equals(java.lang.Object o)
  {
    scheduler.Meeting that;
    try
    {
      that = (scheduler.Meeting) o;
    }
    catch (java.lang.ClassCastException ex)
    {
      return false;
    }
    try
    {
      return this.title.equals(that.title) && this.day == that.day && this.startHour == that.startHour && this.endHour == that.endHour && this.users.equals(that.users);
    }
    catch (java.lang.NullPointerException ex)
    {
      return false;
    }
  }
  public static java.lang.String getDayName(int day)
  {
    if (day == 0)
    {
      return "Sunday";
    }
    else
    if (day == 1)
    {
      return "Monday";
    }
    else
    if (day == 2)
    {
      return "Tuesday";
    }
    else
    if (day == 3)
    {
      return "Wednesday";
    }
    else
    if (day == 4)
    {
      return "Thursday";
    }
    else
    if (day == 5)
    {
      return "Friday";
    }
    else
    if (day == 6)
    {
      return "Saturday";
    }
    else
    {
      return "Invalid";
    }
  }
  public static int getDayValue(java.lang.String dayName)
  {
    java.lang.String d = dayName.toLowerCase();
    if (d.equals("sunday"))
    {
      return 0;
    }
    else
    if (d.equals("monday"))
    {
      return 1;
    }
    else
    if (d.equals("tuesday"))
    {
      return 2;
    }
    else
    if (d.equals("wednesday"))
    {
      return 3;
    }
    else
    if (d.equals("thursday"))
    {
      return 4;
    }
    else
    if (d.equals("friday"))
    {
      return 5;
    }
    else
    if (d.equals("saturday"))
    {
      return 6;
    }
    else
    {
      return -1;
    }
  }
  public java.lang.String toString()
  {
    java.lang.String s = "<\"" + title + "\" | " + getDayName(this.day) + " " + this.startHour + " - " + this.endHour + " | ";
    java.lang.String sep = "";
    for (int i = 0 ; i < this.users.size() ; ++i)
    {
      s += sep;
      s += this.users.get(i).toString();
      sep = ", ";
    }
    s += ">";
    return s;
  }
}