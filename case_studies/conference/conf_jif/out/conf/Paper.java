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
    public static final long jlc$SourceLastModified$jif = 1501499159248L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "pQRNa9u7QmQormvLbB58i8HGa7PmADze");
    public static final String jlc$ClassType$jif$1 =
      ("mJU3omTecnjcubUL3KHe32uv4JsU9cSdpli9uE3oSkQHIItYPZ8DzcDuXRne" +
       "3QPFHZaQ3yKaLfCLYGEmdiibTw1D2WcO+wBAEeu4nNVLeIDDM4eB+1fvZ5SJ" +
       "Ha5MZHX1igLE3KtXpCEgEzuCMkHB3KtXdh9eJnZ0KhOwOaGQ5/dYzX/HKwuZ" +
       "AJA9rH4iO5nIcEQaex6KZ4lMWBr98aMwmRjO5ns9DGWfTDh38qDjQVbvP3KZ" +
       "eNEvExnvn8bcY9LYq1nJBALEDrgCEDwmjQWPSRnYH10BCB6TxrzHpGT93Zxf" +
       "tRkc+KVg+uu20j1b++QP2jr/AP0RD/vnvgrYL6nxv/LFPeeS9L1ZwZUXYEm/" +
       "7B17n+TfQE14/h88//9nO80iBvOEC5eQP3t/9BB+WCFFfyW5Ufp8wvjKx/eN" +
       "2su+c532CyAuxO6ts+Zc/MVk+jOJ3QijV6+GSfNrhDyaPCIO8LuPI9KOZo+V" +
       "O3PMP3rfW3C880t/UBRyOuRZ3WA3Hbi4PWxv3fMzzo3ScmHNVc92FF6KP8NS" +
       "oJj1Rsq04AeVCyT7ewkw1ip6mkC/SR37jAw82v/Vc25Yfsc/smzz3Jq87xdm" +
       "/qEB+g2r/wPxhFp4NFsAAA==");
    
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
    public static final long jlc$SourceLastModified$jl = 1501499159248L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAOV8Ccw0aVpQ///uzOzJHsCyLrvLv7vDOkvvTt3d1TssWF1V" +
       "XUdXdV1dVV3FrGOdXXdV19Fd1bgGjQLBBA0uiAkQoxgFVjyiMYYQiVHU4EmI" +
       "R4yixHgEiQeIShSs7u/7j/nnn5+dCELwS96j3vN5n/c5O8/7feHnJs809eRe" +
       "VWbDPivbF9uhCpoXZaduAp/MnKbZjg2veN85BT7/R3/nu//imybvsifvigut" +
       "ddrYI8uiDfrWnrwjD3I3qBvC9wPfnrynCAJfC+rYyeLzOLAs7Ml7m3hfOG1X" +
       "B40aNGV2vAx8b9NVQX3d836jMHmHVxZNW3deW9ZNO3m3kDhHB+jaOAOEuGlf" +
       "EibPhnGQ+c1h8nsmd4TJM2Hm7MeB7xPunwK4rgisLu3j8LfFI5h16HjB/Slv" +
       "TuPCbydf9fiMByd+fj0OGKc+lwdtVD7Y6s2FMzZM3nsDUuYUe0Br67jYj0Of" +
       "Kbtxl3bygddddBz0lsrxUmcfvNJO3v/4OPmmaxz11itaLlPayZc/Puy6Ul9P" +
       "PvDYnT1yWz+3+dpv/8aCLe5eYfYDL7vA/8w46cOPTVKDMKiDwgtuJr7ja4Tv" +
       "ct73o996dzIZB3/5Y4NvxvyV3/1ffscnP/xjf/tmzFc+YYzkJoHXvuJ9v/sl" +
       "/+iD5CcWb7qA8ZaqbOILKbzq5NdblW97XuqrkRbf92DFS+eL9zt/TP1x65t+" +
       "MPjZu5O3cZNnvTLr8pGq3uOVeRVnQc0ERVA7beBzk7cGhU9e+7nJc2NdiIvg" +
       "plUKwyZoucmbs2vTs+X1e0RROC5xQdGbx3pchOX9euW00bXeV5PJ5LkxTd47" +
       "pmfH9LtuS72d6NSnX9aboF6NqzQvU6XX5UHRNi/rRfxyGwVN3LzsOU3wStN2" +
       "fjyOGOn7FuvX6itJHL7c1N7142XZGa/+xbGp+vVauL+c6J2nO3dGZH/wccbP" +
       "Ri5hy8wP6le8z3dL+r/88Cs/cfcB6d/iop287bLki9clJ3fuXJf6sgtP3NzZ" +
       "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" +
       "IE7hTiUFC+e1SZcsClnCEcRYV2kGXqHV");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "10YAAA==");
}
