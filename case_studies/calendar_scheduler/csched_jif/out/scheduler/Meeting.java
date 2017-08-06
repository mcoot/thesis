package scheduler;

import jif.util.LinkedList;

public class Meeting {
    public String title;
    public int day;
    public int startHour;
    public int endHour;
    private LinkedList users;
    
    public Meeting scheduler$Meeting$(final String dayName, final int startHour,
                                      final int endHour, final String title,
                                      final LinkedList attendees) {
        this.jif$init();
        {
            this.day = Meeting.getDayValue(this.jif$scheduler_Meeting_Owner,
                                           dayName);
            this.startHour = startHour;
            this.endHour = endHour;
            this.title = title;
            this.users =
              new LinkedList(
                jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.singleton().
                      readerPolicy(this.jif$scheduler_Meeting_Owner,
                                   jif.lang.PrincipalUtil.bottomPrincipal()),
                    jif.lang.LabelUtil.singleton().topInteg())).
                jif$util$LinkedList$();
            try {
                for (int i = 0; i < attendees.size(); ++i) {
                    jif.lang.JifObjectWrapper w =
                      jif.lang.JifObjectWrapper.
                      jif$cast$jif_lang_JifObjectWrapper(
                        jif.lang.LabelUtil.
                          singleton().
                          toLabel(
                            jif.lang.LabelUtil.singleton().
                              readerPolicy(
                                this.jif$scheduler_Meeting_Owner,
                                jif.lang.PrincipalUtil.bottomPrincipal()),
                            jif.lang.LabelUtil.singleton().topInteg()),
                        attendees.
                          get(i));
                    User u = (User) w.getObject();
                    this.users.
                      add(
                        new jif.lang.JifObjectWrapper(
                          jif.lang.LabelUtil.
                            singleton().
                            toLabel(
                              jif.lang.LabelUtil.singleton().
                                readerPolicy(
                                  this.jif$scheduler_Meeting_Owner,
                                  jif.lang.PrincipalUtil.bottomPrincipal()),
                              jif.lang.LabelUtil.singleton().topInteg())).
                          jif$lang$JifObjectWrapper$(u));
                }
            }
            catch (final ClassCastException ex) {  }
            catch (final IndexOutOfBoundsException ex) {  }
            catch (final NullPointerException ex) {  }
        }
        return this;
    }
    
    private static boolean meetingDetailsValid(
      final jif.lang.Principal jif$Owner, final int day, final int startHour,
      final int endHour) {
        return day >= 0 && day <= 6 && (startHour >= 0 && startHour <= 23) &&
          (endHour > startHour && endHour <= 24);
    }
    
    public boolean overlaps(final int day, final int startHour,
                            final int endHour) {
        return this.day ==
          day &&
          (this.startHour >= startHour && this.startHour < endHour ||
             startHour >= this.startHour && startHour < this.endHour);
    }
    
    public boolean overlaps(final jif.lang.Principal P, final Meeting that) {
        try {
            return this.overlaps(that.day, that.startHour, that.endHour);
        }
        catch (final NullPointerException ex) { return false; }
    }
    
    public int getDuration() { return this.endHour - this.startHour; }
    
    public LinkedList getUsers() { return this.users; }
    
    public boolean equals(final Object o) {
        Meeting that;
        try {
            that =
              Meeting.jif$cast$scheduler_Meeting(
                        jif.lang.PrincipalUtil.bottomPrincipal(), o);
        }
        catch (final ClassCastException ex) { return false; }
        try {
            return this.title.equals(that.title) && this.day == that.day &&
              this.startHour == that.startHour && this.endHour ==
              that.endHour && this.users.equals(that.users);
        }
        catch (final NullPointerException ex) { return false; }
    }
    
    public int hashCode() {
        try {
            return 7 * this.title.hashCode() + 19 * this.day ^ 31 *
              this.startHour ^ 17 * this.endHour ^ this.title.hashCode() ^ 41 *
              this.users.hashCode();
        }
        catch (final NullPointerException ex) { return 0; }
    }
    
    public static String getDayName(final jif.lang.Principal jif$Owner,
                                    final int day) {
        if (day == 0) {
            return "Sunday";
        } else
            if (day == 1) {
                return "Monday";
            } else
                if (day == 2) {
                    return "Tuesday";
                } else
                    if (day == 3) {
                        return "Wednesday";
                    } else
                        if (day == 4) {
                            return "Thursday";
                        } else
                            if (day == 5) {
                                return "Friday";
                            } else
                                if (day == 6) {
                                    return "Saturday";
                                } else {
                                    return "Invalid";
                                }
    }
    
    public static int getDayValue(final jif.lang.Principal jif$Owner,
                                  final String dayName) {
        try {
            String d = dayName.toLowerCase();
            if (d.equals("sunday")) {
                return 0;
            } else
                if (d.equals("monday")) {
                    return 1;
                } else
                    if (d.equals("tuesday")) {
                        return 2;
                    } else
                        if (d.equals("wednesday")) {
                            return 3;
                        } else
                            if (d.equals("thursday")) {
                                return 4;
                            } else
                                if (d.equals("friday")) {
                                    return 5;
                                } else
                                    if (d.equals("saturday")) {
                                        return 6;
                                    } else {
                                        return -1;
                                    }
        }
        catch (final NullPointerException ex) { return -1; }
    }
    
    public String toString() {
        try {
            String s = "<\"" + this.title + "\" | " +
            Meeting.getDayName(this.jif$scheduler_Meeting_Owner, this.day) +
            " " + this.startHour + " - " + this.endHour + " | ";
            String sep = "";
            for (int i = 0; i < this.users.size(); ++i) {
                s += sep;
                s += this.users.get(i).toString();
                sep = ", ";
            }
            s += ">";
            return s;
        }
        catch (final IndexOutOfBoundsException ex) { return ""; }
        catch (final NullPointerException ex) { return ""; }
    }
    
    public static final String jlc$CompilerVersion$jif = "3.4.3";
    public static final long jlc$SourceLastModified$jif = 1501908437000L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "2WfSlMUP7cWPVhTFDYK3szOxWJXmj0UV");
    public static final String jlc$ClassType$jif$1 =
      ("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");
    
    public Meeting(final jif.lang.Principal jif$Owner) {
        super();
        this.jif$scheduler_Meeting_Owner = jif$Owner;
    }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Principal jif$Owner,
                                         final Object o) {
        if (o instanceof Meeting) {
            Meeting c = (Meeting) o;
            return jif.lang.PrincipalUtil.equivalentTo(
                                            c.jif$scheduler_Meeting_Owner,
                                            jif$Owner);
        }
        return false;
    }
    
    public static Meeting jif$cast$scheduler_Meeting(
      final jif.lang.Principal jif$Owner, final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$Owner, o)) return (Meeting) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Principal jif$scheduler_Meeting_Owner;
    public static final String jlc$CompilerVersion$jl = "2.7.0";
    public static final long jlc$SourceLastModified$jl = 1501908437000L;
    public static final String jlc$ClassType$jl =
      ("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" +
       "nkkXaZAYBwuChl72wvBgHIadyipayGvq");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "p/zqI/xrL7PtRabOh+5Uf+j5ee+eV/ev1n2nP/o+6T1/7Fb9oe7hs8+P+bXH" +
       "Y37tBZJ/8Dl+n7tNPCzl9z88fOQrj5B9D9LeW8J+/KXsgs8+rsQ8wh98b4o/" +
       "eF/qg8/F7wXFu/ve//L7EHtPWvjJRWXypyTu/M6Os/ZsZ7H3bq/pf8Qpy8y3" +
       "i5eYcD/fH17KH3h4+KjzCMGv73xvU15/hF98b2o/8CIN4mVC/+z7EPqv36qv" +
       "dg8fLQe/yezqPuhffTcywKcZqx/LHiHz9ZFxm3J4hOR7k/Hqi/N/tBm3+t9+" +
       "Hwp+8Vb9/NdCwWtLkRZsvEfIf30U3KZwj3D33hS8Fbd//336/sKt+ne6h0+E" +
       "frfrG/tZAuPu3VDfLEVd9v21R/hvfn2o36b8wiP8ua8N9b/0Pn3/0a365YXl" +
       "C+r6LZ/nbkHeDe/vXcpi1z7xjU/hx//Prw/v25R//Aj/t/fG+6Xkxbck5TzN" +
       "7Lvv9CvvQ9Dd5P7V7uHDft3b2XtL0O9dSvDw8MnffYT/89dHzm3K33uEv/G1" +
       "HcOvvU/ff3Wr/rPlGCK7jajS899NfG4G8556WC4+D3iE3/QeeL+rHf6+W/Wy" +
       "Hf7M40rf+Ag/8rWr9FOj9Dffh7C/dat+vXv4+E017Fl69KdvvBtp37+UP/rw" +
       "8On9I3z9/xHSbiv9wCN88rWT9jR38X94H9L+zq36249ab8/3ZNT31Pqbwfr5" +
       "xZX+8CP83q9P3G5Tni3xXV+buP299+n7+7fqNxdx68oXiaYvn8lHn3HwlYen" +
       "nzvsHv7aO/POn3zx/6u08y/94JNFz9u47svO/+JjGuOToYy9J7c4Ni7i7otf" +
       "evITT37kR7UnX/lSVb3M6/Pbg9ePvEzurfe3qup9ePm/vk/f79yqf7Dw+Rku" +
       "75oXeMP2Jd7fEfr8O3j/yl/5/y/vn2ZrPnmaUv/kMYi6H8KzgLoMvvgj91TO" +
       "W+tP2Lnzlbtlf/r0PDn9/vU+707Xl588TlkcwctznrqEpxPKH90v5xwHT75Y" +
       "Pomfb/jkEe+bCDw+PnGf/NCTLz5rL9948jSuf/LONHn9ls26uJFFphZGdafy" +
       "i+7r73M5+vJznL/0xlceFw0WF+S/8bLgvZ8Bu8vGP8M2/Sf3Ub/7PoL3T27V" +
       "P+oevuHt/H+HN3z2axLf+kzEnjXcej///wLWr3zovbF+5eZ5Xnm4JdYuWC+i" +
       "2r2T1Xd8piVKf/x++22Eb33H7xU9/VUd9y/+wqc++i2/oP+395/seP7LNx8W" +
       "Hj4a9Fn21mz/tzx/+PZCS3yn6MNPc//vXHjlE7fc72fo3Bo+WT2l6v8GYR+5" +
       "tDZJAAA=");
}
