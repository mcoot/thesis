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
    public static final long jlc$SourceLastModified$jif = 1501499159248L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "oGlte1eIDMU1bZnNg28x2Hh11hyAxxuy");
    public static final String jlc$ClassType$jif$1 =
      ("8kaUzJsOjju3dIE71Pt77RV8k6KeuNMUqxe1CV2J6ABkIavncaAZ2L0jw7u7" +
       "objdEvJbRLMFfhEszMQOZfOpYSj7zGEfAChiHZexejEPcHDmMHD/6r2MMrHN" +
       "lYmsrl5RgJh79Yo0BGRiW1AmKJh79cruw8vEtk5lAjYnFPL8Lqv573hlIRMA" +
       "sovVj2cnExmOSGPPQ/EMkQlLoz9+FCYTw9l8r4Wh7JMJ504edNzP6r2HLhMv" +
       "+WUi4/3TmHtMGns1K5lAgNg+VwCCx6Sx4DEpA/uLKwDBY9KY95iUrL+b86s2" +
       "gwO/FEx/3Va6e3Of/EGb5+2jP+Jh/9xXAfslNf5XvrjnXJK+Nyu48gIs6Ze9" +
       "Y++R/BuoCc//g+f/37XTLGIwT7hwCfmb90cP4YcVUvRXkhulf0wYX/nYnlG7" +
       "2Xeu034BxIXYuXnW7As+nUx/JrEbYfSqVTBpfo2QR5NHxAF+93FE2tHssXJn" +
       "jvm29z0FRzu/9AdFIadDntUNdtOBC9rD9tY9P+PcKC0TVl/xTEfhxfgzLAWK" +
       "WW+kTAt+ULlAsr+XAGOtpKcJ9JvUsb+TgUf7v3rODcvv+EeWXj+nJu/HBZl/" +
       "aIB+w+r/ACDXrfE0WwAA");
    
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
    public static final long jlc$SourceLastModified$jl = 1501499159248L;
    public static final String jlc$ClassType$jl =
      ("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" +
       "Ku9kCJwiq32/m+VnyWwOqZaxIUrCdjfD");
    public static final String jlc$ClassType$jl$1 =
      ("96tIOzgYFsIG7CpdiRQHvLUshK/rknNH52iHl7FYUAMOCbQkV65iRCthU8/m" +
       "wzbHuPXRZBa6U/NK7JLOhi5jMm4zxVICfUe0OKYKjS4IK0QISMp2/RivbGUb" +
       "ets97iu4GmkwuDgr1D5eKCwe7YkH30CKpbTm01Q/+IHVzeCDuCexWEAPnobB" +
       "vhNaS2dRG2In4NgSJw9FzYp8RIsscYaI0Tbw1bpGCB+jK7haEgzXMwC3DEyQ" +
       "FHik2462KQeuClpY4ghPWdTKnp/XOcFj/BJFqZ1DI4GprTFxASoDLp/N7RTz" +
       "erL0SY3oY7x1zCWLt72RIWu9srfuqh5x9uImxaKpNGtcpJcyZ6eKS4w/jULn" +
       "nijQn6Igc9hhRaTTvOIB/EI7k4C+3GxlbrZI9LNINyNWSddoy1NB7/Y1VAML" +
       "E52iR2LhRuwJUYRxpugQNKXFx77gpggwl9msjoaT4Q70yt0yM9O2+V08PSaL" +
       "3lyMVLRMyFgAImNVQLScHY++asBw5UGznF/r/JzodCEmimMcxGgbqAi51o8a" +
       "4A0VvwlmgO0eoXRYwNEcwEJPc9wEAYMFNKAOuzxZopWjuwrfD76T7bgkNOfC" +
       "zC00Ex9t+TAAQ5WAeQ3A0A5wYYA3Y9aSekbZA8legoHSAZjFImiNYVvv68rf" +
       "LahtR/CiqEgMPdoUR3zoEKRSKGLqM6zR0OIKIQQT1NY5ie3LFhGA8Z5g1cha" +
       "k4rM7ARRmIYlFTtQNHr3VZtujLzOhnkPzuBUEWnE1OGWX28XENtLEOlo20Kz" +
       "sJWxdTuzclHNODF7lJ9FOWKXCgwRLOCsZic9ibYeAO6OPBDA4tDSfpTZq9SB" +
       "1BKS6nBp1d7ULOh+ah2WkkRo1AwmMNKuaddSBCidSxRvbIQoI6cDTKzQxVKU" +
       "/JChm/kRX4v4cV0Y5VKIm9EI1tsEVecUpB+KU39i+2yYnpyWGk2JNYhjAtBR" +
       "u93OIEUw2Bn79bmUKm67WCzWhAMnyDF1D8fIQpa2AKSSsAMbX9gfCTWV/J7e" +
       "mTyUM8WSPU8NatoMqqxM7dnUjQUSk2eDoqCFUZGRWUTnfvSyMGujVwCeJWsx" +
       "X6iiNVvBOp1kpVnyR5pCN/MNmQOeuG785aZvWtVM0EVFdxa93JlrxTwgvANB" +
       "JzxeT1PHWYJHg9st4zM2PZTbFJR8OYeY1fGEDVNntPQo6YCFwr41WManmSPK" +
       "DKFJj7xr2oVu5bv9fJ4twYPKleraWMbUMAfnZzZvo6ExcIjW1OMiBc7IhlJW" +
       "XK5pnK2zQDoPRiyXqTgaxQRm+VCHrDEhriDGLFhLp5dQFvvj7SkXFlrm/qYb" +
       "1Fquz/MmL4viIIqCtdnVwejS7RyzofLImB/2+4W8bLClsQpOWyLkFqZMcO4q" +
       "PEPeQcVnEktPhWQ57mBHt/sh9JjMgs9IylcNF6/nq8XitD2qEK4zBiUZJV7u" +
       "+MN4cOmBdNU4QECOcJIOSfiM5NKQX89ke3lQq87M9+2uSyI80Xq7Xxx21QZS" +
       "YoUWGSmzAWzNR2alaYG8J1JKcNpg2uRYyQtDhWIsU1O6sq74JVUSS+JQxm6/" +
       "swnpjHN5mXBu7svKZgNKiu0bxzAnF7GSRJBZxv2m3JekkcnHHViufAcRigBl" +
       "jpBOiAhM8AElJb1+EOmWM2cISJ0yrNETYRmPDqset9PD/iwZdHqg8qLns+A0" +
       "V6BQyTRoL48XdqxQIG1KOLZOY1beJbPIdr0h9Gdt45VoaCOIB8/Tcog2LciB" +
       "lBcsapnZqprrAu3a06fUFmI3cUudgUPhGLVhsUU8OqHQGd0BzLDDnZpY0b2E" +
       "OrZ+FKWGKtApaKcej7NpeabbJVg44qHXw+VsOaUP2WrjMj2AmV6pWFLVYNq8" +
       "QTWv3hCmiqyonESzJmFCY3rumA1FsVrBpw4PQ3PBAojMBwlpmSLs3GB2qhGu" +
       "oRRcnSAonoMJ5/n7+uADNo+vNH8D+wcQ321ozh1wziC6WJjKeymIXVQI9hap" +
       "Eybp+AKr+PKZJdA1BOW4zhecj880bb30DnCIY6ErKmJE86DMD17IOn6RAPOm" +
       "AA1+EPAOD5e0dVbPbJh1MT6a78552bJnUzuLfLk4wLgTzlnzpBr8gt0cqH2Y" +
       "jk7xbi2CqV8QcMfTIQyfpnbMKJ4GnwMJMGNSZiU+K2N/RgVwFOs4Sesmsmes" +
       "EA5sr0Tk+bqW8cNu6x7hvRUCKNUw/FnAPH9WrPtRZxbZkUhpfJ/i5sqRSQml" +
       "aFVfbWAUP0/Fhq8XSBSXhLhQtnNA0tJdjiOaVFj4vplyURm3cqL0XMpz2Vba" +
       "zoBYFLcch8w7bwNzMbifkqB58o0BFc6FRZqYyU2JeZnvZz2UMToMxydzaSQB" +
       "P4imXDIrUHeDTeWffQ/YLeiuz3SAJwhgR59xPzWkEE+Ls+liit1Wu3B0fRfh" +
       "HmRjPldOMd2yobuIFFCsiX7D7xEoEcxzVgfszLVtAhk25tlH5XJBhQZA7uMI" +
       "MJTVQVpHycgbQaiifZtznUf7ewit98vALoe5xewLO1wlghNopOgFYC+6i8VZ" +
       "y5zgyMA2UcbWqjjput6NBlpr04eFLrDQuObheJjDbNAPVTcUEIJsLXdvFud5" +
       "upa6nVqtaCzgfW0N9LW66nkwwOq5MfChb0kCsjt1c8XFfTMT8VRA4+5EJKa/" +
       "2BAgSVlLqOloRZ2ySoZQnIis/ayGsOAElstNBRHGMGRYYJIYM8Ow1PZIY4vO" +
       "w+0sYyqYnmb8aHVwEZOoc/og4tm88dw93UekuYs2wai7PYHyzUgbML6MWXO9" +
       "M+ebTRhJlFUN2x2bFbhEtadQ6yBvew7oQ4fjTokoZ0mEjsF5ayE97WijF4ES" +
       "PSAjcs33iAZrsbLFsZMgDKQsFTzrcwvHNDI6qd2FyxKCsTgeUtEHkA5ggtHM" +
       "6LGua/pLKMBwG1Xwnmt8w4Po8adENtR3EyS2jIGrpChqQIcl4YVcw7C6ReJR" +
       "iTSiYBSdu8C3ALfC1qOV06a2hR0Afh6d4QbOjpFDttxR5YVRp5HVICjSwZPy" +
       "vRbBA016GB6EzGF0aiNSthniJDDEbFUCglAyYrI/VWUCqT4XwOg+m69pNTQX" +
       "2Glz+bbL5oy0ZB1DCRbtU0rmEb5oIRgMElYVsCprtxFgp2R3kjRalpUZKYxq" +
       "ns8GdErhe/2MJki5NAOYEzhovnQdcZDHdRk+ENqpaYxqEtRPTC3QabXYjEv4" +
       "oj/dnnG8W2ndkiBzbNbwmzOx3qObPQqFRslPj8iqAvyzNKPIbgZurZULSt6M" +
       "pI/QFIjkKRfM0G6HeVUietCuLaN0x22mYt8sEZ+tVgcX3U+n6mzdZLg9m/lT" +
       "bwbCO52n2bMOj+6ndzqic1te7u2t0aq7OGgSb37e72bpPk1oGNi5zRxcrjt2" +
       "t292qQlj1TQ1uhlXkse9pxVbfZ17GaCokMh0GDUa4xQJ1ExV7bg0ak8AOswp" +
       "dWhmKOZQrOUQ6ehaOLW0xtGSGGUXlaeyvcHn+jaZdTrpBZ3nDzxmbkxzGutY" +
       "PTX4BKvK6Q6jpTrf2BzKtUZ1nOq+4cEtWEqE3bZT0h2lYppyzYwZLf2Zxa5H" +
       "96qcYTixKz1ybp4x7MJ2n75l0s9/DZM+v3gdNr0JKPuGpwSUffJV8T0fuEx2" +
       "jW67xoS/chOzdg1VvfT4xOut8EeeGmf4INzv+ncJv79zW79zEzP9D14bM33v" +
       "hd/hkOmPffJe0VhVWDRZ7b5wGxh6b+zy9dbp+OlrbNJN7UqNa/UCvZD/lQvw" +
       "FS70bl9M8C99LM/ryftfD/xUUn7LDSkv2Tf+loT7+f8XCMcSt5Hhx8S9T7sv" +
       "fkqPp5Lv298I+f7+/wvkG5344FHSfdHrQJ9Kts/8f8d1enYT1P36XPfqHg/J" +
       "1z2k1UdeTatnb5N+W4qPhGQ/EsL/4DXAex+8BnigHS4xth98vSdh1/ja7/vD" +
       "n/keR/r+xd3baNB9PXlrneWfSNzWTR5Z5d3X+vEBhm+/YJiM6Z0jBn/mtvya" +
       "RzB8JF70sc1dQ0/fdjvkq29L5PHNPQxWfdPDQNKvfJCx1/n/3FPiWv/CJfve" +
       "23jp56830PMPcXpsJ/fG9MFxkfK2/NQb28llyMu35fb1d/Ioen/5KbAfvmQ/" +
       "UE/e4ru1fnlEcN32k/D+yJg+PC76Y7fln31jeF+GfO9t+ac+N7z/2lNgP3bJ" +
       "/upI8hHvVz07eBLqyOT64OLNH74p3/Trbwz1y5Bfuy1/9XND/W88BfY3L9mP" +
       "15O3XVB/GFvPPgnzT9ykN//d2/Kzbwzzy5AfuC2///Uxv/PQ6Imus/7sU9D/" +
       "O5fsp+rJs+6ox5LqSUHLzx2zLHGt9Ek7WoyJmUzecu+mfO6/v7EdXYb8t9vy" +
       "115/R3cfGoqfuK+0vvCB0nr0Wr6u+Y+est9fvGQ/92C/l6+/96SNvTAmedzY" +
       "b96Wv/zGNnYZ8s9vy1/8nI7qF66z/vJTUP8Xl+yf/NaoPz+5qv63Nrfly28M" +
       "9cuQr70tjc9NPn7lKbCriP3LUSUFowmAZ85VJZlPwvv3jikc6798W/7UG8P7" +
       "MuQnb8u//rnh/etPgf3nS/bvRrzr7OGzq8f10fXh0HsmrzFN/sr/taZJm4XO" +
       "1QIJ07B+4WP3vv7e135Ku/fp0e54nMS/lQF2gf73PH8KCX/j9WF3rsP/60je" +
       "+7g88bnEBdvHSH5F6IOvIfmdH/2/juQ3D1fu3bwnvXerRK+0v/9aJ/Ne+Nrr" +
       "M6rPwWJ8xAf++L3bQVZrPT7qxny7GZZ9ihoPOPTuvZDdCx8see9q0VxO/lq5" +
       "Z9/7qnsv3LRlL927eTB079XvQ43Lm6lqlIHErbP0hY+9OGqgkZ2SkY569oL9" +
       "4uu76x9/DPWPvfTp2xW8UYW5Lz3OeE/8ceCjlyy/fZH7+jfDgwvvztufwnjv" +
       "vGTP3DyBfeQgXqNN7z+lfv99FrvfcIF+8LcD6y94Ctbvu2TvuvzociG1VdWP" +
       "0PshIo+h/gX/W6hrT0T9UaQ++BTYRYXcef+tLzOaRq/7A8TvBuIffQrshUv2" +
       "4XryoccRf4L3/7uB++wpsMvvb3e+4vb3s0dxf8z9/t3AG3kK7PLr3x3wCTR/" +
       "gu/b1ZNnrmx/eQH//tf8p5mb/4di/9D3vOstX/Q9xj+6eSZ8/3+WPMtP3uI1" +
       "SfLou+5H6s/mpeuF1508e/PK+7r7O1893kQXcbvUvya/Edj/BSqASTzrRgAA");
}
