package scheduler;
import java.util.LinkedList;
public class Calendar
{
  public final scheduler.User user;
  private java.util.LinkedList<scheduler.Meeting> meetings;
  public Calendar (scheduler.User inputUser)
  {
    user = inputUser;
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
    try
    {
      if (meeting != null && user.equals(meeting.owner))
      {
        meetings.add(meeting);
      }
    }
    catch (java.lang.NullPointerException impossible)
    {
    }
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
        if (se.chalmers.paragon.runtime.LockState.isOpen(new se.chalmers.paragon.runtime.Lock(scheduler.Meeting.isOwner, new se.chalmers.paragon.runtime.Actor(user), new se.chalmers.paragon.runtime.Actor(m.self))))
        {
          s += m.toString();
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