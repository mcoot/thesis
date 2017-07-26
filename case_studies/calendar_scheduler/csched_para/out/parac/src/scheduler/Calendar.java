package scheduler;
import java.util.LinkedList;
public class Calendar
{
  public final scheduler.User user;
  private java.util.LinkedList<scheduler.Meeting> meetings;
  public Calendar (scheduler.User user)
  {
    scheduler.User tmpUser = new scheduler.User("WHY");
    try
    {
      tmpUser = user.self;
    }
    catch (java.lang.NullPointerException ex)
    {
    }
    this.user = tmpUser;
    this.meetings = new java.util.LinkedList<scheduler.Meeting>();
  }
  public boolean freeAtTime(int day, int startHour, int endHour)
  {
    if (endHour <= startHour)
    return false;
    for (int i = 0 ; i < meetings.size() ; ++i)
    {
      if (meetings.get(i).overlaps(day, startHour, endHour))
      {
        return false;
      }
    }
    return true;
  }
  public void addMeeting(scheduler.Meeting meeting)
  {
    meetings.add(meeting);
  }
  public java.util.LinkedList<scheduler.Meeting> getMeetings()
  {
    return meetings;
  }
  public java.lang.String getCalendarRepresentation()
  {
    try
    {
      java.lang.String s = user.toString() + "'s Calendar:\n---";
      for (int i = 0 ; i < meetings.size() ; ++i)
      {
        scheduler.Meeting m = meetings.get(i);
        s += "\n";
        java.lang.String mString = m.toString();
        if (se.chalmers.paragon.runtime.LockState.isOpen(new se.chalmers.paragon.runtime.Lock(scheduler.Meeting.isAttending, new se.chalmers.paragon.runtime.Actor(user), new se.chalmers.paragon.runtime.Actor(m.self))))
        {
          s += mString;
        }
      }
      return s;
    }
    catch (java.lang.NullPointerException ex)
    {
      return "";
    }
  }
}