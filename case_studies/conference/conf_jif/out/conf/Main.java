package conf;

import java.io.PrintStream;
import jif.runtime.Runtime;

public class Main {
    private static ConferenceSystem conferenceSystem;
    private static Paper[] papers;
    
    public static final void main(final String[] args) throws SecurityException,
        IllegalArgumentException {
        final jif.lang.Principal p = Runtime.user(null);
        {
            PrintStream out1 = null;
            try {
                Runtime runtime = Runtime.getRuntime(p);
                out1 =
                  runtime ==
                    null
                    ? null
                    : runtime.stdout(
                                jif.lang.LabelUtil.singleton().noComponents());
            }
            catch (final SecurityException e) {  }
            PrintStream out2 = out1;
            PrintStream out = out2;
            if (out == null)
                throw new IllegalArgumentException("Out is null :(");
            out.println("Conference system" + "\n-----------------\n");
            out.println("Initialising system...");
        }
    }
    
    private static void setupDummyData() {
        Main.conferenceSystem =
          new ConferenceSystem(
            jif.principals.Organiser.getInstance()).conf$ConferenceSystem$();
        Author alice = new Author().conf$Author$("Alice");
        Author bob = new Author().conf$Author$("Bob");
        Author charles = new Author().conf$Author$("Charles");
        Author dennis = new Author().conf$Author$("Dennis");
        Author eve = new Author().conf$Author$("Eve");
        Author[] allAuthors = { alice, bob, charles, dennis, eve };
        Author[] authorsABC = { alice, bob, charles };
        Author[] authorsDE = { dennis, eve };
        try {
            Main.papers = (new Paper[3]);
            Main.papers[0] =
              new Paper(
                jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.singleton().
                      readerPolicy(jif.principals.Organiser.getInstance(),
                                   jif.lang.PrincipalUtil.bottomPrincipal()),
                    jif.lang.LabelUtil.singleton().topInteg())).
                conf$Paper$("A Paper We Did Together", "We all did it :3",
                            allAuthors);
            Main.papers[1] =
              new Paper(
                jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.singleton().
                      readerPolicy(jif.principals.Organiser.getInstance(),
                                   jif.lang.PrincipalUtil.bottomPrincipal()),
                    jif.lang.LabelUtil.singleton().topInteg())).
                conf$Paper$("An Excellent Paper", "Truly excellent",
                            authorsABC);
            Main.papers[2] =
              new Paper(
                jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.singleton().
                      readerPolicy(jif.principals.Organiser.getInstance(),
                                   jif.lang.PrincipalUtil.bottomPrincipal()),
                    jif.lang.LabelUtil.singleton().topInteg())).
                conf$Paper$("A Terrible Paper", "This paper is bad", authorsDE);
        }
        catch (final ArrayIndexOutOfBoundsException ex) {  }
        catch (final NullPointerException ex) {  }
    }
    
    public Main conf$Main$() {
        this.jif$init();
        {  }
        return this;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1501402334819L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAO08aXQVVZr3FVkIW9gJEDBAQIOQAAIqwQUCgcCDpElQiWlD" +
       "pV4lKXjvVVFVL3mBphvpEWxQPB3BpW1snUFHbRoc9+PWSo+CY4ttt91u436m" +
       "xw0HPdOtzrQ69/vufbXcqiSPOTi/hnNyb71b9/vud7/9LsXBEyTXMsmEDVpr" +
       "ud1lqFb5Cq21TjYtNVanx7saaFOz8tXtv43dtM54WyJ5jaS/Zq1NWnKrGiUF" +
       "cspu103N7rLJ0OgGuUOuSNlavCKqWXZllAxU9KRlm7KWtK1N5IckEiVDNdoi" +
       "J21NttVYtaknbDIpatCB2uK6XaGm7QpDNuVEBZJSUVcVly2LYsrD1gyS/oap" +
       "d2gx1bTJGVFKOO8dl1vUeEUdfxeFX5Vpk5Rk0PP5sckhZja7fWdX7L3xiqH3" +
       "9SOFjaRQS9bbsq0pVXrSpvQ0kkEJNdGimtaiWEyNNZJhSVWN1aumJse1zbSj" +
       "nmwkwy2tLSnbKVO11qiWHu+AjsOtlEFJhDEzjVEyiLEkpdi6mZlOXqumxmOZ" +
       "X7mtcbnNssloly1setXQTnkxgLJTNVtlRc2A5GzUkjHghQDhzLF0Je1AQfMT" +
       "KpWXM1ROUqYNZDiTXFxOtlXU26aWbKNdc/WUDQwe1yPSShCErGyU29RmmxSJ" +
       "/erYK9qrABkBIDYZJXZDTFRK4wQpeeRzYvXCPVuSy5MS0hxTlTjQ358CTRSA" +
       "1qitqqkmFZUBDpoevUEe/cTVEiG08yihM+vz8A8+u3jGxKeOsT7jQ/rUtmxQ" +
       "FbtZOdAy5KXiqrLz+zEV1C0NhO+bOSp/HX9TmTaoYY12MMLL8szLp9Y8u27b" +
       "PerHEhlQQ/IUPZ5KUD0apugJQ4ur5jI1qZpgIjWkQE3GqvB9Dcmnz1EtqbLW" +
       "2tZWS7VrSE4cm/J0/E1Z1EpRAIvy6bOWbNUzz4Zst+Nz2iCE5NM/Moz+5dG/" +
       "dbyutUnD0gVNay3VrKZYrKYlupJKqNSAm9YmtSa7XbU0q0mRLbXZslMxjfag" +
       "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" +
       "7pFGNtxcG83/9jLn8kiohNhNr/8BjDNEnL1DAAA=");
    
    public Main() { super(); }
    
    public void jif$invokeDefConstructor() { this.conf$Main$(); }
    
    private void jif$init() {  }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1501402334819L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAM17a8w0aVZQf9/OzuwOe0fYZdnLsDssO/Qy1dVV1V29I4Tu" +
       "qurquld1VVdXFQNDXbvu9+q64BogkSUQUdcBQWET425AXNhoRE2EhD8qCDGR" +
       "eI1RCNEoIon8UP+gWN3v+93e+Xbwhxjf5Ln085znPM85zznnOSd13i/93uSt" +
       "VTl5Ic/i/hRn9ct1n7vVy6JZVq6DxWZVKePAa/aPToHX/9J3vedvvWXybmPy" +
       "7iCVa7MObCxLa7erjck7Ejex3LJaO47rGJP3pq7ryG4ZmHEwjIBZakzeVwWn" +
       "1Kyb0q32bpXF5wvg+6omd8vrng8G2ck77Cyt6rKx66ys6sl72NA8m0BTBzHA" +
       "BlX9Cjt51gvc2KmKyZ+e3GMnb/Vi8zQCfi37gArgihHYXsZH8OeD8ZilZ9ru" +
       "gyXPREHq1JOP3l3xkOIXmRFgXPpc4tZ+9nCrZ1JzHJi87+ZIsZmeALkug/Q0" +
       "gr41a8Zd6skHvyLSEehtuWlH5sl9rZ584C6ceDM1Qr39ypbLknryNXfBrpi6" +
       "cvLBO3f22G39Hv8nf+R70l16/3pmx7Xjy/nfOi76yJ1Fe9dzSze13ZuF7/hm" +
       "9sfMr/2lH7w/mYzAX3MH+Abm7/6p3//2T33kl3/lBubrnwIjWKFr16/ZX7De" +
       "9U8/hL20esvlGG/Lsyq4iMITlF9vVbydeaXLR1n82ocYL5MvP5j85f0/1L/3" +
       "Z93fvT95npo8a2dxk4xS9V47S/IgdkvSTd3SrF2HmrzdTR3sOk9Nnhv7bJC6" +
       "N6OC51VuTU2eia9Dz2bX3yOLvBHFhUXPjP0g9bIH/dys/Wu/yyeTyXNjmbx3" +
       "LM+ORb9thXqiEJ9+9VC55XbEUr2KZ3aTuGldvXpIg1dr362C6lXbrNzXqrpx" +
       "ghFilO9brl+7r4WB92pV2tcfr3JmkL48juR/THi7Cz3vbO/dG1n9obtqH486" +
       "sstixy1fs19vNsTv//xrv3b/oeDfcqKevP2C8eULxsm9e1dMf+KiEDcXNrI7" +
       "GtV41NR3vCR/J/3dP/ixt4ySkrfPjMy6gL54V24faTs19szx+K/Z7/7sf/rv" +
       "X/6xz2SPJLievPgGxXrjyotifOwuVWVmu85oeB6h/+YXzF947Zc+8+L9yy1f" +
       "qKlHWi7K+5G7ezyhIK88MDYXTtxnJ1/lZWVixpepBxbi+dovs/bRyJXdX3Xt" +
       "v+sPx797Y/lfl3KRpcvApR0tCnYrxy88FOR6kgjlyUyDUQJ++wc+99s/9MVP" +
       "/3HIw6fB2afmi2+B0PxGMi6XeYeBVzv6rXL+U//qn/wOdP9C+AOT++7HbLPs" +
       "1q88puYXZO+4KvR7H8mGUrruCPdvf1z8iz/6e5/9jqtgjBAff9qGL17qC1vM" +
       "kR1Z+Wd+pfjXv/nvvvDP7j8SpnrybN5YcWBfT/6hEdEnHm01WoB4tELjSaoX" +
       "D2mSOYEXmFbsXgTzD979jeAv/Jcfec+NdMXjyM1dlZNP/dEIHo1/3Wbyvb/2" +
       "Xf/jI1c09+zLC/SIHY/AbszaVz/CvC5Ls7+co/u+3/jwT/wj86dGAzkapSoY" +
       "3KudmVzJm1yp+tRVdL7pWk/vzL18qb6+u859zXX88pbfNfHby1v5SPQN4Es/" +
       "+UHs2373euhHon/B8cHujSZBNR/TyvnPJv/t/see/Qf3J88Zk/dcn2kzrVUz" +
       "bi63aowPbYXdDrKTdz4x/+SjefNCvPJQtT90V+0e2/au0j0yRWP/An3pP/e4" +
       "no2M+OoLk759LG8byz+/bX/mMvue/FK/t7s3uXbg65KPXuuPXapvvDLyfj15" +
       "Li+D86iIo5RVV2+ne4j9egXvu8X607ftTzyGvb5y51b55L6q3eS6+H3je361" +
       "ndid2RvVu9SzN9Lw/Cjr779pJ//5KTR821eg4dJFL9XqKUe/IPud2/bfPHH0" +
       "Z3Nz9D6q6o0uxlVwb7yA//ql3/zd33jnh3/+akGfsUazc72Gu77ZG12vJzyq" +
       "6629/eHh3nE53DeN5QPj6f/DbfuP68l3/980fHdZf/vY/rHv0T2QgOevEiBe" +
       "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" +
       "0V21fZeg5wAMrO2GOqxrJBzdAEhj4Zpw");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "50sA3YRjvJWyIL5er7/18hm0vf2i+t7r996H6bFh4F0mbvJWbr6jfvRSffxh" +
       "Lsf179nbwt+2u8cSTR5LW5pccgk+/JXyWa95BF/4/tc/7whfBO/ffvU+1JO3" +
       "11n+LbF7duMnMqAu/e96eIwPXNB/w01uyb1P37bg40k0j777/tEfv59Mo3n/" +
       "LbrZbfvhu9R901PzO/CHWD50wfLiWN45zv3ibfu37x4uyfOb3LzP3kF6Jxni" +
       "6x/75O6Ogh/UPdHZbn5NYbuF+dgjGCqO3ZMZr8vTNdPlIeh1qx++VN9XT55J" +
       "zCB96ifzcxY4d3h9TVj6xFj+ymTydcxti/4f8vrNs5UumJa37Utfmc2P50X8" +
       "5TeZ+8lL9Xo9eVfl1k2ON0nS42ZtXkb/wh2i6MltdZHfzz1o30DUH5XB8Vff" +
       "ZO6vXarP3yYGvXhJzHzxEaMeneS5B+y9d6td17ae/Nobc0df+OT/09TRlz79" +
       "QtGY1RjtZbX7yZuczBcuAvLCCPVikJ6zyMVd77F83U++9ML31H5QvfyI5E++" +
       "9MpnXsrzx2XkK1iUJ+i/zP50nr8Je//Gm8z93KX6Yj35wFc66NNE4pLtd80D" +
       "v3MRX/7/7SJuEhgfv4mgvnD+he/4TvmFu8y+q5D3rgrZPcn+557G/r/5puz/" +
       "O28y9/cu1ZfrydsenO7K7m40LxfSLmmzH3jDf6bc/P+E/fOff/fb3v/5w7+8" +
       "SUB88D8Oz7KTt3lNHD+eI/pY/9m8dL3guvWzNxmjNyz4xXHHC0cv/V+6qrXX" +
       "/W/tpfI+GzMAAA==");
}
