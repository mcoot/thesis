package scheduler;

public final class Calendar {

    // The user who owns the calendar
    private final User user;

    /**
     * Construct a calendar belonging to the given user
     *
     * @param user the user for this calendar
     */
    public Calendar(User user) {
        this.user = user;
    }

}
