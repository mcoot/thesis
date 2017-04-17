package battleships;

import jif.util.List;
import jif.util.LinkedList;
import jif.util.Iterator;
import jif.util.NoSuchElementException;

/**
 * This class represents a board in the BattleShip game.
 *
 * A Board is a collection of ships that do not intersect with each other.
 *
 * It is parameterized by the label L, which is the level of
 * information that the board contains, and must be the same as the
 * level of information the Ships contain.  
 */
class Board {
    private List ships;
    
    public Board battleships$Board$() {
        this.jif$init();
        {
            this.ships =
              new LinkedList(this.jif$battleships_Board_L).jif$util$LinkedList$(
                                                             );
        }
        return this;
    }
    
    /**
     * @throws IllegalArgumentException if the ship to add intersects a ship
     *   already on the board.
     */
    public void addShip(final Ship s) throws IllegalArgumentException {
        List shps = this.ships;
        if (s != null && shps != null) {
            try {
                for (Iterator iter = shps.iterator();
                     iter != null && iter.hasNext(); ) {
                    Ship t =
                      Ship.jif$cast$battleships_Ship(
                             this.jif$battleships_Board_L, iter.next());
                    if (s.intersects(t)) {
                        throw new IllegalArgumentException(
                                "Ship to add " +
                                  "intersects an existing ship.");
                    }
                }
                shps.add(s);
            }
            catch (final ClassCastException impossible) {  }
            catch (final NoSuchElementException impossible) {  }
        }
    }
    
    /**
     * Test if a ship occupies the coordinate coord
     */
    public boolean testPosition(final Coordinate coord,
                                final jif.lang.Label lbl) {
        List shps = this.ships;
        if (shps != null) {
            int sz = shps.size();
            for (int i = 0; i < sz; i++) {
                try {
                    Ship s =
                      Ship.jif$cast$battleships_Ship(
                             this.jif$battleships_Board_L, shps.get(i));
                    if (s != null && s.covers(coord, lbl)) { return true; }
                }
                catch (final IndexOutOfBoundsException impossible) {  }
                catch (final ClassCastException impossible) {  }
            }
        }
        return false;
    }
    
    /**
     * Return a new board that has the endorsement of the principal o.
     * The label L is required to be equivalent to {p->*; p<-*}.
     */
    public Board endorseBoard(final jif.lang.Principal p,
                              final jif.lang.Principal o) {
        Board
          newBoard =
          new Board(
            jif.lang.LabelUtil.
                singleton().
                toLabel(
                  jif.lang.LabelUtil.singleton().
                      readerPolicy(p, jif.lang.PrincipalUtil.topPrincipal()),
                  jif.lang.LabelUtil.
                      singleton().
                      writerPolicy(
                        p,
                        jif.lang.PrincipalUtil.
                            topPrincipal()).
                      meet(
                        jif.lang.LabelUtil.
                            singleton().writerPolicy(
                                          o,
                                          jif.lang.PrincipalUtil.topPrincipal(
                                                                   )), true))).
          battleships$Board$();
        List shps = this.ships;
        int sz = shps == null ? 0 : shps.size();
        for (int i = 0; i < sz; i++) {
            Ship s = null;
            try {
                s =
                  Ship.
                    jif$cast$battleships_Ship(
                      jif.lang.LabelUtil.
                          singleton().
                          toLabel(
                            jif.lang.LabelUtil.
                                singleton().
                                readerPolicy(
                                  p, jif.lang.PrincipalUtil.topPrincipal()),
                            jif.lang.LabelUtil.singleton().
                                writerPolicy(
                                  p, jif.lang.PrincipalUtil.topPrincipal())),
                      shps == null ? null : shps.get(i));
            }
            catch (final IndexOutOfBoundsException impossible) {  }
            catch (final ClassCastException impossible) {  }
            Ship ss = s;
            if (ss != null) {
                Coordinate pos = ss.pos;
                if (pos != null) {
                    int posX = pos.x;
                    int posY = pos.y;
                    Coordinate
                      c =
                      new Coordinate(
                        jif.lang.LabelUtil.
                            singleton().
                            toLabel(
                              jif.lang.LabelUtil.singleton().
                                  readerPolicy(
                                    p, jif.lang.PrincipalUtil.topPrincipal()),
                              jif.lang.LabelUtil.
                                  singleton().
                                  writerPolicy(
                                    p,
                                    jif.lang.PrincipalUtil.
                                        topPrincipal()).
                                  meet(
                                    jif.lang.LabelUtil.
                                        singleton().
                                        writerPolicy(
                                          o,
                                          jif.lang.PrincipalUtil.topPrincipal(
                                                                   )), true))).
                      battleships$Coordinate$(posX, posY);
                    int length = ss.length;
                    boolean isHoriz = ss.isHorizontal;
                    Ship
                      t =
                      new Ship(
                        jif.lang.LabelUtil.
                            singleton().
                            toLabel(
                              jif.lang.LabelUtil.singleton().
                                  readerPolicy(
                                    p, jif.lang.PrincipalUtil.topPrincipal()),
                              jif.lang.LabelUtil.
                                  singleton().
                                  writerPolicy(
                                    p,
                                    jif.lang.PrincipalUtil.
                                        topPrincipal()).
                                  meet(
                                    jif.lang.LabelUtil.
                                        singleton().
                                        writerPolicy(
                                          o,
                                          jif.lang.PrincipalUtil.topPrincipal(
                                                                   )), true))).
                      battleships$Ship$(c, length, isHoriz);
                    try { { newBoard.addShip(t); } }
                    catch (final IllegalArgumentException impossible) {  }
                }
            }
        }
        return newBoard;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1492411763599L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "6TJEPO70+CQi0ER3o1KO7JPxaaULvhrB");
    public static final String jlc$ClassType$jif$1 =
      ("p7jgbTkyQManNcF8LjYDLruezwGSDM/CX+n14VdlTaKcjVztMu9aJGTW6THv" +
       "RgSqcdfcnDVFcda82QW/BcHrXPBtWbMEh3l3eEP+2ExOyL/GDXnWOGGvHfcA" +
       "0IU5VMrl5f1I3FKXuFwxEdtbMCiKLXPBcwVFDByjor3eDYRoT5wG7S1nRvvK" +
       "06cdvkMZPYwbgKJI9Pmc4RbMeIlhzrqhQHTF/BgFPto14KMeFcKdpT18PUb5" +
       "uq4TM3PcPSn/iziuPL2TchKBNrq0v50jUmEsfdcFfx/Br3XBP8gRLbCT8lfq" +
       "+4m/y0O/BXlEaejHI+kPHkoP3dW7cNBdTUfxO4TOjxIWsZ908P5ehuc6Xzfk" +
       "lILLFNFAHOON2GZLKPakoDB0E7VS8DUh94El/Q2PDH02V+p9xM/3GVv9v4YB" +
       "31xtp7+pmZD+NHVKzb5DYw6yH87J+jMBLsTuuxYsuuK9GfT3M/JI4rx+PSxa" +
       "WC8U0FAAaYAf/xqZFZuNK3/++I97PVw02vfDUX0977/4dlfqPkLcxX3B1/ej" +
       "nwlptbDhGz/d1PdqQmkzSZXNpUa7acHPbxZJ9jeAAdc36bt49JdsYv9OEI8N" +
       "/n6QB603Z4ysunNxfcFnl+R+zQ4JLvkHvcmCfWJVAAA=");
    
    public Board(final jif.lang.Label jif$L) {
        super();
        this.jif$battleships_Board_L = jif$L;
    }
    
    public void jif$invokeDefConstructor() { this.battleships$Board$(); }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Label jif$L,
                                         final Object o) {
        if (o instanceof Board) {
            Board c = (Board) o;
            return jif.lang.LabelUtil.singleton().equivalentTo(
                                                    c.jif$battleships_Board_L,
                                                    jif$L);
        }
        return false;
    }
    
    public static Board jif$cast$battleships_Board(final jif.lang.Label jif$L,
                                                   final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$L, o)) return (Board) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Label jif$battleships_Board_L;
    public static final String jlc$CompilerVersion$jl = "2.7.1";
    public static final long jlc$SourceLastModified$jl = 1492411763599L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAM17acws2XXQN8/2jGM73pI4TrDjhz2Yccqe6q6lq9omiK59" +
       "7a6q7qrqqjgZat+Xrq2rK5hNQKxEJChxQkAkQmAQBCeRgChCKCg/CBAFsQkF" +
       "EEsihAQI8iMSi5DYqvt7b96bN88DkQjKJ/W999177rnnnu2e83TqK7969462" +
       "uXtYV/klyqvu1e5SB+2ritO0gU/mTtse5onXvB8CwC/98e98/19+29377Lv3" +
       "JeW+c7rEI6uyC8bOvntPERRu0LQb3w98++4DZRD4+6BJnDyZZsCqtO8+2CZR" +
       "6XR9E7Ra0Fb5cAX8YNvXQXM78/GkdPceryrbrum9rmra7u79UuoMDth3SQ5K" +
       "Sdt9Trp7MUyC3G9Pd7/37gXp7h1h7kQz4Iekx7cAbxhB5jo/g78rmclsQscL" +
       "Hm95e5aUfnf3sWd3vH7jl8UZYN76UhF0cfX6UW8vnXni7oP3JOVOGYH7rknK" +
       "aAZ9R9XPp3R33/xVkc5A76wdL3Oi4LXu7sPPwin3SzPU19zYct3S3X3Ds2A3" +
       "TGNz983PyOwpaf3q9nd833eVXPngRrMfePmV/nfMm77lmU1aEAZNUHrB/cb3" +
       "fKv0w86HfvaLD+7uZuBveAb4HuZnfs+v/a5Pf8vP/Z17mN/yHJidmwZe95r3" +
       "Zfe9//Aj5KfWb7uS8c66apOrKrzh5jepKo9WPjfWsy5+6HWM18VXHy/+nPa3" +
       "rN//48F/eHD3Lv7uRa/K+2LWqg94VVEnedCwQRk0Thf4/N3XBKVP3tb5u5fm" +
       "sZSUwf3sLgzboOPv3p7fpl6sbv+eWRTOKK4sevs8TsqwejyunS6+jcf67tHf" +
       "u+ffB+7uXvilR/0vdnch9dnP623QMDOW9vNU5fVFUHbt5/Uy+XwXB23Sfj4p" +
       "6jy4zt6s4fOu03UzbJzU7eeJJ+OHAs98vm28N65XTuO/miZh/f/tpPF65689" +
       "v/DCLI6PPOsa8tmOuCr3g+Y170s9Qf/aT772iw9eN45H3OruPvAU5ldvmO9e" +
       "eOGG8euvxnMv3Fk02Wzys1W/51P77xB+9xc//rZZq+rz22fmXkFfflbHn3gG" +
       "fh45s+K+5r3vu//df/mpH/5C9UTbu7uX32SEb955NaKPP3u7pvICf3ZST9B/" +
       "60Pnp1/72S+8/OCqEV8z+6bOmbVnNvRvefaMNxjT5x47pitHHkh37w6rpnDy" +
       "69Jjb/KuLm6q85OZG9vffRu/93/Nfy/Mv/95/V317jpx7WfvQz7S+YevK313" +
       "Nyj/+o/8wGd/Q9VjlvwlaK768dklgn8aQj4D4fW9qlyl+gwnb8732/b1j/7T" +
       "v/fv4QdXDjz20+97yqHvg+5zT/mGK7L33LzAB54oyaEJghnuX/6I8oM/9Kvf" +
       "/e03DZkhPvG8A1++tlf+ODNfquYP/53TP/vlf/Xlf/zgiVZ1dy/WvZsn3o3y" +
       "j8yIPvnkqNlt5LPrmilpX9bLovKTMHHcPLhq6H9/329b/vR//L7336tZPs/c" +
       "C625+/T/GcGT+W8i7n7/L37nf/2WG5oXvOuz9YQdT8DufeHXPcG8aRrncqVj" +
       "/AP/6KN/4m87Pzp71dmTtckU3JzTC4+M5krUB7u7985ievX6QL0qOW6Q3y77" +
       "6dvib7+1wFWXblvubmuLa/NbxtvaN9zmX2zf/Fww13f3iWnY4Ff+1DeTv/M/" +
       "3O7yxDSuOL55fLPrMJynrBb68eI/P/j4iz//4O4l++79tyffKTvDyfursO35" +
       "0W7JR5PS3de+Yf2ND/D9a/O5103/I8+a5VPHPmuUT1zWPL5CX8cvPW2HMyM+" +
       "eGXSJ+8HD95537/wn66r76+v7QfGF+5ug9Vty8du7cevzW97rHIv1U0yzIZ6" +
       "r3PdHHNdLeqxrL72KqtH/vBeq772tgTdoMcXZgTvgF9FX73J6Hc+/5C3XYef" +
       "nJW7vUVm844wKZ388YHfmObey4/9hjFHarOKvTwf+5iE998U7aYv9wHNc6iY" +
       "9eG9T8Ckao56vvff/LG/+/2f+OVZ/sLdO4arbGaxP4Vr21/Dwj/ylR/66Lu/" +
       "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" +
       "28m1V6R9WchmxaQZFqWh2FLnOVQvSaAP");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "QVqe87pzqZidQH+p+Ce1yKa9fdzWuoM5Hqe4oy2s02D2RB68cjtkLfitNax3" +
       "NI9vwXKlEqsFbCOXti+3Y+gxZQ5owKQigjRk3OAVZDhnzJvN5tuu6mg8Ut6v" +
       "e5Pyvrz8Kup7Xy9lPb+U6cF1+NlrQz4pX5qRPVWL+NqtoPQ16br8mRv68fm4" +
       "7h5V+T0pa7u7Fvt89KvVTt8Kfb78B7/0Y/7uzy0fPNqudHdf01X1Z/JgCPKn" +
       "UL1zxvSxZzDJt3rxJ2Vuf1H+yi+wn/R+4MHd216vUHtT2fkbN33ujXVp72qC" +
       "rp/d/Ruq077p9eq0az3yrUTt62fOfeRR/w1PV6c9Yf/Hrs0nXt96Y8e7Hm35" +
       "+kf9e5/a+hb1gtlbrBXXJuzuPviUxF6+SezlJ7T4b7zBN86/mfoH/+JR/w9+" +
       "fTe4bvn7j/pf+Oo3eKZI8v1P1yjPD+F9NWv31ps+/qS8jc/zIHLyTRPdCm3p" +
       "0Qvqa/HmDc2tqbq7lxzfv+K+7Zce1Ztdu1139/ahSvznseMz8w+5u3vHv33U" +
       "//yvjx3XLX/zUf83vjo7Htzb2+ObfehpdpBV1fhJ6XQ3rfvM7dA/9BZC/+K1" +
       "+X3d3Xu6oO0eF+0/784vuVWVB075vGtfqyx3s2H9t7nfzv2Xf33Xvm75s4/6" +
       "H/2/vvYHXy+VVZqk9JLauX0u8YO3A3/gLa78w9fmj85XDkq/atrgpuLP0/CX" +
       "Ht/thUcfEbxwX8n9z99cyf3wlfo3vJD79Tr/zy4X+Keh1Wfgxac++/DUO21y" +
       "6qsueOW+QPrhVTkfXj1vUg5VFlBB+FQV/SufevhdXZy0r77ZyF/51Oe+8Km6" +
       "/uoCu/29+Cw/rqt/sq7fguE/9hZrf/ra/Eh39+GvRvB1/fc8I5hrNe/1K45n" +
       "BfMzv1kFc19G/LRkku4qiYff/h37h88y/U2FyLeHdXyjGF56nhi+/JZi+Itv" +
       "sfaXrs2f6e7e+Zi657H9dvhH38T2F/78b1K239dUP3xkFo/8143/j9/sKnzl" +
       "228F19fZ73IK9ws3j3I/ulXg34a3PdKnHz4CnR+SZ2Hvq9nvgavvYGbRJuHD" +
       "V6qHyesHPbyRe5X5bfDQe/htD1+5n6s+9/A+WHj4xup//Vqh3CZllAddVb7y" +
       "qVeDUz8rUj5z61C94r36VaKrT9+onY35EdLQydvgTab93PDtk9eGeCr4epP3" +
       "vb0qzyk/v2fAbedfeQs9+5lr8xP33zk8JYXr7Pc8rW2PP5v58GMtezxxXf3o" +
       "/7ubXJu/eoP6G29B9c9dm792LXifqfactnsz22/0jN3dO27/un4E8uE3fZx5" +
       "/wmh95M/9r53fuOP6f/k9mXS65/5vSjdvTPs8/zpTxueGr9YN0GY3Kh58f5D" +
       "h3se/M3u7t1PEXOd+vn6/lb/G4hVseklOgAA");
}
