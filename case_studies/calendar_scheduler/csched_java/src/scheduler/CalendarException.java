package scheduler;

/**
 * Exception relating to the calendar
 */
public class CalendarException extends Exception {

    public CalendarException() {
        super();
    }

    public CalendarException(String message) {
        super(message);
    }

    /**
     * Exception thrown when an entry is invalid
     */
    public static class InvalidEntryException extends CalendarException {
        public InvalidEntryException() {
            super();
        }

        public InvalidEntryException(String message) {
            super(message);
        }
    }

}
