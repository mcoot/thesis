package scheduler;

import java.util.LinkedList;

public class Meeting {

    public final String title;

    public final int day;

    public final int startHour;

    public final int endHour;

    private LinkedList<User> users;

    public Meeting(int day, int startHour, int endHour, String title, LinkedList<User> attendees) throws InvalidMeetingException {
        if (!meetingDetailsValid(day, startHour, endHour)) {
            throw new InvalidMeetingException();
        }
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
        this.title = title;

        this.users = new LinkedList<>(attendees);
    }

    public Meeting(String dayName, int startHour, int endHour, String title, LinkedList<User> attendees) throws InvalidMeetingException {
        if (!meetingDetailsValid(getDayValue(dayName), startHour, endHour)) {
            throw new InvalidMeetingException();
        }
        this.day = getDayValue(dayName);
        this.startHour = startHour;
        this.endHour = endHour;
        this.title = title;

        this.users = new LinkedList<>(attendees);
    }

    private static boolean meetingDetailsValid(int day, int startHour, int endHour) {
        return (day >= 0 && day <= 6) && (startHour >= 0 && startHour <= 23) && (endHour > startHour && endHour <= 24);
    }

    public boolean overlaps(int day, int startHour, int endHour) {
        return this.day == day && ((this.startHour >= startHour && this.startHour < endHour)
                || (startHour >= this.startHour && startHour < this.endHour));
    }

    public boolean overlaps(Meeting that) {
        return overlaps(that.day, that.startHour, that.endHour);
    }

    public int getDuration() {
        return endHour - startHour;
    }

    public LinkedList<User> getUsers() {
        return new LinkedList<>(users);
    }

    public boolean equals(Object o) {
        Meeting that;
        try {
            that = (Meeting)o;
        } catch (ClassCastException ex) {
            return false;
        }

        try {
            return this.title.equals(that.title) && this.day == that.day && this.startHour == that.startHour
                    && this.endHour == that.endHour && this.users.equals(that.users);
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public int hashCode() {
        return 7 * title.hashCode() + 19 * this.day ^ 31 * this.startHour ^ 17 * this.endHour ^ 41 * this.users.hashCode();
    }

    public static String getDayName(int day) {
        if (day == 0) {
            return "Sunday";
        } else if (day == 1) {
            return "Monday";
        } else if (day == 2) {
            return "Tuesday";
        } else if (day == 3) {
            return "Wednesday";
        } else if (day == 4) {
            return "Thursday";
        } else if (day == 5) {
            return "Friday";
        } else if (day == 6) {
            return "Saturday";
        } else {
            return "Invalid";
        }
    }

    public static int getDayValue(String dayName) {
        String d = dayName.toLowerCase();

        if (d.equals("sunday")) {
            return 0;
        } else if (d.equals("monday")) {
            return 1;
        } else if (d.equals("tuesday")) {
            return 2;
        } else if (d.equals("wednesday")) {
            return 3;
        } else if (d.equals("thursday")) {
            return 4;
        } else if (d.equals("friday")) {
            return 5;
        } else if (d.equals("saturday")) {
            return 6;
        } else {
            return -1;
        }
    }

    public String toString() {
        String s = "<\"" + title + "\" | " + getDayName(this.day) + " " + this.startHour + " - " + this.endHour + " | ";

        String sep = "";
        for (int i = 0; i < this.users.size(); ++i) {
            s += sep;
            s += this.users.get(i).toString();
            sep = ", ";
        }
        s += ">";

        return s;
    }

}
