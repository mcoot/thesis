package conf;

/**
 * An author who may have papers submitted to a conference
 */
public class Author {

    private final String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        Author other;
        try {
            other = (Author)o;
        } catch (ClassCastException ex) {
            return false;
        }

        return other.name.equals(name);
    }

    public int hashCode() {
        return name.hashCode();
    }

    public String toString() {
        return "Author: " + name;
    }

}
