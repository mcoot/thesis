package conf;

/**
 * A paper which may be submitted to a conference
 */
public class Paper {

    private final String title;
    private final String paperAbstract;

    private Author[] authors;

    public Paper(String title, String paperAbstract, Author[] authors) {
        this.title = title;
        this.paperAbstract = paperAbstract;

        this.authors = new Author[authors.length];
        for (int i = 0; i < authors.length; ++i) {
            this.authors[i] = authors[i];
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAbstract() {
        return paperAbstract;
    }

    public Author[] getAuthors() {
        Author[] copy = new Author[authors.length];
        for (int i = 0; i < authors.length; ++i) {
            copy[i] = authors[i];
        }
        return copy;
    }

    public boolean equals(Object o) {
        Paper other;
        try {
            other = (Paper)o;
        } catch (ClassCastException ex) {
            return false;
        }

        if (authors.length != other.authors.length) return false;

        for (int i = 0; i < authors.length; ++i) {
            if (!authors[i].equals(other.authors[i])) {
                return false;
            }
        }

        return other.title.equals(title) && other.paperAbstract.equals(paperAbstract);
    }

    public int hashCode() {
        int result = 19;

        result = 31 * result + title.hashCode();
        result = 31 * result + paperAbstract.hashCode();
        // Assuming order of authors matters
        for (int i = 0; i < authors.length; ++i) {
            result = 31 * result + authors[i].hashCode();
        }

        return result;
    }

    public String toString() {
        String s = "";

        s += "Title: " + title + "\n";

        s += "Abstract: " + paperAbstract + "\n";

        s += "Authors: ";

        String sep = "";
        for (int i = 0; i < authors.length; ++i) {
            s += sep + authors[i].toString();
            sep = ",";
        }

        return s;
    }

}
