package scheduler;

import java.util.LinkedList;

public class Calendar {

    public final User user;

    private LinkedList<Meeting> meetings;

    public Calendar(User user) {
        this.user = user;
        this.meetings = new LinkedList<>();
    }

    public boolean freeAtTime(int startHour, int endHour) {
        if (endHour <= startHour) return false;

        for (int i = 0; i < meetings.size(); ++i) {
            if (meetings.get(i).overlaps(startHour, endHour)) {
                return false;
            }
        }

        return true;
    }

    public void addMeeting(Meeting meeting) throws InvalidMeetingException {
        if (!freeAtTime(meeting.startHour, meeting.endHour) || !meeting.getUsers().contains(user)) {
            throw new InvalidMeetingException();
        }

        meetings.add(meeting);
    }

    public LinkedList<Meeting> getMeetings() {
        return new LinkedList<>(meetings);
    }

    public String getCalendarRepresentation() {
        String s = user.toString() + "'s Calendar:\n---";

        for (int i = 0; i < meetings.size(); ++i) {
            s += "\n" + meetings.get(i).toString();
        }

        return s;
    }

}
