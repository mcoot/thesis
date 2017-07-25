package scheduler;

import java.util.LinkedList;

public class Main {

    private static Scheduler scheduler = new Scheduler();

    private static User alice = new User("Alice");
    private static User bob = new User("Bob");
    private static User charles = new User("Charles");

    public static void main(String[] args) {
        System.out.println("Calendar scheduler" +
                           "\n----------------\n");

        System.out.println("Initialising system...");

        setupDummyData();
    }

    private static void setupDummyData() {
        // Add the users to the scheduler
        scheduler.addUser(alice);
        scheduler.addUser(bob);
        scheduler.addUser(charles);

        // Combinations of attendees
        LinkedList<User> aliceOnly = new LinkedList<>();
        aliceOnly.add(alice);
        LinkedList<User> bobOnly = new LinkedList<>();
        aliceOnly.add(bob);
        LinkedList<User> charlesOnly = new LinkedList<>();
        aliceOnly.add(charles);
        LinkedList<User> alicebob = new LinkedList<>();
        aliceOnly.add(alice);
        aliceOnly.add(bob);
        LinkedList<User> alicecharles = new LinkedList<>();
        aliceOnly.add(alice);
        aliceOnly.add(charles);
        LinkedList<User> bobcharles = new LinkedList<>();
        aliceOnly.add(bob);
        aliceOnly.add(charles);
        LinkedList<User> allUsers = new LinkedList<>();
        aliceOnly.add(alice);
        aliceOnly.add(bob);
        aliceOnly.add(charles);


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
            scheduler.addMeeting(bob, new Meeting("Monday", 10, 11, "Important Serious Work", charlesOnly));

            // Some combinations
            scheduler.addMeeting(bob, new Meeting("Monday", 10, 12, "Catch up sesh", alicebob));
            scheduler.addMeeting(bob, new Meeting("Monday", 13, 14, "Alice's disciplinary hearing", alicecharles));
            scheduler.addMeeting(bob, new Meeting("Monday", 9, 10, "Bob's disciplinary hearing", bobcharles));


            scheduler.addMeeting(bob, new Meeting("Monday", 14, 15, "Departmental meeting", allUsers));
        } catch (InvalidMeetingException ex) {
            // Impossible
            System.err.println("Meetings are broken :(");
        }
    }

}
