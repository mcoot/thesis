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
    public static final long jlc$SourceLastModified$jif = 1492411758036L;
    public static final String jlc$ClassType$jif =
      ("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");
    
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
    public static final long jlc$SourceLastModified$jl = 1492411758036L;
    public static final String jlc$ClassType$jl =
      ("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" +
       "deDYoYvPjgS2Xc2I/rhTYJnuNmtqUdTk");
    public static final String jlc$ClassType$jl$1 =
      ("ON2tO25uu0bvPCC79hiTNgiPlDQITBMFvXG2gRfGPnQBGQi47bxA3N69hF0J" +
       "nIoru3PXI3dG7yQYHpGIlhzSYWOGbJWWPMkm/XaVAJL6PdUjNDHTQsmnKCfQ" +
       "I3sDEK1v7VbofMv1tyR0N5uEONEpRDYN1zJqMhvwAPBRRXeuPByPx585f8nX" +
       "Lr+iP3/+kH8/7SMM3FMH//CH8sE5TLJ9dJjgdjV4Ki+CxqycB8IEL/b4XroW" +
       "NH3jKvz9hgifI3BvN9Pn32amU/X1//1JkKtJ2kdjHFxGPq8ifINTRObFt0sv" +
       "OUdjvv5Db33NFv4ufPtyOF0N3lVl+adip3HiG8HCj93AxJ9Taq4ifn+P/8Zv" +
       "Mi9bP3Z78Nj9YN1DmTkPDnrtwRDdM4VT1UWqPBCo+677sa93n/b0nf3z/GBw" +
       "608u3390PVB3xYSPnYpPPBg2e+ZyyH+9fP/na0NvhE5vXeYqXIaBLgK2QXaO" +
       "ulZyVThmcp4svzHuRrj2w9fCR45VF0F1pFvLyc+R5EuYj1+LK8ax45nxuPDO" +
       "Ef77oOepzpGvqBo8nsfm8ZGRoSYLLjKcgvv7/v7BZXFKcfnWvfdDJDsV3/0O" +
       "0eMfeIe+HzoVb1aDD1wT3ZeuRPelK55cLeup0+iXTxS+zMa5dZED8e8ezoG4" +
       "88r/nxSIVz99Z1+bZbCvs8p55SK34M6JwndOahqkTRY5U8e9loDyyqt3vlD5" +
       "QXn3bQjxyquvvflqnr+9kJ5/T96kyqn3i/lNQbvOgR9+h76/cSr+WjX44Nut" +
       "+tTf3WDP04MLDbnJnn/055Y9Fzb7On+C6sSPO5/9nHznJtVvWs5bZ1vcPsiH" +
       "px7Fhx99Rz589R36fuJUfKUaPH1vdY+i+3nyFx+i+23zzyvdL7IU7lxqxy7L" +
       "YsdMzwy4Z+Ez95XPnlMYTq1fMJPdm2dTd1G7n8Ny/nseJ8KfvPN/BI/ch+/N" +
       "6M0BF7kjF9DZ52a9QATunVeyO8H91d25UtCTuFz9u2Pd+cydV671Zq/d32AW" +
       "9X29/jivnWt98fLLdx7OzFFPKQ3Ovu5lM+4ZoGSvWHff0ZH45AUFXv2zRYtc" +
       "oEVefe3ieO0Rv/bmZdU149J5yCw90lm5yJ645mRcCfpjVzkWZxflU49In7hg" +
       "xXn4z7yDnvydU/FT1eC9DwrRo867py7ZcV2J7qXTffCe8txrOPW++Ge8y1Px" +
       "s2fQX3iHHX3zVPxc7wqddmSZZfU2jLrw7arBM1dNp1yxDz6U0n2ReGz94tee" +
       "ffoDX1P/5TmB8X5y8JPLwdNuHcfXE5+u1Z/MC8cNzut68iIN6oIkf78avPva" +
       "sk5N/yC/2N//BKofnVZbLgAA");
}
