package battleships;

import jif.util.*;

/**
 * This class represents a player in the BattleShip game.
 *
 * A player has a secret Board that contains Ships. The player
 * initially generates a Board by placing Ships on the Board before the game 
 * starts.  That Board is then endorsed by the Opponent player (also an object
 * of this class), and stored.
 * 
 * During the game the Player generates a query to ask the Opponent
 * (the method getNextQuery), the Opponent endorses the query (the method 
 * endorseQuery), and the Opponent processes the query (the method 
 * processQuery()). Processing queries requires declassifying some 
 * information about the board. 
 *
 * This class also keeps track of which queries the opponent has
 * asked, to ensure the opponent doesn't repeat a query.
 *
 * This class is parameterized by the prinicipals P and O. P is the
 * principal that this Player class represents, and O is the opponent. The 
 * secret board is instantiated with the label parameter {P->*;P<-* meet O<-*}; 
 * i.e., the information is readable only by P, but trusted by both O and P.
 */
class Player {
    /**
     * This Board represents P's board. 
     * It's fine to make the reference to the board public, as all the 
     * information contained in the board is readable only by P
     */
    private Board board;
    /**
     * Record which queries the opponent has made, to stop them from
     * repeating queries.
     */
    private List opponentQueries;
    
    public Player battleships$Player$() {
        this.jif$init();
        {
            this.opponentQueries =
              new LinkedList(
                jif.lang.LabelUtil.
                    singleton().
                    toLabel(
                      jif.lang.LabelUtil.
                          singleton().bottomConf(),
                      jif.lang.LabelUtil.
                          singleton().
                          writerPolicy(this.jif$battleships_Player_P,
                                       jif.lang.PrincipalUtil.topPrincipal()).
                          meet(
                            jif.lang.LabelUtil.
                                singleton().
                                writerPolicy(
                                  this.jif$battleships_Player_O,
                                  jif.lang.PrincipalUtil.topPrincipal()),
                            true))).jif$util$LinkedList$();
        }
        return this;
    }
    
    /**
     * Create an initial board by placing ships to cover numCovered coords.
     */
    Board init(final int numCovered) {
        final Ship[]
          myCunningStrategy =
          { new Ship(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.singleton().
                        readerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(1, 1), 1, true),
        new Ship(
          jif.lang.LabelUtil.singleton().
              toLabel(
                jif.lang.LabelUtil.singleton(
                                     ).readerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal()),
                jif.lang.LabelUtil.singleton(
                                     ).writerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal(
                                                                  )))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(1, 3), 2, false),
        new Ship(
          jif.lang.LabelUtil.singleton().
              toLabel(
                jif.lang.LabelUtil.singleton(
                                     ).readerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal()),
                jif.lang.LabelUtil.singleton(
                                     ).writerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal(
                                                                  )))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(2, 2), 3, true),
        new Ship(
          jif.lang.LabelUtil.singleton().
              toLabel(
                jif.lang.LabelUtil.singleton(
                                     ).readerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal()),
                jif.lang.LabelUtil.singleton(
                                     ).writerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal(
                                                                  )))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(3, 4), 4, false),
        new Ship(
          jif.lang.LabelUtil.singleton().
              toLabel(
                jif.lang.LabelUtil.singleton(
                                     ).readerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal()),
                jif.lang.LabelUtil.singleton(
                                     ).writerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal(
                                                                  )))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(5, 6), 5, true),
        new Ship(
          jif.lang.LabelUtil.singleton().
              toLabel(
                jif.lang.LabelUtil.singleton(
                                     ).readerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal()),
                jif.lang.LabelUtil.singleton(
                                     ).writerPolicy(
                                         this.jif$battleships_Player_P,
                                         jif.lang.PrincipalUtil.topPrincipal(
                                                                  )))).
          battleships$Ship$(
            new Coordinate(
              jif.lang.LabelUtil.
                  singleton().
                  toLabel(
                    jif.lang.LabelUtil.
                        singleton().readerPolicy(
                                      this.jif$battleships_Player_P,
                                      jif.lang.PrincipalUtil.topPrincipal()),
                    jif.lang.LabelUtil.singleton().
                        writerPolicy(this.jif$battleships_Player_P,
                                     jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(5, 7), 6, false) };
        Board
          board =
          new Board(
            jif.lang.LabelUtil.
                singleton().
                toLabel(
                  jif.lang.LabelUtil.singleton().
                      readerPolicy(this.jif$battleships_Player_P,
                                   jif.lang.PrincipalUtil.topPrincipal()),
                  jif.lang.LabelUtil.singleton().
                      writerPolicy(this.jif$battleships_Player_P,
                                   jif.lang.PrincipalUtil.topPrincipal()))).
          battleships$Board$();
        int i = 0;
        for (int count = numCovered; count > 0 && board != null; ) {
            try {
                Ship newPiece = myCunningStrategy[i++];
                if (newPiece != null && newPiece.length > count) {
                    newPiece =
                      new Ship(
                        jif.lang.LabelUtil.
                            singleton().
                            toLabel(
                              jif.lang.LabelUtil.
                                  singleton().
                                  readerPolicy(
                                    this.jif$battleships_Player_P,
                                    jif.lang.PrincipalUtil.topPrincipal()),
                              jif.lang.LabelUtil.singleton().
                                  writerPolicy(
                                    this.jif$battleships_Player_P,
                                    jif.lang.PrincipalUtil.topPrincipal()))).
                        battleships$Ship$(newPiece.pos, count,
                                          newPiece.isHorizontal);
                }
                board.addShip(newPiece);
                count -= newPiece == null ? 0 : newPiece.length;
            }
            catch (final ArrayIndexOutOfBoundsException ignored) {  }
            catch (final IllegalArgumentException ignored) {  }
        }
        return board;
    }
    
    /**
     * Store the endorsed board.
     */
    void storeBoard(final Board board) { this.board = board; }
    
    /**
     * Endorse the opponents board.
     */
    Board endorseBoard(final Board b) {
        Board brd = b;
        if (brd == null) return null;
        return brd.endorseBoard(this.jif$battleships_Player_O,
                                this.jif$battleships_Player_P);
    }
    
    /**
     * Endorse a query from the opponent.
     */
    Coordinate endorseQuery(final Coordinate qu) {
        Coordinate query = qu;
        if (query == null) return null;
        int x = query.x;
        int y = query.y;
        return new Coordinate(
                 jif.lang.LabelUtil.
                     singleton().
                     toLabel(
                       jif.lang.LabelUtil.
                           singleton().bottomConf(),
                       jif.lang.LabelUtil.
                           singleton().
                           writerPolicy(this.jif$battleships_Player_P,
                                        jif.lang.PrincipalUtil.topPrincipal()).
                           meet(
                             jif.lang.LabelUtil.
                                 singleton().
                                 writerPolicy(
                                   this.jif$battleships_Player_O,
                                   jif.lang.PrincipalUtil.topPrincipal()),
                             true))).battleships$Coordinate$(x, y);
    }
    
    /**
     * Generate the next query to ask the opponent.
     */
    public Coordinate getNextQuery() {
        Coordinate c = this.nextQuery;
        if (c == null) {
            c =
              new Coordinate(
                jif.lang.LabelUtil.
                    singleton().
                    toLabel(
                      jif.lang.LabelUtil.
                          singleton().readerPolicy(
                                        this.jif$battleships_Player_P,
                                        jif.lang.PrincipalUtil.topPrincipal()),
                      jif.lang.LabelUtil.singleton().
                          writerPolicy(this.jif$battleships_Player_P,
                                       jif.lang.PrincipalUtil.topPrincipal()))).
                battleships$Coordinate$(0, 0);
        }
        boolean direction = (c.x + c.y) % 2 == 0;
        int newX = c.x + (direction ? 1 : -1);
        int newY = c.y + (direction ? -1 : 1);
        if (newX < 0) newX = 0;
        if (newY < 0) newY = 0;
        this.nextQuery =
          new Coordinate(
            jif.lang.LabelUtil.singleton().
                toLabel(
                  jif.lang.LabelUtil.singleton(
                                       ).readerPolicy(
                                           this.jif$battleships_Player_P,
                                           jif.lang.PrincipalUtil.topPrincipal(
                                                                    )),
                  jif.lang.LabelUtil.singleton(
                                       ).writerPolicy(
                                           this.jif$battleships_Player_P,
                                           jif.lang.PrincipalUtil.topPrincipal(
                                                                    )))).
            battleships$Coordinate$(newX, newY);
        Coordinate
          d =
          new Coordinate(
            jif.lang.LabelUtil.
                singleton().
                toLabel(
                  jif.lang.LabelUtil.singleton().bottomConf(),
                  jif.lang.LabelUtil.singleton().
                      writerPolicy(this.jif$battleships_Player_P,
                                   jif.lang.PrincipalUtil.topPrincipal()))).
          battleships$Coordinate$(c.x, c.y);
        return d;
    }
    
    private Coordinate nextQuery;
    
    /**
     * Process the query of the opponent. Note that the method requires
     authority
     * to declassify the result of processing the query.
     *
     * @throws IllegalArgumentException if the opponent has asked the query
     already
     */
    boolean processQuery(final Coordinate query)
          throws IllegalArgumentException {
        Board brd = this.board;
        List oppQueries = this.opponentQueries;
        if (brd == null || oppQueries == null || query == null) {
            throw new IllegalArgumentException("Bad state or args");
        }
        if (oppQueries.contains(query)) {
            throw new IllegalArgumentException(
                    "Opponent already asked the query " + query.toString());
        }
        try { oppQueries.add(query); }
        catch (final ClassCastException impossible) {  }
        boolean
          result =
          brd.
          testPosition(
            query,
            jif.lang.LabelUtil.
                singleton().
                toLabel(
                  jif.lang.LabelUtil.singleton().bottomConf(),
                  jif.lang.LabelUtil.
                      singleton().
                      writerPolicy(
                        this.jif$battleships_Player_P,
                        jif.lang.PrincipalUtil.
                            topPrincipal()).
                      meet(
                        jif.lang.LabelUtil.
                            singleton().writerPolicy(
                                          this.jif$battleships_Player_O,
                                          jif.lang.PrincipalUtil.topPrincipal(
                                                                   )), true)));
        return result;
    }
    
    public static final String jlc$CompilerVersion$jif = "3.5.0";
    public static final long jlc$SourceLastModified$jif = 1501224997576L;
    public static final String jlc$ClassType$jif =
      ("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" +
       "oJDaAn51I9zqItYKgu4qwvJZ3VWiIbsL");
    public static final String jlc$ClassType$jif$1 =
      ("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");
    
    public Player(final jif.lang.Principal jif$P,
                  final jif.lang.Principal jif$O) {
        super();
        this.jif$battleships_Player_P = jif$P;
        this.jif$battleships_Player_O = jif$O;
    }
    
    public void jif$invokeDefConstructor() { this.battleships$Player$(); }
    
    private void jif$init() { nextQuery = null; }
    
    public static boolean jif$Instanceof(final jif.lang.Principal jif$P,
                                         final jif.lang.Principal jif$O,
                                         final Object o) {
        if (o instanceof Player) {
            Player c = (Player) o;
            boolean ok = true;
            ok =
              ok &&
                jif.lang.PrincipalUtil.equivalentTo(c.jif$battleships_Player_P,
                                                    jif$P);
            ok =
              ok &&
                jif.lang.PrincipalUtil.equivalentTo(c.jif$battleships_Player_O,
                                                    jif$O);
            return ok;
        }
        return false;
    }
    
    public static Player jif$cast$battleships_Player(
      final jif.lang.Principal jif$P, final jif.lang.Principal jif$O,
      final Object o) {
        if (o == null) return null;
        if (jif$Instanceof(jif$P, jif$O, o)) return (Player) o;
        throw new ClassCastException();
    }
    
    private final jif.lang.Principal jif$battleships_Player_P;
    private final jif.lang.Principal jif$battleships_Player_O;
    public static final String jlc$CompilerVersion$jl = "2.7.1";
    public static final long jlc$SourceLastModified$jl = 1501224997576L;
    public static final String jlc$ClassType$jl =
      ("H4sIAAAAAAAAAM28aczsWHYYVt0z0z2bZpM11jIjvYzak27VqFkki1XF6Yxt" +
       "Fve9SBbJImekDveluC9FFpUxFAO25CVyIo8UG7GEwJDhJZKcGHCCwDDiILAt" +
       "QXaA2IYdI4gtBAqyOPrhH0l+xInDqu9t/fpNJ3IMx/zAe+9377mH557tngvc" +
       "U7/4m4uPtM3iUVVm1ygru7e7axW0bx+cpg18PHPa9jh3vOv9zBL41r/7o5/5" +
       "Cx9afNpefDoptM7pEg8viy4YO3vxyTzI3aBpMd8PfHvx2SIIfC1oEidLphmw" +
       "LOzF59okKpyub4JWDdoyu9wAP9f2VdDcv/mkU1h80iuLtmt6ryubtlt8Rkid" +
       "iwP0XZIBQtJ27wiL18IkyPy2XvyexSvC4iNh5kQz4OeFJ6sA7hgB6tY/g388" +
       "mclsQscLnkz58Dkp/G7xAy/OeLriN/gZYJ76eh50cfn0Ux8unLlj8bkHkjKn" +
       "iACta5IimkE/UvbzV7rF935bpDPQRyvHOztR8G63+O4X4Q4PQzPUx+5suU3p" +
       "Ft/1Itgd09gsvvcFmT0nrd+U/rWf+rGCKV690+wHXnaj/yPzpO9/YZIahEET" +
       "FF7wMPGTPyT8rPP5v/yTry4WM/B3vQD8APOf/Bv/+Hd/5fv/yq88wHzfS2Bk" +
       "Nw287l3vF9xP/VdfwN9CP3Qj46NV2SY3VXjPyu9SPTweeWesZl38/FOMt8G3" +
       "nwz+FfWvWT/+54J/9Ori4+ziNa/M+nzWqs96ZV4lWdDQQRE0Thf47OJjQeHj" +
       "93F28frcFpIieOiVw7ANOnbx4eze9Vp5/39mUTijuLHow3M7KcLySbtyuvje" +
       "HqvF4+eT8/uFxeLDzuNa7xYB+dVv6G3QUDOW9htE6fV5UHTtN/Qi+UYXB23S" +
       "fsNz2uDdtuv9ZIZwna6bIeOkek/73TQJv9E23nvGD5lzDZq356HqX9SHxtuK" +
       "v2N45ZVZGF940TFksxUxZeYHzbvet/o9+Y9/+d1fe/WpaTzm1Wwhz6F++wH1" +
       "4pVX7ih/2812HmQ7S+Y8W/xs1J98S/sR7l//yS99aFaqavjwzNsb6Bsvqvgz" +
       "x8DOLWfW23e9T//E//i//fmf/Wb5TNm7xRvvs8H3z7zZ0JdeXF5TeoE/+6hn" +
       "6H/okfMX3/3L33zj1ZtCfGx2TZ0zK89s59//4jfeY0vvPPFLN5a8Kiw+EZZN" +
       "7mS3oSfO5ONd3JTDs5473z9xb3/qn87PK/P7f93em9rdOm71zFr8sco/eqrz" +
       "3aI7/He//6e/+i9EPb4KrndfgdY/DO2qB025yfQFPt4979e06uf+6//yf4Jf" +
       "va3/iZP+9HPeXAu6d55zDDdkn7y7gM8+U5FjEwQz3H/7xw5/9Gd+8ye+fteP" +
       "GeIHX/bBN27ljTvOzJWy+X2/Uv/9f/gPfuHvvPpMp7rFa1XvZol3p/wLM6Iv" +
       "P/vU7DOy2W/NlLRv6EVe+kmYOG4W3PTzn3z6d4B/8X/5qc88KFk29zyIrFl8" +
       "5f8ZwbP+79kvfvzXfvR///47mle82571jB3PwB4c4Xc+w4w1jXO90TH+m3/r" +
       "i3/8rzs/N7vU2Y21yRTcPdOr9+W9etedz80qMovp7dvuNCt0UnhJ5dw3gB++" +
       "r/ord6h/9V4ubyp1n7u4j61uxfeN97Hvuvd/rH3/pkHddt9nFmIDv/gnvhf/" +
       "nf/ovqhnFnLD8b3j+12I4TxnvNCfy//XV7/02l99dfG6vfjMfeN3is5wsv4m" +
       "dXveulv8caew+I73jL93G37Yc9556gG+8KJ1PvfZF23zmeua2zfoW/v1583x" +
       "sd9f/O75/dJi8ZF/63Ft3UY/U93Kz46vLO6NzX3KD9zLL92K3/FE916vmuQy" +
       "2+v4FOmd8594jOz0uFaeQ9otPuKWTuM/kexnn/er+9vIgwneSugp2s/d0P6u" +
       "+X1rsXiNelx/z0to/V3fhtZb86sPNjKbbFlVZTF7EqWfQ7qgfULLd9y07LEf" +
       "f7CHF+m482w/v99aLL7rDzyutZfQQT3QcSvQ9zPnNkt9XPPvYc7Hijn8vJF1" +
       "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" +
       "516RSA5Xax/kJWC0fFgAps3FRou4QuOJ");
    public static final String jlc$ClassType$jl$1 =
      ("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" +
       "4vH1/2fX3Be326pf/HYZVfebqr/we7/18778p8BXH09/t1t8rCurH86CS5A9" +
       "h+oTM6YfeAGTeM8ie3bt/c+Kv/ir9Je9n3518aGnN9bfl4z23knvvPee+seb" +
       "oOub4vie2+rf8/Tu9O3a9OI753e5WLz29cf1e25eP+P//dr1D7732vXHH09R" +
       "H9fCc1M/IH/g93zA2I/fiuuscc+J7I0Hkb3xjJjhvXR8YX6hxeL13/ZQv/ZP" +
       "3reEW1G98NlXHmcQ3f7/+uPLyLfqR7vFh5L5EHNr/74PIPUP3orf291ywZL7" +
       "xfavvYy2G3u/sVh8xx9+XH/zt0LbHesd6o98ACH/zq34w93i4+0cRQT7p5kA" +
       "Lyzqw5cy8V9G4u+c32Cx+NSPPa6xfzYS//gHkPjv3Yqf7RafDAp/jnSCp0kJ" +
       "L+XZ1+a3XCw+/T8/rv+j3ypB/B3q3/8Agv7krfi5ZwTd0wPuU18g6G4jPzS/" +
       "02Lx2b/5uP7l35qN3Kb80uP6T/+/s5E/+wFj/8Gt+IWZ9ijopCepDS+j/T7l" +
       "zfn9E4vF53/pcf0H/tmY+R9+gPV8rlt86VnmAZtlQeRkWBPdM8vI0QuqW77S" +
       "Hc1fuBW/NNNe3ZLo2vZZWsYL2vq6W5ZZ4BQvLOn125K+fPvy4uG5193iv3l/" +
       "vtujN///SHd766uP6t5pk7ovu+DNhzyyRzfLe3TbiJLiUp4DIgifSzV8861H" +
       "P9bFSfv2S1zem2+98823qurb69j9ee1FftxG/1L1okyf16H/7APG/vNb8Z8+" +
       "3jpfRvFt/I++IJiP3qZ/9v2C+Vv/kgrmIcnqeckk3U0Sj74eXJzszacpQz/m" +
       "5O43H33tUdFn2Vvv/Ij26GXyQN8rj9dfJo+/+oHy+NUPGPu1W/FfdIuPPqHz" +
       "Zfy/f/yL7+P/q+S/nPx/yJV69Ng+Htv6XRBPQpkyfPPr90SqW+9dCnf38tB6" +
       "mrH4IJ7bvMNXHv1WwOWn4LPjehH+IU/wAbj8EWpWiyR89Gb5KHlK26OHJd4U" +
       "5qH1yJuV5M3HveU7T5dUnuf+2W6Cd+6tufjylx+9P/NSv2UyBXU/a2U2i+FY" +
       "vum9/e0i46/cl/vWPzeE8h2h/NY7D9HijPKdbz5uhk7WBu9zQS8Nu798K5Tn" +
       "YuZnyvyhZ3ly94j7h1+S+/bA8vv0v/0BtvD3bsXf7Bafeq+q3Hr/4+ct4kkm" +
       "9Hc/sYQnHbfRL/5zXs6t+Dt30H/wAaT/+q34+93i+26kz6bVvUQWd6rGbvHa" +
       "w7+3BN/vft+vbjz8NoT3yz//6Y/+9p/X/9495/zp7ze8Jiw+Gs6+6vls1efa" +
       "r1VNECZ3el57yF19YMVvdItPPEfOreu/rx7W9X8D27jcU/5DAAA=");
}
