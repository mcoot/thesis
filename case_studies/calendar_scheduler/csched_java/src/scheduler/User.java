package scheduler;

public final class User {

    // The username
    private final String name;

    /**
     * @param name The username for this user
     */
    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof User)) return false;
        return name.equals(((User)other).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "User: " + name;
    }

}