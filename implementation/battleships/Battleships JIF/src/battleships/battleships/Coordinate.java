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
    public static final long jlc$SourceLastModified$jif = 1492411767134L;
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
    public static final long jlc$SourceLastModified$jl = 1492411767134L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAOV7e+zs2FnY3LvZTbIJyW4gEPK8JEvYxbvrGXs8trMNre3x" +
       "jO0Zz4zfHmfJ4rc94/drbEMQVILQIqWIhpdaUCulVUEptKiICorKP1BQUNUi" +
       "BKUVBSHUh2jUIrVUfUE98/vd+7t79+4lUUtBdCSfc+Z83znnO9/5Xkf+/NnP" +
       "jx4vi9GdLI06P0qrF6suc8sXd2ZRug4VmWUpDx2v2N8DgJ/+vo8/9eOPjd5u" +
       "jN4eJlJlVqFNpUnltpUxemvsxpZblITjuI4xejpxXUdyi9CMwn5ATBNj9I4y" +
       "9BOzqgu3FN0yjZoz4jvKOnOLy5p3O9ejt9ppUlZFbVdpUVajp9YHszHBugoj" +
       "cB2W1Uvr0RNe6EZOmY++eXRrPXrci0x/QPzy9d1dgJcZwcW5f0B/MhzILDzT" +
       "du8OecMxTJxq9IEHR9zb8TOrAWEY+sbYrYL03lJvSMyhY/SOK5IiM/FBqSrC" +
       "xB9QH0/rYZVq9O7XnXRAelNm2kfTd1+pRu96EG93BRqw3nxhy3lINXrng2iX" +
       "mdpi9O4Hzuy+0/r85s996hsTJrl9odlx7ehM/+PDoPc/MEh0PbdwE9u9GvjW" +
       "r11/r/nlP/Mdt0ejAfmdDyBf4fzkN/3eX3j+/T/7C1c473kIztY6uHb1iv0Z" +
       "623//L3Uc/hjZzLelKVleBaFV+38cqq7a8hLbTbI4pffm/EMfPEu8GfFn99/" +
       "y4+4v3t79CQ7esJOozoepOppO42zMHKLpZu4hVm5Djt6s5s41AXOjt44tNdh" +
       "4l71bj2vdCt29Ibo0vVEevk/sMgbpjiz6A1DO0y89G47M6vg0m6z0fXvqeF5" +
       "y2h0S7uul9XoOP/Iy0rpFothlvLleWrXsZtU5ctKEr5cBW4Zli+HcRa5596L" +
       "NrxsmVU14AZhVr5M3rTvcOzi5bKwXwWn0rRwwkF13BcPoZf9v12uPe/+S063" +
       "bg0H894HjUQ0aBSTRo5bvGJ/uibp3/vRVz53+56aXPNt0Mv7pn/xZvrRrVuX" +
       "ab/srEtXZz2c1HGwAIOSv/U56eu5b/iODz42CFl2esPA6zPqMw+K/I2hYIeW" +
       "OcjxK/bbP/nvfv/HvvcT6Y3wV6NnXqOTrx151qkPPrjFIrVdZ7BZN9N/7R3z" +
       "J175mU88c/ssIG8eTFVlDsI06P37H1zjVbr10l07dWbL7fXoLV5axGZ0Bt01" +
       "Lk9WQZGebnouvH/Lpf22Pxx+t4bnD87PWQzPHed6MEbUtQrcuacD1ajZ/fa3" +
       "f/dH/lgFZTj+zi3OQvKRyRR7Hpq+AGHZlbycT/UBTl5s8Uel7Af/xT/99/Dt" +
       "Mwfumu2332ffJbd66T5TcZ7srRej8PSNkMiF6w54v/H9u7/6PZ//5McuEjJg" +
       "fOhhCz5zLs/8MQe+pMW3/UL+67/5rz/zK7dvpKoaPZHVVhTaF8rfO0z04Zul" +
       "BisSDZZsoKR8Rkni1Am90LQi9yyh//PtXz35if/wqaeuxCwaeq4OrRg9/0dP" +
       "cNP/leToWz738f/6/ss0t+yzF7thxw3alWn80puZiaIwuzMd7bf+8vt+4J+Y" +
       "PzgY2cGwlWHvXmzVrWulORP1jmr0tuGYXjz7qxfXpuVGl80+fwF+zaUEzrJ0" +
       "GTK6wMbn4j3tBfbOS/+T5Wu9x+Lshm9UwwA/+9ffTX3d7172cqMa5zne3b7W" +
       "fqjmfVoL/Uj8X25/8Imfuz16ozF66hIBmEmlmlF9Pmxj8OEldd25Hn3Jq+Cv" +
       "9sdXzuele6r/3gfV8r5lH1TKG7s1tM/Y5/Yb79fDgRFPn5n07uF5+8Dfn7qu" +
       "//4Z+lR2Lp9ub40ujdllyAcu5QfPxVdfncm5+eErcasGgXkIX3dFGA8K0Fx7" +
       "Zfc7Pv2X//DFT3369n2hy4deEz3cP+YqfLms8eRlofMqX/WoVS4jFv/2xz7x" +
       "03/nE5+8cu3veLUjppM6/ru/+r9+6cXv/61ffIiVf2wIsq6U/1xCr2XXlw5b" +
       "/2/X9X96CLvIL4hd3bnx0fsWutrerUGRH4dfRF68CO7y4VM9dplq0PjyEr0O" +
       "I7zBE0V35/6KQ2Q/c9eYqkM0O+jdM4Pe3NWhpy7ad1Giq6DvIVQMbH7bDdo6" +
       "HSLD7/yd7/qlv/Kh3xxYxo0eb84CO/D2vrk29Tl0/vbPfs/73vLp3/rOi2ka" +
       "dv2x/rP7j59n3Z0Ldggrz9RJaV3Y7tosK/5iS1znHoEvXZ/zufq6arBI6UMJ" +
       "rN7zW8y0ZIm7P36MUbCvToyo5zo6IJRoGkzcKUfQnBBOyVbjaH8vEjNC6yhz" +
       "vhS4nk+Mkpe3CG/UVuxbq3URKOuFhUveklqYgYuGkVg5sxhtIrPVdTKboYVV" +
       "TOYooB5sKz6qhYmYoNpOehDweABAopPY6hawszsj6RvAA8G+AZEOYQ7FfC4v" +
       "xlaZxls1ivC4lhRLleTDflWHdLSMtMjrxoYZ8GDTgElo1c1YRQ+1ddKsPCgL" +
       "ujSEaLWyTyoF1a3iOEm5QZMQoMxAnIaRrMZcq+nzgo3601iYGEY4Y1cOnyIN" +
       "KnVTCZlmER+ujvLieMoUCS8S04DX0lQMrFxZCD3XaAavwEJgTvfHgCuKhUKf" +
       "OmqPJXNFOHDKGFfcrcRk3MGeyH6QlK0W6CoXHtzWYXazfOZskZzVXHSP1/MD" +
       "I8POpFW0fqeL9dpD+vnCUk+ivsohUeQ1s1WVzgyyqWLBoTqplHpWSpJ4JNkK" +
       "5kOFozSTU8fagjmuYzOMtSIQg6oT6bIbr4Noc8zpfCeTbcQxGsXGp+yg7JGp" +
       "IUe5uFBwrUJdITKUiNMYbCNJGRVAi27adtB4C6un/hCI0iLIZkJCqstOYFi4" +
       "mx1pjGeZvQu007o6Ej6zQZEV22y7yI54aumSS8U+ZkKeHiZxn9t5PpdJKMyO" +
       "Ex/jJV5aVgTNrqaaGwrQsavbOdAcrWlYnnKBFsjQjnf4uCXko8PRCSLa2CHu" +
       "gYZzJjNHy5jwuJWWHFURYERQKpBSZraSjlIXiWk6nxuY3iz4Pe5Jzc7W5E7b" +
       "4Mdt7bVLHHF262YMaZtxn0vCVmvMzTgOIWnvmiTYjmvZ7FIFUQlVFU5W4MLm" +
       "tqtAFq7ksWlLp7Y67qeapuLe2sgSADCqipwpkLuCeh87iqqk2+JOTLM8gsyC" +
       "Pszs8BjNNCKcqx0Z0YUybcrlOsOwFtAUkfZ0jtsujblxqoV0i5jJdAMtxGNO" +
       "EItak40+VtXVJJFlAsWsaDfFA7B1ZY9nZ2ud12eIZMK1O+smibbMNra8po0i" +
       "kfK47sTwtIILJVkVkHQ0yorOHShekattCs7gyo9jqTagziiE2jFmh1Xb5Npp" +
       "4uDrrlFVBWfFzeFo5iyiFWCFNZOTO1u7HS+y2YHzCten2cpMpYJ2LIlzcW4d" +
       "oTAqbaoWPuzl9uCEUYeOVQGZrQOOrJY7IsrDMjQFiEbKpEnIqeFtl5HjDYdo" +
       "zCO6L3pJw4I8ipgMt2Z9uCQbSWQrZuuhuFRDqM4ZfI2gx2Bti/AyUSXl6BdG" +
       "vKuUg+awByQ+zGGFIxn4OF4lCyCbYr0i7pW29ngyUiKHOzECQ+3JDRsY4tTy" +
       "1vx8ta4yEMA2NFrN8m1gZLZoky1JMSTGN5hdkaqipIIK5H7SKuq8sPHG0igE" +
       "XnGbboHyWLI9zWMVqLzTliXMDkkoPTUFVFLVRqmEKacvImXVKxMHTQbVOpLM" +
       "dMdxJsl7Gw4ElzZ5AgNQnU+3k3TupK26WhDoGnHS9cadrPpqCybrHdYnWwdt" +
       "Z2Ot3m6OZSwrtX5as2FFFgdGGpurcS1psruCbdir3S2P140oKiGPFfNF3hFV" +
       "Zk3pwS5QRg3aZo9uZgDu1qTerDYQ58fRTDcWi6YpZZudqpgPReMG7ZZuLRtr" +
       "1TgcxvQCONIMznZzJZ/k2mzCSnbEqpAosDiIAOGgggyMZ6q8UwlW2ip5n8IA" +
       "cGKTHc1JaFS1vQfUoiyKtMQGArpLloly2iMQT4GiY9LebBuimAPE6Hyco9S2" +
       "jouAEfBpmNre4SjYGCEWTUwieY1I/tilSPKE4cphh6WCI+x9NWUk0TktJjyb" +
       "shS1bRohk3FS3lvtibaynobkmMNLtdK7dSonuiIOtgIhTlFKtwA2XXpMj8gK" +
       "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" +
       "ENuJrmX9IFybsbV1kXjJjBMQx7lOXiQ7");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "Dwmva/v1N3Q/qZ96BOy7zsVfqkZvqtKbRKbNw+h+9xXttz93Xf+jL47u85Cf" +
       "vq5/4guj+/seAfuBc/HdA93BYJGo1LkI0EcfRvfXDM9XjUaPvXBdP/3F0X0e" +
       "8tR1/eQXJEAv3NXQd97T0Pv9zmXNv/GIrX3mXPy1avSEOxijqHxYRtcbrTSN" +
       "XDN52H7fPzzPDRv46HX9tV/cfs9DnruuP/T6+711E6P9zcusP/qIHf29c/HD" +
       "93Z0/ve3HyD9TWfkp1/rHH7yT7lzaNLQufiAMAmrZ5+78413Pvb10p1PDJb/" +
       "QV7/UY7wDP0HWfYINv7DR8B+6lz8+KAPd2l5aCLgmdoHGP+2uzbp1Yy/9VN/" +
       "Shl/la955ypR+861HlxO4K6TSb1nP3ZJ5vwCPPf6+TvXqGZjPoh75VSvkNOv" +
       "XwyHG3p3nk3vhPcWunNj8M9Hf/Pvjn3no3eevQ+avnTnytndeXX2tXJOpy0H" +
       "uxu5VZo8+9yLg4oMkhUNzJPTZ+0XH3Wrev6yg+de+sT1zN6gW+5LD8reay5w" +
       "5+aHz8XqvuDi0ZbsvhTV60jjDPi5R8jjL56Lf3yVbH7fybxG9e9+u/Cuu5J3" +
       "t+MMfd//vZ2ci5+/YP2zR1D9y+fic0MYc6baNsvqdXh/Q9QD2/iy/6NtrB+6" +
       "jfsJ/PVHwP7VufiV64DTd6vXvTf+SRD+24+A/c65+I1q9P4HCX/Ide1Pgvbf" +
       "fQTs8+fi35xTsh+g/YGb0p8E3f/5EbDfPxf/8SE8f8gFpa1GT97I/vnjk3e9" +
       "5hvRqy8Z7R/9obe/6St+SPm1yxdR9742fGI9epNXR9H9n1Tc134iK1wvvJD1" +
       "xNUHFlcs+O/V6C336d+5639kV4r8vwGkA8tMrDoAAA==");
}
