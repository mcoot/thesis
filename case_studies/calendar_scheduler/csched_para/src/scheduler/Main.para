package scheduler;

import java.util.LinkedList;

public class Main {

    private static Scheduler scheduler = new Scheduler();

    private static User alice = new User("Alice");
    private static User bob = new User("Bob");
    private static User charles = new User("Charles");

    private static LinkedList<User> aliceOnly = new LinkedList<>();
    private static LinkedList<User> bobOnly = new LinkedList<>();
    private static LinkedList<User> charlesOnly = new LinkedList<>();
    private static LinkedList<User> alicebob = new LinkedList<>();
    private static LinkedList<User> alicecharles = new LinkedList<>();
    private static LinkedList<User> bobcharles = new LinkedList<>();
    private static LinkedList<User> allUsers = new LinkedList<>();

    private static Meeting meetingAliceBobAttend;

    public static void main(String[] args) {
        System.out.println("Calendar scheduler" +
                           "\n----------------\n");

        System.out.println("Initialising system...");

        setupDummyData();

        // Finding out whether other users are free or not has no confidentiality constraints
        boolean scheduleCheck1 = scheduler.attendeesFreeAtTime(allUsers,
                Meeting.getDayValue("Monday"), 9, 10);
        System.out.println("Are all users available at 9 - 10 on a Monday? " + scheduleCheck1);
        boolean scheduleCheck2 = scheduler.attendeesFreeAtTime(allUsers,
                Meeting.getDayValue("Tuesday"), 9, 10);
        System.out.println("Are all users available at 9 - 10 on a Tuesday? " + scheduleCheck2);

        System.out.println();
        System.out.println("Alice prints her calendar:");

        // A user may print out all events in their own calendar (since they attend all events in their calendar)
        alice.channel.println(scheduler.getCalendar(alice).getCalendarRepresentation());

        // A user may not print out another user's calendar since it cannot be statically determined whether the printing user attends all of them!
        // alice.channel.println(scheduler.getCalendar(bob).getCalendarRepresentation());

        System.out.println();
        System.out.println("Alice and bob print an event both attend:");

        // Alice and bob may both print out a meeting they attend
        alice.channel.println(meetingAliceBobAttend.toString());
        bob.channel.println(meetingAliceBobAttend.toString());
        // Charles may not
        // charles.channel.println(meetingAliceBobAttend);



    }

    private static void setupDummyData() {
        // Add the users to the scheduler
        scheduler.addUser(alice);
        scheduler.addUser(bob);
        scheduler.addUser(charles);

        // Combinations of attendees
        aliceOnly.add(alice);
        bobOnly.add(bob);
        charlesOnly.add(charles);
        alicebob.add(alice);
        alicebob.add(bob);
        alicecharles.add(alice);
        alicecharles.add(charles);
        bobcharles.add(bob);
        bobcharles.add(charles);
        allUsers.add(alice);
        allUsers.add(bob);
        allUsers.add(charles);

        try {
            // Only making dummy schedules for Monday

            // Alice
            scheduler.addMeeting(alice, new Meeting("Monday", 8, 10, "Coming in late", aliceOnly));
            scheduler.addMeeting(alice, new Meeting("Monday", 12, 13, "Lunch break", aliceOnly));
            scheduler.addMeeting(alice, new Meeting("Monday", 16, 18, "Leaving early", aliceOnly));


            // Bob meetings
            scheduler.addMeeting(bob, new Meeting("Monday", 7, 9, "Long breaky", bobOnly));
            scheduler.addMeeting(bob, new Meeting("Monday", 13, 14, "Nap time", bobOnly));

            // Charles meetings
            scheduler.addMeeting(charles, new Meeting("Monday", 10, 11, "Important Serious Work", charlesOnly));

            // Some combinations
            meetingAliceBobAttend = new Meeting("Monday", 10, 12, "Catch up sesh", alicebob);
            scheduler.addMeeting(alice, meetingAliceBobAttend);
            scheduler.addMeeting(bob, meetingAliceBobAttend);

            Meeting m = new Meeting("Monday", 13, 14, "Alice's disciplinary hearing", alicecharles);
            scheduler.addMeeting(alice, m);
            scheduler.addMeeting(charles, m);

            m = new Meeting("Monday", 9, 10, "Bob's disciplinary hearing", bobcharles);
            scheduler.addMeeting(bob, m);
            scheduler.addMeeting(charles, m);

            m = new Meeting("Monday", 14, 15, "Departmental meeting", allUsers);
            scheduler.addMeeting(alice, m);
            scheduler.addMeeting(bob, m);
            scheduler.addMeeting(charles, m);
        } catch (InvalidMeetingException ex) {
            // Impossible
            System.err.println("Meetings are broken :(");
        }
    }

}
