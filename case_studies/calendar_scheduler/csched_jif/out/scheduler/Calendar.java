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
      ("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");
    
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
       "5G0E22lOXm7Z45jALPSIwCu+J6QFxMvu");
    public static final String jlc$ClassType$jl$1 =
      ("ek+iEGEwsxO0nDBzDGnwmdQstJaZEPNlMtkqJ3bVHBtyPdxNvSXDkNmgFPs1" +
       "aB0TbOlJvAcoQHeY5slyYy/kqNGjYjsVkQmerU1XkOYzB0ZJF6cBboUHZLAU" +
       "0N63TzmIGeEiVxmL8bK1Yi2zCS3sVKWzxkw0ePwaRhJ/H8AsN1NZN4szzCNo" +
       "QCI13mamuUHHAeMfAYJcbZdekiytcn8I1sco7KNKtyAGr5LlaiF2XOZX43a7" +
       "3UbaUXX26aC9Esv0mkRXFuhEpBnkJ63Pp8VCASAc5tLuGC8AauyidndaL3WP" +
       "do39qfHAckV2UDkYtBg4DqZPSXmh4fBO7Zk4pOEAR3FFkcyU2bGu1yKSggOq" +
       "GHTBwTR9FRhjWe6Xx9iHgXEZ9QZcYqd9VsvcVBCSwNEWh4Pt7sA1WcJYpqwE" +
       "1NlC3mAv7GYVOQVQOsXaUh1CN/04jNdy5pnuGNBnaogcNov0FAD7Zbmb7fgZ" +
       "XuxbKmmPRdsGIm7jfOGi9M4KsjU532w0DZXgTvBceE/P5D3kNRu9zXF+Q7IN" +
       "tS+XcY+rNKTWpsdkOjLeHDWBriHf0WXQJcbLYDZY0w7c+CUNUikF7CAbD2Bx" +
       "CKCsiLWoozJ3D7QqQI5R1j1Ki0OgBVB7UFmji6WMRvmRBunpEL8LHE85mcnX" +
       "0j4ueDirJMBRMvKYiYkFFz4YFJKtDKp4iNXQDRksH8duaJmSRc/imSrvLW69" +
       "261P6FjrzaUtzoRDXtMRDZXzBh5Cn6CZTnd+AtQJaqSezQd9Qzbz4Y5Z7gwP" +
       "2MKpKhdVMh+H0LRVRTpvA3PuMvR8bxW65lEavp0TaxuKDPagZ3KZgDnKl50S" +
       "8ObcQzjsRHtonWd96GZuvxzupxzUQ0EPSLBvnODB800rCCSGOEWJaG+NDHHS" +
       "mlr2PV4IXFksuoG4xMRPKNIEsZm2HI9RiI96iepCY33KF/pJds2ZqWvuGuCW" +
       "ADjcF9edkqxTFMfxj5+fj6Trx7NXLk97dzOdAt89D5CPPjZdPWmqj38/vHVu" +
       "fuxcEDdvhu8Zlnr1bsLAnZvUjzuX7IQzzEcve1y9gL7/XHzw7mPo5e+565wa" +
       "9Lqe3PcYet+z9Oj8/Pbeb5b+dHl6+9Jf/9wXbe7nJ7eu37b31ehNVZp9NHIa" +
       "J7pvqTcNK73/oZV2l5Sve8/Uf2/35d9Zf8j6yVujp+++MD+SOfbgpDcefFd+" +
       "sXCqukikB16Xv+Mu7W++ySt60/D9wnX9xftfl+/J5iG2Xdjx4vWUn7uuf+Zh" +
       "tj3+vd9/wlh4Luxq9G13xfnqjThfvYeM+SAJ3zN8bx2Nnnrtqh7992+NhPOU" +
       "/3Zdf/2bk/D01fP15ffu+jX2XPHV6Gk/ubyGX36Xly2LJxDZnou4Gr3oFo6D" +
       "V5IfO49b9XkzTSPHSB5H8ruH74MDNn90XX/jWyP5POXr1/V/+uYkP5Tc8cq9" +
       "9KrrpJzLVj/4BFJ/6Fx8/0CqYdvXcx5H6jNN6tuPo/NskR8djHJ8XT/zrdF5" +
       "nvL0Vf3MH//ptPPHnzD2E+fis9XozUenup+ajz8O9dnZkQz7f/a6/r5vDfXz" +
       "lDvXtf6nQ/0LTxj72+fip6rRdwyo31iU4GSFUzpJZdwkQZEPEXLJPPzQWQeu" +
       "PeWlrkZfezQb7PZrfxbJYPdnDH5sMr/KBvvwx27ntVEOd/G0cl67SrO6fdao" +
       "2+eDwU+aNHQIx70vG++1D9/+VOX55euPcTOvffiNT384y765iO4eGQ8w5Tz6" +
       "xSx7ggj+zhPGvnQufrYaveubYXwe/8xD0nnhPP2VR6Xz63+epXOVjXS/ePzq" +
       "LI7bn/ikePtxjMceZPzzj2P8LzyR8V9+wtgvnYu/W41euMHlcYy+bP7eRxj9" +
       "1G/8OWb0VXrV7WtruD5KLhy/CRZS97VPXHKvzr2fMmLz05dcqKvW3fS9y8/L" +
       "vAthH7l9PcVojIfnXKXDXU1IP0kOQvXd26+lt/27G96+Qfws8Jv2bev2x2+/" +
       "dnckfeP2Vdhy+9FcQvmcweTk9aBDA3Qlpa9Zrz8p+PvIXbwHo75e1TWi0nnE" +
       "xB8bZn7oXCyvMzYf1KFb96A++pjctCtWXGb+6hO07x+di39Qjd72oFzOvaf7" +
       "dfAmD/ddN7p303Eefe//O0rOxa9doP7xE7D+J+fiN6rRd56xHnS4egz/Lwh1" +
       "g13ddJzzSt/1yL97XP1TgvVLX3zphW//ovxvLunOd/9x4Lnt6AW3jqL7MyXv" +
       "az83nF6uf8Houau8ySs+/PYQc99F6NzxleyKrv8DE6rsoXUyAAA=");
}
