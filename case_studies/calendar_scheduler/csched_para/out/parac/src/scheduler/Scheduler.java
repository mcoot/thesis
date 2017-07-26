package scheduler;
import java.util.HashMap;
import java.util.LinkedList;
public class Scheduler
{
  public static final se.chalmers.paragon.runtime.Policy bottom = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {java.lang.Object.class}, new se.chalmers.paragon.runtime.Variable(0)));
  private java.util.HashMap<scheduler.User, scheduler.Calendar> calendars;
  public Scheduler ()
  {
    calendars = new java.util.HashMap<scheduler.User, scheduler.Calendar>();
  }
  public scheduler.Calendar getCalendar(scheduler.User user)
  {
    return calendars.get(user);
  }
  public void addUser(scheduler.User user)
  {
    try
    {
      calendars.put(user, new scheduler.Calendar(user.self));
    }
    catch (java.lang.NullPointerException ex)
    {
    }
  }
  public boolean attendeesFreeAtTime(java.util.LinkedList<scheduler.User> users, int day, int startHour, int endHour)
  {
    for (int i = 0 ; i < users.size() ; ++i)
    {
      if (!calendars.get(users.get(i)).freeAtTime(day, startHour, endHour))
      {
        return false;
      }
    }
    return true;
  }
  public void addMeeting(scheduler.User user, scheduler.Meeting meeting)
  {
    calendars.get(user).addMeeting(meeting);
  }
}