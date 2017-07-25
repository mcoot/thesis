package scheduler;

import java.util.HashMap;
import java.util.LinkedList;

public class Scheduler {

    private HashMap<User, Calendar> calendars;

    public Scheduler() {
        calendars = new HashMap<>();
    }

    public Calendar getCalendar(User user) {
        return calendars.get(user);
    }

    public void addUser(User user) {
        calendars.put(user, new Calendar(user));
    }

    public boolean attendeesFreeAtTime(LinkedList<User> users, int startHour, int endHour) {
        for (int i = 0; i < users.size(); ++i) {
            if (!calendars.get(users.get(i)).freeAtTime(startHour, endHour)) {
                return false;
            }
        }

        return true;
    }

    public void addMeeting(User user, Meeting meeting) throws InvalidMeetingException {
        calendars.get(user).addMeeting(meeting);
    }

}
