package scheduler;

import java.util.ArrayList;
import java.util.List;

public final class Calendar {

    // The user who owns the calendar
    private final User user;

    private final List<CalendarEntry> entries;

    /**
     * Construct a calendar belonging to the given user
     *
     * @param user the user for this calendar
     */
    public Calendar(User user) {
        this.user = user;
        entries = new ArrayList<>();
    }

    /**
     * Returns whether a given entry could be added to the calendar
     *
     * @param day the day the engagement is on
     * @param startHour the hour the engagement starts
     * @param endHour the hour the engagement ends
     * @param title the title of the engagement
     * @param description the engagement description
     * @param otherAttendees the attendees of the event, not including the calendar owner
     * @return true iff adding the entry would succeed, false if it would cause an exception
     */
    public boolean canAddEntry(WeekDay day, int startHour, int endHour,
                               String title, String description, List<User> otherAttendees) {
        // The current user must attend events on their calendar
        List<User> attendees = new ArrayList<>(otherAttendees);
        attendees.add(user);

        CalendarEntry entry;
        try {
            entry = new CalendarEntry(day, startHour, endHour, title, description, attendees);
        } catch (CalendarException.InvalidEntryException ex) {
            return false;
        }

        // Check that the entry does not overlap any existing entries
        for (CalendarEntry existing : entries) {
            if (entry.overlapsWith(existing)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Add an entry to the calendar
     *
     * @param day the day the engagement is on
     * @param startHour the hour the engagement starts
     * @param endHour the hour the engagement ends
     * @param title the title of the engagement
     * @param description the engagement description
     * @param otherAttendees the attendees of the event, not including the calendar owner
     * @throws CalendarException if the entry is impossible or clashes with an existing engagement
     */
    public void addEntry(WeekDay day, int startHour, int endHour,
                         String title, String description, List<User> otherAttendees)
            throws CalendarException {
        // The current user must attend events on their calendar
        List<User> attendees = new ArrayList<>(otherAttendees);
        attendees.add(user);

        CalendarEntry entry = new CalendarEntry(day, startHour, endHour, title, description, attendees);

        // Check that the entry does not overlap any existing entries
        for (CalendarEntry existing : entries) {
            if (entry.overlapsWith(existing)) {
                throw new CalendarException("Entry would clash with existing calendar");
            }
        }

        entries.add(entry);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("Calendar for " + user.getName() + ":");
        s.append(System.lineSeparator());

        for (CalendarEntry entry : entries) {
            s.append(entry.toString());
            s.append(System.lineSeparator());
        }

        return s.toString();
    }

}
