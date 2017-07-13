package conf;

/**
 * An organiser for the conference, who can see details as the conference is being organised
 */
public class Organiser {

    private final String name;

    public Organiser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        Organiser other;
        try {
            other = (Organiser)o;
        } catch (ClassCastException ex) {
            return false;
        }

        return other.name.equals(name);
    }

    public int hashCode() {
        return name.hashCode();
    }

    public String toString() {
        return "Organiser: " + name;
    }

}
