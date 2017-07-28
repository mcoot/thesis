package battleships;

/**
 * This class represents an (x,y) coordinate in the space of the
 * Battleships board. x and y should be non-negative integers.
 * The co-ordinate (0, 0) is the lower left of the board.
 * 
 * It is parameterized by the label L, which is the level of information 
 * that the coordinate contains.
 */
class Coordinate implements jif.lang.JifObject {
    /**
     * The x coord. 
     */
    public int x;
    /**
     * The y coord.
     */
    public int y;
    
    public Coordinate battleships$Coordinate$(final int x, final int y) {
        this.jif$init();
        {
            this.x = x;
            this.y = y;
        }
        return this;
    }
    
    public String toString() { return "(" + this.x + ", " + this.y + ")"; }
    
    public int hashCode() { return 13 * this.x ^ -23 * this.y; }
    
    public boolean equals(final jif.lang.Label lbl,
                          final jif.lang.IDComparable o) {
        if (o == null || !Coordinate.jif$Instanceof(lbl, o)) { return false; }
        Coordinate that = Coordinate.jif$cast$battleships_Coordinate(lbl, o);
        return this.x == that.x && this.y == that.y;
    }
    
    public boolean equals(final jif.lang.IDComparable o) {
        return this.equals(this.jif$battleships_Coordinate_L, o);
    }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1501224992108L;
    public static final String jlc$ClassType$jif =
      ("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");
    
    public Coordinate(final jif.lang.Label jif$L) {
        super();
        this.jif$battleships_Coordinate_L = jif$L;
    }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Label jif$L,
                                         final Object o) {
        if (o instanceof Coordinate) {
            Coordinate c = (Coordinate) o;
            return jif.lang.LabelUtil.singleton().
              equivalentTo(c.jif$battleships_Coordinate_L, jif$L);
        }
        return false;
    }
    
    public static Coordinate jif$cast$battleships_Coordinate(
      final jif.lang.Label jif$L, final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$L, o)) return (Coordinate) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Label jif$battleships_Coordinate_L;
    private jif.lang.Label jif$jif_lang_JifObject_L;
    
    public final jif.lang.Label jif$getjif_lang_JifObject_L() {
        if (this.jif$jif_lang_JifObject_L == null)
            this.jif$jif_lang_JifObject_L = this.jif$battleships_Coordinate_L;
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
    public static final long jlc$SourceLastModified$jl = 1501224992108L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAMV7e+wsWVpQ3zs7M7uzy87MwsKy7A6X3QFntpbp7qquRzO7" +
       "aL0fXdXVXY9+scu13u/3o6sLRtAou5EIPhZEI2giJEgWCBpCFDH8IQpCNKhR" +
       "NCoYNaKAkRg0+ACr+/e793fvnTuX3UjcTvqc0/V95zvf+5yT+vqzvzF6uipH" +
       "d/IsPnlxVr9Wn3Knem1llJVjk7FRVdrw4K71XcD4M3/+G1/460+Nnj+Mng9S" +
       "tTbqwCKztHa6+jB6V+IkplNWuG079mH0Yuo4tuqUgREH/YCYpYfRe6rAS426" +
       "KZ1Kcaosbs+I76ma3Ckva957KI7eZWVpVZeNVWdlVY9eEEOjNcZNHcRjMajq" +
       "18XRM27gxHZVjP7I6JY4etqNDW9A/FLxnhTjC8Uxc34+oD8XDGyWrmE596a8" +
       "LQpSux595aMz7kv88mJAGKY+mzi1n91f6m2pMTwYveeKpdhIvbFal0HqDahP" +
       "Z82wSj16/1sSHZDenhtWZHjO3Xr0vkfxVlegAesdF7Wcp9Sj9z6KdqHUlaP3" +
       "P2KzB6z1G8uPfcc3pVx6+8Kz7Vjxmf+nh0kvPTJJcVyndFLLuZr4ro+I3218" +
       "6U99+vZoNCC/9xHkK5yf+Obf/EMffemnf/YK5ysegyOboWPVd63vN9/9ix8g" +
       "X50/dWbj7XlWBWdXeEjyi1VX15DXu3zwxS+9T/EMfO0e8KeVv7f/1h9yfu32" +
       "6Dl+9IyVxU0yeNWLVpbkQeyUrJM6pVE7Nj96h5Pa5AXOj54dxmKQOldPZdet" +
       "nJofvS2+PHomu/weVOQOJM4qetswDlI3uzfOjdq/jLt8dP15Yfi+czS6tb3u" +
       "2XoU0F/3Cb1ySmagUn2CyqwmcdK6+oSeBp+ofacKqk9YRuXcrerGDgYM06jr" +
       "AdMP8ofGd8PA/URVWg/BySwr7WAIHOe1AZz//1ysO0v+RcdbtwajfODRBBEP" +
       "0cRlse2Ud63PNAT9mz9y9+dv3w+Ra50NMfkA+dduyI9u3bqQ/ZJzHF3ZebBS" +
       "NET/EODvelX9pPCHP/2hpwYHy49vG/R8Rn35UXe/SRL8MDIGH75rPf+pX/3v" +
       "P/rdb2Q3jl+PXn5TPL555jmePvSoiGVmOfaQr27If+SO8eN3f+qNl2+fneMd" +
       "Q5qqjcGRhph/6dE1Hoqr1+/lqLNaboujd7pZmRjxGXQvsTxX+2V2vHly0f07" +
       "L+N3/+7wuTV8f+f8Pbvg+cG5HxIRee3+d+77f55f2e2s3UckuuTDj6v59/7S" +
       "P/xP0O0zJ/dS5/MP5FjVqV9/IFzPxN51CcwXb4yllY4z4P3r71n9ue/6jU99" +
       "w8VSA8aHH7fgy+f2zKcx8JeVf+Jni3/xy//m+//p7Rvr1qNn8saMA+vC+QcG" +
       "Ql9zs9QQyfGQTQZOqpf1NMnswA0MM3bOnvK/n//q6Y//+ne8cGXueHhypbxy" +
       "9NHfm8DN8y8nRt/689/4P166kLllnXeSG3XcoF2lpy++oYyXpXE689H90X/8" +
       "wb/w943vHRLdkFyqoHcu+eLWtfOemXpPPXr3EFOvnfeM10TDdOKLsMAF+DWX" +
       "9iNnm16mjC6w8bn5iu4Ce+/l+XPVmzM4c94Kb1z0MP7sX3o/+fW/dpHlxkXP" +
       "NN7fvTmON8YD0QP+UPJbtz/0zM/cHj17GL1w2YWNtN4YcXM29mHYRyvy+qE4" +
       "+qKH4A/viVcbwOv3Q/ADj4bHA8s+Ghw3+WMYn7HP42cfjIdBES+elfT+4fv8" +
       "oN+/dd3/2Bn6Qn5uX+xujS4D+DLlpUv7Vefm5SubnIdffeVu9eAwj9HrqgyS" +
       "IQDa653R+fRn/uTvvvYdn7n9wPHhw2/awR+cc3WEuKzx3GWh8ypf9aRVLjOY" +
       "//ijb/zkD77xqavt9T0Pb4Z02iQ//M/+zy+89j2/8nOPybZPDQedq+A/t9M3" +
       "q+uLB9F/+7r/r49RF/45qet0HnzsgYWuxLs1BPLT0Gvwa5Pzb+bxpJ66kBoi" +
       "vrqcIIcZ7rAjxPdof1kYWy/fS2qb4UQ5xN3LQ9zci6EXLtF3CaKrg9djuBjU" +
       "/O4bNDEbTmff/u//9C9854d/eVCZMHq6PTvsoNsHaC2b8/H12z77XR9852d+" +
       "5dsvqWmQ+pOf+l9vXE5O8rnhhqPdmTs1a0rLEY2qli65xLHvM/h113Y+dx+v" +
       "h4yUPZbB+v2/ys0qHr/3kXSUhNeb7rCbQ+2RO/DmGOMwCcdmXi/LocUS9NFN" +
       "8RmxSnrcPnJEj86dlluulMkc0iCvi/ittu5YGuL9aKdkKGmsSZENyL2PRvuJ" +
       "2ixI3mhFwXMEWV+v0ChlqTESKDWYbcf2dm7OU1Ygq5RabpTNzi7iFnKRFlnt" +
       "TttTz0zMSkAWm2k+T4JAN2NLDd1jE7AJG6twDseTel25qzFlTpfQzjjNucbu" +
       "tmKMnba+SmmzSigzapUQYCHm0VwYculWmrewLB10WAxJKzoWnWjxNLOhmFUq" +
       "WPqkKYPWyml6czopXDzrBHum69AWAZP4FHWSAW4DuxTyrrIbyUB72cb2Srzz" +
       "qdo6mkQc5QzU1IrLT3f2JMt1zYbJfUzKQlVXx1TRUuco7VVMBAozB8Wt1fTY" +
       "nKNmVjmxOdthamAKYGaQgkqnGNPhQL6eJOYxJ+1tsfcFbFumRLoVUr1Wl4KR" +
       "6Albxn5QBAmbqfY+2eXWNMqKYmJVkmQcIDLpYntJ5Mwa1qFjpfhKtA8X0sLZ" +
       "JA7JTjoh8hlpYzpyBDdbhYqH3RdLRXdVUoJkwgeS4QpMBryoJr0IVjRoSSI8" +
       "E5VTQo8FnOwA2rWMk4FFNJ6Xu4UiAOCmjhd9n8/4g9JXCVYFqHOQC7XKYKnf" +
       "0L3gEzNTAMSNR4cOS1PtBK6WaKSO0SMrR0rCqLiPS1qktEU60wtaBZfzHSd2" +
       "MHBaLCC70g/7XLfWsLDOTjNhvvJIE/GIkqkXgRgEhHqUOI2G3C6DEUy08u6w" +
       "EngIXCPwmG1bsZ51lZqGcxqeTcSkpE8Nc9z2OzvYcZwQuNyO8YJj4RWZj7vS" +
       "XJi4vgni4caeGLrRKfMsO27ZaLmqoRk3t1tn4mM8lm2mqQx7QZ7KWWRRyk7X" +
       "IlBVdmBe8B5S0N58c8KLYptZJeCeVKryF6pY7w6xzCLCoQd3Iihsy1mLCYEt" +
       "RKRKKFwSi2pcTEE/b+2ERLfAat+C4mk5C0O+qA+trUX5smBMFWSLpaNs9ieQ" +
       "jXe8zee0Z9cGs0iXKIEvT1tPc+hltcQ6SQ34Piq7PMojO2oOed2tGJNaTo7a" +
       "cji25YgaLAo+NtS9A40tdNnIXDogB7TEbjHopPGK0GwLje9YACLL6jitHQyY" +
       "pDPMKCo+61JFtd1TbKGnHamSp9kMXxkCJsS9sV6pNihxBKNPy3g+n2zBaEtr" +
       "RK33hi9NjvXcDk2jsrLpYjlnhuwxbuACNfb2ZnZCpaqMa2KBGrbKG9osTI7Q" +
       "Zop4B3+wF7077LKJL4UznhXnWgYnEXnMQwvhSThnDdWTU5n3cDBMfCrZYOlx" +
       "jldgjaIzi0XropCHY6q1tYiMIBkC0du5uyQ2a/2oSEBWrXqI5cB8bCX1IZaq" +
       "JM5Uq1fXKY5Jk4kJcMo4KUVaWhywyO+GbOEEVnuECSbWF/16akGyNsl4Wj6u" +
       "DkqBY+5S2GGhTM6QaK7DEpVbHjRkG9X3GgDTjYW3W25jVAuhMVgfMwbaVE7O" +
       "iUpvCId8J4YVEShbr/PDXJ0uTiKfxxDQIKyLpj262ps6r/EhGfssfCC2OlQR" +
       "Y1b3pRPENS1yxOox2LpoQS5BIWXDxFhXpA2BvMG6C1DlTshhClOrHW/FzaTr" +
       "sIAA1UCdRAiRx6JepEkuqnQO6MqB6tvOXqY7KOsViNngcDSJ5LxIpb4vQXzS" +
       "jxM2QU1MacdLn90F69AjOtCQbTmzFKgpxY6ejiPnuFihcAs4ljRXXA/rJth6" +
       "wtZCQhtTm2GjtaCTIWdvKEOxtSmxqtwx5StIxnLzYMWRNY6qpI/ncMCxtL5m" +
       "wrE40ZwduNAsRV1bgxpmvb9l0Dr2nSM6raMdc7KyciLRYKZzIpSCwDJRm0TK" +
       "YIYhpDIS1uvpAtzkCmweREXAe7Zl20KmJdDx2apSZuNuMVy+xqfQNcMjTAk7" +
       "vxZbxSrbNauwh7VK6exuSdf0XqsppFaiYxgqYIDuNoKlKXWoJNKs9KO+4kO9" +
       "6TV/DyJQTuN1BXO7SF4KjRo6fDObsvhRgVFLxGTULJFcM+EZlznp5qQRge2j" +
       "bW5yfG3JubyxLUQgWZaYNTmi+JtxF7SDfBwNNKwWWxUT1Cu8hegN360Kv2W2" +
       "Ip/Wga7I0Aot8/DAK7G5AKmpv1cFvWNMZEZupuYpKBZmm8hTsgxwW/brlTsp" +
       "qCCKnUSiqgVob1xkNccqF5CwUndQzQ3VPgzXcEBEqCCipuPsSkQRi+I0OR2x" +
       "zViHuDLduWMQkHf65HhkUQid7psyifazLkK8cLsDrHTMiRs99nsCMMZjvjyM" +
       "d6pjeLSvkHLBl/xKivRJIXncPlZ1Gw2bVvZ5vBDyKkY3aR3PoXTsyCLDQX07" +
       "j5g8QOc7Qw/3VpcJVqXUNGQ4gITMwWlWTYiEB1lxtdc5rhs3q2AhMn0czvDN" +
       "fO6sHJXZ+oFYcdKx5sWoa0Msx5doQRdOfDCZyiV3+V4KE21KLrCqL8yTP214" +
       "QTjJwoaqeFFd+ntLXeOF25L41mwLW01PiD3nhPyI+C1O4ayALWQb7qFUWh1M" +
       "8Fgkk1W9jRp0mgZysKf5BeKlia7R4yog6EnSZEsllhqgxuuea0qMZwoDAE/6" +
       "6bRSSDAzVLfeYjueBZb+ovKDMEl1VUhDtlUigTKBcidw45Uwb+15S5o0xUg2" +
       "KyN7fFxmCtM4YLVrlgmD2f6+35Ixy8PMPj/Nie4wWRw9sdZwdIlHC4JkT9Zp" +
       "40YooFihexjjnDyhuam8rqbqKQnnMdHqB/KkhyQp71vKLHXVWBCh2o3p7di0" +
       "3TaNtRpUNlMByhU8bbbs3uwI9Kgx25qCTi5Uez4xdftkNt9HXA0iaZxs90tw" +
       "m2+0hb3qURjZYuXgO3FzIPcy7YDr6hCUAM/4hjmZmn09NyEx2LvLYxaA22jT" +
       "ZgxOBTE0DUq7jNj12iY2xMQL6r0iT2Qwao6ZfqiSQ1DAiQqNd34gHcxNOta9" +
       "nHcZm6i1k9CsBFCBFR0cF6HK1pyem0bKMzHXLwnaczRIsupDp5cECWussNBX" +
       "tQkSXuBujcBbBVNSDdpaYjnK3QbAECD7ZMOzO07ZFOPaVBjAtSdopQUOsnY2" +
       "HT9rGipeuYLSrdp537WJFW1NZH3yN0lJbllFzdTCU4yG8JmsbtjAQNis85I+" +
       "O4Si5u1iTe9nGblAomir0q7q6ew6C3hI3dDDgS9axnJRpc6eTwsSgXCrpHA6" +
       "awW8zJo9nu2pVWzxYWiZXUXN0O1apBmNWk+QJJiKSyVc28B07tFltpSQLZGU" +
       "OdR10+PiSKmzUICmQlRiy3y4MpKHkOrDKNTwxRBecLmnRVibwet5jS/1s5zz" +
       "kOzjaIb0fDUcC4gy2h4aQoLVg4CMQXI/3aaecJge0g3XxpYxbfJ8V64IQdWc" +
       "TJC5wtuGVgrFOxCR124lx1CYl1im4TCXp42UCU2w18b+NkXIDa6xMkl5Muoh" +
       "7D40dDReer3Vuv6AYTTWWgsiaMKhhAIzcqCldsvMUROAxb0j7ThzzkmbGowA" +
       "ee4vrdrrQEijNs5MLmZkM+84kfEFj88rYJe6bTv2QA2birRRwlg2bSlaHKJ1" +
       "Sm/XvLAO9DFQzPci1xXbbrtUmthuOFZ351PQDakpNNY4Y4fizKm3u9NMBMY1" +
       "q4zdEHNACZ7lbdZzRONByIw54Za+o8HjKpt3fJNGU6fRBjOMzUY+1kGBuA1I" +
       "rzcYdsA2Sns6eLXIkDTlzNNmspgOVjgU0E6wBc8uJkcL2A7CgHOrp4dQ8oXq" +
       "mCV6OqUaSwmPkTDJAceHw21hGIUjFlmTtKIKILWkrVCJxnDWXPg7Bx9n3spO" +
       "t3PSZdFVGNb5bjucqnN9N47kplgZttUgubmOwxO7ch0aTLmqFYYtpRXSPhPK" +
       "1bphbWJ6PK5Qm3djIwE0QoyLHUhYOlSQHuXPOG5pNSaDTmAYdO3DxqeobeSd" +
       "LIWepbFE7rTJvt+PexnO3Nm6bXLL2ittNTdnx7GzLE20oGyFESAI30rZwByB" +
       "UVqs0CbHtcO+tz/R4JgOZtR+TlYz3rCa8XS49Jkow2xRSKoDP6mXcIcrtNE3" +
       "e4DjHbGvcxLdb440DY1lJFq602VFwuzY4mobXFtbnUq1YzyhSSpwTRfrC3vC" +
       "88DqxNAEvnXgdlNCmQAupR2+5RofZPk5vcGTlUcUc2DM4msMVDBCgwyOHvjx" +
       "TL3J9xnNhYEpRSllU5OuVGN3sNqu63xIX9bGftswIDvdDtEkTfEx5E+XB+to" +
       "HA72nMDgwIbxKS3DQJas6V5T0e0ckJIy2synJ9KM02TLEGu15uJt2ZOw79Jy" +
       "vZGlsrM1TAeLNqDlIAdVipDMKlctwxluV/pK1miYn4AmeGp5JiPY8aYjx5Gq" +
       "Hgi1JHM6R+kSRgk2NEWvsy0WO7lWG2SghwY5brHcbKJbgoRNYVxakEOGxTB0" +
       "XNcLyjV8G6GgfgYC7mZzHDN+HywwACnncoyUWAzUR3hyQKyx4ADJYTcDEURf" +
       "bxkECslku9Hmu+H2WRLMwRscjFlsdHhqYMdOoczYQxa+gjMEm4DgUZuslzO5" +
       "O4HElI7MVbY4AUY9aVIZCu2KBRIUyJbHIx4Y6R7AfJaR0PHRhqc+vSDjHao1" +
       "FEdaGsqEcSMw9WljsuK0ywZTCsCMMSsT4qaHBO/hbsuAsUkFgVh4eKIXTL/Q" +
       "qjidrX08UOOd3puYHEzGGQLRh/K0AyFTKE2wjMd1vB3TBNmvBW26NRez6KDY" +
       "eaKgPH5o1og76aZj2QWGDCx2CpoPt8XjwLqmz4x5H0EnDguW/UwsuHRaIZrt" +
       "C7y3Q/cqegz2+O60Ao5rzq7n8SnXXBWIJNo++kHAMHN/visgZ0FOc59fdabm" +
       "NZ2Mq4vjdrcg5jBoKOo4OyxmfAAB2kk7bICTQ/XmPjyRouHSe+OkDTdhy1bd" +
       "ma7a081kt17rwRDYuSyybbcNvIlEqGNpqepygKvUQfVwFWDhPCQ6calnFE9Q" +
       "FSsoEFAttZ1t4cMtTw93SSMvjj7YFBQNUoU6O+3QLZnVE0euVmkHRB7vaShl" +
       "cAdoyh8nPeAnpS8LKh9EkS8jeIfqR1VJF/OwUv1SWOlZUel4layqVZGfADaX" +
       "joJCc3M12sJ8t+uJ03pDEsQB4X3c2eDFKVsOFwm2sSPVW5HeBnYcPYgq2F1y" +
       "YlKlReZYKbMm1F4uybbYkU4LTTHfa+kCXMLoApEqKjwdudo42liheml1qAHD" +
       "17WmX2Amr9iigMCuDRxMoKfVyS4pKqll1HSTLYKY4Jlkt8O4fBUg1t49yUFg" +
       "ZBtPaTxAWgq+xVSsS+byTiulg+sY3GSfRkm9nzILhhKl2NqA2tTDlSPloDYc" +
       "hWZS4HjpRQse34XcNjbpTsFN2CYb0AsYPeE6cAGAmMYvEi8WHaFTD9jas7vj" +
       "ppeHA4CArE1vXaoObfjFml6kqajzJuDTflcXPJJI1SxGOYtG6NkaWU8nsk/t" +
       "A2239j056UsyXZwWmC+QtRlWi0l5kpKGJx1UpGHA3pJWLlljVAdBISZEZhGH" +
       "y3WUMfB018SKe0QRRLXK7QacuiZOR1013aoUpWplamEQNemnAWBZaHUgeamb" +
       "p/C0JJCF05+WquZOpzFIt2kSwwtbWaGHPpoF9UQsM5RAT4fMofN4gZd1NgZo" +
       "sYXKIdfI5mHOc6obHCXntHD3kRfwprKmzXk5tvkqyRLM3VZlKxs1F+VNsNP0" +
       "GNJVWuBjQc54hgYcckrQw10RInVW5aluOhN2TYJa0HA1LfsxAtkI3PYwEAIu" +
       "4h7EMSzNckyIW7uF9sDGAcftkYc8fLsgFWGysaODIAyXSz2HRWnWz2VPwKiW" +
       "KthTNXXCYjgbDQdVYBBv1y4PbDnZklxPHaL5riI2GzGdeqDolPDSP4ALi5+I" +
       "4sJczxpxXqom6U2xg28ewmIvEgrKtCXrRvIU1ZfrNW2sWclZo71/GHKn0OhN" +
       "aGtL2fP7petAYrLYNzOUZq2DmQAKPMF521e1Zcd2y7FVjRehNJsbBsaVJMRx" +
       "SbvLfA1FfBSWI6xKZimeAxFXzgUTzZYojiqJ5y+PDeZ5eupCB8wIFgGaSxAY" +
       "Z1AmhiFCG/Mt5poMuNpL6gzAFgxnUZ0d");
    public static final String jlc$ClassType$jl$1 =
      ("9moNNjwkNypO7/X62GPEim3Qmdv7MNfr3HEs0qeV5II24x+oWb02WJDYszQp" +
       "sEdKUJt5jIxz0Aa5drj++Lzt9DvHWjS7Llj7cbg/Ht3SwRkaxJHE1jVxVuRe" +
       "BsrU3kd7KJnBk3rexTXAUKR5TErXG5+YXJu1DSO7OgvBkBvnKupSuyUGkWks" +
       "bA4bZtdEUI3kU6todoS/XvM6FdXEaj7F91RW596a1ojhJq1o4OTIL7L5AZwx" +
       "bgmQgawHm2gOVUdtMU6lEl/EXu22JQ4DgVJ7djO1OgGji7jnMtg4AYuC3J8k" +
       "BBpnjI/ZFXUqOiS1+qJ2EXkw9XR/RGP55JsoWKZVN5NQ3c20cda5HMDNguFm" +
       "OZE9CXe3g33dYXd1p3ILqns6wqloGkBMdlCCtIk9lZYmTiB1nHXEvSTBRFlO" +
       "jyf01CIznLKzqJ4t91aM9Wjja4ZykHFEJHrhyIGIMh2zCrSxt/BYNogZULUr" +
       "FvR0roM0pVuvBkP4Dg4s2pMgQJnNc0Q+RtBFaJ48wNLSDBn2kCO9ag+EhqwC" +
       "qN2BnKwKawPGUZWNLABh2sFUeoYxBMY2Zq70qy4l7GRi8VirzL3ab72xOJa8" +
       "vPZaCmBrxzg5GYz263ZiL+nD7IDKBkh6YzygQZIuqY0tz5tmWlBbJEF2x2Fb" +
       "sgOWOUIM0U6o1ZQIJ1rpb2xEDHyoIFKk3cyEqqIIQPP6HRrt+dilCqJnE6mr" +
       "pbabLbmCnKVa5qHEWF/MUaIjUa2SZnE23+NDTEgqPvMOC3g4SXc5lGAALtO2" +
       "T6KAmwp7zj3NRdfBixVKQgsOBSFY32H7fThf7vYEgITbscKCBTwV+Zqd+JKT" +
       "9t2GWkpaR+SSCS95FmGHyyxXuGvHC63enTrqZrgL70WqGc/9NYZNkl3Wz0LT" +
       "37lJv4BhpA4mGXAUixB1YwXkPajZlfPwhIb9oA/cyirZxNYrcoyrO2UyLIQz" +
       "AEypcD/fVvVusdu4fRvRlpgPqdaYMUFCVjIGn5qOY5wCbSnT07EWWjZMfzhu" +
       "gfFs7h78ZbeUtmhEnrbhVprthbb3GnrRc1oclCd3uM6bG44fogBpgXUvbisA" +
       "mQVVizjxPsH6ubu3u61PZ0eeGWNuvKZrP9YBHMc/fn7ltb1+e/bi5d3e/Qqr" +
       "MHDPAOnNL8iu3kUeHv8C8XY9ejYvg9aoL+89F/feHH5goPfygwUuN9Umd8Uz" +
       "zkffaqG7T3jp+cnu/kvUy+fZM+B6fOuqBuPum2swvu5O0RhVUDRZ7bxyzeyd" +
       "gb9vMhLzjcsbx6vRpQ7gMjxDzxq5ewbeFQL3uoZKfP3VPK9H73sr8BMFu6ol" +
       "eencGL+nGObvvxg8dV32YcbOPUm+4gkYTxQm/HyE+cbff2E4o/IfFOTL3gL6" +
       "RCGyL7BFtOzqrflbW+RhjBthuscHyei6ZOemRuV+uct77pe73PfXcwXEB9+q" +
       "bPFS/fD9f+wz32fLPzC9fU356+vRO+os/9rYaZ34gVXeNVD6ykcoSZdSzZty" +
       "lr8mffbn2K+x/uzt0VP3K1HeVPH58KTXH64/ea506qZMtYeqUL78vuHeeVYA" +
       "NHy/ZEhLX3vdP/1gWcWNH1xs/qH7Uy+6e+56ytuu+lu/88DUR+qCbl/lvvuF" +
       "Fx+7kP7jT6ge+rZz8y2Dnz6QE1++yYkv37D2xsMCfXD4fvmw1jdf9+HnJ9B5" +
       "SnDdW28t0IOs/qknwL7z3Hy6Hr29zm4KPqTH8f3+K95v//x1/7c/P77PU37y" +
       "uv/xz43v734C7HvOzZ8Z+PaHzEBm9sWBPvY4vv/A8P2q0eipr73uX/z8+D5P" +
       "eeG6f+5zcqCP3ovQ996P0Afz8GXNv/wE0f7qufmL9egZZ0hGcfW4ypdnzSyL" +
       "HSN9nLwvDd9XBwE+ft1/5POT9zzl1ev+w28t762bPfyvXKj+8BMk+tFz84P3" +
       "JTr/+oFHWH/7GfnFNyfpP/g5Juk2C+xLLg7SoH7l1TvfdOcbPqneeePV++Wa" +
       "n/PGcIb+jTx/gjg/8QTY3zw3Pzb45T1eHlu4dOb2EQW8+15ueFgBt4jfQwFX" +
       "dV53rgo871z7xUUT95Ju5r7yDZcisM9hJxM/euca1WiNR3GvNpkr5OyTzKDk" +
       "wL3zSnYnuL/QnZsEeDbBza871p2P33nlAWj2+p2r5H/n4apN/VyGVw15KHbq" +
       "LH3l1dcGlxksHDtprWWvWK896RT60YsEr77+xjVld/A15/VHfeBNB97z8KvP" +
       "jfDAZvvkyH6gtO165z0D/u4T/OJnz83fuSpSfcAybwqFe7XH77vnAfcenKEf" +
       "/P2T5Nz8zAXrHz2B6188N/9g2NbPXFtGVb+F7m+YekSML/l/EmPxWDEeZPCX" +
       "ngD7l+fmn1wfwDynfsvz/ReC8X/7BNi/Ozf/qh699CjjjznOfyF4/89PgP36" +
       "ufkP51LOR3h/5AT/heD7vz0B9lvn5r88RuePObB39ei5G98/F62/703/77r6" +
       "F5L1I9/3/Nu/7Pv0f375R8P9fwo9I47e7jZx/GAp9gPjZ/LScYMLW89cFWZf" +
       "qeC369E7H4i/86P/mV8F8v8F4n4s42g2AAA=");
}
