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
    public static final long jlc$SourceLastModified$jif = 1501225000930L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAM08CZgUxdU1PbDLcrNcyz0uCCKwC4gQWFFwuVZX2OxyyAqO" +
       "vT29uw2z073dPcuCIRpDBI9gQjzwU/jFeP/EIwkxRjTRHGBIYkhIBPMbDebA" +
       "KDlMzGU0qfeqprv6mNkZVpOf76Nqtrpe1at3v1c9s/806WmZZMwGrbnC3myo" +
       "VsUlWnOdbFpqok5Pbl5Jh+LK3/d9L7F7rfGqRIoaSS/NWpWy5Ga1lpTIabtV" +
       "NzV7s00G1m6QO+TKtK0lK2s1y66qJX0UPWXZpqylbKudfJxEaslAjY7IKVuT" +
       "bTWxxNTbbHJWrUE3aknqdqXaaVcasim3VSIqlXXVSdmy6EpFOJpZpJdh6h1a" +
       "QjVtMq6WIs5nJ+UmNVlZx5/Vwl9VnSaJZZbn52OHw5XZ6W6bUnnrHVcO/GKU" +
       "DGgkA7RUgy3bmlKtp2yKTyPp26a2NammtTCRUBONZFBKVRMNqqnJSW0Lnain" +
       "GkmppbWkZDttqla9aunJDphYaqUNiiLsmRmsJX0ZSdKKrZuZ4xQ1a2oykfmr" +
       "Z3NSbrFsMswlCzveEhintOhNyamazbKiZkB6bNRSCaCFD8I544RL6QQKWtym" +
       "Un45W/VIyXSAlDLOJeVUS2WDbWqpFjq1p562gcAjsy5aBYyQlY1yixq3SZl/" +
       "Xh17RGeVICEAxCZD/dNwJcqlkT4uCfw5vfyCnVenlqUkxDmhKknAvxcFGusD" +
       "qlebVVNNKSoD7Htu7e3ysGd2SITQyUN9k9mcJz/2xwVTx37jMJszKmTOiqYN" +
       "qmLHlfua+h8dXT15bpSJoG5pwHzPyVH46/iTqk6DKtYwZ0V4WJF5+I3676y9" +
       "9hH1TYn0riFFip5Mt1E5GqTobYaWVM2lako1QUVqSImaSlTj8xpSTD/XaimV" +
       "ja5obrZUu4b0SOJQkY5/UxI10yWARMX0s5Zq1jOfDdluxc+dBiGkmP4ng+j/" +
       "voRENvD+Kpsoi+etW2Wp5hK6irVuka6k21SqwOtWpbR1dqtqadY6RbbUuGWn" +
       "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" +
       "M+1dOyIc7yoB+O8nOiztiGb5njV8Hz8y");
    public static final String jlc$ClassType$jif$1 =
      ("CJpSaAYjW4fw7+NHhrc76QI0I0XP99mAwENzFwp9NpMdhZ8zjN6CUoPcQVrj" +
       "Ez2HwO9FgYdmk89AoYUczsXz92EWkvlZB6A0DOC3IkA3rgphrbd4/6a4ZuGR" +
       "5QOhkaXPtEBr8siSEzSPyJLboWBkCSbBVcb1Qf1cH9RPXCv6ZVcZ1wf1c70v" +
       "shTxdQVgQw4BeNovAPDxHiGGujfPS0JO1yy0bPv/QMsjBdGSBUABYso5iPmj" +
       "PIgJ3TFG0OxOtwAiQ3OiPbdp8B0GB4/lzQH4+EpenoiR+bUz486vCuAOVfse" +
       "7EcUTFIW+FFj9kO8yqN7B/QavnfVS/h7fs4vj5Xwn3UTf3BM+FxEI/JmDQ9e" +
       "gm1/A7F7yyZ9BGsCQ6cZet4rM/YNu04WM5SJJA0Xmbe9P8wIX+hKs996jit/" +
       "mDlj0bOHJx7i32TP+pNOLsRjey9ZfvUfZ7OfcuxJbeCWLbBpr1pSzEJFxAF+" +
       "m/KsrKtl1ipaNvnd/o+XnO38GiE0pUJc7Dldmev8rwn9xoLnx6jjykay9aZv" +
       "bS/9BMW0kZRo1kozbdnws9AlSuaLcbBWC+43x2B68w+68CT/F/qFZcWXoiMb" +
       "7lxRW/yvy3N/twIRHvhvZHAk5fpbAAA=");
    
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
    public static final long jlc$SourceLastModified$jl = 1501225000930L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAOW8acw0W3oQ1t93Z+6sns14PB7P8jG+NneomVtdXV3VVb4Y" +
       "pZaupbu27qquri6Pua69a9+rq8qeQIiCrVgxkTN2QIntRHIiggwWkSCIRbEU" +
       "keBgERKBAbEYnEQEgRH8AIRYq/t9v+V+97vfeJSAEXmlOue853nOOc95zrOd" +
       "V895f/ZXZ++tq9mjIk+GIMmbN5qh8Oo3FKuqPZdKrLrWpo63nB8HwK/957/t" +
       "Y//9K7OPmrOPhpnaWE3oUHnWeH1jzj6ceqntVTXhup5rzj6eeZ6relVoJeE4" +
       "IeaZOftEHQaZ1bSVV++9Ok+6K+In6rbwqtuajzuF2YedPKubqnWavKqb2ceE" +
       "yOossG3CBBTCunlTmL3qh17i1uXs3589EGbv9RMrmBA/KTzeBXibEWSu/RP6" +
       "B8OJzMq3HO/xkPfEYeY2s88/P+LJjl/bTgjT0PelXnPOnyz1nsyaOmafuCMp" +
       "sbIAVJsqzIIJ9b15O63SzD79rpNOSO8vLCe2Au+tZvap5/GUO9CE9YEbW65D" +
       "mtm3PI92m6mvZp9+7syeOa1flX7Lj/5AxmUPbzS7npNc6X/vNOhzzw3ae75X" +
       "eZnj3Q388G8WfsL65J/84Yez2YT8Lc8h3+H8Dz/4D/69L33u5//0Hc63vwBH" +
       "tiPPad5yfsb+yP/+GeqL+CtXMt5f5HV4FYW37fx2qso95M2+mGTxk09mvALf" +
       "eAz8+f3/fPodv9/7Ow9nH+Rnrzp50qaTVH3cydMiTLyK9TKvshrP5Wcf8DKX" +
       "usH52fumthBm3l2v7Pu11/Cz9yS3rlfz2+8Ti/xpiiuL3jO1w8zPH7cLqznf" +
       "2n0xm83eN32zj0/fh2ezB9F9/f3NzFl/91cOtVcx0yz1V+jcaVMva+qvHLLw" +
       "K83Zq8P6K45Ve2/VTeuGE4ZtNc2EeQ6Lt7XfikL/K3XlvA2uTuUbE6D4N7NM" +
       "f93tN10ePJgO4jPPG4Vk0iAuT1yvesv5Wkuu/8EffOvPPHyiFvd8mhT2mYnf" +
       "uE48e/DgNuFvuGrN3alOZxJPuj6p84e/qH7f5vt/+AuvTOJUXN4zcfWK+trz" +
       "wv3UJPBTy5ok9i3noz/0//yjn/uJr+ZPxbyZvfYO7XvnyKv2fOH5zVW547mT" +
       "dXo6/W9+ZP3ht/7kV197eBWFD0xGqbEmsZk0/HPPr/E2LXrzsUW6MuShMPuQ" +
       "n1eplVxBj83IB5tzlV+e9ty4/qFb+yP/cvp5MH3/4vpdBe7aca0ns0PdC/uj" +
       "J9LezBrlV37Xj333v0bRmI598KqrcHw3tMS+tFh+eYEVd3JyPdPn+Hizud+j" +
       "Fj/5l/7s34YfXvf/2Dx/9Bk7rnrNm8+YhOtkH74p/8efiohWed6E99d+j/Kf" +
       "/fiv/tD33uRjwviOFy342rW8cseauJJX/9GfLv/yL//1n/nzD5/KVDN7tWjt" +
       "JHRulH9mmui7ni41WYtkslgTJfVrhyzN3dAPLTvxrvL5zz76ndAf/rs/+rE7" +
       "IUumnrsjq2Zf+voTPO3/NnL2O/7Mb/vHn7tN88C5equn7HiKdmcCv/npzERV" +
       "WcOVjv4/+D8++3v/F+snJ2M6GbA6HL2bTXpwrzJXoj7RzD4yHdMbV7/0hmDZ" +
       "XnLb7JduwN90K4GrJN2GzG6w+bX49v4G+5Zb/4frd3oJ5upunyqGCf7sf/lp" +
       "6rf+ndtenirGdY5P9++0G7r1jM4ufn/6Dx9+4dU/9XD2PnP2sZunt7JGt5L2" +
       "etjm5Ktr6r5TmH3T2+Bv97t3TubNJ4r/meeV8plln1fJp/Zqal+xr+33PauF" +
       "EyM+eGXSF+4s/sPlff2ZK/RjxbX8eP9gdmugtyGfv5VfuBbf+QyDP9PMXpnE" +
       "/PH5fPJZ20jleeWGU1Dk3WnTtVy8ff1PTd8np3V/+31dvmD97/k667+aeFnQ" +
       "nF9wrkoVppMCdvfe3/vhr/3H//KNH/3aw2dCpO94R5Ty7Ji7MOm20Advq/XT" +
       "Kr/xZavcRjB/6+e++sd/31d/6C6E+MTbHf46a9M/8Ev//Bff+D1/4xde4F1e" +
       "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" +
       "UrEBAxBIUs1pi+FlwMO57dw5nuU5haLj");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "Pk9ugsrdm/rS7ybu3mz2gT9xX/9X3xjd1yE/fV//3l+TuH/5sX38lif28dlY" +
       "4Lbm//iSrf1P1+KPTXrgTS4ieXdB+tz0DVP7H93X/+c3trHrkF+5r//qr0kP" +
       "fv426//6EtJ/8Vr8qZeS/v4r8vVx4HOu+Y/82+2auzx0bx44zMLm9S8++oFH" +
       "3/t96qOvTn73eVZ/vSjkCv1zRfESLv75l8B+6Vr82UnuH9PywvcEV2qf4/tH" +
       "Htuet/P9wX/9byff7159PLp7i/bo/iXJ7QAee/Lcf/17b09Cfg1hk/ClR/eo" +
       "Vmc9j3sXudwh59/HTGcb+o9ezx+FTxZ6dHWo1zO/1o+cR9/z6PVbT/7mo7v4" +
       "4dHbn5Mdru9z6smYJl6TZ69/8Y1JHSYxSib+afnrzhsvvrZ+6UbpF9/86v2c" +
       "/qRB3pvPi9g77sbX5nddi8P9k72vb5ieedByH7ZdAX/zJWL3f1+Lv3L3bu6Z" +
       "E3iHgj9+hPmpxwL2uOMK/ez/dzu5Fr9yw/q7L6H6712Lv9XMvu1K9SSszTu4" +
       "/pSc5zbwG/5fbUB/4QaeJe0fvgT2j6/F37+P5wOvedc7+a8H4f/i3WEPbmv9" +
       "k2b2uecJf8Fd+NeB9gfvewnsA9fi4fXp1nO0P3cP/fWg+2MvgX3iWnzoBTx/" +
       "wf2vn1zDVeqvb2c/9Y5/ZXH3DxecP/hTH33/t/7U4S/ennM/+acIrwqz9/tt" +
       "kjz7IvSZ9qtF5fnhbSOv3r0PvW3+wSeb2Yee0blr17cWd8r7rwBmMjBVU0MA" + "AA==");
}
