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
      ("H4sIAAAAAAAAAL1dCZgVxbXuuzEMIPu+DgyLbDPsiAO4zMjmACMwiEN07Lm3" +
       "Z+bCnbv2hRkIihghgiEvBFG/KKJBn1FUfMboF6NRXiKKJMEsChqXYF5cInFJ" +
       "8lwi5tU5Vberu6pu355JvjffN1V9q+tUnTrnP6fO6e7b99AZLZRJa8PWRRvL" +
       "zLakkSlbEm2s0dMZI1KTiLWtIk314c/vOh659Yrkm36tU53WOZqpjWf0RqNa" +
       "K9azZnMiHTXbTK1n9Tp9g16eNaOx8upoxqyo1rqGE/GMmdajcTOT0q7RfNVa" +
       "zyhp0eNmVDeNyIJ0osXURlYnyURNsYRZbrSa5Uk9rbeUIyvlNZUxPZMhI3XC" +
       "1twgnZPpxIZoxEib2ohqwjjrHdMbjFh5DTtXDZ8qWtNaSW54tj66OByZru7m" +
       "ieV7b7mq538FtB51Wo9ofKWpm9FwZSJuEn7qtG4tRkuDkc5cFIkYkTqtV9ww" +
       "IiuNdFSPRTeRjol4ndY7E22K62Y2bWRWGJlEbAN07J3JJgmLMGeusVrrRkWS" +
       "DZuJdG45nRqjRiyS+xRqjOlNGVPrz8VCl7cA2oksuhBxGulGPWzkSILro/EI" +
       "yEKgsNY4+lLSgZAWtRhEX9ZUwbhOGrTeVHMxPd5UvtJMR+NNpGsokTVBwIPz" +
       "DloBitDD6/Umo97UBor9augp0qsYBQEkptZP7IYjES0NFrRk08+ZZXN3b44v" +
       "ivuR54gRjgH/nQnRcIFohdFopI142KCE3SZU79P7P/VNv6aRzv2EzrTP41//" +
       "+MJJw595nvYZouizvGGdETbrwwcbur80tHL8nACFYCITBeU7Vo7gr2FnKlqT" +
       "xLD6WyPCybLcyWdWPHfF1vuNP/u1Lou1TuFELNtCcNQrnGhJRmNGeqERN9Jg" +
       "Iou1YiMeqcTzi7UiclwdjRu0dXljY8YwF2vBGDZ1SuBnIqJGMgSIqIgcR+ON" +
       "idxxUjeb8bg1qWlaEfnX+pL/EPm/hNXnmVq4vDnRYpRnzGzEIIZbnpkxfeac" +
       "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" +
       "DLMIeqsIltsJCqdIfmnlKKiIwynwNVoh");
    public static final String jlc$ClassType$jif$1 =
      ("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" +
       "NGT523cAAA==");
    
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
      ("H4sIAAAAAAAAAM28Caw0a3YYdN+bebO8mXg2j/cZ//E8OzOu8auuratrXsZK" +
       "LV370l1du7Gfa+uq6q6ufW1nokCU2CTCgWTsOAo2CDkIghMjlJAoyMgIAQ6x" +
       "kIiiABLEVkQIkbGQhQgKMgnV997//9/735IZiURcqb6v6lvPOd9Zr77Tv/Tb" +
       "d6+0zd2TqsznJC+717u5itvXd37TxhGd+21rLA1vhj8DgF//Mz/2yf/oA3ef" +
       "8O4+kRWHzu+ykC6LLp467+7jl/gSxE1LRlEceXefKuI4OsRN5ufZdRlYFt7d" +
       "p9ssKfyub+JWj9syH24DP932Vdzc7/m0Ub77eFgWbdf0YVc2bXf3SfnkDz7Y" +
       "d1kOylnbvSHffeiYxXnU1nd/6O4l+e6VY+4ny8Bvk59iAd6vCLK39mX4q9kC" +
       "ZnP0w/jplA+esyLq7r73xRnPMH5NWgYsUz98ibu0fLbVBwt/abj79ANIuV8k" +
       "4KFrsiJZhr5S9ssu3d13veeiy6CPVH549pP4ze7uO14ct3voWkZ99J4stynd" +
       "3WdfHHa/0tTcfdcLZ/aW0/pt9ff/9E8UfPHyPcxRHOY3+F9ZJn3+hUl6fIyb" +
       "uAjjh4kf/0H5Z/1v+5Wfevnubhn82RcGP4z5q3/wd/7Alz//q7/2MOa732WM" +
       "FpzisHsz/MXgW/7b76G/RHzgBsZHqrLNbqzwNszvT3X32PPGVC28+G3PVrx1" +
       "vv6081f1/9L9w38h/q2X714V7j4Ulnl/WbjqU2F5qbI8bri4iBu/iyPh7qNx" +
       "EdH3/cLdh5d3OSvih1bteGzjTrj7YH7f9KHy/nsh0XFZ4kaiDy7vWXEsn75X" +
       "fpfev0/V3d3dh5fn7luX55Xl2T7Wm+4uBNPyEoNt10dx0bVgiyIYsUJRsEvj" +
       "NmvB0G/jN2+9WXz7yBdI/ObNNkzjqF9AB8P71zdP2RFsmxB83qHEcbcw1+tL" +
       "T/UvZpvphu3vGV96aTmI73lRKeSLBPFlHsXNm+HXe2r7O3/pzb/58jOxeKRT" +
       "d/epZyu//rjy3Usv3a/4rTexeTjW5VDOi7Av8vzxLx1+VPzxn/q+Dyz8VI0f" +
       "XEh6G/rai9z9XCcIy5u/sOyb4Sd+8n/9R7/8s18rn/N5d/faO8TvnTNv4vN9" +
       "L2LXlOECdRM/X/4Hn/h/5c1f+dprL9944aOLVur8hW8WEf/8i3u8TYzeeKqS" +
       "bhR5Wb772LFsLn5+63qqR17t0qYcn7fck/1j9+/f8k+Xv5eW55/cnhvH3Rpu" +
       "9aJ36Eduf/KM3bu7WRuX97/3x/7U3/vjf/4r/7xYhH4ce+ORr0CbLyPoD6Fw" +
       "9cAtt4N9gZj3mverh+rn//v/5h8iL9+I8FRJf+It2vwQd2+8RTHcFvv4vQr4" +
       "1HM+MZo4Xsb9Tz+3+9M/89s/+SP3TLKM+MK7bfjarbyRyF9IUzZ/9Nfq/+E3" +
       "/u4v/u2XnzNWd/ehqg/yLLyH/HuWhX7g+VaLzsgXvbVA0r5mFpcyyo6ZH+Tx" +
       "jUl/9xPfD/2V/+2nP/nAafnS8nBuzd2X/9kLPG//TuruD//NH/u/Pn+/zEvh" +
       "zWY9J8fzYQ+K8DPPVyabxp9vcEz/8t/63J/9r/yfX1Tqosba7Brfa6aXHuXm" +
       "BtSnFz5ZTun1m3VauDorwqzy83uEv3w/4Pfdl8CNpe6n3d33rW7Fd0/3fZ+9" +
       "b3+1fae9YG+G97mEeOAv/ZvfRf/wb93j81xCbmt81/RODWL5bxFe+C9c/s+X" +
       "v+9D/8XLdx/27j55b/P9orP8vL8duLdY7ZZ+bJTvfs/b+t9ugR/MzRvPNMD3" +
       "vCidb9n2Rdl8rrmW99vo2/uH3yqOCyE+dSPSF5fnM3d3L3/yoX7pH996P1nd" +
       "yk9NL93dv6zvp3zvffl9t+L7H87l9voDDyzX3b3SZV0ePz2qT94f8v1ZPXgS" +
       "DyJ1K+G3A/CF5fnsAgD2WH/hXQD46jcCwAcif36Xo11Y5bLI4fDoCsQ/9fU/" +
       "/k9f/+mvv/wWf+kL73BZ3jrnwWe63+XV+62mZZff+3673M9g/8Evf+0/+fe+" +
       "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" +
       "CCo8N+ngBs7pnEa10hC7Dbja7/qWLvj+");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "nu6U2kfmy2S0pRZO69UMQ210oYNpn/I4bLKoeukTgu0vxC5ExhHscILFxh3u" +
       "WyC1uBHzMZ0vPXQqEe+iTMAapGEBxcVI5dzJUEvqJONDAs8qyWxEmEekTbxP" +
       "VEA4SGhXOf0w7rpNrjCgzRfMGqQuyGUmlChcb5Sj4XU+cTSuLgrMyGiIAOSF" +
       "xsCPYObIarHZZCBm2nMSrq7HNEGzqMbNjDu5KQMyQTjvrqfKDWpCyzZHsDw2" +
       "KXraWY0LMauuOdMTUHKbDFnNeWC1CKc5WN8t+ztdf13DLr5QmtXWuJH5nGdp" +
       "VTuhTnTMNhqmTlfKZo/JUd5VXczsUdhIFhbZlUTGdQYwYVCHwKBclwXQtwGq" +
       "NeO+VrrrFRypXuUMDEZCkiS/+tWbi1o8OrSfeYdD+xr0Hi7twz3l+t3vBb98" +
       "e7Vvhf/0LvB33xZ7lpjy5mOG0Zv3STC3IT90v8XDDdzvvRVfeHbB+f7vQ495" +
       "W/hjDb3lgvNbkh/ubpfXP/deKXb3F9d/8V/5+i9E2p+HXn7MoGC7u492ZfVD" +
       "eTzE+VuW+pZlpe99YSXlPq3weTLEv6/80t/gfiD8Uy/ffeBZHsM7shPfPumN" +
       "t2cvvNrEXd8UxttyGL7zGe63e913//byfO7u7gPWQ/3yf/bWG+PPj+YFst2T" +
       "49XHKb/6WP/1F8n2PKvklXusX3l23syz4v7Tu9/pj7xPKsofvRV/qLv79LNj" +
       "fu3xmF97DuQffAbfZ24TueX5/Xd3H/7aYy28B2rvzWE//sJN+E8/rsQ/1l95" +
       "b4w/eL/UB5+x33OMmfu9/7X3Qfb+gv1PLiJzeUCRiTs/y1vLz7Po3a6Ufzgo" +
       "yzz2ixeIcH++P7w8f+Du7iPBYw1+c+d7m/L6Y/3F98b2A8+v7L+I6J99H0T/" +
       "3K34enf3kXKIm9yv7gf9G++GBviQXvnR/LHmvzk0blO4x5p8bzRefn7+jzrj" +
       "Vv4774PBL96Kn/9GMHhtedQFmuixlr45DG5TxMeaeW8M3grbf/A+fX/xVvy7" +
       "3d3Hkrhj+sZ/mmzHvBvo6PLoy76/9lj/W98c6Lcpv/BY/9w3Bvpffp++//hW" +
       "/PJC8gV085Z7cq9B3g3u71+eRa997Fsf6lf/728O7tuUf/xY/x/vDfcLiXZv" +
       "SSB5yEK73+lX3gehe5X717q7D8V17+fvzUG/d3mOd3cf/93H+n/55tC5Tfn7" +
       "j/VvfGPH8Gvv0/df34r/fDmG1G9Tuozid2Ofm8K8T5MrF5sHPNaffQ+431UP" +
       "/8CteFEPf+pxpW99rD/8jYv0g1L6W++D2N++Fb/e3b16Ew1/Vh/t6RvvhtoP" +
       "Ls8fubv7JPtYv/7/CWq3lX7osX7yjaP2kGf3P74Pan/3VvydR6n35/vEyfeU" +
       "+pvC+vnFlP7wY/393xy73aY8XeLz3xi7/f336fsHt+I3F3bryudJkS+eyUee" +
       "UvClu4e/+7q7++vvTJJ+8sV/ETnSb0mj/wq6fkiR/tJXnixy3mZ1X3bxFx9T" +
       "7p4MZRY9ufmxWZF1X/zSk5948iM/enjytS9V1Yu0tt7uvH74RXRvvb9VVe9D" +
       "y//9ffp+51b8w4XOT2F51xy2G7Qv0P4eoM+9g/Yv/dX//9L+IbPwyUP695NH" +
       "J+r+EJ461OXxiz9yn3Z4a/0J/xJ87V6zP7w9S6S+/7yfd4/Xl588TlkMwYtz" +
       "HkzCw4TyR9nlnLPjky+WT7JnGz55hPvGAo+vT8InX33yxaft5RtPHvz6J+9M" +
       "6TZvmZeLGVl4aiFUZ5RfDF9/n+Doy89g/tIbX3tc9LiYoPiNFxnv/RTYPW/8" +
       "M3TTf3o/6nffh/H+ya34R93dt7yd/u+whk9/+uA7nrLY04Zb7+f+OUD90ivv" +
       "DfVLN8vz0t0tCXSBemHV7p2kvodnWrz0x+9bHv93vOPHdR5+Aib8S7/wiY98" +
       "+y+Y/93970s8+5mWD8l3Hzn2ef7WzPS3vH+oauJjdo/Rhx7y1O+p8NLHbnnK" +
       "T8G5NXy8esDq/wUh5umD40cAAA==");
}
