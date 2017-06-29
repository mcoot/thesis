package scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scheduler {

    private Map<User, Calendar> calendars;

    public Scheduler() {
        calendars = new HashMap<>();
    }

    /**
     * Add a user with a calendar to the scheduler
     *
     * @param name the username to add
     */
    public void addUser(String name) {
        User u = new User(name);

        // Cannot have duplicate users
        if (calendars.containsKey(u)) {
            throw new IllegalArgumentException("User already exists");
        }

        calendars.put(u, new Calendar(u));
    }

    /**
     * Add an event to the calendars of its attendees
     *
     * @param day the day the engagement is on
     * @param startHour the hour the engagement starts
     * @param endHour the hour the engagement ends
     * @param title the title of the engagement
     * @param description the engagement description
     * @param attendees the attendees of the event
     * @throws CalendarException if the entry is impossible
     *                           or clashes with an existing engagement for any attendee
     */
    public void schedule(WeekDay day, int startHour, int endHour,
                         String title, String description, List<User> attendees)
            throws CalendarException {
        for (User u : attendees) {
            List<User> otherAttendees = new ArrayList<>(attendees);
            otherAttendees.remove(u);
            calendars.get(u).addEntry(day, startHour, endHour, title, description, otherAttendees);
        }
    }

    /**
     * Check whether an event with the given details may be scheduled
     *
     * @param day the day the engagement is on
     * @param startHour the hour the engagement starts
     * @param endHour the hour the engagement ends
     * @param title the title of the engagement
     * @param description the engagement description
     * @param attendees the attendees of the event
     * @ true iff the event is valid and all attendees are free
     */
    public boolean canSchedule(WeekDay day, int startHour, int endHour,
                               String title, String description, List<User> attendees) {
        for (User u : attendees) {
            List<User> otherAttendees = new ArrayList<>(attendees);
            otherAttendees.remove(u);
            if (!calendars.get(u).canAddEntry(day, startHour, endHour, title, description, otherAttendees)) {
                return false;
            }
        }
        return true;
    }

}
