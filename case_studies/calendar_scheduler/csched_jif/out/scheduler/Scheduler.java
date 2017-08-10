package scheduler;

import jif.util.HashMap;
import jif.util.LinkedList;
import jif.lang.Principal;

public class Scheduler {
    private HashMap calendars;
    
    public Scheduler scheduler$Scheduler$() {
        this.jif$init();
        {
            this.calendars =
              new HashMap(
                jif.lang.LabelUtil.singleton().noComponents(),
                jif.lang.LabelUtil.singleton().noComponents()).
                jif$util$HashMap$();
        }
        return this;
    }
    
    public Calendar getCalendar(final Principal User) {
        try {
            Principal pUser = User;
            jif.lang.JifObjectWrapper wP =
              new jif.lang.JifObjectWrapper(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$lang$JifObjectWrapper$(pUser);
            jif.lang.JifObjectWrapper w =
              jif.lang.JifObjectWrapper.jif$cast$jif_lang_JifObjectWrapper(
                                          jif.lang.LabelUtil.singleton(
                                                               ).noComponents(),
                                          this.calendars.get(wP));
            Calendar c =
              Calendar.jif$cast$scheduler_Calendar(User, w.getObject());
            return c;
        }
        catch (final ClassCastException ex) { return null; }
        catch (final NullPointerException ex) { return null; }
    }
    
    public void addUser(final Principal User) {
        try {
            Principal pUser = (Principal) User;
            jif.lang.JifObjectWrapper w =
              new jif.lang.JifObjectWrapper(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$lang$JifObjectWrapper$(pUser);
            jif.lang.JifObjectWrapper wCal =
              new jif.lang.JifObjectWrapper(
              jif.lang.LabelUtil.singleton().noComponents()).
              jif$lang$JifObjectWrapper$(
                new Calendar(User).scheduler$Calendar$());
            this.calendars.put(w, wCal);
        }
        catch (final NullPointerException ex) {  }
    }
    
    public boolean attendeesFreeAtTime(final LinkedList users, final int day,
                                       final int startHour, final int endHour) {
        try {
            for (int i = 0; i < users.size(); ++i) {
                jif.lang.JifObjectWrapper w =
                  jif.lang.JifObjectWrapper.
                  jif$cast$jif_lang_JifObjectWrapper(
                    jif.lang.LabelUtil.singleton().noComponents(),
                    users.get(i));
                final Principal p = (Principal) w.getObject();
                if (!this.getCalendar(p).freeAtTime(day, startHour, endHour)) {
                    return false;
                }
            }
            return true;
        }
        catch (final NullPointerException ex) { return false; }
        catch (final IndexOutOfBoundsException nex) { return false; }
        catch (final ClassCastException ex) { return false; }
    }
    
    public void addMeeting(final Principal User, final Meeting meeting) {
        try {
            this.getCalendar(User).addMeeting(meeting);
        }
        catch (final NullPointerException ex) {  }
    }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1502340064000L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAL1cCXgUVbau7g7Z2MIethBC2DUNyGIIKBC2QAKREISIhEp3" +
       "JSmodHWqqpMA4qjjiCvz6eA2T3j6PXHEQdHnQ/1EZ0bc8LmMzvjGZYbRYXyK" +
       "D1FxG3lv1HfPubdruXW7aTfyfbm3+tY95957zn/OPfdUde89LnUzDWn4BrW5" +
       "zNoUV8yyJWpzrWyYSrRW1zatJE2NkZN3vBC9ZU38raCU3SDlqmZ9zJSblWop" +
       "T05YrbqhWpssqaB6g9whhxOWqoWrVdOqqJa6R/SYaRmyGrPMduliKVAtFaik" +
       "RY5Zqmwp0YWG3mZJI6vjZKAWTbfCSpcVjsuG3BbGqYRrKzXZNAmnbGxNMsmN" +
       "G3qHGlUMSxpRTSbOemtyk6KFa9m9avhU0WVIxUn2bH10cciZru7GieEdN68r" +
       "+PeQ1LtB6q3G6izZUiOVeswi82mQerQpbU2KYc6NRpVog9QnpijROsVQZU3d" +
       "TDrqsQapr6m2xGQrYSjmCsXUtQ7o2NdMxMkUYcxkY7XUg4okEbF0I7mc7GZV" +
       "0aLJT92aNbnFtKSBjljo8hZCO5FFPhGnYjTLESVJkrVRjUVBFhyFvcbSpaQD" +
       "Ic1pU4i+7KGyYjJpkPpSzWlyrCVcZxlqrIV07aYnLBDwkJRMK0ARcmSj3KI0" +
       "WlIh36+W3iK98lAQQGJJA/huyIloaQinJZd+ji+btX1LbHEsiHOOKhEN5p9L" +
       "iIo4ohVKs2IosYhCCXtMqL5JHvj4lUFJIp0HcJ1pn4cvOjHnjKLfHaJ9hgr6" +
       "LG/aoESsxsidTb1eGVY5vjxEIaibKijfs3IEfy27U9EVJ4Y10OYIN8uSN3+3" +
       "4pk1l9yjHAtK+VVSdkTXEm0ER30ieltc1RRjkRJTDDCRKilPiUUr8X6VlEOu" +
       "q9WYQluXNzebilUlZWnYlK3jZyKiZsICRJRDrtVYs568jstWK153xSVJyiH/" +
       "0kB2sYXVmiUp4Va9TQmbViKqEMMNm1PPmlY+aerUsNWqmKoZjsim0gh3VQU+" +
       "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" +
       "cLyZvrdPf9sitI4wHsv/OIiLrfsV18CG");
    public static final String jlc$ClassType$jif$1 =
      "W5dX53yz2v5ujRC6AVzJ/wN6oBLh6VAAAA==";
    
    public Scheduler() { super(); }
    
    public void jif$invokeDefConstructor() { this.scheduler$Scheduler$(); }
    
    private void jif$init() {  }
    
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1502340064000L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAL17Wcw02VVYz+/xjD02eAMDxpjBHixMw3RVV3VVdwwk3bV2" +
       "7V1rVyEYau2q6tr3KsdZkBIjkJwoGEIksPLgRAQ5EEVBeUiQkLJBQJESRVke" +
       "CChBCgh4IFE2KQmp/v7vX+af34P8kk+qe2/f5dyzn3Ol8335DxbvrKvFq0We" +
       "jJckb15vxsKvX5fsqvY9LLHrWp0n3nB/Yrn6wl/9wff/3Xcs3mct3hdlSmM3" +
       "kYvlWeMPjbV4b+qnjl/Ve8/zPWvxgcz3PcWvIjuJpnljnlmLD9bRJbObtvJr" +
       "2a/zpLtt/GDdFn51d+ejSW7xXjfP6qZq3Sav6mbxfi62O3vVNlGy4qK6+TS3" +
       "eCmI/MSry8WfWbzALd4ZJPZl3vhh7hEVqzuIK/I2P29/JZrRrALb9R8defEa" +
       "ZV6z+NZnTzym+DV23jAffTn1mzB/fNWLmT1PLD74EKXEzi4rpami7DJvfWfe" +
       "zrc0i498RaDzpncVtnu1L/4bzeIbn90nPVyad737ji23I83i65/ddgdpqBYf" +
       "eUZmT0nrD4Tv+fxnMjp7cIez57vJDf93zoc+9swh2Q/8ys9c/+HB934n95P2" +
       "h3/pRx4sFvPmr39m88M9f/9P/+Gf+q6P/fKvPNzzzc/ZIzqx7zZvuF9yvvZf" +
       "fhT71O4dNzTeVeR1dFOFN1F+J1XpfuXTQzHr4ocfQ7wtvv5o8Zflf2r+uZ/z" +
       "f+/B4pXj4iU3T9p01qoPuHlaRIlfUX7mV3bje8fFu/3Mw+7Wj4uX5zEXZf7D" +
       "WTEIar85Ll5M7qZeyu9+zywKZhA3Fr04j6MsyB+NC7sJ78ZDsVgsXp6/xYfv" +
       "B5+575Nm4a/CPPVXddN6ftbUqxqGNjsAhldN6NdRvXLt2n/jthr5tx/JjIld" +
       "vVG7oe+1M+or9274RhwFq7pyV08WlEej1+e14v/XRcON4q/pX3hhFsZHn3UM" +
       "yWxFdJ54fvWG+4X2QPzhz7/xaw8em8Y9r5rFhx7Dfv0x7MULL9zB/Lqb8TwU" +
       "7iya62zys1W/91PKDzA/9CMff8esVUX/4szY29bXntXxJ57hOI/sWXHfcN/3" +
       "ud/577/wk5/Nn2h7s3jtLUb41pM3I/r4s/RVuTtjW/lPwH/nq/YvvvFLn33t" +
       "wU0j3j37psaetWc29I89e8ebjOnTjxzTjScPuMV7grxK7eS29MibvNKEVd4/" +
       "mblj/Hvuxl/7R/PfC/P3f2/fTe9uE7d+9j7Yvc6/+ljpi+Kh0G7cfYaiOyf4" +
       "vUrxM//uX/wu9OCGySN/+b6nHKviN59+ykZvwN57Z40feCIstfL9ed9v/JT0" +
       "4z/xB5/7/jtJzTs+8bwLX7u1NzztGb+8+gu/Uv773/wPX/rXD55It1m8VLRO" +
       "Erl3mH90BvTJJ1fN5pvMLmTGpH5Ny9Lci4LIdhL/pin/+33fDv7i73/+/Q/F" +
       "ncwzD5lXLb7rjwfwZP6bDos/92s/+D8+dgfmBfcWPp6w48m2hz7pQ08g76vK" +
       "Hm94DH/+X33LX/tn9s/M3m32KHU0+XdOYnFH3uKOquWdLD95137nM2vffWu+" +
       "ebhb+/q7+VsgftY/k7dA90QXrdWXf/oj2Pf93h3ST3TxBuMjw1utVbefMpP1" +
       "z6X/7cHHX/onDxYvW4v338VYO2t0O2lvUrXmKFlj95Pc4mvetP7miPfQvX/6" +
       "sa199Fk7eOraZ63giZeYx7fdt/HLTyv+zIj33pgEz9975u/37/t/fFt9f3Fr" +
       "PzC8sLgbQHdHPnbXftutee2Rbr1cVFE3W8bwGOgd599z//2j+/4fPgW0mRl6" +
       "7zLru1MfnHOP2R0+FDtt1yFvFw+t7Nau7tR2eGG+7J3Q6/Dr0O339zwfoXfc" +
       "ht8+a3x9lzbNJ4Ios5OHmt8sviFO3NceGbU+p1Gz3r023/wEi5v23Xj/+sNs" +
       "4zlYzLrztU+2cfmckvzYb//lX/9Ln/jNWVeYxTu7mxxnFXkKltDecra/+OWf" +
       "+Jb3fOG3fuzONGfe/cA/rz6xuEElbs33zfnMDTslbyvX5+y64e9syffuEHyr" +
       "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" +
       "qKSToc8yHUoTtJFyOMKwsBy2uM80rtHr");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "vzdf+1gtbhO/WDynLPRhSe7w/wDtYGF6zjMAAA==");
}
