package scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An entry in the calendar
 *
 * It is assumed that all engagements start/end on the hour
 */
public final class CalendarEntry {

    // The day on which the engagement is held
    private final WeekDay day;
    // The hour on which the engagement starts
    private final int startHour;
    // The hour on which the engagement ends
    private final int endHour;
    // The title of the engagement
    private final String title;
    // The engagement description
    private final String description;

    // The list of users who are attending the engagement
    private final List<User> attendees;

    /**
     * Construct a new calendar entry
     *
     * @param day the day the engagement is on
     * @param startHour the hour the engagement starts
     * @param endHour the hour the engagement ends
     * @param title the title of the engagement
     * @param description the engagement description
     * @param attendees the attendees of the engagement
     * @throws CalendarException.InvalidEntryException if the times are invalid
     */
    public CalendarEntry(WeekDay day, int startHour, int endHour,
                         String title, String description, List<User> attendees)
            throws CalendarException.InvalidEntryException {
        // Check that the engagement is valid
        if (!areTimesValid(startHour, endHour)) {
            throw new CalendarException.InvalidEntryException(
                    String.format("Engagement %s (%d - %d) is not valid", title, startHour, endHour));
        }
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
        this.title = title;
        this.description = description;

        this.attendees = new ArrayList<>(attendees);
    }

    /**
     * Construct a new calendar entry with only one attendee
     *
     * @param day the day the engagement is on
     * @param startHour the hour the engagement starts
     * @param endHour the hour the engagement ends
     * @param title the title of the engagement
     * @param description the engagement description
     * @param attendee the user attending the engagement
     */
    public CalendarEntry(WeekDay day, int startHour, int endHour,
                         String title, String description, User attendee)
            throws CalendarException.InvalidEntryException {
        this(day, startHour, endHour, title, description, Collections.singletonList(attendee));
    }

    /**
     * Check whether the given times are possible for an engagement
     *
     * @param startHour the start time
     * @param endHour the end time
     * @return true iff the times are valid for an engagement
     */
    private boolean areTimesValid(int startHour, int endHour) {
        // Must be valid hours - cannot start after 11pm or end after midnight
        if (startHour < 0 || startHour > 23) return false;
        if (endHour < 0 || endHour > 24) return false;
        // Start must be earlier than end
        if (startHour >= endHour) return false;
        return true;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public int getDuration() {
        return endHour - startHour;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<User> getAttendees() {
        return new ArrayList<>(attendees);
    }

    /**
     * Check whether this entry overlaps with another entry
     *
     * If an entry ends at the same time the other starts, it is assumed they do not overlap
     *
     * @param entry the entry to check against
     * @return true iff the entries overlap in time
     */
    public boolean overlapsWith(CalendarEntry entry) {
        // Check they are on the same day
        if (!day.equals(entry.day)) return false;
        // If one entry's start is within the other entry, they overlap
        return ((startHour >= entry.startHour && startHour < entry.endHour)
                || (entry.startHour >= startHour && entry.startHour < endHour));
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CalendarEntry)) return false;
        CalendarEntry other = (CalendarEntry)o;

        return day.equals(other.day)
                && other.startHour == startHour && other.endHour == endHour
                && title.equals(other.title) && description.equals(other.description)
                && attendees.equals(other.attendees);
    }

    @Override
    public int hashCode() {
        int result = 19;
        result = 29 * result + day.hashCode();
        result = 29 * result + startHour;
        result = 29 * result + endHour;
        result = 29 * result + title.hashCode();
        result = 29 * result + description.hashCode();
        result = 29 * result + attendees.hashCode();

        return result;
    }

    @Override
    public String toString() {
        String sep = System.lineSeparator();
        String format = "Calendar Entry: " + sep + "Title: %s" + sep + "Description: %s"
                + sep + "Time/Day: %d - %d, %s" + sep + "Attendees: %s";

        StringBuilder s = new StringBuilder();
        String commaSep = "";
        for (User u : attendees) {
            s.append(commaSep);
            s.append(u.toString());
            commaSep = ", ";
        }

        return String.format(format, title, description, startHour, endHour, day, s.toString());
    }

}
