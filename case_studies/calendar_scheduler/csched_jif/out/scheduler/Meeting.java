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
      ("H4sIAAAAAAAAAM28C8z0anoQ9p2ze85e2Ws29938ZE/Cbrw548uMPc4hEfb4" +
       "Ovb4OrbHTpMT38ce329jOyyCIkgKamjpJgS1CagKFdBAqgoKok2VqmobSlSp" +
       "CNFWakmESilKoyqqSkWVQj3f9/3/f85/LuxKLe0nve/rea/P87zP9ZMf/+Jv" +
       "3b3SNndPqjKb4qzsXu+mKmxfV9ymDYNd5rbtcel40/9pYPW1P/Wjn/r3P3D3" +
       "Sefuk0mhd26X+Luy6MKxc+4+noe5FzYtEQRh4Nx9ugjDQA+bxM2SeZlYFs7d" +
       "Z9okLtyub8JWC9syG24TP9P2Vdjcn/m0U7z7uF8Wbdf0flc2bXf3KTF1B3fV" +
       "d0m2EpO2e0O8ezVKwixo67s/cPeSePdKlLnxMvGbxadYrO53XDG3/mX6R5MF" +
       "zCZy/fDpkg9ekiLo7r7rxRXPMH5NWCYsSz+Uh925fHbUBwt36bj7zANImVvE" +
       "K71rkiJepr5S9ssp3d23v+emy6QPV65/cePwze7uW1+cpzwMLbM+ck+W25Lu" +
       "7nMvTrvfaWzuvv2FO3vLbf2W9Ht/6scLrnj5HuYg9LMb/K8si77wwiItjMIm" +
       "LPzwYeHHv0/8Gfebf/knX767WyZ/7oXJD3P+2u//7d/3lS/8yq8+zPmOd5kj" +
       "e2nod2/6v+B94r/+zt2X8Q/cwPhwVbbJjRXehvn9rSqPI2+M1cKL3/xsx9vg" +
       "608Hf0X7z+0/+BfD33z57qP83at+mfX5wlWf9su8SrKwYcMibNwuDPi7j4RF" +
       "sLsf5+8+tDyLSRE+9MpR1IYdf/fB7L7r1fL+90KiaNniRqIPLs9JEZVPnyu3" +
       "O98/j9Xd3d2HlnL3TUt5ZSn0Y7vt7vzVuczDVdv1QVh07apdIxscXK9X3Tls" +
       "k3blu2345m00CW8/sgUSt3mz9c9h0C+gr/z7xzfTJFq1jb96PnAIw25hrteX" +
       "kepfzDHjDdvfdX3ppeUivvNFpZAtEsSVWRA2b/pf60n6t//ym3/r5Wdi8Uin" +
       "7u7Tz3Z+/XHnu5deut/xm25i83Cty6VcFmFf5PnjX9Z/ZP9jP/ndH1j4qbp+" +
       "cCHpbeprL3L3c53AL0/uwrJv+p/8if/5H//Sz3y1fM7n3d1r7xC/d668ic93" +
       "v4hdU/oL1E34fPvve+L+1Td/+auvvXzjhY8sWqlzF75ZRPwLL57xNjF646lK" +
       "ulHkZfHuY1HZ5G52G3qqRz7anZvy+rznnuwfu3/+xD9b/l5ayj+9lRvH3Tpu" +
       "7aJ3do/c/uQZu3d3o3xdnv/+H/2Tf/+P/bkf+BfAIj+wRr+CrL9/DVcPzHK7" +
       "1xdoea94f1Cvfu6//a/+EfLyjQZPdfQn36LM9bB74y164bbZx+81wKefs8mx" +
       "CcNl3v/ws8q/8dO/9RM/fM8jy4wvvtuBr93qG4XchTJl80d+tf7vfv3v/cLf" +
       "efk5X3V3r1a9lyX+PeTfuWz0vc+PWlRGtqitBZL2NaPIyyCJEtfLwhuP/s4n" +
       "vwf6q//LT33qgdGypefh2pq7r/zzN3je/23k3R/8Wz/6f3zhfpuX/JvJek6O" +
       "59Me9OBnn+9MNI073eAY/9Df/vyf/i/cn1s06qLF2mQO7xXTS49icwPqMwub" +
       "LLf0+s04LUydFH5Sudk9wl+5n/B77mvgxlH3y+7ux8Bb9R3j/djn7vs/2r7T" +
       "XDA3u/tcQJzVL/5b3777od+8x+e5gNz2+PbxnQrEdN8iu/BfzP/3l7/71f/s" +
       "5bsPOXefujf5btGZbtbfLtxZjHa7e+wU737X28bfboAfrM0bzxTAd74onG85" +
       "9kXRfK64lufb7Nvzh94qjQshPn0j0peW8tm7u5c/9dC+9E9uo5+qbvWnx5fu" +
       "7h/Q+yXfdV9/9636nod7uT1+7wPLdXevdEmXhU+v6lP3l3x/Vw+OxINI3Wr4" +
       "7QB8cSmfWwDYPLZffBcAfvDrAeADgTu9y9UurJIvcjg8egLhT37tj/2z13/q" +
       "ay+/xV364js8lreueXCZ7k/56P1R43LK736/U+5XMP/wl776H/75r/7Egzvx" +
       "mbcbf7ro87/0d/+vX3v9Z3/jb76LpfnA4ti9J8G+vJRvWQj1Y48t9y4E478e" +
       "gn1k4Z2m48r+nrGp9zzw9yzl25aD/pXHtn2XA6Wv58Cb0/K+x338KX7fsRzz" +
       "Vx7bP/Uux+nvcdxyRtUkw2JAxmeb3uuCjz1u9jOP7Z94y6YL7/bt4uQ/5d3P" +
       "3tTMC8b8LdA+8MBLy1mvIK+vX0duv/+ld4fnA/foL9q5vQ8rlhVRUjwqrYUe" +
       "35Jm/mtPTZ+5QLDoyNeWw2/Db7zLiQvffeK5XInl4p7/8f/xX/u1P/HFX194" +
       "aH/3ynBTIguzvUX4pP4Wv/zRX/zpz3/sa7/xx+9NxkKmH/n3/vqHP3zb1b9V" +
       "P7r49jdI9OVq/FB02+5wr+PD4AbMPQjkI+PfGrpbLEX5Nol+RpInd9y65Ymn" +
       "fwco2J3O5hhZKw9seV7pgTNJWRO5V7Ocp0dDhXlUp3naHodmRNQR3Q6KBVzo" +
       "5JzEpdWhW4PxcOvKuJ2pD65+6UerZyIh2Zjtbl2a0dw4W6O26hy2MwTwt9ih" +
       "R5RhFicvx88r11sPh1UkFUdp3lRzJB+lAhs8wtdh9ZhnlAna7v5cd7sjiPsG" +
       "eyn12tb74VwXCRiol6qO+2BQFGcruSINhriVoR2U5HpT5ll8hdDKtNWZTKSt" +
       "eaRdygK5ymjiLUKC5VVLHMfSuj1ruSdrr+lKZUPGgeRn8JJ1RehWEFfROn25" +
       "Ohd9dz6j4WVdImzQXKf4WLm0AXrVsRYNp+KrWJAqIxFQ09wETCxfoEXNKbq3" +
       "kwO6ztb+pLfVdeysnXkuJEsm+wFy2YspQ/5+2FaukVVaV1xgJS3X3j6XscoZ" +
       "K7Pre3TmRGR0cajuwkmzPFWXdCHecumBVzDThSYXr82NUlkhd0Xqtdm3Drgy" +
       "r52DCqQgawKYMqEwWujGkhs+ZlJjFI7TygJXTHmAjm3mry87flAdzL0afSdo" +
       "Dr9nI8YI0vOG0micbTFgl2p0PA36uXOVZG3I3hU1aCgD971oGFeEvOzX2dYF" +
       "hPHAx7s1t+Nkhd+BMaNWTVSREp6byMYGGb1UrCQvW9aeOqFeQ8ZedHcmgdCH" +
       "q82HDCVrbUfQPqfWPSEMPqaSZQrVfVwZdUuQKn05d86p4e2O1kGJbrQL6K/G" +
       "sxVF3c6GRcBhilZCBaLZBtOePquiZjcQeQTy8UKv9/1mE4ZWf0Vg5RQeLcmU" +
       "140pOFA0wEG63QanVUoTZlW0giiXQ20u7mq5wyETARD1ogg6e1wL11OMEm2N" +
       "pNpMnrYnORONS8Jy0AHq6csoz/sNbq/4UGywUYlwoAkcdNjYpwQ0rserySmG" +
       "eK1ou6hrL0OPNEAm/nzaDZrdk7My49E0nZhsL3hH8GJIlFUEubDalFBiMNso" +
       "0mhVqoiLahzXm7RV3XVXpJpElqMsW2fBqYBQi1BQAQjguIr2zmrCyV1lI+O+" +
       "AUHPOu7klPPBQTcOaCTnlJbpdaHVgp+iwV49CMjpGuQ8lQLJeS/FdbIO3O5I" +
       "sf4eddVYQbdED6KZKhzxsXTXHsksoYNT0BHqesz53KW4EVIQR9MSLWn8hZnt" +
       "jkvcvtzByL7gImC8riwlPECzLe6ngETzBFKcHdRwMQDDRHQ417UpsIZ5sFYJ" +
       "3tSWucMjX8mg8Yjuqq1WKyNdmTsY7oNgwmIlL+f2QOsUgDozvTkGEneaYPM6" +
       "GHQaOk1HeHGVl4ZpAqf0euQB9JJCOWjtwnBfesAxzNLteDhXFAuuqj1SMah2" +
       "Ecw1DxJwzpOrik12Qupi3jzD6QZGmnIBe9bBiyMol11BjmXHMO4x4XXRzQ6o" +
       "p2Bg2QtD33pGOjh1JBPrSSrlA6WM6qKduTnwxLZYH8czH1/hnq829c44JmZm" +
       "VEU50+ZpC4k0OQRbMS5Akz+1vB1sOKCshtwCuwljthh8vFDuGeb30A49EAMy" +
       "zXJDc/YS8gH4oQG8TGwmzFmEBCrBKcF7YmzqNAbSveEtyjHsL0jfeTWyuU4r" +
       "VsqmHa3zoFbHG07NKhkhLIflc7uZYTVSTiWLhDgqW9fDNmlzN1e0C99tkt35" +
       "JA8HcvDpaRXY5CVD2S2y4a11oWfXyD76eJt4FkPgHJuIJFDHsqwACYCm+35G" +
       "17UaMaqjG4aQ553CdNKWEskNWpyi4uBE23Zk7S3vpHB/GNdSWInhSrYcNNCv" +
       "pheXgFUzay9c5ccr1QtmogcHDcVU0LswBuFe275QjupKa8qwWmMrDIkX0ygP" +
       "aIt1mn01S87Sslg42EdSZRipiAqTQ6pNlmAElHAHjsanRiywfXKOVCxRQjHV" +
       "ZMucCCpwGeyID6tZoUn/uo4nET4nAi1lOlh6TMXkgZHROlnQuYpqalfMXO3p" +
       "mkSNO9cic4SFoNXlPHPpCVobSsYYEXGZwMlqK1Cu9B0vGmHcc1YmaHyR4OyI" +
       "hIazJUyW7qOzQFpKJezztuYkJ04ixQPziy1XA1U76npKsEX/EcFGloQsPUK2" +
       "lZ+w7chowOhqFQHB6JGAzCnq1rUDyhhDewFDbzM2kc/8ebQNbzon+2plHHcQ" +
       "30m0U4WJL5IQ79BxIfLtlW9YqDwY+InUWgoLGzIyu9HtLE93+32PSPkIuLgS" +
       "uGAfXzCZFy/+GcSz8ZhclTHfj+p47k56PDBSBg3i8axjtcGybnGx6khxs62K" +
       "w8Z5tSod0wtPm1HaxKdj6qsex6OAUQwiivonMLM7pBQCBJJGTIcRbMAghmrO" +
       "wc7U0YKTe60BymMiUjs4opwVeMjOtGoa10u+51EuTHpKHStgL3V8Kmv0WtoT" +
       "An9mStIC+K2Ro+HZv9BmrTZtZXF6dSq2+CIWkgTq/FkqkXCetsVlnOpGXjUh" +
       "3nUhDgNhYZ94cUe0DB9OFgHokzPDxuijbQhCUcQZlxHX03GMOE2hzqrmoLad" +
       "JPqOpuQrz5eg0cUCfqKpi2LsdAbuALgEseC8WZVA5QfM1WLXHFSSum7xngwe" +
       "Qd5kjgeDg+2NGnYo72hprx5yYjxOM7tp4lZKjlqGDc0F1avLJtUPmSfkHhxT" +
       "YjQalgGYuR6bOeB3yEqfOcBcSQp2oSo9caM4JQ8HZKdNEofzDt7Tir2VAP14" +
       "2nasRk/i2mR5vxnwK7wFTlyA0lrsxeyuR5lmmnLlZEXYKs8yfEOuPChzLM5k" +
       "Fo0kKrS0Q6+CD+bqmBndthf1dTE0ah750Eqvuvk8DFC0GIAWw6nthcjWbso6" +
       "cVdvM8KE0YI0dCwoZHh9mNkyNyxbiF1fQMe5UgCeNpUCGteKwUw2ftmt1m7W" +
       "AqOeYcctS2wuZy2V41pvj0kD9LvreXcdwHNcsmud0XdX2/H7Q7PNo/NqXJHR" +
       "SqVHjTi2jj63grewCKA7hBnEJO5lpby5LnqvXSySkzP+qoKs2cGViM1FcyPO" +
       "VLfbpf0iNdeVzHUUHe8P1CmqSb3IB7GbMVdBmg7iT9Z6CK8aEiXzEVfk04CM" +
       "8LqzkQIS6N3VylnrtDgF0qSSAiYUaywClK19HXih1bl6hU0yWUnpYd1blLpy" +
       "klVNX3IPLx3Kumb7jLDdEjrCEYP5B3lvRTMzj2y7WID1FqdTq5jWcHtk/I2j" +
       "hbQ7TSOLmuogw0LEgdo1CgP5KGimrpd1dzKccdaqFZdeQbs/uKB7KKTTRhdY" +
       "aZYYEG4RJcRWB1Ox8OsWyLGkMZ1UC5s978KX9ope5mMayzuEWEPazrSOR66g" +
       "5exE68lJFE+FSF1Q/NCvENtpNZJnS6m6qO1uc9R6dK+YBaYD2WgRm8hmNlGa" +
       "y8eViVlrfBH0k9DDx3jrQ7mc8kYqtP7+oh8wGmwyG5QiNexJl0hnURObLt62" +
       "gS45R7aSi51PHS17Og0Yt/W0tub3XbI4Zjq9EGkoBGyWTkKqxq3jT6ID8YHl" +
       "dZ3KO/nikvVhDhk25xKdXsawmvLxWtpITBeneTtdDpt4vcr5TbhyN/DM18DV" +
       "AKFUoiDVsDirGkOOPYb7ofYazNjtc/gAqUjC4pktbcr1OIQ47fabsrGoMKrx" +
       "46FUAirAd1hxUQYrmXBCbd1817MpofZKs0c11iTbi0Qg5zGunZrZqNah0rf+" +
       "hQoiLdpB3Kno7djGmX5dYv2mZ5Fo03C53BfdVOZrkt5tchtoaL8F94GRjIlk" +
       "HOpd7BtK0JmnaJPWCUauQygBlZY7ZxAOaATnNmu6c6TjxhLYsIEXtbAcNkIB" +
       "zFWrhWYQ3wp2259Xk2cp6xaOPDDgSUen1QlU0dlifP2QkFxnMDu0W7w60iNH" +
       "qsZxOaRNsuFL9hp6AAJThbxjGJKx/E0iXGMmrKFjQJ1CGprXPrRj5eoEToPi" +
       "ZTEZ1tIWRgWTrbIt1zin6ArEMgeNkg0k6gWF6CbcHQnhquDIVkQHm8rW4xwH" +
       "HizYoh2ceiyfa/JM74AUBXJZlUeIQeQCVlkO1trFLbepC7s5r6GC2A6yb/O2" +
       "gcA+tEHLkmMpeLGhyHaEznhsyxiVchDZTrOE8cRRMrbI4lHbkDCri8XDZxLb" +
       "gXI744svPehm0NRHDnFb5losugNGg01D1u5QrYeOLg5k3fg2jTBKvGeFQNiG" +
       "eIVoo3beHCb0vIpOpETbc+EnghSDEOWCJT6arsf3fe31dtsSjb5CnGtgtMex" +
       "c1kPuSwXo2QoKleQa6qZGqS1Kin8mUWTiDhr17VzDrUWDwyYtFIPFGSOQ8PF" +
       "74LJ9CIwMHaNy/UFaSp1Hi+rhsXtCECP/cEb0rNIqsLkTrkLRlFI0DbcLqZw" +
       "Pq0DS6jVPmDnIlVDdoWYlYfNRL63cFxrdmefofNTKhGcTeqnS7zCLHyFK8P2" +
       "cgDmY8eh4ySRW2mOi3Sj6e2VzSS0T+mQ8vxLTjCY2cotVhppdognAzlQa0W9" +
       "Vg3XWKe1VCjg7hq1GTw2140c2YvADPIwY13sb7PQrcFAkU7UaXLlthHZegdi" +
       "i5SCTnA5XpJ4x7CdrewTEo8BG+9OsV8CkBBVkQbHZ5xiNWvM+k0BGEArGgJF" +
       "XM3onGmUFUKYaarykE923Q5YwU1ONeLTIRjBk6AROGtta+HEDJ1ss9vkOIG8" +
       "iG/NIhMIaEPm0iU68vop1bScph1TB6NqlEAFU3dJcK6Aw1W0LZI/7a/GwPpp" +
       "KovjJAcbUjn4lIjjanoUUIbZHT2MCKE1jGlUDe43dYSgAr61LG2vWIpDi32H" +
       "+Is5QSBsq5wk5Sy6hLnVWnh0rEM/yFoEAA2Gr0uuCM/4hQXbZO8skSG5xpSW" +
       "vsKZmFURazviZQvjtSCQpFlaTmcfLcpr4TO1W4QJr7aO1Vh+W9XXNi82unFh" +
       "cykysH2b+AAFM94ikV6VbLItHG0MPzE7F9FqCo3yMeEZZALiamCceJUKYNGL" +
       "sptlHjCddw5mZdRqLA0lb/GRVSLGP9W8v2en4dqsEdPnIwZeK3lRKRN1QLZp" +
       "ePQGjrTVOqhaiKEdzB1nKAVi19RgcL9tK9hZ25NDnI25jyY78wkLmsRBn5t4" +
       "RCnmmEzIaKfqWtz7UTzWJKQZ5Xk1H/civhh5UfAEMC/zgmzydUH1HdvlyuKN" +
       "qOtLvT1v3WztZEM2V7THQfsBkhzlwpOEB6Y0T7FJVoTz1SZPc2rX8Z7g3RbX" +
       "fUsgeAIQSlGj452LEHLsLbIKMnw1bUOeoGOBoHe16s5wSFrmFVRhTTplS1yw" +
       "uPwcs4RfVtPDNsXvbEYlMJEgSyNm4/O+PuKIYM3QgbAZiCOInTRb5iZXQeKa" +
       "oCkRO4SBSolA+oeGUE86RdngIsUq3YkWs66uOXkUz2cCs4CmlmbiKlVZpx8O" +
       "PrM6tpuiOUnYaUMbCUW5pU2R7HWJuQcJT0OzJGO8RYlYKsXDaSLP7cHbd8Du" +
       "TBDjEoQGhUBe6UYVeSYOr8ECFoRngNVoGrXdkz5fKg5iMlqvslTnV2C64+yY" +
       "WQVzGgKq6hEpc03g3USV+WAw7f4MnGULEQzqeiFLmqv3Slud233e7QhVCyxW" +
       "RtphzNlrvMs9PSzTNmclbLWY1F5R8eMYQr2BsOCh1pVtTa9EekhtM+cz+boP" +
       "YF2N8rW2zheNf050MHTLrY4rJRTqFSZt2/xkZIOVkpehLr2ix1tLLIuwQzC+" +
       "G+S0n4LcxOkmUXlobV+WUBt306y2UR1qEwYQ8fk0bmQFkZOKofDEHIAhCkzi" +
       "siLRYSjGa07Ri9+e+ydloAxEYs+zpZ09aY0KATx7uq97KzgZdHQ8BfEgSRaR" +
       "XTdnIq09Ut40loV528te2gxOVVyiOIB2");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "+e+p8NLHbrncT8G5dXy8esDq/wYpQZXUBkkAAA==");
}
