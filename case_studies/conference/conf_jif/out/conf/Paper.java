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
       "oGlte1eIDMU1bZnNg28x2Hh11hyAxxuy");
    public static final String jlc$ClassType$jif$1 =
      ("8kaUzJsOjju3dIE71Pt77RV8k6KeuNMUqxe1CV2J6ABkIavncaAZ2L0jw7u7" +
       "objdEvJbRLMFfhEszMQOZfOpYSj7zGEfAChiHZexejEPcHDmMHD/6r2MMrHN" +
       "lYmsrl5RgJh79Yo0BGRiW1AmKJh79cruw8vEtk5lAjYnFPL8Lqv573hlIRMA" +
       "sovVj2cnExmOSGPPQ/EMkQlLoz9+FCYTw9l8r4Wh7JMJ504edNzP6r2HLhMv" +
       "+WUi4/3TmHtMGns1K5lAgNg+VwCCx6Sx4DEpA/uLKwDBY9KY95iUrL+b86s2" +
       "gwO/FEx/3Va6e3Of/EGb5+2jP+Jh/9xXAfslNf5XvrjnXJK+Nyu48gIs6Ze9" +
       "Y++R/BuoCc//g+f/37XTLGIwT7hwCfmb90cP4YcVUvRXkhulf0wYX/nYnlG7" +
       "2Xeu034BxIXYuXnW7As+nUx/JrEbYfSqVTBpfo2QR5NHxAF+93FE2tHssXJn" +
       "jvm29z0FRzu/9AdFIadDntUNdtOBC9rD9tY9P+PcKC0TVl/xTEfhxfgzLAWK" +
       "WW+kTAt+ULlAsr+XAGOtpKcJ9JvUsb+TgUf7v3rODcvv+EeWXj+nJu/HBZl/" +
       "aIB+w+r/AB9PffA0WwAA");
    
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
      ("H4sIAAAAAAAAAOV8Ccw0W1ZQ///Me29WZoGBYWCGf5jH+IaeedVd1dVVNY/F" +
       "6tq6qmtfurp73vCsrn3p2qu6qnAMGgWiCRgcFBMlRiEKjKBEQgwhEiOIwQ1C" +
       "BGMUJcQlSBB3jYrV/X3/8v73v595UcTol9yl7rnLueeec+45nXO/z/3a5Jmq" +
       "nNzLs6T3k6x+se5zt3pRtsrKdYjEqip9bHjF/s4p8Nk/8Q3v/uE3Td51mLwr" +
       "TLXaqkObyNLa7erD5B0n93R0ywp3HNc5TN6Tuq6juWVoJeEwdszSw+S9Vein" +
       "Vt2UbqW6VZa0l47vrZrcLa9r3m/kJ++ws7Sqy8aus7KqJ+/mI6u1gKYOE4AP" +
       "q/olfvKsF7qJUxWT3ze5w0+e8RLLHzt+MX9/F8B1RoC+tI/d3xaOaJaeZbv3" +
       "h7w5DlOnnnzF4yMe7Pj5zdhhHPrcya2D7MFSb06tsWHy3huUEiv1Aa0uw9Qf" +
       "uz6TNeMq9eQDrzvp2OktuWXHlu++Uk/e/3g/+QY09nrrlSyXIfXkfY93u87U" +
       "lZMPPHZmj5zWr4lf823fmK7Tu1ecHddOLvg/Mw760GODVNdzSze13ZuB7/hq" +
       "/o9bX/zj33p3Mhk7v++xzjd9fvT3/sbv/viHfuKnb/p82RP6SMfItetX7O85" +
       "fsHPfjnxMexNFzTekmdVeGGFV+38eqryLeSlLh958YsfzHgBvngf+BPqT+2/" +
       "6fvdX707eRs7edbOkuY0ctV77OyUh4lbMm7qllbtOuzkrW7qEFc4O3lurPNh" +
       "6t60Sp5XuTU7eXNybXo2u36PJPLGKS4kevNYD1Mvu1/PrTq41rt8Mpk8N6bJ" +
       "e8f07Jh+z21p1BOD/OTLRuWW9DhL9TKZ2c3JTevqZSMNX64Dtwqrl22rcl+p" +
       "6sYJxx4jf99S/Vp9JQq9l6vSvn68LFvj0b84NuW/XRN3lx2983znzkjsL39c" +
       "8JNRStZZ4rjlK/ZnmxX1Gz/4ys/cfcD6t7SoJ2+7TPnidcrJnTvXqb7oIhM3" +
       "ZzZSPB4leRTWd3xM+zT3e771K980Mkt+fvNIr0vX5x9n3YcCz441a9zAK/a7" +
       "vuVf/scf+uOfyR4ycT15/jWy9dqRF9n4yse3VWa264y65+H0X33P+pFXfvwz" +
       "z9+9HPRbx+3U1sgUo/x+6PE1XiUjL93XNxdS3OUnb/ey8mQlF9B9JfG2Oiiz" +
       "88OWK73ffq1/wW+Of3fG9D8u6cJOl4ZLOSoV4paV7z3g5XqSSb/8zd/xyf+d" +
       "bEA8AGp9VbunC0d8cg7OPw7OPgEu8hvmuBznYyS8KtOv1fI//Yt/919Bdy9b" +
       "v6933/WIgtbc+qVHZP0y2TuuUv2eh9yhl6479vvH3yX/se/8tW/51JU1xh4f" +
       "edKCz1/yC2GskSBZ+Yd+uviHv/RPvufn7z5kp3rybN4ck9C+Yv7l40QffbjU" +
       "qAaSURWNmFTPG+kpc0IvtI6Je2HN//aur5r/yL/+tnff8FcyttycVjn5+G89" +
       "wcP2L11NvulnvuE/feg6zR37cg09JMfDbje67QsfzoyXpdVf8Oh+/8998E/+" +
       "TetPj1py1ExVOLhXZXPnVlouSL23nnzBeEwvXi6cF3nr6CbXzX78Cvxd13x6" +
       "YaLrkMkVNrtkX9ZdYe+7tr+jeq36py/36EOZOACf+1MfIL7uV697eSgTlzk+" +
       "0L1WWWytR8QV/P7Tf7j7lc/+5N3Jc4fJu69XuJXWWytpLod9GC/hirht5Cfv" +
       "fBX81Rfqze3x0gOZ//LH5fGRZR+XxodKaqxfel/qzz0qgLcafPJVY3rLmH7i" +
       "tvyLF+i780v+nu7O5FpZXod8xTX/ykv2VfdZ7rm8DNtRQm94rp48U4d14t4/" +
       "q3dfT/l6WDfWwY1MXXLw1Vh8YkxvHdOv35Y//wQsvu51sLhUP3kfgXfmF1WM" +
       "H0dlaNlXRv6a1130a8f09nGC2W35zBMWJT6fRZ+zmtE4KqvqtcbIlbtv7IV/" +
       "87lf+tWfe+cHf/CqaN98HBXV9VAet+Jea6S9yva6rvnWBxu5HNnkQ2P6nsnk" +
       "y4zb8uvrif6/U1UKI/ff3sS/LfN29xnm7dfbFL+h5n1pflQBgJeMu3848pMP" +
       "5+6l+tGRGb0wtZL7h/Rs4qZ+HTxB+OUyPI1aur21/dxv/ewf/s0Xv+2zdx8x" +
       "kD/yGhv10TE3RvJ1obddV+vGVT78tFWuI+h/8UOf+bG/8JlvuTEg3/tqc49K" +
       "m9Nf/Af//W+/+F3/9G89we5408gllw+2e0Cnuzebv0/LL3wofESSpe5FW9+H" +
       "3ZgoYfbiA99kBHavoXg5+YrHNiFcOfGhsvs+4XN/i/mo/R13J296oKde40y8" +
       "etBLr9ZObyvd0RdK9VfpqC+9OebrBi/Zh5+i4L2nwK4263h8z9gXCjxBLd3o" +
       "2O4RFXFzfndG3fYM9OLiRejynTyZz950y2fPVlcn8PKl3ee2L4kS+/n7hsx2" +
       "9AjHq+/5kdUf10j3lxtp/QUP0eKz0ZP6I7/yR//2t3/kl8bD5ybPtJf7YeSS" +
       "R3AXm4ur+c2f+84Pvv2z//SPXC2B8dA+/V3qv/37l1mvt9XoZHzggomWNaXt" +
       "8lZVC9er23UuyFxRMG459lLs6tEAyF6lpx/Q495kvahY/P6fMEOJnW+oxwwT" +
       "emotwtRA4IvAD/3YzoK1KhCURq4IDqe6bLPWZz0lpm4iOWeUSmQ3L4UjzUHL" +
       "foGD4+WfhWHTFjPAnFLrftMtl0i2QdbLtnXdhmmaYgm1bQkUzbKRT/se3yZe" +
       "G2Jb2dnNtwA0hyBsO7jnBbtWBtJc743ChOd0kffgMec3JryNVEHaMmWhtaW2" +
       "lSJMNtvdLLCdJTJ1Ep09qmRP70R3FmhHWC0CheoO/KEITKKqMxMQjZSBTc7q" +
       "ad6s1Iip0aAIgqWS6HalJJaa1H4KsMY4kF9sLJXRk5Cz7ILfzOis3huaqIcH" +
       "a+QE8+R0TeKeQvZomayWJ7VqFhaXxzndVbXicfPzvG4OG4U0qkWR7f0hLcp9" +
       "LlVJbfbOsDsXx8GhJB5EmQ5z1tRCSKBxRnkjJh3i1Riyn228VcHIcdEPKtWo" +
       "m1KLVW+VU+sC7Iu5WJ1oSe/1WGVlhe9TPtTLg0GpW9MwllYVM5mzMpJQpTfg" +
       "joWT4TAX9WTGrxVdiin1EOnH4qy6yUbLCZUXpkMCk/uyyouzDG3LbWUkeWgI" +
       "jpAQydymkb1iQkoMHyzxkDDKkWPcQxyfcX53VoYg54dQcQgmcIvZsICNfht3" +
       "KufPV6xkuZte2ybOwQo4zlXKGpwluEHxcYZYZHxWcs0MjTZW42qPSNhOm0/V" +
       "nb9lCZzoAnw9PUa+tthu1GhW2d4ZEeR056zs06HXojDl8IT2SJmbkaRnrAbY" +
       "PB5iTtJ0nEbWST1EenSe2U3kx/iSBFbzPJ25jUzqlimtZYRZY0FszU6ONJtz" +
       "hyooktIAsd1w6vfVwAlaQZyKGEeHWalOmfZgAhsQMkMTlxzKpZPCg/rwmMpp" +
       "2qpOe4oKkcDMKtyK5G6rNVqWLrX5MssKBvRYzYlx2opNolHjzOe97bmGYT5h" +
       "NLuYOQY8VH1ynBsbKYxBmEkXJ47JTsqZ4NDRZo5Pg4kwjlPT5bnZznYrgpEB" +
       "vKFhcroDCOyE6R1/oh24Lzg4P3VGvF0L6sG0EqbYhgrbnnLHoJO4rorTPux1" +
       "NVnV4gbeKhqOhrP9UEzFgKXXG9UyosV+y9QaHXhaXs7Ow/YsLfsMWeRssCIR" +
       "jZ8WxUzlD6esEBRXnGVHY6kL0/bYdlPLj6bZ2Uxq3AnCgWb3W3bFegU55CvX" +
       "2GdtNmR8Seey7Rmp7pSou6MFja2mWWYrIZCZTd+lqtn4iRuVB4lN5HlXlPAC" +
       "UhJSX8w2kFqwpK6UsLnv8m0xpy1nlH2toz3Qycu4FzSRE+llsIpUOelIhvL3" +
       "tL5C566iCzZur6oNTVVxi04DkznkUwkDpnMULrenos6TBNcEfLXSaNLfR0BN" +
       "GqBGoUrcVILHdF57hLrxjBKjJ2jTtwaRDSuSHWRbXjjr2K7r7ByUS8My58vz" +
       "obTYTTlKpsM7FsmANLjgiJnaeNOOajBlpW7RBODRTcdbvUucpvJss670hcGC" +
       "EnxcqaWz2e2WeTtrvQjvNrHqTLF+jULOvEp2Eqgo+xLHCm/AdmGTiaZ2xKCy" +
       "b7DEPpKQUqkrKpQNi9G3PnFQzG5l6yWlc15TeHV99DywzYv5ykBCJKK2nFRo" +
       "EiSxBe0shYXpjNTWp6ypmfsj7HLkkc03yCpfzfv+kIDDloqLgY2sXKgi2IFA" +
       "aZ0CQDdtl0aUKJrSJEXICMjujNcQxC5tjh5gAIB3uM2Fm5UOiTmcWlHQsqwz" +
       "1fMgZJoVOVg8gJCVVEMh3LCjfjgNiWr2Zgjv45BkcMqCN5mrlY2d0Udsfpoh" +
       "I+Kta7t1z1PEHEdCLKW2yvkU4QI/hVZzGEKrgAXO/LmL4OF0nJM0bPZ8RyPl" +
       "eSFRNExovLJhoLJ2WxhfSCVWEIra72gq29OiFgUWZcDHRcOyG2e2z1Tl3J36" +
       "mbuNQ0LGFPS8k+0M6llUVvpj2q6jsIKiTom1kzpjQc6Q1aPK0EujT7Zbm1uA" +
       "KtIko1zOjP3CUM0g92dbd8MVaybvYHsAU4ME5LyfGYTETudMnUkLCYwMpSLN" +
       "DTdfqHs3iLZnhDH0XQFL5LkJUC7GUm0ZktujUwT1MtTWtG3SXRmNwhItWoZK" +
       "Fd82mm67Gv1ynt4CnH/KNowdsrUIpiwMlUrvZettlodlh5L7vMPNdQYuwNHJ" +
       "KVVC12yo54+c2uemMT1PDXGHySPlopYkVlBhuzuIPiyWuodksx5Wkdjp2UE9" +
       "SjTDrrFluWQiE3UluJf6IOawdhn0cQXtWtnHYSlLpwkXiiK0jJQVABMb22iz" +
       "oKhO9nmYV8jS5TmpA+AcwA4Y0uuJNxjCPKSyDJnZ6tTEpMLNq+5ME67FST0J" +
       "kaxOdx1E60lvaLBwqPnK5f09SduacXAwKFH8rF97Ap7KBrrexujqkO7nU/F4" +
       "NkTEY0yRy07FsgMKAJKhtkp3LYK6iGFAyc7xgDiSV8uk2e68HbCWkxDWfCAi" +
       "cAM+MJbNg/NwGnbHE5LFrGvbRiaEinfSpsVGJ2VS01AxrPf7UXP1gOwyfak3" +
       "PGETsziddudtifmwz+blEcoRxJ6zXAukgXg6hiwuH3qaFQ6HtQKNsqQUS1Gr" +
       "OcM03QXl9XS/BmQUByJ8JhorudrMgwWz80Jt1ipw2SGgl+teVSqlwI1XoKfV" +
       "kmqGIicxOhYAos91i+lxpMbOyJhFNJqLbM1Fq2gvsEwcb3xBaTj9xBZhawh9" +
       "KuBIEGUHOjJtKp4nWFk5ijLsOFz3G3JDqhZEmYfTtnM48rQ0ZsopTsyk72R8" +
       "bkj8xqUtaN8O02hfAbyX5ZCylWYJMlcZTpeEljo3FJjGVIDIXbwTA4tXD94J" +
       "Bvlsf9rnFGHKrcMF3r4V3X6aG6v2ODK/uF+C21aZH6v8WFmHxhVgJeQhGjKl" +
       "nTeA0so1Z34tArlwKAtkpJYpr/kaE5OMgNoAy5z63HcBsfKWc2DT9kXcOaBP" +
       "YLGa7UttEdTbncskRLywF3rI6CmHefSBxYWUlgqB6KbqOVhUOHJuZ3MInLpo" +
       "461H7l8T+Ir0OGZlLdBURmwMq3lUPdTj5bhPVnsJVg3O7dwZUuGgvHBTVpFt" +
       "JB4ZUSqVBX4K1HPL2T5mhPq5WRGtQi8U1vFRu+NkHLR3U5YCMX4prNUB75bF" +
       "PCctzTycdxuQ72mvPa3raLkrxViDh0Oj+t5MX2eHo0FMbSrjFeqQnJR9WLTT" +
       "uQ14BDhXIWOk9LLuuRNHS7UDQPC0czYl1KbNgbBB2QS8I9gzhTpDdzW8dnbt" +
       "0POq4/cDeM7EcrvRgkTebzloJrZbRWe5xki42aIM/DhuguUKD/0KFTI12Xeh" +
       "DsERPpyFQQGbQYilpZVZu72VlqTr6diJXSm7BnSldRB1y+l0TelUNVuze4Ra" +
       "qf5pqDV1SogndNGQQOXKdQQgioVFzqhnUnFFpWHM4B5mt80mTUGrJvX1qAx1" +
       "3hNTOj9asnwSrSHK3XRlBgPO7AllBZWgsC6IMyDaOGmreRdIlpN2kgedyYXB" +
       "1O3GX68lIMugQ3EmqjI9KfNsDu+AHYCtTL/kd83MiOP4MBul9HTYS7HMlkiv" +
       "8supO6dd0wny07QPStYRu+02lfdqkdVlMRBVXu+ZsDVBTVzYfM6pIqG4U5gp" +
       "+ypOtllVnqZVrvRlXvVbYQnzQ77UY3C0z1Gv3u/sreg7Yq1QCqikFEaTbhgp" +
       "mIiZ7mwZ7E/wsnLXa90rjk7rZdVJmjGgu0eNIeZyJ07gRYGO3A2jxQlydMSO" +
       "gugsQMB52VeOKQ8clPK7qNFFRtP0LiRTZJetHYeYKjI4TSvsgPjtECRCp0Ax" +
       "TOP7XO3XMupxHSn6a04tJModJLQ5TzeprSy1ZWEm65HnykScA1tWXeFExtDw" +
       "vgAzhhj2jBwc7EPibr1Ymp5wgTCr+fZAm+fKIj1Y6s5pcozafFTnbTVUApFa" +
       "rTOfbsF01NOovqo870QS7F5ez4KKScmaXWyhMscapJvadJAffbud8+B0VLWH" +
       "2EcRZ7MGweluCyN+4nmj+YjyylbzgCA2YSQb+DWPMnC8YKIz18kUGVvrDR4w" +
       "EDJe3jW4TsPSCTJrdYL1Tm3pCheKKOgxZ7TZsGYRSkhozE/N0p8tI0dG8GSB" +
       "ImhODx6atGrr442IlEjp58gUi1psSWiQBTrGcVmnhu2z3VGaE27JexFZbNaW" +
       "3hOyiDLkLhrmOsQfIJgwvO0g+V24zPRphMwAV/BpntEo5gCoxT61soXdTVcd" +
       "WW3PTDeryzTN0OMUBuxzx5Q5k5QoISWso8jxiQOKzUC4WrRwT9bBPNVrwkyj" +
       "dYdZXgqVWJcSU6rJBWWPLDnU4GAxZwRvXfJNtG9PoEzKM9fEOu4IES20YGlJ" +
       "lKdMqqKju6BmXg6MpkHXUhhEtYhXnFJ4cKMpeA51fJG6Hq4H7lCspGI3D4hI" +
       "8rFTtCuW/DHkxSZoOJHZCU2PkQK65heInMnd9ExsXELRRAZj5T5gKBo4iDPK" +
       "UeddKqlLdMoGWqIhmO1k2z5GM94MyWAYVqOr0oCSa4DJ2TudGZdrlBTQif1x" +
       "W5LobC6l+C49wkEBwzLAzQOMRoZ5cHS8fBEnGnXgOM7J6vhMEg3WKSQKLnzY" +
       "hNBeRKRzwKYuyuDzFNihXlDTcqttV0FWUzMQ5hW8bahWpZWScGW/kFgApccl" +
       "2nK9mGsCzR6zQ4bI9axj5RVQRcVhgKjRXTsRGhWe+Zke1HrAMnxbsuleWvSs" +
       "cVbQzb6yh2nesKMlKK/88HzC4XplTbEVqYLKjGMdNF5F8ZJczb0mZQWc6uK1" +
       "MV4zoS/bNJlrhZLFG9iGjZ2mFouMP/CRj2TSWnHSysoCnCYJyYdDx8bI3dzo" +
       "xstw1u3X57VtkNMATmwIniVVLNC8vaBzAJcWseDqCzvcn7GVsVzPoxNh6/vF" +
       "CfcZEKvJBHHJc8wdiBxoNReD2UAYWrIa7zO1wSBXMpAMX+sLAGKPLlsIQzDa" +
       "8KxdGBvUhtPczY57XUc3HMg34pnDS8CuE0C26tTueLqxcp9M3B1bW1IDh8OC" +
       "i2AdgMNwHdOkxzMSdTIhZrnNYrwfrWnbAuqIgvI9t3WCUjpWoavpjQBSab5X" +
       "dAhNSMENzztBPsyTRaJsjYqsVyaoz49UtcitjrbgHZ9UBVcFplVZZ0GpUUrb" +
       "Qp2yNa0uPzEqBwQK61Yxh+SVXBXBmRDXHHZCQNTAg12nCXIekI6Al2qdyIXj" +
       "MaKO9jvdOQnhTPE4/9C32UI5wM5MPxh44jjwFErqNnO6LBnNUtc1XUoFJPm8" +
       "aQXsRME9Ok+J0fz3YJ5c41PNKRD4CE1hUSBpBNWoJbdVUmdLdeKWrRdrSikq" +
       "OhZAc1DmM2s5FKTZ4+GGLTYiVGbCniiAtZBah5JZELMclIRkWDknJbL2y+m+" +
       "WtQE4+ywHJfOkE5gVChSU4xZJmuBz+S1duqxlF6xVWRDltmNzqFY1nYdAERx" +
       "Mrt6Px4cWWOZ2IrbJjj3MUf1BCCw5zbpLeCggmgQGgV9Ppf9br2YgQJFUUV3" +
       "PseCXzFr+NgoAdxMzSV2EORTx3XHDqvywTJGbxQ8RXM5gY/8hjnQqHXKnEWz" +
       "ElM+xDkA7Xxsl6K2umK6w6mBB4RXiD4UdwNw3JcQNdqhHi7NMok94imsgVop" +
       "h4qv5sq68k6GwCmy2vc7ID9LZnNItYwN");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "PNNGAAA=");
}
