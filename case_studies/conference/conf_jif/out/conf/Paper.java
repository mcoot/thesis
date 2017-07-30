package conf;

/**
 * A paper which may be submitted to a conference
 */
public class Paper implements jif.lang.JifObject
{
    private String title;
    private String paperAbstract;
    private Author[] authors;
    
    public Paper conf$Paper$(final String title, final String paperAbstract,
                             final Author[] authors) {
        this.jif$init();
        {
            this.title = title;
            this.paperAbstract = paperAbstract;
            try {
                this.authors = (new Author[authors.length]);
                for (int i = 0; i < authors.length; ++i) {
                    this.authors[i] = authors[i];
                }
            }
            catch (final NullPointerException ex) {
                this.authors = (new Author[2]);
            }
            catch (final ArrayIndexOutOfBoundsException ex) {  }
        }
        return this;
    }
    
    public String getTitle() { return this.title; }
    
    public String getAbstract() { return this.paperAbstract; }
    
    public Author[] getAuthors() {
        if (this.authors == null) { return new Author[2]; }
        return (Author[]) this.authors.clone();
    }
    
    public boolean equals(final Object o) {
        try {
            Paper other;
            try {
                other =
                  Paper.
                    jif$cast$conf_Paper(
                      jif.lang.LabelUtil.
                        singleton().
                        toLabel(
                          jif.lang.LabelUtil.singleton().bottomConf(),
                          jif.lang.LabelUtil.singleton().
                            writerPolicy(
                              jif.lang.PrincipalUtil.topPrincipal(),
                              jif.lang.PrincipalUtil.topPrincipal())),
                      o);
            }
            catch (final ClassCastException ex) { return false; }
            if (this.authors.length != other.authors.length) return false;
            for (int i = 0; i < this.authors.length; ++i) {
                try {
                    if (!this.authors[i].equals(other.authors[i])) {
                        return false;
                    }
                }
                catch (final ArrayIndexOutOfBoundsException ex) {
                    return false;
                }
            }
            return other.title.equals(this.title) &&
              other.paperAbstract.equals(this.paperAbstract);
        }
        catch (final NullPointerException ex) { return false; }
    }
    
    public boolean equals(final jif.lang.Label lbl,
                          final jif.lang.IDComparable o) {
        try {
            return this.equals((Object) o);
        }
        catch (final ClassCastException ex) { return false; }
    }
    
    public boolean equals(final jif.lang.IDComparable o) {
        return this.equals(this.jif$conf_Paper_AuthorLabel, o);
    }
    
    public int hashCode() {
        try {
            int result = 19;
            result = 31 * result + this.title.hashCode();
            result = 31 * result + this.paperAbstract.hashCode();
            for (int i = 0; i < this.authors.length; ++i) {
                try {
                    result = 31 * result + this.authors[i].hashCode();
                }
                catch (final ArrayIndexOutOfBoundsException ex) {  }
            }
            return result;
        }
        catch (final NullPointerException ex) { return 0; }
    }
    
    public String toString() {
        String s = "";
        s += "Title: " + this.title + "\n";
        s += "Abstract: " + this.paperAbstract + "\n";
        s += "Authors: ";
        String sep = "";
        try {
            for (int i = 0; i < this.authors.length; ++i) {
                s += sep + this.authors[i].toString();
                sep = ",";
            }
        }
        catch (final NullPointerException ex) {  }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        return s;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1501296027523L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "N7jDvL/fXsE3KRYQUlTG66J20p2IDkAK");
    public static final String jlc$ClassType$jif$1 =
      ("eS1+CSMLux/M8u5HUNxnk8JWyWqFH+iKMrFD+XylUSgHzGFfABjCO5bwurcI" +
       "cGTmMHT/6mBWmbjfk4mcrl4xgIR39Yo2hGTi/rBMMDDv6pXTR5SJ+7uUCdic" +
       "UOnzWl4v755MAMhFvF6cm0xkOSJN/AKKF6lM2Dr78aMomRjO52uPQjkgE+6d" +
       "POho8Fo5epl4NSgTWe+fJrxj0sRvcpIJBEi84QlA+Jg0ET4m5WDveAIQPiZN" +
       "+I9J6frz3F+1KQn9cC/7sVl557a+hYO3LTzAfsTD+fWtIv7DZuKPbgnP+TR9" +
       "b2a/MVKEJfuyd+Igzb+BmvD8AZ7/f9HJsogSkXDREvJ7/28Qwg8rdLAfLW6U" +
       "/zJ+3PRde0ft4d+5zvgFEA/ioW2z517yyST2q4V5lNFrkZmFtaSAJY+IA/wM" +
       "44iMozlj5c8a/UWfh4tOcn94D4oBgg75VlfipQNrO6P21n2/qtworySXXbt7" +
       "44Ar8GdYilRrgdlh2fD7xkWy870EGKuTnSawb1In/kQHPjn41XNhWHHHP7Zi" +
       "67zagv9cmP2HBtg3rP4P+QX5g8NaAAA=");
    
    public Paper(final jif.lang.Label jif$AuthorLabel) {
        super();
        this.jif$conf_Paper_AuthorLabel = jif$AuthorLabel;
    }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Label jif$AuthorLabel,
                                         final Object o) {
        if (o instanceof Paper) {
            Paper c = (Paper) o;
            return jif.lang.LabelUtil.singleton().
              equivalentTo(c.jif$conf_Paper_AuthorLabel, jif$AuthorLabel);
        }
        return false;
    }
    
    public static Paper jif$cast$conf_Paper(
      final jif.lang.Label jif$AuthorLabel, final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$AuthorLabel, o)) return (Paper) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Label jif$conf_Paper_AuthorLabel;
    private jif.lang.Label jif$jif_lang_JifObject_L;
    
    public final jif.lang.Label jif$getjif_lang_JifObject_L() {
        if (this.jif$jif_lang_JifObject_L == null)
            this.jif$jif_lang_JifObject_L = this.jif$conf_Paper_AuthorLabel;
        return this.jif$jif_lang_JifObject_L;
    }
    
    private jif.lang.Label jif$jif_lang_IDComparable_L;
    
    public final jif.lang.Label jif$getjif_lang_IDComparable_L() {
        if (this.jif$jif_lang_IDComparable_L == null)
            this.jif$jif_lang_IDComparable_L = this.jif$jif_lang_JifObject_L;
        return this.jif$jif_lang_IDComparable_L;
    }
    
    private jif.lang.Label jif$jif_lang_Hashable_L;
    
    public final jif.lang.Label jif$getjif_lang_Hashable_L() {
        if (this.jif$jif_lang_Hashable_L == null)
            this.jif$jif_lang_Hashable_L = this.jif$jif_lang_JifObject_L;
        return this.jif$jif_lang_Hashable_L;
    }
    
    private jif.lang.Label jif$jif_lang_ToStringable_L;
    
    public final jif.lang.Label jif$getjif_lang_ToStringable_L() {
        if (this.jif$jif_lang_ToStringable_L == null)
            this.jif$jif_lang_ToStringable_L = this.jif$jif_lang_JifObject_L;
        return this.jif$jif_lang_ToStringable_L;
    }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1501296027523L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAMV8CewseVpQvze7szt7sAcsx8Isj91hmbV2p7q66+ja2VXq" +
       "7Lq6qrq7qqu72GWss6u6zq67ClcRFIggGlgQoxBjQMWsq8EYY4wJMV4EPONF" +
       "jEKMiRokEaNoIqDV/f+/c9683YkY3uR39O/87u/7Tb76f+FXJ28ti8m9PIv7" +
       "Y5xVr1R97pWvqFZRei4VW2WpjQOvOT8CgJ//E9/+3p95bvIec/KeMN1WVhU6" +
       "VJZWXleZk3clXmJ7RUm4rueak/elnuduvSK04nAYF2apOXl/GR5Tq6oLr9x4" +
       "ZRY3l4XvL+vcK6533h+UJu9ysrSsitqpsqKsJu+VTlZjgXUVxqAUltWr0uR5" +
       "P/RitzxPfv/kjjR5qx9bx3HhV0v3sQCvJ4LsZXxc/o5wBLPwLce7v+UtUZi6" +
       "1eQbn9zxAOOXxHHBuPVtiVcF2YOr3pJa48Dk/TcgxVZ6BLdVEabHcelbs3q8" +
       "pZp88A0PHRe9PbecyDp6r1WTr31ynXozNa564UqWy5Zq8oEnl11P6orJB5/g" +
       "2SPc+lX5Uz/4HSmX3r3C7HpOfIH/reOmDz2xaeP5XuGljnez8V2/S/pR66v/" +
       "1vfdnUzGxR94YvHNmr/++37tWz/+oZ/9Bzdrvv4paxT75DnVa85P2l/xT7+B" +
       "+hj+3AWMt+dZGV5E4THMr1xVb2de7fJRFr/6wYmXyVfuT/7s5u8dvvMver9y" +
       "d/IOfvK8k8V1MkrV+5wsycPYK5Ze6hVW5bn85AUvdanrPD9529iXwtS7GVV8" +
       "v/QqfvKW+Dr0fHb9PZLIH4+4kOgtYz9M/ex+P7eq4Nrv8slk8raxTN4/lufH" +
       "8m23rVpNdOaTn9FLr2DHU8rP0JlTJ15alZ/R0/AzVeCVYfkZxyq918qqdsNx" +
       "xSjft1S/dl87hf5nysK5/viMao2sf2Ucyv9/HdxdMHp3e+fOSOxveFLx41FL" +
       "uCx2veI15/M1yfzaF1/7+bsPRP+WFtXkHZcjX7keOblz53rUV1104oZnI8Wj" +
       "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" +
       "5RW5wYlAnFYVDFrzertWiELxodyOhRY+");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "zm8U9v8CQxIy9VNDAAA=");
}
