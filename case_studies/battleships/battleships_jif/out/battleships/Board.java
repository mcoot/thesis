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
    public static final long jlc$SourceLastModified$jif = 1501224976116L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAM08C5QUxbU9M+yP5bP8d/kOy/IV2IB8YlYjsMvyG2FlQWVF" +
       "h96eXrZhdrrp7lkGFIO+KGoQExQ/L8FgAolRnqgJmhOFIMaAD6NiPqhB4iMv" +
       "ikZM9BkTY9TUvVXTn+qa2UUSz9tztqqnuu6te2/dur/umd2npQLLlIas0lom" +
       "2usM1Zo4X2tpkE1LTTToyXVLyFBc+fDeZxN3LTN+F5YKm6RizVqasuQWNSaV" +
       "yGm7VTc1e50tlcVWye1yddrWktUxzbJrYlKpoqcs25S1lG2tka6RQjGpTCMj" +
       "csrWZFtN1Jt6my0NjxlkoZVJ3a5WM3a1IZtyWzWSUt1Qm5Qti2AqxNEskmLD" +
       "1Nu1hGra0rAYIZzNTsrNarK6gd2LwaeajClFs+gZf5Q5xEy523ZO9e13Xln2" +
       "SETq2ST11FKNtmxrSq2esgk9TVK3NrWtWTWtmYmEmmiSeqVUNdGompqc1NaT" +
       "iXqqSeptaStTsp02VWuxaunJdpjY20obhERYMzsYk7pRkaQVWzez7BS2aGoy" +
       "kf1U0JKUV1q21N8VC2WvHsaJLLoScapmi6yoWZAuq7VUAmTBQTg8Vi0gEwho" +
       "UZtK9stZqktKJgNSb7pzSTm1srrRNrXUSjK1QE/bIOCBOZHWwEbIymp5pRq3" +
       "pXJ+XgO9RWaVoCAAxJb68dMQE9mlgdwuefbn9MLzt1yVmpsKI80JVUkC/cUE" +
       "aCgHtFhtUU01pagUsNu42B1y/303hiWJTO7HTaZzHrv63Rnjhx44TOcMEsxZ" +
       "1LxKVey4srO5x9HBtWPPi1AV1C0NNt/HOSp/A7tTkzHIwervYISbE7M3Dyz+" +
       "+bKN96t/DEtd50mFip5MtxE96qXobYaWVM05ako14YjMk0rUVKIW78+Tish1" +
       "TEupdHRRS4ul2vOkLkkcKtTxMxFRC0EBIioi11qqRc9eG7LditcZQ2J/peS/" +
       "lySFfsP6I7aUmP2l5Ust1awnWKzldbqSblPJAV6+NKUtt1tVS7OWK7Klxi07" +
       "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" +
       "S105XYGIx5yZnGQEGu8yquTJPpmcVrrg");
    public static final String jlc$ClassType$jif$1 =
      ("qxF8kgvelicDZHJaw+dzkWlw2fl8DpBkRBb+aq/7viZnEuUwcq0rvOuRkBln" +
       "JrybEajOXXNzzhTFWfNWF/w2BJ/ngm/LmSU4wrvLG/JHpgtC/jVuyOOLdmD+" +
       "xXm0yRXjLqRriUtXvkiIscWHQpFlLni+UIiBw0kI/xiafV4G1gRiNkAdPwMu" +
       "ms+Oi5VnzsURZACKIuHn8oZbMONFhjQnL1x0xfwYBT7WOeBjHhVCplIexThO" +
       "RbquAzNzwj0p/4s4rj6zk3IKgTa6tL+VJ1Jh0nzHBX8Pwa93wd/PEy2wk/I3" +
       "6vuJvytAvwWPsMsDPxhJf+RQefCensUD7ll6DL876PwQYQn7KQfv72R4rgsN" +
       "U23RcJkSGohjvBHZbEulnrQGhm6hVgq+IuQ+sKS/3ZGhz+bKvY/4xT5jq/9X" +
       "MOAbq2n6O5px5c+TJ9XtPzzqEPvBnJw/D+BC7Lln/sKr3p1GfzejgCRj69fD" +
       "osUxqYiGAkgD/OjX8JzYsrgK5479qMdDJSN9PxjV2/P+i4+7cvcR4m7hC76+" +
       "H/qMK6ulDV/72abe1xJKm0hubi0x05YNP7lZomS/+Qu4vk7fxaO/YBP5T4J4" +
       "NP+7QR603pwxtOruRbGiTy/L/5odElz2T/lnlSZWVQAA");
    
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
    public static final long jlc$SourceLastModified$jl = 1501224976116L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAM17eewsW1rQ792ZeW82ZpOdGeY6PMY31MyrvaprRgnd1dXV" +
       "1VVdVd21dRcDz9qruvZ9gVE0KEQiGhgQjRCjYyI6QqISYwyGP0QhELcYlESF" +
       "GBM0yB8kLjEuWN2/e9+97747T0nE8Ev6nHPP+c53zvn2L/erL/7G3Tvq6u5h" +
       "kSdjkOTNq81YePWrslXVnksnVl2r88Rrzg8B4Of/zLd/4G+87e795t37o0xp" +
       "rCZy6DxrvKEx796beqntVfXSdT3XvPtg5nmu4lWRlUTTDJhn5t2H6ijIrKat" +
       "vPro1XnSXQE/VLeFV93OfDwp3L3XybO6qVqnyau6ufuAcLE6C2ybKAGFqG4+" +
       "I9y96Ede4tbl3R+6e0G4e4efWMEM+JXC41eAN4zg5jo/g787mq9Z+ZbjPd7y" +
       "9jjK3Obuo8/ueP3FL/MzwLz1pdRrwvz1o96eWfPE3Yfur5RYWQAqTRVlwQz6" +
       "jrydT2nuvvZLIp2B3llYTmwF3mvN3Vc/CyffL81Q77qR5bqlufuKZ8FumIbq" +
       "7muf4dlT3PoN8fd//3dk2+zB7c6u5yTX+79j3vT1z2w6er5XeZnj3W987zcJ" +
       "P2x95U9/74O7uxn4K54Bvof529/5m9/yya//mZ+7h/m658BI9sVzmtecL9jv" +
       "+6cfpj9Bve16jXcWeR1dReENL79xVX608pmhmGXxK1/HeF189fHizxz/wfm7" +
       "/qr36w/u3s3dvejkSZvOUvVBJ0+LKPEq1su8ymo8l7t7l5e59G2du3tpHgtR" +
       "5t3PSr5few139/bkNvVifvv3TCJ/RnEl0dvncZT5+eNxYTXhbTwUd4/+3jP/" +
       "Pnh398IvPep/oblzmU9/Vqu9ajNjqT+7zp029bKm/qyWRZ9tQq+O6s86Vu29" +
       "VjetG80QttU0M2QYFW8Yv3aJ/M/WlfOG9VVuVe6r80rx/+mc4freL+tfeGFm" +
       "xYefNQvJrEPbPHG96jXn8+2K+c2feO0XHryuGI8o1dx98CnMr94w373wwg3j" +
       "l18V556xM1viWd1njX7vJ5Rv2/3B7/3Y22aJKvq3z4S9gr78rHw/sQrcPLJm" +
       "oX3Nef/3/Pv/8pM//Ln8iaQ3dy+/SQHfvPOqQB979nVV7njubKCeoP+mh9ZP" +
       "vfbTn3v5wVUa3jXbpcaaJWdW8q9/9ow3KNJnHhulK0UeCHfv8fMqtZLr0mNL" +
       "8u4mrPL+ycyN7O+5jd/3W/PfC/Pvf11/V5m7Tlz72fLQj+T94esC39w18r/9" +
       "4z/w6d9B4Zj5PnrVVTo+DWOLTyLYp5BFcS8oV54+Q8eb2f0DSvGj//If/Qf0" +
       "wfX9jy30+58y5YrXfOYpq3BF9t6b/n/wiYiolefNcP/6R+Qf/KHf+J5vvcnH" +
       "DPENzzvw5Wt7pY41UyWv/tjPlb/8K//mC//8wROZau5eLFo7iZzbzT88I/r4" +
       "k6Nmg5HMRmu+Sf2ylqW5G/mRZSfeVT7/x/u/Ef6p//j9H7gXsmSeuWdZdffJ" +
       "/zOCJ/Nfs7r7rl/49v/69Tc0LzhXh/WEHE/A7q3g73mCeVlV1ni9x/BH/tlH" +
       "/uw/tH50tqezDaujybuZpRceqcz1Uh9q7t43s+nVq2t6VbBsL7k99pO3xd93" +
       "a4GrJN223N3WoGvzdcNt7Stu8y/Wb3YUm6vHfaIYJvjFP/+19Df/+u0tTxTj" +
       "iuNrhzcbDt16SmeRv5r+5wcfe/FnH9y9ZN594ObsrazRraS9Mtuc3XVNP5oU" +
       "7r7sDetvdL33fuYzryv+h59VyqeOfVYlnxiseXyFvo5feloLZ0J86Eqkj98P" +
       "Hrzzvn/hP11XP1Bc2w8OL9zdBsRty0dv7ceuzTc+FrmXiirqZjW9l7lmjrau" +
       "GvWYV1925dUja3gvVV92W0Ju0MMLM4J3oK/ir9549M3PP+Rt1+HHZ+GubzHZ" +
       "vMOPMit5fOBXXRLn5cdWQ59jtFnEXp6PfXyFD9wE7SYv96HMc24xy8P7noAJ" +
       "+RzvfN+/+9O/+Ke+4Vdm/u/u3tFdeTOz/SlcYnsNCP/4F3/oI+/5/K9+300L" +
       "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" +
       "MMGjPioEUIQQs31CGKvYrhl72IWpvsKk");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "7nmiTdY6SCKW7cHDjk+hsLUjaIDwsyiTiZmnCggcWqyLSX+wJPC8knEV22Gi" +
       "DJCHIwGhRT80UtUebTZSR1AA8dxlkglRwSRLFNPQD8vlVRz1R8L7e94kvC/D" +
       "X0J87+ulzs8vZXpwHX762tBPypdmZE/XJ97KSV8TrsufuqEfno/r7lGV35Oy" +
       "trtrsc9HvlTV9K3Q5wt/9PM/5kp/GX7waLvc3L2ryYtPJd6sbE+heueM6aPP" +
       "YNrfKsWflLn9+P6LP89+3PmBB3dve71C7U0F52/c9Jk31qW9u/KatsrUN1Sn" +
       "fc3r1WnXSuRbidqXz5T78KP+K56uTntC/o9em294feuNHO9+tOXLH/Xve2rr" +
       "W9QLxm+xll4bv7n70FMce/nGsZef3MV94wu+av7Nt3/wrx71/+S394Lrln/8" +
       "qP/5L/2CZ4okP/B0hbIyt7eTmrfe9LEn5W1ckniBlSyr4FZmywyOV1yLN29o" +
       "bk3e3L1kue4V922/8Kje7NpJzd3buzxyn0eOT80/7O7uHb/2qP/Z3x45rlv+" +
       "/qP+731pcjy417fHL/vKp8lB53nlRpnV3KTuU7dDv/stmP691+YPN3fvbby6" +
       "eVyu/7w3v2Tn+ZyxZs979rXKUpoV67/NvTj3X/jtPfu65S896n/0//rZH3q9" +
       "VFauosyJCuv2ocQP3g78gbd48g9fmz85P9nL3LyqvZuIP0/CX3r8thcefT7w" +
       "wn0d9y+/uY774SvF73AZ9+s1/p+GocUnEeJTKPSJTz8sW6uOyjZvvFfuy6Mf" +
       "XkXz4dXuRlmXx956dpVPKuhf+cTD72jCqH71zSr+yic+87lPFMWXZtft78Vn" +
       "qXFd/XNF8Rbk/rG3WPsL1+ZHmruv/lIXvq5/5zNsudbyXr/eeJYtP/W7ky33" +
       "JcRP8yVqrnx4+K3fpjx8luRvKkK+OdXhjUx46XlM+MJbMuHH32Ltr12bv9jc" +
       "vfPx7Z5H9NvhH3kT0V/4wu9Kot9XUz98pBKPLNeN+o+9de6/8q23Uuvr7HdY" +
       "qf25my25H91q72/D2x7hkw8fgc4u5FnY+zr2e+D82zYzYyP/4Sv5w+j1gx7e" +
       "rnvl+G3w0Hn4Bx6+cj+Xf+bhfZjw8I11/9q1NrmOsiDxmjx75ROvemU7i1Ey" +
       "U1DNX3Fe/RJx1Sdvt50V+RFS30pq701q/dzA7ePXZvVU2PUmu3vzJ88pPL8n" +
       "wG3n33wLKfvb1+av33/h8BQXrrN/4mlZe/y5zFc/lrHHE9fVj/y/e8m1+Vs3" +
       "qL/3Frf+mWvzd66l7vOtZ3lt3kz2232G5u4dt39dP//46jd9kHn/2aDzEz/2" +
       "/nd+1Y9p/+L2RdLrn/a9KNy902+T5OmPGp4av1hUnh/dbvPi/ScO9zT4+83d" +
       "e566zHXqZ4v7V/1vHHqU5hk6AAA=");
}
