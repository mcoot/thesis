package scheduler;

import java.io.PrintStream;

public class User {

    public final String name;

    public PrintStream channel;

    public User(String name) {
        this.name = name;

        this.channel = System.out;
    }

    public boolean equals(Object o) {
        User that;
        try {
            that = (User)o;
        } catch (ClassCastException ex) {
            return false;
        }

        try {
            return that.name.equals(name);
        } catch (NullPointerException ex) {
            return false;
        }
    }

    public int hashCode() {
        return name.hashCode();
    }

    public String toString() {
        return name;
    }

}
