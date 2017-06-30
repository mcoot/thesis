package scheduler;

import java.util.*;

public class Scheduler {

    private Map<User, Calendar> calendars;

    public Scheduler() {
        calendars = new HashMap<>();
    }

    /**
     * Add a user with a calendar to the scheduler
     *
     * @param name the username to add
     * @return the user added
     */
    public User addUser(String name) {
        User u = new User(name);

        // Cannot have duplicate users
        if (calendars.containsKey(u)) {
            throw new IllegalArgumentException("User already exists");
        }

        calendars.put(u, new Calendar(u));

        return u;
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
     *
     * Add an event with only one attendee
     *
     * @param day the day the engagement is on
     * @param startHour the hour the engagement starts
     * @param endHour the hour the engagement ends
     * @param title the title of the engagement
     * @param description the engagement description
     * @param user the user this engagement is for
     * @throws CalendarException if the entry is impossible or clashes
     */
    public void schedule(WeekDay day, int startHour, int endHour,
                         String title, String description, User user)
            throws CalendarException  {
        schedule(day, startHour, endHour, title, description, Collections.singletonList(user));
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

    /**
     * Get a string representation of a user's calendar
     *
     * @param user the user to get the calendar for
     * @return a string displaying the calendar
     */
    public String getCalendarPrintout(User user) {
        if (!calendars.containsKey(user)) {
            return null;
        }
        return calendars.get(user).toString();
    }

}
