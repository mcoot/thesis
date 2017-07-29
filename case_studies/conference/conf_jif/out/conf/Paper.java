package conf;

/**
 * A paper which may be submitted to a conference
 */
public class Paper implements jif.lang.JifObject {
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
                            jif.lang.LabelUtil.
                                singleton().bottomConf(),
                            jif.lang.LabelUtil.
                                singleton().
                                writerPolicy(
                                  jif.lang.PrincipalUtil.topPrincipal(),
                                  jif.lang.PrincipalUtil.topPrincipal())), o);
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
        try { return this.equals((Object) o); }
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
                try { result = 31 * result + this.authors[i].hashCode(); }
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
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1501296027523L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAM08C3gVxblz9uQJhEdECe8DBBSVRETxYqSAASQYISUQFdC4" +
       "2bMhC5uzm909ELBWUBGrFa+IiqXksxVRlIraevX6qgV7wUp9t6K12tKvLa3S" +
       "W/1aq22td/5/5uzOPs7JCUi9+b4zs5mdf+af//3PzDm7jpBC2yLDl2utVc5q" +
       "U7Wr5mqtDbJlq8kGQ1+9kDY1K59+50Byy6XmexIpWkxKNHtRypZb1XpSKqed" +
       "NsPSnNUO6V+/XF4pV6cdTa+u12ynpp70VoyU7ViylnLsDvJ1Eqsn/TXaIqcc" +
       "TXbU5GzLaHfIqHqTTrRMN5xqtdOpNmVLbq9GVKobanXZtulIRdiaGaTEtIyV" +
       "WlK1HDKyniLOe+tyi6pXN/B39fBfTadFEpnh+frY4nBktrrbT6vefOfl/R+N" +
       "k36LST8t1ejIjqbUGimH4rOY9GlX21tUy56RTKrJxWRASlWTjaqlybq2hnY0" +
       "UotJua0tS8lO2lLtBapt6CuhY7mdNimKMGemsZ70YSRJK45hZZZT1KqpejLz" +
       "X2GrLi+zHXKSRxa2vNnQTmnRi5JTtVplRc2AFKzQUkmgRQDCXWPlhbQDBS1u" +
       "Vym/3KkKUjJtIOWMc7qcWlbd6FhaahntWmikHSDwkKyD1gAjZGWFvExtdkhF" +
       "sF8De0V7lSIhAMQhJwa74UiUS0MCXBL4c2TeeRuvTM1JSYhzUlV0wL+EAo0I" +
       "AC1QW1VLTSkqA+xzav0d8knP3CARQjufGOjM+jz+tQ+nnz7iuf2sz9CIPvNb" +
       "lquK06xsb+n76rDa8VPiTAQNWwPm+1aOwt/A39R0mlSxTnJHhJdVmZfPLfif" +
       "S9c+oL4vkV51pEgx9HQ7laMBitFuarpqXaCmVAtUpI6UqqlkLb6vI8X0uV5L" +
       "qax1fmurrTp1pEDHpiID/6ckaqVDAImK6bOWajUyz6bstOFzp0kIKaYfUk4/" +
       "RfSzhNcNDlk069yli2zVmk1HsZfONJR0u0oVeOmilLbUaVNtzV6qyLbabDvp" +
       "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" +
       "eX+/vYJvUiwkpHQ0r0s7SE8iOgAp4bX4");
    public static final String jlc$ClassType$jif$1 =
      ("JYwc7H4gxzs4QYnf65CSNtlug1/XijKxQ/l8g6NQDpjDfgAwhHes4HWZCHB0" +
       "5jB0/+pQTpnY4clEXlevGEDcu3pFG0IysSMsEwzMu3qV6SPKxI5uZQI2JzT6" +
       "vIbXl/dMJgDkMl5fnJ9M5DgixeuK8T1UJhyD/XJRlEyM4PN1RKEckAn3Th50" +
       "NHmtHrtM/DQoEznvn8a9Y9L4a3nJBALEf+YJQPiYNB4+JuVgb3sCED4mjfuP" +
       "Sen6C90fuakI/eou+6VY5aGufiWDuha9yX7TI/PTWaX8V8nEX8wSnoto+t7K" +
       "fnKkFMu+JqL3a5p/AzXh+RCe//+9k2URFSLhoiXkt/4fEITfWUizXxxuVv58" +
       "5sSZz+4ft49/7TrrF0A8iN1dc+dd+eFk9pODhZTRa5CZJfWkmCWPiAP8huKo" +
       "rKNlxiqaM/4ffR8uHev+ah4U5YIO+VZX4aUDazqj9tZ9P4ncrKwgV930/Iby" +
       "dfirLKWavdBK2w78OHGpkvleAozVyU4TTOZFj9CBTw5++1wYVtzxjy2/a359" +
       "8eeX5P7NAfYNq/8D1wYg+YBaAAA=");
    
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
    
    public static final String jlc$CompilerVersion$jl = "2.7.1";
    public static final long jlc$SourceLastModified$jl = 1501296027523L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAMV8Cazs6lnY3PuSl7wsZGEPvHBJHukLTp5nPLbHziMt3mbs" +
       "8Ta2x8sMCQ+vY3u8jbexDaEU2oJaSisIlKotqiq6oRQqqgohhISqLiBoS1FL" +
       "i6oWVFWiiCKVqpvU1TPn3PXdd5OnUnGkfzn+t+/7v/3o+8/nfmfy1qqc3Cvy" +
       "pD8kef1K3Rd+9crGLivfoxK7qrbjh9fcHwTAz/7Zb37vTz43ec9+8p4o02q7" +
       "jlwqz2q/q/eTd6V+6vhlRXie7+0n78t839P8MrKTaBgn5tl+8v4qOmR23ZR+" +
       "pfpVnrSXie+vmsIvr2fe/yhM3uXmWVWXjVvnZVVP3ivEdmuDTR0loBBV9avC" +
       "5Pkg8hOvOk2+fXJHmLw1SOzDOPHLhPtYgNcdweXl+zj9HdEIZhnYrn9/yVuO" +
       "UebVk695csUDjF/ixwnj0relfh3mD456S2aPHybvvwEpsbMDqNVllB3GqW/N" +
       "m/GUevKBN9x0nPT2wnaP9sF/rZ58xZPzNjdD46wXrtdyWVJPvvTJadedunLy" +
       "gSdo9gi1fkf6hu/71ozN7l5h9nw3ucD/1nHRB59YpPqBX/qZ698sfNfXCz9k" +
       "f9nPfs/dyWSc/KVPTL6Z81Pf9rvf+LEP/tzP38z5qqfMkZ3Yd+vX3B91vuif" +
       "fjX1Ufy5CxhvL/IqurDCY5hfqbq5HXm1K0Ze/LIHO14GX7k/+HPqP9h9x4/5" +
       "v3138g5u8rybJ006ctX73DwtosQvV37ml3bte9zkBT/zqOs4N3nb2BeizL/5" +
       "KgdB5dfc5C3J9dPz+fX38YqCcYvLFb1l7EdZkN/vF3YdXvtdMZlM3jaWyfvH" +
       "8vxYvum23dQTnfnEp/TKL5fjLtWn6NxtUj+rq0/pWfSpOvSrqPqUa1f+a1Xd" +
       "eNE4Y+Tv21u/dl+Lo+BTVelef/nUxh5J/8r4qfj/tXF3wejd5zt3xsv+6icF" +
       "PxmlhM0Tzy9fcz/bkMzv/vhrv3j3Aevf3kU9ecdly1euW07u3Llu9SUXmbih" +
       "2Xjjx1GSR2F910e1T6+/5Xs+9NzILMX5LeN9Xaa+9CTrPhR4buzZIwKvue/5" +
       "7n//X3/ihz6TP2TievLS62Tr9SsvsvGhJ9Eqc9f3Rt3zcPuvv2f/ndd+9jMv" +
       "3b0Q+oURndoemWKU3w8+ecZjMvLqfX1zuYq7wuSdQV6mdnIZuq8k3lGHZX5+" +
       "+OV63++89r/o/4w/d8byvy/lwk6XD5d2VCrULSvfe8DL9SSX/+0f//5P/F6y" +
       "AfVgUOur2k8vHPGJ2Wz6MWj6cQgubpjjQs4nrvCqTD+pFX/xX/7j35rfvaB+" +
       "X+++5xEFrfn1q4/I+mWzd12l+n0PuWNb+v4471//8OYHfvB3vvubrqwxzvjw" +
       "0w586VJfLsYeLyQv/9jPn37t1//Nj/6zuw/ZqZ48XzROErlXyL963OgjD48a" +
       "1UAyqqIRkuolPUtzLwoi20n8C2v+z/d83ezv/Ifve+8NfyXjlxtqlZOPff4N" +
       "Hn7/SnLyHb/4zf/tg9dt7rgXM/TwOh5Ou9FtX/xwZ6Is7f4CR/dHfuXFP/cP" +
       "7b84aslRM1XR4F+VzZ1babkA9f568kUjmV65GJxXBNvxkyuyH7sO/oFrDVyY" +
       "6Lpkch2bXqqv6q5jX3r9/q7q9ep/ebGjD2ViD37uL3yA+oO/fcXloUxc9vhA" +
       "93plYdiPiCv0Y+l/ufuh5//+3cnb9pP3Xk24ndWGnTQXYu9HI1xRtx+Fybsf" +
       "G3/coN5Yj1cfyPxXPymPjxz7pDQ+VFJj/zL70n/bowJ4q8EnXzeWt4/lp2/b" +
       "v3oZfW9xqd/X3ZlcO+h1yddc6w9dqq+7z3JvK8qoHSX0hufqyVvrqE78+7R6" +
       "75XKV2LdeAc3MnWpoceh+PhYXhjLb962v/QUKP7gG0Bx6X7iPgDvLi6qmHBG" +
       "ZWi7V0b+hjc89JNjeee4wUdu2sn/eMqh1Bdy6NvsZnSOyqp6vTNy5e4bf+E/" +
       "fu7Xf/tX3v3ij18V7VucUVFdifKkF/d6J+0x3+t65guPIwLfIvLi0xC5T4x3" +
       "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" +
       "oz7GoukiwR0dP553RLNzLAurN6vayXzB");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "7S+/OdAvS/7JbfsLXxjoP/eMsb97qX6mnrzjAvrD/GruaZB//Ka85S/ftt/x" +
       "5iC/LPnDt23/xpDfeWgsw+uuv/AM8H/xUv29evK8P+qxpHpa4urbnDxPfDt7" +
       "GkazsbCjrvy12/ZvvzmMLkt+8rb93BtjdPehg/Hx+0rrSx8orUdN1vXMf/4M" +
       "fH/tUv3yA3wvv/2jpyH28lg2k8nb/9Zt+wNvDrHLku+/bb/3CyLVr153/Y1n" +
       "gP5vL9W/+vygvzSW7WTywodu2xfeHOiXJW+/be9+YfLxW88Y++1L9e9GlRSO" +
       "BpnKvatK0p8G9x8YSzT2h9v2m98c3Jcln75tzS8M7v/0jLH/fKl+Z4S7zh8+" +
       "X3lSH13uafK+yeschT/0BToKbR55V38gyqL65Y/e+9Z73/Rp7d5nRi/gSYQ/" +
       "n3NyGf3vRfEMhP7nM8b+96X6ryOy92F5agL7BdonLuAK0Iuvu4A7zOe5gJvE" +
       "/ns3b9bu3SqY603cf82QBy9/0/WZyRfgTT0SV3zs3u0iu7WfXHXj2twsyz+9" +
       "HK87Cu69nN+LHhx572rtL3S4du659z557+Wbb/mr924eVNx7/A2afnlTUo38" +
       "kfh1nr380VdG6RyJm/hZvc1fdl954xDoY0+A/tFXP3N7QjCKt//qk2zw1IDr" +
       "I5cqu33198Za84ExuPPCG7PBnXdequduntk9QojXaZr7zzW/4j7B73+4jL74" +
       "/wPq9z8D6i+5VO++BLKXq7ar+pH7fgjIE6B/yf8T6MpTQX8UqK96xtiLl+rL" +
       "bv380W14wzDy9wPwl54xdtniztfUkw8+CfhTosbfD9g//owx8FK9fPs3iUdh" +
       "fyJQ/P2AG33GGHapZk+586fEhV09eeuV7S+vbL/idf/N4uZ/Lrg//iPvefuX" +
       "/4j+L26eIt7/vwjPC5O3B02SPPp29JH+80XpB9EVk+dvXpJesb/zDaNduIjb" +
       "pf/J4kZg/y/jIwu4T0MAAA==");
}
