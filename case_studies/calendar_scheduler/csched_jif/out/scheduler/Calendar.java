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
      ("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" +
       "Prq5+BsMuOCa/wW1Wni8bj4AAA==");
    
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
       "ovTJru8nPd13qyFq6UxcTQOHX/dAVDOg");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "t/Mruv4PFuTxttoyAAA=");
}
