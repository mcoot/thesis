package scheduler;
import java.util.LinkedList;
public class Main
{
  public static final se.chalmers.paragon.runtime.Policy bottom = new se.chalmers.paragon.runtime.Policy(new se.chalmers.paragon.runtime.Clause(new Class<?>[] {java.lang.Object.class}, new se.chalmers.paragon.runtime.Variable(0)));
  private static scheduler.Scheduler theScheduler = new scheduler.Scheduler();
  private static scheduler.User alice = new scheduler.User("Alice");
  private static scheduler.User bob = new scheduler.User("Bob");
  private static scheduler.User charles = new scheduler.User("Charles");
  private static java.util.LinkedList<scheduler.User> aliceOnly = new java.util.LinkedList<scheduler.User>();
  private static java.util.LinkedList<scheduler.User> bobOnly = new java.util.LinkedList<scheduler.User>();
  private static java.util.LinkedList<scheduler.User> charlesOnly = new java.util.LinkedList<scheduler.User>();
  private static java.util.LinkedList<scheduler.User> alicebob = new java.util.LinkedList<scheduler.User>();
  private static java.util.LinkedList<scheduler.User> alicecharles = new java.util.LinkedList<scheduler.User>();
  private static java.util.LinkedList<scheduler.User> bobcharles = new java.util.LinkedList<scheduler.User>();
  private static java.util.LinkedList<scheduler.User> allUsers = new java.util.LinkedList<scheduler.User>();
  private static scheduler.Meeting meetingAliceBobAttend;
  public static void main(java.lang.String[] args) throws java.lang.NullPointerException
  {
    java.lang.System.out.println("Calendar scheduler" + "\n----------------\n");
    java.lang.System.out.println("Initialising system...");
    setupDummyData();
    boolean scheduleCheck1 = theScheduler.attendeesFreeAtTime(allUsers, scheduler.Meeting.getDayValue("Monday"), 9, 10);
    java.lang.System.out.println("Are all users available at 9 - 10 on a Monday? " + scheduleCheck1);
    boolean scheduleCheck2 = theScheduler.attendeesFreeAtTime(allUsers, scheduler.Meeting.getDayValue("Tuesday"), 9, 10);
    java.lang.System.out.println("Are all users available at 9 - 10 on a Tuesday? " + scheduleCheck2);
    java.lang.System.out.println();
    java.lang.System.out.println("Alice prints her calendar:");
    scheduler.Calendar aliceCal = theScheduler.getCalendar(alice);
    IOChannel aliceOut = new IOChannel(bottom, aliceCal.user);
    aliceOut.println(theScheduler.getCalendar(alice).getCalendarRepresentation());
  }
  private static void setupDummyData()
  {
    theScheduler.addUser(alice);
    theScheduler.addUser(bob);
    theScheduler.addUser(charles);
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
    theScheduler.addMeeting(alice, new scheduler.Meeting("Monday", 8, 10, "Coming in late", aliceOnly));
    theScheduler.addMeeting(alice, new scheduler.Meeting("Monday", 12, 13, "Lunch break", aliceOnly));
    theScheduler.addMeeting(alice, new scheduler.Meeting("Monday", 16, 18, "Leaving early", aliceOnly));
    theScheduler.addMeeting(bob, new scheduler.Meeting("Monday", 7, 9, "Long breaky", bobOnly));
    theScheduler.addMeeting(bob, new scheduler.Meeting("Monday", 13, 14, "Nap time", bobOnly));
    theScheduler.addMeeting(charles, new scheduler.Meeting("Monday", 10, 11, "Important Serious Work", charlesOnly));
    meetingAliceBobAttend = new scheduler.Meeting("Monday", 10, 12, "Catch up sesh", alicebob);
    theScheduler.addMeeting(alice, meetingAliceBobAttend);
    theScheduler.addMeeting(bob, meetingAliceBobAttend);
    scheduler.Meeting m = new scheduler.Meeting("Monday", 13, 14, "Alice's disciplinary hearing", alicecharles);
    theScheduler.addMeeting(alice, m);
    theScheduler.addMeeting(charles, m);
    m = new scheduler.Meeting("Monday", 9, 10, "Bob's disciplinary hearing", bobcharles);
    theScheduler.addMeeting(bob, m);
    theScheduler.addMeeting(charles, m);
    m = new scheduler.Meeting("Monday", 14, 15, "Departmental meeting", allUsers);
    theScheduler.addMeeting(alice, m);
    theScheduler.addMeeting(bob, m);
    theScheduler.addMeeting(charles, m);
  }
}