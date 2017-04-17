package battleships;

/**
 * This class represents a Ship in the BattleShip game.
 *
 * A ship has a length, a coordinate for the bottom left position, and 
 * a flag indicating whether the ship is laid out horizontally or vertically.  
 *
 * It is parameterized by the label L, which is the level of information 
 * that the ship contains.
 */
public class Ship implements jif.lang.JifObject {
    /**
     * The bottom left position of the ship. ( i.e., minimum 
     * values of x and y coords that the ship covers)
     */
    Coordinate pos;
    /**
     * Length of the ship.
     */
    int length;
    /**
     * Is the ship horizontal? If so, then it covers coords from
     * (pos.x, pos.y) to (pos.x+length-1, pos.y); otherwise from
     * (pos.x, pos.y) to (pos.x, pos.y+length-1).
     */
    boolean isHorizontal;
    
    public Ship battleships$Ship$(final Coordinate pos, final int len,
                                  final boolean isHoriz) {
        this.jif$init();
        {
            this.pos = pos;
            this.length = len;
            this.isHorizontal = isHoriz;
        }
        return this;
    }
    
    /**
     * Does the ship cover the co-ordinate coord?
     */
    public boolean covers(final Coordinate coord, final jif.lang.Label lbl) {
        Coordinate pos = this.pos;
        if (coord == null || pos == null) return false;
        if (this.isHorizontal) {
            return coord.y == pos.y && pos.x <= coord.x && coord.x < pos.x +
              this.length;
        } else {
            return coord.x == pos.x && pos.y <= coord.y && coord.y < pos.y +
              this.length;
        }
    }
    
    /**
     * Does this Ship intersect with the Ship ship?
     */
    public boolean intersects(final Ship ship) {
        if (ship == null) return false;
        Coordinate c = this.pos;
        for (int i = 0; i < this.length && c != null; i++) {
            if (ship.covers(c, this.jif$battleships_Ship_L)) return true;
            if (this.isHorizontal) {
                c =
                  new Coordinate(this.jif$battleships_Ship_L).
                    battleships$Coordinate$(c.x + 1, c.y);
            }
            else {
                c =
                  new Coordinate(this.jif$battleships_Ship_L).
                    battleships$Coordinate$(c.x, c.y + 1);
            }
        }
        return false;
    }
    
    public String toString() {
        Coordinate pos = this.pos;
        Coordinate end = null;
        if (pos == null)
            pos =
              new Coordinate(this.jif$battleships_Ship_L).
                battleships$Coordinate$(0, 0);
        if (this.isHorizontal)
            end =
              new Coordinate(this.jif$battleships_Ship_L).
                battleships$Coordinate$(pos.x + this.length, pos.y);
        else
            end =
              new Coordinate(this.jif$battleships_Ship_L).
                battleships$Coordinate$(pos.x, pos.y + this.length);
        return pos.toString() + " to " + end.toString();
    }
    
    public int hashCode() {
        Coordinate pos = this.pos;
        if (pos == null)
            pos =
              new Coordinate(this.jif$battleships_Ship_L).
                battleships$Coordinate$(0, 0);
        return pos.hashCode() ^ 4007 * this.length ^
          (this.isHorizontal ? 1861 : 2713);
    }
    
    public boolean equals(final jif.lang.Label lbl,
                          final jif.lang.IDComparable o) {
        if (o == null || !Ship.jif$Instanceof(lbl, o)) { return false; }
        Ship that = Ship.jif$cast$battleships_Ship(lbl, o);
        Coordinate thispos = this.pos;
        Coordinate thatpos = that.pos;
        return this.length ==
          that.length &&
          this.isHorizontal ==
          that.isHorizontal &&
          (thispos == thatpos || thispos != null &&
             thispos.equals(lbl, thatpos));
    }
    
    public boolean equals(final jif.lang.IDComparable o) {
        return this.equals(this.jif$battleships_Ship_L, o);
    }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1492411779151L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "C47oMx09OyIc7ykB+O8nOiztiKb5njV8");
    public static final String jlc$ClassType$jif$1 =
      ("Hz8yBJpiaIYiW4fx7+NHRnY46QI0o0XP99mAwENzFwp9OpMdhR82jN6CUoPc" +
       "QVrjEz2DwO9FgYdmk89AoYUcycXz92EWkvlZB6A4DOC3IkAvrgphrbd4/6a4" +
       "Zu6R5QOhkaXPtEBr8siSEzSLyJLboWBkCSbBVcb1Qf1cH9RPXCv6ZVcZ1wf1" +
       "c70vshTxdQVgQwYBeNovAPDxHiGGujfLS0JO1zS0bP//QMsjOdGSBUABYsoZ" +
       "iPmjLIgJ3TFG0PRONwciQ3OiI7Np8B0GB49lzQH4+EpWnoiR+bUz486vcuAO" +
       "Vfs89iMKJikJ/Lwx+0le5dG9gwpH7l39Ev6qn/P7Y0X8x93Enx0TPufTiLxF" +
       "w4MXYTvQQOzeskk/wZrA0GmGnvfKjH3DrpvFDCUiScNF5m3vzzPCF7o62a8+" +
       "Nyl/mD1rybOHJx/i32RP+5NOLsRje5evuPqPc9kPOvahNnDLFti0sIYUsFAR" +
       "cYBfqDwr7WqptfKXTX134ONFZzu/SQhNsRAXe05X4jr/a0K/seD5WeomZSPZ" +
       "etO3thd/gmLaQIo0a5XZadnwA9FFSuqLcbBWK+43z2B68w+68BT/F/qFZcWX" +
       "oiMb7lxZU/CvyzN/twIRHvxvj+2yXwRcAAA=");
    
    public Ship(final jif.lang.Label jif$L) {
        super();
        this.jif$battleships_Ship_L = jif$L;
    }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Label jif$L,
                                         final Object o) {
        if (o instanceof Ship) {
            Ship c = (Ship) o;
            return jif.lang.LabelUtil.singleton().equivalentTo(
                                                    c.jif$battleships_Ship_L,
                                                    jif$L);
        }
        return false;
    }
    
    public static Ship jif$cast$battleships_Ship(final jif.lang.Label jif$L,
                                                 final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$L, o)) return (Ship) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Label jif$battleships_Ship_L;
    private jif.lang.Label jif$jif_lang_JifObject_L;
    
    public final jif.lang.Label jif$getjif_lang_JifObject_L() {
        if (this.jif$jif_lang_JifObject_L == null)
            this.jif$jif_lang_JifObject_L = this.jif$battleships_Ship_L;
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
    public static final long jlc$SourceLastModified$jl = 1492411779151L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAOW8a6wsW3oQ1ufcmTtPz8t4PB7P4zC+NneomVvV9eiq8sVR" +
       "uqqrurq6uh5dXdXV5Wuu613V9X53lT0JAYGtWDHIjB1QsEGKExE0YIEEQQEU" +
       "SxEPB4uQCAERSUycRCQCI/gBKFICqe69z+Oee+4ZjyAxIluqtdZe61trfetb" +
       "33PrW/sbvzZ7f13NHhV5MgRJ3rzRDIVXvyFbVe25dGLV9WHqeNv5aQD8+n/4" +
       "2z/xp16ZfdycfTzK1MZqIofOs8a7NObso6mX2l5VL13Xc83ZJzPPc1Wviqwk" +
       "GifAPDNnn6qjILOatvLqvVfnSXcF/FTdFl512/NxpzD7qJNndVO1TpNXdTP7" +
       "hHC2OgtsmygBhahu3hRmr/qRl7h1Oft3Zg+E2fv9xAomwE8Lj08B3lYE2Wv/" +
       "BP7haEKz8i3HezzlfXGUuc3si8/PeHLi17YTwDT1A6nXhPmTrd6XWVPH7FN3" +
       "KCVWFoBqU0VZMIG+P2+nXZrZZ99z0Qnog4XlxFbgvd3MPvM8nHw3NEF96EaW" +
       "65Rm9h3Pg91WulSzzz53Z8/c1q+Jv+0nfyTjsoc3nF3PSa74v3+a9IXnJu09" +
       "36u8zPHuJn70two/Y336L/z4w9lsAv6O54DvYP7zH/3H//ZXvvCLf+UO5rtf" +
       "ACPZZ89p3nZ+3v7Yf/s5+svkK1c0PljkdXRlhXec/Har8v3Im5di4sVPP1nx" +
       "OvjG48Ff3P+l0+/4Y97ffzj78Gb2qpMnbTpx1SedPC2ixKvWXuZVVuO5m9mH" +
       "vMylb+Ob2QemthBl3l2v5Pu112xm70tuXa/mt98nEvnTElcSvW9qR5mfP24X" +
       "VhPe2pdiNpt9YPpmn5y+j85mD8739Q83M2/1/W9ptVex0yr1W6vcaVMva+q3" +
       "tCx6qwm9OqrfitIi8a69N2l4y7aaZoINo6J+i3rafsRv2LfqynnHuDqVb5wj" +
       "v/j/aqPL9cTf1j94MF3G555XDMkkRVyeuF71tvP1lmL+8Z94+68+fCIa97Sa" +
       "hPaZhd+4Ljx78OC24G+6Ss7dzU73Ek/yPon0R7+s/hD/wz/+pVcmlir6902U" +
       "vYK+9jyDP1ULm6llTVz7tvPxH/vf/+kv/MzX8qes3sxee5cEvnvmVYK+9Pzh" +
       "qtzx3ElDPV3+tz6y/vTbf+Frrz28ssOHJsXUWBPrTFL+hef3eIckvflYK10J" +
       "8lCYfcTPq9RKrkOPVcmHm7DK+6c9N6p/5Nb+2L+Yfh5M3z+/flemu3Zc60n1" +
       "0PcM/+gJxzezTv7V3/NT3///KnNMFz941ZU9vn+OEl+B0a/CRHHHKddbfY6S" +
       "N837A2rxs3/7r/0fyMMrBR4r6Y8/o81Vr3nzGcVwXeyjNxXwyadMcqg8b4L7" +
       "H/+A/Pt/+td+7AdvHDJBfM+LNnztWl7pY010yavf/VfK//5X/qef/xsPn3JV" +
       "M3u1aO0kcm6Yf25a6PuebjXpjGTSWxMm9WtaluZu5EeWnXhXDv2/Pv698z/9" +
       "D37yE3dslkw9d5dWzb7yzRd42v9d1Ox3/NXf/s++cFvmgXO1WU/J8RTsThF+" +
       "+9OVl1VlDVc8Lv/ef/f5P/iXrZ+dVOqkxupo9G6a6cG90FyR+lQz+9h0TW9c" +
       "rdMbgmV7ye2wX7kN/pZbCVx56TZldhuDrsV3X25j33Hr/2j9blvBXo3uU9Ew" +
       "wW/8oc/S/9bfv53lqWhc1/js5d2aQ7eekVr4j6X/5OGXXv2LD2cfMGefuNl7" +
       "K2t0K2mvl21OFrum7zuF2be9Y/yd1vfO1Lz5RPQ/97xYPrPt80L5VGNN7Sv0" +
       "tf2BZ+VwIsSHr0T60p3ef4je15+7jn6iuJafvDyY3RqL25Qv3sovXYvvfYbA" +
       "n2tmr0xs/vh+Pv2sdqTzvHKjyTXy7qTpWsLv3P8z0/fpad9/974uX7D/D3yT" +
       "/V9NvCxowhfcq1xF6SSA3b0P4P341//9f/HGT3794TOO0ve8y1d5ds6ds3Tb" +
       "6MO33S7TLr/5ZbvcZrB/7xe+9uf+6Nd+7M6R+NQ7zT6Ttekf/5v/9y+/8Qf+" +
       "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" +
       "J3gTRayoEMtO4XYNkJtKwSOjkWPH1eRM");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "YEscfwEjBN7LwOSACPX+7GFe107hrEPGstRZoZitBLaJoHpyzGt2uXdOlF+u" +
       "+go/lkXjb42DMUdQSWTNsQVVJRTr/dLwoMlVOVegBW2n6G2FHb08NVXZ9BoJ" +
       "aUIXDFLBUjY5ZGGGablZvyRZVm1LwbGp4xZAkRGmFkQPLAjqALJgyZrO0cij" +
       "nY0nF1MDpyBiFMGm3+y57tKdAXgw+r2zXC5/4MqG3j3Tfvu7mPa1+Xuw7V3e" +
       "UfjifKCHzewDRRV191lg+uNEoE9fV3wmW+ztay7t28J19KvvtUX64i0eXJvx" +
       "5Umq1O3nmtL84L794C7D9G+/O8P00eu/MQmmX/7+R2Vr1VHZ5o33+j19Hk0g" +
       "P2Kl9tduOUt3rVua4615Hb1ew9vXwbf5yL9PRhfe/HJRNLPPvNfwSyl6l7j3" +
       "xWuRf1P6/Z1/g+i3Wd2n09qJ95iE3/0SiJdS8fKtUPFv/RtERc6qw2cp+J3v" +
       "MfpS6n3t/688eMjvUhzfmwffCfGUis8w3Pe8k2Sv3j/eePu+Pj2TIfpMFvST" +
       "hOpPPUmofqIyrjmun3+vJzi3/Naf/51f/zlX+k/mD++zStlm9qEmL76aeJ2X" +
       "PLPLx6aVvvjcSrvbs6OnCdP/2e4bv7T+PuenHs5eeZLr/K7XS++c9OY7M5w/" +
       "XHlNW2WHd+Q5f9cTsnzkShZu+r44m73yJ+/r5tnE2aeM+RxFb3mzH76fUt/X" +
       "6fMUfZp5/srTDNg3r8XqWoi39X/qJUnqX78W/8HkJz7Dca9dzeFrTzH7iXee" +
       "57dM3+sTgj96X//wt3ae65S37+t3cchTJB/eWfAn5/nqben/6CVH+dlr8TPN" +
       "9RlT51U3EPFF+H/v9P22iVvR+/qz3xr+1ynfdV9/+3vj/+Cpe/Btt1V//iWo" +
       "/6fX4g8392/q6kkQ3hv9z0+fOOmnn76vf9e3hv51yu+8r3/0vdF/Frs//pKx" +
       "X7gWf7SZfbDJn+ZMGy/C+7PT99Zs9sFfua//+reG93XKf3Nf/9KvD+8/85Kx" +
       "P3st/uSEdzgZCjp3b+K7ei9292azD/35+/qPfGt4X6f84fv6D/662P2rj/Xj" +
       "dzzRj8/6A7c9/8uXHO2/uhb/xSQH3mQikvdmpC9M3zC1/+l9/b98awe7TvnV" +
       "+/p/+HXJwS/eVv2vX4L6L1+Lv/hS1D94Bb4+F3zOOP/Zf92Nc5dH7s0GR1nU" +
       "vP7lRz/y6Ad/SH30tcnyPk/sb+aJXEf/elG8hI5/4yVjf/Na/LWJ8x/j8sLX" +
       "BVdsn6P8xx5rn3dS/sF//K8r5e9egTy6e5v26P5lye0KHlvz3H/9B29PRH4d" +
       "rpPwlUf3oFZnPQ97573cAec/xE63G/mPXs8fRU82enQ1qtdbv9aPnEc/8Oj1" +
       "W0/+5qM7H+LRO5+Xadf3OvWkUBOvybPXv/zGJBITIyUTrQ75684bLw5hv3LD" +
       "9Mtvfu1+TX+SIu/N55nsXXHytfl910K7f8L3zZXTMw9c7l2368D//BLG+9+u" +
       "xd+5e0f3zA28S8gfP8v8zGMWe9xxHf38v7qTXItfvUH9g5dg/Q+vxd9rZt91" +
       "xdqx6uZdVH+KznMH+E3/UgfQX3iAZ1H7Jy8Z+2fX4h/d+/SB17xndP4bgfg/" +
       "f++xB7e9/s9m9oXnEX9BTPwbgPuDD7xk7EPX4uH1KddzuD8Xjf5G4P2Jl4x9" +
       "6lp85AU0f0EMeJmMw5Xrr29pP/Ouf3Bx928YnD/xcx//4Hf+nPa3bg+8n/yr" +
       "hFeF2Qf9NkmefSH6TPvVovL86HaQV+/ei94O/+DTzewjz8jctes7izvh/X8A" +
       "h7tFI2lDAAA=");
}
