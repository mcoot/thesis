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
      ("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" +
       "gQkfVERo80gGhG4bim4KYqM0FVCazVCZwerJnogNqottgOlhABXnEnr0nUPo" +
       "cT3lcIi3c1x7H/YugeIG8Avw0ECr5aFuEtq+bm+wGhqtjVWxuvKL+zOAbXJZ" +
       "1k1fkeTfiENVrwTMYfucGSYBTChv659QbnOEcgtdEOUOuYdP2DgbR12EZQww" +
       "wLkoE7+DnIxEAp1hVqdJkHVmdca8VxHTGpa8bsVs6VSTSrK8PkgB/Ol+vd0L" +
       "OT+cJLZbgycFBjc63XVOpDeF8K80SU8eohoTdOi4Oxj/2Vi645d9o+96asTD" +
       "uxd54r9y/wabJSEp6XT1hPje/pel5ks+fpum02pP2n/4q1kGO2abbjg31nEW" +
       "WGUfsWBlASqy6efddt+jZ15tWohWz5XgeAMldsDsIsgwShAo7/Oe6tj41KxR" +
       "NRulhLhxzL9eNPGpa77pTg18AK7Rux66t/CdmR/fh9u206xKX5plA+RMtaCc" +
       "T/HFrN7DKDeSbl6NHf3Kr451L3+bouvnbhjElXNGPXO6bNz1LDqFBe9nq0L1" +
       "QCizr9Jl02F2tCZ+5J8Km//FxWzkICFBDw6k/IRyv8OAh+30zEfPxappqp0u" +
       "qi6ofHlT3acv/b0lgN+3qVLt3aAP0pPizXhy3K7fblttzfEDutVDrq0+Qpvu" +
       "oG4JbcmPseWeUDuOjffSwVAedibc4JkwpOmgA/aEQ/INNsmDTbQus09FvEFB" +
       "A9xIOK5d3LLgv3Z/1lWFMdSwDoFETCSWwzxQRzNi/zK54f68oe5scYRvsdbY" +
       "oXvH11/xJuqik7NgLOULLDCoh0SshNjjJ1j9oxAb/ny4DefhsZoacu+ZWCmb" +
       "7DFWH3BNimm0N5xARMaysY+HIeLztpAwYlwEA3/C6sNf1NsC5HG3x7VdUCml" +
       "A+18NkjAkWT5j1n9pxACvnguBITJ3mH1G14C9mUjIIz9MAyRbASEgR+w+v3z" +
       "QcATuQh4ojecENQIbHApVSRwq9qSaTNM173W1dPXPXfzOGMnta3VtlZIvWYN" +
       "4sxA/XC/OZk3Z4hZdTuax/w2kiLCqoOJmhkw0uSi2W9UcS7qu4bYtCy0pKCY" +
       "oC2wepXJXRbrUDul2CYpGetR9c0xUOykbJj4oMhts0jWSZ8hUSc7pLk6u9r5" +
       "AtCI338gfqNJBg1UhEE19iC8bAnQNiEOn//dttRNC4+i7ShBcmD40UIJM817" +
       "6sGAqlq847yXxqHcSIinH73t2JQ/rhuJt4EW4d3n+ysFrc5/ng8HdaR9UOHL" +
       "zz0/5rqX8ji+gStWVCHZIODVCFdkduhEKFUl2asxxxDpGQyKhhIFBGm22QaH" +
       "T9xMxi6D1W3Q+wbK6n9aRxpvZznSsC8Ezs+xhkZPGAASU7EPkI0pKH6HrR2E" +
       "QqKVftO4McJxPsWOWYkWHND0sLr7fCj2J27F7gV3XxUmQ35xqK0TVx1R51ej" +
       "TBVAZlI1G68lQkSpjrr5N2HySdlutPFY4sBNe/YnVz9Qa8UPkkmYr2qzFKlb" +
       "UlxmJD9gRlbiHb7jLy+9f0nVxCNdu87fPSE66vArwcm+TfmReWjloReWTRN3" +
       "k0jBvg0MvJfgBfLfZtBV13jO8cq913JwhjCOKMUNrN7kFg+01lTioZgWvOwC" +
       "EJnVogs0e24WGZajD04yIkUmN9hU6esTPt+GKI9i6xlhKPtUYARH/RkO1Fnd" +
       "dR5UIDIqkI4T+1qKBgoNLMU/LAWFBohkI5Qhe+FxQn+iWQoQKbdjUNLgD0t9" +
       "TQcdsEo74rXGuIJgpwlKjK0jBV6yj6fSwh9n9VMDkxQAeZLV7ugshzTMytEX" +
       "g2I6kRQSQnfAjV6YpAxn6x0JQ9knKSVWqAUDn2P1s+dDUuYGoqCcUlHtSMXX" +
       "+iUVCBCpc0SgOigV1UGpoGALHRGoDkpF9Vml4kIOrxHzZrF6+MCkAkBKWV2c" +
       "XSqsK2cvj/Eg0Vp4LqtrAjy+GNCO9/tQUWnDZvp+V1TqygiKEXaweGrHgVO3" +
       "7MZDxchKeniWlVGRAigaKEHgcVmuDVJ83bhDuQr2FFmtnbf5oGjFOUPxhp6/" +
       "MLk8Qg8qnF661zJ6XxpGd5K7WsdahK7RNuYKIxv6JdAbce02R3o3BgV6Y1Cg" +
       "KVi7I70bgwLtbVJpE03MIkp4bOc7nYyshyfRIh4n+oQS5JC7khFlKavnhwsl" +
       "nN+29Eso1QGLZFcOkWSsjag+xiLuDQzneBjuAJmAortfnOxBgC0O23qCnOwJ" +
       "cpKC/ZXDtp4gJ3uCnOyxOHlz/ziZwQGv2tvH5G0StWyRBlaTAHXBgNKvxiXs" +
       "1aE2xXo174tNgMTYboUYo+0Uzj0Oe3+P5VtnzXbKoTvG9nc1q5fBKt9E8u1g" +
       "2U7k9nA6fsnZTuROO9uJ7ISnj8POOZf0kUhXFtnB/d+++PzjfzN2zSx6wQlv" +
       "Z4Yd2S8SRckwmkiv/xUEJFk9k/hGVjd4Tdq8JF2SaakuaSTBJMpJVJAoH9y+" +
       "IAmiAq4SBSTAmWjBI2I37u6T0D8+9u3Tc396fK/nOH+yf+fOLvDasLZx/KWX" +
       "t/7kCJ4oFqVJ0qOvyigkLeEVOeTdPs9Voydh6A2hsrNWs6qal3xbeeTvLvnD" +
       "enrMEnwLyx6s5s+vW/bk8mm85wVfWKUE07rIPg4tLtrTXio0n8OP29B0ocCj" +
       "2F+dIwR8EIqlRASpQQx5GXVtenNa7UnTs56WIYcyf/30rJMWcdkFO8uafZdE" +
       "AUKwqZi4jYq9tW/1R6ces+aC2xzijjXrEg199A99jdSXohu0Nm95D+oM3I4B" +
       "Sh1JZWC5Dsw1Gl40cA6FWnJQ6HGkEBQPhYXHUSbn08JiNxy6xAYYEQZQ5gY4" +
       "+z1pfraQhm3QSx6k4T02AvDCCZ7TwMJTWF1+njQUlvoerdAnHaHi6Yp+nERh" +
       "ouUlAIFKVvuur88tUTjqThQGIAy9mm07XZf2hW2qqkhCOmeyQUPIvXSCezTH" +
       "czf0ulx0Q9BrNwS9Ns4VOem46Iag127wJBQml0/oe+FAVAKK15ASuSIbXr3Q" +
       "IQ/18vB4K/afgmJnbo/ZZXm/yD1ors5duAD8d1TAsqcHSNJ9ltAhUdxW8Q3E" +
       "e0UOTT/j13R4/EemxPD8JLW771AdzR629U9voXi/62ypg4+5DjmPfDFy/rlf" +
       "5DziIaejX35p+nRg0oSN70Dxi/5oFin4SL9iZQTg889J6/iiAWgdksiXxkNI" +
       "WE04vYDVM7q4gaTxAFLNaveLLj6JjbDrnC6PL5oMs1zEoFew+go3Ajbf+NFf" +
       "XsbEj8mRMVGawagSO+nmS3Ntj2LrxhzKsbAjvkz7KueDoQ8j9LTsFoWfDsUw" +
       "O7pCoLBYqYtFOmThYPjjbgzJN5HzsxnHV4dxHiaCfJOf3R8d4msR9YtthSEN" +
       "fh3yNR10wObbCmONcemQr0mlTTTf5K+gyoFllnzT3r3jiPjFXWd3RNh+ttTt" +
       "q09RacLILw0nBL7x+x4U/w3F+0iSDyDpg4ePuuxED4pPXJ6Prw8IPBQrUeiz" +
       "mWx+PBSLUGqQO0hr7JmSQ+CbUOChqPYZKLSQY5l4zguzkNTP2gAjwgBq3QAD" +
       "f6kQLjHw6gPmmsvqOe45zzHs5GmO5Q87fQYGyioWdjKy0ogipxdk1igYX4Jh" +
       "cFSyJKilJUEtxbn4lKOSJUEtLfHFl258HTGYmEMMOv1iAI/NTiTFr+kP8xy6" +
       "ZqHl5P8PtNw6IFrSMChAzJE5iHlzP4gJ1S2UoNmt+wCIDMXOrtwGwrcZbLyl" +
       "3xyAx9v75Y8omXefG3fuGgB3iPIXez99KQt8q0+/Lxcf2V8yeOz+tSfwozT7" +
       "S5Ai9m69+wMQ13MBic5TMm6/iL6uiRE0v9/khrgsCzTRPNp3G0rfNeml8UOZ" +
       "m7DhgnPA+3Uh3NVn6H9hkBD/NKd2yTPHph1lL1Jmfb3EgXh0/4pV1787j36P" +
       "OIjYwy1bYNHBca6Qho2IA3xgOSXrbNZcBcurPxn2WNFU+5M6KEa4YmTP7sqc" +
       "QOCq3rDDPM//sZAQN3Nbd/50+4gbCaatXJFsrNEzhgn/20GRaL3zAHO1WF8+" +
       "oPYcIhNf6H+f1DWt+4gxsmnv6njh51fbR4yhEowIl/4vjo3+xdFCAAA=");
    
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
      ("H4sIAAAAAAAAAOV7e+zs2FnY3LvZ3WQTsruBhJDnJVnCbrx7bY/HnnG2ofV4" +
       "7Bk/xh6/5uEkLH6/3/aMx7AoVIKkRUpRGl5qQa2UVgWloUWNiqCo/AMFBVUt" +
       "oi2ookQI9SEatUgtVUsL9czvd+/vdx97SdRSEB3J55zf+b5zzvd953uc8/Pn" +
       "z3158HhVDm7lWXz04qy+XR9zp7q9MsrKscnYqCq173jF+n4A/MwPfuszP/nY" +
       "4Gl98HSQKrVRBxaZpbXT1vrgTYmTmE5ZEbbt2Prg2dRxbMUpAyMOuh4xS/XB" +
       "W6rAS426KZ1Kdqos3p8Q31I1uVOe17zTyQ/eZGVpVZeNVWdlVQ+e4UNjb4BN" +
       "HcQgH1T1y/zgCTdwYrsqBt85uMEPHndjw+sR38bf4QI8zwjSp/4e/amgJ7N0" +
       "Dcu5M+R1UZDa9eC994+4y/FzXI/QD30ycWo/u7vU61Kj7xi85YKk2Eg9UKnL" +
       "IPV61Mezpl+lHrzjNSftkV6fG1ZkeM4r9eDt9+OtLkA91hvOYjkNqQdvvR/t" +
       "PFNbDt5x355d260vC3/uU9+eLtKbZ5ptx4pP9D/eD3rPfYNkx3VKJ7Wci4Fv" +
       "+iD/A8bbfvaTNweDHvmt9yFf4PzD7/jdv/Die37uFy9w3vkQHNEMHat+xfqs" +
       "+eZ//i7yBfyxExmvz7MqOKnCPZyfd3V1CXm5zXtdfNvdGU/A23eAPyf/wu7j" +
       "P+78zs3BU8zgCSuLm6TXqmetLMmD2CnnTuqURu3YzOANTmqTZzgzeLJv80Hq" +
       "XPSKrls5NTN4XXzueiI7/92LyO2nOInodX07SN3sTjs3av/cbvPB5e+Z/nnj" +
       "YHBjc1nP60FAfeijWuWUdD9L9dFZZjWJk9bVR7U0+GjtO1VQfdQyKueVqm7s" +
       "oMcwjbruMf0gv6f9Shi4H61K6x44mWWlHfSG49zuwfn/y8XaE+dfc7hxo9+U" +
       "d93vIOLemhZZbDvlK9Znmin1u59/5Ys375rIpcx6m7w2/e2r6Qc3bpyn/bqT" +
       "HV3sc79LUW/9vYG/6QXlY+y3ffJ9j/UKlh9e18v5hPrc/ep+5SSYvmX0OvyK" +
       "9fQn/v3v/cQPvJpdKX49eO4Be3xw5Mme3nc/i2VmOXbvr66m/+At4wuv/Oyr" +
       "z908KccbejdVG70i9Tb/nvvXuMeuXr7jo05iuckP3uhmZWLEJ9Adx/JU7ZfZ" +
       "4arnLPs3nttv/sP+d6N//uD0nFTw1HGqe0dEXqr/rbv6Xw/q1W99z6c/9Meo" +
       "Jv3mH53ypCIfgkeTF4ejl4aT/EJbTnt6nxzPXvjDSv4jv/ZP/wNy88T/HYf9" +
       "9DXPrjj1y9ecxGmyN53dwbNXKqKWjtPj/cYPrf7q93/5Ex8560eP8f6HLfjc" +
       "qTxJx+ilkpXf/YvFr//mv/nsr9680ql68ETemHFgnSl/Vz/RB66W6v1H3Puw" +
       "npLqOS1NMjtwA8OMnZN+/s+nvwn+wn/81DMXShb3PRdbVg5e/KMnuOr/hung" +
       "41/81v/2nvM0N6xT/LoSxxXahVP82quZibI0jic62u/6lXf/8D8xfqR3r71L" +
       "q4LOOXupG5cmcyLqLfXgzf023T5Fqtu8YTrxmdkXz8BvPpfASZPOQwZnGHQq" +
       "3tmeYW899z9VPRg36FMAvjIMHfzcX38H+S2/c+blyjBOc7yjfdB7rI1rNjv8" +
       "8eS/3nzfEz9/c/CkPnjmHPuNtF4bcXPabL2P3hV52ckPvuYe+L2R+CLsvHzX" +
       "8N91v1FeW/Z+k7zyWn37hH1qP3ndCntBPHsS0jv65+levj99Wf/9E/SZ/FQ+" +
       "294YnBvYech7z+X7TsU3XezJqfmBC3Wre4V5iFxXZZD0BrC/jMfOJz/zl//w" +
       "9qc+c/PaoeX9D5wbro+5OLic13jqvNBplW981CrnEfS/+4lXf+bvvPqJi6D+" +
       "lntDMJU2yd/9l//rl2//0Jd+6SE+/rH+eHVh/Kdy+KC4vrZn/b9f1v/5IeKa" +
       "fkXiOp4aH7620AV7N3pDfhy5jd4+K+784VM9dp6qt/jqfG7tR7h9HIrvzP31" +
       "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" +
       "KxTbMDvr6IIIVLLLjWVHtDhpDFe3KULj");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "Nx3nGJqaOgAA");
}
