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
       "+OV63++89r/o/4w/d8byvy/lwk6XD5d2VCrULSvfe8DL9SST/+0f//5P/F6y" +
       "AfVgUOur2k8vHPGJGf6xOf5xeF7c8MaFmk/c4FWXflIr/uK//Me/Nb97wfy+" +
       "2n3PI/pZ8+tXHxH1y2bvugr1+x4yx7b0/XHev/7hzQ/84O989zddOWOc8eGn" +
       "HfjSpb7ciz3eR17+sZ8//dqv/5sf/Wd3H3JTPXm+aJwkcq+Qf/W40UceHjVq" +
       "gWTURCMk1Ut6luZeFES2k/gXzvyf7/m62d/5D9/33hv2SsYvN8QqJx/7/Bs8" +
       "/P6V5OQ7fvGb/9sHr9vccS9W6OF1PJx2o9q++OHORFna/QWO7o/8yot/7h/a" +
       "f3FUkqNiqqLBv+qaO7fCcgHq/fXki0YqvXKxN68ItuMnV2Q/dh38A9cauPDQ" +
       "dcnkOja9VF/VXce+9Pr9XdXrtf/yYkYfisQe/Nxf+AD1B3/7istDkbjs8YHu" +
       "9brCsB+RVujH0v9y90PP//27k7ftJ++9WnA7qw07aS7E3o82uKJuPwqTdz82" +
       "/rg9vTEerz4Q+a9+UhwfOfZJYXyoo8b+Zfal/7ZH5e9WgU++bixvH8tP37Z/" +
       "9TL63uJSv6+7M7l20OuSr7nWH7pUX3ef5d5WlFE7CugNz9WTt9ZRnfj3afXe" +
       "K5WvxLpxDm5k6lJDj0Px8bG8MJbfvG1/6SlQ/ME3gOLS/cR9AN5dXDQx4Yy6" +
       "0HavjPwNb3joJ8fyznGDj9y0k//xlEOpL+TQt9nN6BuVVfV6X+TK3Tfuwn/8" +
       "3K//9q+8+8Ufv+rZtzijnroS5Ukn7vU+2mOu1/XMFx5HBL5F5MWnIXKfGO+8" +
       "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" +
       "fYxF00WCOzp+PO+IZudYFlZvVrWT+YJL");
    public static final String jlc$ClassType$jl$1 =
      ("RqUuozqUcHqDLQ45s2UTYSk5rNKTjXywSVN21x0LpmuV4BihlWAQHZ1/qqLO" +
       "FUPgbeRauGdStOlplQJOmfOWQ8CuqS0/2inEhuvLGchtewpIgY3nRRGk73ha" +
       "YZSU4+IpSS9idbbkyGFgTtwQHGA4wNpizlW06u/ihQspZdmslo2FOks3I05j" +
       "TBGX4Ho3M3fzw5CxCtgB1Sy2cIvOzX5J1sszsjXZM+shRIvvrNF/JwQm28hZ" +
       "Qx1qzJjFh5U3LszUeaiYwGnWkBlGAKQHXv7U4VPbnrDEeTnzjkur6vANvbfO" +
       "Wpi5fuS1Apx1sj3sKL1FWAgfduTKK9C9TrdalSLs3DwinryBFNxrz0lVV3vs" +
       "jCG2t91HzcK0jgcxyNwe2uy0OqKb0RWUpq4ogDrmrq1WtRPjpImGlpqrwYLm" +
       "hQngxXFNDjK53IJ4B2b+kK7SeW5ENAzRKycL27kfDbBBAUCIBRk8lQQaPUDz" +
       "YTNkU5ewSReP0C3NtnE7RadMHO8zRwbLMKio/XCw8rNWEq4YUQOg58s1zlID" +
       "qEYthgu7MxhXMXiebaSzuRI34WCaB2uen/wgrEQHTYFix+DYCtiPPlWx3zsh" +
       "BHcbOlB9eW3NqFW+OWR9wh4PDSNxrV4cD3v1IAstIO8zWdtGLqJwvIQKYjOP" +
       "ZaaB1DD1TvKGbna2edwz5NoHcTQ/zPxMSAGB9qQld9qghKfMas0m0KkU9Cun" +
       "oWQ9y3ScbBk0YFa6T7v9euZvljTS2XW7aOMmdmbOfC9RDIYPTTlv5/YBtWFv" +
       "dINNszQra6+Tm7gnQZA+MG7CtyW3dM/80iSIIpZZCMI2Rdqed16oywaQO6OX" +
       "GTlkY5DHlbpZbKIwAMhpsYiXIqsa2zGe7LBRe1XYihER48ztYbTM56W4XJy7" +
       "k7ibHuONZY2q3Tm0WzRAZ8CqGKB2L7m+bXSKjxJdWEl8JbvF0qIvf/juT3HI" +
       "BwUdsBU0TDfZjFtPyV1DgalNbf2pqvTbAxKdhIWbkFM7hPXQzO0cKkwMx2Pt" +
       "KJaLGMwqgSKXo2M6BdcpMdfcIxJYu1IDMDnczSSCHm37MrXIzlfgsDNHWWor" +
       "r6C8bp0TWN+M+jONCKTjFstzDLObsKeHlFUWIIsuvCW57AFNb4qd0egG0hc1" +
       "cMDjrZb0IL+WeD2VEH4rVOhM4ex2ZHg9QcWjhNQBxIaKsPJiJTou1szCYg8R" +
       "Msays0ywwcjmul48BjuCwFkoNaBs2W8HtVBmpE1Mp+xGoKY8ctpvcn5KFuXJ" +
       "JGWhspUKnzO0NDTJMiCn292uR9YnohOZ9drOYmMTKbMFICVl1LILUFTLHA0X" +
       "XWflNrXHNPzob7C4j11LR/ykc7MZIOnSPKzMDkyRTX5ed9luUBfOLHeRZrsQ" +
       "+0Dfb9MFHyMbS8m9XezU2EYEQ3WRdpBzBs79cuvPlUgf/G3QQSqZxpgmBzvy" +
       "SEZzDtlNaxoYnVBdBXqWR9L13oDmZE+d2x2XEtJ+TtlYe1hmjbpZ17DiHqbl" +
       "PpfDRUZ0ZNHMK4Krp0seOvFaiGfleIWLfUnp8GZh1YsFQEMjTZHDEhtCCK9V" +
       "71xkPFecoPN86gSEQG9MYs6eG8wCY9zAmd4KOITSnGPaFMX+ZNrJJimogksU" +
       "MHJ7lVSq/Z7JCcYn8iHgJKlbzkUeXMAYD7HrYQ7CCQS0q/XRlS2fb6nSUjdl" +
       "WHTDvBFAKBfnxzGqQo+lkRaBiVt5hBolg8MGbp2DYa4t6pinegl3qfOcltvE" +
       "ANFNnYEQU8jzoxQsNtuFeda3fIrA/BGB+21An2lC2Mx29UY/KLtWAJljph2n" +
       "YhuJoaNbTqjyG7cAY4oxKZMJ7dlmnirnIJBPtC8KfcDRu96TSHWMxKjADFIz" +
       "3no6P4YW9kBXhclO8fXM5nhsrR2QJCdMZoXiGoMxIBGttiev16xzzWdqxNln" +
       "QSfhJcYr3JSdp/qaqPOGEPC1yI6kClSF2HboEoNLCAsaWJhGqx2aNRV0mC81" +
       "lCM4pfDJQ2PZIMXTFH0WT0CA91IvkVmFDiEtcpvaCrd9z3dwTjpyyRDYxgD3" +
       "S9YORvM2j0xp3YJ7bG9sdsHWQc6ZzS6XRJ/V522/CyKRghEDjslpWMsksG/g" +
       "gJEDDlsPSwixDI/tDrM1jm48mc33REuA4jbjV6V+hixeYrr1smbgkdyo4Pbx" +
       "tJuulmHlBhSQpZtoJ2UDaQwcsg6afFRTfp6XKcysqEbFUCvOU9fdc5ZsgP3R" +
       "k7YFR0y7XY2uj/MdwGR+etCHMZQvbcYkfClRbQPCWsKzQwwg92TSUNudorfc" +
       "uYTAkqNn6+SwPDIoAPI7YrWmHVRf7bCY5aBwjq5mMMBRQohFMAYHp0QIVpo8" +
       "4yyVZguj4ZM6YKkG2S4r1e3DrUjx8GkjCnMRE6m25Vh15uWV1p2PLKKCyZTL" +
       "aH03BvlrFuZ8LxujkCCS1xg5BTE42fRTm4WbXYwaSy+0GUkJz2uJHPozNoOW" +
       "faCoHhUrhujbpsxZLUwUJOJ47Frk4uggW2hQDiEbptI80Zc4UFaHvgYjzGYE" +
       "IkiNahMqkk6R692R0vwsJGpM74VotJ7bLmhp+IgtiWnukZmIZ51o0OLoKpCL" +
       "iKoxFypkZQvooQrzIiyuqGh65GXYl1GxKmhxWOQEYjDEvOPIJgfWhU5OIw9s" +
       "2YploYotS5/fqZ3hdY3FofT6MIrEaP8kYVsrWH6smwgT1PX+sNz2THmOC5vx" +
       "9ipL1Y1PFHvGc9ToSE55Xygpl92NMdNZjA4MJsRMhG6iBLBoOQca0wyRvsVY" +
       "M1kE3OzUc1TIDCsGidhkYCuNQcP9asr30BgvMGG6HlRoMTDLgyjVqCadg4Or" +
       "1/48j1Tfb1XXDxo2o1jfAsB2t2716HwsWGVaTqvFKKORfCAK2LHgSypAd5tV" +
       "8L5rfsODBOxnZDbUd7H17uwuWPjQDRWs7LIAHTWjVCfNYQZaUcx3CphgB1RS" +
       "6CKmgwNxDlm/gllzT7HkFBllDQQKZVtkO9hNGCvx2xVDu828WK6mXF9pYsWc" +
       "h9HnORmotuE7Dmn2Cgethy3aco6VgJ64PtBHMUGCbI2LCH2IOr/hse1MX492" +
       "F7TWasL0IryRZirPuEcim29DZCqxac2WtQjSSs4MWZthNr7DBdieZ2ty9HwD" +
       "YLdWLlJLwsC6MQ7OvKIYGk7joNmM3IZS+DRo7CMH+nkDoMYOsVdNEJl0E9p4" +
       "by22HLjZmraFGVjGWNhZy/I6B+oFH2T8cSk2wPokzG2kAInBCgGV8kEQwI+Q" +
       "ri41YQxPrWMNjqqH2wamHg1W1zVGi2BIpe0HAA5qGAcX27JcTgkskmaeC3ge" +
       "4C+PeCHT4X6r2gi1XwfmMaXMTURssLDh85KXki462eK4b6BiDeu3wMX5QXac" +
       "DBh7C7Z12h5OMV7v8Q2cuSV/Phj4fApyTu8FUSnwpt16JA+dF5jMropjm1xs" +
       "m9Hr8HYr75cxTpHbMwIAs/POqIcu7iHQno+Br+9byGYhEcFOOoEYPQ4fgN3o" +
       "lBDEJy8s9K23DPfFr2O4l2ZvwHI3qS/f/ozksE88lqvzgctm19zba4r0azf5" +
       "Z9fUzcuMj7/RCd/5zLy7B+lv159LNvqd2/6dmxTi116fQvyJe6fGrqJTk9f+" +
       "y7dpi/dG6L7VTp3PXLN+bnpX2K7dy+jlMl67DL62joLbdH7h1Y8WRT35ijca" +
       "fiZi33OD2KX6o58XDef3Hg2Ovs0idhL/PiZf9YwZz0TmT70ZZL759x4Z1q7C" +
       "RxH58jcYfSYS3//7TJFtfpMc+8YUeXzGQ2S6h5B/+HHIn78t8m3LPZIR+kgq" +
       "9IOs6vc/yKp+wMeXPMsX3+hlzTXH8ke/87M/4sl/ZXb3NiPQrCcv1Hnx8dGK" +
       "+Mkjp7z32v+WBxBeUlQnyVjePULw2dt2/mjO6kNSPYHcNf3wHbdLoNv2Y08i" +
       "9zBh8bmHyYTf8KDirvv/lWfkNv61S/WXbnNmX7pqrpcewvQEJvfG8uJ4iHHb" +
       "Em8Ok8uSb7xtP/HGmDwK3o8/Y+xvXaq/UU/efvDr7SUZ+4r20+D+8Fi+djz0" +
       "z9+23/Xm4L4s+c7b9tu+MLh/6hljP32pfnK88hHux9K3nwY6Nrkmrj/3v27b" +
       "X35zoF+W/JPb9he+MNB/7hljf/dS/Uw9eccF9If51dzTIP/4TXnLX75tv+PN" +
       "QX5Z8odv2/6NIb/z0FiG111/4Rng/+Kl+nv15Hl/1GNJ9bTE1bc5eZ74dvY0" +
       "jGZjYUdd+Wu37d9+cxhdlvzkbfu5N8bo7kMH4+P3ldaXPlBaj5qs65n//Bn4" +
       "/tql+uUH+F5++0dPQ+zlsWwmk7f/rdv2B94cYpcl33/bfu8XRKpfve76G88A" +
       "/d9eqn/1+UF/aSzbyeSFD922L7w50C9L3n7b3v3C5OO3njH225fq340qKRwN" +
       "MpV7V5WkPw3uPzCWaOwPt+03vzm4L0s+fduaXxjc/+kZY//5Uv3OCHedP3y+" +
       "8qQ+utzT5H2T1zkKf+gLdBTaPPKu/kCURfXLH733rfe+6dPavc+MXsCTCH8+" +
       "5+Qy+t+L4hkI/c9njP3vS/VfR2Tvw/LUBPYLtE9cwBWgF193AXeYz3MBN4n9" +
       "927erN27VTDXm7j/miEPXv6m6zOTL8CbeiSu+Ni920V2az+56sa1uVmWf3o5" +
       "XncU3Hs5vxc9OPLe1dpf6HDt3HPvffLeyzff8lfv3TyouPf4GzT98qakGvkj" +
       "8es8e/mjr4zSORI38bN6m7/svvLGIdDHngD9o69+5vaEYBRv/9Un2eCpAddH" +
       "LlV2++rvjbXmA2Nw54U3ZoM777xUz908s3uEEK/TNPdfa37FfYLf/3AZffH/" +
       "B9TvfwbUX3Kp3n0JZC9XbVf1I/f9EJAnQP+S/yfQlaeC/ihQX/WMsRcv1Zfd" +
       "+vmj2/CGYeTvB+AvPWPsssWdr6knH3wS8KdEjb8fsH/8GWPgpXr59m8Sj8L+" +
       "RKD4+wE3+owx7FLNnnLnT4kLu3ry1ivbX17ZfsXr/pnFzb9ccH/8R97z9i//" +
       "Ef1f3DxFvP9vEZ4XJm8PmiR59O3oI/3ni9IPoismz9+8JL1if+cbRrtwEbdL" +
       "/5PFjcD+X7eOBRJOQwAA");
}
