package scheduler;
public final class CalendarEntry
{
  private final scheduler.CalendarEntry self = (scheduler.CalendarEntry) this;
  public static final se.chalmers.paragon.runtime.Policy allUsers = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {User.class}, new se.chalmers.paragon.runtime.Variable(0)));
  static final public se.chalmers.paragon.runtime.LockID isAttending = new se.chalmers.paragon.runtime.LockID("isAttending", User.class, scheduler.CalendarEntry.class);
  public static final se.chalmers.paragon.runtime.Policy attendeesOnly = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {User.class}, new se.chalmers.paragon.runtime.Variable(0), new se.chalmers.paragon.runtime.Atom(isAttending, new se.chalmers.paragon.runtime.Variable(0), new se.chalmers.paragon.runtime.Actor(self))));
  private final WeekDay day;
  private final int startHour;
  private final int endHour;
  private final java.lang.String title;
  private final java.lang.String description;
  private final User[] attendees;
  public CalendarEntry (WeekDay day, int startHour, int endHour, java.lang.String title, java.lang.String description, User[] attendees) throws CalendarException
  {
    if (!areTimesValid(startHour, endHour))
    {
      throw new CalendarException(java.lang.String.format("Engagement %s (%d - %d) is not valid", title, startHour, endHour));
    }
    this.day = day;
    this.startHour = startHour;
    this.endHour = endHour;
    if (title == null)
    {
      throw new CalendarException("Title may not be null");
    }
    this.title = title;
    if (description == null)
    {
      throw new CalendarException("Description may not be null");
    }
    this.description = description;
    if (attendees == null)
    {
      throw new CalendarException("Attendees may not be null");
    }
    this.attendees = new User[attendees.length];
    for (int i = 0 ; i < attendees.length ; ++i)
    {
      this.attendees[i] = attendees[i];
    }
    setAttendanceLocks();
  }
  private void setAttendanceLocks()
  {
    for (int i = 0 ; i < this.attendees.length ; ++i)
    {
      User curAttendee = attendees[i];
      se.chalmers.paragon.runtime.LockState.open(new se.chalmers.paragon.runtime.Lock(isAttending, new se.chalmers.paragon.runtime.Actor(curAttendee), new se.chalmers.paragon.runtime.Actor(self)));
    }
  }
  private boolean areTimesValid(int startHour, int endHour)
  {
    if (startHour < 0 || startHour > 23)
    return false;
    if (endHour < 0 || endHour > 24)
    return false;
    if (startHour >= endHour)
    return false;
    return true;
  }
  public int getStartHour()
  {
    return startHour;
  }
  public int getEndHour()
  {
    return endHour;
  }
  public int getDuration()
  {
    return endHour - startHour;
  }
  public java.lang.String getTitle()
  {
    return title;
  }
  public java.lang.String getDescription()
  {
    return description;
  }
  public User[] getAttendees()
  {
    return attendees;
  }
  public boolean overlapsWith(scheduler.CalendarEntry entry)
  {
    try
    {
      if (!day.equals(entry.day))
      return false;
      return ((startHour >= entry.startHour && startHour < entry.endHour) || (entry.startHour >= startHour && entry.startHour < endHour));
    }
    catch (java.lang.NullPointerException ex)
    {
      return false;
    }
  }
  public boolean equals(java.lang.Object o)
  {
    scheduler.CalendarEntry other = null;
    try
    {
      other = (scheduler.CalendarEntry) o;
    }
    catch (java.lang.ClassCastException ex)
    {
      return false;
    }
    try
    {
      return day.equals(other.day) && other.startHour == startHour && other.endHour == endHour && title.equals(other.title) && description.equals(other.description);
    }
    catch (java.lang.NullPointerException ex)
    {
      return false;
    }
  }
  public int hashCode()
  {
    int result = 19;
    result = 29 * result + day.hashCode();
    result = 29 * result + startHour;
    result = 29 * result + endHour;
    result = 29 * result + title.hashCode();
    result = 29 * result + description.hashCode();
    return result;
  }
  public java.lang.String toString()
  {
    java.lang.String sep = "\n";
    java.lang.String format = "Calendar Entry: " + sep + "\tTitle: %s" + sep + "\tDescription: %s" + sep + "\tTime/Day: %d - %d, %s" + sep + "\tAttendees: %s";
    java.lang.String s = "";
    java.lang.String commaSep = "";
    for (int i = 0 ; i < attendees.length ; ++i)
    {
      User u = attendees[i];
      s += commaSep;
      s += u.toString();
      commaSep = ", ";
    }
    return java.lang.String.format(format, title, description, startHour, endHour, day.toString(), s);
  }
}