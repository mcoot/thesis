package scheduler;
public final class Calendar
{
  public static final se.chalmers.paragon.runtime.Policy allUsers = scheduler.CalendarEntry.allUsers;
  public static final se.chalmers.paragon.runtime.Policy attendeesOnly = scheduler.CalendarEntry.attendeesOnly;
  public static final se.chalmers.paragon.runtime.Policy meme = new se.chalmers.paragon.runtime.Policy();
  public static final se.chalmers.paragon.runtime.Policy calendarOwner = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {}, new se.chalmers.paragon.runtime.Actor(user)));
  private final scheduler.Calendar self = (scheduler.Calendar) this;
  private final scheduler.User user;
  private int numEntries;
  private final scheduler.CalendarEntry[] entries;
  public Calendar (scheduler.User user)
  {
    this.user = user;
    entries = new scheduler.CalendarEntry[5];
    numEntries = 0;
  }
  public boolean canAddEntry(scheduler.WeekDay day, int startHour, int endHour, java.lang.String title, java.lang.String description, scheduler.User[] otherAttendees)
  {
    scheduler.User[] attendees = new scheduler.User[otherAttendees.length + 1];
    attendees[0] = user;
    for (int i = 1 ; i < attendees.length ; ++i)
    {
      attendees[i] = otherAttendees[i - 1];
    }
    scheduler.CalendarEntry entry;
    try
    {
      entry = new scheduler.CalendarEntry(day, startHour, endHour, title, description, attendees);
    }
    catch (scheduler.CalendarException ex)
    {
      return false;
    }
    for (int i = 0 ; i < numEntries ; ++i)
    {
      scheduler.CalendarEntry existing = entries[i];
      if (entry.overlapsWith(existing))
      {
        return false;
      }
    }
    return true;
  }
  public void addEntry(scheduler.WeekDay day, int startHour, int endHour, java.lang.String title, java.lang.String description, scheduler.User[] otherAttendees) throws scheduler.CalendarException
  {
    scheduler.User[] attendees = new scheduler.User[otherAttendees.length + 1];
    attendees[0] = user;
    for (int i = 1 ; i < attendees.length ; ++i)
    {
      attendees[i] = otherAttendees[i - 1];
    }
    scheduler.CalendarEntry entry = new scheduler.CalendarEntry(day, startHour, endHour, title, description, attendees);
    for (int i = 0 ; i < numEntries ; ++i)
    {
      scheduler.CalendarEntry existing = entries[i];
      if (entry.overlapsWith(existing))
      {
        throw new scheduler.CalendarException("Entry would clash with existing calendar");
      }
    }
    entries[numEntries] = entry;
    numEntries++;
    if (numEntries >= entries.length)
    {
      scheduler.CalendarEntry[] newList = new scheduler.CalendarEntry[numEntries * 2];
      for (int i = 0 ; i < numEntries ; ++i)
      {
        newList[i] = entries[i];
      }
      entries = newList;
    }
  }
  public java.lang.String toString()
  {
    java.lang.String s = "";
    s += "Calendar for " + user.getName() + ":";
    s += "\n";
    for (int i = 0 ; i < numEntries ; ++i)
    {
      scheduler.CalendarEntry entry = entries[i];
      if (se.chalmers.paragon.runtime.LockState.isOpen(new se.chalmers.paragon.runtime.Lock(scheduler.CalendarEntry.isAttending, new se.chalmers.paragon.runtime.Actor(user), new se.chalmers.paragon.runtime.Actor(entry))))
      {
        s += "\n";
      }
    }
    return s;
  }
}