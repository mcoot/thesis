package scheduler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class SchedulerApp {

    private static User alice;
    private static User bob;
    private static User charles;

    private static User currentUser;

    private static Scheduler scheduler = new Scheduler();

    public static void main(String[] args) {

        // Setup in/out streams
        PrintStream output = System.out;
        PrintStream err = System.err;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            setupCalendars();
        } catch (CalendarException ex) {
            err.println("Setup failed due to CalendarException: " + ex.getMessage());
            System.exit(1);
        }

        // Select user
        output.print("Select a user to log in as (select A, B or C):\nA) Alice\nB) Bob\nC) Charles\n> ");
        currentUser = null;
        while (currentUser == null) {
            String response = getUserResponse(input, err).toLowerCase().trim();
            if (response.equals("a") || response.equals("alice")) {
                currentUser = alice;
            } else if (response.equals("b") || response.equals("bob")) {
                currentUser = bob;
            } else if (response.equals("c") || response.equals("charles")) {
                currentUser = charles;
            } else {
                output.print("Invalid option. Choose one of A, B or C\n> ");
            }
        }

        output.println("Successfully logged in as " + currentUser.getName() + "!");

        // Allow the user to query whether meetings are free
        while (true) {
            output.print("> ");
            String response = getUserResponse(input, err).toLowerCase().trim();
            if (response.equals("exit") || response.equals("quit")) {
                // Quit command
                output.println("Exiting application...");
                System.exit(0);
            } else if (response.equals("help") || response.equals("?")) {
                // Help command
                output.println("Program commands:\nquit - exit the program" +
                        "\ncheck <day> <start> <end> - check whether a time is available to the current user" +
                        "\n\te.g. check monday 11 13 would check if Monday 11am to 1pm is free" +
                        "\ncheck <day> <start> <end> <attendees> - check whether a time is available to the given attendees" +
                        "\n\te.g. check monday 11 13 ABC checks whether all of Alice, Bob and Charles are free (e.g. AC would check just Alice and Charles)" +
                        "\nshow - show the current user's calendar");
            } else if (response.startsWith("check")) {
                parseCheckCommand(response, output);
            } else if (response.equals("show")) {
                output.println(scheduler.getCalendarPrintout(currentUser));
            } else {
                output.println("Command not recognised");
            }
        }

    }

    private static void parseCheckCommand(String command, PrintStream output) {
        WeekDay day = null;
        int startHour = -1;
        int endHour = -1;

        String[] args = command.split(" ");
        if (args.length < 4) {
            output.println("Too few arguments");
            return;
        }
        if (!args[0].equals("check")) {
            output.println("Command is not a check command");
            return;
        }

        try {
            day = WeekDay.valueOf(args[1].toUpperCase());
        } catch (IllegalArgumentException ex) {
            output.println("Day of week is invalid");
            return;
        }

        try {
            startHour = Integer.parseInt(args[2]);
            endHour = Integer.parseInt(args[3]);
        } catch (NumberFormatException ex) {
            output.println("Hours must be valid integers");
            return;
        }

        if (startHour < 0 || startHour > 23 || endHour < 0 || endHour > 24) {
            output.println("Hours must be within the 24 hour range");
            return;
        }

        if (startHour >= endHour) {
            output.println("Start must be before end");
            return;
        }

        // Check whether attendees were specified
        List<User> attendees = new ArrayList<>();
        if (args.length >= 5) {
            Set<Character> initials = new HashSet<>();
            for (char c : args[4].toCharArray()) {
                initials.add(c);
            }
            if (initials.contains('a')) {
                attendees.add(alice);
                initials.remove('a');
            }
            if (initials.contains('b')) {
                attendees.add(bob);
                initials.remove('b');
            }
            if (initials.contains('c')) {
                attendees.add(charles);
                initials.remove('c');
            }
            if (initials.size() > 0 || attendees.size() == 0) {
                output.println("Invalid attendees specified");
                return;
            }
        } else {
            attendees.add(currentUser);
        }

        if (scheduler.canSchedule(day, startHour, endHour, "", "", attendees)) {
            output.println("This slot is free for all attendees");
        } else {
            output.println("This slot is not free for all attendees");
        }

    }

    private static String getUserResponse(BufferedReader input, PrintStream err) {
        String response = null;

        try {
           response = input.readLine();
        } catch (IOException ex) {
            err.println("Failed to read from System input");
            System.exit(2);
        }

        return response;
    }

    /**
     * Sets up Alice, Bob and Charles' calendars and populates them with dummy events
     *
     * @throws CalendarException if events cannot be scheduled
     */
    private static void setupCalendars() throws CalendarException {
        alice = scheduler.addUser("Alice");
        bob = scheduler.addUser("Bob");
        charles = scheduler.addUser("Charles");

        // Alice's calendar
        scheduler.schedule(WeekDay.MONDAY, 8, 10, "Morning Meeting", "The meeting in the mornin'", alice);
        scheduler.schedule(WeekDay.TUESDAY, 8, 10, "Morning Meeting", "The meeting in the mornin'", alice);
        scheduler.schedule(WeekDay.WEDNESDAY, 8, 10, "Morning Meeting", "The meeting in the mornin'", alice);
        scheduler.schedule(WeekDay.THURSDAY, 8, 10, "Morning Meeting", "The meeting in the mornin'", alice);
        scheduler.schedule(WeekDay.FRIDAY, 8, 10, "Morning Meeting", "The meeting in the mornin'", alice);
        scheduler.schedule(WeekDay.THURSDAY, 10, 18, "ACTUALLY WORKING", "", alice);

        // Bob's calendar
        scheduler.schedule(WeekDay.MONDAY, 10, 12, "Unspecified Meeting", "", bob);
        scheduler.schedule(WeekDay.TUESDAY, 10, 11, "Specified meeting", "...", bob);
        scheduler.schedule(WeekDay.THURSDAY, 14, 15, "Important Meeting", "IMPORTANT!!!", bob);

        // Charles's calendar
        scheduler.schedule(WeekDay.FRIDAY, 15, 18, "Leaving early friday lol", "", charles);
        scheduler.schedule(WeekDay.THURSDAY, 9, 12, "Doing things", "Things!", charles);
        scheduler.schedule(WeekDay.THURSDAY, 14, 15, "Doing other things", "Other things!", charles);

        // Shared meetings
        List<User> aliceBob = new ArrayList<>();
        aliceBob.add(alice);
        aliceBob.add(bob);
        List<User> allUsers = new ArrayList<>();
        allUsers.add(alice);
        allUsers.add(bob);
        allUsers.add(charles);

        scheduler.schedule(WeekDay.WEDNESDAY, 10, 12, "Coffee Catchup", "Catching up", aliceBob);
        scheduler.schedule(WeekDay.TUESDAY, 13, 14, "Interdepartmental Organisation Meeting", "Organising interdepartmentally", allUsers);
    }

}
