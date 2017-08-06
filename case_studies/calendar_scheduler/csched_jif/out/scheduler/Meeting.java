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
       "x42p348++Mup711KHxiUX1hmVo77Z5TN");
    public static final String jlc$ClassType$jif$1 =
      ("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" + "gwAA");
    
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
      ("H4sIAAAAAAAAAM28C8z0anoY9J2ze85eu9ds7rv5mz1Jd+PNGV9m7PGeJqo9" +
       "vo49vo7tsUNy4vvY4/vdk27VUrUJrUihbNJUkIBQiqCkDUItrQpBQQhIaYRE" +
       "VRWQoIkqSqlChCJEUVFo8Xzf9///Of+5dFeiFZ/0vq/nvT7P8z7XT378S799" +
       "90rb3D2pymyOs7J7vZursH1dcZs2DHaZ27bHpeNN/2eA1df/zI996j/8wN0n" +
       "nbtPJoXeuV3i78qiC6fOuft4HuZe2LREEISBc/fpIgwDPWwSN0uuy8SycO4+" +
       "0yZx4XZ9E7Za2JbZcJv4mbavwub+zKed4t3H/bJou6b3u7Jpu7tPiak7uKu+" +
       "S7KVmLTdG+Ldq1ESZkFb3/2hu5fEu1eizI2Xid8qPsVidb/jirn1L9M/mixg" +
       "NpHrh0+XfPCSFEF39z0vrniG8WvCMmFZ+qE87M7ls6M+WLhLx91nHkDK3CJe" +
       "6V2TFPEy9ZWyX07p7r7zPTddJn24cv2LG4dvdnff/uI85WFomfWRe7LclnR3" +
       "n3tx2v1OU3P3nS/c2Vtu67el3//TP1Fwxcv3MAehn93gf2VZ9IUXFmlhFDZh" +
       "4YcPCz/+A+LPut/6Kz/18t3dMvlzL0x+mPNX/uDv/IGvfOFXf+1hzne9yxzZ" +
       "S0O/e9P/Re8T/+13776Mf+AGxoersk1urPA2zO9vVXkceWOqFl781mc73gZf" +
       "fzr4q9p/af/hPx/+1st3H+XvXvXLrM8Xrvq0X+ZVkoUNGxZh43ZhwN99JCyC" +
       "3f04f/eh5VlMivChV46iNuz4uw9m912vlve/FxJFyxY3En1weU6KqHz6XLnd" +
       "+f55qu7u7j60lLtvWcorS6Ef221356/OZR6u2q4PwqJrV+0a2eDger3qzmGb" +
       "tCvfbcM3b6NJePuRLZC4zZutfw6DfgF95d8/vpkm0apt/NXzgUMYdgtzvb6M" +
       "VP98jplu2P6e8aWXlov47heVQrZIEFdmQdi86X+9J+nf+Ytv/o2Xn4nFI526" +
       "u08/2/n1x53vXnrpfsdvuYnNw7Uul3JZhH2R549/Wf/R/Y//1Pd+YOGnavzg" +
       "QtLb1Nde5O7nOoFfntyFZd/0P/mT/+s//OWf/Vr5nM+7u9feIX7vXHkTn+99" +
       "Ebum9Beom/D59j/wxP3Lb/7K1157+cYLH1m0UucufLOI+BdePONtYvTGU5V0" +
       "o8jL4t3HorLJ3ew29FSPfLQ7N+X4vOee7B+7f/7EP1n+XlrKP76VG8fdOm7t" +
       "ond2j9z+5Bm7d3ezPC7Pf/eP/+m/+yf+3Ff/WbHI7nHujUe+Cm2/gqx/cA1X" +
       "D9xyu9gXiHmveX9Ir37+v/9v/gHy8o0IT5X0J9+izfWwe+MtiuG22cfvVcCn" +
       "n/PJsQnDZd7/9HPKv/Yzv/2TP3LPJMuML77bga/d6huJ3IU0ZfPHfq3+H37j" +
       "7/zi33r5OWN1d69WvZcl/j3k371s9P3Pj1p0RrborQWS9jWjyMsgiRLXy8Ib" +
       "k/7uJ78P+sv/209/6oHTsqXn4d6au6/80zd43v8d5N0f/hs/9n994X6bl/yb" +
       "zXpOjufTHhThZ5/vTDSNO9/gmP7I3/z8n/2v3J9fVOqixtrkGt5rppce5eYG" +
       "1GcWPllu6fWbdVq4Oin8pHKze4S/cj/h993XwI2l7pfd3Y+Bt+q7pvuxz933" +
       "f7R9p71gbob3uYQ4q1/6N75z98O/dY/Pcwm57fGd0zs1iOm+RXjhP5//ny9/" +
       "76v/xct3H3LuPnVv892iM92sv124s1jtdvfYKd79nreNv90CP5ibN55pgO9+" +
       "UTrfcuyLsvlccy3Pt9m35w+9VRwXQnz6RqQvLeWzd3cvf+qhfekf3UY/Vd3q" +
       "T08v3d0/oPdLvue+/t5b9X0P93J7/P4HluvuXumSLgufXtWn7i/5/q4ePIkH" +
       "kbrV8NsB+OJSPrcAsHlsv/guAPzQNwLABwJ3fperXVglX+RweHQFwp/6+p/4" +
       "J6//9Ndffou/9MV3uCxvXfPgM92f8tH7o6bllN/7fqfcr2D+/i9/7T/+d7/2" +
       "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" +
       "SJJFZOPmTKS1R8qbxrIwb3vZS5vBqYpL");
    public static final String jlc$ClassType$jl$1 =
      ("FAfQjvBv/9NL58X/M+qsDWalKUVeiRFeUntb0k6tOcP4riBGvb0MQoeE4PbE" +
       "SJIHX3IWBxwL3alEIriLxibSRmryiB2OJwvvYHGGz+we38cQWJSnhdsNmSM3" +
       "M3s2M7Atx0oAksCbYLfrj9gS2yYuLExmxKHUJgocnztk/krqmRGqr7aocep6" +
       "cV3WMostno61VZagab9GOmktuNZBzBNPq3XsfMA8O7KCJaAC1ouXU3hLqLWx" +
       "WpSzsF1VH5SzIYpl0+yoRmMoljrVJcmqLdYiMU0ai8WfxE1ERdAWbvdpsOKp" +
       "dLviTUPH0dovyx2w2a0gA68buEwtMKHX8ykHZF21ZdizR+7I+1hFxcQFufDW" +
       "ouVG15fVPUQUFLg7eTwLCFZSRUCWUqRniRuttrIllOcP5OBFI7LK8UvTKoAc" +
       "SadQKSmRlSXPJGSCGdbnOrh6iLuftxfJ6L0lxjNQgZehAq0is3UrX2AqKtmk" +
       "Aol1mqwB1Sli6NWehGNLtfcMHDDmltePUWvWp/WMMnByKJqg8qI6c7YHk9mq" +
       "izSUEe5BLLpy2U0Rnc0UuKzN7TU3lM6tcZGdwTYS9DMg2skqY8/rRkDgtlH0" +
       "yXJNxXcVEKNiJtOCFJkPZ0CzL+VmMqlibfCIMjDsyF+x2YQxKL3KNQmgLc6N" +
       "6TjuT0xuzDMdnAS1MIetvV/v5SENERsFem8yFRbERIQ52tn6uDiX9cRe9rzH" +
       "J+aV9FKh2K6XKF4nTRw6WVhmIXQ1BBYSVEs8jW6cdeQBjW6LvRkyRy+dJwPd" +
       "Lr7O1Y/6IedM3Lnovt9M8kqUHPpKUgflms2jcwD5i4vOGaCwAkqTuuHuF4Vi" +
       "XlG03qVRsJEibg3ROMsprlsHItVu6fC03rp7MKK2zXUNLlFJq8MDGU1ztIsV" +
       "aht2tBoU6V6zyMW06ad8L4IIFPBHODn3viYW+VxN/qVDEZ/Vx5rP1JA5YAcQ" +
       "2232Cwc3rLzp8k2IMGA1dKPJy66nYVsyCcJkWI0oWblaUK5otbavNZ8nBzbR" +
       "86t/bo5qkKhaWk6zDWnr0M5IfPKBFSDns6yfqTK5KK4yTIga27XHRDtym4BB" +
       "jFMdZhOqNLCtHEVxvGavM7XVvDpAs8rPJctUKbWImJSOulHWE32M3Jk2L8JO" +
       "LlqANNtNChFgS0EXZy3V63zxfsW+InD6ap3crDwsDGmVHQmsIhV3zjNicBnZ" +
       "WHCOsnWwjo70ruDMfn1e6ZdkE2B0bY2D63v0bE0xpsBmjCP9OV80/mljXRYl" +
       "AZ52+uQt8fGxIDrNrgnoSo/nmY0XmyLS5HG13uUo4UQs0vNIg/CrfrW5FOEw" +
       "EE0oQBeTR3pBRApkrrv4Fm9ZrWaNPq75WxbkAqY3a1kdeHJhnLVybamADjaU" +
       "QKTthQov8N7fCb7jcJnpQZeBbisHkaUKsiHAsg4RltAyn0DX04HdeKY5eyyX" +
       "SozqyuWBCtdEueJzJU74kdQHGzZXscaqEucQoz9bYpyT7WFDTKvTVgzX/sUQ" +
       "oanHp80SgoiYQGDt4mnRCUrCoqNkcuUOhq6c+bVA69fSXhU2QV6z5NSr6yV8" +
       "6QyOacueOJpzSlD6dXCga7Zt0JOJY4ida1tk2zYY0m02J3DwEC+agaBG5o5T" +
       "lFHDB3CSiMWo4+tjek5H0iRseHdZdLsfXnvEjFRTtbXFNkzcEhP0u9q41gza" +
       "WuTpuHfOImicmUM7CeDgYtfNpnFYRrAHWJWPV95sOMcOkpV/SI57uzeO/FnY" +
       "sAc4y4EteJJWG6Dx95J5SHrBGHO6SLi9ozAj1bLrI1QDk0FAaddCpmExJj6d" +
       "WLVuO4duuMw+XxwGPTL7ytnH6nk49VqSGsOJK5txJziAl6eeEwye2LVh11tX" +
       "jDa7DEYUkW5cO682Zq3xviFKx9Ssz5QNtE0m0IaNmUcqgYaEiK9WKJplynDe" +
       "udWYeLsfHPCAwTBDyO5Ju2xFDKhGe2OG0O6YOm1AgAEqC0mlKL54sE5eSjOp" +
       "CegB56FqQtRxDxZUvmv8kYZnnjd86hIUl1ZVs4O0o/UCVGPXIMotmLKkABge" +
       "5pLbnbPRFvGaKM84NpldMWJapT2LayrXn7iU25daQJApBTiVRbPWBjuuO30P" +
       "IYRNXsS2766rA39Qjvq84nZJLEf1HiHrfecguZaNjH7GpnpWa2jqDKFDe8rN" +
       "6JIDsqqYOgHArqV0VvbZRuN0yjrTLIhXIZh5ubzy1j1hrve17sEQNhZXfZiu" +
       "uTW20tVQAp83A8gyD5MO1qYeOeCi8q42ogG7FI3gyU3oLcxWeCvx17ZC5jM/" +
       "9ZIh6izTsNni/h1gKHXDFTEfa/mi03FYtjWNUxUf9ILaWpk80dBlH89Y3BaN" +
       "UDlReXS100QcrdDrWR9hS4mbdgcUyb1z59Kieoj27nxKt0VZnYxtuArqU4ro" +
       "Caxh2S7YtiiSIM2irKd8y9ic08v3fRVibk9rRO7tHbDzL4NHKpFgkPLlil75" +
       "dcFTQEAylpWDeLzj8cEUj2x8gbWLbGhpVQ7MOAJhNO+iSIc4ZQeruNUksMup" +
       "RYmejJMM9pEFHNphvbP4XmzZuUncTdh1BF1VC2mGQ1ktkcEWQjIywv1WXK0m" +
       "cxr2dCLDkgzMuL2zVwCP8nN04I5HAMOzaAnu2H1cneWtaI/0GrLcblNqCu0q" +
       "UoftrRlJMKP0mus50mF5WsMVst4CwKGvMAgSuCkxTtA5N0sMczZH6fYqwOXx" +
       "rYJP37/f8Ozd4/d5s6H72H8SnY6hK6w6yIlUHQlRiqvCGaozD/ZFTSv8vN9g" +
       "cF5NlwMvOQ1GXeSr0Llo3BWLqrS3qood43yRpYiS/O3gdudQhUd9FSMU7NZH" +
       "+ZI3Q9W26wsqGInFqplLDeqWLlMN5Lo2vTDKxbnqoYrpyQk9Vp3lYftG60Ri" +
       "8ZssGEVldS2BiRvylcDAqV0KNWZrutljAx0n3cXTtQ0rDgiL+NkRllhXS5CE" +
       "v/azEBILcRaRgNqs9/dISzZ0x+Erxi7M9irA10ZdOdedqWjQMT129coIeEBb" +
       "JTlCpMhm3fLnJfQWj9wetABBv5oFthl1L0qxDmw9pC4nzKQXO7SzA86htnJs" +
       "0b5tj0az4WSP6yZ3nbcywUlhep0Pw1AeNlQwIGrFYyY5nyaXQ7cnofEwkNJb" +
       "d6MShZGDO+1SHZQMSMiq3ZTdTFTNnpAgfLeDO8lvbKOMcgekuCWyjGnMo3me" +
       "7jnGjbv9SAZ5HyIORx4G2ZZonimIbVyKta2wm2vuE0ixnke4m8cmqA/JZcsh" +
       "Wd1nEyF3c25XTR3Xx3LfC7bAmgTBwqACHqAzuGgU2RJzccNfmHHVnnYU7xiR" +
       "mXZ7vazPU94WaCNWmjA5qncVQb53L+B4IXiNw0YePENyqzgnnzlHWOxZ2YGI" +
       "Dilz2F00G163JbxZIpdIsnlPCkDdXeL8dH2sKZmEEmA4wSNZ7TtRWtVUZ1dn" +
       "5DCqqyUk3JGyzSAUh4ZTe51lPPIxxm93VRk2O87Z5+xmSuFsTWcqVngnUD50" +
       "q70lovIo5BerPNQruEzakgRnqxbP+HXi1MYvaEkDhYbiN5aA2qtgqy36XEIv" +
       "c3fg19xKi7E4569Vzk/VclcRORxFan1CbRhKwvNxsc21DOC77RZY/K6rrhbs" +
       "cYMgUgq3SkjkOCfw6gkuUnZkdxa+MUHSlLsI6sXStDC4nnkLsWucVXOWRZr0" +
       "vF5FhjsuDImumEE6HY8rzMCoEp9c2Q5AEm/kwl4Y3VzP/ZYrEKCIzQllN5RD" +
       "zaiy0zEXGgwfzZoIaXjjcuRjsYltSNkwVSSchS2Yw3iorFK99eByuZ6tLTkl" +
       "3qpId2HR/QXAUhLbM93MoOD57GmNtlpdcHV9OMD4YCxmEVl5ew5WGlczdQXl" +
       "88yQ2QNG7CBle0Sl8kKYfNHSV/yalbhO1oyzj2rZ3au1S4GQ1hNCLVjjYadq" +
       "oZK5BM47CeGA5xWViikB6D1uGCiBmbi+Xu1r7DIQ1Dif8RMjjJS0wsqR2BQY" +
       "kRHYCTSy62VnMdfxYBSmw5OiZy8+mz/Q8oTP4iG+Svw51ATFYJJLbFyX6GRi" +
       "PEdrPOHKMt7qLPsXFJx9qOu26ymItDkKrkO8RXX+eD1vYztoS6UbznWFOZ4T" +
       "yrM1U6QO6hsvBMjEPHCAYW0SkktQeheZqGFzubTTT2rp5kASBoXjJJywPTcY" +
       "5LsjWVOIDbEQMTGIc5BnxS01EAXwKhD0OWWveodOftthyMxAYsFoljoclLmc" +
       "HJ1EliCOijkJVpmp4svyyNpeqQ5unWxXI2UhOG6KRHcMrr45njqLKI9WHm7w" +
       "jiw26qUtLGVzUq2aRG1BkRIpqhVYS9qG1FbBMYjySWdHRoMJwS9YeQlJdJ4X" +
       "KAbkala5sHqa5FckpFyjXJjT3+WkzueifTI8u4Jty58mwcE0vjjKUkuhwCE5" +
       "K0EKy5ue0a5hvQuHRKMjYQfs4b6itn3ngYS+FkaZSymV3QKlDl2AU8evACEj" +
       "RPUSij1G8CM72r4O5D3vq/GxFDDP3e3oHRTauuJRtOvsDGceVhcGFc6NsfX1" +
       "xtNhh0oOxIKkTzFASSWLnjtMQdzW4BgXan+eOEvtTxTBJzvduGIOWqkLdqS2" +
       "o9K5nV1f3XWI4LrOUWqyFj5caiSVOqPNNznuEmBXlgy9Zmto5R2hA01alw3Z" +
       "aiyS5yVN+VRwsonDEncM9HkgD/H6kEsonfPLhKNEDxRr6CIkbs7mtI6vi7Pb" +
       "ertrUXEplAf2BLKszKK1s8QgOtzs8FZADg5kzHBT403OmKetMdAM5+vIUVMj" +
       "TsJiYV+M0Vq6YHl/ckQR2dB5YoV2nJdBkMSufsJs0tMNsclV9oxuejFnd3Bw" +
       "mMII7blob1w9YCxPF2httfIMw0MCdnCgoEyWuONwSBetPmyYzeJAsQZXiqi6" +
       "OS26imNMpR/QIICtdHN0Njm1pTPSu6yI6GQgO2B1ueDrEN63UOHZMoFTFxDs" +
       "/WOFCXhFXfbydVpxNhXzEYkFXS7qR8rZJPP2dDVEDIvksXdP0F6Acy2dDrxy" +
       "LmmXOcMavC+wU+bTwQix2yu6OHzsNE6wTpXwccvFnTXBzjgBugMss/cDZlyN" +
       "2c9UbnvaARWzF4615Ppi3Idz3G3PrUgcG/qscIqtumZU0uU5NA8QO/lz7QDZ" +
       "dglwYiKq6KDnxd24ma4U5m9BDFj84GuxcbyoyzqL8cLTVJwla6oteHWQgTJ0" +
       "nWTFSP0h9CD6YPBnaLvR+zRbTfaesvLTEsxPRRsuTp0Oxusz25OqBi1CTXba" +
       "te0ZIehIKtF7TlUNcMiluQhGuVfLa8cV4oKsCxWtNYOB4+lA1XmnZnGxl8ip" +
       "7CpiXQvFYS1Nsu4ax1GrJgC6VCOzTWdb8iKTPIlxEQ21LoxRUJJtc132aASs" +
       "odnWcfOWmQ9LWFUil8Qs3HJVXyFHs00T8lqAgMygSC66tWW1YNrMoxcoOk/z" +
       "VIbSVW/RqHetOEkxvZSUdpFg5TGxqAYhxwzL8IwK3oXB1LdXOCD7fFbLrkAQ" +
       "jwUwldNJgN+T+IbCwLXo9UVUDTWy+H8bs4lKeSoZsYH2u71Ww9GpUf3NbOrh" +
       "5UBfVSpqUAYaobDf4CdqCyvOEjNRqnpG0AqvSr03CNPb1DYX2gqAHrwrcMhk" +
       "xsOFdrdCuvRwMdNpa6/0I7ZlMPkI4mNSIR6TTP52RYNAilzUXewOxH7QANyo" +
       "w9PxrDczQeJrrkKvC6d5YSQtHvKpK+29tkkCnA+zzFctGFSROFlfM9EtsUro" +
       "9G3o8NYBByrENbvBQxF41Qba6dwxdpMI+qmi9pU6rigAB67NxDJdgrGr2ju6" +
       "oLM5BOLIKhwWb5y8iYIuhLxwqON5BXTZJu2TjCaZczFsuU12DEWJiEeCuLnx" +
       "xaPT/9l3OP2vQe/h9j+8y12/+7vTL98erVvlPn1f+rtumz1L3nnzMQvrzftE" +
       "oduUH7w/4uEt5e+5VV989hL4/d+rj7lt2GMLveUl8LckiNzdXvD//HulId6/" +
       "3P+L/+LXfyGQ/xz08mOWCdPdfaQrqx/MwiHM3rLVJ5advueFnQ73qZfPE0b+" +
       "vcMv/XX2+/0//fLdB57lerwjg/Pti954e4bHR5uw65vi+LY8j+94hvvt3fe7" +
       "f2spn7+7+4D50L78n731rfrnV/MC2e7J8dHHJb/62P61F8n2PPPmlXusX3l2" +
       "39Sz6v6nc3/SH32fdJ0/dqv+UHf3mWfX/NrjNb/2HMg/+Ay+z94Wskv5/Xd3" +
       "H/raY8u/B2rvzWE//kK2wGced+Ie26++N8YfvN/qg8/Y7znG1P3Z//L7IHuf" +
       "hPCTi8jkDyhSYecmWWu6WRK822v3H/LKMgvd4gUi3N/vDy/lD9zdfdh7bFff" +
       "3P3elrz+2H7pvbH9wPO0hhcR/bPvg+i/fqu+3t19uBzCJnOr+0n/6ruhsXpI" +
       "Qf1I9thy3xwatyXsY0u8NxovP7//R51xq//t98HgF2/Vz38jGLy2FGmBJnhs" +
       "hW8Og9uS/WNLvTcGb4Xt33+fsb9wq/6d7u5jcdhRfeM+TUik3g309VK05dxf" +
       "e2z/zW8O9NuSX3hsf+4bA/0vvc/Yf3Srfnkh+QK6ccvPudcg7wb39y1l0Wsf" +
       "+5aH9qP/9zcH923JP3ps/4/3hvuFZMS3JNk8ZOrdn/Qr74PQvcr9q93dq2Hd" +
       "u9l7c9DvXUp0d/fx331s/5dvDp3bkr/32P7GN3YNv/Y+Y//1rfrPl2s4u+15" +
       "Vwbhu7HPTWHepxKWi80DHtvPvQfc76qHv/9WvaiHP/2407c8th/6xkX6QSn9" +
       "zfdB7G/dql/v7j56Ew13lh7t6RvvhtoPLOWP3t19inlsX///BLXbTj/42D75" +
       "xlF7yEX8H98Htb9zq/72o9S7831y6XtK/U1h/fxiSn/4sf2+b47dbkuebvGF" +
       "b4zd/t77jP39W/WbC7t15fPE0Rfv5MNPKfjS3cPffdvd/bV3JpI/+dI/jzzy" +
       "t3xq4Ktr9CGN/MtffbLIeZvUfdmFX3pMS3wylEnw5ObHJkXSfenLT37iyY/8" +
       "qP7ka1+uqhdpbb7def3Qi+jeRn+rqt6Hlv/7+4z9zq36Bwudn8Lyrnl+N2hf" +
       "oP09QJ9/B+1f+iv//6X9Q/blk4cU+SePTtT9JTx1qMvoSz9yn5p56/0JN/e+" +
       "dq/ZH56eJZvf/7xfd4/XV548LlkMwYtrHkzCw4LyR5nlnpPoyZfKJ8mzA588" +
       "wn1jgcfHJ/6TH3rypaf95RtPHvz6J+9Mezdu2amLGVl4aiFUdyy/5L/+PsHR" +
       "V57B/OU3vva4abSYoPCNFxnv/RTYPW/8U3TTf3o/63ffh/H+8a36h93dJ95O" +
       "/3dYw6efh/j2pyz2tOM2+vl/BlC/9Mp7Q/3SzfK8dHdLlF2gXli1eyep7+GZ" +
       "Fi/98fftWwff/o4PED18Jsf/i7/wyQ9/2y8Y/939NziefcrmVfHuw1GfZW/N" +
       "3n/L86tVE0bJPUavPuTy31PhpY/dcrmfgnPr+Hj1gNX/Cw49Yj8HSQAA");
}
