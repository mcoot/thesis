package battleships;

import java.io.PrintStream;

/**
 * The class BattleShip is responsible for coordinating gameplay
 * between two Players, P1 and P2.
 */
class BattleShip {
    /**
     * The number of covered coordinates that each player is to 
     * have on their board. Players can have any number of ships,
     * so long as the ships cover this number of squares.
     */
    public static final int NUM_COVERED_COORDS = 10;
    
    public void play(final PrintStream output) throws SecurityException,
        IllegalArgumentException {
        if (output == null) throw new IllegalArgumentException("Null output");
        output.println("Playing battleships, with each player having " +
                         BattleShip.NUM_COVERED_COORDS +
                         " covered coordinates");
        Player player1 =
          new Player(this.jif$battleships_BattleShip_P1,
                     this.jif$battleships_BattleShip_P2).battleships$Player$();
        Player player2 =
          new Player(this.jif$battleships_BattleShip_P2,
                     this.jif$battleships_BattleShip_P1).battleships$Player$();
        output.print("  Initializing....");
        Board proposed1 = player1.init(BattleShip.NUM_COVERED_COORDS);
        Board accepted1 = player2.endorseBoard(proposed1);
        player1.storeBoard(accepted1);
        Board proposed2 = player2.init(BattleShip.NUM_COVERED_COORDS);
        Board accepted2 = player1.endorseBoard(proposed2);
        player2.storeBoard(accepted2);
        output.println(" Done.");
        int player1Hits = 0;
        int player2Hits = 0;
        output.println("  Playing rounds...");
        while (player1Hits < BattleShip.NUM_COVERED_COORDS && player2Hits <
                 BattleShip.NUM_COVERED_COORDS) {
            Coordinate play1Query = player1.getNextQuery();
            Coordinate play1QueryEnd = player2.endorseQuery(play1Query);
            output.
              print(
                "\t" +
                  jif.lang.PrincipalUtil.toString(
                                           this.jif$battleships_BattleShip_P1) +
                  ": " +
                  (play1QueryEnd == null ? "null" : play1QueryEnd.toString()) +
                  "?  ");
            boolean result = player2.processQuery(play1QueryEnd);
            player1Hits += result ? 1 : 0;
            output.print(result ? "Y" : "N");
            if (player1Hits < BattleShip.NUM_COVERED_COORDS) {
                Coordinate play2Query = player2.getNextQuery();
                Coordinate play2QueryEnd = player1.endorseQuery(play2Query);
                output.
                  print(
                    "   " +
                      jif.lang.PrincipalUtil.
                        toString(this.jif$battleships_BattleShip_P2) +
                      ": " +
                      (play2QueryEnd == null
                         ? "null"
                         : play2QueryEnd.toString()) +
                      "?  ");
                boolean result2 = player1.processQuery(play2QueryEnd);
                player2Hits += result2 ? 1 : 0;
                output.print(result2 ? "Y" : "N");
                output.println("   Score: " + player1Hits + " vs. " +
                                 player2Hits);
            }
        }
        output.println("\n");
        output.
          println(
            (player1Hits >=
               BattleShip.NUM_COVERED_COORDS
               ? jif.lang.PrincipalUtil.toString(
                                          this.jif$battleships_BattleShip_P1)
               : jif.lang.PrincipalUtil.toString(
                                          this.jif$battleships_BattleShip_P2)) +
              " won!");
    }
    
    public BattleShip battleships$BattleShip$() {
        this.jif$init();
        {  }
        return this;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1501224968149L;
    public static final String jlc$ClassType$jif =
      ("H4sIAAAAAAAAAL1aC3RV1Zne9+b9kITwSiAJlxCQKOSaqIAE5ZGHhF5IVhKo" +
       "pujl5Nxzk0POPed4zr7hBsosaCs4pWJLwepSKHbAEUrF6arTzqi02iqgVseO" +
       "raiL6qIzLX2go0vbcc2gs/+993neE4Q+Jmtl73P32f+///0/vv3vvc/R8yjP" +
       "NFDNBjnZiEd1yWxcKSe7BcOUEt2aMtpHmuLiRw+9mLjvVv2tMMrvR4WyuUY1" +
       "haQUQ0VCGg9phoxHMSqPbRBGhGgay0o0Jpu4JYZKRE01sSHIKjbvQH+HQjFU" +
       "LpMWQcWygKVEh6GlMJoR08lAg4qGo1IGR3XBEFJRKkq0u1URTJNwyqetFpNC" +
       "3dBG5IRkYDQ9RgTnvRVhQFKi3fxdDH61ZAwUsdjz+bHJUc5sdnuvju75xu3l" +
       "381BZf2oTFZ7sYBlsVVTMZGnH5WmpNSAZJjLEgkp0Y/Gq5KU6JUMWVDkTaSj" +
       "pvajClMeVAWcNiSzRzI1ZQQ6VphpnYgIY1qNMVTKVJIWsWZY08lPypKSsH7l" +
       "JRVh0MRosqMWNr0OaCe6KCbqlIykIEoWSe6wrCZAFz4Ke471nyEdCGlBSiL2" +
       "sofKVQXSgCqY5RRBHYz2YkNWB0nXPC2NQcFTx2TaAoYQxGFhUIpjVOnv181e" +
       "kV5FVBFAgtEkfzfKiVhpqs9KLvucX71412Z1hRqmMickUQH5CwlRrY+oR0pK" +
       "hqSKEiMsvSp2rzD5qbvCCJHOk3ydWZ/vf/69pXNrf3SS9ZkW0KdrYIMk4rh4" +
       "cGDcK9WtDTfkMBfUTBmM75k5df5u/qYlo5PAmmxzhJeN1ssf9Tx369Yj0u/D" +
       "qLgT5Yuakk4RPxovaildViTjZkmVDAiRTlQkqYlW+r4TFZDnmKxKrLUrmTQl" +
       "3IlyFdqUr9HfREVJwgJUVECeZTWpWc+6gIfoc0ZH/K+c/BeR/2O8/iZGcvui" +
       "dWtMyeggXMx1bZqYTkkkgNetUeV1eEgyZXOdKJhS3MTphEx6DAgYk55Dsu55" +
       "jpPAXGcaouf9cvrcS54byWv9/3OwDMy8fGMoRIxS7YcEhUTTCk0hsBEX96SX" +
       "t7/3aPyFsB0iXGckJl3sGx32KBSibCdCHDE7EysNk3gnOFja0HvbyvV31eUQ" +
       "B9M35hIdQ9c6D962OqDQSfFRJJ7570v09buun7Y4jPL6CW6abVJSSCu4u3W5" +
       "llYJvky0m3okAj0qBbxA0C3QRUqD0ZQsuGQwScgMhwmQTSPRUO+PySAxy3ac" +
       "++Oxe7doTnRiVJ8FGtmUEPR1fjsYmiglCIw67K+KCI/Hn9pSH0a5BEnI3DCZ" +
       "GQBTrX8MT/C3WEAKc8kj00tqRkpQ4JWllWI8ZGgbnRbqIOOgqGC+Ahb1CUgx" +
       "+MZefd/pl357bRiFHbgucy1/vRJucUEEMCujYDDecZA+Q5JIvzP3dX997/kd" +
       "n6PeQXrMDBqwHspWAg1kESQavPPkHa+/9cuDr4Ydj8JkhUwPKLKYoXMZ/wn5" +
       "C5H/j+Ef4hwaoCZo38oxJmKDDEa4++z23Yv+hrFIImxUMiAOFzVdt3Bu83Xz" +
       "mhfCfGc7GiEgpxCgJQoz69eoKS0hJ2VhQJEgiP63bFbT43/YVc6cTCEtzGQG" +
       "mvvpDJz2quVo6wu3/6mWsgmJsMg6VnO6MeSe4HBeZhjCKMiR2fazmvtPCPvI" +
       "GkBw15Q3SQxKqRUQdZsmaoG5tLzG9+5aKCIEK/wvyXDTHESgkUnyFJklMXFx" +
       "8vt1Ub2j7W3qccUkCJIkN5NFknVVZwV0q/0WohpyhUGrc01W507nNcTjFL8M" +
       "fPzc2yKJ9yN1n6NBWJKQTNGQdcu1ycpSbMopXSHqlhIUO0hOg7WVRH12gmYI" +
       "qqkQX2N400dftmd0A9KDEcGgdqJaqctAmNhidEPeFxcX7NxhaDO/PD/MFTmO" +
       "uTlR3VLEC1i93rJqeDtBh3JihqSmCYaTEV2MKBbAtUC00YEs2RyNO/LFxX2T" +
       "vvFkxbd3L2MJwnQvRVbvxde0bo9f908/DfN4nuJfElYI5hCJ+9PKa/17z1xV" +
       "y7i6cIG//9e2O/fe+4PvX8dWjVJYqZcsZUs2OEut31A9kkAWL2bJuPj+/jek" +
       "nus/eochlLZR9afKOsnyRFkXIF3mT5BlG5QLaKedSFWZ5ZGc/fy7Dxw7/8vu" +
       "pTSMXLaHXCgrHefOZYPrYvq4wrsG2vI09mm6LVJcvH3yv11d/eStf+9Wvo/A" +
       "1XvX4QcL3p370QE6bdsDZ/o80Ca4qBdCuYjJS2HKY3a3kG7rT5l05tWTIyve" +
       "YeL6vSuIYknzxOPnKqs2U3/R6didfFSoVulBxv4s2XE5xo40xp75YUHP8y5j" +
       "UwsSFWykHZk9oexwDNBLGM8K0udyDWMt5dLqjTPf2NBy4ZXvWbG30tZKg3eC" +
       "Pkr3NPOveqJq15tbuyweq9lU+1xTXcuaroeiIUNjt5+23ETLZf4ggMY21hnK" +
       "2xyGDR6GAU09DtmAo/IGW+XZTayutNO3ak/61gH7NydlETfd+OvdH99BUpac" +
       "fjRuSDA7VZIHwHaR7EoBku1fGI13BQzFOkhcFHcS5t/j+Abrjx59cGrrTb+n" +
       "sejkR0A9PZOd6a4VXKlb85HUh+G6/GfDqIBkmDRvJFvztYKShtSkn+w0zVbe" +
       "GENXeN57d41si9Ri53/V/tzMNaw/M3MybPIMveG52IfylWDzReS/jOj/HK+f" +
       "c6M8TcAZjoJIjXRlk4yKswcO/mnbjoVhWLDzRkB0opVyp9/qNGzutx/dW1Oy" +
       "5+2dNAwJ+2JgqtLhZ9CyHoorqf1z4HEOybhMek6AyXRkVVAytrB0SZ/ChXyW" +
       "1991CUuUt3rNqnhr19r2nvY2Unf1tPWanuWXLixSgu1RDz1y9NGW0sOHaIQX" +
       "Ue8gvoL5UlsIFNZvprgrvIqbwWV4OUhxLOpsgmlBBKfcBLT6/CWF5hYqzVYn" +
       "Drdkh6a3qccWpBp4RbgAL/H6ebcgUN7JgtVLVcN7vxBE5Qlym2560Gg/DaLL" +
       "jkiCeCkS0iP81EG6a8+XP2nctSfsOpqZmXU64qZhxzPMchx2DDTjYqNQio7f" +
       "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");
    
    public BattleShip(final jif.lang.Principal jif$P1,
                      final jif.lang.Principal jif$P2) {
        super();
        this.jif$battleships_BattleShip_P1 = jif$P1;
        this.jif$battleships_BattleShip_P2 = jif$P2;
    }
    
    public void jif$invokeDefConstructor() { this.battleships$BattleShip$(); }
    
    private void jif$init() {  }
    
    public static boolean jif$Instanceof(final jif.lang.Principal jif$P1,
                                         final jif.lang.Principal jif$P2,
                                         final Object o) {
        if (o instanceof BattleShip) {
            BattleShip c = (BattleShip) o;
            boolean ok = true;
            ok =
              ok &&
                jif.lang.PrincipalUtil.equivalentTo(
                                         c.jif$battleships_BattleShip_P1,
                                         jif$P1);
            ok =
              ok &&
                jif.lang.PrincipalUtil.equivalentTo(
                                         c.jif$battleships_BattleShip_P2,
                                         jif$P2);
            return ok;
        }
        return false;
    }
    
    public static BattleShip jif$cast$battleships_BattleShip(
      final jif.lang.Principal jif$P1, final jif.lang.Principal jif$P2,
      final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$P1, jif$P2, o)) return (BattleShip) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Principal jif$battleships_BattleShip_P1;
    private final jif.lang.Principal jif$battleships_BattleShip_P2;
    public static final String jlc$CompilerVersion$jl = "2.7.1";
    public static final long jlc$SourceLastModified$jl = 1501224968149L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAM16aczr2HWY5s3qseNZGi/x+mJPpjPR+JEURUr01EEkUiLF" +
       "RRI3SaTHfuW+74tIulMkQWsbSeEG6TgL0DgB6gJp4MRA2rQ/igD5kzRBggIt" +
       "uv5oHQQFmiJxgQBN86NtUkrf9973ve+9mbZA2kaALq/uPffcc892D3XON749" +
       "eLLIB7fTJGydMCnvlG1qFXe2Wl5YJh5qRSH1A3eNrw6Bt37i88//0uOD59TB" +
       "c14sllrpGXgSl1ZTqoP3RFakW3kxM03LVAcvxJZlilbuaaHX9YBJrA5eLDwn" +
       "1soqtwrBKpKwPgG+WFSplZ/3vDfIDt5jJHFR5pVRJnlRDp5nfa3WgKr0QoD1" +
       "ivJ1dvCU7VmhWWSDvzp4jB08aYea0wO+n713CuCMEViexnvwZ72ezNzWDOve" +
       "kicCLzbLwcdvrrh/4peYHqBf+nRklW5yf6snYq0fGLx4QVKoxQ4glrkXOz3o" +
       "k0nV71IOPvS2SHugZ1LNCDTHulsOPngTbnsx1UO968yW05Jy8L6bYGdMTT74" +
       "0A2ZXZPWt9d/6StfiKn41plm0zLCE/1P9os+dmORYNlWbsWGdbHwPd/L/rj2" +
       "/l/58q3BoAd+3w3gC5h/9Ff+8Ptf+9iv/sYFzIcfAbPRfcso7xpf19/7zz6C" +
       "v4o9fiLjmTQpvJMqPHDys1S3lzOvN2mvi++/j/E0eefe5K8Kv678wM9bv39r" +
       "8Oxq8JSRhFXUa9ULRhKlXmjlpBVbuVZa5mrwLis28fP8avB032e92LoY3dh2" +
       "YZWrwRPheeip5Py7Z5Hdozix6Im+78V2cq+faqV77jfp4PLzfP99V//95uXz" +
       "Z8qBt/j0G3Jh5cseS/EGkRhVZMVl8YYce2+UrlV4xRuGVlh3i7IyvR5C18qy" +
       "h3S99IH+Xd+z3yhy44H5+bkv9v07/XT6/3Kz5nTy7zg+9lgvlI/cdBBhb01U" +
       "EppWftd4q5ov/vAX7/7Wrfsmcsmz3iavob9zhX7w2GNntN95sqMLOfdSCnrr" +
       "7w38Pa+Kn6P/8pc/8XivYOnxiZ7HJ9CXbqr7lZNY9T2t1+G7xnNf+r3/+s0f" +
       "fzO5Uvxy8NJD9vjwypM9feLmEfPEsMzeX12h/97b2i/f/ZU3X7p1Uo539W6q" +
       "1HpF6m3+Yzf3eMCuXr/no05sucUO3m0neaSFp6l7juXZ0s2T49XImffvPvff" +
       "+6f957H++yen70kFTwOnZ++I8Ev1v31f/8tBuf3dL/7Yp/8vqkkv/NbKTyry" +
       "aWg8fW00/tRoml5oy0mmN/h49sKfEdOf/jf/9D/Bt07nv+ewn7vm2UWrfP2a" +
       "kzghe8/ZHbxwpSJSblk93L/7ye3f+uq3v/TZs370EJ981IYvndoTd7SeK0n+" +
       "138j+7ff+vdf/xe3rnSqHDyVVnroGWfKP9Ijevlqq95/hL0P6ykpXpLjKDE9" +
       "29P00Drp539/7nugX/6Drzx/oWRhP3Ihsnzw2v8awdX4d80HP/Bbn//jj53R" +
       "PGac7q8rdlyBXTjFv3CFeZbnWnuio/nBf/7Rn/on2k/37rV3aYXXWWcvdet8" +
       "vFtn3XmxV5FeTHdON1Wv0F5seKl2vgw+dT71a2eov3huhyeVOq8dnOfAU/Ph" +
       "5jz3vvP4U8XDF8jydBNfWYgKfONvfwj/vt8/H+rKQk44PtQ87EZ22jXjHf18" +
       "9Ee3PvHUr90aPK0Onj8HAVpc7rSwOkld7a/xAr8cZAff8cD8g1fyxf3z+n0P" +
       "8JGb1nlt25u2eeW++v4J+tR/+ro59oz44IlJn+6/z/V69HuXz18/zT6fntoX" +
       "mrN3u1DdM+9XfQTiWPmLv/uzX//jH/zS9NZJZE/WJ9J7rjx/BbeuTnHUF7/x" +
       "1Y+++63f+ZGztvbonz0hRc/bf/zcfuLUfM9ZKI+fui/3ylycQ7KyP44Xa2Fz" +
       "n9izRD9wSeSvXT5/6RqxPfPWMncX3+wWwoLonxuBEB8h6l5/ot4468tYwfry" +
       "Wz/8p3e+8tatawHVJx+Kaa6vuQiqzrw8n+gjTb/Ld7/TLucVy//4zTf/8c+9" +
       "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" +
       "k2Vhg/luhA31Dp2ERSEt9wvpoBC0ng1n");
    public static final String jlc$ClassType$jl$1 =
      ("lCR0GmXbiO0he71rd5007SY+5UW6Sk3cmXIYUUjl2JU47F88qZyUkLTDDAGg" +
       "uDWG2LxxWCi6GSNBA+5GY28MaO5qXVdcuYrdaMh7oJnPZtkUHu2jvHMJGCeX" +
       "09SeTuauqWPdUtG4LXbQSVwaoQ0xSQhfFmB0cwDmmJvHAdTLdXb+U3x3+Q/6" +
       "C+c/8e8Xe/iefZrgHv6TfHBOkSiPThHcKgdPp7lXa6X1QIrgoz2+l64nUa8S" +
       "33e30Dn79nY7ff5tdjp13/jf32R0tUnzaIyDy6znVXZvcMrGfPTtikrOmZiv" +
       "/9BbXzM3fxe6dbl8UQ7eVSbpp0KrtsIbicKP38DEnQtprrJ9f4/7xm+SLxs/" +
       "dmvw+P1E3UP1OA8uev3B9NyzuVVWeSw9kKT7rvt5r3efzvSd/feFweCxP7l8" +
       "/tH1JN2VED5+aj75YMrs2csl/+Xy+Z+vLb2RNn3sskrhMgV0kaz1knPGtRTL" +
       "3NKi82bpjXU3UrUfvpY6sowq98p20RhWes4iX8J84lpOMQwtRwtnuXPO7d8H" +
       "PW91znoF5eCJNNTaR2aF6sS7qGvy7p/7+weXzamw5Vv3ng+x7NR89ztkjn/g" +
       "HeZ+6NS8WQ4+cE11X7pS3ZeuZHJF1tOn1S+fOHxZg/PYRfXDtx6ufrj9yv+P" +
       "4odXP307q7TCy6qktF65qCq4feLv7ZORenGdBBZh2dcKT1559fYXStcr7rwN" +
       "G1559fU3X03Tt1fR8+epmzw5zX4xvalm1/n/w+8w9zdOzV8rBx98O6pP890N" +
       "4TwzuLCPm8L5h39OhXPhr69LxytP0rj92c+Jt2/y/KbXfOzsh5sHpfD0o6Tw" +
       "o+8oha++w9xPnJqvlINn7lH3KK6fN//oQ1y/dffPJ9cvahNuX1qGniShpcVn" +
       "9t/z7Yn9ymfPhQun0S9okf7m2cld9O5Xrpx/ntdtoddu/x/Bj+7D9w705oKL" +
       "ipEL6ORzy14dPPv2K8lt7z51t6+M86QsV79uG7c/c/uVa7PJ6/cPmAT9XG87" +
       "1uvnXt+8/PLth+tx5FMhg5VVvWaGvVCk5BXjzjuGEK9dcODVP1u0owu0o1df" +
       "v7hYe8Svv3nZtbWwsB5ySY8MUy5qJq6FF1dq/vhVZcU5OPnUI4omLkRxXv4z" +
       "72Alf+fU/FQ5eO+DSvSom+7pS3FcN6F7JXQfvGc69wZOsx/9Mz7lqfnZM+gv" +
       "vMOJvnlqfq4Pgk4n6m2xfBtBXUR15eDZq6FThdgHHyrhvig0Nn7xa88984Gv" +
       "yf/6XLR4vxj4KXbwjF2F4fVyp2v9p9Lcsr0zXU9dFD9dsOTvl4N3XyPrNPQP" +
       "0ovz/U/ReLpvSy4AAA==");
}
