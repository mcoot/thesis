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
       "AfVgUOur2k8vHPGJ2RT/GDT9OAQXN8xxIecTV3hVpp/Uir/4L//xb83vXlC/" +
       "r3ff84iC1vz61Udk/bLZu65S/b6H3LEtfX+c969/ePMDP/g73/1NV9YYZ3z4" +
       "aQe+dKkvF2OPF5KXf+znT7/26//mR//Z3YfsVE+eLxonidwr5F89bvSRh0eN" +
       "aiAZVdEISfWSnqW5FwWR7ST+hTX/53u+bvZ3/sP3vfeGv5Lxyw21ysnHPv8G" +
       "D79/JTn5jl/85v/2wes2d9yLGXp4HQ+n3ei2L364M1GWdn+Bo/sjv/Lin/uH" +
       "9l8cteSomapo8K/K5s6ttFyAen89+aKRTK9cDM4rgu34yRXZj10H/8C1Bi5M" +
       "dF0yuY5NL9VXddexL71+f1f1evW/vNjRhzKxBz/3Fz5A/cHfvuLyUCYue3yg" +
       "e72yMOxHxBX6sfS/3P3Q83//7uRt+8l7rybczmrDTpoLsfejEa6o24/C5N2P" +
       "jT9uUG+sx6sPZP6rn5THR459UhofKqmxf5l96b/tUQG81eCTrxvL28fy07ft" +
       "X72Mvre41O/r7kyuHfS65Guu9Ycu1dfdZ7m3FWXUjhJ6w3P15K11VCf+fVq9" +
       "90rlK7FuvIMbmbrU0ONQfHwsL4zlN2/bX3oKFH/wDaC4dD9xH4B3FxdVTDij" +
       "MrTdKyN/wxse+smxvHPc4CM37eR/POVQ6gs59G12MzpHZVW93hm5cveNv/Af" +
       "P/frv/0r737xx6+K9i3OqKiuRHnSi3u9k/aY73U984XHEYFvEXnxaYjcJ8Y7" +
       "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" +
       "UR9j0XSR4I6OH887otk5loXVm1XtZL7g");
    public static final String jlc$ClassType$jl$1 =
      ("klGpy6gOJZzeYItDzmzZRFhKDqv0ZCMfbNKU3XXHgulaJThGaCUYREfnn6qo" +
       "c8UQeBu5Fu6ZFG16WqWAU+a85RCwa2rLj3YKseH6cgZy254CUmDjeVEE6Tue" +
       "Vhgl5bh4StKLWJ0tOXIYmBM3BAcYDrC2mHMVrfq7eOFCSlk2q2Vjoc7SzYjT" +
       "GFPEJbjezczd/DBkrAJ2QDWLLdyic7NfkvXyjGxN9sx6CNHiO2v03wmByTZy" +
       "1lCHGjNm8WHljQszdR4qJnCaNWSGEQDpgZc/dfjUticscV7OvOPSqjp8Q++t" +
       "sxZmrh95rQBnnWwPO0pvERbChx258gp0r9OtVqUIOzePiCdvIAX32nNS1dUe" +
       "O2OI7W33UbMwreNBDDK3hzY7rY7oZnQFpakrCqCOuWurVe3EOGmioaXmarCg" +
       "eWECeHFck4NMLrcg3oGZP6SrdJ4bEQ1D9MrJwnbuRwNsUAAQYkEGTyWBRg/Q" +
       "fNgM2dQlbNLFI3RLs23cTtEpE8f7zJHBMgwqaj8crPyslYQrRtQA6PlyjbPU" +
       "AKpRi+HC7gzGVQyeZxvpbK7ETTiY5sGa5yc/CCvRQVOg2DE4tgL2o09V7PdO" +
       "CMHdhg5UX15bM2qVbw5Zn7DHQ8NIXKsXx8NePchCC8j7TNa2kYsoHC+hgtjM" +
       "Y5lpIDVMvZO8oZudbR73DLn2QRzNDzM/E1JAoD1pyZ02KOEps1qzCXQqBf3K" +
       "aShZzzIdJ1sGDZiV7tNuv575myWNdHbdLtq4iZ2ZM99LFIPhQ1PO27l9QG3Y" +
       "G91g0yzNytrr5CbuSRCkD4yb8G3JLd0zvzQJoohlFoKwTZG2550X6rIB5M7o" +
       "ZUYO2RjkcaVuFpsoDAByWizipciqxnaMJzts1F4VtmJExDhzexgt83kpLhfn" +
       "7iTupsd4Y1mjancO7RYN0BmwKgao3Uuubxud4qNEF1YSX8lusbToyx+++1Mc" +
       "8kFBB2wFDdNNNuPWU3LXUGBqU1t/qir99oBEJ2HhJuTUDmE9NHM7hwoTw/FY" +
       "O4rlIgazSqDI5eiYTsF1Ssw194gE1q7UAEwOdzOJoEfbvkwtsvMVOOzMUZba" +
       "yisor1vnBNY3o/5MIwLpuMXyHMPsJuzpIWWVBciiC29JLntA05tiZzS6gfRF" +
       "DRzweKslPcivJV5PJYTfChU6Uzi7HRleT1DxKCF1ALGhIqy8WImOizWzsNhD" +
       "hIyx7CwTbDCyua4Xj8GOIHAWSg0oW/bbQS2UGWkT0ym7Eagpj5z2m5yfkkV5" +
       "MklZqGylwucMLQ1NsgzI6Xa365H1iehEZr22s9jYRMpsAUhJGbXsAhTVMkfD" +
       "RddZuU3tMQ0/+hss7mPX0hE/6dxsBki6NA8rswNTZJOf1122G9SFM8tdpNku" +
       "xD7Q99t0wcfIxlJybxc7NbYRwVBdpB3knIFzv9z6cyXSB38bdJBKpjGmycGO" +
       "PJLRnEN205oGRidUV4Ge5ZF0vTegOdlT53bHpYS0n1M21h6WWaNu1jWsuIdp" +
       "uc/lcJERHVk084rg6umSh068FuJZOV7hYl9SOrxZWPViAdDQSFPksMSGEMJr" +
       "1TsXGc8VJ+g8nzoBIdAbk5iz5wazwBg3cKa3Ag6hNOeYNkWxP5l2skkKquAS" +
       "BYzcXiWVar9ncoLxiXwIOEnqlnORBxcwxkPsepiDcAIB7Wp9dGXL51uqtNRN" +
       "GRbdMG8EEMrF+XGMqtBjaaRFYOJWHqFGyeCwgVvnYJhrizrmqV7CXeo8p+U2" +
       "MUB0U2cgxBTy/CgFi812YZ71LZ8iMH9E4H4b0GeaEDazXb3RD8quFUDmmGnH" +
       "qdhGYujolhOq/MYtwJhiTMpkQnu2mafKOQjkE+2LQh9w9K73JFIdIzEqMIPU" +
       "jLeezo+hhT3QVWGyU3w9szkeW2sHJMkJk1mhuMZgDEhEq+3J6zXrXPOZGnH2" +
       "WdBJeInxCjdl56m+Juq8IQR8LbIjqQJVIbYdusTgEsKCBham0WqHZk0FHeZL" +
       "DeUITil88tBYNkjxNEWfxRMQ4L3US2RWoUNIi9ymtsJt3/MdnJOOXDIEtjHA" +
       "/ZK1g9G8zSNTWrfgHtsbm12wdZBzZrPLJdFn9Xnb74JIpGDEgGNyGtYyCewb" +
       "OGDkgMPWwxJCLMNju8NsjaMbT2bzPdESoLjN+FWpnyGLl5huvawZeCQ3Krh9" +
       "PO2mq2VYuQEFZOkm2knZQBoDh6yDJh/VlJ/nZQozK6pRMdSK89R195wlG2B/" +
       "9KRtwRHTblej6+N8BzCZnx70YQzlS5sxCV9KVNuAsJbw7BADyD2ZNNR2p+gt" +
       "dy4hsOTo2To5LI8MCoD8jlitaQfVVzssZjkonKOrGQxwlBBiEYzBwSkRgpUm" +
       "zzhLpdnCaPikDliqQbbLSnX7cCtSPHzaiMJcxESqbTlWnXl5pXXnI4uoYDLl" +
       "MlrfjUH+moU538vGKCSI5DVGTkEMTjb91GbhZhejxtILbUZSwvNaIof+jM2g" +
       "ZR8oqkfFiiH6tilzVgsTBYk4HrsWuTg6yBYalEPIhqk0T/QlDpTVoa/BCLMZ" +
       "gQhSo9qEiqRT5Hp3pDQ/C4ka03shGq3ntgtaGj5iS2Kae2Qm4lknGrQ4ugrk" +
       "IqJqzIUKWdkCeqjCvAiLKyqaHnkZ9mVUrApaHBY5gRgMMe84ssmBdaGT08gD" +
       "W7ZiWahiy9Lnd2pneF1jcSi9PowiMdo/SdjWCpYf6ybCBHW9Pyy3PVOe48Jm" +
       "vL3KUnXjE8We8Rw1OpJT3hdKymV3Y8x0FqMDgwkxE6GbKAEsWs6BxjRDpG8x" +
       "1kwWATc79RwVMsOKQSI2GdhKY9Bwv5ryPTTGC0yYrgcVWgzM8iBKNapJ5+Dg" +
       "6rU/zyPV91vV9YOGzSjWtwCw3a1bPTofC1aZltNqMcpoJB+IAnYs+JIK0N1m" +
       "Fbzvmt/wIAP7GZkN9V1svTu7CxY+dEMFK7ssQEfNKNVJc5iBVhTznQIm2AGV" +
       "FLqI6eBAnEPWr2DW3FMsOUVGWQOBQtkW2Q52E8ZK/HbF0G4zL5arKddXmlgx" +
       "52H0eU4Gqm34jkOavcJB62GLtpxjJaAnrg/0UUyQIFvjIkIfos5veGw709ej" +
       "3QWttZowvQhvpJnKM+6RyObbEJlKbFqzZS2CtJIzQ9ZmmI3vcAG259maHD3f" +
       "ANitlYvUkjCwboyDM68ohobTOGg2I7ehFD4NGvvIgX7eAKixQ+xVE0Qm3YQ2" +
       "3luLLQdutqZtYQaWMRZ21rK8zoF6wQcZf1yKDbA+CXMbKUBisEJApXwQBPAj" +
       "pKtLTRjDU+tYg6Pq4baBqUeD1XWN0SIYUmn7AYCDGsbBxbYsl1MCi6SZ5wKe" +
       "B/jLI17IdLjfqjZC7deBeUwpcxMRGyxs+LzkpaSLTrY47huoWMP6LXBxfpAd" +
       "JwPG3oJtnbaHU4zXe3wDZ27Jnw8GPp+CnNN7QVQKvGm3HslD5wUms6vi2CYX" +
       "22b0OrzdyvtljFPk9owAwOy8M+qhi3sItOdj4Ov7FrJZSESwk04gRo/DB2A3" +
       "OiUE8ckLC33rLcN98esY7qXZG7DcTerLtz8jOewTj+XqfOCy2TX59poj/dpN" +
       "/tk1dfMy4+NvdMJ3PjPv7kH62/Xnko5+57Z/5yaH+LXX5xB/4t6psavo1OS1" +
       "//Jt2uK9EbpvtVPnM9esn5veFbZr9zJ6uYzXLoOvraPgNp9fePWjRVFPvuKN" +
       "hp+J2PfcIHap/ujnRcP5vUeDo2+ziJ3Ev4/JVz1jxjOR+VNvBplv/r1HhrWr" +
       "8FFEvvwNRp+JxPf/PlNkm98kx74xRR6f8RCZ7iHkH34c8udvi3zbco9khD6S" +
       "Cv0gq/r9D7KqH/DxJc/yxTd6WnPNsfzR7/zsj3jyX5ndvc0INOvJC3VefHy0" +
       "In7yyCnvvfa/5QGElxTVSTKWd48QfPa2nT+as/qQVE8gd00/fMftEui2/diT" +
       "yD1MWHzuYTLhNzyouOv+f+UZuY1/7VL9pduc2ZeumuulhzA9gcm9sbw4HmLc" +
       "tsSbw+Sy5Btv20+8MSaPgvfjzxj7W5fqb9STtx/8entJxr6i/TS4PzyWrx0P" +
       "/fO37Xe9ObgvS77ztv22Lwzun3rG2E9fqp8cr3yE+7H07aeBjk2uievP/a/b" +
       "9pffHOiXJf/ktv2FLwz0n3vG2N+9VD9TT95xAf1hfjX3NMg/flPe8pdv2+94" +
       "c5Bflvzh27Z/Y8jvPDSW4XXXX3gG+L94qf5ePXneH/VYUj0tcfVtTp4nvp09" +
       "DaPZWNhRV/7abfu33xxGlyU/edt+7o0xuvvQwfj4faX1pQ+U1qMm63rmP38G" +
       "vr92qX75Ab6X3/7R0xB7eSybyeTtf+u2/YE3h9hlyffftt/7BZHqV6+7/sYz" +
       "QP+3l+pffX7QXxrLdjJ54UO37QtvDvTLkrfftne/MPn4rWeM/fal+nejSgpH" +
       "g0zl3lUl6U+D+w+MJRr7w237zW8O7suST9+25hcG9396xth/vlS/M8Jd5w+f" +
       "rzypjy73NHnf5HWOwh/6Ah2FNo+8qz8QZVH98kfvfeu9b/q0du8zoxfwJMKf" +
       "zzm5jP73ongGQv/zGWP/+1L91xHZ+7A8NYH9Au0TF3AF6MXXXcAd5vNcwE1i" +
       "/72bN2v3bhXM9Sbuv2bIg5e/6frM5Avwph6JKz5273aR3dpPrrpxbW6W5Z9e" +
       "jtcdBfdezu9FD468d7X2FzpcO/fce5+89/LNt/zVezcPKu49/gZNv7wpqUb+" +
       "SPw6z17+6CujdI7ETfys3uYvu6+8cQj0sSdA/+irn7k9IRjF23/1STZ4asD1" +
       "kUuV3b76e2Ot+cAY3Hnhjdngzjsv1XM3z+weIcTrNM3955pfcZ/g9z9cRl/8" +
       "/wH1+58B9ZdcqndfAtnLVdtV/ch9PwTkCdC/5P8JdOWpoD8K1Fc9Y+zFS/Vl" +
       "t37+6Da8YRj5+wH4S88Yu2xx52vqyQefBPwpUePvB+wff8YYeKlevv2bxKOw" +
       "PxEo/n7AjT5jDLtUs6fc+VPiwq6evPXK9pdXtl/xuv9mcfM/F9wf/5H3vP3L" +
       "f0T/FzdPEe//X4TnhcnbgyZJHn07+kj/+aL0g+iKyfM3L0mv2N/5htEuXMTt" +
       "0v9kcSOw/xdDLgBcT0MAAA==");
}
