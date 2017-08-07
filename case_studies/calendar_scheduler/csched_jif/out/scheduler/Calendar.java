package scheduler;

import jif.util.LinkedList;

public class Calendar {
    private LinkedList meetings;
    
    public Calendar scheduler$Calendar$() {
        this.jif$init();
        {
            this.meetings =
              new LinkedList(
                jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.singleton().
                      readerPolicy(this.jif$scheduler_Calendar_Owner,
                                   jif.lang.PrincipalUtil.bottomPrincipal()),
                    jif.lang.LabelUtil.singleton().topInteg())).
                jif$util$LinkedList$();
        }
        return this;
    }
    
    public boolean freeAtTime(final int day, final int startHour,
                              final int endHour) {
        if (endHour <= startHour) return false;
        try {
            for (int i = 0; i < this.meetings.size(); ++i) {
                jif.lang.JifObjectWrapper w =
                  jif.lang.JifObjectWrapper.
                  jif$cast$jif_lang_JifObjectWrapper(
                    jif.lang.LabelUtil.
                      singleton().
                      toLabel(
                        jif.lang.LabelUtil.singleton().
                          readerPolicy(
                            this.jif$scheduler_Calendar_Owner,
                            jif.lang.PrincipalUtil.bottomPrincipal()),
                        jif.lang.LabelUtil.singleton().topInteg()),
                    this.meetings.
                      get(i));
                Meeting m =
                  Meeting.jif$cast$scheduler_Meeting(
                            this.jif$scheduler_Calendar_Owner, w.getObject());
                if (m.overlaps(day, startHour, endHour)) { return false; }
            }
        }
        catch (final ClassCastException ex) { return false; }
        catch (final IndexOutOfBoundsException ex) { return false; }
        catch (final NullPointerException ex) { return false; }
        return true;
    }
    
    public void addMeeting(final Meeting meeting) {
        try {
            if (meeting != null) {
                this.meetings.
                  add(
                    new jif.lang.JifObjectWrapper(
                      jif.lang.LabelUtil.
                        singleton().
                        toLabel(
                          jif.lang.LabelUtil.singleton().
                            readerPolicy(
                              this.jif$scheduler_Calendar_Owner,
                              jif.lang.PrincipalUtil.bottomPrincipal()),
                          jif.lang.LabelUtil.singleton().topInteg())).
                      jif$lang$JifObjectWrapper$(meeting));
            }
        }
        catch (final NullPointerException impossible) {  }
    }
    
    public LinkedList getMeetings() { return this.meetings; }
    
    public String getCalendarRepresentation() {
        try {
            String s = "Calendar:\n---";
            for (int i = 0; i < this.meetings.size(); ++i) {
                jif.lang.JifObjectWrapper w =
                  jif.lang.JifObjectWrapper.
                  jif$cast$jif_lang_JifObjectWrapper(
                    jif.lang.LabelUtil.
                      singleton().
                      toLabel(
                        jif.lang.LabelUtil.singleton().
                          readerPolicy(
                            this.jif$scheduler_Calendar_Owner,
                            jif.lang.PrincipalUtil.bottomPrincipal()),
                        jif.lang.LabelUtil.singleton().topInteg()),
                    this.meetings.
                      get(i));
                Meeting m =
                  Meeting.jif$cast$scheduler_Meeting(
                            this.jif$scheduler_Calendar_Owner, w.getObject());
                s += "\n";
                s += m.toString();
            }
            return s;
        }
        catch (final IndexOutOfBoundsException ex) { return ""; }
        catch (final ClassCastException ex) { return ""; }
        catch (final NullPointerException ex) { return ""; }
    }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1502011690000L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAL1bC5QVxZmue+c9vAbkMbwvMyMvYS7gCIGBIAwODy8yYYDI" +
       "GL329O0709D3dtPdd7ig5KAGUdjgBt9r4JgEEnWJkux63JP4SNxkQc3GddcT" +
       "0fhas8eQVRJ1NYmbGLf+v6pf1T2XwbjOOVPVXV3/X1X///2Pqu577AypsEwy" +
       "cYuabbZ3GIrVvEbNdkimpWQ6dG3HBtqUlj/8xs8yd202XouTyi5SrVob85aU" +
       "VVKkRirYvbqp2jtsUpfaIvVJyYKtasmUatmtKTJI1vOWbUpq3ra2kS+TWIrU" +
       "qbRFytuqZCuZdlPP2WRKyqAD9Wi6nVSKdtKQTCmXxKkkO9o0ybIop0psdZhU" +
       "G6bep2YU0yaTU3TivLcmdStasoM/S8Fda9EkCYc9Xx9bHHJmq7v9guRtd15V" +
       "9/0yMqyLDFPznbZkq3KbnrfpfLrI4JyS61ZMa1kmo2S6yPC8omQ6FVOVNHUn" +
       "7ajnu8gIS+3JS3bBVKz1iqVrfdBxhFUw6BRhTKcxRQYzkRRkWzed5VRmVUXL" +
       "OHcVWU3qsWwy2hMLW147tFNZ1FJxKmZWkhWHpHyrms+ALAQKd41Nl9IOlLQq" +
       "p1B9uUOV5yXaQEYwzWlSvifZaZtqvod2rdALNgh4XL9MW0ERkrxV6lHSNqkX" +
       "+3WwR7RXDQoCSGwySuyGnKiWxgla8unnzGWLD1yTX5WP45wziqzB/Ksp0SSB" +
       "aL2SVUwlLyuMcPDM1B3S6MduihNCO48SOrM+j1z77sWzJv3oJOszPqLPuu4t" +
       "imyn5SPdQ5+b0DZjYRmDoG6poPzAyhH8HfxJa9GghjXa5QgPm52HP1r/L5t3" +
       "P6C8FSe1q0mlrGuFHMXRcFnPGaqmmCuVvGKCiawmNUo+04bPV5Mqep1S8wpr" +
       "XZfNWoq9mpRr2FSp4z0VUZayABFV0Ws1n9Wda0Oye/G6aBBCqug/GUX/K+h/" +
       "O68/Z5NMslfPKUnLLmQUarhJq+XCixbOaWlJ2r2KpVpJWbKUNDxVFbjR6Ewk" +
       "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" +
       "8eWl3xvjhOv+DwNAct34OwAA");
    
    public Calendar(final jif.lang.Principal jif$Owner) {
        super();
        this.jif$scheduler_Calendar_Owner = jif$Owner;
    }
    
    public void jif$invokeDefConstructor() { this.scheduler$Calendar$(); }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Principal jif$Owner,
                                         final Object o) {
        if (o instanceof Calendar) {
            Calendar c = (Calendar) o;
            return jif.lang.PrincipalUtil.equivalentTo(
                                            c.jif$scheduler_Calendar_Owner,
                                            jif$Owner);
        }
        return false;
    }
    
    public static Calendar jif$cast$scheduler_Calendar(
      final jif.lang.Principal jif$Owner, final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$Owner, o)) return (Calendar) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Principal jif$scheduler_Calendar_Owner;
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1502011690000L;
    public static final String jlc$ClassType$jl =
      ("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" +
       "IOAcWTTBdtv13Xa+gbotstzB9LCjwbJQ");
    public static final String jlc$ClassType$jl$1 =
      ("CttbzFID0QuxVacDYnYoTJ9P4h4ql5QJtJDhInnZYULbiWXQtDw9GqgF1MIO" +
       "aO10HzK71TpN9WTo7UUM4qdmuoEWOJ0ZWOR5mZlaU7rfO+iBGOQFyBfJjjob" +
       "ILqRTjAJoGpLST7XNovywA3gKphuElyF1qRKqYh2mq9zRNuZ6/RQ8j2Yacv5" +
       "QrcVDp2uAGpZa0tEFiAvwY9aruYpBhXzDIlMO99s55w6uiDGdrk+WOjChtQH" +
       "kYYODLSLRoX3N4oAuRoQH80DXi2UoV/EXVyVQh6wpQwNNLHeJJJKe2IY5/R5" +
       "/ChsFXlPih1D46hAduGGOvT7M4Qn40cVHyDNgVxmXMG4vTsafuHbK0s9L2aR" +
       "TfpeYG3X9YY6LZW12CiHtIHUHD/ARp1GjSdmR9lVlY5x/HZa6P7WBTraSefN" +
       "ch0XUxRKzcSQyzbpg0NLJKxB5aFn9QBQdf5y/GY0YtxlNi2oAfxxHfp1JUQH" +
       "Km4SqOcL2t6qPJnRY1QcqsrCG3rHlzcQuRiDgM2aKylR8djhtMZ3QcaK7hnH" +
       "MnbFbPF6R/YZWSzdWSVrFLMrYIXrpodtvMNlgGB6mnG7LpWY6Yk0/fN0ms1P" +
       "y+n4wZ/yY6RhKRUnkZYkUg3bLduzQgFTdYsq3QnhXSYS+HVtEUiFmPqUXJMS" +
       "MZW0ZTb42gYBiM2WIc4CDtjssp0XLLvFkEWBZI6BlxoqhJATU1kTgxSoORrE" +
       "4cdIG/UWxpRAAZE1xNsCFnPj+TIlp5EumZGZMXRr5KC62W4zykPG6ApPFKA1" +
       "4DxGDS8eNLgDhDjjQN+APQjQxa0ssTIy6IbRLGvPUzJzrTfKvunw9JTReRW4" +
       "K9deNNP8OA1xOIC8aPz8BZlRB9BmWPBdxgBctz6wBmQkG7ADK2TagETTAEnO" +
       "ROiGiCGwdzAZ6tgjkdFmJBc+FLeWFMjmGi49UV00DOqT2FDWQI/sg0haDURJ" +
       "YCyUECBTVT3BRwaEu3oEd80pEBtg2W4XdgUjYrtYXK6Y9rcXbC9fr/8epEOd" +
       "Qu8yQL/5Qurm2lN/8h3jnUvzk5dief9e8f3jVK88yCq4dz+r4N41heEC84nr" +
       "Gje3pB+6FB95cGF6/T13m3iD3dbQIxemj1xdTy5XdB/4SjlS1+u5L/71z3/B" +
       "EX8aunN7/72rJm+r0uwTkdu40SNTvW2c6UOPzSRc88IeXmX/PeFLv8l81P7h" +
       "O5OnH9xCvym97I1Ir7/x7vnFwq3qItm/4Qb6Gx7s/e33k4/eNj4/c1t/4dEb" +
       "6IeyeYxtV3a8eIvyU7f1jz/OtifnBIRvMXa+FE41+doH4nzlvjhfeUiM9cYt" +
       "fOv4fM1k8tSrN/Xkv391W7ig/Lfb+g++8haevrnivr4Ltze2l0qqJk+HyfXG" +
       "/PpeXpcs3mKT7aWIq8mLXuG6i2ofxu6TZn3eStPINZMnbfl94/ORkZo/uq2/" +
       "/NVt+YLyB7f1f/rKW34sAeTlhzlYwk0OwXWp73mLrX7vpfiucaum49ziPGmr" +
       "zzRp6DxpnxeL/MRolNPb+pmvbp8XlKdv6mf++E+nnT/4FmM/dCk+V03e7rvV" +
       "o7v5lieRjl4cybj+527r7/jqSL+g3LutD3860n/iLcb+9qX4kWryDSPp9y1K" +
       "drPCLd2kMu8nStGPbeSanvjRiw7cesprXU1+980pY3df/f+WMfaxT97Na7MM" +
       "8zqt3FdvUrHuXjTq7uVgCJMmPbtL13skZe/Vj939zioIy9ee4GZe/djrn/5Y" +
       "ln1lET04Mt7AlMvoF7LsLUTwd95i7IuX4ieryXu/EsWX8c88Jp0XLugvv1k6" +
       "v/znWTo3GUuPiiesLuK4+22fUu4+ifHEGxn//JMY/zNvyfgvvcXYz12Kv1tN" +
       "XrhPy5MYfV38A29i9FO/8ueY0TcpWHdvreH2KLly/H6wkHqvfts1P+vS+51m" +
       "bH36mi9103qQ4nd9veJdN/bxu7coZmM+jnOTMneDkH6KHoUaendfTe+GDxa8" +
       "e5/wi8Dvt+/ad7/l7qsPRtLX796ELXffnG+oXrKc3LwedWiErvbpq/ZrbxX8" +
       "ffwB3aNR387qmVHpvsnEnxhmfvRSULdZnW/UoTsPoT7xhPy1G1ZcMX/xLbTv" +
       "H12Kf1BN3vlGuVx6+0d18H6y7nvv6979jsvoB/7f7eRS/NIV6h+/BdX/5FL8" +
       "SjX5xgvVow5XT+D/laButKv7HZfc0/e+6T8hN/9csH/uC+964eu/oP6ba070" +
       "g38XPMdPXvDqKHo0m/KR9nPj6eWFV4qeu8mtvOHDr48x9wOCLh2/kd3s6/8A" +
       "Te/k5JoyAAA=");
}
