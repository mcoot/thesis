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
    public static final long jlc$SourceLastModified$jif = 1501296027523L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "xByehpjrMyAmVDcwgqa07d0hMhQ3taU3");
    public static final String jlc$ClassType$jif$1 =
      ("D77FYOMNGXMAHm/LyBsxMm8+Ou7c2Q3uMO/vtVfwTYo6QvKKeJ3XRroT0QFI" +
       "Lq/dX8JIw+6dad7dD8U9JsltEYwW+D2wMBM7lM83JAxlnznsBwCFvGMBr/u4" +
       "AY7OHAbuXx1OKxPbHZnI6OoVA4g5V69oQ0AmtgdlgoE5V6+sPm6Z2N6lTMDm" +
       "hEyfV/D60u7JBIBcwuuLMpOJNEeksf1QvEBlwlTZjx+FycRwPl9bGMo+mbDv" +
       "5EFHjdfSscvEy36ZSHv/NOYck8Z+nZFMIEDsoCMAwWPSWPCYlIP9wRGA4DFp" +
       "zHtMStffw/5Vm4LA7wSz37YV79/SL3fwlnkH2Y94WD/2lcd/R839G1+u52ya" +
       "vjfJuPI8LNmXvWOHaf4N1ITn/8Hz/y86WBZR4CZcuIT82fuTh/DDCu3sN5Ib" +
       "xL+eOb7i6b2j9/DvXKf8AogDsWvLzNkrP57EfiSxB2X0ihUwaW41yWHJI+IA" +
       "v/o4MuVo1ljZM8Z83veBvJPt3/mDIt+lQ57VFTjpwMqOsL11z484N4hLyKrr" +
       "XujMvwJ/hiVPNur0dsOEn1POE63vJcBYy9lpAvsmdewvdOBT/F89dw3r3vGP" +
       "LL51TnXO1wvS/9AA+4bV/wG2GJUxMlsAAA==");
    
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
    public static final long jlc$SourceLastModified$jl = 1501296027523L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAOV8eewse1ZX3zvz3uzMAgPDwAyXmcfwhpp51VXVVdU9j0G7" +
       "qrpr79q6uqtrZnhW19K1V3XtVTCKokCAgIEBMQJ/kMF1BIMSYwyJMW4EBCVG" +
       "NEYxhIgGiZIoGhWwun+/u7z77rvMiyIab/Jdur7b+Z7v+X7OOb+c7/3cr0+e" +
       "KYvJvTyL+1OcVS9Ufe6WL8hWUboOGVtluR0/vGR/HwB+5k99/Tt+4nWTt5uT" +
       "twepVllVYJNZWrldZU7emrjJ0S3KpeO4jjl5Z+q6juYWgRUHw9gxS83Ju8rg" +
       "lFpVXbil6pZZ3Fw6vqusc7e4rnn/ozB5q52lZVXUdpUVZTV5hxBajQXWVRCD" +
       "QlBWLwqTZ73AjZ3yPPnDkzvC5Bkvtk5jxy8W7u8CvM4Iri/fx+5vDkYyC8+y" +
       "3ftDXh8FqVNNvuLxEQ92/Bw/dhiHviFxKz97sNTrU2v8MHnXDUmxlZ5ArSqC" +
       "9DR2fSarx1WqyXtfddKx0xtzy46sk/tSNXnP4/3km6ax15uubLkMqSbvfrzb" +
       "daaumLz3sTN75LR+ffO13/UNKZPevdLsuHZ8of+ZcdD7Hxukup5buKnt3gx8" +
       "69cI32998U99293JZOz87sc63/T569/4G3/wI+//W//gps+XPaGPdAxdu3rJ" +
       "/uzxC/7xl5MfXrzuQsYb86wMLqLwsp1fT1W+bXmxy0dZ/OIHM14aX7jf+LfU" +
       "v3f4pr/o/trdyZvZybN2FtfJKFXvtLMkD2K3oN3ULazKddjJm9zUIa/t7OQN" +
       "Y10IUvfmq+R5pVuxk9fH10/PZtffI4u8cYoLi14/1oPUy+7Xc6vyr/Uun0wm" +
       "bxjT5F1jenZMn7gt5Wqirz72Sb10i/U4S/lJKrPrxE2r8pN6Gnyy8t0yKD9p" +
       "W6X7UlnVTjD2GOX7luvX6kth4H2yLOzrj0/K1nj0L4yf8t+ribvLjt7W3rkz" +
       "MvvLH7/48XhLmCx23OIl+zM1sfqNH3vpZ+4+EP1bXlSTN1+mfOE65eTOnetU" +
       "X3S5EzdnNnI8Gm/yeFnf+mHtU9wf+rYPvG4Ulrx9/civS9fnHhfdhxeeHWvW" +
       "uIGX7Ld/67/9zR///k9nD4W4mjz3irv1ypGXu/GBx7dVZLbrjNjzcPqvuWf9" +
       "5Es/9enn7l4O+k3jdiprFIrx/r7/8TVedkdevI83F1bcFSZv8bIiseJL032Q" +
       "eHPlF1n78MuV32+51r/gd8Z/d8b025d0EafLh0s5ggp5K8r3HshyNUmk4mSl" +
       "wSgDv/wt3/PL3/6jH/vfKRHiuOOLQHwMmn4Exj6KzPMb0bgc5mMMvELpx7X8" +
       "h/7Zz/075O5l4/dR9+2PwLPmVi8+ctMvk731eqff+VA2toXrjv3+5Q/I3/t9" +
       "v/6tn7gKxtjjg09a8LlLfmGLNbIjK/7EPzj/81/6V5/9J3cfClM1eTavj3Fg" +
       "Xyn/8nGiDz1cagSBeASikZLyOT1NMifwAusYuxfB/B9v/yroJ//9d73jRrri" +
       "8cvNWRWTj/zuEzz8/qXE5Jt+5uv/y/uv09yxL0roITsedrtBti98OPOyKKz+" +
       "Qkf3R3/hfX/671s/NGLkiEtlMLhXqLlze1cuRL2rmnzBeEovXNTNC4J1dOPr" +
       "Zj9ybfzqaw5cROg6ZHJtm16yL+uube++fn9r+UrwX1+06MMbYYKf+8H3kl/3" +
       "a9e9PLwRlzne270SKnbWI5cV/ovJf777gWf/7t3JG8zJO64K3EqrnRXXl8M2" +
       "RxVckrcfhcnbXtb+cnV6oztefHDjv/zx2/jIso/fxYcQNdYvvS/1Nzx6/W7x" +
       "e/JVY3rjmP7GbflnL63vyC/5O7s7k2sFuw75imv+gUv2VfdF7g15ETTj/byR" +
       "uWryTBVUsXv/rN5xPeXrYd3YBjd36pLDL6fio2N605h+9bb82SdQ8XWvQsWl" +
       "+rH7BLwtvwDx8jhCoWVfBflrX3XRj4/pLeMEH7opJ//9CYuSn8+ib7Dq0TQq" +
       "yvKVpshVum+shf/4uV/6tV942/t+7Aqzrz+O2HQ9lMdtuFeaaC+zvK5rvunB" +
       "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" +
       "YaLRhwUUWINNR1uRIr8Ek/l8yitgPOsY");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "vm7UQ5frdqn/gfzmwv5PczXmkdVGAAA=");
}
